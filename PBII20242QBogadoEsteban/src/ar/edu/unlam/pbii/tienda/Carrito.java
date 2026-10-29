package ar.edu.unlam.pbii.tienda;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private List<Producto> productos;

	public Carrito() {
		this.productos = new ArrayList<Producto>();
	}

	public Boolean agregarAlCarrito(Producto producto) {
		return this.productos.add(producto);
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

}
