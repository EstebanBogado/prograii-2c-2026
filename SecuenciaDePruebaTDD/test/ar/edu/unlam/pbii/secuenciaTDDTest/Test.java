package ar.edu.unlam.pbii.secuenciaTDDTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.secuenciaTDD.Secuencia;

class Test {
	private Secuencia secuencia;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() {
		secuencia = new Secuencia();
	}

	@org.junit.jupiter.api.Test
	void secuenciaTestInicial() {
		assertEquals(Integer.valueOf(1), secuencia.getSuma(2));
		System.out.println("Hola Mundo!!!");
	}

}
