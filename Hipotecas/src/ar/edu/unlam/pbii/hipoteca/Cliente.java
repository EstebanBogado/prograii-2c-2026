package ar.edu.unlam.pbii.hipoteca;

import java.util.Objects;

public class Cliente {
	private String codCli;
	private String nomCli;
	private String domicCli;
	private Double sueldoDeclarado;

	public Cliente(String codCli, String nomCli, String domicCli, Double sueldoDecalarado) {
		this.codCli = codCli;
		this.nomCli = nomCli;
		this.domicCli = domicCli;
		this.sueldoDeclarado = sueldoDecalarado;
	}

	public String getCodCli() {
		return codCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public String getDomicCli() {
		return domicCli;
	}

	public Double getSueldoDeclarado() {
		return sueldoDeclarado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCli);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codCli, other.codCli);
	}
}
