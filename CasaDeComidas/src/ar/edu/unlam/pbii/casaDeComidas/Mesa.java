package ar.edu.unlam.pbii.casaDeComidas;

import java.util.Arrays;

public class Mesa {
	private Integer cantidad = 0;
	private Plato[] consumo = new Plato[3];
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

	@Override
	public String toString() {
//		return "Mesa [cantidad=" + cantidad + ", consumo=" + Arrays.toString(consumo) + ", numeroMesa=" + numeroMesa
//				+ ", mesaAbierta=" + mesaAbierta + "]";
		
		StringBuilder string = new StringBuilder("mesa [");
		boolean primero = true;

		if (cantidad != null) {
			string.append("cantidad= ").append(cantidad);
			primero = false;
		}
		if (consumo != null) {
			if (!primero) string.append(", ");
			string.append("consumo= ").append(Arrays.toString(consumo));
			primero = false;
		}
		if (numeroMesa != null) {
			if (!primero) string.append(", ");
			string.append("número de mesa= ").append(numeroMesa);
		}

		string.append("]");
		return string.toString();
	}

	public void eliminarConsumo(Plato consumo) {
//		if (!this.mesaAbierta)
//			return;
		for (int i = 0; i < this.consumo.length; i++) {
			if (this.consumo[i] == consumo) {
				this.consumo[i] = null;
				cantidad--;
				return;
			}
			for(int j = 0; j <this.consumo.length; j ++) {
				if(this.consumo[i] == null) {
					this.consumo[i] = this.consumo[i + 1];
					this.consumo[i + 1] = null;
				}
			}
		}
	}
}
