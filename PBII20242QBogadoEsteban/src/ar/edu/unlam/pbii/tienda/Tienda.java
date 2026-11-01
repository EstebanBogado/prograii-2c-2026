package ar.edu.unlam.pbii.tienda;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tienda {

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

	public Producto buscarProductoPorCodigo(Integer codProducto) {
		for (Producto producto : this.productos) {
			if (producto.getCodProducto().equals(codProducto))
				return producto;
		}
		return null;
	}

	public void agregarCaracteristicaAProducto(Producto producto, Caracteristica caracteristica)
			throws ProductoNoEncontradoException, ProductoNoSoportadoException {

		if (producto instanceof ProductoPersonalizado)
			producto.agregarCaracteristica(caracteristica);
		else
			throw new ProductoNoSoportadoException("Este producto no es personalizable");
	}
	
	public Set<ProductoPersonalizado> ordenarProductoPersonalizadoPorCantCaracteristicas() {

		TreeSet<ProductoPersonalizado> ordenados = new TreeSet<ProductoPersonalizado>(
				new ProductoPersonalizadoOrdenadoPorCantCaract());
		for (Producto producto : this.productos) {
			if (producto instanceof ProductoPersonalizado)
				ordenados.add((ProductoPersonalizado) producto);
		}
		return ordenados;
	}

	public Set<ProductoFisico> ordenarProductoFisicoPorDimension() {

		TreeSet<ProductoFisico> ordenados = new TreeSet<ProductoFisico>(new ProductosFisicosOrdenadosPorDimension());
		for (Producto producto : productos) {
			if (producto instanceof ProductoFisico)
				ordenados.add((ProductoFisico) producto);
		}
		return ordenados;
	}

	public Set<ProductoDigital> ordenarProductoDigitalPorFormato() {

		TreeSet<ProductoDigital> ordenados = new TreeSet<ProductoDigital>(new ProductosDigitalesOrdenadosPorFormato());
		for (Producto producto : productos) {
			if (producto instanceof ProductoDigital)
				ordenados.add((ProductoDigital) producto);
		}
		return ordenados;
	}

}
