package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala4D;
import ar.edu.unlam.pbii.salaDeCineTDD.Tipo;

class TestSala4D {
	Sala4D sala4D;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() {
		sala4D = new Sala4D(7, 4);
	}

	@org.junit.jupiter.api.Test
	void crearUnaSala4DYSetearleElVolumenYQueDevuelvaOChentaYNoSeaNull() {
		sala4D.setVolumen(80);

		assertNotNull(sala4D);
		assertEquals(Integer.valueOf(80), sala4D.getVolumen());
	}

	@org.junit.jupiter.api.Test
	void queLaSal4DTnegaEfectoDeAguaYViento() {
		sala4D.aplicarEfectoDeViento();

		assertEquals(String.valueOf("qué viento".toUpperCase()), sala4D.aplicarEfectoDeViento());
	}

	@org.junit.jupiter.api.Test
	void proyectarUnaPeliculaYActivarElEfectoViento() {
		Pelicula laOdisea = new Pelicula("La Odisea", 225, 16, Tipo.CIENCIA_FICCION);

		sala4D.activarEfectoViento();
		sala4D.proyectarPelicula(laOdisea);

		assertNotNull(sala4D.activarEfectoViento());
		assertEquals(String.valueOf("qué viento".toUpperCase()), sala4D.aplicarEfectoDeViento());
	}

	@org.junit.jupiter.api.Test
	void proyectarUnaPeliculaYActivarElEfectoAgua() {
		Pelicula laOdisea = new Pelicula("La Odisea", 225, 16, Tipo.CIENCIA_FICCION);

		sala4D.activarEfectoAgua();
		sala4D.proyectarPelicula(laOdisea);

		assertNotNull(sala4D.activarEfectoAgua());
		assertEquals(String.valueOf("agua activada".toUpperCase()), sala4D.aplicarEfectoDeAgua());
	}

	@org.junit.jupiter.api.Test
	void proyectarUnaPeliculaYActivarElEfectoMovimiento() {
		Pelicula laOdisea = new Pelicula("La Odisea", 225, 16, Tipo.CIENCIA_FICCION);

		sala4D.activarEfectoMovimiento();
		sala4D.proyectarPelicula(laOdisea);

		assertNotNull(sala4D.activarEfectoAgua());
		assertEquals(String.valueOf("butaca moviéndose".toUpperCase()), sala4D.aplicarEfectoDeMovimiento());
	}

	@org.junit.jupiter.api.Test
	void desactivarLosEfectosEspecialesYQueSeanNull() {
		sala4D.activarEfectoMovimiento();
		sala4D.activarEfectoAgua();
		sala4D.activarEfectoViento();

		assertNotNull(sala4D.aplicarEfectoDeAgua());
		assertNotNull(sala4D.aplicarEfectoDeMovimiento());
		assertNotNull(sala4D.aplicarEfectoDeViento());

		sala4D.desactivarEfectoAgua();
		sala4D.desactivarEfectoViento();
		sala4D.desactivarMovimiento();

		assertNull(sala4D.aplicarEfectoDeAgua());
		assertNull(sala4D.aplicarEfectoDeMovimiento());
		assertNull(sala4D.aplicarEfectoDeViento());
	}

	@org.junit.jupiter.api.Test
	void contarLaCantidadDeBoletosVendidosYQueNoSeVendaDosVecesElMismoAsiento() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		sala4D.proyectarPelicula(starWars);
		sala4D.venderBoleto(5, 3, 18);
		sala4D.venderBoleto(5, 2, 18);
		sala4D.venderBoleto(6, 1, 18);
		sala4D.venderBoleto(5, 3, 18); // Asiento ocupado al momento de querer realizar la operación

		assertEquals(Integer.valueOf(3), sala4D.boletosVendidos());
	}
}
