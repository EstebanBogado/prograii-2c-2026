package ar.edu.unlam.pbii.localDeComidasTest;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unlam.pbii.localDeComidas.Cliente;
import ar.edu.unlam.pbii.localDeComidas.Guarnicion;
import ar.edu.unlam.pbii.localDeComidas.Local;
import ar.edu.unlam.pbii.localDeComidas.Menu;
import ar.edu.unlam.pbii.localDeComidas.Plato;
import ar.edu.unlam.pbii.localDeComidas.Sanguche;

class Test {

	@org.junit.jupiter.api.Test
	void crearUnLocalYQúeNoSeaNull() {
		Local central = new Local("Casa Central");

		assertNotNull(central);
		assertEquals("Casa Central", central.getNombreDelLocal());
	}

	@org.junit.jupiter.api.Test
	void crearUnClienteYQueTengaCategoriaEstandard() {
		Cliente cliente1 = new Cliente("Pedro");
		cliente1.setCatCliente("Standard");

		assertNotNull(cliente1);
		assertEquals("Standard", cliente1.getCatCli());
	}

	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenu() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", Sanguche.CLASICA, Guarnicion.PAPAS_FRITAS, 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", Sanguche.BACON, Guarnicion.PAPAS_FRITAS, 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", Sanguche.MILA_SIMPLE,
				Guarnicion.ENSALADA_LECHUGA_TOMATE, 8.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
		menuCasaCentral.setPlato(hamburguesaClasica);

		central.setMenu(menuCasaCentral);

		assertEquals(Integer.valueOf(3), central.getMenu());
	}

	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenuYQueSePUedaAumentarElTamanio() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", Sanguche.CLASICA, Guarnicion.PAPAS_FRITAS, 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", Sanguche.BACON, Guarnicion.PAPAS_FRITAS, 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", Sanguche.MILA_SIMPLE,
				Guarnicion.ENSALADA_LECHUGA_TOMATE, 8.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
		central.setMenu(menuCasaCentral);

		assertEquals(Integer.valueOf(2), central.getMenu());

		menuCasaCentral.setPlato(hamburguesaClasica);
		central.setMenu(menuCasaCentral);
		central.listarMenu();

		assertEquals(Integer.valueOf(3), central.getMenu());
	}

	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenuYQueSePUedaEliminarUnPlato() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", Sanguche.CLASICA, Guarnicion.PAPAS_FRITAS, 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", Sanguche.BACON, Guarnicion.PAPAS_FRITAS, 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", Sanguche.MILA_SIMPLE,
				Guarnicion.ENSALADA_LECHUGA_TOMATE, 8.0);
		Plato sangucheMilanesaCompleto = new Plato("Mila Campleta", Sanguche.MILA_COMPLETO,
				Guarnicion.ENSALADA_ZANAHORIA_HUEVO, 12.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
		menuCasaCentral.setPlato(hamburguesaClasica);
		central.setMenu(menuCasaCentral);
		assertEquals(Integer.valueOf(3), central.getMenu());

		menuCasaCentral.eliminarPlato(hamburguesaClasica);
		central.setMenu(menuCasaCentral);
		menuCasaCentral.setPlato(sangucheMilanesaCompleto);
		assertEquals(Integer.valueOf(3), central.getMenu());
	}
	
	@org.junit.jupiter.api.Test
	void crearUnLocalYArmarleUnMenuYCalcularLaVentaTotal() {
		Local central = new Local("Casa Central");
		Menu menuCasaCentral = new Menu("Menu Casa Central");
		Plato hamburguesaClasica = new Plato("Burga Clásica", Sanguche.CLASICA, Guarnicion.PAPAS_FRITAS, 10.0);
		Plato hamburguesaEspecial = new Plato("Super Burga", Sanguche.BACON, Guarnicion.PAPAS_FRITAS, 15.0);
		Plato sangucheMilanesaBasico = new Plato("Mila Básica", Sanguche.MILA_SIMPLE,
				Guarnicion.ENSALADA_LECHUGA_TOMATE, 8.0);
		Plato sangucheMilanesaCompleto = new Plato("Mila Campleta", Sanguche.MILA_COMPLETO,
				Guarnicion.ENSALADA_ZANAHORIA_HUEVO, 12.0);

		menuCasaCentral.setPlato(sangucheMilanesaBasico);
		menuCasaCentral.setPlato(hamburguesaEspecial);
		menuCasaCentral.setPlato(hamburguesaClasica);
		menuCasaCentral.setPlato(sangucheMilanesaCompleto);
		central.facturaciónDiarita();
	}
}
