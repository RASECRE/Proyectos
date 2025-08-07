package Colas;

public class ColaRecorrido {
	
	int[] x = new int[3];
	int rear;
	
	ColaRecorrido(){
		rear=-1;
		}
	
	void encolar(int dato){
		if(rear==x.length-1) {
			System.out.println("Cola Llena");
			}else
			rear++;
			x[rear]=dato;
			System.out.println(dato);
	}
	
	int desencolar() {
		int dato = 0;
		if(rear==-1){
			System.out.println("Cola Vacia");
		}else 
		dato = x[0];
		for(int i=0;i<x.length;i++)
		x[i] = x[i+1];
		rear--;
		return dato;
		
	}
}
