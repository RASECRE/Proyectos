package Parte1;
public class Principal {
	public static void main(String[] args) {
		Pila P =new Pila();
		System.out.println("INICIANDO PROGRAMA...");
		for (int i=0; i<8; i++) {
			P.push(i+1);
		}
		for (int i=0; i<3; i++) {
			System.out.println("Número extraido de la pila es: " +P.pop());
		}
		for (int i=0; i<5; i++) {
			P.push(i+1);
		}
		for (int i=0; i<2; i++) {
			System.out.println("Número extraido de la pila es: " +P.pop());
		}
		System.out.println("-FINALIZA EL PROGRAMA-");
	}
}
