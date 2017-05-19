package co.edu.icesi.modelo;

public class Tablero implements ITablero {

    //---------------------------------------------
    // PROPIEDADES
    //---------------------------------------------

    /**
     * Cuadriculas del juego
     */
    private Cuadricula cuadricula;

    /**
     * Contador del juego
     */
    private Contador contador;


    //---------------------------------------------
    // CONSTRUCTOR
    //---------------------------------------------

    /**
     * Constructor de la clase tablero, se encarga de
     * crear un tablero.
     */
    public Tablero(boolean jugador) {
        if (jugador) {
            cuadricula = new CuadriculaJugador();
        } else {
            cuadricula = new CuadriculaEspectador();
        }
    }

    //------------------------------------------------------
    // SERVICIOS
    //------------------------------------------------------

    public Cuadricula getCuadricula() {
        return cuadricula;
    }


    public Contador getContador() {
        return contador;
    }

    @Override
    public void attach() {

    }

    @Override
    public void destaparVacias(int x, int y) {
        cuadricula.fillGrid(cuadricula.getCeldas(), x, y);
    }

    @Override
    public boolean finJuego(int x, int y) {
        boolean fin = false;
        Celda celda = cuadricula.obtenerCelda(x, y);
        if (celda.getMinasAdyacentes() == 9 && celda.isTapada() == false) {
            fin = true;
        }
        if (contador.getDestapadas() == (getNumeroCeldas() - cuadricula.ratioMinas())) {
            fin = true;
        }
        return fin;
    }

    @Override
    public void iniciarJuego() {
        contador = Contador.getInstancia();
    }

    @Override
    public int getNumeroCeldas() {
        return cuadricula.getNumeroCeldas();
    }

    @Override
    public void setEtiqueta(int etiqueta, int x, int y) {
        cuadricula.obtenerCelda(x, y).setEtiqueta(etiqueta);
    }

    public int getEtiqueta(int x, int y) {
        return cuadricula.obtenerCelda(x, y).getEtiqueta();
    }

    public boolean isCeldaTapada(int x, int y) {
        return cuadricula.obtenerCelda(x, y).isTapada();
    }

    public void destaparCelda(int x, int y) {
        cuadricula.obtenerCelda(x, y).setTapada(false);
    }

    @Override
    public int ObternerValorCelda(int i, int j) {
        return cuadricula.obtenerCelda(i, j).getMinasAdyacentes();
    }

}