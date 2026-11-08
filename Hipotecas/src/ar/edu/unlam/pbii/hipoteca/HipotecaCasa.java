package ar.edu.unlam.pbii.hipoteca;

public class HipotecaCasa extends Hipoteca {
	private Double montoMinimo = 0.0;
	private Double montoMaximo = 5_000_000.0;
	private Double montoAsegurado = 0.0;

	public HipotecaCasa(String codHipo, Cliente cliente, String fechaOtorgamiento, Double montoHipo, Double interes,
			Estado estadoHipo, Double montoAsegurado) throws HipotecaNoPermitidaException {
		super(codHipo, cliente, fechaOtorgamiento, montoHipo, interes, estadoHipo);
		this.montoAsegurado = montoAsegurado;
		if (!esPermitida())
			throw new HipotecaNoPermitidaException("Monto inválido");
	}

	@Override
	public Boolean validarMonto(Double monto) {
		Boolean validada = false;
		if (monto > this.montoMinimo && monto <= this.montoMaximo)
			validada = true;
		return validada;
	}

	@Override
	public Double montoFinal() {
		Double montoFinal = 0.0;

		montoFinal = this.montoHipo + (this.montoHipo * (super.interes / 100)) + this.montoAsegurado;

		return montoFinal;
	}

}
