package ar.edu.unlam.pbii.hipoteca;

public class Liquidacion {
	private Integer codLiquidacion;
	private Hipoteca hipoteca;
	private EstadoLiquidacion estado;
	private Double montoFinal;
	private String fechaEmision;

	public Liquidacion(Integer codLiquidacion, Hipoteca hipoteca) {
		this.codLiquidacion = codLiquidacion;
		this.hipoteca = hipoteca;
		this.estado = EstadoLiquidacion.PENDIENTE;
	}
	
	
	
	

	public Integer getCodLiquidacion() {
		return codLiquidacion;
	}

	public void setCodLiquidacion(Integer codLiquidacion) {
		this.codLiquidacion = codLiquidacion;
	}

	public Hipoteca getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(Hipoteca hipoteca) {
		this.hipoteca = hipoteca;
	}

	public EstadoLiquidacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoLiquidacion estado) {
		this.estado = estado;
	}

	public Double getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(Double montoFinal) {
		this.montoFinal = montoFinal;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
}
