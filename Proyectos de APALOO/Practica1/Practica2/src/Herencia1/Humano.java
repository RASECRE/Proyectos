package Herencia1;
public class Humano {
	protected String nombre;
	private String apellido;
	private int edad;
	Humano(String nombre, String apellido, int edad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
	}
	String getNombreCompleto() {
		return nombre+ " " + apellido;
	}
	int getEdad() {
		return edad;
	}
	String getInformacion() {
		return "Nombre: " + getNombreCompleto() + " " + "Edad: " + getEdad();
	}
}
