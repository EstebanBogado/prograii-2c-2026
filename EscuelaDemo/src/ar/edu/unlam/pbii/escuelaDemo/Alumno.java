package ar.edu.unlam.pbii.escuelaDemo;

public class Alumno extends Persona {

	private String anioCursada;
	private String division;
	private Double promGeneral;

	public Alumno(String dni, String apellido, String nombre, String anioCursada, String division, Double promGeneral)
			throws NotaPromedioGeneralInvalidaException {
		super(dni, apellido, nombre);
		this.anioCursada = anioCursada;
		this.division = division;
		if (promGeneral <= 0.0 || promGeneral > 10.0)
			throw new NotaPromedioGeneralInvalidaException("El promedio general debe estar entre 1 y 10");
		else
			this.promGeneral = promGeneral;
	}

	public String getAnioCursada() {
		return anioCursada;
	}

	public String getDivision() {
		return division;
	}

	public Double getPromGeneral() {
		return promGeneral;
	}

	@Override
	public String toString() {
		return super.toString() + "Alumno [anioCursada=" + anioCursada + ", division=" + division + ", promGeneral="
				+ promGeneral + "]\n";
	}

}