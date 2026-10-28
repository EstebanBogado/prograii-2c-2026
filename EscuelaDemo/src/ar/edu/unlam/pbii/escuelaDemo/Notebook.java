package ar.edu.unlam.pbii.escuelaDemo;

public class Notebook implements Alquilable {
	private Marca marca;
	private String nroSerie;

	public Notebook(Marca marca, String nroSerie) {
		this.marca = marca;
		this.nroSerie = nroSerie;
	}

	public Marca getMarca() {
		return marca;
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
