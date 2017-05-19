package co.edu.icesi.vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * Created by Josquin on 11/05/2017.
 */
public class PanelEstado extends JPanel {

    //-------------------------------------------------------------
    // CONSTANTES
    //-------------------------------------------------------------
    /**
     * Constante con la etiqueta del tiempo
     */
    public final static String TIEMPO = "TIEMPO: ";

    /**
     * Constante con la etiqueta de minas
     */
    public final static String MINAS = "MINAS: ";

    /**
     * Constante con la etiqueta de banderas
     */
    public final static String BANDERAS = "BANDERAS: ";

    /**
     * Constante con la etiqueta de celdas destapadas
     */
    public final static String DESTAPADAS = "DESTAPADAS: ";

    /**
     * Constante con el tiempo cero
     */
    public final static String TIEMPO_CERO = "00:00:00.00";

    /**
     * Constante con el contador en cero
     */
    public final static String CONTADOR_CERO = "00";

    /**
     * Constante de accion del boton iniciar
     */
    public final static String INICIAR = "INICIAR";

    /**
     * Constante  de accion del boton cancelar
     */
    public final static String CANCELAR = "CANCELAR";

    //-----------------------------------------------------------
    // ATRIBUTOS
    //-----------------------------------------------------------

    /**
     * Etiqueta para el tiempo del juego
     */
    private JLabel lbTiempo;

    /**
     * Tiempo que transcurre en el juego
     */
    private JLabel txtTiempo;

    /**
     * Etiqueta para la cantidad de minas
     */
    private JLabel lbMinas;

    /**
     * Numero de minas
     */
    private JLabel txtMinas;

    /**
     * Etiqueta para la cantidad de celdas destapadas
     */
    private JLabel lbDestapadas;

    /**
     * Numero de casillas destapadas
     */
    private JLabel txtDestapadas;

    /**
     * Etiqueta para la cantidad de banderas
     */
    private JLabel lbBanderas;

    /**
     * Numero de banderas
     */
    private JLabel txtBanderas;

    /**
     * Etiqueta para la dificultad
     */
    private JLabel lbDificultad;

    /**
     * ComboBox con una lista de dificultad del juego
     */
    private JComboBox lstDificultad;

    /**
     * Boton que inicia el juego
     */
    private JButton btnIniciar;

    /**
     * Boton que cancela en juego
     */
    private JButton btnCancelar;


    //--------------------------------------------------------------
    // CONSTRUCTOR
    //--------------------------------------------------------------
    public PanelEstado(InterfazJugador view) {

        setLayout(new GridLayout(6, 2, 10, 50));
        setBorder(new TitledBorder("Estado: "));
        inicializarPanel();
    }

    //---------------------------------------------------------------
    // SERVICIOS
    //---------------------------------------------------------------

    /**
     * Se crea e inicializa todos los componentes del panel de estado
     */
    private void inicializarPanel() {

        lbTiempo = new JLabel(TIEMPO, SwingConstants.RIGHT);
        lbTiempo.setFont(lbTiempo.getFont().deriveFont(25.0f));
        txtTiempo = new JLabel(TIEMPO_CERO);
        txtTiempo.setFont(txtTiempo.getFont().deriveFont(25.0f));
        add(lbTiempo);
        add(txtTiempo);

        lbMinas = new JLabel(MINAS, SwingConstants.RIGHT);
        lbMinas.setFont(lbMinas.getFont().deriveFont(15.0f));
        txtMinas = new JLabel(CONTADOR_CERO);
        txtMinas.setFont(txtMinas.getFont().deriveFont(15.0f));
        add(lbMinas);
        add(txtMinas);

        lbBanderas = new JLabel(BANDERAS, SwingConstants.RIGHT);
        lbBanderas.setFont(lbBanderas.getFont().deriveFont(15.0f));
        txtBanderas = new JLabel(CONTADOR_CERO);
        txtBanderas.setFont(txtBanderas.getFont().deriveFont(15.0f));
        add(lbBanderas);
        add(txtBanderas);

        lbDestapadas = new JLabel(DESTAPADAS, SwingConstants.RIGHT);
        lbDestapadas.setFont(lbDestapadas.getFont().deriveFont(15.0f));
        txtDestapadas = new JLabel(CONTADOR_CERO);
        txtDestapadas.setFont(txtDestapadas.getFont().deriveFont(15.0f));
        add(lbDestapadas);
        add(txtDestapadas);

        lbDificultad = new JLabel("DIFICULTAD");
        add(lbDificultad);

        lstDificultad = new JComboBox();
        lstDificultad.addItem("Muy Facil");
        lstDificultad.addItem("Facil");
        lstDificultad.addItem("Normal");
        lstDificultad.addItem("Dificil");
        lstDificultad.addItem("Muy Dificil");
        add(lstDificultad);


        btnIniciar = new JButton("Iniciar");

        btnIniciar.setActionCommand(INICIAR);
        add(btnIniciar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        add(btnCancelar);
    }

    public void addActionListener(MouseListener mouseListener, ActionListener actionListener) {
        btnIniciar.addActionListener(actionListener);
        btnCancelar.addActionListener(actionListener);
    }

    public String getTxtTiempo() {
        return txtTiempo.getText();
    }

    public void setTxtTiempo(String txtTiempo) {
        this.txtTiempo.setText(txtTiempo);
    }

    public String getTxtMinas() {
        return txtMinas.getText();
    }

    public void setTxtMinas(String txtMinas) {
        this.txtMinas.setText(txtMinas);
    }

    public String getTxtDestapadas() {
        return txtDestapadas.getText();
    }

    public void setTxtDestapadas(String txtDestapadas) {
        this.txtDestapadas.setText(txtDestapadas);
    }

    public String getTxtBanderas() {
        return txtBanderas.getText();
    }

    public void setTxtBanderas(String txtBanderas) {
        this.txtBanderas.setText(txtBanderas);
    }

    public String selectItem() {
        return (String) lstDificultad.getSelectedItem();
    }


}
