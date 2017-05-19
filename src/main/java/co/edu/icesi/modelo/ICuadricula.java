package co.edu.icesi.modelo;

/**
 * Created by Josquin on 19/05/2017.
 */
public interface ICuadricula {
    /**
     * Estandar de casillas para obtener el ratio de minas por cuadricula
     */
    public final static int ESTANDAR_CASILLAS = 64;

    /**
     * Nuemero de casillas por defecto
     */
    public final static int NUMERO_DEFECTO_CASILLAS = 8;

    /**
     * Se encarga de crear una matriz con celdas vacias
     */
    public void inicializarCeldas();

    /**
     * Se encarga de realizar el proceso de minado de la cuadricula,
     * esto se hace deacuerdo al ratio de minas permitido
     */
    public void crearMinas();

    /**
     * Se encarga de calcular cuantas minas por cuadricula deben existir
     *
     * @return numero de minas que se deben poner en la cuadricula
     */
    public int ratioMinas();

    /**
     * Algoritmo floodFill, se encargara de despejar las casillas vacias
     * una vez seleccionada una determinada casilla vacia.
     *
     * @param arr matriz de celdas
     * @param r   posicion de fila de la celda en la cuadricula.
     * @param c   posicion de columna de la celda en la cuadricula.
     */
    public void fillGrid(CeldaBuilder[][] arr, int r, int c);

    /**
     * Se encarga de calcular cuantas minas adyacentes tiene la
     * celda seleccionada.
     * <b> Precondicion: </b> se debe crear e inicializar una matriz con celdas vacias.
     * <b> Poscondicion: </b> se calcula el numero de minas adyacentes de la celda
     *
     * @param i numero de la fila de la celda
     * @param j numero de la columna de la celda.
     */
    public void minasAdyacentes(int i, int j);

    /**
     * Se encarga de analizar cuantas minas adyacentes hay por
     * cada celda.
     * <b> Precondicion: </b> se debe crear e incializar la matriz de celdas.
     * <b> Poscondicion: </b> las celdas poseen su respectivo numero de minas adyacentes.
     */
    //public abstract void inicializarNumeros();

    /**
     * Se encarga obtener la celda
     * <b> Precondicion: </b> se debe crear e incializar la matriz de celdas.
     * <b> Poscondicion: </b> las celdas poseen su respectivo numero de minas adyacentes.
     */

    public Celda obtenerCelda(boolean celda, int i, int j);

    public int getNumeroCeldas();

    public CeldaBuilder[][] getCeldas();


    /**
     * Se encarga de analizar cuantas minas adyacentes hay por
     * cada celda.
     * <b> Precondicion: </b> se debe crear e incializar la matriz de celdas.
     * <b> Poscondicion: </b> las celdas poseen su respectivo numero de minas adyacentes.
     */
    public void inicializarNumeros();

    public void destaparCelda(int x, int y);

    public void setNumeroCeldas(int numeroCeldas);


}
