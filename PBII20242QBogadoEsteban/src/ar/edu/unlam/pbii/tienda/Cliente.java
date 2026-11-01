package ar.edu.unlam.pbii.tienda;

public class Cliente {
	private String nombreCliente;
	private String dni;
	private Carrito carritoCompras;

	public Cliente(String nombreCliente, String dni) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.carritoCompras = new Carrito();

	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public Boolean agregarProductoAlCarrito(Tienda tienda, Integer codProd) {

		Producto producto = tienda.buscarProductoPorCodigo(codProd);

		if (producto == null)
			return false;
		return this.carritoCompras.agregarAlCarrito(producto);

	}

	public Carrito getCarrito() {
		return this.carritoCompras;
	}

}
