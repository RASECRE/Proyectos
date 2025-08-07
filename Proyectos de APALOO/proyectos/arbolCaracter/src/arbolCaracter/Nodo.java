package arbolCaracter;

public class Nodo {
	char info;
    Nodo hizq, hder;
    Nodo previo, sucesor;
    int h; // altura

    public Nodo(char info){
        this.info = info;
        hizq = hder = null;
        h = 1; // se asume que el nulo es cero
    }

    public int compareTo(Nodo b){return this.info - b.info;} 
}
