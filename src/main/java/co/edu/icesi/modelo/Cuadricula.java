package co.edu.icesi.modelo;

/**
 * @Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public class Cuadricula {

    /**
     * Estandar de casillas para obtener el ratio de minas por cuadricula
     */
    public final static int ESTANDAR_CASILLAS = 64;

    /**
     * Matriz de celdas
     */
    private Celda[][] celdas;

    /**
     * Longitud de la matriz de celdas
     */
    private int numeroCeldas;

    /**
     * Metodo constructor, se encarga de crear la cuadricula con
     * el numero de celdas, minas y la cantidad de celdas con numero
     * de minas adyacentes.
     *
     * @param numeroCeldas longitud de la matriz de celdas (matriz N x N)
     */
    public Cuadricula(int numeroCeldas) {
        this.numeroCeldas = numeroCeldas;
        inicializarCeldas();
        crearMinas();
        inicializarNumeros();
    }

    /**
     * Se encarga de crear una matriz con celdas vacias
     */
    public void inicializarCeldas() {
        celdas = new Celda[numeroCeldas][numeroCeldas];
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas.length; j++) {
                // Al inicializar por defecto todas son vacias
                celdas[i][j] = new CeldaVacia();
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

            Celda mina = new CeldaMina();
            //TODO Agregar el patron de state
            mina.setMinasAdyacentes(9);
            mina.setMina(true);

            celdas[posX][posY] = mina;
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
    private void minasAdyacentes(int i, int j) {
        int filas = numeroCeldas - 1;
        if (filas > 0) {
            int columnas = numeroCeldas - 1;
            for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, filas); x++) {
                for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, columnas); y++) {
                    if (x != i || y != j) {
                        Celda temp = celdas[x][y];
                        if (!temp.esMina()) {
                            int numero = temp.getMinasAdyacentes();
                            temp.setMinasAdyacentes(numero + 1);
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
    public void inicializarNumeros() {
        for (int i = 0; i < numeroCeldas; i++) {
            for (int j = 0; j < numeroCeldas; j++) {
                Celda temp = celdas[i][j];
                if (temp.esMina()) {
                    minasAdyacentes(i, j);
                }
            }
        }
    }

    /**
     * Metodo para imprimir la cuadricula por consola
     */
    private void imprimirCuadricula() {
        for (int i = 0; i < numeroCeldas; i++) {
            for (int j = 0; j < numeroCeldas; j++) {
                System.out.print(celdas[i][j].getMinasAdyacentes() + " ");
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
        if (arr[x][y].esMina()) {
            /* arr[r][c] = 'W'; */

            fillGrid(arr, r + 1, c);
            fillGrid(arr, r - 1, c);
            fillGrid(arr, r, c + 1);
            fillGrid(arr, r, c - 1);
        }
    }

    public static void main(String[] args) {
        Cuadricula temp = new Cuadricula(8);
        temp.imprimirCuadricula();

    }

}