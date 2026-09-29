package ar.edu.unlam.pbii.cuentasBancariasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.cuentasBancarias.CajaAhorro;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaSueldo;
import ar.edu.unlam.pbii.cuentasBancarias.cuentaSueldo;

class CuentasTest {
	CuentaSueldo cuentaSueldo;
	CajaAhorro cajaAhorro;
	CajaAhorro cajaAhorro2;

	@BeforeEach
	void setUp() {
		cuentaSueldo = new CuentaSueldo("CD-1234", 2000.0);
		cajaAhorro = new CajaAhorro("CA-1234", 5000.0);
		cajaAhorro2 = new CajaAhorro("CA-2345", 10000.0);
	}

	@Test
	void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		cuentaSueldo.extraer(1000.0);
		assertEquals(1000.0, cuentaSueldo.getSaldo());

	}

	@Test
	void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		cuentaSueldo.extraer(2500.0);
		assertEquals(2000.0, cuentaSueldo.getSaldo());

	}

	@Test
	void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {
		for (int i = 0; i < 5; i++)
			cajaAhorro.extraer(1000.0);
		assertEquals(0.0, cajaAhorro.getSaldo());

	}

	@Test
	void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900() {
		for (int i = 0; i < 6; i++)
			cajaAhorro2.extraer(1000.0);
		assertEquals(3900.0, cajaAhorro2.getSaldo());

	}
	
	@Test
	void mostrarElSaldoDeLasTresCuentas() {
		assertEquals(2000.0, cuentaSueldo.getSaldo());
		assertEquals(5000.0, cajaAhorro.getSaldo());
		assertEquals(10000.0, cajaAhorro2.getSaldo());
	}

}
