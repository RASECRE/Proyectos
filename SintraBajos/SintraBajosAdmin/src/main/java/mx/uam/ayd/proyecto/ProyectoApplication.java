package mx.uam.ayd.proyecto;

import javax.annotation.PostConstruct;
import mx.uam.ayd.proyecto.negocio.ServicioCita;
import mx.uam.ayd.proyecto.presentacion.principalAdministrador.ControlPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * Clase principal que arranca la aplicación
 * construida usando el principio de
 * inversión de control
 *
 *
 * @author Sintra Bajos
 * Este cambio es en la rama de trabajo
 */
@SpringBootApplication
public class ProyectoApplication {

  @Autowired
  ControlPrincipal controlPrincipal;

  //////////////////////////////////////////
  // cambios inecesarios
  //////////////////////////////////////////
  @Autowired
  ServicioCita servicioCita;

  /**
   *
   * Método principal
   *
   * @params args argumentos de la línea de comando
   *
   */
  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(
      ProyectoApplication.class
    );

    builder.headless(false);

    builder.run(args);
  }

  /**
   * Metodo que arranca la aplicacion
   * inicializa la bd y arranca el controlador
   * otro comentario
   */
  @PostConstruct
  public void inicia() {
    controlPrincipal.inicia();
    //////////////////////////////////////////
    // cambios inecesarios
    //////////////////////////////////////////
   

  }
}
