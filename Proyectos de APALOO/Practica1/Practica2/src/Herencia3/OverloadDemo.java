package Herencia3;
public class OverloadDemo {
	void test() {
		System.out.println("Salida del metodo 1");
	}
	void test(int a, int b) {
		System.out.println("Salida del metodo 2 "+" Valor de a: "+ a + " Valor de b: " + b);
	}
	void test(double a) {
		System.out.println("Salida del metodo 3" + " Valor de a: " + a);
	}
}
