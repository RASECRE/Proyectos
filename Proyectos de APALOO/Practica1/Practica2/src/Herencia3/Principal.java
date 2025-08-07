package Herencia3;
public class Principal {
	 public static void main (String args[]) {
	OverloadDemo obj1 = new OverloadDemo();
	obj1.test();
	obj1.test(17);
	 }
}
//Existen un error en el llamado al no haber un método sobrecargado que reciba un
//entero?
//	no
//• Si es que no hay error, que método sobrecargado se ejecuta?
//	 no, si pones un double lo acepra
//• Si se invierten los tpos de datos que pasa?
//	ejecuta el double
//▪ void test(double a) ----> void test(int a)
// 	no se puede
//▪ int i ------> double i
//	si se pude
//• De lo anterior, que diferencias hay (o no hay) con la sobrecarga de constructores?
// la diferencia es que no se utiliza el super lo demas es muy similar