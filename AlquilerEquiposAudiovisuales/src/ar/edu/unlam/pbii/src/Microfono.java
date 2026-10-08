package ar.edu.unlam.pbii.src;

public class Microfono extends Articulo {

	private final Double tarifaDiaria = 10.0;
	private final Integer diasBase = 2;

	public Microfono(Integer cantElem) {
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

	public Integer getDiasBase() {
		return this.diasBase;
	}

	@Override
	public Double getCosto(Integer dias) {
		Integer diasACobrar = Math.max(diasBase, dias);

		return ((this.tarifaDiaria * diasACobrar) * this.cantElem);
	}

}
