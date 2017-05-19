package co.edu.icesi.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by CarlosTorres on 18/05/2017.
 */
public class MigestorDecorador implements ActionListener {

    private InterfazJugador interfazJugador;

    public MigestorDecorador(InterfazJugador interfaz) {
        this.interfazJugador = interfaz;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == interfazJugador.getItemPrimero()) {
            try {
                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            } catch (Exception u) {
                u.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(interfazJugador);
            interfazJugador.validate();
        }


        if (e.getSource() == interfazJugador.getItemSegundo()) {
            try {
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            } catch (Exception u) {
                u.printStackTrace();
            }

            SwingUtilities.updateComponentTreeUI(interfazJugador);
            interfazJugador.validate();
        }
        if (e.getSource() == interfazJugador.getReiniciar()) {
            interfazJugador.setPanelTablero(interfazJugador.getCopiaModelo().getTableroGuardado());
            interfazJugador.getPanelTablero().refrescarTablero(interfazJugador.getModelo());
            interfazJugador.update();
        }
    }
}
