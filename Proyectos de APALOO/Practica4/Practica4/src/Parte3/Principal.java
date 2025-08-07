package Parte3;
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Pila P3 = new Pila();
		int opc = 0;
		int s;
		System.out.println("INICIANDO...");
		do {
			System.out.println("MENÚ: ");
			System.out.println("1.-TAMAÑO DE LA PILA.");
			System.out.println("2.-INTRODUCIR VALORES.");
			System.out.println("3.-VALORES PARA SACAR.");
			System.out.println("4.-SALIR.");
			System.out.println("INTRODUCIR LA OPCION ELEGIDA: ");
			s=sc.nextInt();
			switch(s) {
			case 1:
				System.out.println("TAMAÑO DE LA PILA: ");
				int M = sc.nextInt();
				P3.push(M);
				break;
			case 2:
				System.out.println("VALOR DE LA PILA: ");
				int O = sc.nextInt();
				P3.push(O);
				break;
			case 3:
				System.out.println("NÚMERO EXTRAIDO DE LA PILA: " +P3.pop());
				break;
			case 4:
				System.out.println("-PROGRAMA FINALIZADO");
				break;
			default:
			System.out.println("-ERROR OPCION NO ENCONTRADA-");
		}
	}while(s<4);
	}
}
