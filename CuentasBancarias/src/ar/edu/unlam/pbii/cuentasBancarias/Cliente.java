package ar.edu.unlam.pbii.cuentasBancarias;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
	private long cuitCliente;
	private String nombreCliente;
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	private Double saldoGeneral = 0.0;

	public Cliente(String nombreCliente, long cuitCliente) {
		this.nombreCliente = nombreCliente;
		this.cuitCliente = cuitCliente;
	}

	public long getCuitCliente() {
		return cuitCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void agregarCuenta(Cuenta cuenta) {
		cuentas.add(cuenta);
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	@Override
	public String toString() {
		return "Cliente [cuitCliente=" + cuitCliente + ", nombreCliente=" + nombreCliente + ", cuentas="
				+ cuentas.toString() + "]";
	}

	public boolean esVip() {
		for (Cuenta cuenta : cuentas) {
			this.saldoGeneral += cuenta.getSaldo();
		}
		if (this.saldoGeneral >= 1_000_000.0)
			return true;
		return false;
	}

	public Double getSaldoGeneral() {
		return this.saldoGeneral;
	}

	public void extraerDeCuenta(String nroCuenta, Double monto) {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getNroCuenta().equals(nroCuenta)) {
				cuenta.extraer(monto);
				esVip();
			}
		}
	}
}
