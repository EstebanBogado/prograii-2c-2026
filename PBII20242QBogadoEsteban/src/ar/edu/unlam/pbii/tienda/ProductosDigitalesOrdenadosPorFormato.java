package ar.edu.unlam.pbii.tienda;

import java.util.Comparator;

public class ProductosDigitalesOrdenadosPorFormato implements Comparator<ProductoDigital> {

	@Override
	public int compare(ProductoDigital uno, ProductoDigital dos) {
//		// TODO Auto-generated method stub
//		return uno.getFormato().compareTo(dos.getFormato());

		int resultado = uno.getFormato().compareTo(dos.getFormato());
		if (resultado != 0)
			return resultado;

		resultado = uno.getTamanio().compareTo(dos.getTamanio());
		if (resultado != 0)
			return resultado;

		return uno.getCodProducto().compareTo(dos.getCodProducto());
	}

}
