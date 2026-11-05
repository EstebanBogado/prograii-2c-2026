package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import ar.edu.unlam.pb2.Restaurante;
import ar.edu.unlam.pb2.excepciones.ClienteInexistenteException;

public class Pedido {

	private Integer nroPedido;
	private Cliente cliente;
	private List<Producto> productos;

	public Pedido(Integer nroPedido, Cliente cliente) throws ClienteInexistenteException {
		this.nroPedido = nroPedido;
		this.cliente = cliente;
		if (this.cliente == null)
			throw new ClienteInexistenteException("Este cliente no existe");
		productos = new ArrayList<Producto>();
	}

	public Integer getNroPedido() {
		return nroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);

	}
	
	

	public List<Producto> getProducto() {
		return this.productos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, nroPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(nroPedido, other.nroPedido);
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public Double calcularTotal() {
		Double total = 0.0;
		
		for (Producto producto : productos) {
			total += producto.getPrecioFinal();
		}
		
		return total;
	}

}
