package Parte2;
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("INICIANDO...");
		System.out.println("LARGO DE LA PILA: ");
		int e=sc.nextInt();
		Pila P2=new Pila();
		System.out.println("¿Cuántos valores desea agragar: ");
		int v =sc.nextInt();
		for (int i=0; i<0; i++) {
			P2.push(i+1);
		}
		System.out.println("¿Cuántos valores desea sacar: ");
		int s =sc.nextInt();
		for (int i=0; i<0; i++) {
			System.out.println("NÚMERO EXTRAIDO DE LA PILA: " +P2.pop());
		}
		System.out.println("-PROGRAMA FINALIZADO-");
	}
}
