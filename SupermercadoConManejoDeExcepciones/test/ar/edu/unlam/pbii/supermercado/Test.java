package ar.edu.unlam.pbii.supermercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.supermercado.Producto;
import ar.edu.unlam.pbii.supermercado.Supermercado;
import ar.edu.unlam.pbii.supermercado.TicketEfectivo;
import ar.edu.unlam.pbii.supermercado.TicketInexistenteException;
import ar.edu.unlam.pbii.supermercado.TicketRepetidoException;
import ar.edu.unlam.pbii.supermercado.Ticket;

class Test {

	private Supermercado supermercado;
	private Producto leche;
	private Producto pan;
	private Producto cocucha;

	@BeforeEach
	public void setUp() {
		supermercado = new Supermercado("Economico");
		leche = new Producto("lec-1234", 10, 1000.0);
		pan = new Producto("pan-2345", 20, 5.0);
		cocucha = new Producto("cocucha efervescente", 0, 10.0);

	}

	@org.junit.jupiter.api.Test
	void queAlAgregarUnDosProductosSeCalculeElSubtotalDelTicket()
			throws TicketRepetidoException, TicketInexistenteException, ProductoSinStocException {

		Ticket ticket = new TicketEfectivo("TE-1234");
		ticket.agregarProducto(leche);
		ticket.agregarProducto(pan);
		assertEquals(Integer.valueOf(2), ticket.getCantProd());
//		ticket.agregarProducto(cocucha); // punto donde falla el test
		assertThrows(ProductoSinStocException.class, () -> ticket.agregarProducto(cocucha));

	}

	@org.junit.jupiter.api.Test
	void queAlConsultarUnTicketInexxistenteArrojeTicketInexistenteException()
			throws TicketRepetidoException, TicketInexistenteException {

		Ticket ticket = new TicketEfectivo("TE-1234");

		supermercado.agregarTicket(ticket);

		assertThrows(TicketInexistenteException.class, () -> supermercado.buscarTicket("TE-4321"));

	}

	@org.junit.jupiter.api.Test
	void queAlAgregarUnTicketYaExistenteArrojeTicketRepetidoException()
			throws TicketRepetidoException, TicketInexistenteException {

		Ticket ticket = new TicketEfectivo("TE-1234");

		supermercado.agregarTicket(ticket);
		assertEquals(Integer.valueOf(1), supermercado.cantTickets());

		assertThrows(TicketRepetidoException.class, () -> supermercado.agregarTicket(ticket));
		assertEquals(Integer.valueOf(1), supermercado.cantTickets());

	}

}
