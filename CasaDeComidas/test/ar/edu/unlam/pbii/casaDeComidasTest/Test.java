package ar.edu.unlam.pbii.casaDeComidasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.casaDeComidas.Bebida;
import ar.edu.unlam.pbii.casaDeComidas.Local;
import ar.edu.unlam.pbii.casaDeComidas.Menu;
import ar.edu.unlam.pbii.casaDeComidas.Mesa;
import ar.edu.unlam.pbii.casaDeComidas.Plato;

class Test {
	private Local central;

	@BeforeEach
	void setUp() {
		central = new Local("Casa Central");
	}

	@org.junit.jupiter.api.Test
	void CrearUnLocalDeComidasYQueNoSeaNull() {
		assertNotNull(central);
	}

	@org.junit.jupiter.api.Test
	void crearUnMenuParaElLocal() {
		Menu menuCasaCentral = new Menu("Menú General");

		assertNotNull(menuCasaCentral);
	}

	@org.junit.jupiter.api.Test
	void crearUnMenuParaElLocalYAgregarleDosPlatos() {
		Integer valorEsperado = 2;
		Menu menuCasaCentral = new Menu("Menú General");
		Plato plato1 = new Plato();
		Plato plato2 = new Plato();

		menuCasaCentral.agregarPlato(plato1);
		menuCasaCentral.agregarPlato(plato2);

		assertEquals(valorEsperado, menuCasaCentral.getCantidad());
	}

	@org.junit.jupiter.api.Test
	void crearDosPlatosYColocarlesSusComponentes() {
		Menu menuCasaCentral = new Menu("Menú General");
		Plato plato1 = new Plato();
		Plato plato2 = new Plato();

		plato1.agregarCarne(Carne.BIFE_CHORIZO);
		plato1.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		plato1.agregarBebida(Bebida.COCA_COLA);
		plato2.agregarCarne(Carne.PECHUGA_GRILLE);
		plato2.agregarGuarnicion(Guarnicion.ENSALADA_MIXTA);
		plato2.agregarBebida(Bebida.SPRITE);
		menuCasaCentral.agregarPlato(plato1);
		menuCasaCentral.agregarPlato(plato2);

		assertEquals(Carne.BIFE_CHORIZO, plato1.getCarne());
		assertEquals(Guarnicion.ENSALADA_MIXTA, plato2.getGuarnicion());
	}

	@org.junit.jupiter.api.Test
	void crearUnaMesaAbrirlaYCargarleDosPlatos() {
		Menu menuCasaCentral = new Menu("Menú General");
		Plato plato1 = new Plato();
		Plato plato2 = new Plato();
		Mesa mesa1 = new Mesa(1);
		central.abrirMesa(mesa1);

		plato1.agregarCarne(Carne.BIFE_CHORIZO);
		plato1.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		plato1.agregarBebida(Bebida.COCA_COLA);
		plato2.agregarCarne(Carne.PECHUGA_GRILLE);
		plato2.agregarGuarnicion(Guarnicion.ENSALADA_MIXTA);
		plato2.agregarBebida(Bebida.SPRITE);
		menuCasaCentral.agregarPlato(plato1);
		menuCasaCentral.agregarPlato(plato2);
		mesa1.agregarConsumo(plato2);
		mesa1.agregarConsumo(plato1);

		assertEquals(Integer.valueOf(2), mesa1.getCantidad());
		assertEquals(Integer.valueOf(1), central.getMesasAbiertas());

	}
}
