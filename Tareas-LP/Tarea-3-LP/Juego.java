import java.util.Scanner;

public class Juego {
    /*****
     * int main
     ******
     * Realiza el procesamiento principal del programa.
     * Permite interactuar con el mapa y controlar el flujo del juego.
     ******
     * Input:
     *   String[] args: Arreglo que contiene los argumentos que se ingresan en la línea de comandos.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public static void main(String[] args) {
        Pikinim[] pikinims;
        pikinims = new Pikinim[3];

        pikinims[0] = new Cyan();
        pikinims[1] = new Magenta();
        pikinims[2] = new Amarillo();

        Zona[] mapa;
        mapa = new Zona[11];
        mapa[0] = new Pieza(50);
        mapa[1] = new Enemigo(130,20,25, true, "Este es una especie de hongo marron, con ojos saltones, colmillos y un ceno fruncido");
        mapa[2] = new Enemigo(50,10,15, true, "Esta criatura se asemeja a una especie de reptil, con ojos grandes y amarillos que emiten una luz siniestra, \ntiene una piel escamosa y pálida.");
        mapa[3] = new Pildora(25);
        mapa[4] = new Muralla(50);
        mapa[5] = new Pieza(100);
        mapa[6] = new Enemigo(45,8,10, true, "Este parece ser un humano, pero no se ve con buenas intenciones, este parece llevar en su cabeza una especie de piramide, \ntiene su vestimenta desgarrada, es alto y lleva una gran espada en la mano derecha.");
        mapa[7] = new Pieza(35);
        mapa[8] = new Pildora(15);
        mapa[9] = new Enemigo(75,15,20, true, "Esta criatura, parece ser una tortuga gigante con piel verde, cuernos, colmillos afilados, brazos musculosos, \nuna concha con pinchos y cejas gruesas");
        mapa[10] = new Muralla(150);


        System.out.println("\n¡Bienvenido a 'Mal Aterrizaje'!");
        System.out.println("Te despiertas solo en un planeta extrano");
        System.out.println("Lo ultimo que recuerdas es que estabas haciendo un viaje de rutina y de pronto todo se volvio negro...");
        System.out.println("Estas dentro de tu nave, la cual esta destrozada y inmediatamente te pones el tanque de oxigeno.");
        System.out.println("Afuera ves unas extranas criaturas de diferentes colores");
        System.out.println("Estas son pequenas y lo unico que repiten es 'pikinim' en una voz aguda");
        System.out.println("Decides salir de tu nave y acercarte a ellas, estas parecen inofensivas");
        System.out.println("Te dices a ti mismo: Quizas me pueden ayudar a encontrar las piezas para reparar mi nave");
        System.out.println("Sin embargo debes ser rapido, antes de que se te acabe el tanque de oxigeno\n");


        int turno = 1, turnos_totales = 30, PosJugador = 5, opcion, PiezasEncontradas = 0;
        Zona zona_izq, zona_der, zona_mid;
        String dir_muralla = "ninguna";
        Scanner input = new Scanner(System.in);

        boolean flag1 = true, flag2 = true, flag3 = true, pikinim_muertos = false;

        while((turno <= turnos_totales) && (PiezasEncontradas != 3) && (!pikinim_muertos)) {
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("Turno " + turno + " Piezas encontradas: " + PiezasEncontradas);
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("PIKINIMS");
            System.out.println("Cyan: cantidad= " + pikinims[0].GetCantidad() + " capacidad= " + pikinims[0].GetCapacidad() + " ataque= " + pikinims[0].GetAtaque() + "       ");
            System.out.println("Magenta: cantidad= " + pikinims[1].GetCantidad() + " capacidad= " + pikinims[1].GetCapacidad() + " ataque= " + pikinims[1].GetAtaque() + "    ");
            System.out.println("Amarillo: cantidad= " + pikinims[2].GetCantidad() + " capacidad= " + pikinims[2].GetCapacidad() + " ataque= " + pikinims[2].GetAtaque() + "   ");
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

            System.out.println("Tienes 3 opciones:");

            if (PosJugador == 10){
                zona_der = mapa[0];
            } else {
                zona_der = mapa[PosJugador+1];
            }
            if (PosJugador == 0){
                zona_izq = mapa[10];
            } else {
                zona_izq = mapa[PosJugador-1];
            }
            zona_mid = mapa[PosJugador];


            if ((mapa[PosJugador] instanceof Muralla) && (!mapa[PosJugador].GetCompletada()) && (dir_muralla.equals("izquierda"))){
                System.out.println("    1. La muralla te bloquea el paso!");
                System.out.println("    2. Ir a la izquierda (" + zona_izq + ")");
                System.out.println("    3. Quedarse aqui (" + zona_mid + ")");
                opcion = input.nextInt();
                while (opcion == 1){
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("No puedes atravesar murallas\n");
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("Turno " + turno + " Piezas encontradas: " + PiezasEncontradas);
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("PIKINIMS");
                    System.out.println("Cyan: cantidad= " + pikinims[0].GetCantidad() + " capacidad= " + pikinims[0].GetCapacidad() + " ataque= " + pikinims[0].GetAtaque() + "       ");
                    System.out.println("Magenta: cantidad= " + pikinims[1].GetCantidad() + " capacidad= " + pikinims[1].GetCapacidad() + " ataque= " + pikinims[1].GetAtaque() + "    ");
                    System.out.println("Amarillo: cantidad= " + pikinims[2].GetCantidad() + " capacidad= " + pikinims[2].GetCapacidad() + " ataque= " + pikinims[2].GetAtaque() + "   ");
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("Tienes 3 opciones:");
                    System.out.println("    1. La muralla te bloquea el paso!");
                    System.out.println("    2. Ir a la izquierda (" + zona_izq + ")");
                    System.out.println("    3. Quedarse aqui (" + zona_mid + ")");
                    opcion = input.nextInt();
                }
            } else if ((mapa[PosJugador] instanceof Muralla) && (!mapa[PosJugador].GetCompletada()) && (dir_muralla.equals("derecha"))){
                System.out.println("    1. Ir a la derecha (" + zona_der + ")");
                System.out.println("    2. La muralla te bloquea el paso!");
                System.out.println("    3. Quedarse aqui (" + zona_mid + ")");
                opcion = input.nextInt();
                while (opcion == 2){
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("No puedes atravesar murallas\n");
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("Turno " + turno + " Piezas encontradas: " + PiezasEncontradas);
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("PIKINIMS");
                    System.out.println("Cyan: cantidad= " + pikinims[0].GetCantidad() + " capacidad= " + pikinims[0].GetCapacidad() + " ataque= " + pikinims[0].GetAtaque() + "       ");
                    System.out.println("Magenta: cantidad= " + pikinims[1].GetCantidad() + " capacidad= " + pikinims[1].GetCapacidad() + " ataque= " + pikinims[1].GetAtaque() + "    ");
                    System.out.println("Amarillo: cantidad= " + pikinims[2].GetCantidad() + " capacidad= " + pikinims[2].GetCapacidad() + " ataque= " + pikinims[2].GetAtaque() + "   ");
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("Tienes 3 opciones:");
                    System.out.println("    1. Ir a la derecha (" + zona_der + ")");
                    System.out.println("    2. La muralla te bloquea el paso!");
                    System.out.println("    3. Quedarse aqui (" + zona_mid + ")");
                    opcion = input.nextInt();
                }
            } else {
                System.out.println("    1. Ir a la derecha (" + zona_der + ")");
                System.out.println("    2. Ir a la izquierda (" + zona_izq + ")");
                System.out.println("    3. Quedarse aqui (" + zona_mid + ")");
                opcion = input.nextInt();
            }



            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            switch (opcion){
                case 1:
                    PosJugador += 1;
                    dir_muralla = "izquierda";
                    if (PosJugador == 11){
                        PosJugador = 0;
                    }
                    break;
                case 2:
                    PosJugador -= 1;
                    dir_muralla = "derecha";
                    if (PosJugador == -1){
                        PosJugador = 10;
                    }
                    break;
                case 3:
                    if ((mapa[PosJugador] instanceof Muralla) && (mapa[PosJugador].GetCompletada())){
                        dir_muralla = "ninguna";
                    }

                    break;
            }

            System.out.println();

            mapa[PosJugador].Interactuar(pikinims);

            if ((pikinims[0].GetCantidad()==0) && (pikinims[1].GetCantidad()==0) && (pikinims[2].GetCantidad()==0)){
                pikinim_muertos = true;
            }

            if ((mapa[0].GetCompletada()) && (flag1)){
                flag1 = false;
                PiezasEncontradas += 1;
            } else if ((mapa[5].GetCompletada()) && (flag2)) {
                flag2 = false;
                PiezasEncontradas += 1;
            } else if ((mapa[7].GetCompletada()) && (flag3)){
                flag3 = false;
                PiezasEncontradas += 1;
            }


            turno += 1;
        }
        if (PiezasEncontradas == 3){
            System.out.println("Has logrado encontrar todas las piezas!");
            System.out.println("Con la ayuda de los pikinim, llevas todas las piezas devuelta a la nave");
            System.out.println("Despues de dias de estar trabajar en conjunto con las criaturas");
            System.out.println("finalmente logran reparar la nave lo suficiente como para volver a casa");
            System.out.println("Te despides de cada uno de los pikinim que te acompanaron en tu aventura");
            System.out.println("Con un nudo en la garganta, te subes a tu nave y, mientras te alejas, no puedes evitar que se te escape un lagrima.");
            System.out.println("-------------------FIN-------------------");
        } else if(pikinim_muertos){
            System.out.println("Ves como cada uno de tus pikinim estan muriendo en batalla");
            System.out.println("Decides unirte a la batalla y atacas al monstruo");
            System.out.println("Pero este es demasiado fuerte para ti y no puedes con el");
            System.out.println("El enemigo arrasa contigo y te quedas moribundo en el suelo");
            System.out.println("Lo ultimo que ves es a un pikinim arrastrandose hacia ti");
            System.out.println("Intentas extender tu brazo para alcanzarlo, pero no lo puedes mover, ya es demasiado tarde...");
            System.out.println("-------------------FIN-------------------");
        } else {
            System.out.println("Empiezas a sentir como cada vez mas cuesta respirar");
            System.out.println("Ademas, experimentas mareos y nauseas");
            System.out.println("Miras tus dedos, los cuales estan completamente morados");
            System.out.println("Empiezas a tener mucho sueno, hasta que todo se vuelve negro...");
            System.out.println("-------------------FIN-------------------");
        }
    }
}