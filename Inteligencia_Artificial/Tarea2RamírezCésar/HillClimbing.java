package Tarea2RamírezCésar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class HillClimbing {
    public static void main(String[] args) {
        
        String archivo =  "D:\\Proyectos\\Inteligencia_Artificial\\Tarea2RamírezCésar\\Datos_Normalizados.txt";
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

        int Sol_act[] = new int[150];
        float Vecinos[][] = new float[150][3];
        float cost_act;
	Sol_act = Sol_inicial();
        cost_act = funcion_Obj(Sol_act, aux);
        System.out.println("\nDistancia: " + cost_act);

        // Iniciar el Hill Climbing
        int iteraciones[] =  new int [100];
        for(int a = 0; a < iteraciones.length; a++){
            for(int i = 0; i < 150; i++){
                for(int j = 0; j < 3; j++){
                                       
                    if(j != Sol_act[i]){
                        
                        int aux1= Sol_act[i];
                        Sol_act[i] = j;
                        Vecinos[i][j] =  funcion_Obj(Sol_act, aux);                                                                      
                        Sol_act[i] = aux1;
                    }else{
                        Vecinos[i][j]= 1000000;                     
                    }
                }
            }
            ArrayList A = new ArrayList();
            A = Menor_costo(Vecinos);       
            int n = (int) A.remove(0);
            int m = (int) A.remove(0);
                       
            if(Vecinos[n][m] <= cost_act){
                Sol_act[n] = m;
                cost_act = Vecinos[n][m];
            }
        }
        System.out.println("\nCosto: " + cost_act);
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