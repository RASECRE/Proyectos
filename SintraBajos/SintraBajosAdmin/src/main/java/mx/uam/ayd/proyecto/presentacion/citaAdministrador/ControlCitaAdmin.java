package mx.uam.ayd.proyecto.presentacion.citaAdministrador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCita;
import mx.uam.ayd.proyecto.negocio.ServicioPrecios;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import mx.uam.ayd.proyecto.negocio.modelo.Precios;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
import mx.uam.ayd.proyecto.presentacion.principalAdministrador.VentanaPrincipal;


@Component
public class ControlCitaAdmin {
	
	 /**
	   * Descripción de la clase ControlCitaAdmin. Se hacen los
	   * metodos del control.
	   * 
	   * @author Octavio Silva Zamora
	   * @version 1.0
	   * @Date 09/06/2023
	   */
	
	@Autowired
	private VentanaCitaAdmin ventana;
	
	@Autowired
	private ServicioUsuario recuperausuarios;
	
	@Autowired
	private ServicioPrecios servicioPrecio;
	
	@Autowired
	private ControlListarUsuarios diagnostico;
	
	@Autowired
	private ServicioCita serviciocita;
	

  
	/**
	 * El metodo Inicia y permite mostrar la ventana en la pantalla
	 * El método "muestra()" recibe como 
	 * parámetro la referencia a la instancia actual de la clase.
	 * .
	 */
  public void inicia() {
    ventana.muestra(this);
  }
  
  
  /**
   * Retorna una lista de usuarios a traves el ServicioUsuario.
   *
   * @return Una lista de usuarios.
   */
  public List<Usuario> listausuarios() {
      return recuperausuarios.recuperaUsuarios(); // Retorna la lista de usuarios 
  }
  
  
  
  /**
   * El metodo recibe el usuario actual para la consulta del Diagnostico.
   * a traves del control
   * 
   * @param usuario El usuario para la consulta.
   */
  public void consultar(Usuario usuario) {
      diagnostico.pacienteActual(usuario); 
  }
  
  
  /**
   * Retorna la lista de precios a traves del servicio Precios.
   *
   * @return Una lista de precios.
   */
  public List<Precios> listaPrecios() {
      return servicioPrecio.listarPrecios(); // Retorna la lista de precios obtenida del método "listarPrecios()"
  }
  
  
  
  /**
   * Agrega una cita utilizando los parametros pasados.
   * Muestra un mensaje de confirmación si la cita se registra correctamente.
   * Finaliza la operación llamando al método "termina()".
   * Si se produce alguna excepción, muestra un mensaje de error.
   *
   * @param fecha    La fecha de la cita.
   * @param hora     La hora de la cita.
   * @param servicio El servicio de la cita.
   * @param correo   El correo del paciente.
   * @param Nombre   El nombre del paciente.
   */
  public void agregarcita(LocalDate fecha, LocalTime hora, String servicio, String correo, String Nombre) {
      try {
          serviciocita.agregarCita(fecha, hora, servicio, correo, Nombre); // Agrega la cita utilizando el método "agregarCita()" de la instancia "serviciocita"
          ventana.muestramensaje("Se registró la cita"); // Muestra un mensaje de confirmación de que se registró la cita
          termina(); // Finaliza la operación
      } catch (Exception ex) {
          ventana.muestramensaje("No se pudo registrar la cita: " + ex.getMessage()); // Muestra un mensaje de error si se produce una excepción
      }
  }
  
  
  /**
   * Busca la próxima cita disponible.
   *
   * @return un objeto Optional que contiene la próxima cita disponible, o un Optional vacío si no hay citas disponibles.
   */
  
  public Optional<Cita> findProximaCitaDisponible() {
	  return serviciocita.findProximaCitaDisponible();
	}
  
  
	// Termina la historia de usuario
	public void termina() {
		ventana.dispose();   // aqui hace terminar el programa, comentar en caso de ser necesario	
	}

}
