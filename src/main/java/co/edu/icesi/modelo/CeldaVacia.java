package co.edu.icesi.modelo;

public class CeldaVacia extends Celda {

    //------------------------------------------------
    // CONSTANTES
    //------------------------------------------------

    /**
     * Constante con el estado vacio
     */
    public final static String ESTADO_VACIO = "VACIO";

    //------------------------------------------------
    // PROPIEDADES
    //------------------------------------------------

    /**
     * Constructor de la celda vacia
     */
    public CeldaVacia() {
        setEstado(ESTADO_VACIO);
    }


}