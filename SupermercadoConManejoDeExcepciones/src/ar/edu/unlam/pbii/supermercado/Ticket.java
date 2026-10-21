package ar.edu.unlam.pbii.supermercado;

import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {

	protected String nroTicket;
	protected Double monto;
	protected List<Producto> productos = new ArrayList<Producto>();

	public Ticket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public String getNroTicket() {
		return this.nroTicket;

	}

	public Double getSubtotalTicket() {
		return this.monto;
	}

	protected void agregarProducto(Producto producto) throws ProductoSinStocException {
		if (producto == null) {
			throw new IllegalArgumentException("El producto no puede ser null");
		}
		if (producto.getStockProd() == 0)
			throw new ProductoSinStocException("No hay existencia del producto " + producto.getCodProd());
		productos.add(producto);
	}

	public Integer getCantProd() {
		return productos.size();
	}
}
