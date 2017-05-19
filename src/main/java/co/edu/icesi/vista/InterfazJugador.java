package co.edu.icesi.vista;

import co.edu.icesi.modelo.ITablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Autor Jose Luis Osorio Quintero
 * Universidad Icesi - 2017 - 05
 * Este es un proyecto academico para la clase de diseno de patrones.
 */
public class InterfazJugador extends InterfazBuscaMinas {

    //---------------------------------------------------
    // PROPIEDADES
    //---------------------------------------------------
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
     * Memento que se encarga de guardar el estado del juego
     */
    private Memento memento;

    /**
     * Panel que muestra el estado y las configuraciones iniciales del juego
     */
    private PanelEstado panelEstado;

    /**
     * Barra de Menu del Juego
     */
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

    /**
     * Item que reinicia el juego
     */
    private JMenuItem reiniciar;

    /**
     * Item del JMenu
     */
    private JMenuItem itemPrimero;

    /**
     * Item del JMenu
     */
    private JMenuItem itemSegundo;

    /**
     * Item del JMenu
     */
    private JMenuItem itemTercero;

    /**
     * Clase facade del mundo que conecta con la interfaz
     */
    private ITablero modelo;

    //----------------------------------------------------------------------
    // CONSTRUCTOR
    //----------------------------------------------------------------------

    /**
     * Constructor panel que se encarga de construir la interfaz de jugador
     */
    public InterfazJugador(ITablero modelo, boolean espectador) {
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
        this.menuJugabilidad = new JMenu("Jugabilidad");
        this.reiniciar = new JMenuItem("Reiniciar");
        this.itemPrimero = new JMenuItem("Opción 1");
        this.itemSegundo = new JMenuItem("Opción 2");
        this.itemTercero = new JMenuItem("Opción 3");

        construirPaneles(modelo, espectador);
    }

    /**
     * Se encarga de inicializar los paneles
     *
     * @param modelo     clase facade de la logica
     * @param espectador boolean para determinar el jugador o el espectador
     */
    public void construirPaneles(ITablero modelo, boolean espectador) {

        int numero = modelo.getNumeroCeldas();
        panelTablero = new PanelTablero(numero, modelo, espectador);
        memento = new Memento(panelTablero);
        add(panelTablero, BorderLayout.CENTER);

        panelEstado = new PanelEstado(this);
        add(panelEstado, BorderLayout.EAST);

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

    /**
     * Agrega la accion al panel
     * @param mouseListener Accion del mouse
     */
    public void addAction(MouseListener mouseListener) {
        panelEstado.addActionListener(mouseListener);
        panelTablero.addAction(mouseListener);
    }

    /**
     * Actualiza los componentes de la interfaz
     */
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
        return memento;
    }

    public PanelTablero getPanelTablero() {
        return panelTablero;
    }

    public void setPanelTablero(PanelTablero panelTablero) {
        this.panelTablero = panelTablero;
    }

    public JMenuItem getReiniciar() {
        return reiniciar;
    }

    public ITablero getModelo() {
        return modelo;
    }
}