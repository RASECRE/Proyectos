package mx.uam.ayd.proyecto.negocio;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

class ServicioUsuarioTest {

	
	 @Mock
	  private UsuarioRepository usuarioRepository;

	  @InjectMocks
	  private ServicioUsuario usuarioService;

	  @BeforeEach
	  public void setUp() {
		  MockitoAnnotations.openMocks(this);
	  }
	  
	 

	    @Test
	    public void testAgregaUsuario() {
	        // Datos de prueba
	    	String nombre = "John";
			String apellidoPaterno = "Doe";
			String apellidoMaterno = "Smith";
			String sexo = "Masculino";
			Date fechaNa = new Date();
			String domicilio = "Calle 123";
			long telefono = 1234567890;
			String correo = "john.doe@example.com";
			String password = "secreto";
			String diagnostico = "Ninguno";

			// Comportamiento esperado
			Usuario usuarioGuardado = new Usuario(); // Crea un usuario ficticio
			
			// Establece los valores del usuario ficticio con los datos de prueba
			usuarioGuardado.setNombre(nombre);
			usuarioGuardado.setApellido(apellidoPaterno);
			usuarioGuardado.setApellidomaterno(apellidoMaterno);
			usuarioGuardado.setSexo(sexo);
			usuarioGuardado.setFechaNa(fechaNa);
			usuarioGuardado.setDomicilio(domicilio);
			usuarioGuardado.setTelefono(telefono);
			usuarioGuardado.setCorreo(correo);
			usuarioGuardado.setPass(password);
			usuarioGuardado.setDiagnostico(diagnostico);

	        // Comportamiento del repositorio simulado
			when(usuarioRepository.findByCorreo(correo)).thenReturn(null);
	        
	        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGuardado); // Define el comportamiento
	        
	     // Ejecución del método a probar
			Usuario resultado = usuarioService.agregaUsuario(nombre, apellidoPaterno, apellidoMaterno, sexo, fechaNa,
					domicilio, telefono, correo, password, diagnostico); // Llama al método a probar
	        
			// Verificaciones
	        verify(usuarioRepository, times(1)).findByCorreo(correo);
	        verify(usuarioRepository, times(1)).save(resultado);
	        
	        assertNotNull(resultado); // Verifica que el objeto usuario no sea null
	        
	    }
	    
	    @Test
	    public void testAgregaUsuario_CorreoExistente() {
	        // Datos de prueba
	        String nombre = "John";
	        String apellidoPaterno = "Doe";
	        String apellidoMaterno = "Smith";
	        String sexo = "M";
	        Date fechaNa = new Date(); // Aquí debes proporcionar una fecha válida
	        String domicilio = "123 Calle Principal";
	        long telefono = 1234567890;
	        String correo = "john.doe@example.com";
	        String pass = "password";
	        String diagnostico = "Aqui hay un diagnostico";

	        // Comportamiento del repositorio simulado
	        Usuario usuarioExistente = new Usuario();
	        when(usuarioRepository.findByCorreo(correo)).thenReturn(usuarioExistente); // Simular que ya existe un usuario con el mismo correo

	        // Llamada al método que se está probando
	        try {
	            usuarioService.agregaUsuario(nombre, apellidoPaterno, apellidoMaterno, sexo, fechaNa, domicilio, telefono, correo, pass, diagnostico);
	            Assertions.fail("Se esperaba una excepción IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            // Verificación
	            verify(usuarioRepository, times(1)).findByCorreo(correo); // Verificar que el método findByCorreo se haya llamado una vez
	            Assertions.assertEquals("Ese correo ya existe", e.getMessage()); // Verificar que se lance la excepción esperada con el mensaje correcto
	        }
	    }

	    
	    @Test
	    public void testValidarUsuario_UsuarioValido() {
	        // Datos de prueba
	        String correo = "john.doe@example.com";
	        String password = "password";

	        // Comportamiento del repositorio simulado
	        Usuario usuario = new Usuario();
	        usuario.setPass(password); // Establecer la contraseña para el usuario
	        when(usuarioRepository.findByCorreo(correo)).thenReturn(usuario); // Simular la búsqueda del usuario por correo

	        // Llamada al método que se está probando
	        Usuario resultado = usuarioService.ValidarUsuario(correo, password);

	        // Verificaciones
	        verify(usuarioRepository, times(2)).findByCorreo(correo); // Verificar que el método findByCorreo se haya llamado dos veces
	        Assertions.assertEquals(usuario, resultado); // Verificar que el resultado sea igual al usuario esperado
	    }


	    @Test
	    public void testValidarUsuario_UsuarioNoValido() {
	        // Datos de prueba
	        String correo = "john.doe@example.com";
	        String password = "password";

	        // Comportamiento del repositorio simulado
	        when(usuarioRepository.findByCorreo(correo)).thenReturn(null); // Simular que no se encuentra ningún usuario con el correo proporcionado

	        // Llamada al método que se está probando
	        Usuario resultado = usuarioService.ValidarUsuario(correo, password);

	        // Verificaciones
	        verify(usuarioRepository, times(1)).findByCorreo(correo); // Verificar que el método findByCorreo se haya llamado una vez
	        Assertions.assertNull(resultado); // Verificar que el resultado sea nulo, ya que no se encontró ningún usuario
	    }

	    @Test
	    public void testValidarUsuario_ContrasenaIncorrecta() {
	        // Datos de prueba
	        String correo = "john.doe@example.com";
	        String password = "password";
	        String contrasenaIncorrecta = "incorrecta";

	        // Comportamiento del repositorio simulado
	        Usuario usuario = new Usuario();
	        usuario.setPass(contrasenaIncorrecta); // Establecer la contraseña incorrecta para el usuario
	        when(usuarioRepository.findByCorreo(correo)).thenReturn(usuario); // Simular la búsqueda del usuario por correo

	        // Llamada al método que se está probando
	        Usuario resultado = usuarioService.ValidarUsuario(correo, password);

	        // Verificaciones
	        verify(usuarioRepository, times(2)).findByCorreo(correo); // Verificar que el método findByCorreo se haya llamado dos veces
	        Assertions.assertNull(resultado); // Verificar que el resultado sea nulo, ya que la contraseña es incorrecta
	    }
	    

	}