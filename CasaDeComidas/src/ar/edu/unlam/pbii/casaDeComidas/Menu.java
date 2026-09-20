package ar.edu.unlam.pbii.casaDeComidas;

import java.util.Arrays;

public class Menu {
	private Producto[] platos = new Producto[2];
	private String nombreMenu;
	private Integer cantidad = 0;

	public Menu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public String getNombreMenu() {
		return this.nombreMenu;
	}

	public void agregarPlato(Producto plato) {
		for (int i = 0; i < this.platos.length; i++) {
			if (this.platos[i] == null) {
				this.platos[i] = plato;
				cantidad++;
				return;
			}
			if (cantidad == this.platos.length) {
				this.platos = Arrays.copyOf(this.platos, this.platos.length * 2);
			}
		}
	}

	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return this.cantidad;
	}
}
