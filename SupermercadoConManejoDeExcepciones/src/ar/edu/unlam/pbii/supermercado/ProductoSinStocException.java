package ar.edu.unlam.pbii.supermercado;

public class ProductoSinStocException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoSinStocException(String mensaje) {
		super(mensaje);
	}
}
