package ar.edu.unlam.pbii.tienda;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tienda  {

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

	public Set ordenarProductoFisicoPorDimension() {
		
		TreeSet<ProductoFisico> ordenados = new TreeSet<ProductoFisico>(new ProductosFisicosOrdenadosPorDimension());
		for (Producto producto: productos) {
			if(producto instanceof ProductoFisico)
				ordenados.add( (ProductoFisico) producto);
		}
		return ordenados;
	}


}
