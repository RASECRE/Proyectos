--Funcion Coprimos (el gcd se ocupa para el mcd)
coprimos a b = gcd a b == 1

--Funcion Codifica (con el filter tomamos x si los elementos son iguales y el otro nos ayuda a cuando es diferente)
codifica [] = []
codifica (x:xs) = (x, length (filter (==x) (x:xs))) : codifica (filter (/=x) xs)

--2
--Haskell Avanzado
--Fraccion
data Fraccion = Fraccion Integer Integer deriving Show --Definir el tipo de dato que se manejara la Fraccion /  agregar el "deriving show" ayudo a que ya apareciera el resultado 
--suma
sumaF(Fraccion n1 d1)(Fraccion n2 d2) = Fraccion ( n1 * d2 + n2 * d1) (d1 * d2)
--resta
restaF(Fraccion n1 d1)(Fraccion n2 d2) = Fraccion ( n1 * d2 - n2 * d1) (d1 * d2)
--multiplicacion
multiF(Fraccion n1 d1)(Fraccion n2 d2) = Fraccion ( n1 * n2 ) (d1 * d2)
--divicion
divF(Fraccion n1 d1)(Fraccion n2 d2) = Fraccion ( n1 * d2 ) (n2 * d2)
--normaliza
normaliza (Fraccion n d) = let gcd' = gcd n d
                           in Fraccion (n `div` gcd') (d `div` gcd') -- esto hace que dentro de la fraccion haga el mcd tanto del numerador como del denominador 

-- se debe poner la funcion y despues entre parentesis poner Fraccion y el numerador y despues el denominador "sumaF(Fraccion numerador denominador)"

--Fracciones Egipcias
fraccionE :: Fraccion -> [Fraccion]
fraccionE (Fraccion n d)
    | n == 0 = []  -- Si el numerador es cero, no hay fracciones egipcias
    | n > 0 = let k = (d + n - 1) `div` n
                  in Fraccion 1 k : fraccionE (normaliza (Fraccion (n * k - d) (d * k)))
    | otherwise = error "No se admiten fracciones negativas"

--3
--Funcion mergesort (ordenamiento de mezcla) 
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
    | x < y  = x : merge xs (y:ys)   -- | ese signo es la guardia y lo va hace si es verdadera si no se pasa a la siguiente
    | otherwise = y : merge (x:xs) ys

-- El splitAt es una funcion que divide un vector en dos partes. Como la tupla 
mergesort [] = []
mergesort [x] = [x]
mergesort xs = merge (mergesort ls) (mergesort rs) where
    (ls, rs) = splitAt (div (length xs) 2) xs