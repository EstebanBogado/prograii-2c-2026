package ar.edu.unlam.pbii.tienda;

public class ProductoDigital extends Producto {

	private String nombreProducto;
	private Double precio;
	private String descripcionProducto;
	private Integer existencias;
	private String formato;
	private Integer tamanio;

	public ProductoDigital(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, String formato, Integer tamanio) {
		super(codProducto);
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcionProducto = descripicionProducto;
		this.existencias = existencias;
		this.formato = formato;
		this.tamanio = tamanio;
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

	public String getFormato() {
		return formato;
	}

	public Integer getTamanio() {
		return tamanio;
	}

	
}
