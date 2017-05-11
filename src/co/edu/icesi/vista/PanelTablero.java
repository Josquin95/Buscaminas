package co.edu.icesi.vista;

import co.edu.icesi.control.ControlJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public class PanelTablero extends JPanel implements ActionListener{

    /**
     * Matriz de botones.
     */
    private JButton[][] btnCasillas;

    /**
     * Interfaz principal que se encarga de visualizar toda la informacion
     */
    private InterfazBuscaMinas view;

    /**
     * NONE
     */
    private ControlJuego control;

    /**
     * Constructor para la clase panel tablero, se encarga
     * de crear los elementos graficos del panel.
     * @param numeroBotones longitud de la matriz de botones.
     */
    public PanelTablero(int numeroBotones){
        setLayout(new GridLayout(numeroBotones,numeroBotones));
        inicializarPanel(numeroBotones);
    }

    /**
     * Se encarga de crear e inicialzar cada uno de los botones
     * del panel tablero para el juego buscaminas
     * @param numeroBotones longitud de la matriz de botones
     */
    private void inicializarPanel(int numeroBotones){
        btnCasillas = new JButton[numeroBotones][numeroBotones];
        for (int i = 0; i < numeroBotones; i++){
            for(int j = 0; j < numeroBotones; j++){
                btnCasillas[i][j] = new JButton();
                btnCasillas[i][j].addActionListener(this);
                add(btnCasillas[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

