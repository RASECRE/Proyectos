--Funcion Factorial
--caso base
factorial 0 = 1  
--caso recursivo
factorial n = n * factorial (n - 1)  

--Funcion Raiz
raiz a b c = (((-b + sqrt(b^2 - 4*a*c)) / (2*a)), ((-b - sqrt(b^2 - 4*a*c)) / (2*a)))
