package ar.edu.unlam.pbii.salaDeCineTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.salaDeCineTDD.Complejo;
import ar.edu.unlam.pbii.salaDeCineTDD.Genero;
import ar.edu.unlam.pbii.salaDeCineTDD.Pelicula;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala;
import ar.edu.unlam.pbii.salaDeCineTDD.Sala4D;
import ar.edu.unlam.pbii.salaDeCineTDD.SalaGeneral;
import ar.edu.unlam.pbii.salaDeCineTDD.SalaSorround;

class TestComplejoDeSalas {
	Complejo complejoUnlam;

	@BeforeEach
	void setUp() {
		complejoUnlam = new Complejo("Complejo de Cines UNLaM");
	}

	@Test
	void crearUnComplejoYAgregarleLasSalas() {
		Sala salaGeneral1 = new SalaGeneral(7, 4);
		Sala salaSorround1 = new SalaSorround(6, 6);
		Sala sala4D1 = new Sala4D(6, 8);

		complejoUnlam.agregarSala(salaGeneral1);
		complejoUnlam.agregarSala(sala4D1);
		complejoUnlam.agregarSala(salaSorround1);
		assertEquals(Integer.valueOf(3), complejoUnlam.getCantSalas());

	}

	@org.junit.jupiter.api.Test
	void crearUnaPeliculaAptaParaMayoresDe16YCalcularLaFacturacionDeLaSala() {
		Double valorEsperado = 158.0;
		Pelicula starWars = new Pelicula("Star Wars: el regreso del jedi", 120, 16, Genero.CIENCIA_FICCION);
		Pelicula odisea = new Pelicula("La Odisea", 255, 13, Genero.ACCION);
		Pelicula ToyStoty = new Pelicula("Toy Story", 95, 0, Genero.INFANTIL);
		Sala4D sala4D = new Sala4D(7, 4);
		SalaGeneral salaGeneral = new SalaGeneral(6, 5);
		Sala salaSorround = new SalaSorround(8, 9);
		
		sala4D.proyectarPelicula(starWars);
		salaGeneral.proyectarPelicula(ToyStoty);
		salaSorround.proyectarPelicula(odisea);
		complejoUnlam.agregarSala(salaSorround);
		complejoUnlam.agregarSala(salaGeneral);
		complejoUnlam.agregarSala(sala4D);
		
		sala4D.venderBoleto(6, 3, 15);
		sala4D.venderBoleto(6, 2, 17);
		sala4D.venderBoleto(5, 3, 18);
		sala4D.venderBoleto(5, 2, 18);
		assertEquals(48.0, sala4D.getFacturaciónSala());

		salaSorround.venderBoleto(6, 3, 15);
		salaSorround.venderBoleto(6, 2, 17);
		salaSorround.venderBoleto(5, 3, 18);
		salaSorround.venderBoleto(5, 2, 18);
		assertEquals(64.0, salaSorround.getFacturaciónSala());

		salaGeneral.venderBoleto(4, 3, 9);
		salaGeneral.venderBoleto(4, 2, 8);
		salaGeneral.venderBoleto(5, 3, 18);
		salaGeneral.venderBoleto(5, 2, 18);
		assertEquals(46.0, salaGeneral.getFacturaciónSala());
		
		assertEquals(valorEsperado, complejoUnlam.getFacturacionComplejo());
	}

}
