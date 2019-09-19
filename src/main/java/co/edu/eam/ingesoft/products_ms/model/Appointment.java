package co.edu.eam.ingesoft.products_ms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

  /**
   * Entity Primary key.
   */
  @Id
  private Integer id_appointment;

  /**
   * Appointment`s date_time.
   */
  @NotNull
  @Column(name = "date_time")
  private Date date_time;

  /**
   * Appointment`s id_psychologist.
   */
  @NotNull
  @Column(name = "id_psychologist")
  private String id_psychologist;

  /**
   * Appointment`s id_student.
   */
  @NotNull
  @Column(name = "id_student")
  private String id_student;

  /**
   * Appointment`s status.
   */
  @NotNull
  @Column(name = "status")
  private String status;

  public Appointment() {
    super();
  }

  public Appointment(Integer id_appointment, @NotNull Date date_time, @NotNull String id_psychologist,
      @NotNull String id_student, @NotNull String status) {
    super();
    this.id_appointment = id_appointment;
    this.date_time = date_time;
    this.id_psychologist = id_psychologist;
    this.id_student = id_student;
    this.status = status;
  }

  public Integer getId_appointment() {
    return id_appointment;
  }

  public void setId_appointment(Integer id_appointment) {
    this.id_appointment = id_appointment;
  }

  public Date getDate_time() {
    return date_time;
  }

  public void setDate_time(Date date_time) {
    this.date_time = date_time;
  }

  public String getId_psychologist() {
    return id_psychologist;
  }

  public void setId_psychologist(String id_psychologist) {
    this.id_psychologist = id_psychologist;
  }

  public String getId_student() {
    return id_student;
  }

  public void setId_student(String id_student) {
    this.id_student = id_student;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
