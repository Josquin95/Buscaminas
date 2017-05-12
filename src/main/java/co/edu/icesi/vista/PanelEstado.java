package co.edu.icesi.vista;

import co.edu.icesi.modelo.JuegoFacade;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Josquin on 11/05/2017.
 */
public class PanelEstado extends JPanel implements ActionListener {

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
    public final static String DESTAPADAS = "CELDAS DESTAPADAS: ";

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
    private JTextField txtTiempo;

    /**
     * Etiqueta para la cantidad de minas
     */
    private JLabel lbMinas;

    /**
     * Numero de minas
     */
    private JTextField txtMinas;

    /**
     * Etiqueta para la cantidad de celdas destapadas
     */
    private JLabel lbDestapadas;

    /**
     * Numero de casillas destapadas
     */
    private JTextField txtDestapadas;

    /**
     * Etiqueta para la cantidad de banderas
     */
    private JLabel lbBanderas;

    /**
     * Numero de banderas
     */
    private JTextField txtBanderas;

    /**
     * Etiqueta para la dificultad
     */
    private JLabel lbDificultad;

    /**
     * Checklist con una lista de dificultad del juego
     */
    private JList lstDificultad;

    /**
     * Boton que inicia el juego
     */
    private JButton btnIniciar;

    /**
     * Boton que cancela en juego
     */
    private JButton btnCancelar;

    /**
     * Conexion con el Jframe
     */
    private InterfazBuscaMinas view;

    //--------------------------------------------------------------
    // CONSTRUCTOR
    //--------------------------------------------------------------
    public PanelEstado(InterfazBuscaMinas view, JuegoFacade modelo) {
        this.view = view;

        setLayout(new GridLayout(6, 2));
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
        crearMarcadores(lbTiempo, TIEMPO, txtTiempo, TIEMPO_CERO);
        crearMarcadores(lbMinas, MINAS, txtMinas, CONTADOR_CERO);
        crearMarcadores(lbBanderas, BANDERAS, txtBanderas, CONTADOR_CERO);
        crearMarcadores(lbDestapadas, DESTAPADAS, txtDestapadas, CONTADOR_CERO);

        lbDificultad = new JLabel("DIFICULTAD");
        add(lbDificultad);

        lstDificultad = new JList();
        add(lstDificultad);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnIniciar.setActionCommand(INICIAR);
        add(btnIniciar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand(CANCELAR);
        add(btnCancelar);
    }

    /**
     * Crea la etiqueta y su respectivo marcador
     *
     * @param label     JLabel que se desea crear e inicializar
     * @param lbNombre  Nombre de la etiqueta
     * @param txtfiel   JTextField que se desea crear e inciializar, el txtfield no puede
     *                  ser editable por el usuario
     * @param txtNombre Nomnde del textfiel
     */
    private void crearMarcadores(JLabel label, String lbNombre, JTextField txtfiel, String txtNombre) {
        label = new JLabel(lbNombre);
        txtfiel = new JTextField(txtNombre);
        txtfiel.setEditable(false);

        this.add(label);
        this.add(txtfiel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
