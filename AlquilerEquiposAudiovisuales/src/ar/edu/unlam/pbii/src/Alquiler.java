package ar.edu.unlam.pbii.src;

import java.util.ArrayList;
import java.util.List;

public class Alquiler implements EsAsegurable {
	private Cliente cliente;
	private Integer diasAlqui;
	private List<Articulo> articulos;

	public Alquiler(Cliente cliente, Integer diasAlqui) {
		this.cliente = cliente;
		this.diasAlqui = diasAlqui;
		this.articulos = new ArrayList<Articulo>();
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Integer getDiasAlqui() {
		return this.diasAlqui;
	}

	public void setDiasAlqui(Integer diasAlqui) {
		this.diasAlqui = diasAlqui;
	}

	public void setArticulo(Articulo articulo) {
		articulos.add(articulo);
	}

	public Double subTotal() {
		Double subTotal = 0.0;
		for (Articulo articulo : articulos) {
			subTotal += articulo.getCosto(this.diasAlqui);
		}
		return subTotal;
	}

	public Double total(TipoDeCobertura cobertura) {

		Double total = subTotal() * EsAsegurable.costoCobertura(cobertura);
		return total;
	}

}
