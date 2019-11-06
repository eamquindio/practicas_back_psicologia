package co.edu.eam.ingesoft.products_ms.services;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.model.Cita;
import co.edu.eam.ingesoft.products_ms.repositories.AppointmentRepository;

/**
 * Service to perform bussines operations over Appointment entity.
 *
 * @author manuel
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

  /**
   * List cita by psicologoCedula and estado.
   *
   * @param psicologoCedula psicologoCedula to looking for
   * @param estado          estado to looking for
   * @return list of cita with a psicologo_cedula and estado.
   */
  public List<Cita> findByPsicologoCedulaOrEstadoOrderByFechaHora(String psicologoCedula, String estado) {
    return appointmentRespository.findByPsicologoCedulaOrEstadoOrderByFechaHora(psicologoCedula, estado);
  }

  /**
   * Update a appointmenToUpdate.
   *
   * @param appointmen appointmenToUpdate to update.
   * @return appointmen edited
   */
  public Cita update(Cita appointmen) {
    Cita appointmenToUpdate = find(appointmen.getIdCita());

    if (appointmenToUpdate == null) {
      throw new EntityNotFoundException("appointmenToUpdate not exists");
    }

    return appointmentRespository.save(appointmen);
  }
  
  
  public Cita updateCita(int id, Cita cita) {
    Cita cit = null;
    try {
      cit = appointmentRespository.findById(id).get();
      if (cit != null) {
        cit.setFechaHora(cita.getFechaHora());
      
      }
      return cit;

    } catch (EntityNotFoundException e) {
      throw new EntityNotFoundException("La cita no se ha encontrado");
    } 
  }
  
}
