package PilaNombres;

public class Principal {

	public static void main(String[] args) {
		PilaNombres cad = new PilaNombres();
		cad.push("Luis");
		cad.push("Pedro");
		cad.push("Octavio");
		cad.push("Juan");
		int tama�o = cad.tama�o();
		
		for (int i = 0; i < tama�o; i++) {
			System.out.println(cad.pop());
			}
	}

}
