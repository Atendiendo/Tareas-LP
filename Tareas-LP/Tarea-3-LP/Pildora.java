import java.util.Scanner;

public class Pildora extends Zona{
    private final int cantidad;

    /*****
     * Constructor Pildora
     ******
     * Esta función, inicializa las variables de la clase Pildora
     * Llamando a su vez el constructor de la superclase Zona para inicializar
     * todas la variables necesarias
     ******
     * Input:
     * int cantidad: variable a asignar.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Pildora(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    /*****
     * void Interactuar
     ******
     * Si la zona ya esta completada, se llama a interactuar de la superclase
     * en caso contrario, se le pide al usuario que color de
     * pikinim desea aumentar y posteriormente se llama a multiplicar
     * del color elegido con la cantidad de pildoras como parametro
     ******
     * Input:
     *   Pikinim[] pikinims: arreglo de pikinims.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void Interactuar(Pikinim[] pikinims){
        if (GetCompletada()){
            super.Interactuar(pikinims);
        }else {
            System.out.println("De repente te encuentras con unas pequenas pildoras en el suelo");
            System.out.println("Decides darselas a tus pikinim because why not");
            System.out.println("Ingrese el color de pikinim que desea multiplicar");
            System.out.println("1.Cyan 2.Magenta 3.Amarillo");
            Scanner input = new Scanner(System.in);

            int color_pikinim = input.nextInt();

            switch (color_pikinim){
                case 1:
                    pikinims[0].multiplicar(cantidad);
                    break;
                case 2:
                    pikinims[1].multiplicar(cantidad);
                    break;
                case 3:
                    pikinims[2].multiplicar(cantidad);
                    break;
            }
            SetCompletada(true);
        }


    }

    /*****
     * String toString
     ******
     * Da una descripcion de la clase
     ******
     * Input:
     *   No es requerido ningún parámetro.
     ******
     * Returns:
     *   Descripcion de los atributos de la clase.
     *****/
    public String toString() {
        if (GetCompletada()){
            return super.toString();
        } else {
            return "Pildora: cantidad=" + cantidad;
        }

    }
}
