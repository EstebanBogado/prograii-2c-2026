package ar.edu.unlam.pbii.casaDeComidas;

import java.util.Arrays;

public class Local {
	private Mesa[] mesasLocal = new Mesa[5];
	private String nombreSucursal;
	private Integer cantidad = 0;

	public Local(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
		for (int i = 0; i < mesasLocal.length; i++)
			mesasLocal[i] = null;
	}

	public Boolean abrirMesa(Mesa mesa) {
		if (mesasLocal[mesa.getNumeroMesa() - 1] == null) {
			mesasLocal[mesa.getNumeroMesa() - 1] = mesa;
			mesa.abrirMesa();
			this.cantidad++;
			return true;
		}

		return false;
	}
	
	public Integer cantPlatosVendidos() {
		Integer cantidad = 0;
		for(int i = 0; i < this.cantidad; i ++) {
			cantidad += mesasLocal[i].getCantidad();
		}
		return cantidad;
	}

	public Integer getMesasAbiertas() {
		return this.cantidad;
	}

	public String getNombreSucursal() {
		return this.nombreSucursal;
	}
	
	public Double facturacionLocal() {
		Double facturacion = 0.0;
		 for(int i = 0; i < this.cantidad; i ++) {
			facturacion += mesasLocal[i].getGastoMesa();
		}
		 return facturacion;
	}

	@Override
	public String toString() {
		return "Local [mesasLocal= " + Arrays.toString(mesasLocal) + ", nombreSucursal= " + nombreSucursal
				+ ", cantidad= " + cantidad + "]\n";
		
	}

}
