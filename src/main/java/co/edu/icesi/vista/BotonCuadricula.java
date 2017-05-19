package co.edu.icesi.vista;

import javax.swing.*;

/**
 * Created by CarlosTorres on 18/05/2017.
 */
public class BotonCuadricula extends JButton {


    /**
     * Constante de imagen cero
     */
    public final static String CERO = "src/main/resources/imagenes/cero.png";

    /**
     * Constante de imagen uno
     */
    public final static String UNO = "src/main/resources/imagenes/uno.png";

    /**
     * Constante de imagen dos
     */
    public final static String DOS = "src/main/resources/imagenes/dos.png";

    /**
     * Constante de imagen tres
     */
    public final static String TRES = "src/main/resources/imagenes/tres.png";

    /**
     * Constante de imagen cuatro
     */
    public final static String CUATRO = "src/main/resources/imagenes/cuatro.png";

    /**
     * Constante de imagen cinco
     */
    public final static String CINCO = "src/main/resources/imagenes/cinco.png";

    /**
     * Constante de imagen seis
     */
    public final static String SEIS = "src/main/resources/imagenes/seis.png";

    /**
     * Constante de imagen siete
     */
    public final static String SIETE = "src/main/resources/imagenes/siete.png";

    /**
     * Constante de imagen ocho
     */
    public final static String OCHO = "src/main/resources/imagenes/ocho.png";

    /**
     * Constante de imagen mine
     */
    public final static String MINE = "src/main/resources/imagenes/mine.png";

    /**
     * Constante de imagen boom
     */
    public final static String BOOM = "src/main/resources/imagenes/mine.png"; //TODO aun no existe :C

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
    private ImageIcon image;

    /**
     * Tamanno de la matriz de botones
     */
    private int size;

    //------------------------------------------
    // CONSTRUCTOR
    //------------------------------------------

    /**
     * Constructor del boton de cuadricula
     *
     * @param posX posicion fila del boton
     * @param posY posicion columna del boton
     */
    public BotonCuadricula(int posX, int posY, int size) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
    }

    //-------------------------------------------
    // SERVICIOS
    //-------------------------------------------

    /**
     * Cambia la imagen de la celda
     * @param valor con el valor de la celda
     */
    public void setImageJuego(int valor) {
        try {
            String ruta = "";
            switch (valor) {
                case 0:
                    ruta = CERO;
                    break;
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
            int longitud = (int) ((double) (512 / size));
            image = new ImageIcon(((new ImageIcon(ruta).getImage().getScaledInstance(longitud, longitud, java.awt.Image.SCALE_SMOOTH))));
            this.setIcon(image);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @return posicion x del boton
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return posicion y del boton
     */
    public int getPosY() {
        return posY;
    }

}
