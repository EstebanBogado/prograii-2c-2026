package ar.edu.unlam.pbii.cuentasBancariasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.cuentasBancarias.Cuenta;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaCorriente;
import ar.edu.unlam.pbii.cuentasBancarias.CajaAhorro;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaSueldo;

class CuentasTest {
	Cuenta cuentaSueldo;
	Cuenta cajaAhorro;
	Cuenta cajaAhorro2;
	Cuenta cuentaCorriente;
	Cuenta cuentaCorriente1;

	@BeforeEach
	void setUp() {
		cuentaSueldo = new CuentaSueldo("CD-1234", 2_000.0);
		cajaAhorro = new CajaAhorro("CA-1234", 5_000.0);
		cajaAhorro2 = new CajaAhorro("CA-2345", 10_000.0);
		cuentaCorriente = new CuentaCorriente("CC-1234", 0.0, 0.0);
		cuentaCorriente1 = new CuentaCorriente("CC-2345", 100.0, 100.0);

	}

	@Test
	void queSePuedaExtraer1000PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		cuentaSueldo.extraer(1_000.0);
		assertEquals(1000.0, cuentaSueldo.getSaldo());

	}

	@Test
	void queNoSePuedaExtraer2500PesosDeUnaCuentaSueldoConSaldoIgualA2000Pesos() {
		cuentaSueldo.extraer(2_500.0);
		assertEquals(2000.0, cuentaSueldo.getSaldo());

	}

	@Test
	void queAlRealizar5ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe5000SuSaldoFinalSea0() {
		for (int i = 0; i < 5; i++)
			cajaAhorro.extraer(1_000.0);
		assertEquals(0.0, cajaAhorro.getSaldo());

	}

	@Test
	void queAlRealizar6ExtraccionesDe1000EnUnaCajaDeAhorroConSaldoInicialDe10000SuSaldoFinalSea3900() {
		for (int i = 0; i < 6; i++)
			cajaAhorro2.extraer(1_000.0);
		assertEquals(3_900.0, cajaAhorro2.getSaldo());

	}

	@Test
	void queAlDepositar1000EnUnaCuentaCorrienteConSaldoIgualACeroSuSaldoFinalSea1000() {

		cuentaCorriente.depositar(1_000.0);
		assertEquals(1_000.0, cuentaCorriente.getSaldo(), 0.0001);

	}
	
	@Test
	void queAlRetirar150PesosDeUnaCCConSaldoTotal200PesosElsaldoTotalSea47ConCincuenta() {

		cuentaCorriente1.extraer(150.0);
		assertEquals(47.50, cuentaCorriente1.getSaldo(), 0.0001);

	}

	@Test
	void mostrarElSaldoDeLasTresCuentas() {
		assertEquals(2_000.0, cuentaSueldo.getSaldo());
		assertEquals(5_000.0, cajaAhorro.getSaldo());
		assertEquals(10_000.0, cajaAhorro2.getSaldo());
	}

}
