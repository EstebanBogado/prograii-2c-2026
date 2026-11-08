package ar.edu.unlam.pbii.hipoteca;

public class LiquidacionInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public LiquidacionInexistenteException(String mensaje) {
		super(mensaje);
	}
}
