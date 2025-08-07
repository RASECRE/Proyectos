package Pilas;

public class Principal_Pila {

	public static void main(String[] args) {
	Pila stack = new Pila();

	Pila.evaluaCadenaPostfija("623+-382/+*2^3");
	
	//for(int i=0; i<10; i++)
	//stack.push(i+1); 
	
	//System.out.println("");
	//System.out.println("Contenido de la pila: ");
	//for(int i=0; i<10; i++)
		//System.out.println("Posicion " + i + ": " + stack.pop());
	
	}
}
