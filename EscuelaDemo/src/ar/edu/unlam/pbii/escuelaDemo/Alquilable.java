package ar.edu.unlam.pbii.escuelaDemo;

public interface Alquilable {

	 default Boolean estaDisponible() {
		 return true;
	 }

}
