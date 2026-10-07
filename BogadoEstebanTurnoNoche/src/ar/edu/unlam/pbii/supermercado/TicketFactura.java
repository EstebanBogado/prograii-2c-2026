package ar.edu.unlam.pbii.supermercado;

public class TicketFactura extends Ticket {

	public TicketFactura(String nroTicket) {
		super(nroTicket);
	}

	@Override
	public Double calcularTotal() {
		Double total = 0.0;
		Double porcInc = 0.21;
		for (Producto productos : super.productos) {
			total += productos.getPrecio() * (1.0 + porcInc);
		}
		return total;
	}

}
