package co.edu.eam.ingesoft.products_ms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity appointment.
 *
 * @author dani0
 *
 */
@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

  /**
   * Entity Primary key.
   */
  @Id
  private Integer idAppointment;

  /**
   * Appointment`s dateTime.
   */
  @NotNull
  @Column(name = "dateTime")
  private Date dateTime;

  /**
   * Appointment`s idPsychologist.
   */
  @NotNull
  @Column(name = "idPsychologist")
  private String idPsychologist;

  /**
   * Appointment`s idStudent.
   */
  @NotNull
  @Column(name = "idStudent")
  private String idStudent;

  /**
   * Appointment`s status.
   */
  @NotNull
  @Column(name = "status")
  private String status;

  public Appointment() {
    super();
  }

  public Appointment(Integer idAppointment, @NotNull Date dateTime, @NotNull String idPsychologist,
      @NotNull String idStudent, @NotNull String status) {
    super();
    this.idAppointment = idAppointment;
    this.dateTime = dateTime;
    this.idPsychologist = idPsychologist;
    this.idStudent = idStudent;
    this.status = status;
  }

  public Integer getIdAppointment() {
    return idAppointment;
  }

  public void setIdAppointment(Integer idAppointment) {
    this.idAppointment = idAppointment;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public String getIdPsychologist() {
    return idPsychologist;
  }

  public void setIdPsychologist(String idPsychologist) {
    this.idPsychologist = idPsychologist;
  }

  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
