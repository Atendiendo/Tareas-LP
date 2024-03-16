all: programa

programa: TreasureFinder.o Bomba.o Tablero.o
	gcc -g -o programa TreasureFinder.o Bomba.o Tablero.o

TreasureFinder.o: TreasureFinder.c Bomba.h Tierra.h Tablero.h
	gcc -c TreasureFinder.c

Bomba.o: Bomba.c Bomba.h Tierra.h Tablero.h
	gcc -c Bomba.c

Tablero.o: Tablero.c Bomba.h Tierra.h Tablero.h
	gcc -c Tablero.c

clean:
	rm -f programa *.o