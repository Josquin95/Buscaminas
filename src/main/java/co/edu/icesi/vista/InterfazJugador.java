package co.edu.icesi.vista;

import co.edu.icesi.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

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

    private Memento copiaModelo;
    private JPanel panelSuperior;

    /**
     * Panel que muestra el estado y las configuraciones iniciales del juego
     */
    private PanelEstado panelEstado;

    private JPanel panelInferior;

    private JMenuBar barraMenu;
    /**
     * Menu para la personilización de la configuración
     */
    private JMenu menuConfiguracion;
    /**
     * Menu para la personilización de la configuración
     */
    private JMenu menuJugabilidad;
    /**
     * item desde donde se podra realizar la configuración de la personalización
     */
    private JMenu itemConfiguracion;
    private JMenuItem reiniciar;
    private JMenuItem itemPrimero;
    private JMenuItem itemSegundo;
    private JMenuItem itemTercero;

    /**
     * Clase facade del mundo que conecta con la interfaz
     */
    private Tablero modelo;


    /**
     * Constructor panel que se encarga de construir la interfaz de jugador
     */
    public InterfazJugador(Tablero modelo) {
        this.modelo = modelo;
        modelo.attach(this);
        setTitle(NOMBRE_APP);
        setSize(ANCHO, LARGO);
        setResizable(false); // No se pemite la modificacion del tamaño
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.barraMenu = new JMenuBar();
        this.menuConfiguracion = new JMenu("Configuración aspecto");
        this.itemConfiguracion = new JMenu("Modificar");
        this.menuJugabilidad= new JMenu("Jugabilidad");
        this.reiniciar =new JMenuItem("Reiniciar");
        this.itemPrimero = new JMenuItem("Opción 1");
        this.itemSegundo = new JMenuItem("Opción 2");
        this.itemTercero = new JMenuItem("Opción 3");

        construirPaneles(modelo);
    }

    public void construirPaneles(Tablero modelo) {
        panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Panel Superior"));
        add(panelSuperior, BorderLayout.NORTH);

        panelTablero = new PanelTablero(modelo.getNumeroCeldas(), modelo);
        copiaModelo=new Memento(panelTablero);
        add(panelTablero, BorderLayout.CENTER);

        panelEstado = new PanelEstado(this);
        add(panelEstado, BorderLayout.EAST);

        panelInferior = new JPanel();
        add(panelInferior, BorderLayout.SOUTH);

        this.barraMenu.add(this.menuConfiguracion);//Se agrega el menu de configuración a la barra
        this.barraMenu.add(this.menuJugabilidad);// Se agrega el menu de la jugabilidad a la barra
        reiniciar.addActionListener(new MigestorDecorador(this));
        this.menuJugabilidad.add(this.reiniciar);
        this.menuConfiguracion.add(itemConfiguracion);//Se agrega le item al menu
        itemPrimero.addActionListener(new MigestorDecorador(this));//se agrega al gestor decorador
        this.itemConfiguracion.add(itemPrimero);//se agrega la primera opción
        itemSegundo.addActionListener(new MigestorDecorador(this));//se agrega al gestor decorador
        this.itemConfiguracion.add(itemSegundo);//se agrega la segunda opción
        itemTercero.addActionListener(new MigestorDecorador(this));//se agrega al gestor decorador
        this.itemConfiguracion.add(itemTercero);
        this.setJMenuBar(this.barraMenu);
        this.barraMenu.setVisible(true);
    }

    public void addAction(MouseListener mouseListener) {
        panelEstado.addActionListener(mouseListener);
        panelTablero.addAction(mouseListener);
    }


    @Override
    public void update() {
        panelTablero.refrescarBotones(modelo);
        panelEstado.setTxtTiempo(modelo.getTiempo());
    }

    public JMenuItem getItemPrimero() {
        return itemPrimero;
    }

    public JMenuItem getItemSegundo() {
        return itemSegundo;
    }

    public Memento getCopiaModelo() {
        return copiaModelo;
    }

    public Tablero getModelo() {
        return modelo;
    }

    public PanelTablero getPanelTablero() {
        return panelTablero;
    }

    public void setPanelTablero(PanelTablero panelTablero) {
        this.panelTablero = panelTablero;
    }

    public JMenuItem getReiniciar() {return reiniciar;}

    public void setModelo(Tablero modelo) {
        this.modelo = modelo;
    }
}