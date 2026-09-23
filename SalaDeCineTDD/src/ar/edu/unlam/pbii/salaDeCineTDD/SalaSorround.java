package ar.edu.unlam.pbii.salaDeCineTDD;

public class SalaSorround extends Sala {
	private Integer cantidadParlantes;
	private Integer potenciTotal; // Unidad de medida W (Watts)

	public SalaSorround(Integer filas, Integer columnas) {
		super(filas, columnas);
		this.volumen = 90;
		this.potenciTotal = 500;
		this.cantidadParlantes = 10;
	}

	@Override
	public void setVolumen(Integer volumen) {
		if (volumen != this.volumen) {
			this.volumen = volumen;
		}
	}

	@Override
	public Integer getVolumen() {
		return this.volumen;
	}

	public void setCantidadParlantes(Integer cantParlantes) {
		this.cantidadParlantes = cantParlantes;
	}

	public void setPotenciaTotal(Integer potTotal) {
		this.potenciTotal = potTotal;
	}

	public Integer getCantidadParlantes() {
		return this.cantidadParlantes;
	}

	public Integer getPotenciaTotal() {
		return this.potenciTotal;
	}

}
