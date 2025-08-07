package Colas;

public class ColaLineal {

	int[] x = new int[4];
	int front;
	int rear;
	int dato;
	
	ColaLineal(){
	rear=-1;
	front=0; 
	}
	
	void encolar(int dato){
	if(rear==x.length-1) {
	System.out.println("Cola Llena");
	}else
	rear++;
	x[rear]=dato;
	}

	int desencolar() {
		if(rear<front){
			System.out.println("Cola Vacia");
		}else 
		dato = x[front];
		front++;
		return dato;
		
}
}

