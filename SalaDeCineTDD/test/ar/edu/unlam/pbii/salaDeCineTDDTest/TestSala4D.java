package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala4D;
import ar.edu.unlam.pbii.salaDeCineTDD.Tipo;

class TestSala4D {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() {
		Sala4D sala4D = new Sala4D(7, 4);
	}

	@org.junit.jupiter.api.Test
	void crearUnaPeliculaConTodosSusParametros() {
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Tipo.CIENCIA_FICCION);
		assertNotNull(starWars);
	}
}
