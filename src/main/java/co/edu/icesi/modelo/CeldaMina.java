package co.edu.icesi.modelo;

public class CeldaMina extends Celda {

    //----------------------------------------------
    // CONSTANTE
    //----------------------------------------------
    /**
     * Constante con el estado de la celda (MINA)
     */
    public final static String ESTADO_MINA = "MINA";

    /**
     * Constante indentificando si la celda tiene una mina
     */
    public final static boolean TIENE_MINA = true;

    /**
     * Constante identificando si la celda no tiene una mina
     */
    public final static boolean NO_TIENE_MINA = false;

    //----------------------------------------------
    // PROPIEDADES
    //----------------------------------------------
    /**
     * Determina si la celda contiene una mina
     */
    private boolean mina;

    //----------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------

    /**
     * Constructor de la clase celdeMina
     */
    public CeldaMina() {
        setEstado(ESTADO_MINA);
        setMina(TIENE_MINA);
    }

    //-----------------------------------------------
    // SERVICIOS
    //-----------------------------------------------

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

}