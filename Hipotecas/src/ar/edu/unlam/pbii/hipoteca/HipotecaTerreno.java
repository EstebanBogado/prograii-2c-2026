package ar.edu.unlam.pbii.hipoteca;

public class HipotecaTerreno extends Hipoteca {
	private Boolean aptoUrbano;
	private Double montoMinimo = 5_000_001.0;
	private Double montoMaximo = 15_000_000.0;

	public HipotecaTerreno(String codHipo, Cliente cliente, String fechaOtorgamiento, Double montoHipo, Double interes,
			Estado estadoHipo, Boolean aptoUrbano) throws HipotecaNoPermitidaException {
		super(codHipo, cliente, fechaOtorgamiento, montoHipo, interes, estadoHipo);
		if (!esPermitida())
			throw new HipotecaNoPermitidaException("Monto inválido o terreno no apto urbano");
	}

	public Boolean esPermitida() {
		return validarMonto(montoHipo) && this.aptoUrbano;
	}

	@Override
	public Boolean validarMonto(Double monto) {
		Boolean validada = false;
		if (monto >= this.montoMinimo && monto <= this.montoMaximo)
			validada = true;
		return validada;
	}

	public Boolean getAptoUrbano() {
		return aptoUrbano;
	}

	public void setAptoUrbano(Boolean aptoUrbano) {
		this.aptoUrbano = aptoUrbano;
	}

	@Override
	public Double montoFinal() {
		// TODO Auto-generated method stub
		return null;
	}
}
