package Parte2;
public class Pila {
	private int[] stack = new int [10];
	private int tope;
	Pila() {
		stack = new int [10];
		tope=-1;
	}
	Pila(int tamaño){
		stack = new int [tamaño];
		tope=-1;
	}
	void push (int item){
		if(tope==stack.length-1) {
			System.out.println("-ERROR PILA VACIA-");
		}
		else{
			tope+=1;
			stack[tope]=item;
		}
	}
	int pop(){
		int item;
		if(tope==1) {
			System.out.println("-ERROR PILA VACIA-");
			item=-1;
		}
		else {
			item=stack[tope];
			tope-=1;
		}
		return item;
	}
}
