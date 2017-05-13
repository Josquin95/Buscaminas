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

    /**
     * Constante para determinar si la celda esta tapada
     */
    public final static boolean TAPADA = true;

    /**
     * Constante para determinar si la celda esta destapada
     */
    public final static boolean DESTAPADA = false;

    //--------------------------------------------------
    // PROPIEDADES
    //--------------------------------------------------

    /**
     * Estado de la celda (vacia, mina, numero)
     */
    private String estado;

    /**
     * Determina si la celda esta tapada
     */
    private boolean tapada;

    /**
     * Etiqueta de la celda
     */
    private int etiqueta;

    //-------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------
    /**
     * Constructor de la clase celda
     */
    public Celda() {
        setEtiqueta(SIN_ETIQUETA);
        setTapada(TAPADA);
    }

    //--------------------------------------------------
    // SERVICIOS
    //--------------------------------------------------


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

    /**
     * @return int con la etiqueta de la celda
     */
    public int getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta cambia el estado de la etiqueta
     */
    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
}