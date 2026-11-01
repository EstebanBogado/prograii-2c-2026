package ar.edu.unlam.pbii.tienda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class TiendaTest {

	@Test
	public void queSePuedaCrearUnProductoFisico() {
		ProductoFisico productoFisico = new ProductoFisico(15, "Camiseta", 45.0, "Camiseta de Futbol", 10, "10x20x5",
				0.5);
		assertNotNull(productoFisico);
	}

	@Test
	public void queSePuedaCrearUnProductoDigital() {

		ProductoDigital productoDigital = new ProductoDigital(1, "Libro electrónico", 9.99, "El Señor de los anillos 2",
				20, "PDF", 500);

		new ProductoDigital(2, "Curso de programación en Python", 49.99, "Aprende a programar desde cero", 100, "MP4",
				2000);
		new ProductoDigital(3, "Álbum: Música para relajarse", 7.99, "10 canciones instrumentales", 50, "MP3", 150);
		new ProductoDigital(4, "Juego: Pixel Adventure", 14.99, "Explora un mundo pixelado lleno de aventuras", 30,
				"EXE", 500);
		new ProductoDigital(5, "App: Organizador de tareas", 2.99, "Gestiona tus tareas diarias", 1000, "APK", 10);
		new ProductoDigital(6, "Fuente: Script Elegant", 19.99, "Fuente con estilo caligráfico", 20, "OTF", 2);
		new ProductoDigital(7, "Plantilla: Diseño de sitio web", 24.99, "Crea tu sitio web en minutos", 50, "FIG", 5);
		new ProductoDigital(9, "Libro: Introducción a la inteligencia artificial", 29.99,
				"Explora los conceptos básicos de la IA", 80, "EPUB", 300);
		new ProductoDigital(10, "Suscripción: Plataforma de streaming", 9.99, "Accede a miles de películas y series", 1,
				"LINK", 1);

		assertNotNull(productoDigital);
	}

	@Test
	public void queSePuedaCrearUnProductoPersonalizado() {

		ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado(1, "Tarta personalizada", 35.0,
				"Tarta personalizada Chocolate de cumpleaños", 10, new ArrayList<>());
		ProductoPersonalizado tarta = new ProductoPersonalizado(2, "Tarta personalizada", 35.0,
				"Tarta de cumpleaños con diseño personalizado", 10, new ArrayList<>());
		ProductoPersonalizado taza = new ProductoPersonalizado(3, "Taza personalizada", 15.0,
				"Taza de cerámica con foto", 20, new ArrayList<>());
		ProductoPersonalizado camiseta = new ProductoPersonalizado(4, "Camiseta personalizada", 20.0,
				"Camiseta de algodón orgánico con diseño personalizado", 30, new ArrayList<>());
		ProductoPersonalizado almohada = new ProductoPersonalizado(5, "Almohada personalizada", 25.0,
				"Almohada de microfibra con foto", 15, new ArrayList<>());
		ProductoPersonalizado joya = new ProductoPersonalizado(6, "Joyería personalizada", 50.0,
				"Collar con nombre grabado", 10, new ArrayList<>());
		ProductoPersonalizado funda = new ProductoPersonalizado(7, "Funda de teléfono personalizada", 12.0,
				"Funda de silicona con diseño personalizado", 50, new ArrayList<>());
		ProductoPersonalizado puzzle = new ProductoPersonalizado(8, "Puzzle personalizado", 30.0,
				"Puzzle de 1000 piezas con foto personalizada", 15, new ArrayList<>());
		ProductoPersonalizado libro = new ProductoPersonalizado(9, "Libro personalizado", 40.0,
				"Libro de cuentos personalizado con el nombre del niño", 8, new ArrayList<>());
		ProductoPersonalizado poster = new ProductoPersonalizado(10, "Póster personalizado", 22.0,
				"Póster enmarcado con diseño personalizado", 20, new ArrayList<>());
		ProductoPersonalizado caja = new ProductoPersonalizado(11, "Caja de regalo personalizada", 18.0,
				"Caja de madera con grabado personalizado", 15, new ArrayList<>());
		assertNotNull(productoPersonalizado);
		assertNotNull(caja);
		assertNotNull(poster);
		assertNotNull(libro);
		assertNotNull(puzzle);
		assertNotNull(funda);
		assertNotNull(joya);
		assertNotNull(almohada);
		assertNotNull(camiseta);
		assertNotNull(taza);
		assertNotNull(tarta);

	}

	@Test
	public void queSePuedanIncorporarDistintosProductosALaTienda() {
		Tienda tienda = new Tienda();
		ProductoFisico productoFisico = new ProductoFisico(10, "Camiseta", 45.0, "Camiseta de Futbol de River", 10, "10x20x5",
				0.5);
		ProductoDigital productoDigital = new ProductoDigital(4, "Juego: Pixel Adventure", 14.99,
				"Explora un mundo pixelado lleno de aventuras", 30, "EXE", 500);
		ProductoDigital productoDigital1 = new ProductoDigital(10, "Juego: Pixel Adventure", 14.99,
				"Explora un mundo pixelado lleno de aventuras", 30, "EXE", 500);
		ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado(5, "Almohada personalizada", 25.0,
				"Almohada de microfibra con foto", 15, new ArrayList<>());
		ProductoPersonalizado almohada = new ProductoPersonalizado(5, "Almohada personalizada", 25.0,
				"Almohada de microfibra con foto", 15, new ArrayList<>());
		ProductoPersonalizado joya = new ProductoPersonalizado(6, "Joyería personalizada", 50.0,
				"Collar con nombre grabado", 10, new ArrayList<>());
		ProductoPersonalizado funda = new ProductoPersonalizado(7, "Funda de teléfono personalizada", 12.0,
				"Funda de silicona con diseño personalizado", 50, new ArrayList<>());
		ProductoPersonalizado puzzle = new ProductoPersonalizado(8, "Puzzle personalizado", 30.0,
				"Puzzle de 1000 piezas con foto personalizada", 15, new ArrayList<>());
		ProductoPersonalizado libro = new ProductoPersonalizado(9, "Libro personalizado", 40.0,
				"Libro de cuentos personalizado con el nombre del niño", 8, new ArrayList<>());
		ProductoPersonalizado poster = new ProductoPersonalizado(10, "Póster personalizado", 22.0,
				"Póster enmarcado con diseño personalizado", 20, new ArrayList<>());
		ProductoPersonalizado caja = new ProductoPersonalizado(11, "Caja de regalo personalizada", 18.0,
				"Caja de madera con grabado personalizado", 15, new ArrayList<>());

		tienda.agregarProducto(productoFisico);
		tienda.agregarProducto(productoDigital);
		tienda.agregarProducto(productoDigital1);
		tienda.agregarProducto(productoPersonalizado);
		tienda.agregarProducto(almohada);
		tienda.agregarProducto(joya);
		tienda.agregarProducto(funda);
		tienda.agregarProducto(puzzle);
		tienda.agregarProducto(libro);
		tienda.agregarProducto(poster);
		tienda.agregarProducto(caja);

		assertEquals(8, tienda.getProductos().size());
	}

	@Test
	public void queSePuedaAgregarUnProductoAlCarritoDeUnCliente() {
		// Crear un producto y un cliente
		Producto producto = new ProductoFisico(10, "Camiseta", 45.0, "Camiseta de Futbol de River", 10, "10x20x5", 0.5);
		ProductoPersonalizado libro = new ProductoPersonalizado(9, "Libro personalizado", 40.0,
				"Libro de cuentos personalizado con el nombre del niño", 8, new ArrayList<>());
		ProductoPersonalizado poster = new ProductoPersonalizado(12, "Póster personalizado", 22.0,
				"Póster enmarcado con diseño personalizado", 20, new ArrayList<>());
		ProductoPersonalizado caja = new ProductoPersonalizado(11, "Caja de regalo personalizada", 18.0,
				"Caja de madera con grabado personalizado", 15, new ArrayList<>());
		Cliente cliente = new Cliente("Juan", "12345678");

		Tienda tienda = new Tienda();

		tienda.agregarProducto(producto);
		tienda.agregarProducto(poster);
		tienda.agregarProducto(caja);
		tienda.agregarProducto(libro);

		// Agregar el producto al carrito
		cliente.agregarProductoAlCarrito(tienda, 10);
		cliente.agregarProductoAlCarrito(tienda, 9);
		cliente.agregarProductoAlCarrito(tienda, 12);
		cliente.agregarProductoAlCarrito(tienda, 11);

		// Verificar que el carrito tenga un producto
		assertEquals(4, cliente.getCarrito().getProductos().size());
	}

//
	@Test
	public void queUnProductoPersonalizadoPuedeAgregarCaracteristicas() {
		Tienda tienda = new Tienda();

		ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado(6, "Joyería personalizada", 50.0,
				"Collar con nombre grabado", 10, new ArrayList<>());
		tienda.agregarProducto(productoPersonalizado);

		try {
			tienda.agregarCaracteristicaAProducto(productoPersonalizado, Caracteristica.LOGO_PERSONAL);
			tienda.agregarCaracteristicaAProducto(productoPersonalizado, Caracteristica.COLOR_AZUL);
			tienda.agregarCaracteristicaAProducto(productoPersonalizado, Caracteristica.GRABADO);
		} catch (ProductoNoEncontradoException e) {
			assertTrue(false);
		} catch (ProductoNoSoportadoException e) {
			assertTrue(false);
		}

		assertEquals(3, productoPersonalizado.getCaracteristicas().size());
	}

	@Test
	public void queUnProductoFisicoNoPuedaAgregarCaracteristicas() {
		Tienda tienda = new Tienda();
		ProductoFisico productoFisico = new ProductoFisico(4, "Camiseta", 45.0, "Camiseta de Futbol de River", 10, "10x20x5",
				0.5);
		ProductoDigital productoDigital = new ProductoDigital(9, "Libro: Introducción a la inteligencia artificial",
				29.99, "Explora los conceptos básicos de la IA", 80, "EPUB", 300);
		tienda.agregarProducto(productoFisico);
		tienda.agregarProducto(productoDigital);

		assertThrows(ProductoNoSoportadoException.class, () -> {
			tienda.agregarCaracteristicaAProducto(productoFisico, Caracteristica.LOGO_PERSONAL);
		});

		assertThrows(ProductoNoSoportadoException.class, () -> {
			tienda.agregarCaracteristicaAProducto(productoDigital, Caracteristica.COLOR_VERDE);
		});
	}

	@Test
	public void obtenerListadoDeProductosFisicosOrdenadosPorDimension() {
		// Implementar la lógica para ordenar los productos físicos por dimensión
		ProductoFisico productoFisico = new ProductoFisico(100, "Camiseta", 45.0, "Camiseta de Futbol de River", 10,
				"15x20x5", 0.5);
		ProductoFisico productoFisico1 = new ProductoFisico(110, "Camiseta", 45.0, "Camiseta de Futbol de River", 10,
				"10x25x5", 0.5);
		ProductoFisico productoFisico2 = new ProductoFisico(120, "Camiseta", 45.0, "Camiseta de Futbol de River", 10,
				"10x20x8", 0.5);
		Tienda tienda = new Tienda();

		tienda.agregarProducto(productoFisico);
		tienda.agregarProducto(productoFisico1);
		tienda.agregarProducto(productoFisico2);

		List<ProductoFisico> ordenadosPorDimension = new ArrayList<ProductoFisico>();
		ordenadosPorDimension.addAll(tienda.ordenarProductoFisicoPorDimension());

		assertEquals("10x20x8", ordenadosPorDimension.get(0).getDimensiones());
		assertEquals("10x25x5", ordenadosPorDimension.get(1).getDimensiones());
		assertEquals("15x20x5", ordenadosPorDimension.get(2).getDimensiones());
	}

	@Test
	public void obtenerListadoDeProductosDigitalesOrdenadosPorFormato() {
//		 Implementar la lógica para ordenar los productos digitales por formato
		ProductoDigital productoDigital = new ProductoDigital(4, "Juego: Pixel Adventure", 14.99,
				"Explora un mundo pixelado lleno de aventuras", 30, "EXE", 500);
		ProductoDigital productoDigital1 = new ProductoDigital(10, "Juego: Pixel Adventure", 14.99,
				"Explora un mundo pixelado lleno de aventuras", 30, "EXE", 500);
		ProductoDigital productoDigital2 = new ProductoDigital(1, "Libro electrónico", 9.99,
				"El Señor de los anillos 2", 20, "PDF", 500);
		ProductoDigital productoDigital3 = new ProductoDigital(2, "Curso de programación en Python", 49.99,
				"Aprende a programar desde cero", 100, "MP4", 2000);
		ProductoDigital productoDigital4 = new ProductoDigital(3, "Álbum: Música para relajarse", 7.99,
				"10 canciones instrumentales", 50, "MP3", 150);
		ProductoDigital productoDigital5 = new ProductoDigital(14, "Juego: Pixel Adventure", 14.99,
				"Explora un mundo pixelado lleno de aventuras", 30, "EXE", 500);
		Tienda tienda = new Tienda();

		tienda.agregarProducto(productoDigital);
		tienda.agregarProducto(productoDigital1);
		tienda.agregarProducto(productoDigital2);
		tienda.agregarProducto(productoDigital3);
		tienda.agregarProducto(productoDigital4);
		tienda.agregarProducto(productoDigital5);

		List<ProductoDigital> ordenadosPorFormato = new ArrayList<ProductoDigital>();
		ordenadosPorFormato.addAll(tienda.ordenarProductoDigitalPorFormato());

		assertEquals("EXE", ordenadosPorFormato.get(0).getFormato());
		assertEquals("EXE", ordenadosPorFormato.get(1).getFormato());
		assertEquals("EXE", ordenadosPorFormato.get(2).getFormato());
		assertEquals("MP3", ordenadosPorFormato.get(3).getFormato());
		assertEquals("MP4", ordenadosPorFormato.get(4).getFormato());
		assertEquals("PDF", ordenadosPorFormato.get(5).getFormato());
	}

	@Test
	public void obtenerListadoDeProductosPersonalizadosCantidadDeCaracteristicas()
			throws ProductoNoEncontradoException, ProductoNoSoportadoException {
		// Implementar la lógica para obtener la cantidad de características de cada
		// producto personalizado
		Tienda tienda = new Tienda();

		ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado(5, "Almohada personalizada", 25.0,
				"Almohada de microfibra con foto", 15, new ArrayList<>());
		ProductoPersonalizado almohada = new ProductoPersonalizado(25, "Almohada personalizada", 25.0,
				"Almohada de microfibra con foto", 15, new ArrayList<>());
		ProductoPersonalizado joya = new ProductoPersonalizado(6, "Joyería personalizada", 50.0,
				"Collar con nombre grabado", 10, new ArrayList<>());
		ProductoPersonalizado funda = new ProductoPersonalizado(7, "Funda de teléfono personalizada", 12.0,
				"Funda de silicona con diseño personalizado", 50, new ArrayList<>());
		ProductoPersonalizado puzzle = new ProductoPersonalizado(8, "Puzzle personalizado", 30.0,
				"Puzzle de 1000 piezas con foto personalizada", 15, new ArrayList<>());
		ProductoPersonalizado libro = new ProductoPersonalizado(9, "Libro personalizado", 40.0,
				"Libro de cuentos personalizado con el nombre del niño", 8, new ArrayList<>());
		ProductoPersonalizado poster = new ProductoPersonalizado(10, "Póster personalizado", 22.0,
				"Póster enmarcado con diseño personalizado", 20, new ArrayList<>());
		ProductoPersonalizado caja = new ProductoPersonalizado(11, "Caja de regalo personalizada", 18.0,
				"Caja de madera con grabado personalizado", 15, new ArrayList<>());

		tienda.agregarProducto(productoPersonalizado);
		tienda.agregarProducto(almohada);
		tienda.agregarProducto(poster);
		tienda.agregarProducto(funda);

		tienda.agregarCaracteristicaAProducto(productoPersonalizado, Caracteristica.LOGO_PERSONAL);
		tienda.agregarCaracteristicaAProducto(productoPersonalizado, Caracteristica.COLOR_AZUL);
		tienda.agregarCaracteristicaAProducto(productoPersonalizado, Caracteristica.GRABADO);

		tienda.agregarCaracteristicaAProducto(almohada, Caracteristica.LOGO_PERSONAL);
		tienda.agregarCaracteristicaAProducto(almohada, Caracteristica.COLOR_AZUL);

		tienda.agregarCaracteristicaAProducto(poster, Caracteristica.LOGO_PERSONAL);
		tienda.agregarCaracteristicaAProducto(poster, Caracteristica.COLOR_AZUL);
		tienda.agregarCaracteristicaAProducto(poster, Caracteristica.GRABADO);
		tienda.agregarCaracteristicaAProducto(poster, Caracteristica.DEDICATORIA);

		tienda.agregarCaracteristicaAProducto(funda, Caracteristica.LOGO_PERSONAL);

		List<ProductoPersonalizado> lista = new ArrayList<ProductoPersonalizado>(
				tienda.ordenarProductoPersonalizadoPorCantCaracteristicas());
		
		assertEquals(Integer.valueOf(1), lista.get(0).getCantCaracteristicas());
		assertEquals(Integer.valueOf(3), lista.get(2).getCantCaracteristicas());
		assertEquals(Integer.valueOf(4), lista.get(3).getCantCaracteristicas());
		assertEquals(Integer.valueOf(2), lista.get(1).getCantCaracteristicas());

	}
}