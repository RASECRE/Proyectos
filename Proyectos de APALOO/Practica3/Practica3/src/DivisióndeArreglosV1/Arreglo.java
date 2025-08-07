package DivisióndeArreglosV1;
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
void division() {
	for(int i = 0; i < a.length; i++) {
		c[i] = a[i] / b[i];
		System.out.println("Arreglo c posicion: " +i+ " : "+a[i]+ "/" +b[i]+ " = " +c[i]);
		}
	}
}
