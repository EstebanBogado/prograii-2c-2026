package ar.edu.unlam.pbii.hipoteca;

public class HipotecaInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public HipotecaInexistenteException(String mensaje) {
		super(mensaje);
	}
}
