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
 * Entidad de negocio Usuario
 * 
 * @author Sintra Bajos
 *
 */
@Entity
@Data
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(name = "Nombre") 
	private String nombre;
	@Column(name = "Apellido_Paterno") 
	private String apellido;
	@Column(name = "Apellido_Materno") 	
	private String apellidomaterno;
	@Column(name = "Sexo") 
	private String sexo;
	@Column(name = "Fecha_Nacimiento") 
	private Date fechaNa;
	@Column(name = "Domicilio") 	
	private String domicilio;
	@Column(name = "Telefono") 
	private long telefono;
	@Column(name = "Correo") 
	private String correo;
	@Column(name = "Password") 
	private String pass;
	  @Column(name = "Diagnostico")
	  private String Diagnostico;
	
}
