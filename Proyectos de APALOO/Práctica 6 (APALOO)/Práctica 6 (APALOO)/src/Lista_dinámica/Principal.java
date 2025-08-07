package Lista_din;

public class Principal {

	public static void main(String[] args) {
		
		Nodo aux;
		int x;

		Nodo p = new Nodo();
		p.dato = 10;
		p.sigte = null;
		//System.out.println("El dato de 'p' es: " + p.dato);
		
		
		Nodo q = new Nodo();
		q.dato = 20;
		q.sigte = p; //Conecta los nodos "q" y "p"
		p = q; //Se mueve al inicio "p" donde se encuentra "q"
		//System.out.println("El dato de 'q' es: " + q.dato);
		
		Nodo w = new Nodo();
		w.dato = 30;
		w.sigte = q;
		p = w;
		//System.out.println("El dato de 'w' es: " + w.dato);
				
		Nodo.imprime(p);
		System.out.println("");
		//x = p.dato;
		//p.dato = p.sigte.sigte.dato;
		//p.sigte.sigte.dato = x;
		Nodo.imprime(p);
		
		
	}

}
