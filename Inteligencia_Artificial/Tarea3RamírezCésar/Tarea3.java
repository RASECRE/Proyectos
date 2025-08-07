package Tarea3RamírezCésar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.exp;

public class Tarea3 {
    public static void main(String[] args) {
        
        String archivo =  "D:\\Proyectos\\Inteligencia_Artificial\\Tarea3RamírezCésar\\Datos_Normalizados.txt";
        float[][] aux = new float[150][4];
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            int fila = 0;
            while ((linea = br.readLine())!= null){
                String[] valores =  linea.split(",");
                for(int columna = 0; columna < 4; columna++){
                    aux[fila][columna] = Float.parseFloat(valores[columna]);
                }
                fila++;
            }
        } catch(IOException e){
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        
        for (int i = 0; i < aux.length ; i++) {
            for (int j = 0; j <aux[0].length ; j++) {
                 System.out.format("%-10.8f"+"  ",aux[i][j]);
            }
            System.out.println();
        }

        int Mejor_sol [] = new int[150];
        int Sol_act[] = new int[150];
        float Mejor_Costo, Cost_act, Cost_veci;
        int Mov1;
        float TempI = 1000, TempF = (float) 0.001, alfa = (float) 0.95, Temp;
        Sol_act = Sol_inicial();
        Mejor_sol = Sol_act;
        Cost_act = funcion_Obj(Sol_act, aux);
        Mejor_Costo = Cost_act;
        System.out.println("\nDistancia: " + Mejor_Costo);

        // Iniciar el Recorrido simulado
        Temp = TempI;

        while(Temp > TempF){
            int iteraciones[] = new int[100];
            for(int i = 0; i < iteraciones.length; i++){
                int a = (int) ((Math.random())*150);
                Mov1 = Sol_act[a];
                float b = (float) ((Math.random())*2);
                if(b < 0.5){
                    Sol_act[a] = (Sol_act[a] + 1) %3;
                }else{
                    Sol_act[a] = (Sol_act[a] - 1) %3;
                }

                Cost_veci = funcion_Obj(Sol_act, aux);
                float v = (Cost_veci - Cost_act);
                int u = (int) ((Math.random())*2);
                if(u < exp (-v/Temp)){
                    Cost_act = Cost_veci;
                }else{
                    Sol_act [a] = Mov1;
                }
                if(Mejor_Costo > Cost_veci){
                    Mejor_Costo = Cost_veci;
                    Mejor_sol = Sol_act;
                }
            }
            Temp = Temp * alfa;
        }
        System.out.println("Costo: " + Mejor_Costo);
    }

    public static int[] Sol_inicial(){
        int [] solucion =  new int [150];
        for (int i = 0; i < 150 ; i++) {
            solucion[i] = (int) ((Math.random())*3);
        }
        return solucion;
    }

    public static float funcion_Obj(int [] solucion,float [][] Obs){
        
        float C [][] = new float[3][4];
        int cont [] = new int[3];
        
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 4 ; b++) {
                C[a][b] = 0;
            }
        }
        
        for (int c = 0; c < 3 ; c++) {
            cont[c] = 0;
        }
        
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 150 ; j++) { 
                if(solucion[j] == i){
                    for (int k = 0; k < 4 ; k++) {
                        C[i][k] += Obs[j][k];                       
                    }
                    cont[i] += 1;
                }                    
             }          
        }       
        for (int i = 0; i < 3 ; i++) {
            for (int k = 0; k < 4 ; k++) {
                C[i][k] = C[i][k] / cont[i];
            }         
        }
        float distancia = 0;
        for (int a = 0; a < 3 ; a++) {
            for (int b = 0;b < 150 ; b++) {                
                if(solucion[b] == a){
                    for (int k = 0; k < 4; k++) {                     
                        distancia += abs(C[a][k] - Obs[b][k]);                        
                    }                   
                }   
            }
        }
        return distancia;
    }

    public static ArrayList Menor_costo(float [][] Vecinos){
        
        float Menor_costo = 1000000;
        ArrayList menores = new ArrayList();
        for(int i=0; i < 150; i++){
            for(int j=0; j < 3; j++){               
                if(Menor_costo > Vecinos[i][j]){
                    
                    Menor_costo = Vecinos[i][j];                         
                }
            }
        }
       for(int i=0; i < 150; i++){
            for(int j=0; j < 3; j++){         
                if(Menor_costo == Vecinos[i][j]){
                    menores.add(i);
                    menores.add(j);
                }                  
            }
        }       
        return menores;
    }
}