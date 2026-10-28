package ar.edu.unlam.pbii.escuelaDemo;

public abstract class ItemAlquilable implements Alquilable {

	protected String nroSerie;
	protected Boolean disponible;

	public ItemAlquilable(String nroSerie) {
		this.nroSerie = nroSerie;

	}

	@Override
	public Boolean estaDisponible() {
		// TODO Auto-generated method stub
		return disponible = true;
	}

	@Override
	public Boolean noDisponible() {
		// TODO Auto-generated method stub
		return disponible = false;

	}

	public Boolean getDisponible() {
		return this.disponible;
	}

	public String getNroSerie() {
		return nroSerie;
	}
}
