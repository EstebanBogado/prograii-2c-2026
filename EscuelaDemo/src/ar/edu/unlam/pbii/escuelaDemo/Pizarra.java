package ar.edu.unlam.pbii.escuelaDemo;

public class Pizarra extends ItemAlquilable {

	private Tamanio tamanio;

	public Pizarra(Tamanio tamanio, String nroSerie) {
		super(nroSerie);
		this.tamanio = tamanio;

	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	
}
