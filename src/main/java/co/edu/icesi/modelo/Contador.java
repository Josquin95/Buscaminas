package co.edu.icesi.modelo;

public class Contador extends Thread {

    //----------------------------------------
    // SERVICIOS
    //----------------------------------------

    /**
     * Instacia del singleton
     */
    private static Contador INSTANCIA = null;


    /**
     * Numero de minas que hay en el juego
     */
    private int minas;

    /**
     * Numero de banderas marcadas
     */
    private int banderas;

    /**
     * Numero de celdas destapadas
     */
    private int destapadas;

    /**
     * Numero de interrogantes marcados
     */
    private int interrogantes;

    //--------------------------------------------
    // CONSTRUCTOR
    //--------------------------------------------

    /**
     * Constructor de la clase contador, crear el
     * contador y reinicia los marcadores
     */
    private Contador() {
        destapadas = 0;
        reiniciarMarcador();
    }

    /**
     * Reinicia los marcadores del juego
     */
    public void reiniciarMarcador(){
        //setTiempo(0);
        setMinas(0);
        setBanderas(0);
        setDestapadas(0);
        setInterrogantes(0);
    }

    /**
     * creador sincronizado para protegerse de posibles problemas  multi-hilo
     */
    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Contador();
        }
    }

    /**
     * @return retorna la instancia del contador
     */
    public static Contador getInstancia() {
        if (INSTANCIA == null) createInstancia();
        return INSTANCIA;
    }

    /**
     * Crea la instancia del contador
     */
    private static void createInstancia() {
        if (INSTANCIA == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized (Contador.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCIA == null) {
                    INSTANCIA = new Contador();
                }
            }
        }
    }

    /**
     * El contador no se puede clonar
     *
     * @return No retorna nada
     * @throws CloneNotSupportedException La clase contador no soporta clonacion por ser un singleton
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * @return numero de minas que tiene el juego
     */
    public int getMinas() {
        return this.minas;
    }

    /**
     * @param minas cambiar el numero de minas del marcador
     */
    public void setMinas(int minas) {
        this.minas = minas;
    }

    /**
     * @return numero de banderas del juego
     */
    public int getBanderas() {
        return this.banderas;
    }

    /**
     * @param banderas cambiar el numero de banderas del marcador
     */
    public void setBanderas(int banderas) {
        this.banderas = banderas;
    }

    /**
     * @return numero de celdas destapadas
     */
    public int getDestapadas() {
        return this.destapadas;
    }

    /**
     * @param destapadas cambiar el numero de celdas destapadas del marcador
     */
    public void setDestapadas(int destapadas) {
        this.destapadas = destapadas;
    }

    public int getInterrogantes() {
        return this.interrogantes;
    }

    /**
     * @param interrogantes cambiar el numer de interrogantes en el marcador
     */
    public void setInterrogantes(int interrogantes) {
        this.interrogantes = interrogantes;
    }

}