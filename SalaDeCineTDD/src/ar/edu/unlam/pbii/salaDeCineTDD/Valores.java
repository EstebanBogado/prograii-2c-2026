package ar.edu.unlam.pbii.salaDeCineTDD;

public enum Valores {
	ENTRADA_MENOR(7.0), ENTRADA_MAYOR(16.0), PROMOCIONAL(14.0);

	private final Double precio;

	Valores(Double precio) {
		this.precio = precio;
	}

	public Double getPrecio() {
		return this.precio;
	}
}
