package PilaNombres;
import java.util.ArrayList;

public class PilaNombres {

	ArrayList <String> objeto = new ArrayList <String>();
	
	void push(String Cadena) {
		objeto.add(Cadena);
	}
	
	int tamaño() {
		return objeto.size();
	}
	
	String pop() {
		if(objeto.size() != 0) {
			return objeto.remove(objeto.size() -1);
		}else {
			return "Pila Vacia";
		}
	}
	
	
}
