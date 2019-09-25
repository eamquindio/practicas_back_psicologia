package co.edu.eam.ingesoft.products_ms.routes;

/**
 * Class to define the service's routes.
 *
 * @author caferrerb
 *
 */
public class Router {

  /**
   * Base path of this api.
   */
  public static final String BASE_PATH = "/api/psicologia-ms";

  /**
   * person uri.
   */
  public static final String PERSON_PATH = BASE_PATH + "/persons";

  /**
   * date uri.
   */
  public static final String APPOINTMENT_PATH = BASE_PATH + "/appointment";

  /**
   * person uri.
   */
  public static final String PRODUCTS_PATH = BASE_PATH + "/products";

  /**
   * create person uri.
   */
  public static final String CREATE_PERSON = "/";

  /**
   * create date uri.
   */
  public static final String CREATE_APPOINTMENT = "/";

  /**
   * find person uri.
   */
  public static final String FIND_PERSON = "/";

  /**
   * find person uri.
   */
  public static final String DELETE_PERSON = "/";

  /**
   * Edit person uri.
   */
  public static final String EDIT_PERSON = "/";

  /**
   * Edit products uri.
   */
  public static final String EDIT_PRODUCTS = "/";

  /**
   * find by name persons uri.
   */
  public static final String FIND_BY_NAME = "/find_by_name";

  /**
   * find by psicologoCedula and estado cita uri.
   */
  public static final String FIND_BY_PSICOLOGOCEDULA_ESTADO = "/find_by_psicologo_estado";

  /**
   * find all person uri.
   */
  public static final String FIND_ALL = "/all";

  /**
   * find all products uri.
   */
  public static final String FIND_ALL_PRODUCTS = "/all";

}
