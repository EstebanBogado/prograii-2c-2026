package ar.edu.unlam.pbii.cuentasBancarias;

public class CuentaCorriente extends Cuenta {
	private Double comision = 0.05;
	private Double saldoDescubierto;
	private Double saldoTotal;

	public CuentaCorriente(String nroCuenta, Double saldoInicial, Double saldoDescubierto) {
		super(nroCuenta, saldoInicial);
		this.saldoDescubierto = saldoDescubierto;
		this.saldoTotal = super.saldo + this.saldoDescubierto;
	}

	@Override
	public void extraer(Double monto) {

		if (monto <= super.saldo) {
			super.saldo -= monto;
		} else {
			Double descubierto = monto - super.saldo;
			Double usoDescubierto = descubierto + (descubierto * comision);
			if (usoDescubierto <= this.saldoDescubierto) {
				super.saldo = 0.0;
				this.saldoDescubierto -= usoDescubierto;
			}
		}
	}

	@Override
	public Double getSaldo() {
		return super.saldo + this.saldoDescubierto;
	}

}
