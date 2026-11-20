package ar.edu.unlam.pbii.congreso;

public abstract class Actividad {

	protected String nombreActividad;
	protected Integer cupoActividad;

	public Actividad(String nombreActividad, Integer cupoActividad) {
		this.nombreActividad = nombreActividad;
		this.cupoActividad = cupoActividad;
	}

	public String getNombreAcividad() {
		return nombreActividad;
	}

	public Integer getCupoActividad() {
		return cupoActividad;
	}

	public abstract Double getArancel();

}
