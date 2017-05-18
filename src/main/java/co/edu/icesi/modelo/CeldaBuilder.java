package co.edu.icesi.modelo;

/**
 * Created by Josquin on 17/05/2017.
 */
public abstract class CeldaBuilder {

    //----------------------------------------------------------
    // PROPIEDADES
    //----------------------------------------------------------
    /**
     * Instancia de la celda
     */
    protected Celda celda;

    //----------------------------------------------------------
    // SERVICIOS
    //----------------------------------------------------------

    /**
     * Configura una celda segun su tipo
     */
    public abstract void configurarCelda(int numero);

    /**
     * @return Un objeto de tipo celda
     */
    public Celda getCelda() {
        return celda;
    }

    /**
     * Cambia la celda
     */
    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    /**
     * Crea el objeto celda
     */
    public void crearCelda() {
        celda = new Celda();
    }

}
