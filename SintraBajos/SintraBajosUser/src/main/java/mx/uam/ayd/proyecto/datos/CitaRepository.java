package mx.uam.ayd.proyecto.datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;

/**
 * 
 * Repositorio para citas
 * 
 * @author axelhuerta
 *
 */
public interface CitaRepository extends CrudRepository<Cita, Long> {
  // Encuentra una cita a partir de una fecha y hora
  public Cita findByFechaAndHora(LocalDate fecha, LocalTime hora);

  // Encuentra una cita a partir de una fecha
  public Cita findByFecha(LocalDate fecha);

  // Encuentra una cita a partir de fecha, hora, usuario
  public Cita findByFechaAndHoraAndCorreo(LocalDate fecha, LocalTime hora, String correo);

  // Encuentra las citas asociadas a un usuario
  public List<Cita> findByCorreo(String correo);
}