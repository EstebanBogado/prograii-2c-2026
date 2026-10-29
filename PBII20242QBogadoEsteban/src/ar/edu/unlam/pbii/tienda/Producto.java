package ar.edu.unlam.pbii.tienda;

import java.util.Objects;

public abstract class Producto {

	protected Integer codProducto;

	public Producto(Integer codProducto) {
		this.codProducto = codProducto;
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
}
