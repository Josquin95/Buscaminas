package co.edu.icesi.control;

import co.edu.icesi.modelo.Tablero;
import co.edu.icesi.vista.BotonCuadricula;
import co.edu.icesi.vista.InterfazBuscaMinas;
import co.edu.icesi.vista.InterfazJugador;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlJuego implements MouseListener {

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
        this.view.addAction(this);
        this.model = model;
    }

    public void iniciarVista() {
        //view.pack();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    public static void main(String args[]) {
        Tablero model = new Tablero(true);
        InterfazJugador view = new InterfazJugador(model);
        ControlJuego control = new ControlJuego(view, model);
        control.iniciarVista();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            BotonCuadricula boton = (BotonCuadricula) e.getComponent();
            int posX = boton.getPosX();
            int posY = boton.getPosY();
            model.destaparVacias(posX, posY);
            model.destaparCelda(posX, posY);
            view.update();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}