package ar.edu.unlam.pbii.cuentasBancarias;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
	private long cuitCliente;
	private String nombreCliente;
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();

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
		if (cuentas.contains(cuenta)) {
			return;
		} else {
			cuentas.add(cuenta);
		}
	}

	@Override
	public int hashCode() {
		return Long.hashCode(cuitCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return cuitCliente == other.cuitCliente;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public Integer getCantCtasCli() {
		return this.cuentas.size();
	}

	@Override
	public String toString() {
		return "Cliente [cuitCliente=" + cuitCliente + ", nombreCliente=" + nombreCliente + ", cuentas="
				+ cuentas.toString() + "]";
	}

	public boolean esVip() {
		return getSaldoGeneral() >= 1_000_000.0;
	}

	public Double getSaldoGeneral() {
		Double total = 0.0;
		for (Cuenta cuenta : cuentas) {
			total += cuenta.getSaldo();
		}
		return total;
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
