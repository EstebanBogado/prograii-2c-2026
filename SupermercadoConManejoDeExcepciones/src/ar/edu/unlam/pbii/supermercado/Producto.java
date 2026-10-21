package ar.edu.unlam.pbii.supermercado;

public class Producto {
	private String codigoProducto;
	private Double precio;
	private Integer existencia;

	public Producto(String codigoProducto, Integer existencia, Double precio) {
		this.codigoProducto = codigoProducto;
		this.existencia = existencia;
		if (existencia < 0)
			throw new IllegalArgumentException("El stock no puede ser menor a cero");
		this.precio = precio;
		if (precio < 0.0)
			throw new IllegalArgumentException("El precio no puede ser negativo");
	}

	public String getCodProd() {
		return this.codigoProducto;
	}

	public Double getPrecioProd() {
		return this.precio;
	}

	public Integer getStockProd() {
		return this.existencia;
	}
}
