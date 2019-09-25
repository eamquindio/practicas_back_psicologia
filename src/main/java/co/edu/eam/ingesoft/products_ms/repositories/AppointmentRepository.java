package co.edu.eam.ingesoft.products_ms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.products_ms.model.Cita;

/**
 * Appointment Respository.
 * @author manuel
 *
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Cita, Integer> {

  /**
   * Find all citas.
   * @return list or citas.
   */
  List<Cita> findAll();

  /**
   * Find all citas given a psicologoCedula and estado.
   * @param psicologoCedula psicologoCedula to look for.
   * @param estado estado to look for.
   * @return list or cita.
   */
  List<Cita> findByPsicologoCedulaOrEstadoOrderByFechaHora(String psicologoCedula, String estado);
}
