package co.edu.icesi.modelo;

public abstract class Celda {

    //---------------------------------------------------
    // CONSTANTES
    //---------------------------------------------------

    /***
     * Constante de la etiqueta de la celda
     */
    public final static int SIN_ETIQUETA = 0;

    /**
     * Constante de la etiqueta de la celda
     */
    public final static int BANDERA = 1;

    /**
     * Constante de la etiqueta de la celda
     */
    public final static int INTERROGANTE = 2;

    //--------------------------------------------------
    // PROPIEDADES
    //--------------------------------------------------

    /**
     * Estado de la celda (vacia, mina, numero)
     */
    private String estado;

    /**
     * Numero de minas adyacentes que contiene la celda
     */
    private int minasAdyacentes;

    /**
     * Determina si la celda contiene una mina
     */
    private boolean mina;

    /**
     * Determina si la celda esta tapada
     */
    private boolean tapada;

    /**
     * Etiqueta de la celda
     */
    private String etiqueta;

    //-------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------
    /**
     * Constructor de la clase celda
     */
    public Celda() {
        minasAdyacentes = 0;
    }

    //--------------------------------------------------
    // SERVICIOS
    //--------------------------------------------------

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

    /**
     * @return boolean que determina si la celda contiene una mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param tieneMina cambia el estado de la celda
     */
    public void setMina(boolean tieneMina) {
        this.mina = tieneMina;
    }

    /**
     * @return String con el estado de la celda
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado cambia el estado de la celda
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return Determina si la celda esta tapada o no
     */
    public boolean isTapada() {
        return tapada;
    }

    /**
     * @param tapada cambia el estado de la celda, si esta tapada o no.
     */
    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }
}