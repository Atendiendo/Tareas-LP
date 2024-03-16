public class Pieza extends Zona implements ILevantar{
    private final int peso;

    /*****
     * Constructor Pieza
     ******
     * Esta función, inicializa las variables de la clase Pieza
     * Llamando a su vez el constructor de la superclase Zona para inicializar
     * todas la variables necesarias
     ******
     * Input:
     * int peso: variable a asignar.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Pieza(int peso){
        super();
        this.peso = peso;
    }

    /*****
     * void Levantar
     ******
     * Si la suma de las capacidades de todos los pikinim es superior
     * al peso de la pieza, lo levantan y se deja completada la zona
     ******
     * Input:
     *   Pikinim[] pikinims: arreglo de pikinims.
     ******
     * Returns:
     *   No se retorna nada ya que la función es de tipo void.
     *****/
    public void Levantar(Pikinim[] pikinims){
        System.out.println("Acabas de encontrar una pieza!!");
        int capacidad_total = 0;
        for(int i = 0; i<3; i++){
            capacidad_total += (pikinims[i].GetCantidad())*(pikinims[i].GetCapacidad());
        }
        if (capacidad_total >= peso){
            System.out.println("Con determinación y esfuerzo indomable, los pikinim han logrado levantar la pieza.\n");
            SetCompletada(true);
        } else {
            System.out.println("Los pikinim no han logrado leventar la pieza u.u\n");
        }

    }

    /*****
     * void Interactuar
     ******
     * Si la zona ya esta completada, se llama a interactuar de la superclase
     * en caso contrario, se llama a Levantar.
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
            Levantar(pikinims);
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
            return "Pieza: peso=" + peso;
        }
    }
}
