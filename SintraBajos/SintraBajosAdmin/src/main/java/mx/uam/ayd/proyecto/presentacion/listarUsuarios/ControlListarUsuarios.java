package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ControlListarUsuarios {

  @Autowired
  private ServicioUsuario servicioUsuario;

  @Autowired
  private ventanaDiagnosticoAdmin ventana;

  @Autowired
  private ventanaListaUsuarios ventana2;

  @Autowired
  private ventanaEditar ventanaE;

  @Autowired
  private ControlVerUsuario controlVerUsuario;

  public void inicia() {
    ventana2.muestra(this);
  }

  public void iniciaE(Usuario usuario) {
    ventanaE.muestraE(this, usuario);
  }

  /**
   *
   *  inicia la ventana para consultar los datos de usuario 
   *  @param usuario
   * 
   */
  public void iniciaVentanaVerUsuario(Usuario usuario) {
    controlVerUsuario.inicia(usuario);
  }

  public void iniciaUsuarios() {
    List<Usuario> pacientes = servicioUsuario.recuperaUsuarios();
    for (Usuario paciente : pacientes) {
      log.info("paciente: " + paciente);
    }
  }

  ////////////////////////////////////////////////////////
  // el metodo esta dos veces descrito de forma diferente
  // una aquí y la otra en el control principla
  ////////////////////////////////////////////////////////
  public List<Usuario> obtenUsuarios() {
    List<Usuario> pacientes = servicioUsuario.recuperaUsuarios();
    return pacientes;
  }

  //Metodo usado para obtener al paciente seleccionado
  public void pacienteActual(Usuario usuario) {
    ventana.muestra(this, usuario); // Muestra la ventana y muestra al paciente obtenido
  }

  // Se obtiene el nuevo usuario
  public void recuperaNuevo(Usuario usuario) {
    servicioUsuario.nuevo(usuario);
    ventana.muestraMensaje();
   
  }

  ///////////////////////////////////////
  // Esta en el control principal
  ///////////////////////////////////////
  // Metodo para obtener al paciente
  public void recuperaUsuario(Usuario paciente) {
    //ventana2.termina();
    pacienteActual(paciente);
  }

  /*
   *  Termina la historia de usuario
   */
  public void termina() {
    ventana2.setVisible(false);
  }
}
