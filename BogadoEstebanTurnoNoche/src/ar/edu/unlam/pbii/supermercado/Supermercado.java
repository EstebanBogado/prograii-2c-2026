package ar.edu.unlam.pbii.supermercado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Supermercado {
	private Queue<Ticket> ticketsPendientes = new LinkedList<>();
	private List<Ticket> ticketsCobrados = new ArrayList<Ticket>();
	private Double montoPorCobrar = 0.0;
	private Double montoFacturado = 0.0;

	private String nombre;

	public Supermercado(String nombre) {
		this.nombre = nombre;
	}

	public Boolean encolarTicket(Ticket ticket) {
		if (ticket != null) {
			ticketsPendientes.add(ticket);
			return true;
		}
		return false;
	}

	public Integer getCantidadTicketsPendientes() {
		return this.ticketsPendientes.size();
	}

	public String getNombre() {
		return nombre;
	}

	public Ticket cobrarProximoTicket() {

		if (this.ticketsPendientes.isEmpty()) {
			return null;
		}
		this.ticketsCobrados.add(this.ticketsPendientes.poll());
		return this.ticketsCobrados.getLast();
	}

	

	public Double montoPorCobrar() {
		Double total = 0.0;

		for (Ticket ticket : ticketsPendientes) {
			total += ticket.calcularTotal();
		}

		return total;
	}

	public Double montoFacturado() {
		Double total = 0.0;
		for (Ticket ticket : ticketsCobrados) {
			total += ticket.calcularTotal();
		}
		return total;
	}

	public Integer getCantidadTicketsCobrados() {
		// TODO Auto-generated method stub
		return this.ticketsCobrados.size();
	}

	public Ticket buscarTicketCobradoPorCodigo(String nroTicket) {
		for (Ticket ticket : ticketsCobrados) {
			if (ticket.getCodigo().equals(nroTicket))
				return ticket;
		}
		return null;
	}
}
