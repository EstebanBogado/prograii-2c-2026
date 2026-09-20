package ar.edu.unlam.pbii.casaDeComidas;

public enum Guarnicion implements TienePrecio {
	ENSALADA_MIXTA(7.0), PAPAS_FRITAS(6.0), CROQUETAS_ACELGA(4.0);

	private final Double precio;

	Guarnicion(Double precio) {
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		return this.precio;
	}
}
