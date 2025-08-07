package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

public class ServicioUsuarioTest {

	@Mock
	private UsuarioRepository usuarioRepositoryMock; // Objeto simulado del repositorio de usuarios

	@InjectMocks
	private ServicioUsuario servicioUsuario; // Objeto de la clase ServicioUsuario a probar

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this); // Inicializa las anotaciones de Mockito y prepara los objetos simulados
	}

	@Test
	void testAgregaUsuario() {
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

		// Simulación de comportamiento
		when(usuarioRepositoryMock.findByCorreo(correo)).thenReturn(null); // Define el comportamiento simulado del
																			// método findByCorreo()
		when(usuarioRepositoryMock.save(any(Usuario.class))).thenReturn(usuarioGuardado); // Define el comportamiento
																							// simulado del método
																							// save()

		// Ejecución del método a probar
		Usuario usuario = servicioUsuario.agregaUsuario(nombre, apellidoPaterno, apellidoMaterno, sexo, fechaNa,
				domicilio, telefono, correo, password, diagnostico); // Llama al método a probar

		// Verificación de resultados
		verify(usuarioRepositoryMock).findByCorreo(correo); // Verifica que se haya llamado al método findByCorreo() del
															// objeto simulado
		verify(usuarioRepositoryMock).save(usuarioGuardado); // Verifica que se haya llamado al método save() del objeto
																// simulado
		assertNotNull(usuario); // Verifica que el objeto usuario no sea nulo
		assertEquals(usuarioGuardado, usuario); // Verifica que el objeto usuario sea igual al usuario ficticio
	}

	@Test
	public void testRecuperaUsuarios() {
		// Crea una lista de usuarios ficticia
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario());
		usuarios.add(new Usuario());

		// Define el comportamiento esperado del repositorio de usuarios
		when(usuarioRepositoryMock.findAll()).thenReturn(usuarios); // Define el comportamiento simulado del método
																	// findAll()

		// Ejecuta el método a probar
		List<Usuario> resultado = servicioUsuario.recuperaUsuarios(); // Llama al método a probar

		// Verifica que el resultado sea el esperado
		assertEquals(usuarios, resultado); // Verifica que la lista resultado sea igual a la lista de usuarios ficticia

		// Verifica que se llamó al método findAll() del repositorio
		verify(usuarioRepositoryMock).findAll(); // Verifica que se haya llamado al método findAll() del objeto simulado
	}

	@Test
	public void testNuevo() {
		// Crea un usuario ficticio
		Usuario usuario = new Usuario();

		// Ejecuta el método a probar
		servicioUsuario.nuevo(usuario); // Llama al método a probar

		// Verifica que se llamó al método save() del repositorio con el usuario
		// correcto
		verify(usuarioRepositoryMock).save(usuario); // Verifica que se haya llamado al método save() del objeto
														// simulado con el usuario ficticio
	}
}
