public class Magenta extends Pikinim{
    /*****
     * Constructor Magenta
     ******
     * Esta función, inicializa las variables de la clase Magenta
     * Llamando a su vez el constructor de la superclase Pikinim para inicializar
     * todas la variables necesarias
     ******
     * Input:
     * No es requerido ningún parámetro.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Magenta(){
        super();
        SetAtaque(2);
        SetCapacidad(1);
    }

    /*****
     * void multiplicar
     ******
     * Implementacion de multiplicar para Magenta.
     ******
     * Input:
     *   int cantidad: cantidad a introducir en la formula.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void multiplicar(int cantidad){
        int cantidad_pikinim = GetCantidad();
        int ataque_pikinim = GetAtaque();
        int cantidad_aumentada = cantidad * ataque_pikinim;
        cantidad_pikinim += cantidad_aumentada;
        System.out.println("Los pikinim Magenta han aumentado su cantidad en: " + cantidad_aumentada + "\n");
        SetCantidad(cantidad_pikinim);
    }
}
