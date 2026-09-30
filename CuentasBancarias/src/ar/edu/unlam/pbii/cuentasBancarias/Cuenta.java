package ar.edu.unlam.pbii.cuentasBancarias;

public abstract class Cuenta {
	protected String nroCuenta;
	protected Double saldoInicial;
	protected Double saldo;

	public Cuenta(String nroCuenta, Double saldoInicial) {
		this.nroCuenta = nroCuenta;
		this.saldoInicial = saldoInicial;
		this.saldo = saldoInicial;
	}

	public String getNroCuenta() {
		return this.nroCuenta;
	}

	public Double getSaldoInicial() {
		return this.saldoInicial;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void depositar(Double monto) {
		if (monto > 0.0)
			this.saldo += monto;
	}

	public abstract void extraer(Double monto);
}
