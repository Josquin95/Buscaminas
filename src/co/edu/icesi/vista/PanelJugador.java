package co.edu.icesi.vista;

import javax.swing.*;
import java.awt.*;

public class PanelJugador extends InterfazBuscaMinas {

    public final static int ANCHO = 800;
    public final static int LARGO = 600;

    private PanelTablero panelTablero;
    private JPanel panelSuperior;
    private JPanel panelDerecho;
    private JPanel panelInferior;

	public PanelJugador() {

	    setTitle("Buscaminas");
		setSize(ANCHO,LARGO);
		setResizable(true);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		panelSuperior = new JPanel();
		panelSuperior.add(new JLabel("Panel Superior"));
		add(panelSuperior, BorderLayout.NORTH);

		panelTablero = new PanelTablero(8); // TODO cambiar luego
        add(panelTablero,BorderLayout.CENTER);

        panelDerecho = new JPanel();
        panelDerecho.add(new JLabel("Panel Derecho"));
        add(panelDerecho,BorderLayout.EAST);

        panelInferior = new JPanel();
        add(panelInferior, BorderLayout.SOUTH);


	}

	@Override
	public void update() {

	}

	public static void main(String args[]){
		PanelJugador pnlJugador = new PanelJugador();
		pnlJugador.setVisible(true);
	}
}