package ar.edu.unlam.pbii.casaDeComidasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.casaDeComidas.Bebida;
import ar.edu.unlam.pbii.casaDeComidas.Carne;
import ar.edu.unlam.pbii.casaDeComidas.Combo;
import ar.edu.unlam.pbii.casaDeComidas.Guarnicion;
import ar.edu.unlam.pbii.casaDeComidas.Local;
import ar.edu.unlam.pbii.casaDeComidas.Menu;
import ar.edu.unlam.pbii.casaDeComidas.Mesa;
import ar.edu.unlam.pbii.casaDeComidas.Plato;
import ar.edu.unlam.pbii.casaDeComidas.PlatoDelDia;
import ar.edu.unlam.pbii.casaDeComidas.Producto;

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

	@org.junit.jupiter.api.Test
	void crearUnaMesaAbrirlaYCargarleDosPlatosYEliminarUno() {
		Menu menuCasaCentral = new Menu("Menú General");
		Plato plato1 = new Plato();
		Plato plato2 = new Plato();
		Mesa mesa1 = new Mesa(1);
		Mesa mesa2 = new Mesa(2);
		central.abrirMesa(mesa1);
		central.abrirMesa(mesa2);

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

		mesa1.eliminarConsumo(plato1);
		assertEquals(Integer.valueOf(1), mesa1.getCantidad());
		assertEquals(Integer.valueOf(2), central.getMesasAbiertas());

	}
	
	@org.junit.jupiter.api.Test
	void crearUnaMesaAgregarleUnPlatoDelDiaYUnPlatoComun() {
		Menu menuCasaCentral = new Menu("Menú General");
		Producto platoDelDia = new PlatoDelDia();
		Producto plato1 = new Plato();
		Mesa mesa1 = new Mesa(1);
		menuCasaCentral.agregarPlato(platoDelDia);
		menuCasaCentral.agregarPlato(plato1);

		central.abrirMesa(mesa1);

		platoDelDia.agregarBebida(Bebida.COCA_COLA);
		platoDelDia.agregarCarne(Carne.BIFE_CHORIZO);
		platoDelDia.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		plato1.agregarBebida(Bebida.SPRITE);
		plato1.agregarCarne(Carne.PECHUGA_GRILLE);
		plato1.agregarGuarnicion(Guarnicion.ENSALADA_MIXTA);
		mesa1.agregarConsumo(platoDelDia);
		mesa1.agregarConsumo(plato1);

		assertEquals(Integer.valueOf(2), mesa1.getCantidad());
		assertEquals(Double.valueOf(58.8), mesa1.getGastoMesa(), 0.01);
	}

	@org.junit.jupiter.api.Test
	void crearUnPlatoDelDiaYAplicarVeintePorcientoDeDescuento() {
		Menu menuCasaCentral = new Menu("Menú General");
		Producto platoDelDia = new PlatoDelDia();
		Mesa mesa1 = new Mesa(1);
		menuCasaCentral.agregarPlato(platoDelDia);

		central.abrirMesa(mesa1);

		platoDelDia.agregarBebida(Bebida.COCA_COLA);
		platoDelDia.agregarCarne(Carne.BIFE_CHORIZO);
		platoDelDia.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
	
		mesa1.agregarConsumo(platoDelDia);

		assertEquals(Integer.valueOf(1), mesa1.getCantidad());
		assertEquals(Double.valueOf(25.6), mesa1.getGastoMesa(), 0.01);
	}
	
	@org.junit.jupiter.api.Test
	void crearUnaMesaAgregarleUnComboFamiliarYUnComboComun() {
		Menu menuCasaCentral = new Menu("Menú General");
		Producto comboFamiliar = new Combo("Combo familiar");
		Producto comboComun = new Combo("Combo");
		Mesa mesa1 = new Mesa(1);
		menuCasaCentral.agregarPlato(comboFamiliar);
		menuCasaCentral.agregarPlato(comboComun);

		central.abrirMesa(mesa1);

		comboComun.agregarBebida(Bebida.COCA_COLA);
		comboComun.agregarCarne(Carne.BIFE_CHORIZO);
		comboComun.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		comboFamiliar.agregarBebida(Bebida.SPRITE);
		comboFamiliar.agregarCarne(Carne.PECHUGA_GRILLE);
		comboFamiliar.agregarGuarnicion(Guarnicion.ENSALADA_MIXTA);
		mesa1.agregarConsumo(comboFamiliar);
		mesa1.agregarConsumo(comboComun);

		assertEquals(Integer.valueOf(2), mesa1.getCantidad());
		assertEquals(Double.valueOf(53.76), mesa1.getGastoMesa(), 0.00001);
	}
	

	@org.junit.jupiter.api.Test
	void crearDosMesasAgregarlesUnComboFamiliarUnComboComunUnPlatoDelDiaYUnPlatoComun() {
		Menu menuCasaCentral = new Menu("Menú General");
		Producto comboFamiliar = new Combo("Combo familiar");
		Producto comboComun = new Combo("Combo");
		Producto platoDelDia = new PlatoDelDia();
		Producto plato1 = new Plato();

		Mesa mesa1 = new Mesa(1);
		Mesa mesa2 = new Mesa(2);

		menuCasaCentral.agregarPlato(comboFamiliar);
		menuCasaCentral.agregarPlato(comboComun);
		menuCasaCentral.agregarPlato(plato1);
		menuCasaCentral.agregarPlato(platoDelDia);

		central.abrirMesa(mesa1);
		central.abrirMesa(mesa2);

		
		plato1.agregarCarne(Carne.BIFE_CHORIZO);
		plato1.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		plato1.agregarBebida(Bebida.COCA_COLA);
		platoDelDia.agregarBebida(Bebida.COCA_COLA);
		platoDelDia.agregarCarne(Carne.BIFE_CHORIZO);
		platoDelDia.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		comboComun.agregarBebida(Bebida.COCA_COLA);
		comboComun.agregarCarne(Carne.BIFE_CHORIZO);
		comboComun.agregarGuarnicion(Guarnicion.PAPAS_FRITAS);
		comboFamiliar.agregarBebida(Bebida.SPRITE);
		comboFamiliar.agregarCarne(Carne.PECHUGA_GRILLE);
		comboFamiliar.agregarGuarnicion(Guarnicion.ENSALADA_MIXTA);
		mesa1.agregarConsumo(comboFamiliar);
		mesa1.agregarConsumo(comboComun);
		mesa2.agregarConsumo(platoDelDia);
		mesa2.agregarConsumo(plato1);


		assertEquals(Integer.valueOf(4), central.cantPlatosVendidos());
		assertEquals(Double.valueOf(111.36), central.facturacionLocal(), 0.00001);
	}
}
