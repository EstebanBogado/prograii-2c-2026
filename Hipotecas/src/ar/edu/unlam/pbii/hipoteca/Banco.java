package ar.edu.unlam.pbii.hipoteca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//Iniciar la liquidación de una hipoteca (genera un código autoincremental en estado
//PENDIENTE y retorna su código).

public class Banco {
	private String nombreBanco;
	private Set<Cliente> clientes;
	private Set<Hipoteca> hipotecas;
	private Map<Integer, Liquidacion> liquidacionesPendientes;
	private Map<Integer, Liquidacion> liquidacionesEmitidas;
	private Integer proximoCodigoLiquidacionEmitida;
	private Integer proximoCodigoLiquidacionIniciada;

	public Banco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
		this.clientes = new HashSet<Cliente>();
		this.hipotecas = new LinkedHashSet<Hipoteca>();
		this.liquidacionesPendientes = new HashMap<Integer, Liquidacion>();
		this.proximoCodigoLiquidacionEmitida = 1;
		this.proximoCodigoLiquidacionIniciada= 1;
	}

	public void aprobarHipoteca(Hipoteca hipoteca) {
		hipoteca.setEstadoHipo(Estado.APROBADA);

	}

	public void registrarHipoteca(Hipoteca hipoteca) {
		for (Hipoteca hipo : hipotecas) {
			if ((hipoteca.getCodHipo().equals(hipo.getCodHipo()))) {
				return;
			}
		}
		hipotecas.add(hipoteca);
	}

	public String getNombreBanco() {
		return this.nombreBanco;
	}

	public void registrarCliente(Cliente cliente) throws ClienteDuplicadoException {
		for (Cliente cli : clientes) {
			if (cliente.getCodCli().equals(cli.getCodCli()))
				throw new ClienteDuplicadoException("codCli repetido");
		}

		clientes.add(cliente);
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public Set<Hipoteca> getHipotecas() {
		return this.hipotecas;
	}

	public Hipoteca buscarHipoteca(String codHipoteca) {
		for (Hipoteca hipo : hipotecas) {
			if (hipo.getCodHipo().equals(codHipoteca))
				return hipo;
		}
		return null;
	}

	public String buscarCliente(String codCliente) {
		for (Cliente cliente : clientes) {
			if (cliente.getCodCli().equals(codCliente))
				return cliente.getCodCli();
		}
		return null;
	}

	public Integer iniciarLiquidacion(String codHipoteca) throws HipotecaInexistenteException {
		Hipoteca hipoteca = buscarHipoteca(codHipoteca);
		if (hipoteca == null)
			throw new HipotecaInexistenteException("La hipoteca no está registrada");
		Integer codigo = proximoCodigoLiquidacionIniciada++;
		liquidacionesPendientes.put(codigo, new Liquidacion(codigo, hipoteca));
		return codigo;
	}

	public Double emitirLiquidacion(Integer codLiquidacion)
			throws HipotecaInexistenteException, LiquidacionInexistenteException {

		Double montoFinal = 0.0;
		Liquidacion liquidacion = buscarLiquidacionPendiente(codLiquidacion);
		if (liquidacion == null)
			throw new LiquidacionInexistenteException("Liquidación no iniciada");
		liquidacion.setEstado(EstadoLiquidacion.EMITIDA);
		montoFinal = liquidacion.getHipoteca().montoFinal();
		Integer codigo = proximoCodigoLiquidacionEmitida++;
		liquidacionesEmitidas.put(codigo, liquidacion);
		liquidacionesPendientes.remove(liquidacion.getCodLiquidacion());
		return montoFinal;
	}

	public Liquidacion buscarLiquidacionPendiente(Integer codLiquidacion) {
		return liquidacionesPendientes.get(codLiquidacion);
	}

	public Liquidacion buscarLiquidacionEmitida(Integer codLiquidacion) {
		return liquidacionesEmitidas.get(codLiquidacion);
	}
}
