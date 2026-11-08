package ar.edu.unlam.pbii.hipoteca;

import java.util.Objects;

public abstract class Hipoteca {

	protected String codHipo;
	protected Cliente cliente;
	protected String fechaOtorgamiento;
	protected Double montoHipo;
	protected Double interes;
	protected Estado estadoHipo;

	public Hipoteca(String codHipo, Cliente cliente, String fechaOtorgamiento, Double montoHipo, Double interes,
			Estado estadoHipo) throws HipotecaNoPermitidaException {
		this.codHipo = codHipo;
		this.cliente = cliente;
		this.fechaOtorgamiento = fechaOtorgamiento;
		this.montoHipo = montoHipo;
		this.interes = interes;
		if (estadoHipo != Estado.SOLICITADA) {
			throw new HipotecaNoPermitidaException("El estado inicial de la hipoteca debe ser SOLICITADA");
		} else {
			this.estadoHipo = estadoHipo;
		}
	}

	public abstract Boolean validarMonto(Double monto);

	public Boolean esPermitida() {
		return validarMonto(montoHipo);
	}

	public abstract Double montoFinal();

	public Estado getAprobada() {
		return this.estadoHipo = Estado.APROBADA;
	}

	public Estado getLiquidada() {
		return this.estadoHipo = Estado.LIQUIDADA;
	}

	public Estado getSolicitada() {
		return Estado.SOLICITADA;
	}

	public String getCodHipo() {
		return codHipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getFechaOtorgamiento() {
		return fechaOtorgamiento;
	}

	public Double getMontoHipo() {
		return montoHipo;
	}

	public Double getInteres() {
		return interes;
	}

	public Estado getEstadoHipo() {
		return estadoHipo;
	}

	public void setEstadoHipo(Estado estado) {
		this.estadoHipo = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codHipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hipoteca other = (Hipoteca) obj;
		return Objects.equals(codHipo, other.codHipo);
	}

}
