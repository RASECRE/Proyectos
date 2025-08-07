package IterVsRec;
public class Recursivos {
	double Factorial(int n){
		if(n==0)
			return 1;
		else
			return n * Factorial(n-1);
		}
	double Fibonacci(int n){
		if((n==0) || (n==1))
			return n;
		else
			return Fibonacci(n-1) + Fibonacci(n-2);
		}
	long Suma_arreglos(int[] j, int n){
		if(n==1)
			return j[n-1];
		else
			return Suma_arreglos(j,n-1) + j[n-1];
		}
	long Max(int[] j, int n){
		if(n==1)
			return j[n-1];
		else{
			long v1 = Max(j,n-1);
			if (v1 > j[n-1])
				return v1;
			else
				return j[n-1];
		}
	}
}