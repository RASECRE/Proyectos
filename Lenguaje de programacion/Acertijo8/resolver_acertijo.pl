:- use_module(library(socket)).
:- use_module(library(lists)).

% Define initial and goal states for the Ace 8 puzzle
estado_inicial([[1, 2, 3], [4, 5, 6], [7, 8, a]]).
estado_objetivo([[1, 2, 3], [4, 5, 6], [7, a, 8]]).

% Define the solve predicate
resolver_ace8(EstadoInicial, Solucion) :-
    ace8(Solucion, EstadoInicial, [EstadoInicial]).

% Define the ace8 predicate for solving the puzzle
ace8([], Estado, _) :- estado_objetivo(Estado).
ace8([Movimiento | Movimientos], Estado, Visitados) :-
    movimiento_ace8(Estado, Movimiento),
    aplicar_movimiento_ace8(Estado, Movimiento, NuevoEstado),
    \+ member(NuevoEstado, Visitados),
    ace8(Movimientos, NuevoEstado, [NuevoEstado | Visitados]).

% Define possible moves for the Ace 8 puzzle
movimiento_ace8(Estado, izquierda) :- mover_izquierda(Estado, _).
movimiento_ace8(Estado, derecha) :- mover_derecha(Estado, _).
movimiento_ace8(Estado, arriba) :- mover_arriba(Estado, _).
movimiento_ace8(Estado, abajo) :- mover_abajo(Estado, _).

% Apply a move to the Ace 8 puzzle state
aplicar_movimiento_ace8(Estado, izquierda, NuevoEstado) :- mover_izquierda(Estado, NuevoEstado).
aplicar_movimiento_ace8(Estado, derecha, NuevoEstado) :- mover_derecha(Estado, NuevoEstado).
aplicar_movimiento_ace8(Estado, arriba, NuevoEstado) :- mover_arriba(Estado, NuevoEstado).
aplicar_movimiento_ace8(Estado, abajo, NuevoEstado) :- mover_abajo(Estado, NuevoEstado).

% Define moves for the Ace 8 puzzle
mover_izquierda([X, a | T], [a, X | T]).
mover_izquierda([H | T1], [H | T2]) :- mover_izquierda(T1, T2).

mover_derecha([a, X | T], [X, a | T]).
mover_derecha([H | T1], [H | T2]) :- mover_derecha(T1, T2).

mover_arriba([X | T1], [X | T2]) :- mover_arriba(T1, T2).
mover_arriba([X1, X2 | T], [X2, X1 | T]).

mover_abajo([X | T1], [X | T2]) :- mover_abajo(T1, T2).

% Inicia el servidor socket en el puerto 5000
servidor_ace8 :-
    tcp_socket(Socket),
    tcp_bind(Socket, 5000),
    tcp_listen(Socket, 5),
    writeln('Servidor de rompecabezas del 8 iniciado, esperando conexiones...'),
    aceptar_conexiones_ace8(Socket).

% Maneja las conexiones entrantes
aceptar_conexiones_ace8(Socket) :-
    tcp_accept(Socket, Client, _),
    writeln('Cliente conectado'),
    thread_create(procesar_solicitud_ace8(Client), _, [detached(true)]),
    aceptar_conexiones_ace8(Socket).

procesar_solicitud_ace8(Client) :-
    tcp_open_socket(Client, InStream, OutStream),
    read_term(InStream, EstadoInicial, [variable_names(Vars)]),
    writeln('Estado inicial recibido:'),
    writeln(EstadoInicial),
    resolver_ace8(EstadoInicial, Solucion),
    format(OutStream, "~w~n", [Solucion]),  % Envía la solución al cliente
    flush_output(OutStream),  % Asegura que los datos se envíen al cliente
    close(InStream),
    close(OutStream),
    writeln('Respuesta enviada al cliente'),
    tcp_close_socket(Client).

% Ejecutar el servidor
:- servidor_ace8.
