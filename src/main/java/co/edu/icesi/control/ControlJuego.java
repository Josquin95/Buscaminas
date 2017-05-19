package co.edu.icesi.control;

import co.edu.icesi.modelo.Tablero;
import co.edu.icesi.vista.InterfazBuscaMinas;
import co.edu.icesi.vista.InterfazJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlJuego implements ActionListener {

    /**
     * Interfaz del juego
     */
    private InterfazBuscaMinas view;

    /**
     * Modelo del Juego
     */
    private Tablero model;

    /**
     * @param view
     * @param model
     */
    public ControlJuego(InterfazBuscaMinas view, Tablero model) {
        this.view = view;
        this.view.addActionListener(this);
        this.model = model;
    }

    public void iniciarVista() {
        //view.pack();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        boolean salir = false;
        for (int i = 0; i < model.getNumeroCeldas() && !salir; i++) {
            for (int j = 0; j < model.getNumeroCeldas() && !salir; j++) {
                if (comando.equals("CELDA[" + i + " " + j + "]")) {
                    model.destaparVacias(i, j);
                    model.destaparCelda(i, j);
                    salir = true;
                }
            }
        }
        view.update();
    }

    public static void main(String args[]) {
        Tablero model = new Tablero(true);
        InterfazJugador view = new InterfazJugador(model);
        ControlJuego control = new ControlJuego(view, model);
        control.iniciarVista();

    }
}