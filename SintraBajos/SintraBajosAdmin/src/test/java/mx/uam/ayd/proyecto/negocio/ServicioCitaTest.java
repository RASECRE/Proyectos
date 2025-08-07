package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import mx.uam.ayd.proyecto.datos.CitaRepository;
import mx.uam.ayd.proyecto.negocio.ServicioCita;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCitaTest {

  @Mock
  private CitaRepository citaRepository;

  @Mock
  private ServicioCita servicioCita;

  @InjectMocks
  private ServicioCita citasService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * test para el método listarCitas
   * @param
   * @return
   */
  @Test
  public void testListarCitas() {
    // Crear una lista de citas simulada
    List<Cita> citas = new ArrayList<>();
    Cita cita1 = new Cita();
    cita1.setCorreo("correo1@example.com");
    cita1.setNombre("John Doe");
    cita1.setFecha(LocalDate.of(2023, 2, 20));
    cita1.setHora(LocalTime.of(10, 30));
    cita1.setServicio("Servicio 1");

    Cita cita2 = new Cita();
    cita2.setCorreo("correo2@example.com");
    cita2.setNombre("Jane Smith");
    cita2.setFecha(LocalDate.of(2023, 2, 22));
    cita2.setHora(LocalTime.of(15, 0));
    cita2.setServicio("Servicio 2");

    // Simular el comportamiento del método findAll() del repositorio
    when(citaRepository.findAll()).thenReturn(citas);

    // Verificar que el resultado esté vacío si no hay citas
    Assertions.assertTrue(citas.isEmpty());

    // agregamos las citas de prueba
    citas.add(cita1);
    citas.add(cita2);

    // Llamar al método bajo prueba
    List<Cita> resultado = citasService.listarCitas();

    // Verificar que el resultado coincide con las citas simuladas
    Assertions.assertEquals(citas, resultado);
  }

  @Test
  public void testComprobarCitasDia_TodasLasHorasOcupadas() {
    // Fecha de prueba
    LocalDate fecha = LocalDate.now();

    // Simular una lista de citas con 8 elementos para la fecha dada
    List<Cita> citas = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
      Cita cita = new Cita();
      cita.setFecha(fecha);
      citas.add(cita);
    }

    // Simular el comportamiento del repositorio
    when(citaRepository.findAll()).thenReturn(citas);

    // Llamar al método bajo prueba y verificar que devuelva true
    boolean resultado = citasService.comprobarCitasDia(fecha);
    Assertions.assertTrue(resultado);
  }

  @Test
  public void testComprobarCitasDia_NoTodasLasHorasOcupadas() {
    // Fecha de prueba
    LocalDate fecha = LocalDate.now();

    // Simular una lista de citas con 7 elementos para la fecha dada
    List<Cita> citas = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      Cita cita = new Cita();
      cita.setFecha(fecha);
      citas.add(cita);
    }

    // Simular el comportamiento del repositorio
    when(citaRepository.findAll()).thenReturn(citas);

    // Llamar al método bajo prueba y verificar que devuelva false
    boolean resultado = citasService.comprobarCitasDia(fecha);
    Assertions.assertFalse(resultado);
  }

  @Test
  public void testAgregarCita_CitaExitosa() {
    // Datos de prueba
    LocalDate fecha = LocalDate.of(2023, 2, 28);
    LocalTime hora = LocalTime.of(9, 0);
    String servicio = "Servicio de prueba";
    String correo = "correo@ejemplo.com";
    String nombre = "Juan";

    // Simular que no existe una cita en la misma fecha y hora
    when(citaRepository.findByFechaAndHora(fecha, hora)).thenReturn(null);

    // Llamar al método bajo prueba
    Cita cita = citasService.agregarCita(fecha, hora, servicio, correo,nombre);

    // Verificar que se haya guardado la cita
    verify(citaRepository, times(1)).save(cita);

    // Verificar que los datos de la cita sean los esperados
    assertEquals(correo, cita.getCorreo());
    assertEquals(fecha, cita.getFecha());
    assertEquals(hora, cita.getHora());
    assertEquals(servicio, cita.getServicio());
  }

  @Test
  public void testAgregarCita_HorarioOcupado() {
    // Datos de prueba
    LocalDate fecha = LocalDate.of(2023, 2, 28);
    LocalTime hora = LocalTime.of(9, 0);
    String servicio = "Servicio de prueba";
    String correo = "correo@ejemplo.com";
    String nombre = "Juan";

    // Simular que ya existe una cita en la misma fecha y hora
    Cita citaExistente = new Cita();
    when(citaRepository.findByFechaAndHora(fecha, hora))
      .thenReturn(citaExistente);

    // Llamar al método bajo prueba y esperar una excepción
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        citasService.agregarCita(fecha, hora, servicio, correo, nombre);
      }
    );
  }

  @Test
  public void testAgregarCita_DiaLleno() {
    // Crear una cita existente para el día en cuestión
    Cita citaExistente = new Cita();
    citaExistente.setFecha(LocalDate.now());
    citaExistente.setHora(LocalTime.now());

    // Configurar el repositorio de citas para devolver la cita existente
    Mockito
      .when(citaRepository.findByFechaAndHora(Mockito.any(), Mockito.any()))
      .thenReturn(citaExistente);

    // Configurar el servicio de citas para devolver "true" cuando se llame al método "comprobarCitasDia"
    Mockito
      .when(servicioCita.comprobarCitasDia(Mockito.any()))
      .thenReturn(true);

    // Llamar al método bajo prueba y esperar una excepción
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        citasService.agregarCita(
          citaExistente.getFecha(),
          citaExistente.getHora(),
          "Servicio",
          "Correo",
          "Juan"
        );
      }
    );
  }

  @Test
  public void testEliminarCita_CitaExistente() {
    // Datos de prueba
    LocalDate fecha = LocalDate.of(2023, 2, 28);
    LocalTime hora = LocalTime.of(9, 0);
    String correo = "correo@ejemplo.com";

    // Simular que se encuentra la cita correspondiente
    Cita cita = new Cita();
    when(citaRepository.findByFechaAndHoraAndCorreo(fecha, hora, correo))
      .thenReturn(cita);

    // Llamar al método bajo prueba
    citasService.eliminarCita(fecha, hora, correo);

    // Verificar que se haya eliminado la cita
    verify(citaRepository, times(1)).delete(cita);
  }

  @Test
  public void testEliminarCita_CitaInexistente() {
    // Datos de prueba
    LocalDate fecha = LocalDate.of(2023, 2, 28);
    LocalTime hora = LocalTime.of(9, 0);
    String correo = "correo@ejemplo.com";

    // Simular que no se encuentra la cita correspondiente
    when(citaRepository.findByFechaAndHoraAndCorreo(fecha, hora, correo))
      .thenReturn(null);

    // Llamar al método bajo prueba y esperar una excepción
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        citasService.eliminarCita(fecha, hora, correo);
      }
    );
  }

  @Test
  public void testObtenerCitasPorUsuario_CitasExistentes() {
    // Datos de prueba
    String correo = "correo@ejemplo.com";
    List<Cita> citasEsperadas = new ArrayList<>();

    Cita cita1 = new Cita();
    cita1.setCorreo("correo1@example.com");
    cita1.setNombre("John Doe");
    cita1.setFecha(LocalDate.of(2023, 2, 20));
    cita1.setHora(LocalTime.of(10, 30));
    cita1.setServicio("Servicio 1");

    Cita cita2 = new Cita();
    cita2.setCorreo("correo2@example.com");
    cita2.setNombre("Jane Smith");
    cita2.setFecha(LocalDate.of(2023, 2, 22));
    cita2.setHora(LocalTime.of(15, 0));
    cita2.setServicio("Servicio 2");

    // agregar citas esperadas al listado de citas
    citasEsperadas.add(cita1);
    citasEsperadas.add(cita2);

    // Simular que se encuentran citas para el usuario
    when(citaRepository.findByCorreo(correo)).thenReturn(citasEsperadas);

    // Llamar al método bajo prueba
    List<Cita> citasObtenidas = citasService.obtenerCitasPorUsuario(correo);

    // Verificar que se obtengan las citas esperadas
    assertEquals(citasEsperadas.size(), citasObtenidas.size());
    assertEquals(citasEsperadas, citasObtenidas);
  }

  @Test
  public void testObtenerCitasPorUsuario_CitasInexistentes() {
    // Datos de prueba
    String correo = "correo@ejemplo.com";
    List<Cita> listadoCitasVacio = new ArrayList<>();

    // Simular que no se encuentran citas para el usuario
    when(citaRepository.findByCorreo(correo)).thenReturn(listadoCitasVacio);

    // Llamar al método bajo prueba
    List<Cita> citasObtenidas = citasService.obtenerCitasPorUsuario(correo);

    // Verificar que no se obtengan citas
    assertTrue(citasObtenidas.isEmpty());
  }

  @Test
  public void testObtenerCita_CitaExistente() {
    // Datos de prueba
    LocalDate fecha = LocalDate.of(2023, 2, 28);
    LocalTime hora = LocalTime.of(9, 0);
    Cita citaEsperada = new Cita();

    // Simular que se encuentra la cita correspondiente
    when(citaRepository.findByFechaAndHora(fecha, hora))
      .thenReturn(citaEsperada);

    // Llamar al método bajo prueba
    Cita citasObtenida = citasService.obtenerCita(fecha, hora);

    // Verificar que se obtenga la cita esperada
    assertEquals(citaEsperada, citasObtenida);
  }

  @Test
  public void testObtenerCita_CitaInexistente() {
    // Datos de prueba
    LocalDate fecha = LocalDate.of(2023, 2, 28);
    LocalTime hora = LocalTime.of(9, 0);
    Cita citaEsperada = new Cita();
    citaEsperada.setCorreo(null);
    citaEsperada.setNombre(null);
    citaEsperada.setFecha(null);
    citaEsperada.setHora(null);
    citaEsperada.setServicio(null);

    // Simular que se encuentra la cita correspondiente
    when(citaRepository.findByFechaAndHora(fecha, hora))
      .thenReturn(citaEsperada);

    // Llamar al método bajo prueba
    Cita citasObtenida = citasService.obtenerCita(fecha, hora);

    // Verificar que se obtenga la cita esperada
    assertEquals(citaEsperada, citasObtenida);
  }
}