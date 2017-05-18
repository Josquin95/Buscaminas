package co.edu.icesi.modelo;

public class CeldaNumero extends CeldaBuilder {

    //-------------------------------------------------
    // CONSTANTES
    //-------------------------------------------------

    /**
     * Estado de la celda numero
     */
    public final static String ESTADO_NUMERO = "NUMERO";

    /**
     * Constante indentificando si la celda no tiene una mina
     */
    public final static boolean NO_TIENE_MINA = false;

    //-------------------------------------------------
    // PROPIEDADES
    //-------------------------------------------------

    /**
     * Configura una celda segun su tipo
     */
    @Override
    public void configurarCelda(int numero) {
        celda.setEstado(ESTADO_NUMERO);
        celda.setMina(NO_TIENE_MINA);
        celda.setMinasAdyacentes(numero);
    }

}