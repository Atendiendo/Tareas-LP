%Hechos proveidos
cifrado([0,0], a).
cifrado([0,1], g).
cifrado([1,0], c).
cifrado([1,1], t).

%descrifrar
%Se van tomando los dos primeros elementos de la lista por descrifrar
%Luego se pregunta si estos se encuentra en la lista de hechos proveidos
%Y los guarda en ListaBases
%Se llama recursivamente a descifrar con el resto del mensaje
%La primera linea es para cuando la lista ya se vacia y asi se sale de
%la recursion
descifrar([], []).
descifrar([X,Y|Cola], [ListaBases|RestoLista]) :-
    cifrado([X,Y], ListaBases),
    descifrar(Cola, RestoLista).
