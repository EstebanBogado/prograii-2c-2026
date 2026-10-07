package ar.edu.unlam.pbii.supermercado;

import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {
	protected String nroTicket;
	protected List<Producto> productos = new ArrayList<Producto>();
	protected Double subtotal = 0.0;

	public Ticket(String nroTicket) {
		this.nroTicket = nroTicket;

	}

	public String getNroTicket() {
		return nroTicket;
	}

	public Boolean agregarProducto(Producto producto) {
		if (producto != null && producto.getExistencias() > 0) {
			productos.add(producto);
			producto.quitarDeStock();
			return true;
		}
		return false;

	}

	public Integer getProductos() {
		return this.productos.size();
	}

	public double calcularSubtotal() {
		Double total = 0.0;

		for (Producto producto : productos) {
			total += producto.getPrecio();
		}
		return total;
	}

	public abstract Double calcularTotal();

	public String getCodigo() {
		return this.nroTicket;
	}

}
