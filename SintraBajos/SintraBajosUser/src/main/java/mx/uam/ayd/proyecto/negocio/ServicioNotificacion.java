package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.NotificacionRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;

@Service
public class ServicioNotificacion {
  @Autowired
  private NotificacionRepository notificacionRepository;

  public Notificacion addNotificacion(String message, String correo) {
    Notificacion notificacion = notificacionRepository.findByCorreo(correo);

    notificacion = new Notificacion();
    notificacion.setCorreo(correo);
    notificacion.setMessage(message);

    notificacionRepository.save(notificacion);

    return notificacion;
  }

  public void deleteNotificacion(String correo) {
    try {
      notificacionRepository.deleteAllByCorreo(correo);
    } catch (Exception e) {
      System.out.println("Error en el service: " + e);
    }
  }

  public List<Notificacion> recuperaNotificacion(String correo) {
    List<Notificacion> noti = new ArrayList<>();
    for (Notificacion notifi : notificacionRepository.findAll()) {
      if (notifi.getCorreo().equals(correo)) {
        noti.add(notifi);
      }
    }
    return noti;
  }
}
