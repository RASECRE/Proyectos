package mx.uam.ayd.proyecto.presentacion.EliminarCitas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProximaCita;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

/**
 * Control de la ventana eliminar citas.
 */


@Component
public class ControlEliminarCita {

    @Autowired
    private VentanaEliminarCitas ventana;

    @Autowired
    private ServicioProximaCita servicioProximaCita;

    /**
     * Inicia el programa.
     */

    public void inicia(){
        ventana.muestraE(this);
    }

    /**
     * Obtiene las citas por fecha.
     * 
     * @param fecha Fecha de las citas a obtener
     * @return Lista de citas correspondientes a la fecha
     */

    public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
        return servicioProximaCita.obtenerCitasPorFecha(fecha);
    }

    /**
     * Finaliza el programa.
     */

    public void termina(){
        ventana.setVisible(false);
    } 

    /**
     * Elimina una cita.
     * 
     * @param nombre   Nombre de la cita a eliminar
     * @param fecha    Fecha de la cita a eliminar
     * @param hora     Hora de la cita a eliminar
     * @param servicio Servicio de la cita a eliminar
     */

    public void eliminarCita(String nombre, LocalDate fecha, LocalTime hora, String servicio){
        servicioProximaCita.eliminarCita(nombre, fecha, hora, servicio);
    }
}
