package Genéricas;
public class Principal {
	public static void main(String[] args) {
		Pila <Integer> e = new Pila <Integer>();
		e.push(18);
		e.push(65);
		e.push(797);
		System.out.println("Tipos de Enteros: ");
		for (int i = 0; i < 3; i++) {
		System.out.println(e.pop());
		}
		System.out.println("");
		Pila <Double> d = new Pila <Double>();
		d.push(14.36);
		d.push(985.156);
		d.push(654.165);
		System.out.println("Tipos de Dobles: ");
		for (int i = 0; i < 3; i++) {
		System.out.println(d.pop());
		}
		System.out.println("");
		Pila <String> c = new Pila <String>();
		c.push("César");
		c.push("Foco");
		c.push("Gato");
		System.out.println("Tipos de Cadena: ");
		for (int i = 0; i < 3; i++) {
		System.out.println(c.pop());
		}
		System.out.println("");
		Pila obj = new Pila ();
		obj.push("Hola");
		obj.push("79");
		obj.push("65.4");
		System.out.println("Datos sin alguna especificación: ");
		for (int i = 0; i < 3; i++) {
		System.out.println(obj.pop());
		}
	}
}
