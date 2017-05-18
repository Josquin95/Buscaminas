package co.edu.icesi.vista;

import co.edu.icesi.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazJugador extends InterfazBuscaMinas {

    /**
     * Ancho de la pantalla ss
     */
    public final static int ANCHO = 800;

    /**
     * Largo de la pantalla
     */
    public final static int LARGO = 600;

    /**
     * Nombre de la aplicacion
     */
    public final static String NOMBRE_APP = "Buscaminas";

    /**
     * Panel que contiene la matriz de botones
     */
    private PanelTablero panelTablero;
    /**
     * Menu para la personilización
     */
    private JMenuBar barraMenu;
    /**
     * Menu para la personilización de la configuración
     */
    private JMenu menuConfiguracion;
    /**
     * item desde donde se podra realizar la configuración de la personalización
     */
    private JMenu itemConfiguracion;

    private JMenuItem itemPrimero;
    private JMenuItem itemSegundo;


    private JPanel panelSuperior;

    /**
     * Panel que muestra el estado y las configuraciones iniciales del juego
     */
    private PanelEstado panelEstado;

    private JPanel panelInferior;

    private Tablero modelo;

    /**
     * Constructor panel que se encarga de construir la interfaz de jugador
     */
    public InterfazJugador(Tablero modelo) {
        this.modelo = modelo;
        this.barraMenu=new JMenuBar();
        this.menuConfiguracion= new JMenu("Configuración aspecto");
        this.itemConfiguracion=new JMenu("Modificar");
        this.itemPrimero=new JMenuItem("Opción 1");
        this.itemSegundo=new JMenuItem("Opción 2");
        setTitle(NOMBRE_APP);
        setSize(ANCHO, LARGO);
        setResizable(false); // No se pemite la modificacion del tamaño
        setLocationRelativeTo(null); // Su posicion siempre sera en el centro
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        construirPaneles(modelo);
    }

    private void construirPaneles(Tablero modelo) {
        panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Panel Superior"));
        this.barraMenu.add(this.menuConfiguracion);//Se agrega el menu a la barra
        this.menuConfiguracion.add(itemConfiguracion);//Se agrega le item al
        itemPrimero.addActionListener(new MigestorDecorador());//se agrega al gestor decorador
        this.itemConfiguracion.add(itemPrimero);//se agrega la primera opción
        itemSegundo.addActionListener(new MigestorDecorador());//se agrega al gestor decorador
        this.itemConfiguracion.add(itemSegundo);//se agrega la segunda opción
        this.setJMenuBar(this.barraMenu);
        this.barraMenu.setVisible(true);
        add(panelSuperior, BorderLayout.NORTH);

        panelTablero = new PanelTablero(modelo.getCuadricula().getNumeroCeldas(),modelo); // TODO cambiar luego
        add(panelTablero, BorderLayout.CENTER);

        panelEstado = new PanelEstado(this);
        add(panelEstado, BorderLayout.EAST);

        panelInferior = new JPanel();
        add(panelInferior, BorderLayout.SOUTH);
    }


    @Override
    public void update() {
        ;
    }

    public static void main(String args[]) {
        Tablero modelo = new Tablero(true);
        InterfazJugador panelJugador = new InterfazJugador(modelo);
        panelJugador.setVisible(true);

    }

}