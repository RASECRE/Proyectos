package mx.uam.ayd.proyecto.presentacion.menuAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import mx.uam.ayd.proyecto.presentacion.citaAdministrador.ControlCitaAdmin;
import mx.uam.ayd.proyecto.presentacion.EliminarCitas.ControlEliminarCita;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
import mx.uam.ayd.proyecto.presentacion.verCitas.ControlVerCitas;



@Component
public class ControlAdmin {
  @Autowired
  private ventanaAdmin ventana;

  @Autowired
  private ControlListarUsuarios controlListarUsuarios;

  @Autowired
  private ControlVerCitas controlVerCitas;
  
  @Autowired
  private ControlCitaAdmin controlAgendar;
 

  @Autowired
  private ControlEliminarCita controlEliminarCita;

  public void inicia() {
    ventana.muestra(this);
  }

  public void listarUsuarios() {
    controlListarUsuarios.inicia();
  }

  public void listarCitas() {
    controlVerCitas.inicia();
  }

  
  public void agendarCita() {
	  controlAgendar.inicia();
  }	  

  public void eliminarCitas() {
    controlEliminarCita.inicia();

  }
}
