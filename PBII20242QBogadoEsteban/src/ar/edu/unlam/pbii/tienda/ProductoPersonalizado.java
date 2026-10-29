package ar.edu.unlam.pbii.tienda;

import java.util.List;

public class ProductoPersonalizado extends Producto {

	private String nombreProducto;
	private Double precio;
	private String descripcionProducto;
	private Integer existencias;
	private List<String> caracteristicas;

	public ProductoPersonalizado(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, List<String> caracteristicas) {
		super(codProducto);
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcionProducto = descripicionProducto;
		this.existencias = existencias;
		this.caracteristicas = caracteristicas;
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

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}



}
