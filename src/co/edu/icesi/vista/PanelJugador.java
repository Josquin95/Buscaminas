package co.edu.icesi.vista;

import java.awt.*;

public class PanelJugador extends InterfazBuscaMinas {

	public PanelJugador() {

		setSize(800,400);
		setResizable(true);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}

	@Override
	public void update() {

	}

	public static void main(String args[]){
		PanelJugador pnlJugador = new PanelJugador();
		pnlJugador.setVisible(true);
	}
}