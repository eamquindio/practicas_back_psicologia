package co.edu.eam.ingesoft.productms.test.controllers;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.edu.eam.ingesoft.products_ms.Application;
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
  

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Before
  public void beforeEach() {
    appointmentRepository.deleteAll();
  }
}
