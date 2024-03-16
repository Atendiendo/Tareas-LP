public class Muralla extends Zona{
    private int vida;

    /*****
     * Constructor Muralla
     ******
     * Esta función, inicializa las variables de la clase Muralla
     * Llamando a su vez el constructor de la superclase Zona para inicializar
     * todas la variables necesarias
     ******
     * Input:
     * int vida: variable a asignar.
     ******
     * Returns:
     * No retorna nada debido a que es el constructor.
     *****/
    Muralla(int vida){
        super();
        this.vida = vida;
    }

    /*****
     * boolean TryRomper
     ******
     * Si la suma de los ataques de todos los pikinim es superior
     * a la vida de la muralla, esta se destruye.
     * Si no, solo se le resta a la vida de la muralla.
     ******
     * Input:
     *   Pikinim[] pikinims: arreglo de pikinims.
     ******
     * Returns:
     *   Se retorna true si se logra romper la muralla, en caso contrario false.
     *****/
    public boolean TryRomper(Pikinim[] pikinims){
        System.out.println("Te encuentras con una muralla, la cual te impide el paso");
        System.out.println("Reunes a todos tus pikinim y gritas: A LA CARGA!");
        int ataque_total = 0;
        for(int i = 0; i<3; i++){
            ataque_total += (pikinims[i].GetCantidad())*(pikinims[i].GetAtaque());
        }
        vida -= ataque_total;
        System.out.println("Tus pikinim logran hacer " + ataque_total + " de dano\n");
        if (vida <=0){
            System.out.println("Con un estruendo ensordecedor, los valientes pikinim logran derribar la muralla, permitiéndote así proseguir con tu aventura.\n");
            return true;
        }else {
            System.out.println("Lamentablemente la muralla parece ser mas fuerte de lo que esperabas");
            System.out.println("y los pikinim no logran romperla\n");
            return false;
        }
    }

    /*****
     * void Interactuar
     ******
     * Si la zona ya esta completada, se llama a interactuar de la superclase
     * en caso contrario, se llama a TryRomper, si esta da true
     * se deja la zona completada.
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
        } else if (TryRomper(pikinims)){
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
            return "Muralla: Vida=" + vida;
        }

    }
}
