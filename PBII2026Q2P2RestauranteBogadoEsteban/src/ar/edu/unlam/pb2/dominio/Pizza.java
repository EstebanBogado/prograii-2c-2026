package ar.edu.unlam.pb2.dominio;

import java.util.Set;

public class Pizza extends Producto implements IPersonalizable {

	private String tipoMasa;

	public Pizza(Integer codigoProducto, String nombreProducto, Double precioBase, String tipoMasa) {
		super(codigoProducto, nombreProducto, precioBase);
		this.tipoMasa = tipoMasa;
	}

	public String getTipoMasa() {
		return tipoMasa;
	}

	@Override
	public Double getPrecioFinal() {
		if ((this.extras != null))
			return this.precioBase + (this.extras.size() * 800.0);
		return this.precioBase;
	}

	@Override
	public void agregarIngrediente(IngredienteExtra extra) {
		this.extras.add(extra);
	}

	@Override
	public Set<IngredienteExtra> getIngredientesExtras() {
		return this.extras;
	}
}
