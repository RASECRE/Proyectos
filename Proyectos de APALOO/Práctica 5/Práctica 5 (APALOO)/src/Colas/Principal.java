package Colas;

public class Principal {

	public static void main(String[] args) {
		
		ColaLineal cola= new ColaLineal();
		System.out.println("Cola Lineal");
		cola.encolar(4);
		cola.encolar(5);
		cola.encolar(7);
		cola.encolar(3);
		//cola.encolar(3);
		for(int i=0; i<5; i++)
		System.out.println(cola.desencolar());
		
		System.out.println("");
		
		ColaRecorrido cola2 = new ColaRecorrido();
		System.out.println("Cola con Recorrido");
		cola2.encolar(14);
		cola2.encolar(5);
		cola2.encolar(9);
		cola2.encolar(3);
		//System.out.println(cola2.desencolar());
		
		System.out.println("");
		
		ColaCircular cola3 = new ColaCircular();
		System.out.println("Cola Circular");
		cola3.encolar(8);
		cola3.encolar(9);
		cola3.encolar(2);
		cola3.encolar(5);
		cola3.encolar(3);
		//cola3.encolar(4);
		for(int i=0; i<6; i++)
			System.out.println(cola3.desencolar());
	}

}
