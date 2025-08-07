package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.NotificacionRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;

public class ServicioNotificacionTest {
    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private ServicioNotificacion servicioNotificacion;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddNotificacion() {
        String correo = "correo@example.com";
        String message = "Mensaje de prueba";

        Notificacion notificacion = new Notificacion();
        notificacion.setCorreo(correo);
        notificacion.setMessage(message);

        when(notificacionRepository.save(any(Notificacion.class))).thenReturn(notificacion);

        Notificacion result = servicioNotificacion.addNotificacion(message, correo);

        assertEquals(correo, result.getCorreo());
        assertEquals(message, result.getMessage());

        verify(notificacionRepository, times(1)).save(any(Notificacion.class));
    }
    
    @Test
    public void testDeleteNotificacion() {
        String correo = "correo@example.com";
        
        // Configura el comportamiento de retorno del método deleteAllByCorreo()
        when(notificacionRepository.deleteAllByCorreo(correo)).thenReturn(null);
        
        servicioNotificacion.deleteNotificacion(correo);
        
        verify(notificacionRepository, times(1)).deleteAllByCorreo(correo);
    }


    @Test
    public void testRecuperaNotificacion() {
        String correo = "correo@example.com";

        Notificacion notificacion1 = new Notificacion();
        notificacion1.setCorreo(correo);
        notificacion1.setMessage("Mensaje 1");

        Notificacion notificacion2 = new Notificacion();
        notificacion2.setCorreo(correo);
        notificacion2.setMessage("Mensaje 2");

        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(notificacion1);
        notificaciones.add(notificacion2);

        // Configura el comportamiento de retorno del método findAll()
        when(notificacionRepository.findAll()).thenReturn(notificaciones);

        List<Notificacion> result = servicioNotificacion.recuperaNotificacion(correo);

        // Verifica que la lista de result sea igual a la lista de notificaciones
        assertEquals(notificaciones, result);

        // Verifica que el método findAll() se haya llamado solo una vez
        verify(notificacionRepository, times(1)).findAll();
    }
}
