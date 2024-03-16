public class Cyan extends Pikinim{
    /*****
     * Constructor Cyan
     ******
     * Esta función, inicializa las variables de la clase Cyan
     * Llamando a su vez el constructor de la superclase Pikinim para inicializar
     * todas la variables necesarias
     ******
     * Input:
     * No es requerido ningún parámetro.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Cyan(){
        super();
        SetAtaque(1);
        SetCapacidad(1);
    }

    /*****
     * void multiplicar
     ******
     * Implementacion de multiplicar para Cyan.
     ******
     * Input:
     *   int cantidad: cantidad a introducir en la formula.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void multiplicar(int cantidad){
        int cantidad_pikinim = GetCantidad();
        int cantidad_aumentada = cantidad * 3;
        cantidad_pikinim += cantidad_aumentada;
        System.out.println("Los pikinim Cyan han aumentado su cantidad en: " + cantidad_aumentada + "\n");
        SetCantidad(cantidad_pikinim);
    }
}
