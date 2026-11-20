package ar.edu.unlam.pbii.congreso;

public class Charla extends Actividad {
	private Double valorBase = 0.0;

	public Charla(String nombreActividad, Integer cupoActividad) {
		super(nombreActividad, cupoActividad);
	}

	@Override
	public Double getArancel() {
		// TODO Auto-generated method stub
		return this.valorBase;
	}

}
