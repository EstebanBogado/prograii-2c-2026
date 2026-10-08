package ar.edu.unlam.pbii.src;

public class Luz extends Articulo {

	private final Double tarifaDiaria = 20.0;
	private final Double recargoEnergeticoDiario = 5.0;

	public Luz(Integer cantElem) {
		super(cantElem);
	}

	@Override
	public Double getTarifaDiaria() {
		return this.tarifaDiaria;
	}

	@Override
	public Double getCostosExtra() {

		return this.recargoEnergeticoDiario;
	}

	@Override
	public Double getCosto(Integer dias) {

		return ((this.tarifaDiaria + getCostosExtra()) * dias * this.cantElem);
	}

}
