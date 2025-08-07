package Colas;

public class ColaCircular {
	
	int[] x = new int[6];
	int rear;
	int front;
	int size;
	
	ColaCircular(){
		rear = x.length-1;
		front = x.length-1;
		size = x.length;
		}
	
	void encolar(int dato){
		rear = (rear + 1) % size;
		if(rear == front) {
			System.out.println("Cola Llena");
			rear = (rear - 1 + size) % size;
		}else
			x[rear] = dato;
	}
	
	int desencolar() {
		int dato = -1;
		if(front == rear) {
			System.out.println("Cola Vacia");
		}else 
			front = (front + 1) % size;
		dato = x[front];
		return dato;
	}
}
