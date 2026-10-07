package ar.edu.unlam.pbii.supermercado;

public class TicketEfectivo extends Ticket {

	public TicketEfectivo(String nroTicket) {
		super(nroTicket);
	}

	@Override
	public Double calcularTotal() {
		Double total = 0.0;
		Double porcDesc = 0.10;
		for (Producto productos : super.productos) {
			total += productos.getPrecio() * (1.0 - porcDesc);
		}
		return total;
	}

}
