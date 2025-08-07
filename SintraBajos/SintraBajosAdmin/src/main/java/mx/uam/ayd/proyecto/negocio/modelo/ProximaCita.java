package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProximaCita {
    
  

    private List<String> listaCitas;
  
    public ProximaCita() {
    	this.listaCitas = new ArrayList<>();
    }
    
    public List<String> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<String> listaCitas) {
        this.listaCitas = listaCitas;
    }
    
    
}