import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        readFile("D:\\Proyectos\\proyectos\\leer\\romeo.txt");
    }

    // leer archivo
    private static void readFile(String filename){
        int i,j,k;
        char [] arreglo;
        i = 0;
        ArbolPalabras arbol = new ArbolPalabras();
        try{
            try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    if (line.length() < 1) {
                        continue;
                    }
                    arreglo = line.toCharArray();
                    j = 0;

                    // come blancos
                    while (j < arreglo.length && !Character.isLetter(arreglo[j])) {
                        j++;
                    }
                    

                    // come distintos de blancos
                    k = j;
                    while (k < arreglo.length && Character.isLetter(arreglo[k])) {
                        k++;
                    }

                    String palabra = line.substring(j,k);
                    arbol.agregaPalabra(palabra, j, k);
                    j = k;
                }
            }
        } catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", filename);
            return;
        }
        System.out.println(arbol);
    }

}
