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

  /**
   * @return the idAppointment
   */
  public Integer getIdAppointment() {
    return idAppointment;
  }

  /**
   * @param idAppointment the idAppointment to set
   */
  public void setIdAppointment(Integer idAppointment) {
    this.idAppointment = idAppointment;
  }

  /**
   * @return the dateTime
   */
  public Date getDateTime() {
    return dateTime;
  }

  /**
   * @param dateTime the dateTime to set
   */
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  /**
   * @return the idPsychologist
   */
  public String getIdPsychologist() {
    return idPsychologist;
  }

  /**
   * @param idPsychologist the idPsychologist to set
   */
  public void setIdPsychologist(String idPsychologist) {
    this.idPsychologist = idPsychologist;
  }

  /**
   * @return the idStudent
   */
  public String getIdStudent() {
    return idStudent;
  }

  /**
   * @param idStudent the idStudent to set
   */
  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

}
