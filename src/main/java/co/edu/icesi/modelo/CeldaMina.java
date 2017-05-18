package co.edu.icesi.modelo;

public class CeldaMina extends CeldaBuilder {

    //-----------------------------------------------
    // CONSTANTES
    //-----------------------------------------------
    /**
     * Constante con el estado de la celda (MINA)
     */
    public final static String ESTADO_MINA = "MINA";

    /**
     * Constante indentificando si la celda tiene una mina
     */
    public final static boolean TIENE_MINA = true;

    /**
     * Numero de minas adyacentes
     */
    public final static int ADYANCENTES = 9;

    //-----------------------------------------------
    // SERVICIOS
    //-----------------------------------------------

    /**
     * Configura una celda segun su tipo
     */
    @Override
    public void configurarCelda(int numero) {
        celda.setMina(TIENE_MINA);
        celda.setMinasAdyacentes(ADYANCENTES);
        celda.setEstado(ESTADO_MINA);
    }
}