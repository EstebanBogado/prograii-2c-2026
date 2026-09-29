package ar.edu.unlam.pbii.salaDeCineTDD;

public class SalaGeneral extends Sala {

	public SalaGeneral(Integer filas, Integer columnas) {
		super(filas, columnas);
	}

	@Override
	public void setVolumen(Integer volumen) {
		if (volumen > 100)
			this.volumen = 100;
		if (volumen < 0)
			this.volumen = 0;
		this.volumen = volumen;
	}

	@Override
	public Integer getVolumen() {
		// TODO Auto-generated method stub
		return this.volumen;
	}
}