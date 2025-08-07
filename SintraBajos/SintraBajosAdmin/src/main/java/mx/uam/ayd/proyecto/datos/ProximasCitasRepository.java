package mx.uam.ayd.proyecto.datos;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import mx.uam.ayd.proyecto.negocio.modelo.Cita;


public interface ProximasCitasRepository extends CrudRepository<Cita, Long> {
	
	 
	public List<Cita> findByFecha(LocalDate fecha);

	}