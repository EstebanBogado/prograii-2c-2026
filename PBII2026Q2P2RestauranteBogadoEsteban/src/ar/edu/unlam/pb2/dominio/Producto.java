package ar.edu.unlam.pb2.dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Producto {
	protected Integer codigoProducto;
	protected String nombreProducto;
	protected Double precioBase;
	protected Set<IngredienteExtra> extras;

	public Producto(Integer codigoProducto, String nombreProducto, Double precioBase) {
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.precioBase = precioBase;
		this.extras = new HashSet<IngredienteExtra>();
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void agregarIngrediente(IngredienteExtra extra) {
		this.extras.add(extra);
	}

	public Set<IngredienteExtra> getExtras() {
		return this.extras;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProducto);
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
		return Objects.equals(codigoProducto, other.codigoProducto);
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public Set<IngredienteExtra> getIngredientesExtras() {
		return this.extras;
	}

	public abstract Double getPrecioFinal();
}
