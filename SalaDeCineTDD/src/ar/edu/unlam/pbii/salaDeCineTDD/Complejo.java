package ar.edu.unlam.pbii.salaDeCineTDD;

import java.util.ArrayList;
import java.util.List;

public class Complejo {
	private String nombre;
	private List<Sala> salasComplejo = new ArrayList<Sala>();

	public Complejo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreComplejo() {
		return this.nombre;
	}

	public void agregarSala(Sala sala) {
		salasComplejo.add(sala);
	}

	public Integer getCantSalas() {
		return this.salasComplejo.size();
	}

	public Double getFacturacionComplejo() {
		Double facturacionComplejo = 0.0;

		for (Sala sala : salasComplejo) {
			facturacionComplejo += sala.getFacturaciónSala();
		}

		return facturacionComplejo;
	}

}
