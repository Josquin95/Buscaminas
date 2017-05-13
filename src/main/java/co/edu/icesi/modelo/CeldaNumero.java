package co.edu.icesi.modelo;

public class CeldaNumero extends Celda {

    //-------------------------------------------------
    // CONSTANTES
    //-------------------------------------------------

    /**
     * Estado de la celda numero
     */
    public final static String ESTADO_NUMERO = "NUMERO";

    //-------------------------------------------------
    // PROPIEDADES
    //-------------------------------------------------

    /**
     * Numero de minas adyacentes que contiene la celda
     */
    private int minasAdyacentes;

    //-------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------

    /**
     * Constructor de la clase celda numero
     */
    public CeldaNumero() {
        setEstado(ESTADO_NUMERO);
    }

    /**
     * @return Numero de minas adyacentes
     */
    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    /**
     * @param minasAdyacentes numero de minas a cambiar
     */
    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }

}