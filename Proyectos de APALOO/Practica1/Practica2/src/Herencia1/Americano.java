package Herencia1;
class Americano extends Humano{
	private String SSN;
	Americano(String nombre, String apellido, int edad, String SSN){
		super(nombre, apellido, edad);
		this.SSN=SSN;
	}
	String getInformacion() {
		return "Nombre: " + super.getNombreCompleto() + " " + "Edad: " + super.getEdad() + " SSN: " +SSN;
	}
}
