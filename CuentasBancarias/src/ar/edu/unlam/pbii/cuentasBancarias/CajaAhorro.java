package ar.edu.unlam.pbii.cuentasBancarias;

public class CajaAhorro extends Cuenta {
	private Integer cantExtrac = 0;
	private Double comision = 100.0;

	public CajaAhorro(String nroCuenta, Double saldoInicial) {
		super(nroCuenta, saldoInicial);
	}

	@Override
	public void extraer(Double monto) {
		if (cantExtrac < 5 && monto <= super.saldo && monto > 0.0)
			super.saldo -= monto;
		if (cantExtrac >= 5 && (monto + comision) <= super.saldo && monto > 0.0)
			super.saldo -= (monto + comision);
		cantExtrac++;
	}

	public Integer getCantExtrac() {
		return this.cantExtrac;
	}

	
}
