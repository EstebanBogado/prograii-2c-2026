package ar.edu.unlam.pbii.tienda;

public class ProductoNoSoportadoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoNoSoportadoException(String mensaje) {
		super(mensaje);
	}
}
