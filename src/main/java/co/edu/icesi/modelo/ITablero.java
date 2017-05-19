package co.edu.icesi.modelo;

import co.edu.icesi.vista.InterfazBuscaMinas;

/**
 * Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public interface ITablero {

    public void attach(InterfazBuscaMinas observer);

    public void destaparVacias(int x, int y);

    public boolean finJuego(int x, int y);

    public void bloquearTablero();

    public void iniciarTiempo();

    public String getTiempo();

    public void iniciarJuego(int i);

    public int getNumeroCeldas();

    public void setEtiqueta(int etiqueta, int x, int y);

    public int getEtiqueta(int x, int y);

    public boolean isCeldaTapada(boolean celda, int x, int y);

    public void destaparCelda(int x, int y);

    public void taparCeldas(int x, int y);

    public int ObternerValorCelda(boolean celda, int i, int j);

    public void notify(InterfazBuscaMinas observer);

    public void notifyAllObservers();

    public void stopTimer();

    public void actualizarContador();

    public Contador getContador();

    public void setTamamnio(int numero);

}
