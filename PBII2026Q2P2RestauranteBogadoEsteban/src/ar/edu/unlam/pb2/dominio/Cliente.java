package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Cliente {
	private String dni;
	private String nombreCliente;

	public Cliente(String dni, String nombreCliente) {
		this.dni = dni;
		this.nombreCliente = nombreCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}
}
