package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.salaDeCineTDD.Butaca;
import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala;
import ar.edu.unlam.pbii.salaDeCineTDD.SalaGeneral;
import ar.edu.unlam.pbii.salaDeCineTDD.Tipo;

class TestSalaGeneral {
	Sala salaGeneral;

	@BeforeEach
	void setup() {
		salaGeneral = new SalaGeneral(7, 4);
	}

	@org.junit.jupiter.api.Test
	void crearUnaButacaYQueEsteDisponible() {
		Butaca butaca = new Butaca();
		assertFalse(butaca.estaOcupada());

	}

	@org.junit.jupiter.api.Test
	void crearUnaPeliculaConTodosSusParametros() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		assertNotNull(starWars);
	}

	@org.junit.jupiter.api.Test
	void contarLaCantidadDeBoletosVendidosYQueNoSeVendaDosVecesElMismoAsiento() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		salaGeneral.proyectarPelicula(starWars);
		salaGeneral.venderBoleto(5, 3, 18);
		salaGeneral.venderBoleto(5, 2, 18);
		salaGeneral.venderBoleto(6, 1, 18);
		salaGeneral.venderBoleto(5, 3, 18); //Asiento ocupado al momento de querer realizar la operación
		
		assertEquals(Integer.valueOf(3), salaGeneral.boletosVendidos());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSetearleElVolumenYQueDevuelvaElValorCincuenta() {
		salaGeneral.setVolumen(50);
		assertEquals(Integer.valueOf(50), salaGeneral.getVolumen());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYUnaPeliculaEnCartelera() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		assertEquals(28, salaGeneral.getCantButacas());
		salaGeneral.proyectarPelicula(starWars);
		assertNotNull(salaGeneral.getPelicula());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYCambiarLaPeliculaProyectada() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		Pelicula toyStory = new Pelicula("Toy Story", 89, 0, Tipo.INFANTIL);
		salaGeneral.proyectarPelicula(starWars);
		salaGeneral.cambiarPelicula(toyStory);
		assertNotNull(salaGeneral.getPelicula());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYProyectarUnaPeliculaYVenderBoletos() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		salaGeneral.proyectarPelicula(starWars);
		salaGeneral.venderBoleto(5, 3, 17);
		assertEquals(Integer.valueOf(27), salaGeneral.butacasDisponibles());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYProyectarUnaPeliculaYVenderButacasInexistentes() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		salaGeneral.proyectarPelicula(starWars);
		salaGeneral.venderBoleto(-7, 3, 17);
		assertEquals(Integer.valueOf(28), salaGeneral.butacasDisponibles());
	}

	@org.junit.jupiter.api.Test
	void crearUnaSalaDeCineConSusButacasYProyectarUnaPeliculaYVenderButacasYDevolverla() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		salaGeneral.proyectarPelicula(starWars);
		salaGeneral.venderBoleto(6, 3, 17);
		assertEquals(Integer.valueOf(27), salaGeneral.butacasDisponibles());
		salaGeneral.devolverBoleto(6, 3);
		assertEquals(Integer.valueOf(28), salaGeneral.butacasDisponibles());
	}

	@org.junit.jupiter.api.Test
	void crearUnaPeliculaYAgregarleLaSinopsis() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		starWars.setSinopsis("Pelicula de ciencia ficción y fantasía!!!");
		assertNotNull(starWars.getSinopsis());
	}
}
