package arbolCaracter;

import java.util.List;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		/*Arbol a = new Arbol();
		a.insOrdenado('j');
		a.insOrdenado('a');
		a.insOrdenado('n');
		a.insOrdenado('l'); // desvalance interno derecho
		a.insOrdenado('k');
		a.insOrdenado('m');
		a.insOrdenado('o');
		//System.out.println(a);

		Arbol b = new Arbol();
		b.insOrdenado('j');
		b.insOrdenado('a');
		b.insOrdenado('m');
		b.insOrdenado('k'); // desvalance externo derecho
		b.insOrdenado('l');
		b.insOrdenado('o');
		System.out.println(b);*/

		//TreeMap<String, List<coordenada>> pals = new TreeMap();
		Arbol a = new Arbol();
		Arbol b = new Arbol("a(b,c)");
		a.infijoArbol("0-(a+b)");
		a.poda();
		//System.out.println(Math.sin(30));
		System.out.println(a.pasaInfijo());
		//System.out.println(a.deriva('x').pasaInfijo());
	}

}
