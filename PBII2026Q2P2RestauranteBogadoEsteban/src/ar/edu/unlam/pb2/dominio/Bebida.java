package ar.edu.unlam.pb2.dominio;

public class Bebida extends Producto {

	private Boolean tieneAlcohol;

	public Bebida(Integer codigoProducto, String nombreProducto, Double precioBase, Boolean tieneAlcohol) {
		super(codigoProducto, nombreProducto, precioBase);
		this.tieneAlcohol = tieneAlcohol;
	}

	public Boolean getTieneAlcohol() {
		return tieneAlcohol;
	}

	@Override
	public Double getPrecioFinal() {

		if (this.tieneAlcohol)
			return (this.getPrecioBase() * 1.2);

		return this.getPrecioBase();
	}

}
