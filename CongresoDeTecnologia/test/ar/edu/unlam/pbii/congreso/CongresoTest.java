package ar.edu.unlam.pbii.congreso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CongresoTest {
	Congreso congresoTecnologico;

	@BeforeEach
	void setUp() throws Exception {
		congresoTecnologico = new Congreso("Congreso de Tecnología");
	}

	@Test
	void elArancelDeCadaActividadIncluidosTalleresConDistintosArancelesBase() {
		Actividad charla = new Charla("Seguridad en la nube", 3);
		Actividad taller1 = new Taller("Git desde cero", 2, 6_000.0);
		Actividad taller2 = new Taller("Fundamentos de la IA", 4, 10_000.0);
		Actividad laboratorio = new Laboratorio("Hardening de servidores", 2, 8_000.0);

		assertEquals(Double.valueOf(0.0), charla.getArancel());
		assertEquals(Double.valueOf(6_000.0), taller1.getArancel());
		assertEquals(Double.valueOf(10_000.0), taller2.getArancel());
		assertEquals(Double.valueOf(8_000.0), laboratorio.getArancel());
	}

	@Test
	void queAlCrearDosPersonasConMismoDNISeanLaMismaPersonaAunqueSusNombreDifieran() {
		Asistente asistente1 = new Asistente("12345678", "Juan", "Pérez");
		Asistente asistente2 = new Asistente("12345678", "Ana", "Gómez");

		asistente1.setAcreditacion(Acreditacion.GENERAL);
		asistente2.setAcreditacion(Acreditacion.AUSPICIANTE);
		congresoTecnologico.registrarAsistente(asistente1);
		congresoTecnologico.registrarAsistente(asistente2);
		
assertEquals(Integer.valueOf(1), congresoTecnologico.getCantAsist());
	}

}
