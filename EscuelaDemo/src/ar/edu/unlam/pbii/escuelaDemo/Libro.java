package ar.edu.unlam.pbii.escuelaDemo;

public class Libro extends ItemAlquilable {

	private String nombre;

	public Libro(String nombre, String isbn) {

		super(isbn);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	
}
