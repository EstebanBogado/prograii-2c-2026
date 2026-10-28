package ar.edu.unlam.pbii.escuelaDemo;

public class Libro implements Alquilable {
	
	private String nombre;
	private String isbn;

	public Libro(String nombre, String isbn) {
		this.nombre = nombre;
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public String getIsbn() {
		return isbn;
	}

//	@Override
//	public Boolean estaDisponible() {
//		// TODO Auto-generated method stub
//		return true;
//	}

	

}
