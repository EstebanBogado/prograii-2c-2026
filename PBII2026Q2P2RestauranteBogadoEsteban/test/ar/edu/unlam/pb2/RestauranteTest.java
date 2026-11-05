package ar.edu.unlam.pb2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unlam.pb2.dominio.Bebida;
import ar.edu.unlam.pb2.dominio.Cliente;
import ar.edu.unlam.pb2.dominio.Hamburguesa;
//import ar.edu.unlam.pb2.dominio.IPersonalizable;
import ar.edu.unlam.pb2.dominio.IngredienteExtra;
import ar.edu.unlam.pb2.dominio.Pedido;
import ar.edu.unlam.pb2.dominio.Pizza;
import ar.edu.unlam.pb2.dominio.Producto;
import ar.edu.unlam.pb2.excepciones.ClienteInexistenteException;
import ar.edu.unlam.pb2.excepciones.ProductoDuplicadoException;

public class RestauranteTest {

	private Restaurante restaurante;
	private Cliente cliente;

	@BeforeEach
	public void setUp() {
		this.restaurante = new Restaurante("FastFood Express");
		this.cliente = new Cliente("38123456", "Matias Gonzalez");
	}

	@Test
	public void queSePuedanIncorporarDistintosProductosAlRestaurante() throws ProductoDuplicadoException {
		Producto burger = new Hamburguesa(1, "Doble Cuarto", 4000.0, 2);
		Producto pizza = new Pizza(2, "Muzzarella", 5000.0, "A la piedra");
		Producto bebida = new Bebida(3, "Agua Mineral", 1000.0, false);

		assertTrue(restaurante.agregarProducto(burger));
		assertTrue(restaurante.agregarProducto(pizza));
		assertTrue(restaurante.agregarProducto(bebida));

		assertEquals(3, restaurante.getProductos().size());
	}

	@Test
	public void queAlAgregarUnProductoDuplicadoSeLanceProductoDuplicadoException() throws ProductoDuplicadoException {
		Producto burger1 = new Hamburguesa(1, "Doble Cuarto", 4000.0, 2);
		Producto burgerClon = new Hamburguesa(1, "Doble Cuarto Clon", 4000.0, 2);

		restaurante.agregarProducto(burger1);

		assertThrows(ProductoDuplicadoException.class, () -> {
			restaurante.agregarProducto(burgerClon);
		});
	}

	@Test
	public void queSePuedaRegistrarUnClienteEnElRestaurante() throws ClienteInexistenteException {
		assertTrue(restaurante.registrarCliente(cliente));
		assertEquals(1, restaurante.getClientes().size());
	}

	@Test
	public void queNoSePermitaRegistrarUnClienteDuplicado() {
		Cliente clienteClon = new Cliente("38123456", "Matias Gonzalez Clon");

		assertTrue(restaurante.registrarCliente(cliente));
		assertFalse(restaurante.registrarCliente(clienteClon));
		assertEquals(1, restaurante.getClientes().size());
	}

	@Test
	public void queSePuedaAgregarUnPedidoParaUnClienteRegistrado() throws ClienteInexistenteException {
		restaurante.registrarCliente(cliente);

		Pedido pedido = new Pedido(1001, cliente);
		pedido.agregarProducto(new Hamburguesa(1, "Doble Cuarto", 4000.0, 2));
		pedido.agregarProducto(new Bebida(2, "Gaseosa", 1200.0, false));

		assertTrue(restaurante.agregarPedido(pedido));
		assertEquals(1, restaurante.getPedidos().size());
		assertEquals(2, pedido.getProductos().size());
	}

//	@Test
//	public void queAlCrearUnPedidoParaUnClienteNoRegistradoSeLanceClienteInexistenteException()
//			throws ClienteInexistenteException {
//		Cliente clienteNoRegistrado = new Cliente("99999999", "Cliente Fantasma");
//		Pedido pedido = new Pedido(1002, clienteNoRegistrado);
//
//		assertThrows(ClienteInexistenteException.class, () -> {
//			restaurante.agregarPedido(pedido);
//		});
//	}

	@Test
	public void queSePuedaCalcularElTotalDeUnPedido() throws ClienteInexistenteException {
		Pedido pedido = new Pedido(1001, cliente);

		Hamburguesa burger = new Hamburguesa(1, "Doble Cuarto", 4000.0, 2);
		Pizza pizza = new Pizza(2, "Muzzarella", 5000.0, "A la piedra");
		Bebida bebidaConAlcohol = new Bebida(3, "Cerveza", 2000.0, true);
		Bebida bebidaSinAlcohol = new Bebida(4, "Agua Mineral", 1000.0, false);

		burger.agregarIngrediente(IngredienteExtra.CHEDDAR);
		burger.agregarIngrediente(IngredienteExtra.PANCETA);
		pizza.agregarIngrediente(IngredienteExtra.DOBLE_QUESO);

		pedido.agregarProducto(burger);
		pedido.agregarProducto(pizza);
		pedido.agregarProducto(bebidaConAlcohol);
		pedido.agregarProducto(bebidaSinAlcohol);

		assertEquals(14200.0, pedido.calcularTotal(), 0.01);
	}

//	@Test
//	public void queSePuedanAgregarIngredientesExtrasAProductosPersonalizables() {
//		Hamburguesa burger = new Hamburguesa(1, "Mega Burger", 5000.0, 3);
//		Pizza pizza = new Pizza(2, "Especial", 6500.0, "Al molde");
//		Producto bebida = new Bebida(3, "Gaseosa", 1200.0, false);
//
//		restaurante.agregarIngredienteAProducto(burger, IngredienteExtra.CHEDDAR);
//		restaurante.agregarIngredienteAProducto(burger, IngredienteExtra.PANCETA);
//		restaurante.agregarIngredienteAProducto(pizza, IngredienteExtra.DOBLE_QUESO);
//
//		assertEquals(2, burger.getIngredientesExtras().size());
//		assertEquals(1, pizza.getIngredientesExtras().size());
//
//		assertThrows(ClassCastException.class, () -> {
//			restaurante.agregarIngredienteAProducto((IPersonalizable) bebida, IngredienteExtra.CHEDDAR);
//		});
	}
//
//    @Test
//    public void obtenerListadoDePizzasOrdenadasPorNombre() throws ProductoDuplicadoException {
//        //TODO
//        restaurante.ordenarPizzasPorNombre();
//        assertTrue(false);
//    }
//
//    @Test
//    public void obtenerListadoDePedidosOrdenadosPorMayorPrecio() throws ClienteInexistenteException {
//
//         //TODO
//         restaurante.ordenarPedidosPorMayorPrecio();
//         assertTrue(false);
//
//    }
}