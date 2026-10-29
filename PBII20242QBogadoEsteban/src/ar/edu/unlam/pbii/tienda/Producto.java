package ar.edu.unlam.pbii.tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Producto {

	protected Integer codProducto;
	private List<Caracteristica> caracteristicas;


	public Producto(Integer codProducto) {
		this.codProducto = codProducto;
		this.caracteristicas = new ArrayList<Caracteristica>();

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
//		if (getClass() != obj.getClass())
//			return false;
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
