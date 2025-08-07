package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Precios;

/**
 * 
 * Repositorio para Servicios
 * 
 * @author Octavio_Silva
 *
 */
public interface PrecioRepository extends CrudRepository<Precios, Long> {

  // Encuentra las citas asociadas a un usuario
  public List<Precios> findAll();
}