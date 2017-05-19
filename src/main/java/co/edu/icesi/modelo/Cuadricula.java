package co.edu.icesi.modelo;

/**
 * Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public class Cuadricula implements ICuadricula, Cloneable {

    /**
     * Estandar de casillas para obtener el ratio de minas por cuadricula
     */
    public final static int ESTANDAR_CASILLAS = 64;

    /**
     * Nuemero de casillas por defecto
     */
    public final static int NUMERO_DEFECTO_CASILLAS = 8;

    /**
     * Matriz de celdas
     */
    protected CeldaBuilder[][] celdas;

    protected CeldaBuilder[][] celdasEspectador;

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
        this.numeroCeldas = NUMERO_DEFECTO_CASILLAS;
        inicializarCeldas();
    }

    public Cuadricula(int numeroCeldas) {
        this.numeroCeldas = numeroCeldas;
        inicializarCeldas();
    }

    /**
     * Se encarga de crear una matriz con celdas vacias
     */
    public void inicializarCeldas() {
        celdas = new CeldaBuilder[numeroCeldas][numeroCeldas];
        celdasEspectador = new CeldaBuilder[numeroCeldas][numeroCeldas];
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas.length; j++) {
                // Al inicializar por defecto todas son vacias
                celdas[i][j] = new CeldaVacia();
                celdas[i][j].crearCelda();
                celdas[i][j].configurarCelda(0);

                celdasEspectador[i][j] = new CeldaVacia();
                celdasEspectador[i][j].crearCelda();
                celdasEspectador[i][j].configurarCelda(0);

            }
        }
        crearMinas();
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
            celdasEspectador[posX][posY] = celdaMina;
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
        }
    }

    /**
     * Se encarga de calcular cuantas minas por cuadricula deben existir
     *
     * @return numero de minas que se deben poner en la cuadricula
     */
    public int ratioMinas() {
        double ratio = ((double) numeroCeldas / ESTANDAR_CASILLAS) * 100;
        return (int) Math.round(ratio);
    }

    /**
     * Algoritmo floodFill, se encargara de despejar las casillas vacias
     * una vez seleccionada una determinada casilla vacia.
     *
     * @param arr matriz de celdas
     * @param r   posicion de fila de la celda en la cuadricula.
     * @param c   posicion de columna de la celda en la cuadricula.
     */
    public void fillGrid(CeldaBuilder[][] arr, int r, int c) {
        if (r >= 0 && r < numeroCeldas) {
            if (c >= 0 && c < numeroCeldas) {
                int numeroMinas = obtenerCelda(false, r, c).getMinasAdyacentes();
                boolean tapada = arr[r][c].getCelda().isTapada();
                if (numeroMinas == 0 && tapada) {
                    arr[r][c].getCelda().setTapada(false);
                    celdasEspectador[r][c].getCelda().setTapada(false);
                    fillGrid(arr, r + 1, c);
                    fillGrid(arr, r - 1, c);
                    fillGrid(arr, r, c + 1);
                    fillGrid(arr, r, c - 1);
                }
            }
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
    public void minasAdyacentes(int i, int j) {
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
     * Se encarga obtener la celda
     * <b> Precondicion: </b> se debe crear e incializar la matriz de celdas.
     * <b> Poscondicion: </b> las celdas poseen su respectivo numero de minas adyacentes.
     */

    public Celda obtenerCelda(boolean celda, int i, int j) {
        if (celda) {
            return celdasEspectador[i][j].getCelda();
        }
        return celdas[i][j].getCelda();
    }

    public int getNumeroCeldas() {
        return numeroCeldas;
    }

    public CeldaBuilder[][] getCeldas() {
        return celdas;
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
                CeldaBuilder celdaBuilder = celdas[i][j];
                Celda celda = celdaBuilder.getCelda();
                if (celda.isMina()) {
                    minasAdyacentes(i, j);
                }
            }
        }
    }

    public void destaparCelda(int x, int y) {
        CeldaBuilder celdaBuilder = celdas[x][y];
        celdaBuilder.getCelda().setTapada(false);

        celdaBuilder = celdasEspectador[x][y];
        celdaBuilder.getCelda().setTapada(false);
    }

    public void setNumeroCeldas(int numeroCeldas) {
        this.numeroCeldas = numeroCeldas;
    }

}