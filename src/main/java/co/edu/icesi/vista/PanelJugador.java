package co.edu.icesi.vista;

import co.edu.icesi.modelo.JuegoFacade;

import javax.swing.*;
import java.awt.*;

public class PanelJugador extends InterfazBuscaMinas {

    /**
     * asaas
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

    /**
     * Panel que muestra el estado y las configuraciones iniciales del juego
     */
    private PanelEstado panelEstado;

    private JPanel panelInferior;

    /**
     * Constructor panel que se encarga de construir la interfaz de jugador
     */
    public PanelJugador(JuegoFacade modelo) {
        setTitle(NOMBRE_APP);
        setSize(ANCHO, LARGO);
        setResizable(false); // No se pemite la modificacion del tamaño
        setLocationRelativeTo(null); // Su posicion siempre sera en el centro
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        construirPaneles(modelo);
    }

    private void construirPaneles(JuegoFacade modelo) {
        panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Panel Superior"));
        add(panelSuperior, BorderLayout.NORTH);

        panelTablero = new PanelTablero(8); // TODO cambiar luego
        add(panelTablero, BorderLayout.CENTER);

        panelEstado = new PanelEstado(this, modelo);
        add(panelEstado, BorderLayout.EAST);

        panelInferior = new JPanel();
        add(panelInferior, BorderLayout.SOUTH);
    }

    @Override
    public void update() {

    }

    public static void main(String args[]) {
        JuegoFacade modelo = new JuegoFacade();
        PanelJugador panelJugador = new PanelJugador(modelo);
        panelJugador.setVisible(true);
    }
}