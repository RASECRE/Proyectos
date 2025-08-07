package IterVsRec;
public class Principal {
	public static void main(String[] args) {
		Iterativos It = new Iterativos();
		Recursivos Re = new Recursivos();
		int[] arreglo1 = {1,2,3,4,5,6,7,8,9};
		int[] arreglo2 = {9,2,5,6,4,15,0,89};
		System.out.println("Factorial Iterativo de (0): " + It.Factorial(0));
		System.out.println("Factorial Iterativo de (10): " + It.Factorial(10));
		System.out.println("Factorial Iterativo de (97): " + It.Factorial(97));
		System.out.println(" ");
		System.out.println("Fibonacci Iterativo de (0): " + It.Fibonacci(0));
		System.out.println("Fibonacci Iterativo de (17): " + It.Fibonacci(17));
		System.out.println("Fibonacci Iterativo de (40): " + It.Fibonacci(40));
		System.out.println(" ");
		System.out.println("Factorial Recursivo de (0): " + Re.Factorial(0));
		System.out.println("Factorial Recursivo de (10): " + Re.Factorial(10));
		System.out.println("Factorial Recursivo de (97): " + Re.Factorial(97));
		System.out.println(" ");
		System.out.println("Fibonacci Recursivo de (0): " + Re.Fibonacci(0));
		System.out.println("Fibonacci Recursivo de (17): " + Re.Fibonacci(17));
		System.out.println("Fibonacci Recursivo de (40): " + Re.Fibonacci(40));
		System.out.println(" ");
		System.out.println("El factorial Iterativo maximo es el de 170, ya que desde el 171 marca como Infinito y esto lo se, porque lo puse a prueba con el for que comentado en el codigo.");
		System.out.println("El factorial Recursivo maximo es el de 170, ya que desde el 171 empieza a dar numeros infinitos.");
		System.out.println("El fibonacci Iterativo maximo es el de 92, ya que desde el 93 en adelante salen numero negativos.");
		System.out.println("Supondremos que el Fibonacci Recursivo maximo es el de 92, ya que desde el Fibonacci Recursivo 45 empieza a tardar muchisimo y para saber cual seria el maximo se tendria que tomar mucho tiempo.");
		System.out.println(" ");
		System.out.println("La suma del arreglo iterativo es de: " + It.Suma_arreglos(arreglo1));
		System.out.println("La suma del arreglo recursivo es de: " + Re.Suma_arreglos(arreglo1, 9));
		System.out.println(" ");
		System.out.println("El maximo del arreglo iterativo es de: " + It.Max(arreglo2));
		System.out.println("El maximo del arreglo recursivo es de: " + Re.Max(arreglo2, 8));
	}
}
