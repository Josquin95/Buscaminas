package co.edu.icesi.modelo;

import co.edu.icesi.vista.InterfazBuscaMinas;

/**
 * Created by Josquin on 18/05/2017.
 */
public interface ITablero {

    /**
     * @return Obtiene la cuadricula del juego
     */
    public Cuadricula getCuadricula();

    /**
     * @return Obtiene el contador del juego
     */
    public Contador getContador();

    /**
     * Marca cuando debe actualizarse las interfaces de la vista
     */
    public void attach(InterfazBuscaMinas observer);

    /**
     * Algoritmo que destapa las celdas vacias dada una posicion
     *
     * @param x posicion fila de la casilla selecionada
     * @param y posicion columna de la casilla selecionada
     */
    public void destaparVacias(int x, int y);

    /**
     * Termina el juego de buscaminas
     */
    public boolean finJuego(int x, int y);

    /**
     * Inicio del juego
     */
    public void iniciarJuego();

    /**
     * @return numero de celdas del juego
     */
    public int getNumeroCeldas();

    /**
     * @return Cambia la etiqueta de una casilla
     */
    public void setEtiqueta(int etiqueta, int x, int y);

    /**
     * Obtiene el valor de la celda
     *
     * @param i posicion fila de la cuadricula donde se encuentra la celda
     * @param j posicion columna de la cuadricula donde se encuentra la celda
     * @return valor de la celda
     */
    public int ObternerValorCelda(int i, int j);

}
