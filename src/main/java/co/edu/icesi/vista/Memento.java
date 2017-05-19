package co.edu.icesi.vista;

/**
 * Created by Carlos Torres on 18/05/2017.
 * clase que se encarga de guardar el tablero
 */
public class Memento {

    /**
     * Panel que contiene el tablero del juego
     */
    private PanelTablero tableroGuardado;

    /**
     * Constructor de la clase memento
     *
     * @param inicial
     */
    public Memento(PanelTablero inicial) {
        this.tableroGuardado = inicial;
    }

    /**
     * @return el panel del tablero guardado
     */
    public PanelTablero getTableroGuardado() {
        return tableroGuardado;
    }

    /**
     * @param tableroGuardado cambia el tablero guardado
     */
    public void setTableroGuardado(PanelTablero tableroGuardado) {
        this.tableroGuardado = tableroGuardado;
    }
}
