package co.edu.icesi.vista;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * @Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public abstract class InterfazBuscaMinas extends JFrame {

    public abstract void update();

    public abstract void addAction(MouseListener mouseListener);
}