package co.edu.icesi.modelo;

/**
 * Created by Josquin on 18/05/2017.
 */
public class CuadriculaJugador extends Cuadricula {

    /**
     * Metodo constructor, se encarga de crear la cuadricula con
     * el numero de celdas, minas y la cantidad de celdas con numero
     * de minas adyacentes.
     */
    public CuadriculaJugador() {
        super();
        inicializarNumeros();
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

    public static void main(String[] args) {
        Cuadricula temp = new CuadriculaJugador();
        temp.imprimirCuadricula();
        Tiempo tiempo = Tiempo.getInstancia();
        tiempo.setActivo(true);
        tiempo.run();

    }
}
