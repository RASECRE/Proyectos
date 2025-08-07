import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Grafo {
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

int [][] adj;
static final int INFINITO = Integer.MAX_VALUE-1000;
/**
 *
 * @author Administrador
     * @param a
     * @return 
 */

   
    
boolean esunaLetra(char a){
    return ( (a>='a' && a<='z') || (a>='A' && a<='Z') || (a>='0' &&  a<= '9'));
}
    
public Grafo(String origen) {
 
    String tipo = " ";
    
    try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream(origen);
        try (DataInputStream in = new DataInputStream(fstream)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            int i = 1;
            int tripleta;
            int org = 0, dest=0, peso=0;            
            while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            //System.out.println (i++  +  " "+strLine);
            
            char [] Arr = strLine.toCharArray();
            
            int j = 0;
            tripleta = 1;
            while (j<Arr.length){
                //come blancos
                while (j<Arr.length && !esunaLetra(Arr[j])){
                    j++;
                }
                //come distintos de blancos
                int k = j;
                while (k<Arr.length && esunaLetra(Arr[k])){
                    k++;
                }
                if ((k-j)<1) continue;
                
                //depende del renglon
                if (i == 1){
                    tipo = strLine.substring(j, k);
                    System.out.println("tipo =" + tipo);
                }
                
                //obtiene el tamaño de la matrix
                if (i==2){
                    
                    int tam = Integer.parseUnsignedInt(strLine.substring(j, k));
                    
                    adj = new int[tam][tam];
                    System.out.println("tam =" + String.valueOf(tam));
                }
                
                //Es una tripleta
                if (i>2){
                    
                    switch(tripleta){
                        case 1: org = Integer.parseUnsignedInt(strLine.substring(j, k));
                                tripleta++;
                                break;
                        case 2: dest = Integer.parseUnsignedInt(strLine.substring(j, k));
                                tripleta++;
                                break;
                        case 3: peso = Integer.parseUnsignedInt(strLine.substring(j, k));
                                //le pone el peso a la matriz
                               adj[org][dest]=peso;
                               if (!tipo.contentEquals("D")){
                                   adj[dest][org]=peso;
                               }
                               System.out.println(String.valueOf(org) + " "+  String.valueOf(dest) + "  "+  String.valueOf(peso));
                               
                    }
                    
                    
                    
                }
             
                j = k;
            }
            i++;
            }


        }
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
 
  
  }


public Grafo(){
    adj = null;
}

public Grafo(int numNodos){
    adj = new int [numNodos][numNodos];
    for (int i=0; i<numNodos; i++){
        Arrays.fill(adj[i], 0);
    }
}

public void imprimeMatriz(){
   int i,j;
   
   for (i=0; i<adj.length;i++){
       for (j=0; j<adj.length;j++){
           System.out.print(adj[i][j]);
           System.out.print("\t");
       }
       System.out.print("\n");
   }
}

public void recorridoAnchura(int v){
    int [] marcados = new int[adj.length];
    Queue<Integer> cola = new LinkedList<>();
    int w;
    // lo inicia con cero
    for (int i = 0; i < marcados.length; i++) {
        marcados[i] = 0;
    // 2
    cola.add(v);
    //3
    while (!cola.isEmpty()) {
        //4
        w = cola.poll();
        //System.out.println(w);
        //5
        for (int j = 0; j < adj[w].length; j++) {
            if (adj[w][j] !=0 && marcados[i]==0) {
                cola.add(i);
                marcados[i] = 1;
            }
        }
    }
    }
    
}

public void recorridoProfundidad(int v){
    int [] marcados = new int[adj.length];
    Stack<Integer> pila = new Stack<>();
    int w;
    // lo inicia con cero
    for (int i = 0; i < marcados.length; i++) {
        marcados[v] = 0;
    }
    // 1
    marcados[v] = 1;
    // 2
    pila.push(v);
    //3
    while (!pila.isEmpty()) {
        //4
        w = pila.pop();
        //System.out.println(w);
        //5
        for (int i = 0; i < adj[w].length; i++) {
            if (adj[w][i] !=0 && marcados[i]==0) {
                pila.push(i);
                marcados[i] = 1;
            }
        }
    }
    
}

