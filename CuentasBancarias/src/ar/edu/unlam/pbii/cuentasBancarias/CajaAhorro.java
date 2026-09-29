package ar.edu.unlam.pbii.cuentasBancarias;

public class CajaAhorro {
	private String nroCuenta;
	private Double saldoInicial;
	private Double saldo;
	private Integer cantExtrac = 0;
	private Double comision = 100.0;

	public CajaAhorro(String nroCuenta, Double saldoInicial) {
		this.nroCuenta = nroCuenta;
		this.saldoInicial = saldoInicial;
		this.saldo = saldoInicial;

	}

	public void extraer(Double monto) {
		if (cantExtrac < 5 && monto <= this.saldo && monto > 0.0)
			this.saldo -= monto;
		if (cantExtrac >= 5 && (monto + comision) <= saldo && monto > 0.0)
			this.saldo -= (monto + comision);
		cantExtrac++;
	}

	public Integer getCantExtrac() {
		return this.cantExtrac;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public Double getSaldo() {
		return saldo;
	}
}
