package ar.edu.unlam.pbii.casaDeComidas;

public class PlatoDelDia extends Producto {
	

	private Double descuento = 0.2;

	public PlatoDelDia() {
		super();
	}

	private Double calcularPrecioBase() {
		return carne.getPrecio() + guarnicion.getPrecio() + bebida.getPrecio();
	}

	@Override
	public Double aplicarDescuento() {
		return calcularPrecioBase() * this.descuento; // monto del descuento
	}

	@Override
	public Double calcularPrecio() {
		return calcularPrecioBase() - aplicarDescuento(); // precio final
	}

}
