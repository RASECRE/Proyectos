:- consult('DBMovies.pl').

% Predicado para encontrar actores que han trabajado juntos en más de una película.
actores_juntos(Actor1, Actor2, Peliculas) :-
    % Usamos setof para obtener una lista ordenada de películas en las que ambos actores han trabajado
    setof(Pelicula, (actor(Pelicula, Actor1, _), actor(Pelicula, Actor2, _), Actor1 \= Actor2), Peliculas),
    % Contamos el número de películas en las que han trabajado juntos
    length(Peliculas, Count),
    % Si han trabajado juntos en más de una película, el predicado es verdadero
    Count > 1.

% Predicado para encontrar actores que hayan trabajado bajo la dirección del mismo director.
actores_por_director(Director, Actores) :-
    % Usamos setof para obtener una lista ordenada de actores que han trabajado bajo la dirección del director dado
    setof(Actor, Pelicula^(director(Pelicula, Director), (actor(Pelicula, Actor, _); actress(Pelicula, Actor, _))), Actores).

% Predicado para encontrar el actor con más actuaciones en un año.
actor_mas_activo(Year, MostActive) :-
    % Obtenemos una lista de todos los actores que han aparecido en películas de ese año
    findall(Actor, (actor(_, Actor, _); actress(_, Actor, _)), Actores),
    % Contamos el número de apariciones de cada actor en películas de ese año
    findall(Count-Actor, (
        member(Actor, Actores),
        findall(_, (actor(_, Actor, _); actress(_, Actor, _)), Apariciones),
        length(Apariciones, Count)
    ), Counts),
    % Ordenamos la lista de cuentas de forma descendente y obtenemos el actor con la cuenta más alta
    reverse(Counts, CountsInvertidos),
    sort(CountsInvertidos, CountsOrdenados),
    last(CountsOrdenados, MostActive).

% Predicado para encontrar actores comunes en dos películas de un director.
mismo_cuadro(Pelicula1, Pelicula2, ActoresComunes) :-
    % Obtenemos el director de ambas películas
    director(Pelicula1, Director),
    director(Pelicula2, Director),
    % Nos aseguramos de que las películas sean diferentes
    Pelicula1 \= Pelicula2,
    % Obtenemos una lista de actores que aparecen en ambas películas
    findall(Actor, (actor(Pelicula1, Actor, _), actor(Pelicula2, Actor, _)), ActoresComunes).

% Predicado para encontrar una conexión entre dos actores a través de un número de películas.
conexion(Actor1, Actor2, Camino) :-
    % Iniciamos la búsqueda del camino desde el primer actor
    path(Actor1, Actor2, [Actor1], Camino).
path(Actor1, Actor2, Visitados, Camino) :-
    % Si el primer actor no es igual al segundo actor
    Actor1 \= Actor2,
    % Encontramos una película en la que aparece el primer actor
    (actor(Pelicula, Actor1, _); actress(Pelicula, Actor1, _)),
    % Encontramos otro actor que aparece en la misma película
    (actor(Pelicula, SiguienteActor, _); actress(Pelicula, SiguienteActor, _)),
    % El segundo actor no es el mismo que el primero
    Actor1 \= SiguienteActor,
    % El siguiente actor no ha sido visitado anteriormente para evitar ciclos
    \+ member(SiguienteActor, Visitados),
    % Continuamos la búsqueda desde el siguiente actor
    path(SiguienteActor, Actor2, [SiguienteActor | Visitados], Camino).
% Si el primer actor es igual al segundo actor, hemos encontrado el camino
path(Actor, Actor, Visitados, Visitados).
