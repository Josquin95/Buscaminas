package co.edu.icesi.modelo;

public class CeldaVacia extends CeldaBuilder {

    //------------------------------------------------
    // CONSTANTES
    //------------------------------------------------

    /**
     * Constante con el estado vacio
     */
    public final static String ESTADO_VACIO = "VACIO";

    /**
     * Constante indentificando si la celda no tiene una mina
     */
    public final static boolean NO_TIENE_MINA = false;

    /**
     * Numero de minas adyacentes
     */
    public final static int ADYANCENTES = 0;

    //---------------------------------------------------
    // SERVICIOS
    //---------------------------------------------------

    /**
     * Configura una celda segun su tipo
     */
    @Override
    public void configurarCelda(int numero) {
        celda.setTapada(true);
        celda.setMina(NO_TIENE_MINA);
        celda.setMinasAdyacentes(ADYANCENTES);
        celda.setEstado(ESTADO_VACIO);
    }
}