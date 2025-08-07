from collections import deque

def anchura(pacman, inicio, objetivo):
    cola = deque([(inicio, [])])

    while cola:
        posicion_actual, ruta = cola.popleft()
        ruta_nueva = ruta +[posicion_actual]

        print("Posicion actual:", posicion_actual)
        print("Ruta:", ruta_nueva)
        print("-" * 40)

        if posicion_actual == objetivo:
            return ruta_nueva
        
        children = pacman.get(posicion_actual, [])
        for child in children:
            cola.append((child, ruta_nueva))

    return None

# celdas (grafo)
celdas = {
    "A1": ["B1"],
    "B1": ["A1", "B2", "C1"],
    "C1": ["B1", "D1"],
    "D1": ["C1", "D2"],
    "D2": ["D1", "C2"],
    "C2": ["D2", "C3"],
    "C3": ["C2", "D3"],
    "D3": ["C3", "D4"],
    "D4": ["D3"],
    "B2": ["B1", "A2"],
    "A2": ["B2", "A3"],
    "A3": ["A2", "B3"],
    "B3": ["A3", "B4"],
    "B4": ["B3", "A4", "C4"],
    "C4": ["B4"],
    "A4": ["B4"]
}

destino = "A4"
origen = "A1"

ruta = anchura(celdas, origen, destino)

if ruta:
    print("Se encontro una ruta: ")
    print("-> ".join(ruta))
    print("Costo total de la ruta: ", len(ruta) -1)
else:
    print("No fue porisble encotrar una ruta entre los nodos.")

def inicio_profundidad_limitada(pacman, inicio, destino, profundidad_maxima):
    pila = []
    pila.append([inicio, 0, False, [inicio]])

    print("\nCelda:", inicio)
    print("Profundidad del árbol de búsqueda:", 0)
    print("Test", False)
    print("Ruta", [inicio])

    while pila:
        celda_actual, profundidad, llegar_a_destino, ruta = pila.pop(-1)

        if celda_actual == destino:
            return celda_actual, profundidad, True, ruta

        if profundidad < profundidad_maxima:
            vecinos = pacman[celda_actual]
            for vecino in vecinos:
                nueva_profundidad = profundidad + 1
                llegado = (vecino == destino)
                nueva_ruta = list(ruta)
                nueva_ruta.append(vecino)
                pila.append([vecino, nueva_profundidad, llegado, nueva_ruta])

                print("\nCelda:", vecino)
                print("Profundidad en el árbol de búsqueda:", nueva_profundidad)
                print("Test", llegado)
                print("Ruta", nueva_ruta)

    return None, None, False, None

origen ="A1"
destino = "D4"
profundidad_maxima = 5

# Buscar el camino utilizando búsqueda en anchura con profundidad limitada
celda_actual, profundidad, llegado_a_destino, ruta = inicio_profundidad_limitada(celdas, origen, destino, profundidad_maxima)

if celda_actual:
    print("\n\nNúmero de celda:", celda_actual)
    print("Profundidad del árbol de búsqueda:", profundidad)
    print("¿Llegado a la celda destino?", llegado_a_destino)
    print("Camino recorrido:", ruta)
else:
    print("No se encontró un camino desde la celda de origen a la celda de destino.")
