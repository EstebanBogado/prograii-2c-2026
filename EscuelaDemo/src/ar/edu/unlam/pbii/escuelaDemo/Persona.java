package ar.edu.unlam.pbii.escuelaDemo;

public abstract class Persona implements Comparable<Persona> {
	protected String dni;
	protected String apellido;
	protected String nombre;

	public Persona(String dni, String apellido, String nombre) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + "] \n";
	}

	@Override
	public int compareTo(Persona p) {

		int resultado = this.apellido.compareToIgnoreCase(p.apellido);
		if (resultado == 0) {
			resultado = this.dni.compareTo(p.dni);
		}
		return resultado;
	}

	

}
