package ar.edu.unlam.pbii.congreso;

public class Taller extends Actividad {

	private Double valorBase;

	public Taller(String nombreActividad, Integer cupoActividad, Double valorBase) {
		super(nombreActividad, cupoActividad);
		this.valorBase = valorBase;
	}

	@Override
	public Double getArancel() {
		return this.valorBase;
	}

}
