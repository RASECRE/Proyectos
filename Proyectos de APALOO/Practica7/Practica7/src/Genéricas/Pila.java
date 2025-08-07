package Genéricas;
public class Pila <T> {
	private T[] pila = (T[]) new Object[10];
	private int tope;
	void Pila1() {
		tope = -1;
		}
	void push(T num) {
		if(tope == 9) {
			System.out.println("Pila llena");
			} else {
				tope = tope + 1;
				pila[tope] = num;	
				}
		}
	T pop() {
		T num;
		if(tope==-1){
			System.out.println("Pila Vacia");
			num = null;
			} else{
				num = pila[tope];
				tope= tope - 1;
				}
		return num;
	}
}
