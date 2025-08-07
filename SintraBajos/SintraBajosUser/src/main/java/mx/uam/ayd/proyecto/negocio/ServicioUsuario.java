package mx.uam.ayd.proyecto.negocio;


import java.util.Date;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Service
public class ServicioUsuario {
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	
	/**
	 * 
	 * Permite agregar un usuario
	 * 
	 * @param nombre
	 * @param apellido
	 * @param grupo
	 * @return
	 */
	public Usuario agregaUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, Date fechaNa,
			        String Domicilio,long Telefono, String Correo, String Pass, String diagnostico) {
		
		// Regla de negocio: No se permite agregar dos usuarios con el mismo nombre y apellido
		
		
		Usuario usuario = usuarioRepository.findByCorreo(Correo);
		
		if(usuario != null) {
			JOptionPane.showMessageDialog(null, "Ese correo ya existe, registra otro");
			throw new IllegalArgumentException("Ese correo ya existe");
		}
		
		
		log.info("Agregando usuario nombre: "+nombre+" apellido Paterno: "+apellidoPaterno +" apellidoMaterno: "+apellidoMaterno
				+ " Sexo: "+ sexo + " Fecha de Naciemiento: "+ fechaNa+ " Domicilio: "+ Domicilio+" Télefono: "+Telefono +" Correo: "+Correo+ " Contraseña: "+ Pass, diagnostico );
		
		usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellidoPaterno);
		usuario.setApellidomaterno(apellidoMaterno);
		usuario.setSexo(sexo);
		usuario.setFechaNa(fechaNa);
		usuario.setDomicilio(Domicilio);
		usuario.setTelefono(Telefono);
		usuario.setCorreo(Correo);
		usuario.setPass(Pass);
		usuario.setDiagnostico("");
		usuarioRepository.save(usuario);
		
		
		return usuario;
		
	}
	
	public Usuario ValidarUsuario(String Correo, String Password) {
		
		Usuario usuario = null;
		if(usuarioRepository.findByCorreo(Correo) != null) {
			usuario = usuarioRepository.findByCorreo(Correo);
			if(!usuario.getPass().equals(Password)) {
				JOptionPane.showMessageDialog(null, "Correo o Contraseña Invalidos");
				usuario= null;
			}

		}
		else {
			JOptionPane.showMessageDialog(null, "Correo o Contraseña Invalidos");
		}
		
		return usuario; 
	}

	/**
	 * Recupera todos los usuarios existentes
	 * 
	 * @return Una lista con los usuarios (o lista vacía)
	 */
	
	  // El paciente es almacenado con su nueva informacion
	  public void nuevo(Usuario u) {
	    usuarioRepository.save(u);
	  }
	
}
