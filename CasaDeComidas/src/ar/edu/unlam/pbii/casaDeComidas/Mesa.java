package ar.edu.unlam.pbii.casaDeComidas;

import java.util.Arrays;

public class Mesa {
	private Integer cantidad = 0;
	private Plato[] consumo = new Plato[10];
	private Integer numeroMesa;
	private Boolean mesaAbierta = false;

	public Mesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public void abrirMesa() {
		this.mesaAbierta = true;
	}

	public Boolean mesaAbierta() {
		return this.mesaAbierta;
	}

	public void agregarConsumo(Plato consumo) {
		if (!this.mesaAbierta)
			return;
		if (cantidad == this.consumo.length) {
			this.consumo = Arrays.copyOf(this.consumo, this.consumo.length * 2);
		}
		for (int i = 0; i < this.consumo.length; i++) {
			if (this.consumo[i] == null) {
				this.consumo[i] = consumo;
				cantidad++;
				return;
			}
		}
	}

	public Integer getNumeroMesa() {
		return this.numeroMesa;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}
}
