package ar.edu.unlam.pbii.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.supermercado.Producto;
import ar.edu.unlam.pbii.supermercado.Supermercado;
import ar.edu.unlam.pbii.supermercado.Ticket;
import ar.edu.unlam.pbii.supermercado.TicketEfectivo;
import ar.edu.unlam.pbii.supermercado.TicketFactura;

class Test {
	private Supermercado supermercado;
	private Producto leche = new Producto("lec-1234", 10, 1000.0);
	private Producto pan = new Producto("pan-2345", 20, 5.0);

	@BeforeEach
	public void setUp() {
		supermercado = new Supermercado("Economico");

	}

	@org.junit.jupiter.api.Test
	public void queUnTicketPuedaTenerProductosRepetidosYCalcularSubtotal() {
		Ticket ticket = new TicketEfectivo("TICKET-0001");

		ticket.agregarProducto(leche);
		ticket.agregarProducto(leche); // Repetido
		ticket.agregarProducto(pan);

		assertEquals(Integer.valueOf(3), ticket.getProductos());
		assertEquals(2005.0, ticket.calcularSubtotal(), 0.01);
	}

	@org.junit.jupiter.api.Test
	public void queNoSeAgregueUnProductoNuloAlTicket() {
		Ticket ticket = new TicketEfectivo("TICKET-0001");

		Boolean resultado = ticket.agregarProducto(null);

		assertFalse(resultado);
		assertEquals(Integer.valueOf(0), ticket.getProductos());
	}

	@org.junit.jupiter.api.Test
	public void queSeCalculeCorrectamenteElTotalDeUnTicketEfectivoConDescuento() {
		Ticket ticket = new TicketEfectivo("TICKET-0001");
		ticket.agregarProducto(leche); // 1000.0

		assertEquals(1000.0, ticket.calcularSubtotal(), 0.01);
		assertEquals(900.0, ticket.calcularTotal(), 0.01);
	}

	@org.junit.jupiter.api.Test
	public void queSeCalculeCorrectamenteElTotalDeUnTicketFacturaConIva() {
		Ticket ticket = new TicketFactura("TICKET-0002");
		ticket.agregarProducto(leche); // 1000.0

		assertEquals(1000.0, ticket.calcularSubtotal(), 0.01);
		assertEquals(1210.0, ticket.calcularTotal(), 0.01);
	}

	@org.junit.jupiter.api.Test
	public void queSePuedaEncolarUnTicketEnElSupermercado() {
		Ticket ticket = new TicketEfectivo("TICKET-0001");
		ticket.agregarProducto(pan);

		Boolean resultado = supermercado.encolarTicket(ticket);

		assertTrue(resultado);
		assertEquals(Integer.valueOf(1), supermercado.getCantidadTicketsPendientes());
	}

	@org.junit.jupiter.api.Test
	public void queNoSePuedaEncolarUnTicketNulo() {
		Boolean resultado = supermercado.encolarTicket(null);

		assertFalse(resultado);
		assertEquals(Integer.valueOf(0), supermercado.getCantidadTicketsPendientes());
	}

	@org.junit.jupiter.api.Test
	public void queSePuedaCobrarElProximoTicketRespetandoOrdenFIFO() {
		Ticket ticket1 = new TicketEfectivo("TICKET-0001");
		Ticket ticket2 = new TicketFactura("TICKET-0002");

		supermercado.encolarTicket(ticket1);
		supermercado.encolarTicket(ticket2);

		Ticket ticketCobrado = supermercado.cobrarProximoTicket();

		assertNotNull(ticketCobrado);
		assertEquals("TICKET-0001", ticketCobrado.getCodigo());
		assertEquals(Integer.valueOf(1), supermercado.getCantidadTicketsPendientes());
		assertEquals(Integer.valueOf(1), supermercado.getCantidadTicketsCobrados());
	}

	@org.junit.jupiter.api.Test
	public void queAlCobrarSinTicketsEnColaDevuelvaNull() {

		Ticket ticketCobrado = supermercado.cobrarProximoTicket();

		assertNull(ticketCobrado);
		assertEquals(Integer.valueOf(0), supermercado.getCantidadTicketsCobrados());
	}

	@org.junit.jupiter.api.Test
	public void queSePuedaBuscarUnTicketCobradoPorCodigo() {
		Ticket ticket1 = new TicketEfectivo("TICKET-0001");
		Ticket ticket2 = new TicketFactura("TICKET-0002");
		Ticket ticket3 = new TicketFactura("TICKET-0003");

		supermercado.encolarTicket(ticket1);
		supermercado.encolarTicket(ticket2);
		supermercado.encolarTicket(ticket3);

		Ticket ticketCobrado = supermercado.cobrarProximoTicket();
		Ticket encontrado = supermercado.buscarTicketCobradoPorCodigo("TICKET-0001");
		assertEquals(encontrado.getNroTicket(), ticketCobrado.getNroTicket());

		Ticket ticketCobrado2 = supermercado.cobrarProximoTicket();
		Ticket encontrado2 = supermercado.buscarTicketCobradoPorCodigo("TICKET-0002");
		assertEquals(encontrado2.getNroTicket(), ticketCobrado2.getNroTicket());

		Ticket ticketCobrado3 = supermercado.cobrarProximoTicket();
		Ticket encontrado3 = supermercado.buscarTicketCobradoPorCodigo("TICKET-0003");
		assertEquals(encontrado3.getNroTicket(), ticketCobrado3.getNroTicket());

	}

	@org.junit.jupiter.api.Test
	public void queAlProcesarTicketsSeActualiceElTotalRecaudadoYDisminuyaElPendiente() {
		Ticket ticket1 = new TicketEfectivo("TICKET-0001");
		Ticket ticket2 = new TicketFactura("TICKET-0002");

		supermercado.encolarTicket(ticket1);
		supermercado.encolarTicket(ticket2);
		supermercado.cobrarProximoTicket();
		supermercado.cobrarProximoTicket();

		assertEquals(Integer.valueOf(2), supermercado.getCantidadTicketsCobrados());
		assertEquals(Integer.valueOf(0), supermercado.getCantidadTicketsPendientes());

	}
}