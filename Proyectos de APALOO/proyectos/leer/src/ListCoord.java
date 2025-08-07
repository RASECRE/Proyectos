import java.util.LinkedList;
import java.util.List;

public class ListCoord {
    List <Coordenada>l;

    public ListCoord(){
        l = new LinkedList<>();
    }

    public void agregarCoordenada(Coordenada c){
        l.add(c);
    }

    public String toString(){
        String aux = "";
        for (Coordenada c:l){
            if(aux.length() == 0){
                aux = aux + c;
            } else {
               aux = aux + "," + c;
            }

        }
        return aux;
    }
}
