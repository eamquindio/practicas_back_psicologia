package co.edu.eam.ingesoft.products_ms.services;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Cita;
import co.edu.eam.ingesoft.products_ms.repositories.AppointmentRepository;

/**
 * Service to perform bussines operations over Appointment entity.
 *
 * @author caferrerb
 *
 */
@Service
public class AppointmentService {

  /**
   * Date repository.
   */
  @Autowired
  private AppointmentRepository appointmentRespository;

  /**
   * Create a appointmentToCreate.
   *
   * @param appointmentToCreate date to create.
   * @return date created
   */
  public Cita create(Cita appointmentToCreate) {
    Cita cita = find(appointmentToCreate.getIdCita());

    if (cita != null) {
      throw new EntityExistsException("Appointment already exists");
    }

    return appointmentRespository.save(appointmentToCreate);
  }

  /**
   * Find a date.
   *
   * @param id id to find the date
   * @return the date found
   */
  public Cita find(Integer id) {
    return appointmentRespository.findById(id).orElse(null);
  }

}
