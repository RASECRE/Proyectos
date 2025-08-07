import math

"""1.1 Fracciones con operaciones aritmeticas basicas"""
class Fraccion:
    def __init__(self, numerador, denominador):
        self.numerador = numerador
        self.denominador = denominador
        self.simplificar()

    #Dar de manera simplificada el resultado de las fracciones
    def simplificar(self):
        gcd = math.gcd(self.numerador, self.denominador)
        self.numerador //= gcd
        self.denominador //= gcd

    #Darle forma de como quiero que imprima
    def __str__(self):
        return f"{self.numerador}/{self.denominador}"

    # Suma
    def __add__(self, other):
        nuevo_numerador = self.numerador * other.denominador + other.numerador * self.denominador
        nuevo_denominador = self.denominador * other.denominador
        return Fraccion(nuevo_numerador, nuevo_denominador)

    # Resta
    def __sub__(self, other):
        nuevo_numerador = self.numerador * other.denominador - other.numerador * self.denominador
        nuevo_denominador = self.denominador * other.denominador
        return Fraccion(nuevo_numerador, nuevo_denominador)

    # Multiplicación
    def __mul__(self, other):
        nuevo_numerador = self.numerador * other.numerador
        nuevo_denominador = self.denominador * other.denominador
        return Fraccion(nuevo_numerador, nuevo_denominador)

    # División
    def __truediv__(self, other):
        nuevo_numerador = self.numerador * other.denominador
        nuevo_denominador = self.denominador * other.numerador
        return Fraccion(nuevo_numerador, nuevo_denominador)


"""1.2 Fracciones Egipcias"""
class FraccionEgipcia:
    def __init__(self, fraccion):
        self.fraccion = fraccion
        self.fracciones_egipcias = self.fraccEgipcia()

    def fraccEgipcia(self):
        fracciones_egipcias = []
        fraccion_actual = self.fraccion

        while fraccion_actual.numerador != 0:
            denominador_egipcio = math.ceil(fraccion_actual.denominador / fraccion_actual.numerador)
            fracciones_egipcias.append(Fraccion(1, denominador_egipcio))
            fraccion_actual = fraccion_actual - Fraccion(1, denominador_egipcio)

        return fracciones_egipcias

    def __str__(self):
        return ' + '.join([str(fraccion) for fraccion in self.fracciones_egipcias])

# Ejemplos de todas las operaciones
frac1 = Fraccion(3, 4)
frac2 = Fraccion(1, 2)
frac3 = Fraccion(2, 3)

print("Operaciones simples de fracciones:")
print(f"Suma: {frac1} + {frac2} = {frac1 + frac2}")
print(f"Resta: {frac1} - {frac3} = {frac1 - frac3}")
print(f"Multiplicación: {frac1} * {frac2} = {frac1 * frac2}")
print(f"División: {frac1} / {frac3} = {frac1 / frac3}")

print("\nConversión a fracciones egipcias:")
egipcio1 = FraccionEgipcia(frac1)
print(f"{frac1} en fraccion egipcias: {egipcio1}")

egipcio2 = FraccionEgipcia(frac3)
print(f"{frac3} en fraccion egipcias: {egipcio2}")
