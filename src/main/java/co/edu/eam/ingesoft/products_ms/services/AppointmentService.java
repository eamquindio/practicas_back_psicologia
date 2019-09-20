package co.edu.eam.ingesoft.products_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.products_ms.repositories.AppointmentRepository;

/**
 * Service to perform bussines operations over Appointment entity.
 *
 * @author dani0
 *
 */
@Service
public class AppointmentService {

  /**
   * Appointment repository.
   */
  @Autowired
  private AppointmentRepository appointmentRespository;
}
