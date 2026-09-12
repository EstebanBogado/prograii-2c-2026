package ar.edu.unlam.pbii.localDeComidas;

public class Local {
	private String nombreDelLocal;
	private Menu menu;
	private Plato[] platosVendidos = new Plato[10];

	public Local(String nombreDelLocal) {
		this.nombreDelLocal = nombreDelLocal;
		for (int i = 0; i < platosVendidos.length; i++)
			platosVendidos[i] = null;
	}

	public String getNombreDelLocal() {
		return this.nombreDelLocal;
	}

	public void setMenu(Menu menuCasaCentral) {
		this.menu = menuCasaCentral;
	}

	public Integer getMenu() {
		return menu.getPlatos();
	}

	public void listarMenu() {
		System.out.println(this.menu.toString());
	}

	public void facturaciónDiarita() {

	}

	public void venta() {

	}
}
