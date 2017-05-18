package co.edu.icesi.modelo;

/**
 * Created by Josquin on 17/05/2017.
 */
public class Tiempo extends Thread {

    //---------------------------------------
    // PROPIEDADES
    //---------------------------------------

    /**
     * Instacia del singleton
     */
    private static Tiempo INSTANCIA = null;

    /**
     * Transcurso de horas del juego
     */
    private int horas;

    /**
     * Transcurso de minutos del juego
     */
    private int minutos;

    /**
     * Transcurso de segundos del juego
     */
    private int segundos;

    /**
     * Transcurso de milesimas del juego
     */
    private int milesimas;

    /**
     * Cronometro
     */
    private String cronometro;

    private boolean activo;

    //---------------------------------------------
    // CONSTRUCTOR
    //---------------------------------------------

    /**
     * Constructor de la clase tiempo, es privado por
     * que es un singleton
     */
    private Tiempo() {
    }

    //----------------------------------------------
    // SERVICIOS
    //----------------------------------------------

    @Override
    public void run() {
        horas = 0;
        minutos = 0;
        segundos = 0;
        milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min = "", seg = "", mil = "";
        try {
            while (activo) {
                Thread.sleep(4);
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;

                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                //y las milesimas de segundo de nuevo a 0
                if (milesimas == 1000) {
                    milesimas = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos vuelven a 0
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                }

                //Esto solamente es estetica para que siempre este en formato
                //00:00:000
                if (minutos < 10) min = "0" + minutos;
                else min = minutos + "";
                if (segundos < 10) seg = "0" + segundos;
                else seg = segundos + "";

                if (milesimas < 10) mil = "00" + milesimas;
                else if (milesimas < 100) mil = "0" + milesimas;
                else mil = milesimas + "";

                //Colocamos en la etiqueta la informacion
                setCronometro(min + ":" + seg + ":" + mil);
            }
        } catch (Exception e) {
        }
        //Cuando se reincie se coloca nuevamente en 00:00:000
        setCronometro("00:00:000");
    }

    /**
     * creador sincronizado para protegerse de posibles problemas  multi-hilo
     */
    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Tiempo();
        }
    }

    /**
     * @return retorna la instancia del contador
     */
    public static Tiempo getInstancia() {
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
            synchronized (Tiempo.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCIA == null) {
                    INSTANCIA = new Tiempo();
                }
            }
        }
    }

    /**
     * @return proporciona las horas del juego
     */
    private int getHoras() {
        return horas;
    }

    /**
     * @param horas cambia las horas del juego
     */
    private void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * @return proporciona los minutos del juego
     */
    private int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos cambia los minutos del juego
     */
    private void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * @return proporciona los segundos del juego
     */
    private int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos cambia los segundos del juego
     */
    private void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    /**
     * @return proporciona las milesimas del juego
     */
    private int getMilesimas() {
        return milesimas;
    }

    /**
     * @param milesimas cambia las milesimas del juego
     */
    private void setMilesimas(int milesimas) {
        this.milesimas = milesimas;
    }

    /**
     * @return Un String con el tiempo que da el cronometro
     */
    public String getCronometro() {
        return cronometro;
    }

    /**
     * @param cronometro Cambia el tiempo que muestra el cronometro
     */
    private void setCronometro(String cronometro) {
        this.cronometro = cronometro;
    }

    /**
     * @return El estado del cronometro
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo cambia el estado del tiempo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
