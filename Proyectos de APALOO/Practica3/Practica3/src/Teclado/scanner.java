package Teclado;
import java.util.Scanner;
public class scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar un n�mero entero: ");
		int a=sc.nextInt();
		System.out.println("El n�mero entero ingresado es el: " +a);
	}
}
