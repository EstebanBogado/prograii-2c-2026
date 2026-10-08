package ar.edu.unlam.pbii.src;

public class CamaraCine extends Articulo {

	private final Double tarifaDiaria = 40.0;
	private final Double costoPorTraslado = 100.0;

	public CamaraCine(Integer cantElem) {
		super(cantElem);
	}

	@Override
	public Double getTarifaDiaria() {

		return this.tarifaDiaria;
	}

	@Override
	public Double getCostosExtra() {

		return this.costoPorTraslado;
	}

	@Override
	public Double getCosto(Integer dias) {

		return ((this.tarifaDiaria * dias * this.cantElem)) + getCostosExtra();
	}

}
