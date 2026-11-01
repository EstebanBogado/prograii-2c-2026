package ar.edu.unlam.pbii.tienda;


public class ProductoDigital extends Producto {

	private String formato;
	private Integer tamanio;

	public ProductoDigital(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, String formato, Integer tamanio) {
		super(codProducto, formato, precio, formato, tamanio);
		this.formato = formato;
		this.tamanio = tamanio;
	}

	public String getFormato() {
		return formato;
	}

	public Integer getTamanio() {
		return tamanio;
	}

}
