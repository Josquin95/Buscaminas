package co.edu.icesi.vista;

import javax.swing.*;

/**
 * Created by 1143929085 on 18/05/2017.
 */
public class BotonCuadricula extends JButton {

    public int valor;

    public BotonCuadricula(int celda){
        this.valor=celda;
    }

    public void setValor(int celda) {
        this.valor = celda;
    }

    public int getValor() {
        return valor;
    }

}
