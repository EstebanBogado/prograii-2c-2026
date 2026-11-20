package ar.edu.unlam.pbii.congreso;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Congreso {

	private String nombreCongreso;
	private Set<Asistente> asistentes = new HashSet<Asistente>();

	public Congreso(String nombreCongreso) {
		this.nombreCongreso = nombreCongreso;
	}

	public String getNombreCongreso() {
		return nombreCongreso;
	}

	public Asistente setAcreditacion(Acreditacion acreditacion) {

		return null;
	}

	public void registrarAsistente(Asistente asistente) {
		for (Asistente asist : asistentes) {
			if (asistente.getDni().equals(asist.getDni())) {
				return;
			}
		}
		asistentes.add(asistente);

	}

	public Integer getCantAsist() {
		// TODO Auto-generated method stub
		return this.asistentes.size();
	}

}
