package ar.edu.unlam.pbii.hipoteca;

public class HipotecaDepto extends Hipoteca {
	private Double montoMinimo = 5_000_001.0;
	private Double montoMaximo = 15_000_000.0;

	public HipotecaDepto(String codHipo, Cliente cliente, String fechaOtorgamiento, Double montoHipo, Double interes,
			Estado estadoHipo) throws HipotecaNoPermitidaException {
		super(codHipo, cliente, fechaOtorgamiento, montoHipo, interes, estadoHipo);

	}

	@Override
	public Boolean validarMonto(Double monto) {
		Boolean validada = false;
		if (monto >= this.montoMinimo && monto <= this.montoMaximo)
			validada = true;
		return validada;
	}

	@Override
	public Double montoFinal() {
		Double montoFinal = 0.0;

		montoFinal = this.montoHipo + (this.montoHipo * (super.interes / 100));

		return montoFinal;
	}

}
