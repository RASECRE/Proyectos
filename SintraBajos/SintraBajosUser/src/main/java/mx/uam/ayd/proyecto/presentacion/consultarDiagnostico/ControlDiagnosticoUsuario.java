package mx.uam.ayd.proyecto.presentacion.consultarDiagnostico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Component
/**
 * Clase usada para el control de la clase ventana
 * 
 * @author Ricardo Antonio Ponce Garcia
 * @version 2.0
 * @Date 07/06/2023
 */
public class ControlDiagnosticoUsuario {
	@Autowired
	VentanaDiagnosticoUsuario ventana;
	@Autowired
	ServicioUsuario servicioUsuario;
	
	/**
	 * Metodo con el que se inicia la ventana de la clase VentanaDiagnosticoUsuario
	 * 
	 * @param usuario Objeto necesario para mostrar los atributos del usuario loggeado en la ventana.
	 */
	public void inicia(Usuario usuario) {
		ventana.muestra(this,usuario); //Se invoca la ventana para mostrar los datos
	}

}
