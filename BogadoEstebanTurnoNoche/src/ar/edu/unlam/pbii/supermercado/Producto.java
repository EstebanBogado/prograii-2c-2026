package ar.edu.unlam.pbii.supermercado;

public class Producto {
	private String codProd;
	private Integer existencias;
	private Double precio;

	public Producto(String codProd, Integer existencias, Double precio) {
		this.codProd = codProd;
		this.existencias = existencias;
		this.precio = precio;
	}

	public String getCodProd() {
		return codProd;
	}

	public Integer getExistencias() {
		return this.existencias;
	}

	public void quitarDeStock() {
		this.existencias--;
	}

	public Double getPrecio() {
		return precio;
	}

}
