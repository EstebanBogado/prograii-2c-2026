package ar.edu.unlam.pbii.casaDeComidas;

public class Plato extends Producto {

	public Plato() {
		super();

	}

	@Override
	public Double aplicarDescuento() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public Double calcularPrecio() {

		return (this.carne.getPrecio() + this.guarnicion.getPrecio() + this.bebida.getPrecio());
	}

}
