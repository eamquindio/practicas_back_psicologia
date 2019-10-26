package co.edu.eam.ingesoft.products_ms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity Cita.
 *
 * @author manuel
 *
 */
@Entity
@Table(name = "Cita")
public class Cita implements Serializable {

  /**
   * Entity Primary key.
   */
  @Id
  @Column(name = "id_cita")
  private Integer idCita;

  /**
   * Date`s fecha_hora.
   */
  @NotNull
  @Column(name = "fecha_hora")
  private Date fechaHora;

  /**
   * Date`s psicologo_cedula.
   */
  @NotNull
  @Column(name = "psicologo_cedula")
  private String psicologoCedula;

  /**
   * Date`s estudiante_id.
   */
  @NotNull
  @Column(name = "estudiante_id")
  private String estudianteId;

  /**
   * Date`s estado.
   */
  @Column(name = "estado")
  private String estado;

  /**
   * Date`s titulo.
   */
  @Column(name = "titulo")
  private String titulo;

  /**
   * Date`s descripcion.
   */
  @Column(name = "descripcion")
  private String descripcion;

  public Cita() {
    super();
  }

  public Cita(Integer idCita, @NotNull Date fechaHora, @NotNull String psicologoCedula,
      @NotNull String estudianteId,
      String estado, String titulo, String descripcion) {
    super();
    this.idCita = idCita;
    this.fechaHora = fechaHora;
    this.psicologoCedula = psicologoCedula;
    this.estudianteId = estudianteId;
    this.estado = estado;
    this.titulo = titulo;
    this.descripcion = descripcion;
  }

  /**
   * @return the idCita
   */
  public Integer getIdCita() {
    return idCita;
  }

  /**
   * @param idCita the idCita to set
   */
  public void setIdCita(Integer idCita) {
    this.idCita = idCita;
  }

  /**
   * @return the fechaHora
   */
  public Date getFechaHora() {
    return fechaHora;
  }

  /**
   * @param fechaHora the fechaHora to set
   */
  public void setFechaHora(Date fechaHora) {
    this.fechaHora = fechaHora;
  }

  /**
   * @return the psicologoCedula
   */
  public String getPsicologoCedula() {
    return psicologoCedula;
  }

  /**
   * @param psicologoCedula the psicologoCedula to set
   */
  public void setPsicologoCedula(String psicologoCedula) {
    this.psicologoCedula = psicologoCedula;
  }

  /**
   * @return the estudianteId
   */
  public String getEstudianteId() {
    return estudianteId;
  }

  /**
   * @param estudianteId the estudianteId to set
   */
  public void setEstudianteId(String estudianteId) {
    this.estudianteId = estudianteId;
  }

  /**
   * @return the estado
   */
  public String getEstado() {
    return estado;
  }

  /**
   * @param estado the estado to set
   */
  public void setEstado(String estado) {
    this.estado = estado;
  }

  /**
   * @return the titulo
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * @param titulo the titulo to set
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion the descripcion to set
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
