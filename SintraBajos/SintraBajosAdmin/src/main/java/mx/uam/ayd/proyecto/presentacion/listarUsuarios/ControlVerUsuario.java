package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase para el control de la ventana que muestra
 * los detalles del usuario
 * @author Axel Huerta Hernández
 * @version 1.0
 * @Date 10/06/2023
 */

@Component
public class ControlVerUsuario {

  @Autowired
  private VentanaVerUsaurio ventana;

  /**
   * inicia la ventana
   * @param usuario
   * @return
   */
  public void inicia(Usuario usuario) {
    ventana.muestra(this, usuario);
  }

  /**
   * terminal la HU
   * @param
   * @return
   *
   */
  public void termina() {
    ventana.setVisible(false);
  }
}