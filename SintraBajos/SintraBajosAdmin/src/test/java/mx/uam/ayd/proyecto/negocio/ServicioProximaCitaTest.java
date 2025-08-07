package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.CitaRepository;
import mx.uam.ayd.proyecto.datos.ProximasCitasRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

class ServicioProximaCitaTest {

	@Mock
	private ProximasCitasRepository proximasCitasRepository;

	@Mock
	private CitaRepository citaRepository;

	@InjectMocks
	private ServicioCita cita;

	@InjectMocks
	private ServicioProximaCita servicioProximaCita;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testObtenerCitasPorFecha() {
		// Datos de prueba
		LocalDate fecha = LocalDate.now();
		List<Cita> citasEsperadas = new ArrayList<>();
		// Agregar citas esperadas a la lista
		// ...

		// Configurar comportamiento del mock
		when(proximasCitasRepository.findByFecha(fecha)).thenReturn(citasEsperadas);

		// Llamar al método que se está probando
		List<Cita> citasObtenidas = servicioProximaCita.obtenerCitasPorFecha(fecha);

		// Verificar que se haya llamado al método del repositorio con los parámetros
		// correctos
		verify(proximasCitasRepository).findByFecha(fecha);

		// Verificar que la lista de citas obtenidas sea igual a la lista de citas
		// esperadas
		assertEquals(citasEsperadas, citasObtenidas);
	}

	@Test
	void testEliminarCita() {
		// Datos de prueba
		String nombre = "Nombre de la cita";
		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();
		String servicio = "Servicio de la cita";
		String correo = "example@.com";

		// Crear una lista de citas con una cita para la fecha dada
		List<Cita> citas = new ArrayList<>();
		Cita cita = new Cita();

		cita.setCorreo(correo);
		cita.setNombre(nombre);
		cita.setFecha(fecha);
		cita.setHora(hora);
		cita.setServicio(servicio);
		citas.add(cita);

		// Configurar comportamiento del mock
		when(proximasCitasRepository.findByFecha(fecha)).thenReturn(citas);

		// Llamar al método que se está probando
		servicioProximaCita.eliminarCita(nombre, fecha, hora, servicio);

		// Verificar que se haya llamado al método delete del repositorio con la cita
		// correcta
		verify(proximasCitasRepository).delete(cita);
	}
}
