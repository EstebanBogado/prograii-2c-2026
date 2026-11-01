//package ar.edu.unlam.pbii.tienda;
//
//import java.util.Comparator;
//import java.util.Set;
//import java.util.TreeSet;
//
//public class ProductoPersonalizadoOrdenadoPorCantCaract implements Comparator<ProductoPersonalizado> {
//
//	public ProductoPersonalizadoOrdenadoPorCantCaract(Producto producto) {
//
//	}
//
//	Set<ProductoFisico> ordenados = new TreeSet<ProductoFisico>(
//			Comparator.comparing(ProductoFisico::getExistencias).thenComparing(ProductoFisico::getCodProducto));
//
//	@Override
//	public int compare(ProductoPersonalizado uno, ProductoPersonalizado dos) {
//		int resultado = (uno.getCantCaracteristicas()).compareTo(dos.getCantCaracteristicas());
//		if (resultado != 0)
//			return resultado;
//		return uno.getCodProducto().compareTo(dos.getCodProducto());
//	}
//
//}


package ar.edu.unlam.pbii.tienda;

import java.util.Comparator;

public class ProductoPersonalizadoOrdenadoPorCantCaract implements Comparator<ProductoPersonalizado> {

	@Override
	public int compare(ProductoPersonalizado uno, ProductoPersonalizado dos) {
		int resultado = uno.getCantCaracteristicas().compareTo(dos.getCantCaracteristicas());
		if (resultado != 0)
			return resultado;
		return uno.getCodProducto().compareTo(dos.getCodProducto());
	}
}