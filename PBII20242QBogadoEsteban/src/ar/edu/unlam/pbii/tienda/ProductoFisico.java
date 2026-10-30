package ar.edu.unlam.pbii.tienda;

import java.util.Comparator;

public class ProductoFisico extends Producto {

	private String nombreProducto;
	private Double precio;
	private String descripcionProducto;
	private Integer existencias;
	private Double peso;
	private String dimensiones;

	public ProductoFisico(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, Double peso, String dimensiones) {
		super(codProducto);
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcionProducto = descripicionProducto;
		this.existencias = existencias;
		this.peso = peso;
		this.dimensiones = dimensiones;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public Double getPeso() {
		return peso;
	}

	public String getDimensiones() {
		return dimensiones;
	}

}
