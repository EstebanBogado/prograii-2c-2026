package ar.edu.unlam.pbii.casaDeComidas;

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

	@Override
	public String toString() {
		StringBuilder plato = new StringBuilder("Plato [");
		boolean primero = true;

		if (carne != null) {
			plato.append("carne=").append(carne);
			primero = false;
		}
		if (guarnicion != null) {
			if (!primero) plato.append(", ");
			plato.append("guarnicion=").append(guarnicion);
			primero = false;
		}
		if (bebida != null) {
			if (!primero) plato.append(", ");
			plato.append("bebida=").append(bebida);
		}

		plato.append("]\n");
		return plato.toString();
	}

}
