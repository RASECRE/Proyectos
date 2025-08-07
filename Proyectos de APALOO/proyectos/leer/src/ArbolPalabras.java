import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ArbolPalabras {
    TreeMap <String, ListCoord> palabras;
    
    public ArbolPalabras() {
      palabras = new TreeMap();
    }
    
    public void agregaPalabra(String palabra, int ren, int col){
        //Buscar si la palabra ya esta dada de alta en el arbolCaracter
        palabra = palabra.toUpperCase();
        // si la palabra esta en el arbol
        if(palabras.containsKey(palabra)){
            // que esté
            // .get(key)
            // si esta agrega la coordenada
            palabras.get(palabra).agregarCoordenada(new Coordenada(ren, col));
            
        } else{
            // si no esta, agrega la palabra y la coordenada
            ListCoord l = new ListCoord();
            l.agregarCoordenada(new Coordenada(ren, col));
            palabras.put(palabra, l);
        }
    }

    public String toString(){
        String aux = "";
        Set set = palabras.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            aux = aux + (String)(me.getKey()) +  "(" + ((ListCoord)(me.getValue())).l.size() + ")" + ": ";
            aux = aux + (ListCoord)(me.getValue()) + "\n";
        }

        return aux;
    }
}
