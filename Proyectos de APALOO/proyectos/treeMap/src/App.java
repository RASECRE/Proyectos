import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        // crea el map
        TreeMap<String, Double> tm = new TreeMap<>();
        //var thisWork = 'a';

        // poner elementos en el mapa
        // .put para agregar
        // (key, dato)
        tm.put("Juan", 3434.34);
        tm.put("Pedro", 123.22);
        tm.put("Maria", 1378.00);
        tm.put("Jose", 99.22);
        tm.put("Arturo", -19.08);
        

        // se imprimen de forma ordenada
        System.out.println("\n" + tm + "\n");

        // reccorre con un iterador
        Set set = tm.entrySet(); // tipo de interfaz para ver el arbol

        // Iterator - recorrer listas
        Iterator i = set.iterator(); // sale del set

        // mostrar elementos
        while (i.hasNext()) { // .hasNext() mientras
            // i.next() - devuelve un valor y avanza
            Map.Entry me = (Map.Entry)i.next(); // map entry es otra interfaz
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());      
        }

        System.out.println();
        //Deposita 1000 en la cuenta de Jose
        Double aux;
        double balance = 0.0;
        if ((tm.get("Jose")) != null) {
            balance = tm.get("Jose");
        }

        //double balance = ((Double)tm.get("Jose")); // .doubleValue()
        System.out.println("Saldo de Jose " + balance);
        tm.put("Jose", balance + 1000);
        System.out.println("Nuevo saldo de Jose: " + tm.get("Jose"));

        set = tm.entrySet();
        i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); // map entry es otra interfaz
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());      
        }


        // busqueda
        // sortedMap, una lista
        System.out.println("Menores a Juan");
        SortedMap m = tm.headMap("Juan");
        set = m.entrySet();
        i = set.iterator();
        // mostrar elementos
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); // map entry es otra interfaz
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());      
        }

         // entre jose y pedro
         System.out.println("Entre Jose y Pedro");
         m = tm.subMap("Jose", "Pedro"); // [false,true)
         set = m.entrySet();
         i = set.iterator();
         // mostrar elementos
         while (i.hasNext()) {
             Map.Entry me = (Map.Entry)i.next(); // map entry es otra interfaz
             System.out.println(me.getKey() + ": ");
             System.out.println(me.getValue());      
         }

        // entre jose y pedro
        System.out.println("Entre Jose y Pedro");
        m = tm.subMap("Jose",false, "Pedro", true); // (false,true]
        set = m.entrySet();
        i = set.iterator();
        // mostrar elementos
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); // map entry es otra interfaz
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());      
        }

        // tail mayores a la llave incluyendo la llave
        System.out.println("Mayores a Juan");
        m = m.tailMap("Juan");
        set = m.entrySet();
        i = set.iterator();
        // mostrar elementos
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); // map entry es otra interfaz
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());      
        }


            String[] contenidoSeparado = null;
            // clientela.clear();
            
    
            try {
                leerArchivo = new FileReader(archivo);
                // Datos archivo arruna si se usa el BufferedReader leer.
                // Por eso la variable no global datosArchivo
                BufferedReader datosArchivo = new BufferedReader(leerArchivo);
    
                // contenidoArchivo es String
                while ((contenidoArchivo = datosArchivo.readLine()) != null) {
                    contenidoSeparado = contenidoArchivo.split(",");
                    for (int i = 0; i < contenidoSeparado.length - 4; i = i + 4) {
                        // No funciono con variable global de tipo Cliente
                        Cliente clienteDatos = new Cliente();
                        clienteDatos.setNumCliente(Integer.parseInt(contenidoSeparado[i]));
                        clienteDatos.setNombre(contenidoSeparado[i + 1]);
                        clienteDatos.setFechaNacimiento(contenidoSeparado[i + 2]);
                        clienteDatos.setSaldo(Double.parseDouble(contenidoSeparado[i + 3]));
                        clienteDatos.setDeuda(Double.parseDouble(contenidoSeparado[i + 4]));
    
                        clientela.add(clienteDatos);
                    }
    
                }
            } catch (Exception e) {
                System.out.println("Error al leer el CSV");
    
    
        }
    }
}
