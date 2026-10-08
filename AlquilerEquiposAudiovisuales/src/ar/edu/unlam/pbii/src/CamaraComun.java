package ar.edu.unlam.pbii.src;

public class CamaraComun extends Articulo {

	private final Double tarifaDiaria = 40.0;

	public CamaraComun(Integer cantElem) {
		super(cantElem);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getTarifaDiaria() {

		return this.tarifaDiaria;
	}

	@Override
	public Double getCostosExtra() {
		return 0.0;
	}

	@Override
	public Double getCosto(Integer dias) {

		return (this.tarifaDiaria * dias);
	}

}
