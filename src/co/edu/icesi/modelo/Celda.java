package co.edu.icesi.modelo;

public abstract class Celda {

	private String estado;
	private int minasAdyacentes;
	private boolean mina;

	public Celda() {
	    minasAdyacentes = 0;
    }

	public int getMinasAdyacentes() {
		return minasAdyacentes;
	}

	public void setMinasAdyacentes(int minasAdyacentes) {
		this.minasAdyacentes = minasAdyacentes;
	}

	public boolean esMina() {
		return mina;
	}

	public void setMina(boolean tieneMina) {
		this.mina = tieneMina;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}