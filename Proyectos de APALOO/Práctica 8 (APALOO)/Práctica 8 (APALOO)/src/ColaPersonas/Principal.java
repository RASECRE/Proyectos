package ColaPersonas;

public class Principal {

	public static void main(String[] args) {
		
		ColaPersonas datos = new ColaPersonas();
		Personas h1 = new Personas("Pedro", 17, 1.59);
		Personas h2 = new Personas("Juan", 23, 1.72);
		Personas h3 = new Personas("Tomas", 53, 1.65);
		Personas h4 = new Personas("Rocio", 15, 1.55);
		Personas h5 = new Personas("Alfredo", 8, 1.23);
				
		datos.encolar(h1);
		datos.encolar(h2);
		datos.encolar(h3);
		datos.encolar(h4);
		datos.encolar(h5);
		
		Personas auxiliar = datos.desencolar();
		
		System.out.println("Persona 1");
		System.out.println("Nombre: " + auxiliar.Nombre + ", Edad: " + auxiliar.Edad + " Años, Altura: " + auxiliar.Altura + " cm.");
		auxiliar = datos.desencolar();
		System.out.println("");
		System.out.println("Persona 2");
		System.out.println("Nombre: " + auxiliar.Nombre + ", Edad: " + auxiliar.Edad + " Años, Altura: " + auxiliar.Altura + " cm.");
		auxiliar = datos.desencolar();
		System.out.println("");
		System.out.println("Persona 3");
		System.out.println("Nombre: " + auxiliar.Nombre + ", Edad: " + auxiliar.Edad + " Años, Altura: " + auxiliar.Altura + " cm.");
		auxiliar = datos.desencolar();
		System.out.println("");
		System.out.println("Persona 4");
		System.out.println("Nombre: " + auxiliar.Nombre + ", Edad: " + auxiliar.Edad + " Años, Altura: " + auxiliar.Altura + " cm.");
		auxiliar = datos.desencolar();
		System.out.println("");
		System.out.println("Persona 5");
		System.out.println("Nombre: " + auxiliar.Nombre + ", Edad: " + auxiliar.Edad + " Años, Altura: " + auxiliar.Altura + " cm.");
	}

}
