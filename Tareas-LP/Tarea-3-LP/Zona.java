public class Zona {
    private boolean completada;

    /*****
     * Constructor Zona
     ******
     * Esta función, inicializa las variables de la clase Zona
     ******
     * Input:
     * No es requerido ningún parámetro.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Zona(){
        completada = false;
    }

    /*****
     * void GetCompletada
     ******
     * Funcion para poder obtener la variable completada de la clase.
     ******
     * Input:
     *   No es requerido ningún parámetro.
     ******
     * Returns:
     *   boolean completada: variable completada de la clase.
     *****/
    public boolean GetCompletada(){
        return completada;
    }

    /*****
     * void SetCompletada
     ******
     * Funcion para poder definir la variable completada de la clase.
     ******
     * Input:
     *   boolean completada: cantidad a introducir en la variable.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void SetCompletada(boolean completada){
        this.completada = completada;
    }

    /*****
     * void Interactuar
     ******
     * Imprime por consola que la zona ya esta completada
     ******
     * Input:
     *   Pikinim[] pikinims: arreglo de pikinims.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void Interactuar(Pikinim[] pikinims){
        System.out.println("No queda nada que hacer aquí\n");
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
        return "No queda nada por hacer en esta zona";
    }
}
