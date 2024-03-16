abstract public class Pikinim {
    private int ataque;
    private int capacidad;
    private int cantidad;

    /*****
     * Constructor Pikinim
     ******
     * Esta función, inicializa las variables de la clase Pikinim
     ******
     * Input:
     * No es requerido ningún parámetro.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Pikinim(){
        cantidad = 10;
    }

    /*****
     * void SetCantidad
     ******
     * Funcion para poder definir la variable cantidad de la clase.
     ******
     * Input:
     *   int cantidad: cantidad a introducir en la variable.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void SetCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    /*****
     * void GetCantidad
     ******
     * Funcion para poder obtener la variable cantidad de la clase.
     ******
     * Input:
     *   No es requerido ningún parámetro.
     ******
     * Returns:
     *   int cantidad: variable cantidad de la clase.
     *****/
    public int GetCantidad(){
        return cantidad;
    }

    /*****
     * void SetAtaque
     ******
     * Funcion para poder definir la variable ataque de la clase.
     ******
     * Input:
     *   int ataque: ataque a introducir en la variable.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void SetAtaque(int ataque){
        this.ataque = ataque;
    }

    /*****
     * void GetAtaque
     ******
     * Funcion para poder obtener la variable ataque de la clase.
     ******
     * Input:
     *   No es requerido ningún parámetro.
     ******
     * Returns:
     *   int ataque: variable ataque de la clase.
     *****/
    public int GetAtaque(){
        return ataque;
    }

    /*****
     * void SetCapacidad
     ******
     * Funcion para poder definir la variable capacidad de la clase.
     ******
     * Input:
     *   int capacidad: capacidad a introducir en la variable.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void SetCapacidad(int capacidad){
        this.capacidad = capacidad;
    }

    /*****
     * void GetCapacidad
     ******
     * Funcion para poder obtener la variable capacidad de la clase.
     ******
     * Input:
     *   No es requerido ningún parámetro.
     ******
     * Returns:
     *   int capacidad: variable capacidad de la clase.
     *****/
    public int GetCapacidad(){
        return capacidad;
    }

    /*****
     * void disminuir
     ******
     * Reduce la variable cantidad de la clase.
     ******
     * Input:
     *   int cantidad: cantidad a disminuir.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void disminuir(int cantidad){
        this.cantidad -= cantidad;
    }

    /*****
     * void multiplicar
     ******
     * Recibe un entero cantidad y aumenta la cantidad de
     * Pikinim según la fórmula de cada color.
     ******
     * Input:
     *   int cantidad: cantidad a introducir en la formula.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    abstract public void multiplicar(int cantidad);
}
