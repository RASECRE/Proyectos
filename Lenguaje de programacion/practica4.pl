% Estado objetivo del acertijo del 8
objetivo(1/2/3/4/5/6/7/8/0).

arriba(A/B/C/0/E/F/G/H/I, 0/B/C/A/E/F/G/H/I) :- true.
arriba(A/B/C/D/0/F/G/H/I, A/0/C/D/E/F/G/H/I) :- true.
arriba(A/B/C/D/E/0/G/H/I, A/B/0/D/E/C/G/H/I) :- true.

abajo(A/B/C/D/E/F/0/H/I, A/B/C/D/E/F/G/0/I) :- true.
abajo(A/B/C/D/E/F/G/0/I, A/B/C/D/E/F/G/H/0) :- true.
abajo(A/B/C/D/E/F/G/H/0, A/B/C/D/E/F/0/H/I) :- true.

izquierda(0/A/C/D/E/F/G/H/I, A/0/C/D/E/F/G/H/I) :- true.
izquierda(A/0/C/D/E/F/G/H/I, 0/A/C/D/E/F/G/H/I) :- true.
izquierda(A/B/0/D/E/F/G/H/I, A/0/B/D/E/F/G/H/I) :- true.

derecha(A/0/C/D/E/F/G/H/I, 0/A/C/D/E/F/G/H/I) :- true.
derecha(A/B/0/D/E/F/G/H/I, A/0/B/D/E/F/G/H/I) :- true.
derecha(A/B/C/D/E/F/G/0/H, A/B/C/D/E/F/G/H/0) :- true.

% Encuentra los próximos posibles estados
proximo(T, N):- arriba(T, N).
proximo(T, N):- abajo(T, N).
proximo(T, N):- izquierda(T, N).
proximo(T, N):- derecha(T, N).

% Función para mostrar el camino
despliegaCamino([]) :- nl.
despliegaCamino([H|T]):-
    despliega(H),
    nl,  % Nueva línea entre tableros
    despliegaCamino(T).
    
% Función para desplegar un tablero, muestra como se vera en la terminal
despliega(A/B/C/D/E/F/G/H/I):-
	pon(A),pon('|'),pon(B),pon('|'),pon(C),nl,
    pon('------'),nl,
	pon(D),pon('|'),pon(E),pon('|'),pon(F),nl,
    pon('------'),nl,
	pon(G),pon('|'),pon(H),pon('|'),pon(I),nl,!.

% Hace que el cero sea vacio
pon(X):- X = 0, write(' '), !.
pon(X):- write(X).

% Resuelve la solucion de la lista
resuelve(Ini):-
    objetivo(Obj),
    hazbusca(Ini, Obj, [Ini]).

% Proceso recursivo de búsqueda con depuración
hazbusca(Obj, Obj, Vis):-
    reverse(Vis, Path),
    despliegaCamino(Path), !.
    
hazbusca(Edo, Obj, Vis):-
    proximo(Edo, Nuevo),
    not(member(Nuevo, Vis)),
    hazbusca(Nuevo, Obj, [Nuevo|Vis]).

% Revisa si es elemento de la lista
member(X, [X|_]).
member(X, [_|Ys]):-
    member(X,Ys).

% Define el estado inicial del acertijo del 8
estado_inicial(2/8/3/1/6/4/7/0/5).

% Llama a la función resuelve con el estado inicial
:- estado_inicial(Ini), resuelve(Ini).
