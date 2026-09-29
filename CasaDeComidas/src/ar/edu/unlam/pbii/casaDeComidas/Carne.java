package ar.edu.unlam.pbii.casaDeComidas;

public enum Carne implements TienePrecio {

	BIFE_CHORIZO(15.0), PECHUGA_GRILLE(13.0), FILET_MERLUZA(16.0);

	private final Double precio;

	Carne(Double precio) {
		this.precio = precio;
	}

	@Override
	public Double getPrecio() {
		return this.precio;
	}
}
