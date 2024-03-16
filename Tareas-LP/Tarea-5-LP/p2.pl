%Clave de la cerradura
cerradura(1,4,5,1,0).

%Hace una resta y devuelve el valor absoluto de esta.
resta_absoluto(X, Y, Resultado) :- X >= Y, Resultado is X - Y.
resta_absoluto(X, Y, Resultado) :- X < Y, Resultado is Y - X.
%Suma 5 numeros
suma(A,B,C,D,E,Resultado) :- Resultado is A+B+C+D+E.
%Division por 5
division(X,Resultado) :- Resultado is X/5.
%Verifica que tan cerca se encuentra la contraseña
cercania(X,Resultado) :- X = 0, Resultado = "Contraseña descubierta", !.
cercania(X,Resultado) :- X < 1, Resultado = "Cerca", !.
cercania(X,Resultado) :- X >= 1, Resultado = "Lejos", !.

%Ejecucion programa principal
verificar(X1, X2, X3, X4, X5, R) :-
    cerradura(Y1,Y2,Y3,Y4,Y5),
    resta_absoluto(Y1,X1,D1),
    resta_absoluto(Y2,X2,D2),
    resta_absoluto(Y3,X3,D3),
    resta_absoluto(Y4,X4,D4),
    resta_absoluto(Y5,X5,D5),
    suma(D1,D2,D3,D4,D5,S),
    division(S,E),
    cercania(E,R).
