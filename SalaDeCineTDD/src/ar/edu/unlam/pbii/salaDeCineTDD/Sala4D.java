package ar.edu.unlam.pbii.salaDeCineTDD;

public class Sala4D extends Sala {
	private Boolean vientoActivado = false;
	private Boolean aguaActivada = false;
	private Boolean movimientoActivado = false;

	public Sala4D(Integer filas, Integer columnas) {
		super(filas, columnas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}

	@Override
	public Integer getVolumen() {
		return this.volumen;
	}

	public String aplicarEfectoDeViento() {
		String mensaje = null;
		if (this.vientoActivado)
			mensaje = "qué viento".toUpperCase();
		else {
			mensaje = null;
		}
		return mensaje;

	}

	public Boolean activarEfectoViento() {
		this.vientoActivado = true;
		return this.vientoActivado;
	}

	public Boolean desactivarEfectoViento() {
		this.vientoActivado = false;
		return this.vientoActivado;
	}

	public Boolean activarEfectoAgua() {
		this.aguaActivada = true;
		return this.aguaActivada;
	}

	public Boolean desactivarEfectoAgua() {
		this.aguaActivada = false;
		return this.aguaActivada;
	}

	public Boolean desactivarMovimiento() {
		this.movimientoActivado = false;
		return this.movimientoActivado;
	}

	public String aplicarEfectoDeAgua() {
		String mensaje = null;

		if (this.aguaActivada) {
			mensaje = "agua activada".toUpperCase();
		} else {

			mensaje = null;
		}
		return mensaje;
	}

	public Boolean activarEfectoMovimiento() {
		this.movimientoActivado = true;
		return this.movimientoActivado;
	}

	public String aplicarEfectoDeMovimiento() {
		String mensaje = null;

		if (this.movimientoActivado)
			mensaje = "butaca moviéndose".toUpperCase();
		else {
			mensaje = null;
		}
		return mensaje;
	}
}
