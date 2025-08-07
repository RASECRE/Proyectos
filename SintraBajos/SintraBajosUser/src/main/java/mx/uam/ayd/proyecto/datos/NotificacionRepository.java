package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;

@Transactional
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {

  public Notificacion findByCorreo(String correo);

  public Notificacion deleteAllByCorreo(String correo);
}
