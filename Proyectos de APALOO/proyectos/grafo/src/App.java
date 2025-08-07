public class App {
    public static void main(String[] args) throws Exception {
        Grafo a = new Grafo("/home/axel/java/grafo/grafo/g1.txt");
        System.out.println("Matriz");
        //a.recorridoProfundidadSet(3);
        System.out.println(a.componentesConexas()); 
        System.out.println(a.fuertementeConexa()); 
        
    }

   
}
