package Herencia1;
public class Principal {
	public static void main(String[]args) {
		Mexicano nomM = new Mexicano("C�sar","Ram�rez E.",18, " cuasasd ");
		System.out.println(nomM.getInformacion());
		Americano nomA = new Americano("Anabel", "Echeverria",20,"987-65-4321");
		System.out.println(nomA.getInformacion());
		Humano p1 = new Humano("C�sar","Silva",23);
		System.out.println(p1.getInformacion());
	}
}
//En relaci�n al punto 3, verifcar si en el constructor Mexicano o Americano puede ir el
//llamado super(....,....,....) despu�s de la inicializaci�n del atributo curp o ssn.
//No se puede para esto se pude realizar se tiene que poner antes
