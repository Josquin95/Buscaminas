package co.edu.icesi.modelo;

/**
 * Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public abstract class Cuadricula {

    /**
     * Estandar de casillas para obtener el ratio de minas por cuadricula
     */
    public final static int ESTANDAR_CASILLAS = 4;

    /**
     * Matriz de celdas
     */
    protected CeldaBuilder[][] celdas;

    /**
     * Longitud de la matriz de celdas
     */
    protected int numeroCeldas;

    /**
     * Metodo constructor, se encarga de crear la cuadricula con
     * el numero de celdas, minas y la cantidad de celdas con numero
     * de minas adyacentes.
     */
    public Cuadricula() {
        this.numeroCeldas = ESTANDAR_CASILLAS;
        inicializarCeldas();
        crearMinas();
    }

    /**
     * Se encarga de crear una matriz con celdas vacias
     */
    public void inicializarCeldas() {
        celdas = new CeldaBuilder[numeroCeldas][numeroCeldas];
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas.length; j++) {
                // Al inicializar por defecto todas son vacias
                celdas[i][j] = new CeldaVacia();
                celdas[i][j].crearCelda();
                celdas[i][j].configurarCelda(0);
            }
        }
    }

    /**
     * Se encarga de realizar el proceso de minado de la cuadricula,
     * esto se hace deacuerdo al ratio de minas permitido
     */
    public void crearMinas() {
        int cantidaMinas = ratioMinas();

        System.out.println("Ratio de minas: " + cantidaMinas);

        for (int i = 0; i < cantidaMinas; i++) {
            int posX = (int) (Math.random() * (numeroCeldas - 1));
            int posY = (int) (Math.random() * (numeroCeldas - 1));

            //System.out.println(posX + " <-> " + posY);

            CeldaBuilder celdaMina = new CeldaMina();
            celdaMina.crearCelda();
            celdaMina.configurarCelda(9);

            celdas[posX][posY] = celdaMina;
        }
    }



    /**
     * Metodo para imprimir la cuadricula por consola
     */
    protected void imprimirCuadricula() {
        for (int i = 0; i < numeroCeldas; i++) {
            for (int j = 0; j < numeroCeldas; j++) {
                System.out.print(celdas[i][j].getCelda().getMinasAdyacentes() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Se encarga de calcular cuantas minas por cuadricula deben existir
     *
     * @return numero de minas que se deben poner en la cuadricula
     */
    private int ratioMinas() {
        double ratio = ((double) numeroCeldas / ESTANDAR_CASILLAS) * 100;
        return (int) Math.round(ratio);
    }

    /**
     * Algoritmo floodFill, se encargara de despejar las casillas vacias
     * una vez seleccionada una determinada casilla vacia.
     *
     * @param arr matriz de celdas
     * @param x   posicion de fila de la celda en la cuadricula.
     * @param y   posicion de columna de la celda en la cuadricula.
     */
    private void fillGrid(Celda[][] arr, int x, int y) {
        int r = 0;
        int c = 0;
        if (arr[x][y].isMina()) {
            /* arr[r][c] = 'W'; */

            fillGrid(arr, r + 1, c);
            fillGrid(arr, r - 1, c);
            fillGrid(arr, r, c + 1);
            fillGrid(arr, r, c - 1);
        }
    }

    /**
     * Se encarga de calcular cuantas minas adyacentes tiene la
     * celda seleccionada.
     * <b> Precondicion: </b> se debe crear e inicializar una matriz con celdas vacias.
     * <b> Poscondicion: </b> se calcula el numero de minas adyacentes de la celda
     *
     * @param i numero de la fila de la celda
     * @param j numero de la columna de la celda.
     */
    protected void minasAdyacentes(int i, int j) {
        int filas = numeroCeldas - 1;
        if (filas > 0) {
            int columnas = numeroCeldas - 1;
            for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, filas); x++) {
                for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, columnas); y++) {
                    if (x != i || y != j) {
                        Celda celda = celdas[x][y].getCelda();
                        String mina = celda.getEstado();
                        if (!celda.isMina()) {
                            int numero = celda.getMinasAdyacentes();
                            celdas[x][y] = new CeldaNumero();
                            celdas[x][y].setCelda(celda);
                            celdas[x][y].configurarCelda(numero + 1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Se encarga de analizar cuantas minas adyacentes hay por
     * cada celda.
     * <b> Precondicion: </b> se debe crear e incializar la matriz de celdas.
     * <b> Poscondicion: </b> las celdas poseen su respectivo numero de minas adyacentes.
     */
    public abstract void inicializarNumeros();

    /**
     * Se encarga obtener el valor que tiene cada celda
     * <b> Precondicion: </b> se debe crear e incializar la matriz de celdas.
     * <b> Poscondicion: </b> las celdas poseen su respectivo numero de minas adyacentes.
     */

    public int obtenerValoresCelda(int i,int j){


        int valorCelda=0;

                valorCelda=celdas[i][j].getCelda().getMinasAdyacentes();
        return valorCelda;

    }

    public int getNumeroCeldas() {
        return numeroCeldas;
    }

}