package Herencia1;
public class Principal {
	public static void main(String[]args) {
		Mexicano nomM = new Mexicano("César","Ramírez E.",18, " cuasasd ");
		System.out.println(nomM.getInformacion());
		Americano nomA = new Americano("Anabel", "Echeverria",20,"987-65-4321");
		System.out.println(nomA.getInformacion());
		Humano p1 = new Humano("César","Silva",23);
		System.out.println(p1.getInformacion());
	}
}
//En relación al punto 3, verifcar si en el constructor Mexicano o Americano puede ir el
//llamado super(....,....,....) después de la inicialización del atributo curp o ssn.
//No se puede para esto se pude realizar se tiene que poner antes
