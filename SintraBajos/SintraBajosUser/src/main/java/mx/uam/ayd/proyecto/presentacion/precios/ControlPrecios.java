package mx.uam.ayd.proyecto.presentacion.precios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPrecios;
import mx.uam.ayd.proyecto.negocio.modelo.Precios;



@Component
public class ControlPrecios {

	@Autowired
	private VentanaPrecios ventana;
	

	@Autowired
	private ServicioPrecios servicioPrecio;
	
	public void inicia() {

		ventana.muestra(this);
	}
	
	public List<Precios> listaPrecios() {
		return servicioPrecio.listarPrecios();
	   }
	
}
