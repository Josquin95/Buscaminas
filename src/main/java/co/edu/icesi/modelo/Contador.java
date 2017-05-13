package co.edu.icesi.modelo;

public class Contador {

    /**
     * Tiempo del juego
     */
    private long tiempo;

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

    /**
     * Constructor de la clase contador, crear el contador y reinicia los marcadores
     */
    public Contador() {
        reiniciarMarcador();
    }

    /**
     * Reinicia los marcadores del juego
     */
    public void reiniciarMarcador(){
        setTiempo(0);
        setMinas(0);
        setBanderas(0);
        setDestapadas(0);
        setInterrogantes(0);
    }

    public long getTiempo() {
        return this.tiempo;
    }

    /**
     * @param tiempo cambiar el tiempo del juego
     */
    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public int getMinas() {
        return this.minas;
    }

    /**
     * @param minas cambiar el numero de minas del marcador
     */
    public void setMinas(int minas) {
        this.minas = minas;
    }

    public int getBanderas() {
        return this.banderas;
    }

    /**
     * @param banderas cambiar el numero de banderas del marcador
     */
    public void setBanderas(int banderas) {
        this.banderas = banderas;
    }

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