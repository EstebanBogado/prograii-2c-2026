package ar.edu.unlam.pbii.tienda;

public class ProductoFisico extends Producto {

	private Double peso;
	private String dimensiones;

	public ProductoFisico(Integer codProducto, String nombreProducto, Double precio, String descripicionProducto,
			Integer existencias, String dimensiones, Double peso) {
		super(codProducto, nombreProducto, precio, descripicionProducto, existencias);
		this.dimensiones = dimensiones;
		this.peso = peso;
	}

	public Double getPeso() {
		return peso;
	}

	public String getDimensiones() {
		return dimensiones;
	}

}
