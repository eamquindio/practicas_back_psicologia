package co.edu.eam.ingesoft.products_ms.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   * find a appointmen.
   *
   * @param id       id for appointment to find
   * @param response httpresponse
   * @return person with id
   */
  @GetMapping(value = Router.FIND_APPOINTMENT + "/{id}")
  public Cita find(@PathVariable Integer id, HttpServletResponse response) {
    Cita cita = appointmentService.find(id);

    if (cita == null) {
      response.setStatus(HttpStatus.NOT_FOUND.value());
    }

    return cita;
  }

  /**
   * find a cita by psicologoCedula and estado.
   *
   * @param psicologoCedula psicologoCedula cita to find
   * @param estado          estado cita to find
   * @return list of person with a psicologoCedula and estado
   */
  @GetMapping(value = Router.FIND_BY_PSICOLOGOCEDULA_ESTADO)
  public ResponseEntity<List<Cita>> findByPsicologoCedulaAndEstadoOrderByFechaHora(@RequestParam String psicologoCedula,
      @RequestParam String estado) {
    List<Cita> cita = appointmentService.findByPsicologoCedulaOrEstadoOrderByFechaHora(psicologoCedula, estado);

    if (cita.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(cita, HttpStatus.OK);
  }

  /**
   * Edit a appointmen.
   *
   * @param appointmen person to edit
   * @return appointmen edited
   */
  @PutMapping(value = Router.EDIT_APPOINTMENT)
  public Cita edit(@RequestBody Cita appointmen) {
    return appointmentService.update(appointmen);
  }

}
