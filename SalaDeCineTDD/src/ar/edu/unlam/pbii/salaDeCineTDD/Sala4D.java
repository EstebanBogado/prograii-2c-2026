package ar.edu.unlam.pbii.salaDeCineTDD;

public class Sala4D extends Sala {
	private Boolean aguaActivada = false;
	private Boolean vientoActivado = false;
	private Boolean movimientoActivado = false;

	public Sala4D(Integer filas, Integer columnas) {
		super(filas, columnas);
	}

	@Override
	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}

	@Override
	public Integer getVolumen() {
		return this.volumen;
	}

	public void setEfectoAgua() {
		this.aguaActivada = true;
	}

	public void setEfectoViento() {
		this.vientoActivado = true;
	}

	public void setEfectoMovimiento() {
		this.movimientoActivado = true;
	}

	public Boolean getEfectoAgua() {
		if (aguaActivada) {
			return true;
		}
		return false;
	}

	public Boolean getEfectoViento() {
		if (vientoActivado) {
			return true;
		}
		return false;
	}

	public Boolean getEfectoMovimiento() {
		if (movimientoActivado) {
			return true;
		}
		return false;
	}

	public Boolean warningEfectosActivados() {
		if (getEfectoAgua() || getEfectoMovimiento() || getEfectoViento()) {
			return true;
		}
		return false;
	}

}
