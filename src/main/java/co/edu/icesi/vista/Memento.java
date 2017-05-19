package co.edu.icesi.vista;

import co.edu.icesi.modelo.Tablero;

/**
 * Created by 1143929085 on 18/05/2017.
 * clase que se encarga de guardar el tablero
 */
public class Memento {

private Tablero tableroGuardado;

public Memento(Tablero inicial){
    this.tableroGuardado=inicial;
}

    public Tablero getTableroGuardado() {
        return tableroGuardado;
    }

    public void setTableroGuardado(Tablero tableroGuardado) {
        this.tableroGuardado = tableroGuardado;
    }
}
