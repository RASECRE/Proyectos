package mx.uam.ayd.proyecto.presentacion.agendarCita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCita;
import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import mx.uam.ayd.proyecto.negocio.modelo.Precios;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.precios.ControlPrecios;

/**
 * 
 * Módulo de control para la historia de usuario AgendarCita
 * 
 * @author axelhuerta
 *
 */
@Component
public class ControlAgendarCita {
   @Autowired
   private ServicioCita servicioCita;

   @Autowired
   private ServicioNotificacion servicioNotificacion;


   @Autowired
   private ControlPrecios Controlprecios;
   
   @Autowired
   VentanaAgendarCita ventana;

   /**
    * Inicia la historia de usuario
    * 
    */
   public void inicia(Usuario usuario) {
      ventana.muestra(this, usuario);
   }

   // listar citas
   public List<Cita> listarCitas() {
      return servicioCita.listarCitas();
   }

   // agregar citas
   public void agregarCita(LocalDate fecha, LocalTime hora, String servicio, String correo,String nombre) {
      try {
    	  LocalDate fechaActual = LocalDate.now();
    	  if (fecha.isBefore(fechaActual)) {
              ventana.muestraDialogoConMensaje("Seleccione una fecha valida");
              return;
          }

         servicioCita.agregarCita(fecha, hora, servicio, correo,nombre);
         agregarNotificacionCita(fecha, hora, correo);
         ventana.muestraDialogoConMensaje("Cita agregada");
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al agendar cita: " + e.getMessage());
      }
   }

   // agregar notificacion de la cita 
   public void agregarNotificacionCita(LocalDate fecha, LocalTime hora, String correo) {
      String message = "Se agregó tu cita para el " + fecha + " a las " + hora;
      servicioNotificacion.addNotificacion(message, correo);
   }

   // Comprobar citas
   public void comprobarCitasDia(LocalDate fecha) {
      try {
         servicioCita.comprobarCitasDia(fecha);
      } catch (Exception e) {
         ventana.muestraDialogoConMensaje("Error al consultar las citas del día: " + e.getMessage());
      }
   }

   /**
    * Termina la historia de usuario
    * 
    */
   public void termina() {
      // ventana.setVisible(false);
      ventana.dispose();
   }

public List<Precios> listaPrecios() {
	return Controlprecios.listaPrecios();
}
}
