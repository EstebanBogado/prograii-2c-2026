package ar.edu.unlam.pbii.escuelaDemo;

public class Pizarra implements Alquilable {
	
	private Tamanio tamanio;
	private String nroSerie;

	public Pizarra(Tamanio tamanio, String nroSerie) {
		this.tamanio = tamanio;
		this.nroSerie = nroSerie;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public String getNroSerie() {
		return nroSerie;
	}

//	@Override
//	public Boolean estaDisponible() {
//		// TODO Auto-generated method stub
//		return true;
//	}

}
