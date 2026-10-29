package ar.edu.unlam.pbii.tienda;

import java.util.HashSet;
import java.util.Set;

public class Tienda implements {

	private Set<Producto> productos;

	public Tienda() {
		this.productos = new HashSet<Producto>();
	}

	public Boolean agregarProducto(Producto producto) {
		return this.productos.add(producto);

	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void agregarCaracteristicaAProducto(Producto producto, Caracteristica caracteristica)
			throws ProductoNoEncontradoException, ProductoNoSoportadoException {

		if (producto instanceof ProductoPersonalizado)
			producto.agregarCaracteristica(caracteristica);
		else
			throw new ProductoNoSoportadoException("Este producto no es personalizable");
	}

	public void ordenarPorDimension() {
		// TODO Auto-generated method stub
		
	}


}
