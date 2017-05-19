package co.edu.icesi.vista;

import co.edu.icesi.control.ControlJuego;
import co.edu.icesi.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * @Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public class PanelTablero extends JPanel {

    /**
     * Largo del panel
     */
    public final static int LARGO = 600;

    /**
     * Ancho del panel
     */
    public final static int ANCHO = 600;

    /**
     * Matriz de botones.
     */
    private BotonCuadricula[][] btnCasillas;

    /**
     * Interfaz principal que se encarga de visualizar toda la informacion
     */
    private InterfazBuscaMinas view;

    /**
     * NONE
     */
    private ControlJuego control;

    /**
     * Numero de botones a crear
     */
    private int numeroBotones;

    /**
     * Constructor para la clase panel tablero, se encarga
     * de crear los elementos graficos del panel.
     *
     * @param numeroBotones longitud de la matriz de botones.
     */
    public PanelTablero(int numeroBotones, Tablero tablero) {
        this.numeroBotones = numeroBotones;
        setLayout(new GridLayout(numeroBotones, numeroBotones));
        inicializarPanel(numeroBotones,tablero);
    }

    /**
     * Se encarga de crear e inicialzar cada uno de los botones
     * del panel tablero para el juego buscaminas
     *
     * @param numeroBotones longitud de la matriz de botones
     */
    private void inicializarPanel(int numeroBotones, Tablero tablero) {
        setSize(LARGO, ANCHO);
        btnCasillas = new BotonCuadricula[numeroBotones][numeroBotones];
        for (int i = 0; i < numeroBotones; i++) {
            for (int j = 0; j < numeroBotones; j++) {
                btnCasillas[i][j] = new BotonCuadricula(i, j, numeroBotones);
                btnCasillas[i][j].setActionCommand("CELDA[" + i + " " + j + "]");
                add(btnCasillas[i][j]);
            }
        }
        refrescarBotones(tablero);
    }

    public void addAction(MouseListener mouseListener) {
        for (int i = 0; i < numeroBotones; i++) {
            for (int j = 0; j < numeroBotones; j++) {
                btnCasillas[i][j].addMouseListener(mouseListener);
            }
        }
    }


    /**
     * Refresca los botones del tablero
     *
     * @param tablero clase facade del mundo
     */
    public void refrescarBotones(Tablero tablero) {
        for (int i = 0; i < numeroBotones; i++) {
            for (int j = 0; j < numeroBotones; j++) {
                int etiqueta = tablero.getEtiqueta(i, j);
                boolean destapada = tablero.isCeldaTapada(i, j);
                int numero = tablero.ObternerValorCelda(i, j);
                String valor = (numero == 0) ? " " : numero + "";
                if (!destapada && etiqueta == 0) {
                    btnCasillas[i][j].setEnabled(destapada);
                    // btnCasillas[i][j].setText(valor);
                    btnCasillas[i][j].setImageJuego(numero);
                }
                if (etiqueta == 0 && destapada) {
                    btnCasillas[i][j].setText("");
                    btnCasillas[i][j].setIcon(null);
                    btnCasillas[i][j].setEnabled(true);
                }
                if (etiqueta == 1 && destapada) {
                    btnCasillas[i][j].setText("B");
                }
                if (etiqueta == 2 && destapada) {
                    btnCasillas[i][j].setText("I");
                }
            }
        }
    }

    public void refrescarTablero(Tablero tablero) {
        for (int i = 0; i < numeroBotones; i++) {
            for (int j = 0; j < numeroBotones; j++) {
                tablero.taparCeldas(i, j);
                refrescarBotones(tablero);
            }
        }
    }
}

