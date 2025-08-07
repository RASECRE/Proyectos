package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.menuUsuario.ControlUsuario;


/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlPrincipal {

	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;
	
	@Autowired
	private ControlUsuario controVentanaUsuario;
	

	@Autowired
	private VentanaPrincipal ventana;
	
	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
	}

	/**
	 * Método que arranca la historia de usuario "agregar usuario"
	 * 
	 */
	public void agregarUsuario() {
		
		controlAgregarUsuario.inicia();
		
	}
	
	public Usuario validaUsuario(String Correo, String Password) {  //Este controlador ya retorna un Usuario desde el servicio                                                       //Se podria utilizar este controlador con una condicional                                                           // en donde si el usuario esta registrado nos mande a la ventana
		return controlAgregarUsuario.validar(Correo,Password);     //de usuario    

		
		//  ******//// PREGUNTAR SI ESTA BIEN /////******
	}
	
	public void VentanaUsuario(Usuario usuario) {
		controVentanaUsuario.inicia(usuario);
		
	}
	         
	                                                      
	
	/* Aqui se deben agrear los demas controles*/

}
