package Parte1;
public class Pila {
	int[] stack = new int [10];
	int tope;
	Pila(){
		tope=-1;
	}
	void push (int item) {
		if(tope == 9) {
			System.out.println("-ERROR PILA LLENA-");
		}
		else {
			tope+=1;
			stack[tope]=item;
		}
	}
	int pop() {
		int item;
		if (tope==1) {
			System.out.println("-ERROR PILA LLENA-");
			item=-1;
		}
		else {
			item=stack[tope];
			tope-=1;
		}
		return item;
	}
}
