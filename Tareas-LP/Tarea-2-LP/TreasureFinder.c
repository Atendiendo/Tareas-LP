#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

extern int cant_tesoros_total;
int cant_tesoros;

/*****
* int main
******
* Realiza el procesamiento principal del programa.
* Permite interactuar con el tablero y controlar el flujo del juego.
******
* Input:
*   int argc: Cantidad de argumentos en la línea de comandos.
*   char const *argv[]: Arreglo que contiene los argumentos que se ingresan en la línea de comandos.
******
* Returns:
*   int: Retorna 0 si no hay problemas en la ejecucion.
*****/
int main(int argc, char const *argv[]) {
    int tamaño_tablero;

    printf("¡Bienvenido a TreasureFinder!\n");
    printf("Indique el tamaño del tablero a jugar:\n");

    printf("1.7x7  2.10x10  3.12x12\n");
    printf("Su input: ");
    scanf("%d",&tamaño_tablero);


    switch (tamaño_tablero) {
    case 1:
        tamaño_tablero = 7;
        break;
    case 2:
        tamaño_tablero = 10;
        break;
    case 3:
        tamaño_tablero = 12;
        break;
    
    default:
    printf("Valor invalido\n");
        break;
    }

    IniciarTablero(tamaño_tablero);

    printf("\nEmpezando juego... ¡listo!\n\n");
    bool programa_en_curso = true, inicio = true;
    int turno = 1,accion = 0, fila, columna, tipo_bomba;
    while(programa_en_curso){
        if (inicio){
            printf("Tablero (Turno %d)\n",turno);
            MostrarTablero();
            printf("\n");
            inicio = false;
        }
        if (cant_tesoros==cant_tesoros_total){
            printf("GANASTE :D\n");
            programa_en_curso = false;
            break;
        }

        printf("Seleccione una accion:\n");
        printf("1.Colocar Bomba  2.Mostrar Bombas  3.Mostrar Tesoros  4.Cerrar juego\n");
        printf("Escoja una opcion: ");
        scanf("%d",&accion);
        printf("\n");

        switch (accion) {
        case 1:
           printf("Indique coordenadas de la bomba\n");
           printf("Fila: ");
           scanf("%d",&fila);
           printf("\nColumna: ");
           scanf("%d",&columna);
           printf("\nIndique forma en que explota la bomba\n");
           printf("1.Punto  2.X\n");
           printf("Su input: ");
           scanf("%d",&tipo_bomba);
           printf("\n");

           switch (tipo_bomba) {
           case 1:
            Bomba bomba_punto;
            bomba_punto.contador_turnos = 1;
            bomba_punto.explotar = ExplosionPunto;
            ColocarBomba(&bomba_punto,fila,columna);
            break;

           case 2:
            Bomba bomba_cruz;
            bomba_cruz.contador_turnos = 3;
            bomba_punto.explotar = ExplosionX;
            ColocarBomba(&bomba_cruz,fila,columna);
            break;
           }
            turno +=1;
            PasarTurno();
            printf("Tablero (Turno %d)\n",turno);
            MostrarTablero();
            printf("\n");

           
            break;
        case 2:
            MostrarBombas();
            break;
        case 3:
            VerTesoros();
            break;
        
        case 4:
            programa_en_curso = false;
            break;
        }


    }
    BorrarTablero();

    return 0;
}