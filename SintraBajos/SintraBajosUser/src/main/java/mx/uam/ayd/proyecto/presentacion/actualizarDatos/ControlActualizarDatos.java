package mx.uam.ayd.proyecto.presentacion.actualizarDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Component
public class ControlActualizarDatos {
	@Autowired
	VentanaActualizarDatos ventana;
	@Autowired
	ServicioUsuario servicioUsuario;
	   
public void inicia(Usuario usuario) { //Inicia la ventana de la HU actualizar datos
	ventana.muestra(this, usuario); //Se invoca el metodo de la clase VentanaActualizarDatos
	}

public void UsuarioAct(Usuario usuario) {
	servicioUsuario.nuevo(usuario); //Se pasa el usuario para ser actualizado
	ventana.mensajeConfir(); //Se muestra en la ventana el mensaje de que la operacion fue realizada
	
}

}
