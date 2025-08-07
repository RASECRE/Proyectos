import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de x1: ");
        double x1 = scanner.nextDouble();

        System.out.print("Ingrese el valor de x2: ");
        double x2 = scanner.nextDouble();

        System.out.print("Ingrese el ancho del intervalo: ");
        double intervalWidth = scanner.nextDouble();

        scanner.close();

        List<double[]> intervals = new ArrayList<>();

        // Dividir el intervalo en subintervalos más pequeños
        while (x2 - x1 > intervalWidth) {
            intervals.add(new double[]{x1, x1 + intervalWidth});
            x1 += intervalWidth;
        }
        intervals.add(new double[]{x1, x2});

        // Iniciar el método para cada subintervalo
        for (double[] interval : intervals) {
            findRootsInInterval(interval[0], interval[1], 100);
        }
    }

    public static void findRootsInInterval(double x1, double x2, int n) {
        if (n <= 0) {
            System.out.println("Hay una raiz en " + x1 + ", " + x2);
            return;
        }

        double m = calculateMidpoint(x1, x2);
        double f1 = function(x1);
        double f2 = function(x2);
        double fm = function(m);

        if (f1 * fm == 0 || fm * f2 == 0) {
            System.out.println("Hay una raiz en 0");
            if (f1 * fm == 0 && fm * f2 == 0) {
                return;
            }

            if (x1 == 0) {
                x1 += Math.ulp(0.0);
                f1 = function(x1);
            }
        }

        if (f1 * fm < 0 && fm * f2 < 0) {
            findRootsInInterval(x1, m, n);
            findRootsInInterval(m, x2, n);
        } else if (f1 * fm < 0) {
            findRootsInInterval(x1, m, n - 1);
        } else if (fm * f2 < 0) {
            findRootsInInterval(m, x2, n - 1);
        }
    }

    public static double calculateMidpoint(double x1, double x2) {
        return (x1 + x2) / 2;
    }

    public static double function(double x) {
        return Math.sin(x); // Función seno(x)
    }
}
