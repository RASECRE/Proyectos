package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * 
 * @author Octavio_Silva
 *
 */
@Entity
@Data
@Table(name = "servicios")
public class Precios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Servicio") 
	private String Servicio;
	@Column(name = "Precio") 
	private String Precio;
	
}
