package DivisióndeArreglosV2;
import java.util.Random;
public class Arreglo {
	private int a[] = new int [100];
	private int b[] = new int [100];
	private int c[] = new int [100];
	Arreglo() {
		for (int i = 0; i < a.length; i++){
		Random R = new Random();
			a[i]= R.nextInt(20)+1;
			b[i]= R.nextInt(20);
		}
	}
	int[] division() {
		int contador = 0;
		for(int i = 0; i < a.length; i++) {
			try{
			c[i] = a[i] / b[i];
			System.out.println("Arreglo c posicion: " +i+ " : "+a[i]+ "/" +b[i]+ " = " +c[i]);
			}
			catch(ArithmeticException d) {
				System.out.println("El arreglo c la posicion es: " +i+ " : " +a[i]+ " / 0 = ∞ ");
				contador+=1;
			}
			finally {
				if(i==99);
			}
		}
		System.out.println("El número de veces que se genera la excepcion son: " +contador+ "\n");
		return c;
	}
}