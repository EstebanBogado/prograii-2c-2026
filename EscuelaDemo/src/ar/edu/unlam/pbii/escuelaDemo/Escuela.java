package ar.edu.unlam.pbii.escuelaDemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Escuela {
	private String nombreEscuela;
	private Set<Docente> docentes = new TreeSet<>();
	private Set<Alumno> alumnos = new TreeSet<>();

	public Escuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}

	public String getNombreEscuela() {
		return nombreEscuela;
	}

	public void agregarDocente(Docente docente) throws PersonaConDNIRepetidoException {

		if (docente == null)
			throw new IllegalArgumentException();
		for (Docente d : docentes) {
			if (d.getDni().equals(docente.getDni())) {
				throw new PersonaConDNIRepetidoException("el docente " + docente.getDni() + " ya existe");
			}
		}

//		if (!docentes.add(docente))
//			throw new PersonaConDNIRepetido("el docente " + docente.getDni() + " ya existe");
		docentes.add(docente);
	}

	public void agregarAlumno(Alumno alumno) throws PersonaConDNIRepetidoException {

		if (alumno == null)
			throw new IllegalArgumentException();
		for (Alumno a : alumnos) {
			if (a.getDni().equals(alumno.getDni())) {
				throw new PersonaConDNIRepetidoException("el alumno " + alumno.getDni() + " ya existe");
			}
		}

//		if (!alumnos.add(alumno))
//			throw new PersonaConDNIRepetido("el alumno " + alumno.getDni() + " ya existe");
		alumnos.add(alumno);
	}

	public Integer cantDocentes() {
		// TODO Auto-generated method stub
		return docentes.size();
	}

	public Integer cantAlumnos() {
		// TODO Auto-generated method stub
		return alumnos.size();
	}

	public String listarDocentes() {
		// TODO Auto-generated method stub
		return docentes.toString();
	}

	public String listarAlumnos() {
		// TODO Auto-generated method stub
		return alumnos.toString();
	}
	
	public String listarAlumnos(Comparator<Alumno> criterio) {

		List<Alumno> ordenados = new ArrayList<>(alumnos);
		ordenados.sort(criterio);

		StringBuilder sb = new StringBuilder();
		for (Alumno alumno : ordenados) {
			sb.append(alumno);
		}
		return sb.toString();
	}

	public String listarAlumnosPorAnioCursada() {
		return listarAlumnos(Comparator.comparing(Alumno::getAnioCursada).thenComparing(Persona::getApellido)
				.thenComparing(Persona::getDni));
	}

	public String listarAlumnosPorPromedio() {
		return listarAlumnos(Comparator.comparing(Alumno::getPromGeneral, Comparator.reverseOrder())
				.thenComparing(Persona::getApellido).thenComparing(Persona::getDni));
	}
}
