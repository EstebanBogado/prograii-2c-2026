package ar.edu.unlam.pbii.cuentasBancariasTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.cuentasBancarias.CajaAhorro;
import ar.edu.unlam.pbii.cuentasBancarias.Cliente;
import ar.edu.unlam.pbii.cuentasBancarias.Cuenta;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaCorriente;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaSueldo;

class ClienteTest {
	Cliente cliente;

	@BeforeEach
	void setUp() {
		cliente = new Cliente("Pepe Gómez", 1234567890);
	}

	@Test
	void crearUnClienteYAsociarleUnaCuentaSueldoYUnaCuentaCorriente() {
		Cuenta cuentaSueldo = new CuentaSueldo("CS-1234", 1000.0);
		Cuenta cuentaCorriente = new CuentaCorriente("CC-1234", 0.0, 500.0);

		cliente.agregarCuenta(cuentaSueldo);
		cliente.agregarCuenta(cuentaCorriente);

		assertEquals(Integer.valueOf(2), cliente.getCuentas().size());
	}

	@Test
	void crearUnClienteYAsociarleUnaCuentaSueldoUnaCuentaCorrienteYunaCajaAjhorroYQueSeaVIP() {
		Cuenta cuentaSueldo = new CuentaSueldo("CS-1234", 800_000.0);
		Cuenta cuentaCorriente = new CuentaCorriente("CC-1234", 50_000.0, 50_000.0);
		Cuenta cajaAhorro = new CajaAhorro("CA-1234", 100_000.0);

		cliente.agregarCuenta(cuentaSueldo);
		cliente.agregarCuenta(cuentaCorriente);
		cliente.agregarCuenta(cajaAhorro);

		assertTrue(cliente.esVip());
	}

	@Test
	void crearUnClienteYAsociarleUnaCuentaSueldoUnaCuentaCorrienteYunaCajaAjhorroYQueRealiceExtracciones() {
		Cuenta cuentaSueldo = new CuentaSueldo("CS-1234", 800_000.0);
		Cuenta cuentaCorriente = new CuentaCorriente("CC-1234", 50_000.0, 50_000.0);
		Cuenta cajaAhorro = new CajaAhorro("CA-1234", 100_000.0);

		cliente.agregarCuenta(cuentaSueldo);
		cliente.agregarCuenta(cuentaCorriente);
		cliente.agregarCuenta(cajaAhorro);

		cliente.extraerDeCuenta("CA-1234", 50_000.0);
		assertEquals(950_000.0, cliente.getSaldoGeneral());
	}
}
