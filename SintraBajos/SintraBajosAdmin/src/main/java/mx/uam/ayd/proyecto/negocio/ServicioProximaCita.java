package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ProximasCitasRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

@Service
public class ServicioProximaCita {
	@Autowired
	   ProximasCitasRepository proximasCitasRepository;
	
	/**
	    * 
	    * Busca citas a traves de la fecha
	    * 
	    * @param fecha
	    * @return Lista <Citas> Retorna la lista de citas 
	*/

	public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
        return proximasCitasRepository.findByFecha(fecha);
    }

	/**
     * Permite eliminar una cita
     * 
     * @param nombre   Nombre de la cita
     * @param fecha    Fecha de la cita
     * @param hora     Hora de la cita
     * @param servicio Servicio de la cita
     */

    public void eliminarCita(String nombre, LocalDate fecha, LocalTime hora, String servicio) {
    try {
        List<Cita> citas = proximasCitasRepository.findByFecha(fecha);
        if (!citas.isEmpty()) {
            Cita cita = citas.get(0);
            proximasCitasRepository.delete(cita);
        }
    } catch (Exception e) {
        // Manejar la excepción aquí
        System.out.println("Ocurrió un error al eliminar la cita: " + e.getMessage());
    }
}


}
