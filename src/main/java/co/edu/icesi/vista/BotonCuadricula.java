package co.edu.icesi.vista;

import javax.swing.*;

/**
 * Created by CarlosTorres on 18/05/2017.
 */
public class BotonCuadricula extends JButton {

    public int posX;

    public int posY;

    public BotonCuadricula(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
