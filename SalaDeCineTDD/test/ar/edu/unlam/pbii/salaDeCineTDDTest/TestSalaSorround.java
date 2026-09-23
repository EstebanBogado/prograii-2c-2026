package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala;
import ar.edu.unlam.pbii.salaDeCineTDD.SalaSorround;
import ar.edu.unlam.pbii.salaDeCineTDD.Tipo;

class TestSalaSorround {
	SalaSorround salaSorround;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() {
		salaSorround = new SalaSorround(7, 4);
	}

	@org.junit.jupiter.api.Test
	void creadaLaSalaSorroundVerificarQueNoSeaNull() {
		assertNotNull(salaSorround);
	}

	@org.junit.jupiter.api.Test
	void verificarQueElVolumenSeaNoventaPorDefectoYQueLaPotenciaSeaQuinientosWattsYTengaDiezParlantes() {
		assertEquals(Integer.valueOf(90), ((SalaSorround) salaSorround).getVolumen());
		assertEquals(Integer.valueOf(500), ((SalaSorround) salaSorround).getPotenciaTotal());
		assertEquals(Integer.valueOf(10), ((SalaSorround) salaSorround).getCantidadParlantes());
	}

	@org.junit.jupiter.api.Test
	void cambiarLaPotenciaElVolumenPreDefinidoYLaCantidaddeParlantes() {
		assertEquals(Integer.valueOf(90), ((SalaSorround) salaSorround).getVolumen());
		assertEquals(Integer.valueOf(500), ((SalaSorround) salaSorround).getPotenciaTotal());
		assertEquals(Integer.valueOf(10), ((SalaSorround) salaSorround).getCantidadParlantes());
		salaSorround.setVolumen(100);
		salaSorround.setPotenciaTotal(700);
		salaSorround.setCantidadParlantes(15);
		assertEquals(Integer.valueOf(100), salaSorround.getVolumen());
		assertEquals(Integer.valueOf(700), salaSorround.getPotenciaTotal());
		assertEquals(Integer.valueOf(15), salaSorround.getCantidadParlantes());
	}
	
	@org.junit.jupiter.api.Test
	void contarLaCantidadDeBoletosVendidosYQueNoSeVendaDosVecesElMismoAsiento() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		salaSorround.proyectarPelicula(starWars);
		salaSorround.venderBoleto(5, 3, 18);
		salaSorround.venderBoleto(5, 2, 18);
		salaSorround.venderBoleto(6, 1, 18);
		salaSorround.venderBoleto(5, 3, 18); //Asiento ocupado al momento de querer realizar la operación
		
		assertEquals(Integer.valueOf(3), salaSorround.boletosVendidos());
	}
}