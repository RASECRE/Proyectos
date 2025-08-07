package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import mx.uam.ayd.proyecto.datos.CitaRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio relacionado con las citas
 *
 * @author axelhuerta
 *
 */
@Service
public class ServicioCita {

  @Autowired
  CitaRepository citaRepository;

  /**
   *
   * Retorna todas las citas registradas
   *
   * @return Lista de citas
   */
  public List<Cita> listarCitas() {
    return (List<Cita>) citaRepository.findAll();
  }

  /**
   *
   * Permite agregar una cita
   *
   * @param fecha
   * @param hora
   * @param servicio
   * @return
   */
 public Cita agregarCita(LocalDate fecha, LocalTime hora, String servicio, String correo, String Nombre) {
	    // Regla de negocio: No se permite agendar dos citas en un mismo horario

	    Cita cita = citaRepository.findByFechaAndHora(fecha, hora);

	    if (cita != null) {
	      if (comprobarCitasDia(fecha) == true) {
	    	  //JOptionPane.showMessageDialog(null, "Dia lleno");
	    	  throw new IllegalArgumentException("Día lleno");
	      } else {
	    	  //JOptionPane.showMessageDialog(null, "Horario Ocupado");
	    	  throw new IllegalArgumentException("Hora ocupada");
	        }
	    }
	    
	    else {

	    // registrar datos de la cita
	    cita = new Cita();
	    cita.setCorreo(correo);
	    cita.setFecha(fecha);
	    cita.setHora(hora);
	    cita.setServicio(servicio);
	    cita.setNombre(Nombre);

	    // guardar datos de la cita
	    citaRepository.save(cita);
	    }
	    return cita;
	  }

  /**
   *
   * Comprueba si un dia ya no permite más citas
   *
   * @param fecha
   * @return un boleano si todas las horas estan ocupadas
   */
  public boolean comprobarCitasDia(LocalDate fecha) {
    List<Cita> citas = new ArrayList<>();

    for (Cita cita : citaRepository.findAll()) {
      if (cita.getFecha().compareTo(fecha) == 0) {
        citas.add(cita);
      }
    }

    // 8 horas dado que es la maxima de citas por dia
    return citas.size() == 8;
  }

  /**
   *
   * Permite Eliminar una cita
   *
   * @param fecha
   * @param hora
   * @param idUsuario
   * @return
   */
  public void eliminarCita(LocalDate fecha, LocalTime hora, String correo) {
    // Buscar la cita correspondiente
    Cita cita = citaRepository.findByFechaAndHoraAndCorreo(fecha, hora, correo);

    // Si se encontró la cita, eliminarla
    if (cita != null) {
      citaRepository.delete(cita);
    } else {
      throw new IllegalArgumentException(
        "No se encontró la cita correspondiente"
      );
    }
  }

  /**
   *
   * Permite obtener una cita
   *
   * @param idUsuario
   * @return
   */
  public List<Cita> obtenerCitasPorUsuario(String correo) {
    return citaRepository.findByCorreo(correo);
  }

  /**
   *
   * Permite obtener una cita
   *
   * @param fecha
   * @param hora
   * @return
   */
  public Cita obtenerCita(LocalDate fecha, LocalTime hora) {
    return citaRepository.findByFechaAndHora(fecha, hora);
  }
  /**
  *
  * Busca la cita disponible mas cercana
  *
  * 
  * @return un objeto Optional que contiene la próxima cita disponible
  */
  public Optional<Cita> findProximaCitaDisponible() {
	   LocalDate fechaActual = LocalDate.now();
	   LocalDateTime fechaHoraActual = LocalDateTime.now();
	   LocalDate fechaIteracion = fechaActual;
	   LocalTime horaActual = fechaHoraActual.toLocalTime();

	   while (true) {
	      List<LocalTime> horariosDisponibles = Arrays.asList(
	         LocalTime.of(8, 0),
	         LocalTime.of(9, 0),
	         LocalTime.of(10, 0),
	         LocalTime.of(11, 0),
	         LocalTime.of(12, 0),
	         LocalTime.of(13, 0),
	         LocalTime.of(14, 0),
	         LocalTime.of(15, 0)
	      );
	      // Comprobar si la fecha actual es la misma que fecha Actual
	      
	      if (fechaIteracion.isEqual(fechaActual)) {
	          horariosDisponibles = horariosDisponibles.stream()
	             .filter(hora -> hora.isAfter(horaActual))  // Filtrar horarias pasados
	             .collect(Collectors.toList());
	       }

	      for (LocalTime hora : horariosDisponibles) {
	         Cita cita = citaRepository.findByFechaAndHora(fechaIteracion, hora);
	         if (cita == null) {
	            cita = new Cita();
	            cita.setFecha(fechaIteracion);
	            cita.setHora(hora);
	            return Optional.of(cita);
	         }
	      }

	      // Avanzar al siguiente día
	      fechaIteracion = fechaIteracion.plusDays(1);

	      // Comprobar si se alcanza el límite de días
	      if (fechaIteracion.isAfter(fechaActual.plusDays(30))) {
	         break;
	      }
	   }

	   return Optional.empty();
	}
  
}
