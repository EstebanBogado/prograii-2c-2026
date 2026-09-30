package ar.edu.unlam.pbii.cuentasBancarias;

public class CuentaCorriente extends Cuenta {

	private Double saldoDescubierto;
	private Double saldoTotal;

	public CuentaCorriente(String nroCuenta, Double saldoInicial, Double saldoDescubierto) {
		super(nroCuenta, saldoInicial);
		this.saldoDescubierto = saldoDescubierto;
		this.saldoTotal = super.saldo + this.saldoDescubierto;
	}

	@Override
	public void extraer(Double monto) {
		if (monto > this.saldoTotal)
			return;
		if(monto <= super.saldo)
			this.saldoTotal -= monto;
		
	}

}
