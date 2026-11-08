package ar.edu.unlam.pbii.hipoteca;

public class HipotecaNoPermitidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public HipotecaNoPermitidaException(String mensaje) {
		super(mensaje);
	}
}
