package PilaNombres;

public class Principal {

	public static void main(String[] args) {
		PilaNombres cad = new PilaNombres();
		cad.push("Luis");
		cad.push("Pedro");
		cad.push("Octavio");
		cad.push("Juan");
		int tamaño = cad.tamaño();
		
		for (int i = 0; i < tamaño; i++) {
			System.out.println(cad.pop());
			}
	}

}
