package co.edu.icesi.modelo;

public class Contador {

    private long tiempo;
    private int minas;
    private int banderas;
    private int destapadas;
    private int interrogantes;

    public Contador() {
        // TODO - implement Contador.Contador
        throw new UnsupportedOperationException();
    }

    public long getTiempo() {
        return this.tiempo;
    }

    /**
     * @param tiempo
     */
    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public int getMinas() {
        return this.minas;
    }

    /**
     * @param minas
     */
    public void setMinas(int minas) {
        this.minas = minas;
    }

    public int getBanderas() {
        return this.banderas;
    }

    /**
     * @param banderas
     */
    public void setBanderas(int banderas) {
        this.banderas = banderas;
    }

    public int getDestapadas() {
        return this.destapadas;
    }

    /**
     * @param destapadas
     */
    public void setDestapadas(int destapadas) {
        this.destapadas = destapadas;
    }

    public int getInterrogantes() {
        return this.interrogantes;
    }

    /**
     * @param interrogantes
     */
    public void setInterrogantes(int interrogantes) {
        this.interrogantes = interrogantes;
    }

}