public Set<Integer> recorridoProfundidadSet(int v){
    int [] marcados = new int[adj.length];
    Set<Integer> aux = new TreeSet<>();
    Stack<Integer> pila = new Stack<>();
    int w;
    // lo inicia con cero
    for (int i = 0; i < marcados.length; i++) {marcados[i] = 0;}

    marcados[v] = 1;
        aux.add(v);
    // 2
    pila.push(v);
    //3
    while (!pila.isEmpty()) {
        //4
        w = pila.pop();
        aux.add(w);
        //System.out.println(w);
        //5
        for (int i = 0; i < adj[w].length; i++) {
            if (adj[w][i] !=0 && marcados[i]==0) {
                pila.push(i);
                marcados[i] = 1;
            }
        }

    }
    return aux;
    
    }

    public List<Set<Integer>> componentesConexas(){
        List<Set<Integer>> salida = new LinkedList<>();
        boolean [] marcados = new boolean[adj.length];
    
        for (int i = 0; i < marcados.length; i++) {
            if (marcados[i]) {
                continue;
            }
            Set<Integer> c = recorridoProfundidadSet(i);
            salida.add(c);
            for(int j : c){
                marcados[j] = true;
            }
        }

        return salida;
    }

    public List<Set<Integer>> componentesConexas2(){
        List<Set<Integer>> componentes = new LinkedList<>();
        Set<Integer> marcados = new TreeSet<>();
    
        for (int i = 0; i < adj.length; i++) {
            if (!marcados.contains(i)) {
                continue;
            }
            Set<Integer> unacomp = recorridoProfundidadSet(i);

            for(int j : unacomp){
                marcados.add(j);
            }
        }

        return componentes;
        }

    public Grafo caminosInvertidos(){
        Grafo ci = new Grafo();
        ci.adj = new int[adj.length][adj.length];

        // transpuesta
        for(int i = 0; i < ci.adj.length; i++){
            for (int j = 0; j < ci.adj[i].length; j++) {
                ci.adj[i][j] = adj[j][i];
            }
        }

        return ci;
    }

    public Set<Integer> interseccion(Set<Integer> a, Set<Integer> b){
        Set<Integer> salida = new TreeSet<>();
        for (int i : a) {
            if(b.contains(i)){salida.add(i);}
        }
        return salida;
    }

    public List<Set<Integer>> fuertementeConexa(){
        List<Set<Integer>> salida = new LinkedList<>();
        Set<Integer> marcados = new TreeSet<>();
    
        for (int i = 0; i < adj.length; i++) {
            if (marcados.contains(i)) {
                continue;
            }
            Set<Integer> descendiete, ascendente, comp;
            descendiete = recorridoProfundidadSet(i);
            ascendente = caminosInvertidos().recorridoProfundidadSet(i);
            comp = interseccion(ascendente, descendiete);

            
            for(int j : comp){
                marcados.add(j);
            }

            salida.add(comp);
        }

        return salida;
    }

    public List<Set<Integer>> componentesFuertementeConexas(){
        List<Set<Integer>> componentes = new LinkedList<>();
        Set<Integer> marcados = new TreeSet<>();
        Grafo inversa = caminosInvertidos();
        
        Set<Integer> unacomp;
        Set<Integer> unacompInv;
        Set<Integer> unacompFte;

        for (int i = 0; i < adj.length; i++) {
            if(!marcados.contains(i)){
                // si no esta marcado, pide un recorrido
                unacomp = recorridoProfundidadSet(i);
                unacompInv = inversa.recorridoProfundidadSet(i);
                unacompFte = new TreeSet<>();
                // realiza la interseccion
                for (int v : unacomp) {
                    if(unacompInv.contains(v)){
                        unacompFte.add(v);
                        marcados.add(v);
                    }
                }
            

                // agrega la componente a la lista de elementos
                componentes.add(unacompFte);
            }
        }
        return componentes;
    }
        
}
