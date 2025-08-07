package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.PrecioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import mx.uam.ayd.proyecto.negocio.modelo.Precios;

/**
 * 
 * 
 * @author Octavio_Silva
 *
 */
@Service
public class ServicioPrecios {
   @Autowired
   PrecioRepository PreciosRepository;

   /**
    * 
    * Muestra las listas de Servicios 
    * 
    * @return Lista de Servicios
    */
   public List<Precios> listarPrecios() {
	      return (List<Precios>) PreciosRepository.findAll();
	   }
}
