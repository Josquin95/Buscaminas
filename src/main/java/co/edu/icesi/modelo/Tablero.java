package co.edu.icesi.modelo;

public class Tablero implements ITablero {

    //---------------------------------------------
    // SERVICIOS
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
        contador = Contador.getInstancia();
        if (jugador) {
            cuadricula = new CuadriculaJugador();
        } else {
            cuadricula = new CuadriculaEspectador();
        }
    }

    public Cuadricula getCuadricula() {
        return cuadricula;
    }

    public void setCuadricula(Cuadricula cuadricula) {
        this.cuadricula = cuadricula;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public void attach() {
        // TODO - implement Tablero.attach
        throw new UnsupportedOperationException();
    }



    public void floodFill() {
        // TODO - implement Tablero.floodFill

    }

}