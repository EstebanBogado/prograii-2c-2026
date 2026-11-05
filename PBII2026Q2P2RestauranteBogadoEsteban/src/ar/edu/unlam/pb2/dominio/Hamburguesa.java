package ar.edu.unlam.pb2.dominio;

import java.util.Set;

public class Hamburguesa extends Producto {

	private Integer cantidadMedallones;

	public Hamburguesa(Integer codigoProducto, String nombreProducto, Double precioBase, Integer cantidadMedallones) {
		super(codigoProducto, nombreProducto, precioBase);
		this.setCantidadMedallones(cantidadMedallones);
	}

	public Integer getCantidadMedallones() {
		return cantidadMedallones;
	}

	public void setCantidadMedallones(Integer cantidadMedallones) {
		this.cantidadMedallones = cantidadMedallones;
	}

	@Override
	public Double getPrecioFinal() {
		if ((this.extras != null))
			return this.precioBase + (this.extras.size() * 500.0);
		return this.precioBase;
	}

	

}
