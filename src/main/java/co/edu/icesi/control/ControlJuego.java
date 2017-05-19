package co.edu.icesi.control;

import co.edu.icesi.modelo.Celda;
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
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    public static void main(String args[]) {
        Tablero model = new Tablero();
        InterfazJugador view = new InterfazJugador(model, false);
        InterfazJugador view2 = new InterfazJugador(model, true);
        view2.setTitle("Espectador");
        model.attach(view);
        model.attach(view2);
        ControlJuego control = new ControlJuego(view, model);
        ControlJuego control2 = new ControlJuego(view2, model);
        control.iniciarVista();
        control2.iniciarVista();
        model.iniciarTiempo();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getComponent() instanceof JButton) {

        }
        if (e.getComponent() instanceof BotonCuadricula) {
            BotonCuadricula boton = (BotonCuadricula) e.getComponent();
            int posX = boton.getPosX();
            int posY = boton.getPosY();
            int etiqueta = model.getEtiqueta(posX, posY);

            if (e.getButton() == MouseEvent.BUTTON1) {
                if (etiqueta == 0) {
                    model.destaparVacias(posX, posY);
                    model.destaparCelda(posX, posY);
                }
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                if (etiqueta == 0) {
                    model.setEtiqueta(Celda.BANDERA, posX, posY);
                }
                if (etiqueta == 1) {
                    model.setEtiqueta(Celda.INTERROGANTE, posX, posY);
                }
                if (etiqueta == 2) {
                    model.setEtiqueta(Celda.SIN_ETIQUETA, posX, posY);
                }
            }
            model.notifyAllObservers();
            if (model.finJuego(posX, posY)) {
                System.out.println("Game Over");
            }
        }
        model.notifyAllObservers();
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