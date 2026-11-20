package ar.edu.unlam.pbii.congreso;

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

}
