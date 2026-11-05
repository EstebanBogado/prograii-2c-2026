package ar.edu.unlam.pb2.excepciones;

public class ProductoDuplicadoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoDuplicadoException(String mensaje) {
		super(mensaje);
	}

}
