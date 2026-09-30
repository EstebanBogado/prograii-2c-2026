package ar.edu.unlam.pbii.cuentasBancarias;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(String nroCuenta, Double saldoInicial) {
		super(nroCuenta, saldoInicial);
	}

	@Override
	public void extraer(Double monto) {
		if (monto <= super.saldoInicial && monto > 0.0)
			super.saldo -= monto;
	}
}
