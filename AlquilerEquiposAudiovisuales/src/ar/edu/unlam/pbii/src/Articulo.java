package ar.edu.unlam.pbii.src;

public abstract class Articulo {
	protected Integer cantElem;

	public Articulo(Integer cantElem) {
		this.cantElem = cantElem;
	}

	public abstract Double getTarifaDiaria();

	public abstract Double getCostosExtra();

	public abstract Double getCosto(Integer dias);

	public Integer getCantElem() {
		return this.cantElem;
	}

	public void setCantElem(Integer cantidad) {
		this.cantElem = cantidad;
	}
}
