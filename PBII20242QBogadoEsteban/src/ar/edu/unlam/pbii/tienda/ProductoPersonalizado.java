package ar.edu.unlam.pbii.tienda;

import java.util.ArrayList;
import java.util.List;

public class ProductoPersonalizado extends Producto {

	private String nombreProducto;
	private Double precio;
	private String descripcionProducto;
	private Integer existencias;
	private List<Caracteristica> caracteristicas;

	public ProductoPersonalizado(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, List<Caracteristica> caracteristicas) {
		super(codProducto);
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcionProducto = descripicionProducto;
		this.existencias = existencias;
		this.caracteristicas = new ArrayList<Caracteristica>();
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

	public List<Caracteristica> getCaracteristicas() {
		return this.caracteristicas;
	}

	public Boolean agregarCaracteristica(Caracteristica caracteristica) {
		return this.caracteristicas.add(caracteristica);
	}

}
