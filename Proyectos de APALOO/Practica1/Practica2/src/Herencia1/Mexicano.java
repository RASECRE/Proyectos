package Herencia1;
class Mexicano extends Humano {
	private String curp;
	Mexicano(String nombre, String apellido, int edad, String curp){
		super(nombre, apellido, edad);
		this.curp=curp;
		}
	String getInformacion() {
		return "Nombre: " + super.getNombreCompleto() + " " + "Edad: " + getEdad() + " CURP: " + curp ;
	}
}
