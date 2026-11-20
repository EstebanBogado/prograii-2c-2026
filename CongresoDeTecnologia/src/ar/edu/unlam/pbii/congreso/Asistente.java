package ar.edu.unlam.pbii.congreso;

import java.util.Objects;

public class Asistente {

	private String dni;
	private String nombreAsistente;
	private String apellidoAsistente;
	private Acreditacion acreditacion;

	public Asistente(String dni, String nombreAsistente, String apellidoAsistente) {
		this.dni = dni;
		this.nombreAsistente = nombreAsistente;
		this.apellidoAsistente = apellidoAsistente;
		this.acreditacion = Acreditacion.GENERAL;

	}

	public String getDni() {
		return dni;
	}

	public String getNombreAsistente() {
		return nombreAsistente;
	}

	public String getApellidoAsistente() {
		return apellidoAsistente;
	}

	public void setAcreditacion(Acreditacion acreditacion) {

		this.acreditacion = acreditacion;

	}

	public Acreditacion getAcreditacion() {
		return this.acreditacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asistente other = (Asistente) obj;
		return Objects.equals(dni, other.dni);
	}

}
