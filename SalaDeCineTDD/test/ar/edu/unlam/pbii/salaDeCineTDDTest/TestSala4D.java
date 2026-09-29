package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.salaDeCineTDD.Genero;
import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala4D;

class TestSala4D {
	Sala4D sala4D;

	@BeforeEach
	void setUp() {
		sala4D = new Sala4D(7, 4);
	}

	@Test
	void crearUnaSala4DYQueNoSeaNull() {
		assertNotNull(sala4D);
	}

	@Test
	void crearUnaSala4DYSetearElVolumenYDevolverSuValor() {

		sala4D.setVolumen(70);
		assertEquals(Integer.valueOf(70), sala4D.getVolumen());
	}

	@Test
	void setearElEfectoDeAguaYVientoYQueDevuelvanTrue() {

		sala4D.setEfectoAgua();
		sala4D.setEfectoViento();
		sala4D.setEfectoMovimiento();

		assertTrue(sala4D.getEfectoAgua());
		assertTrue(sala4D.getEfectoViento());
		assertTrue(sala4D.getEfectoMovimiento());
	}
	@Test
	void setearLaAdvertenciaDeefectosEspeciales() {

		sala4D.setEfectoAgua();
		sala4D.setEfectoViento();
		sala4D.setEfectoMovimiento();

		assertTrue(sala4D.warningEfectosActivados());
	}
	
	@org.junit.jupiter.api.Test
	void crearUnaPeliculaAptaParaMayoresDe16YCalcularLaFacturacionDeLaSala() {
		Double valorEsperado = 48.0;
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Genero.CIENCIA_FICCION);
		sala4D.proyectarPelicula(starWars);
		sala4D.venderBoleto(6, 3, 15);
		sala4D.venderBoleto(6, 2, 17);
		sala4D.venderBoleto(5, 3, 18);
		sala4D.venderBoleto(5, 2, 18);

		assertEquals(valorEsperado, sala4D.getFacturaciónSala());
	}
}