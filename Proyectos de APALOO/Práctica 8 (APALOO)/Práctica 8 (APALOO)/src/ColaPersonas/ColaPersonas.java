package ColaPersonas;
import java.util.ArrayList;
import java.util.LinkedList;

public class ColaPersonas {
	ArrayList <Personas> dato = new ArrayList <Personas>();
	
	Personas desencolar(){
		if(dato.size() != 0){
			return dato.remove(0);
		}else {
			return null;
		}
	}
	
	void encolar(Personas Persona) {
		dato.add(Persona);
	}
	
}
