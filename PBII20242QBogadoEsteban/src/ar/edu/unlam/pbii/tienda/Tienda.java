package ar.edu.unlam.pbii.tienda;

import java.util.HashSet;
import java.util.Set;

public class Tienda {

	private Set<Producto> productos;

	public Tienda() {
		this.productos = new HashSet<Producto>();
	}

	public Boolean agregarProducto(Producto producto) {
		return this.productos.add(producto);

	}

	public Set<Producto> getProductos() {
		// TODO Auto-generated method stub
		return this.productos;
	}

}
