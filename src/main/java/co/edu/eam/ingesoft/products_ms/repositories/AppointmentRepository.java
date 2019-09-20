package co.edu.eam.ingesoft.products_ms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.products_ms.model.Appointment;

/**
 * Appointment Repository.
 * @author dani0
 *
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

  /**
   * Find all appointments.
   * @return list or appointments.
   */
  List<Appointment> findAll();

  /**
   * Find all appointments given a status.
   * @param status status to look for.
   * @return list or appointments.
   */
  List<Appointment> findByName(String status);
}
