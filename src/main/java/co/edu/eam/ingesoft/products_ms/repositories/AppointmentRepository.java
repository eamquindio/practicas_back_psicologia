package co.edu.eam.ingesoft.products_ms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.products_ms.model.Cita;

@Repository
public interface AppointmentRepository extends CrudRepository<Cita, Integer>{

}
