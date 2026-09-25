package ar.edu.unlam.pbii.localDeComidas;

public class Plato {
	private String nombre;
	private Sanguche principal;
	private Guarnicion guarnicion;
	private Double precio;

	public Plato(String nombre, Sanguche principal, Guarnicion guarnicion, Double precio) {
		this.nombre = nombre;
		this.principal = principal;
		this.guarnicion = guarnicion;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	/*
	 * public void setNombre(String nombre) { this.nombre = nombre; }
	 */

	public Sanguche getIngred() {
		return principal;
	}

	@Override
	public String toString() {
		return "nombre= " + nombre + ", ingredientes= " + principal + ", guarnicion= " + guarnicion + ", precio= "
				+ precio + "\n";
	}

	public void setIngred(Sanguche sanguche) {
		this.principal = sanguche;
	}

	public Guarnicion getGuarnicion() {
		return guarnicion;
	}

	public void setGuarnicion(Guarnicion guarnicion) {
		this.guarnicion = guarnicion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
