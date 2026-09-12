package ar.edu.unlam.pbii.casaDeComidas;

import ar.edu.unlam.pbii.casaDeComidasTest.Carne;
import ar.edu.unlam.pbii.casaDeComidasTest.Guarnicion;

public class Plato {
	private Carne carne;
	private Guarnicion guarnicion;
	private Bebida bebida;

	public Plato() {

	}

	public void agregarCarne(Carne carne) {
		this.carne = carne;
	}

	public void agregarGuarnicion(Guarnicion guarnicion) {
		this.guarnicion = guarnicion;
	}

	public void agregarBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public Carne getCarne() {
		return this.carne;
	}

	public Guarnicion getGuarnicion() {
		return this.guarnicion;
	}

	public Bebida getBebida() {
		return this.bebida;
	}

}
