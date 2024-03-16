public class Amarillo extends Pikinim{
    /*****
     * Constructor Amarillo
     ******
     * Esta función, inicializa las variables de la clase Amarillo
     * Llamando a su vez el constructor de la superclase Pikinim para inicializar
     * todas la variables necesarias
     ******
     * Input:
     * No es requerido ningún parámetro.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Amarillo(){
        super();
        SetAtaque(1);
        SetCapacidad(3);
    }

    /*****
     * void multiplicar
     ******
     * Implementacion de multiplicar para Amarillo.
     ******
     * Input:
     *   int cantidad: cantidad a introducir en la formula.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void multiplicar(int cantidad){
        int cantidad_pikinim = GetCantidad();
        int cantidad_aumentada = (int) Math.ceil(cantidad * 1.5);
        cantidad_pikinim += cantidad_aumentada;
        System.out.println("Los pikinim Amarillo han aumentado su cantidad en: " + cantidad_aumentada + "\n");
        SetCantidad(cantidad_pikinim);
    }
}
