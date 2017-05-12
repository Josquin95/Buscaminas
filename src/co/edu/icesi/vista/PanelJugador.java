package co.edu.icesi.vista;

import javax.swing.*;
import java.awt.*;

public class PanelJugador extends InterfazBuscaMinas {

    /**
     * Ancho de la pantalla
     */
    public final static int ANCHO = 800;

    /**
     * Largo de la pantalla
     */
    public final static int LARGO = 600;

    /**
     * Nombre de la aplicacion
     */
    public final static String NOMBRE_APP = "Buscaminas";

    /**
     * Panel que contiene la matriz de botones
     */
    private PanelTablero panelTablero;


    private JPanel panelSuperior;
    private JPanel panelDerecho;
    private JPanel panelInferior;

    /**
     * Constructor panel que se encarga de construir la interfaz de jugador
     */
    public PanelJugador() {
        setTitle(NOMBRE_APP);
        setSize(ANCHO, LARGO);
        setResizable(false); // No se pemite la modificacion del tamaño
        setLocationRelativeTo(null); // Su posicion siempre sera en el centro
        setLayout(new BorderLayout());

        construirPaneles();
    }

    private void construirPaneles(){
        panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Panel Superior"));
        add(panelSuperior, BorderLayout.NORTH);

        panelTablero = new PanelTablero(8); // TODO cambiar luego
        add(panelTablero, BorderLayout.CENTER);

        panelDerecho = new JPanel();
        panelDerecho.add(new JLabel("Panel Derecho"));
        add(panelDerecho, BorderLayout.EAST);

        panelInferior = new JPanel();
        add(panelInferior, BorderLayout.SOUTH);
    }

    @Override
    public void update() {

    }

    public static void main(String args[]) {
        PanelJugador pnlJugador = new PanelJugador();
        pnlJugador.setVisible(true);
    }
}