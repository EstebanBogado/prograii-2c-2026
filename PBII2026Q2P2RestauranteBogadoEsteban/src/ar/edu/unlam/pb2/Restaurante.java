package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.dominio.Cliente;
import ar.edu.unlam.pb2.dominio.Hamburguesa;
import ar.edu.unlam.pb2.dominio.IngredienteExtra;
import ar.edu.unlam.pb2.dominio.Pedido;
import ar.edu.unlam.pb2.dominio.Producto;
import ar.edu.unlam.pb2.excepciones.ProductoDuplicadoException;

public class Restaurante {
	private String nombreRestaurante;
	private Set<Producto> catalogoProductos;
	private Set<Cliente> clientes;
	private Set<Pedido> pedidos;

	public Restaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
		clientes = new HashSet<Cliente>();
		pedidos = new HashSet<Pedido>();
		catalogoProductos = new HashSet<Producto>();
	}

	public String getNombreRestaurante() {
		return nombreRestaurante;
	}

	public Boolean agregarProducto(Producto prod) throws ProductoDuplicadoException {
		for (Producto producto : catalogoProductos) {
			if (prod.getCodigoProducto().equals(producto.getCodigoProducto()))
				throw new ProductoDuplicadoException("Este producto ya existe en el catálogo");
		}
		catalogoProductos.add(prod);
		return true;
	}

	public Set<Producto> getCatalogoProductos() {
		return this.catalogoProductos;
	}

	public Set<Producto> getProductos() {
		return this.catalogoProductos;
	}

	public Boolean registrarCliente(Cliente cli) {
		for (Cliente cliente : clientes) {
			if (cli.getDni().equals(cliente.getDni()))
				return false;
		}
		clientes.add(cli);
		return true;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public Boolean agregarPedido(Pedido pedidoItem) {
		for (Pedido pedido : pedidos) {
			if (pedidoItem.getNroPedido().equals(pedido.getNroPedido()))
				return false;
		}
		pedidos.add(pedidoItem);
		return true;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void agregarIngredienteAProducto(Producto producto, IngredienteExtra extra) {
		for (Producto prod : catalogoProductos) {
			if(producto.getCodigoProducto().equals(prod.getCodigoProducto()))
				prod.agregarIngrediente(extra);
		}
	}
}
