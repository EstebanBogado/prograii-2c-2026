package ar.edu.unlam.pbii.tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Producto {

	protected Integer codProducto;
	private String nombreProducto;
	private Double precio;
	private String descripcionProducto;
	private Integer existencias;
	private List<Caracteristica> caracteristicas;

	public Producto(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias) {
		this.codProducto = codProducto;
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

	public Integer getCodProducto() {
		return this.codProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codProducto, other.codProducto);
	}

	public List<Caracteristica> getCaracteristicas() {
		return this.caracteristicas;
	}

	public Boolean agregarCaracteristica(Caracteristica caracteristica) {
		return this.caracteristicas.add(caracteristica);
	}
}
