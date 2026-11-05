package ar.edu.unlam.pb2.dominio;

import java.util.Set;

public interface IPersonalizable {
	public void agregarIngrediente(IngredienteExtra extra);

	public Set<IngredienteExtra> getIngredientesExtras();

}
