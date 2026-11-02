package ar.edu.unlam.pbii.tienda;

import java.util.ArrayList;
import java.util.List;

public class ProductoPersonalizado extends Producto {

	private List<Caracteristica> caracteristicas;

	public ProductoPersonalizado(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, ArrayList<Caracteristica> caracteristicas) {
		super(codProducto, nombreProducto, precio, descripicionProducto, existencias);
		this.caracteristicas = new ArrayList<Caracteristica>();
	}

	public List<Caracteristica> getCaracteristicas() {
		return this.caracteristicas;
	}

	public Integer getCantCaracteristicas() {
		return this.caracteristicas.size();
	}

	public Boolean agregarCaracteristica(Caracteristica caracteristica) {
		return this.caracteristicas.add(caracteristica);
	}

}
