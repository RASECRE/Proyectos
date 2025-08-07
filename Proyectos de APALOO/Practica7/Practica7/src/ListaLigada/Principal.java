package ListaLigada;
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		ClistaLigadaSE objeto = new ClistaLigadaSE(null, opcion);
		System.out.println("Menú");
		do {
			System.out.println("1.- Añadir al Principio");
			System.out.println("2.- Eliminar al Principio");
			System.out.println("3.- Obtener");
			System.out.println("4.- Buscar");
			System.out.println("5.- Imprimir Lista");
			System.out.println("6.- Eliminar Lista");
			System.out.println("7.- Salir");
			do {
				System.out.println("Selecciona el número que diga la acción a realizar");
				opcion = sc.nextInt();
			}while(opcion <= 0 || opcion > 7 );
		switch(opcion) {
		            case 1:
		            	System.out.println("Introduce el número que desea realizar: ");
		            	double x = sc.nextDouble();
		            	objeto.añadirAlPrincipio(x);
		            	System.out.println("");
		            	break;
				case 2:
					objeto.eliminarDelPrincipio();
					break;
				case 3:
					System.out.println("Introduzca la posicion del dato a obtener: ");
					int d = sc.nextInt();
					System.out.println("El dato obtenido es: " + objeto.obtener(d));
					System.out.println("");
					break;
				case 4:
					System.out.println("Digite el valor que desea buscar: ");
					double b = sc.nextDouble();
					System.out.println("El valor ingresado esta en la posicion: " + objeto.buscar(b));
					System.out.println("");
					break;
				case 5:
					System.out.println("La lista: ");
					objeto.imprimirLista();
					break;
				case 6:
					System.out.println("Lista Eliminada");
					objeto.eliminarLista();
					break;
				case 7:
					System.out.println("Fin del programa");
					break;
		     }
		}while(opcion !=7);
	}
}
