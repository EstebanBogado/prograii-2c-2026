package ar.edu.unlam.pbii.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private List<Ticket> tickets = new ArrayList<>();
	private String nombre;

	public Supermercado(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreSupermercado() {
		return this.nombre;
	}

	public void agregarTicket(Ticket ticket) throws TicketRepetidoException, TicketInexistenteException {

		if (ticket == null)
			throw new IllegalArgumentException("El ticket no puede ser null");
		for (Ticket busqueda : tickets) {
			if (busqueda.getNroTicket().equals(ticket.getNroTicket())) {
				throw new TicketRepetidoException("Nro de ticket repetido");
			}
		}
		tickets.add(ticket);
	}

	public Ticket buscarTicket(String nroTicket) throws TicketInexistenteException {

		Ticket ticketEncontrado = null;
		for (Ticket t : tickets) {
			if (t.getNroTicket().equals(nroTicket)) {
				ticketEncontrado = t;
				break;
			}
		}
		if (ticketEncontrado == null)
			throw new TicketInexistenteException("Ticket inexistente");
		return ticketEncontrado;
	}

	public Integer cantTickets() {
		return tickets.size();
	}
}
