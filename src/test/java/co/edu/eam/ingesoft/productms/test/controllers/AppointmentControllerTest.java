package co.edu.eam.ingesoft.productms.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.edu.eam.ingesoft.products_ms.Application;
import co.edu.eam.ingesoft.products_ms.model.Cita;
import co.edu.eam.ingesoft.products_ms.model.Person;
import co.edu.eam.ingesoft.products_ms.repositories.AppointmentRepository;
import co.edu.eam.ingesoft.products_ms.routes.Router;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { Application.class })
public class AppointmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	public static final String SAVE = Router.APPOINTMENT_PATH + Router.CREATE_APPOINTMENT;
	public static final String FIND_BY_PSICOLOGOCEDULA_ESTADO = Router.APPOINTMENT_PATH
			+ Router.FIND_BY_PSICOLOGOCEDULA_ESTADO;
	public static final String EDIT = Router.APPOINTMENT_PATH + Router.EDIT_APPOINTMEN;
	@Autowired
	private AppointmentRepository appointmentRespository;

	@Before
	public void beforeEach() {
		appointmentRespository.deleteAll();
	}

	@Test
	public void save() throws Exception {
		String content = "{\"descripcion\":\"temas basicos\",\"titulo\":\"Entrevista trabajo\",\"estado\":\"activo\",\"estudianteId\":\"1\",\"psicologoCedula\":\"1\",\"fechaHora\":\"2015-06-05T05:00\",\"idCita\":1 }";
		mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		String f = "2015-06-05 00:00:00";
		Date date = formatter.parse(f);

		Cita dateToAssert = appointmentRespository.findById(new Integer(1)).get();
		assertEquals(date, dateToAssert.getFechaHora());
		assertEquals("1", dateToAssert.getPsicologoCedula());
		assertEquals("1", dateToAssert.getEstudianteId());
		assertEquals("activo", dateToAssert.getEstado());
		assertEquals("Entrevista trabajo", dateToAssert.getTitulo());
		assertEquals("temas basicos", dateToAssert.getDescripcion());
	}

	@Test
	public void saveAlreadyExists() throws Exception {
		appointmentRespository
				.saveAll(Lists.list(new Cita(1, new Date(06 / 05 / 2018), "1", "1", "activo", "prueba", "camilo"),
						new Cita(2, new Date(06 / 07 / 2016), "2", "2", "cerrado", "entrevista profundizada",
								"temas del trabajo a realizar")));
		String content = "{\"descripcion\":\"camilo\",\"titulo\":\"prueba\",\"estado\":\"activo\",\"estudianteId\":\"1\",\"psicologoCedula\":\"1\",\"fechaHora\":\"2015-04-05T05:00\",\"idCita\":1 }";

		mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(409));
	}

	@Test
	public void listByPsicologo_cedulaOrEstadoEmptyTest() throws Exception {
		mockMvc.perform(get(FIND_BY_PSICOLOGOCEDULA_ESTADO + "?psicologoCedula=4" + "&estado=asignada"))
				.andExpect(status().isNoContent());
	}

	@Test
	public void listByPsicologo_cedulaOrEstado() throws Exception {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		String f = "2015-06-05 00:00:00";
		Date date = formatter.parse(f);

		appointmentRespository.saveAll(Lists.list(new Cita(1, date, "1", "1", "asignada", "nueva cita", "hay una cita"),
				new Cita(2, date, "2", "2", "pendiente", "nueva cita 2", "hay una cita")));

		mockMvc.perform(get(FIND_BY_PSICOLOGOCEDULA_ESTADO + "?psicologoCedula=1" + "&estado=asignada"))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].psicologoCedula", is("1")))
				.andExpect(jsonPath("$[0].estado", is("asignada")));
	}

	@Test
	public void edit() throws Exception {
		appointmentRespository
				.saveAll(Lists.list(new Cita(1, new Date(06 / 05 / 2018), "1", "1", "activo", "prueba", "claudia")));

		String content = "{\"descripcion\":\"camilo\",\"titulo\":\"prueba\",\"estado\":\"activo\",\"estudianteId\":\"1\",\"psicologoCedula\":\"1\",\"fechaHora\":\"2015-04-05T05:00\",\"idCita\":1 }";
		mockMvc.perform(put(EDIT).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		Cita appointmenToAssert = appointmentRespository.findById(new Integer(1)).get();
		assertEquals("camilo", appointmenToAssert.getDescripcion());
		assertEquals(new Integer(1), appointmenToAssert.getIdCita());

	}

	@Test
	public void editNotExists() throws Exception {
		String content = "{\"descripcion\":\"camilo\",\"titulo\":\"prueba\",\"estado\":\"activo\",\"estudianteId\":\"1\",\"psicologoCedula\":\"1\",\"fechaHora\":\"2015-04-05T05:00\",\"idCita\":1 }";

		mockMvc.perform(put(EDIT).content(content).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

}
