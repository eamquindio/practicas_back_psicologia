package co.edu.eam.ingesoft.products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.routes.Router;
import co.edu.eam.ingesoft.products_ms.services.AppointmentService;

@RestController
@RequestMapping(Router.APPOINTMENT_PATH)
public class AppointmentController {

  /**
   * person service.
   */
  @Autowired
  private AppointmentService appointmentService;
}