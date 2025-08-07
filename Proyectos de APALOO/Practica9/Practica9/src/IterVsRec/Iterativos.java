package IterVsRec;
public class Iterativos {
		double Factorial (int n){ 
		double producto = 1.0;
		for(int i=n; i>0; i--)
		producto = producto * i;
		return producto;
		}
		long Fibonacci(int n){
			if((n==0) || (n==1))
				return n;
		else{ 
			    long fibo1 = 0;
		    	long fibo2 = 1;
				long fibo3 = 0;
				for(int i=1; i<n; i++){
					fibo3 = fibo1 + fibo2;
					fibo1 = fibo2;
					fibo2 = fibo3;
				}
				return fibo3;
			}
		}	
		long Suma_arreglos(int[] j){
		long suma = 0;
		for(int i=0; i<j.length; i++)
			suma = suma + j[i];
		return suma; 
		}
		long Max(int[] j) {
			int  max = j[0];
			for(int i=1; i<j.length; i++) {
				if(j[i]>max)
					max=j[i];
			    }
			return max; 
		}
}
