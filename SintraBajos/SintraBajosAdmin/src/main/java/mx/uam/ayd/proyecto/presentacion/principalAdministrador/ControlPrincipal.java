package mx.uam.ayd.proyecto.presentacion.principalAdministrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.menuAdmin.ControlAdmin;


@Component
public class ControlPrincipal {


	@Autowired
	private VentanaPrincipal ventana;
	
	@Autowired
	private ControlAdmin controlAdmin;
	
	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
	}
	
	public void MenuAdmin() {
		controlAdmin.inicia();
	}

	/* Aqui se deben agrear los demas controles*/

}
