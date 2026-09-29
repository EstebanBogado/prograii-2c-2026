package ar.edu.unlam.pbii.casaDeComidas;

public enum Bebida implements TienePrecio {

	COCA_COLA(10.0), SPRITE(12.0), FANTA(8.0);

	private final Double precio;

	Bebida(Double precio) {
		precio += precio * 0.10;
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		return this.precio;
	}
}
