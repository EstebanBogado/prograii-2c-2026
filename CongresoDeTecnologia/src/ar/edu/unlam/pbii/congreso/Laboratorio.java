package ar.edu.unlam.pbii.congreso;

public class Laboratorio extends Actividad {

	private Double valorBase;

	public Laboratorio(String nombreActividad, Integer cupoActividad, Double valorBase) {
		super(nombreActividad, cupoActividad);
		this.valorBase = valorBase;
	}

	@Override
	public Double getArancel() {
		// TODO Auto-generated method stub
		return this.valorBase;
	}

}
