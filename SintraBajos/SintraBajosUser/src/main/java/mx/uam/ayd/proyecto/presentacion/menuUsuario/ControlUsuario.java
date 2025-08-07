package mx.uam.ayd.proyecto.presentacion.menuUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.agendarCita.ControlAgendarCita;
import mx.uam.ayd.proyecto.presentacion.consultarDiagnostico.ControlDiagnosticoUsuario;
import mx.uam.ayd.proyecto.presentacion.precios.ControlPrecios;
import mx.uam.ayd.proyecto.presentacion.reagendarCita.ControlReagendarCita;
import mx.uam.ayd.proyecto.presentacion.Notificacion.ControlNotificacion;
import mx.uam.ayd.proyecto.presentacion.actualizarDatos.ControlActualizarDatos;

@Component
public class ControlUsuario {
   @Autowired
   private VentanaUsuario ventana;

  @Autowired
   private ControlAgendarCita controlAgendarCita;

   @Autowired
   private ControlNotificacion controlNotificacion;

   @Autowired
   private ControlReagendarCita controlReagendarCita;
   
   @Autowired
   private ControlPrecios controlPrecios;
	
   @Autowired
   private ControlActualizarDatos controlActualizarDatos;
   
   @Autowired
   private ControlDiagnosticoUsuario controlDiagnosticoDatos;

   
   

   public void inicia(Usuario usuario) {
      ventana.muestra(this, usuario);
   }
   
   public void precios() {
	   controlPrecios.inicia();
   }

   /**
    * Método que arranca la historia de usuario "agendar citas"
    * 
    */
   public void agendarCitas(Usuario usuario) {
      controlAgendarCita.inicia(usuario);
   }

   /**
    * Método que arranca la historia de usuario "agendar citas"
    * 
    */
  public void verNitificaciones(Usuario usuario) {
      controlNotificacion.inicia(usuario);
   }

   /**
    * Método que arranca la historia de usuario "agendar citas"
    * 
    */
   public void reagendarCita(Usuario usuario) {
      controlReagendarCita.inicia(usuario);
   }

public void actualizaDatos(Usuario usuario) {
	   controlActualizarDatos.inicia(usuario);
   }

public void consultaDiagnostico(Usuario usuario) {
	controlDiagnosticoDatos.inicia(usuario);
}

}
