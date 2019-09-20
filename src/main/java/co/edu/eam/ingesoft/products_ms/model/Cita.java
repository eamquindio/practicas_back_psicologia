package co.edu.eam.ingesoft.products_ms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity Cita.
 *
 * @author caferrerb
 *
 */
@Entity
@Table(name = "Cita")
public class Cita {

  /**
   * Entity Primary key.
   */
  @Id
  private Integer idCita;

  /**
   * Date`s fecha_hora.
   */
  @NotNull
  @Column(name = "fechaHora")
  private Date fechaHora;

  /**
   * Date`s psicologo_cedula.
   */
  @NotNull
  @Column(name = "psicologoCedula")
  private String psicologoCedula;

  /**
   * Date`s estudiante_id.
   */
  @NotNull
  @Column(name = "estudianteId")
  private Integer estudianteId;

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
}
