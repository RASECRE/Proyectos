package mx.uam.ayd.proyecto.presentacion.Notificacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Component
public class ControlNotificacion {

  @Autowired
  private ServicioNotificacion servicioNotificacion;

  @Autowired
  private VentanaNotificacion ventana;

  public void inicia(Usuario usuario) {
    ventana.muestra(this, usuario);
  }

  public Notificacion addNotificacion(String m, String correo) {
    try {
      Notificacion n = new Notificacion();
      n = servicioNotificacion.addNotificacion(m, correo);
      return n;
    } catch (Exception ex) {
      ventana.muestraDialogoConMensaje("se agrego notificacion " + ex.getMessage());
    }
    return null;
  }

  public void deleteNotificacion(String correo) {
    if(correo == null || correo.isEmpty()) {
      ventana.muestraDialogoConMensaje("El correo es nulo");
      return;
    }
    try {
      servicioNotificacion.deleteNotificacion(correo);
      ventana.muestraDialogoConMensaje("Notificaciones borradas");
    } catch (Exception ex) {
      ventana.muestraDialogoConMensaje("No fue posible borrar las notificaciones" + ex.getMessage());
    }
  }

  public List<Notificacion> recuperaNotificacion(String correo) {
    List<Notificacion> noti = new ArrayList<>();
    noti = servicioNotificacion.recuperaNotificacion(correo);
    return noti;
  }
}