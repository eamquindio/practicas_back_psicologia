package co.edu.eam.ingesoft.products_ms.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.products_ms.model.Cita;
import co.edu.eam.ingesoft.products_ms.routes.Router;
import co.edu.eam.ingesoft.products_ms.services.AppointmentService;

/**
 * REst controller for Appointment entity.
 *
 * @author manuel
 *
 */
@RestController
@RequestMapping(Router.APPOINTMENT_PATH)
public class AppointmentController {
  /**
   * date service.
   */
  @Autowired
  private AppointmentService appointmentService;

  /**
   * create a date operation.
   *
   * @param cita date to create
   * @return date created
   */
  @PostMapping(value = Router.CREATE_APPOINTMENT)
  public Cita create(@RequestBody Cita cita) {
    return appointmentService.create(cita);
  }
}
