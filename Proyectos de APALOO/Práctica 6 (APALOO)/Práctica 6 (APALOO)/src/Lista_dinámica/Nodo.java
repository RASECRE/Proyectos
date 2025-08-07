package Lista_din;

public class Nodo {

	int dato;
	Nodo sigte;
	
	static void imprime(Nodo p) {
		Nodo aux=p;
		while(aux!=null) {
			System.out.println(aux.dato);
			aux = aux.sigte;
		}
	}
	
	//�El metodo que imprime la	lista debe ser est�tico o no-est�tico?
	//Debe de ser estatico, ya que la clase principlal, (la que esta llamando al metodo), es estatica y no se puede hacer una referencia est�tica al m�todo no est�tico.
}
