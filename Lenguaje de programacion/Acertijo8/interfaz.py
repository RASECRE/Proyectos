import socket
import sys
from tkinter import *
import tkinter as tk

# Función para desplegar el nuevo estado recibido del servidor Prolog
def desplegar_estado(cad):
    numeros = cad.split('/')
    for i in range(3):
        for j in range(3):
            num = int(numeros[i * 3 + j])
            if num != 0:
                listaEtiqs[num].grid(row=i, column=j)
            else:
                listaEtiqs[num].grid_forget()

# Función para resolver el acertijo paso a paso
def siguiente_paso_prolog():
    try:
        # Enviar el estado actual del rompecabezas al servidor Prolog
        estado_actual = '/'.join(str(i) for i in l)  # Obtener el estado actual del rompecabezas
        s.sendall(f'{estado_actual}\n'.encode())  # Enviar el estado actual como una cadena de números separados por '/'
        print('Estado inicial enviado al servidor Prolog:', estado_actual)
        
        # Recibir la respuesta del servidor Prolog
        respuesta = s.recv(1024).decode('ascii')
        
        # Verificar si la respuesta contiene números
        if respuesta:
            print("Nuevo estado recibido desde el servidor Prolog:", respuesta)
            # Actualizar la interfaz gráfica con el nuevo estado
            desplegar_estado(respuesta)
        else:
            print('Error en la respuesta del servidor Prolog:', respuesta)
    except socket.error as e:
        print('Error al enviar o recibir datos desde el servidor Prolog:', e)

# Crear ventana raíz
raiz = Tk()
raiz.title("Acertijo del 8")

# Crear un frame
frm = tk.Frame(raiz)
frm.grid(columnspan=4, rowspan=5)

# Leer imágenes
listaNums = [None] * 9
listaEtiqs = [None] * 9

# Cargar las imágenes (cero como espacio vacío)
for i in range(len(listaNums)):
    if i == 0:
        listaNums[i] = PhotoImage()  # Imagen en blanco o transparente
    else:
        listaNums[i] = PhotoImage(file=f'imgs/{i}.png')
    listaEtiqs[i] = tk.Label(frm, image=listaNums[i])

# Crear un socket TCP/IP
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Definir el host y el puerto del servidor Prolog
host = 'localhost'
port = 5000

# Crear socket y conectar al servidor Prolog
try:
    print(f'Conectándose al servidor {host} en el puerto {port}')
    s.connect((host, port))
    print('Conexión establecida con éxito')
except socket.error as e:
    print(f'Error al conectarse al servidor: {e}')
    sys.exit()

# Botones y etiquetas adicionales
tk.Button(frm, text='Termina', command=raiz.destroy).grid(column=0, row=4)
tk.Button(frm, text='Siguiente', command=siguiente_paso_prolog).grid(column=1, row=4)
resultado_label = tk.Label(frm, text="")
resultado_label.grid(column=2, row=4, columnspan=2)

# Definir la lista desordenada
l = [1, 2, 3, 4, 5, 6, 7, 0,8]  # Cambiamos el orden

# Mostrar el rompecabezas inicial
for i in range(3):  # Renglón
    for j in range(3):  # Columna
        num = l[i * 3 + j]
        listaEtiqs[num].grid(row=i, column=j)

# Iniciar la interfaz gráfica
raiz.mainloop()
