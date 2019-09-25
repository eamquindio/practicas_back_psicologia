package co.edu.eam.ingesoft.products_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /**
   * find a cita by psicologoCedula and estado.
   *
   * @param psicologoCedula psicologoCedula cita to find
   * @param estado estado cita to find
   * @return list of person with a psicologoCedula and estado
   */
  @GetMapping(value = Router.FIND_BY_PSICOLOGOCEDULA_ESTADO)
  public ResponseEntity<List<Cita>> findByPsicologoCedulaAndEstadoOrderByFechaHora(
      @RequestParam String psicologoCedula,
      @RequestParam String estado) {
    List<Cita> cita = appointmentService.findByPsicologoCedulaOrEstadoOrderByFechaHora(psicologoCedula, estado);

    if (cita.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(cita, HttpStatus.OK);
  }
}
