package co.edu.icesi.modelo;

import co.edu.icesi.vista.InterfazBuscaMinas;

import java.util.ArrayList;

/**
 * Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public class Tablero implements ITablero {

    //---------------------------------------------
    // PROPIEDADES
    //---------------------------------------------

    /**
     * Cuadriculas del juego
     */
    private ICuadricula cuadricula;

    /**
     * Contador del juego
     */
    private Contador contador;

    /**
     * Tiempo del juego
     */
    private Tiempo tiempo;

    /**
     * ArrayList con las interfaces que dependen de la logica
     */
    private ArrayList<InterfazBuscaMinas> observers;

    private int numeroCeldas;

    //---------------------------------------------
    // CONSTRUCTOR
    //---------------------------------------------

    /**
     * Constructor de la clase tablero, se encarga de
     * crear un tablero.
     */
    public Tablero() {
        cuadricula = new Cuadricula();
        cuadricula.inicializarNumeros();

        observers = new ArrayList<>();
        contador = Contador.getInstancia();
        tiempo = Tiempo.getInstancia();
        tiempo.setTablero(this);
    }

    //------------------------------------------------------
    // SERVICIOS
    //------------------------------------------------------

    @Override
    public void attach(InterfazBuscaMinas observer) {
        observers.add(observer);
    }

    @Override
    public void destaparVacias(int x, int y) {
        cuadricula.fillGrid(cuadricula.getCeldas(), x, y);
    }

    @Override
    public boolean finJuego(int x, int y) {
        boolean fin = false;
        Celda celda = cuadricula.obtenerCelda(false, x, y);
        if (celda.getMinasAdyacentes() == 9 && celda.isTapada() == false) {
            fin = true;
            bloquearTablero();
            tiempo.setActivo(false);
        }
        if (contador.getDestapadas() == (getNumeroCeldas() - cuadricula.ratioMinas())) {
            fin = true;
            bloquearTablero();
            tiempo.setActivo(false);
        }
        return fin;
    }

    @Override
    public void bloquearTablero() {
        for (int i = 0; i < getNumeroCeldas(); i++) {
            for (int j = 0; j < getNumeroCeldas(); j++) {
                destaparCelda(i, j);
            }
        }
    }

    @Override
    public void iniciarTiempo() {
        tiempo.setActivo(true);
        tiempo.run();
    }

    @Override
    public String getTiempo() {
        return tiempo.getCronometro();
    }


    @Override
    public void iniciarJuego(int numeroCeldas) {
        cuadricula = new Cuadricula(numeroCeldas);
        cuadricula.inicializarCeldas();
        cuadricula.inicializarNumeros();
    }

    @Override
    public int getNumeroCeldas() {
        return cuadricula.getNumeroCeldas();
    }

    @Override
    public void setEtiqueta(int etiqueta, int x, int y) {
        cuadricula.obtenerCelda(false, x, y).setEtiqueta(etiqueta);
    }

    @Override
    public int getEtiqueta(int x, int y) {
        return cuadricula.obtenerCelda(false, x, y).getEtiqueta();
    }

    @Override
    public boolean isCeldaTapada(boolean celda, int x, int y) {
        return cuadricula.obtenerCelda(celda, x, y).isTapada();
    }

    @Override
    public void destaparCelda(int x, int y) {
        cuadricula.destaparCelda(x, y);
        cuadricula.destaparCelda(x, y);
    }

    @Override
    public void taparCeldas(int x, int y) {
        cuadricula.obtenerCelda(false, x, y).setTapada(true);
    }

    @Override
    public int ObternerValorCelda(boolean celda, int i, int j) {
        return cuadricula.obtenerCelda(celda, i, j).getMinasAdyacentes();
    }

    @Override
    public void notify(InterfazBuscaMinas observer) {
        observer.update();
    }

    @Override
    public void notifyAllObservers() {
        for (InterfazBuscaMinas observer : observers) {
            observer.update();
        }
    }

    public void notifyReinicio() {
        for (InterfazBuscaMinas observer : observers) {
            //  observer.refrescarPanelTablero();
        }
    }

    public Contador getContador() {
        return contador;
    }

    public void actualizarContador() {
        int banderas = 0;
        int destapadas = 0;
        int minas = 0;
        for (int i = 0; i < getNumeroCeldas(); i++) {
            for (int j = 0; j < getNumeroCeldas(); j++) {
                Celda celda = cuadricula.obtenerCelda(false, i, j);
                banderas += (celda.getEtiqueta() == 1) ? 1 : 0;
                destapadas += (celda.isTapada() == false) ? 1 : 0;
            }

        }
        minas = cuadricula.ratioMinas();
        contador.setBanderas(banderas);
        contador.setDestapadas(destapadas);
        contador.setMinas(minas);
    }

    public void stopTimer() {
        tiempo.setActivo(false);
    }

    public void setTamamnio(int numero) {
        this.numeroCeldas = numero;
        cuadricula.setNumeroCeldas(numero);
    }

}