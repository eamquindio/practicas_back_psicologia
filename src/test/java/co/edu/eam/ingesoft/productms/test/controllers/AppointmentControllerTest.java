package co.edu.eam.ingesoft.productms.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import co.edu.eam.ingesoft.products_ms.repositories.AppointmentRepository;
import co.edu.eam.ingesoft.products_ms.routes.Router;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { Application.class })
public class AppointmentControllerTest {

  String pattern = "yyyy-MM-dd HH:mm:ss.S";
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

  String date = "2015-06-05 00:00:00.0";

  @Autowired
  private MockMvc mockMvc;

  public static final String SAVE = Router.APPOINTMENT_PATH + Router.CREATE_APPOINTMENT;

  @Autowired
  private AppointmentRepository appointmentRespository;

  @Before
  public void beforeEach() {
    appointmentRespository.deleteAll();;
  }

  @Test
  public void save() throws Exception {
    String content = "{\"descripcion\":\"camilo\",\"titulo\":\"prueba\",\"estado\":\"activo\",\"estudianteId\":\"1\",\"psicologoCedula\":\"1\",\"fechaHora\":\"2015-06-05T05:00\",\"idCita\":1 }";
    mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    
    Cita dateToAssert = appointmentRespository.findById(new Integer(1)).get();
    assertEquals(date, dateToAssert.getFechaHora());
    assertEquals("1", dateToAssert.getPsicologoCedula());
    assertEquals("1", dateToAssert.getEstudianteId());
    assertEquals("activo", dateToAssert.getEstado());
    assertEquals("entrevista practica", dateToAssert.getTitulo());
    assertEquals("temas basicos de la persona", dateToAssert.getDescripcion());
  }

  @Test
  public void saveAlreadyExists() throws Exception {
    appointmentRespository.saveAll(Lists.list(new Cita(1,new Date(06/05/2018),"1","1","activo","prueba","camilo"), new Cita(2,new Date(06/07/2016),"2","2","cerrado","entrevista profundizada","temas del trabajo a realizar")));
    String content = "{\"descripcion\":\"camilo\",\"titulo\":\"prueba\",\"estado\":\"activo\",\"estudianteId\":\"1\",\"psicologoCedula\":\"1\",\"fechaHora\":\"2015-04-05T05:00\",\"idCita\":1 }";

    mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(409));
  }
}
