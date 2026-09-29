package ar.edu.unlam.pbii.casaDeComidas;

public class Combo extends Producto {

	private String tipoCombo;
	private Double descuentoFamiliar = 0.20;
	private Double descuentoCombo = 0.15;

	public Combo(String tipoCombo) {
		super();

		this.tipoCombo = tipoCombo;
	}

	private Double calcularPrecioBase() {
		return carne.getPrecio() + guarnicion.getPrecio() + bebida.getPrecio();
	}

	@Override
	public Double aplicarDescuento() {
		Double descuento = 0.0;
		if (this.tipoCombo.equalsIgnoreCase("Combo Familiar")) {
			descuento = calcularPrecioBase() * this.descuentoFamiliar;
		}
		if (this.tipoCombo.equalsIgnoreCase("Combo")) {
			descuento = calcularPrecioBase() * this.descuentoCombo;
		}
		return descuento;
	}

	@Override
	public Double calcularPrecio() {
		return (calcularPrecioBase() - aplicarDescuento());

	}

}
