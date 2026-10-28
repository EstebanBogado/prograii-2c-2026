package ar.edu.unlam.pbii.escuelaDemo;

public class Notebook extends ItemAlquilable {
	private Marca marca;

	public Notebook(Marca marca, String nroSerie) {
		super(nroSerie);
		this.marca = marca;
	}

	public Marca getMarca() {
		return marca;
	}

}
