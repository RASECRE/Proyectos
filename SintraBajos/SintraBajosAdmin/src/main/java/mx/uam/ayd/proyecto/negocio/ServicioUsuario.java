package mx.uam.ayd.proyecto.negocio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	public Usuario agregaUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, Date fechaNa,
			        String Domicilio,long Telefono, String Correo, String Pass, String diagnostico) {
		// Regla de negocio: No se permite agregar dos usuarios con el mismo nombre y apellido
	
		Usuario usuario = usuarioRepository.findByCorreo(Correo);
		
		if(usuario != null) {
			JOptionPane.showMessageDialog(null, "Ese correo ya existe, registra otro");
			throw new IllegalArgumentException("Ese correo ya existe");
		}
		log.info("Agregando usuario nombre: "+nombre+" apellido Paterno: "+apellidoPaterno +" apellidoMaterno: "+apellidoMaterno
				+ " Sexo: "+ sexo + " Fecha de Naciemiento: "+ fechaNa+ " Domicilio: "+ Domicilio+" Télefono: "+Telefono +" Correo: "+Correo+ " Contraseña: "+ Pass );
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
		usuario.setDiagnostico(diagnostico);		
		usuarioRepository.save(usuario);
		return usuario;
	}

	  /**
	   * Recupera todos los usuarios existentes
	   * 
	   * @return Una lista con los usuarios (o lista vacía)
	   */
	  // Los elementos del Repository Usuario son almacenados en un ArrayList
	  public List<Usuario> recuperaUsuarios() {
	    List<Usuario> usuarios = new ArrayList<>();
	    for (Usuario usuario : usuarioRepository.findAll()) {
	      usuarios.add(usuario);
	    }
	    return usuarios;
	  }

	  
	  // El paciente es almacenado con su nueva informacion
	  public void nuevo(Usuario u) {
	    usuarioRepository.save(u);
	  }
}
