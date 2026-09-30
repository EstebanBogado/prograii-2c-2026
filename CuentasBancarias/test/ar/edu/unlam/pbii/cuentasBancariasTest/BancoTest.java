package ar.edu.unlam.pbii.cuentasBancariasTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlam.pbii.cuentasBancarias.Banco;
import ar.edu.unlam.pbii.cuentasBancarias.CajaAhorro;
import ar.edu.unlam.pbii.cuentasBancarias.Cliente;
import ar.edu.unlam.pbii.cuentasBancarias.Cuenta;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaCorriente;
import ar.edu.unlam.pbii.cuentasBancarias.CuentaSueldo;

class BancoTest {

	Banco banco;
	Cliente cliente1;
	Cliente cliente2;
	Cuenta cuentaSueldo;
	Cuenta cuentaCorriente;
	Cuenta cajaAhorro;

	@BeforeEach
	void setUp() {
		banco = new Banco();
		cliente1 = new Cliente("Pepe", 1234567890);
		cliente2 = new Cliente("María", 987654321);
		cuentaSueldo = new CuentaSueldo("CS-1234", 800_000.0);
		cuentaCorriente = new CuentaCorriente("CC-1234", 50_000.0, 50_000.0);
		cajaAhorro = new CajaAhorro("CA-1234", 100_000.0);
	}

	@Test
	void crearUnBancoYQueNoSeaNull() {

		assertNotNull(banco);
	}

	@Test
	void crearUnBancoYAgregarleDosClientes() {
		banco.agregarCliente(cliente1);
		banco.agregarCliente(cliente2);

		assertEquals(Integer.valueOf(2), banco.getCantCli());
	}

	@Test
	void crearUnBancoYAgregarleDosClientesYAgregarlesCuentasACadaUno() {

		banco.agregarCliente(cliente1);
		banco.agregarCliente(cliente2);
		cliente1.agregarCuenta(cuentaCorriente);
		cliente2.agregarCuenta(cuentaSueldo);
		assertEquals(Integer.valueOf(2), banco.getCantCli());
		assertEquals(Integer.valueOf(2), banco.getCantCuentas());
	}

}
