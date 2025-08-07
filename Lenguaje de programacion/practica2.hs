import System.IO

-- Definición del tipo Fraccion
data Fraccion = Fraccion Integer Integer deriving Show

-- Función para normalizar una fracción
normaliza (Fraccion n d) = let gcd' = gcd n d
                           in Fraccion (n `div` gcd') (d `div` gcd')

-- Función para convertir una fracción a fracción egipcia
fraccionE (Fraccion n d)
    | n == 0 = []
    | n > 0 = let k = (d + n - 1) `div` n
                  in Fraccion 1 k : fraccionE (normaliza (Fraccion (n * k - d) (d * k)))
    | otherwise = error "No se admiten fracciones negativas"

-- Función para leer una fracción desde la entrada estándar
leerFraccion :: IO Fraccion
leerFraccion = do
    putStrLn "Ingrese el numerador:"
    numerador <- readLn
    putStrLn "Ingrese el denominador:"
    Fraccion numerador <$> readLn

-- Función para escribir una fracción egipcia en un archivo
escribirFraccionEgipcia :: FilePath -> Fraccion -> IO ()
escribirFraccionEgipcia archivo fraccion = writeFile
  archivo
  (unlines (map mostrarEgipcia (fraccionE fraccion)))
    where mostrarEgipcia (Fraccion n d) = "1" ++ show d

-- Función para leer una fracción egipcia desde un archivo
leerFraccionEgipcia :: FilePath -> IO [Fraccion]
leerFraccionEgipcia archivo = do
    contenido <- readFile archivo
    let lineas = lines contenido
    return $ map (Fraccion 1 . read) lineas

-- Funciones para realizar operaciones con fracciones
sumaF :: Fraccion -> Fraccion -> Fraccion
sumaF (Fraccion n1 d1) (Fraccion n2 d2) = normaliza $ Fraccion (n1 * d2 + n2 * d1) (d1 * d2)

restaF(Fraccion n1 d1) (Fraccion n2 d2) = normaliza $ Fraccion (n1 * d2 - n2 * d1) (d1 * d2)

multF (Fraccion n1 d1) (Fraccion n2 d2) = normaliza $ Fraccion (n1 * n2) (d1 * d2)

divF (Fraccion n1 d1) (Fraccion n2 d2) = normaliza $ Fraccion (n1 * d2) (n2 * d1)

-- Función principal del programa
main :: IO ()
main = do
    putStrLn "Seleccione una opción:"
    putStrLn "1. Pasar fraccion a fraccion egipcia."
    putStrLn "2. Poner la fraccion en un archivo."
    putStrLn "3. Leer el archivo y mostrar la fraccion egipcia."
    putStrLn "4. Realizar operaciones con fracciones egipcias"
    putStrLn "q. Salir"

    opcion <- getLine
    case opcion of
        "1" -> do
            fraccion <- leerFraccion
            putStrLn "Fracción ingresada:"
            print fraccion
            putStrLn "Fracción egipcia:"
            print $ fraccionE fraccion
            main
        "2" -> do
            fraccion <- leerFraccion
            putStrLn "Ingrese el nombre del archivo de la fraccion egipcia que quiere desea cambiar:"
            archivo <- getLine
            escribirFraccionEgipcia archivo fraccion
            putStrLn $ "La fracción egipcia se ha escrito en el archivo '" ++ archivo ++ "'."
            main
        "3" -> do
            putStrLn "Ingrese el nombre del archivo donde tenga su fraccion egipcia:"
            archivo <- getLine
            fraccionesEgipcias <- leerFraccionEgipcia archivo
            putStrLn "Fracciones egipcias leídas del archivo:"
            print fraccionesEgipcias
            main
        "4" -> do
            putStrLn "Operaciones que pudes realizar:"
            putStrLn "1. Suma"
            putStrLn "2. Resta"
            putStrLn "3. Multiplicación"
            putStrLn "4. División"
            putStrLn "q. Salir"
            operacion <- getLine
            case operacion of
                "1" -> do
                    putStrLn "Ingrese la primera fracción:"
                    fraccion1 <- leerFraccion
                    putStrLn "Ingrese la segunda fracción:"
                    fraccion2 <- leerFraccion
                    putStrLn "Resultado de la suma:"
                    print $ sumaF fraccion1 fraccion2
                    main
                "2" -> do
                    putStrLn "Ingrese la primera fracción:"
                    fraccion1 <- leerFraccion
                    putStrLn "Ingrese la segunda fracción:"
                    fraccion2 <- leerFraccion
                    putStrLn "Resultado de la resta:"
                    print $ restaF fraccion1 fraccion2
                    main
                "3" -> do
                    putStrLn "Ingrese la primera fracción:"
                    fraccion1 <- leerFraccion
                    putStrLn "Ingrese la segunda fracción:"
                    fraccion2 <- leerFraccion
                    putStrLn "Resultado de la multiplicación:"
                    print $ multF fraccion1 fraccion2
                    main
                "4" -> do
                    putStrLn "Ingrese la primera fracción:"
                    fraccion1 <- leerFraccion
                    putStrLn "Ingrese la segunda fracción:"
                    fraccion2 <- leerFraccion
                    putStrLn "Resultado de la división:"
                    print $ divF fraccion1 fraccion2
                    main
                _ -> do
                    putStrLn "Operación no válida."
                    main
        "q" -> putStrLn "Programa Terminado"
        _ -> do
            putStrLn "La opcion que selecciono es invalida."
            main
