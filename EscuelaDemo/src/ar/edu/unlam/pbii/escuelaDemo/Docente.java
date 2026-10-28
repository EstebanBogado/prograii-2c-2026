package ar.edu.unlam.pbii.escuelaDemo;

public class Docente extends Persona {

	private String legajo;
	private Object materia;

	public Docente(String legajo, String dni, String apellido, String nombre, String materia) {
		super(dni, apellido, nombre);
		this.legajo = legajo;
		this.materia = materia;
	}

	public String getLegajo() {
		return legajo;
	}

	public Object getMateria() {
		return materia;
	}

	@Override
	public String toString() {
		return super.toString() + "Docente [legajo=" + legajo + ", materia=" + materia + "]\n";
	}

}
