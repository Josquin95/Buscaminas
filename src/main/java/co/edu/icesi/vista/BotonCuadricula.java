package co.edu.icesi.vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * Created by CarlosTorres on 18/05/2017.
 */
public class BotonCuadricula extends JButton {


    /**
     * Constante de imagen uno
     */
    public final static String UNO = "C:/Users/Josquin/Documents/BuscaMinas/Buscaminas/recursos/uno.png";

    /**
     * Constante de imagen dos
     */
    public final static String DOS = "Buscaminas/recursos/dos.png";

    /**
     * Constante de imagen tres
     */
    public final static String TRES = "//recursos/tres.png";

    /**
     * Constante de imagen cuatro
     */
    public final static String CUATRO = "//recursos/cuatro.png";

    /**
     * Constante de imagen cinco
     */
    public final static String CINCO = "imagenes/cinco.png";

    /**
     * Constante de imagen seis
     */
    public final static String SEIS = "imagenes/seis.png";

    /**
     * Constante de imagen siete
     */
    public final static String SIETE = "imagenes/siete.png";

    /**
     * Constante de imagen ocho
     */
    public final static String OCHO = "imagenes/ocho.png";

    /**
     * Constante de imagen mine
     */
    public final static String MINE = "imagenes/mine.png";

    /**
     * Constante de imagen boom
     */
    public final static String BOOM = "imagenes/mine.png"; //TODO aun no existe :C

    /**
     * Posicion x del boton
     */
    private int posX;

    /**
     * Posicion y del boton
     */
    private int posY;

    /**
     * Imagen que contiene el boton
     */
    private Image image;

    //------------------------------------------
    // CONSTRUCTOR
    //------------------------------------------

    /**
     * Constructor del boton de cuadricula
     *
     * @param posX posicion fila del boton
     * @param posY posicion columna del boton
     */
    public BotonCuadricula(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    //-------------------------------------------
    // SERVICIOS
    //-------------------------------------------

    /**
     *
     */
    public void setImageJuego(int valor) {
        try {
            String ruta = "";
            switch (valor) {
                case 1:
                    ruta = UNO;
                    break;
                case 2:
                    ruta = DOS;
                    break;
                case 3:
                    ruta = TRES;
                    break;
                case 4:
                    ruta = CUATRO;
                    break;
                case 5:
                    ruta = CINCO;
                    break;
                case 6:
                    ruta = SEIS;
                    break;
                case 7:
                    ruta = SIETE;
                    break;
                case 8:
                    ruta = OCHO;
                    break;
                case 9:
                    ruta = MINE;
                    break;
            }
            Image img = ImageIO.read(getClass().getResource(ruta));
            this.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
