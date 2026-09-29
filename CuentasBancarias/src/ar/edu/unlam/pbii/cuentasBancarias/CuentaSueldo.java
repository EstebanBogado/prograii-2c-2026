package ar.edu.unlam.pbii.cuentasBancarias;

public class CuentaSueldo {
	private String nroCuenta;
	private Double saldoInicial;
	private Double saldo;

	public CuentaSueldo(String nroCuenta, Double saldoInicial) {
		this.nroCuenta = nroCuenta;
		this.saldoInicial = saldoInicial;
		this.saldo = saldoInicial;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public Double getSaldoInicial() {
		return this.saldoInicial;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void extraer(Double monto) {
		if (monto <= this.saldoInicial && monto > 0.0)
			this.saldo -= monto;
	}
}
