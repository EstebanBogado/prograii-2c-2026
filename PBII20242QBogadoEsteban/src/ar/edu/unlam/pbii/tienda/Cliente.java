package ar.edu.unlam.pbii.tienda;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombreCliente;
	private String dni;
	private List<Producto> carrito;

	public Cliente(String nombreCliente, String dni) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.carrito = new ArrayList<Producto>();
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void agregarProductoAlCarrito(Producto producto) {

		
		
	}
}
