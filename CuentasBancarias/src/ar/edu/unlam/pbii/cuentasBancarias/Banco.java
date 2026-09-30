package ar.edu.unlam.pbii.cuentasBancarias;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public Banco() {

	}

	public void agregarCliente(Cliente cliente) {
		if (!this.clientes.contains(cliente)) {
			this.clientes.add(cliente);
		}
	}

	public Integer getCantCli() {
		// TODO Auto-generated method stub
		return this.clientes.size();
	}

	public Integer getCantCuentas() {
		Integer cantCuentas = 0;

		for (Cliente cliente : clientes)
			cantCuentas += cliente.getCantCtasCli();

		return cantCuentas;

	}

}
