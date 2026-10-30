package ar.edu.unlam.pbii.tienda;

import java.util.Comparator;

public class ProductosFisicosOrdenadosPorDimension implements Comparator<ProductoFisico> {

	public ProductosFisicosOrdenadosPorDimension() {

	}

	@Override
	public int compare(ProductoFisico uno, ProductoFisico dos) {

		return uno.getDimensiones().compareTo(dos.getDimensiones());
	}

}
