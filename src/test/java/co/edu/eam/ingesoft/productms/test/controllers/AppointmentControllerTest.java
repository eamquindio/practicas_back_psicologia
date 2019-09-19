package co.edu.eam.ingesoft.productms.test.controllers;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.edu.eam.ingesoft.products_ms.Application;
import co.edu.eam.ingesoft.products_ms.repositories.PersonRepository;
import co.edu.eam.ingesoft.products_ms.routes.Router;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { Application.class })
public class AppointmentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  public static final String FIND_ALL = Router.PERSON_PATH + Router.FIND_ALL;
  public static final String FIND_BY_NAME = Router.PERSON_PATH + Router.FIND_BY_NAME;
  public static final String FIND_BY_ID = Router.PERSON_PATH + Router.FIND_PERSON;
  public static final String SAVE = Router.PERSON_PATH + Router.CREATE_PERSON;
  public static final String EDIT = Router.PERSON_PATH + Router.EDIT_PERSON;
  public static final String DELETE = Router.PERSON_PATH + Router.DELETE_PERSON;

  @Autowired
  private PersonRepository personRepository;
}
