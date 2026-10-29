package ar.edu.unlam.pbii.tienda;

public class Cliente {
	private String nombreCliente;
	private String dni;

	public Cliente(String nombreCliente, String dni) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getDni() {
		return dni;
	}
}
