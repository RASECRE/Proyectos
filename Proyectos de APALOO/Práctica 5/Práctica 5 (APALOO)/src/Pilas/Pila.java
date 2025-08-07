package Pilas;

public class Pila {
	static int tope;
	static int pila [] = new int [10];
	
	
void Pilas() {
		tope = -1;
	}

static void push(int num) {
	if(tope==9)
		System.out.println("Pila llena");
		else {
		tope = tope + 1;
		pila[tope] = num;
		}
}

static int pop() {
	int num;
	if(tope==-1){
	System.out.println("Pila Vacia");
	num=-1;
	}
	else{
	num= pila[tope];
	tope= tope - 1;
	}
	return num;
}

static int evaluaCadenaPostfija(String Cadena) {
	int num1= 0;
	int num2 = 0;
	int operacion = 0;
	for (int i=0; i<Cadena.length(); i++) {
	char caracter = Cadena.charAt(i);
	if(Character.isDigit(caracter)) {
		int num = Character.getNumericValue(caracter);
	    push(caracter);
	}
	if( (caracter =='+')||(caracter =='-')||(caracter =='*')||(caracter =='/')||(caracter =='^')) {
       if(caracter=='+') {
    	   num1 = pop();
    	   num2 = pop();
    	   operacion = num2 + num1;
    	   push(operacion);
	}
       if(caracter=='-') {
    	   num1 = pop();
    	   num2 = pop();
    	   operacion = num2 - num1;
    	   push(operacion);
	}
       if(caracter=='*') {
    	   num1 = pop();
    	   num2 = pop();
    	   operacion = num2 * num1;
    	   push(operacion);
	}
       if(caracter=='/') {
    	   num1 = pop();
    	   num2 = pop();
    	   operacion = num2 / num1;
    	   push(operacion);
	}
       if(caracter=='^') {
    	   num1 = pop();
    	   num2 = pop();
    	   operacion = num1 ^ num2;
    	   push(operacion);
	}
	
	}
}
	System.out.println(pop());
	return operacion;
}
}
