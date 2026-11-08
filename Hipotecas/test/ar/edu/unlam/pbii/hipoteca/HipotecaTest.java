package ar.edu.unlam.pbii.hipoteca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HipotecaTest {
	Banco banco;
	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente1Repetido;

	@BeforeEach
	void setUp() throws Exception {
		banco = new Banco("Banco Hipotecario");
		cliente1 = new Cliente("C-1234", "Pepe", "Varela 1909, La Matanza", 25_000_000.0);
		cliente2 = new Cliente("C-2345", "María", "Kennedy 909, La Matanza", 20_000_000.0);
		cliente1Repetido = new Cliente("C-1234", "Juan", "Plaza Morón, Morón", 30_000_000.0);
	}

	@Test
	public void dadoUnBancoQuePermitaRegistrarUnCliente() throws ClienteDuplicadoException {
		banco.registrarCliente(cliente1);
		assertNotNull(banco.buscarCliente(cliente1.getCodCli()));
	}

	@Test
	public void dadoUnBancoQueNoSePermitaRegistrarDosClientesConElMismoCodigoLanceClienteDuplicadoException()
			throws ClienteDuplicadoException {
		banco.registrarCliente(cliente1);

		assertEquals(Integer.valueOf(1), banco.getClientes().size());
		assertThrows(ClienteDuplicadoException.class, () -> banco.registrarCliente(cliente1Repetido));
	}

	@Test
	public void dadoUnBancoQueNoSePermitaRegistrarUnaHipotecaCasaConCapitalMayorA5MillonesLanceHipotecaNoPermitidaException()
			throws HipotecaNoPermitidaException {

		assertThrows(HipotecaNoPermitidaException.class, () -> {
			new HipotecaCasa("HC-1234", cliente1, "06/10/2026", 5_000_001.0, 20.0, Estado.SOLICITADA, 1.0);
		});
	}

	@Test
	public void dadoUnBancoQueSePermitaRegistrarUnaHipotecaCasa() throws HipotecaNoPermitidaException {
		Hipoteca hipoCasa = new HipotecaCasa("HC-1234", cliente1, "06/10/2026", 5_000_000.0, 20.0, Estado.SOLICITADA,
				1.0);
		assertNotNull(hipoCasa);

	}

	@Test
	public void dadoUnBancoQueNoSePermitaRegistrarUnaHipotecaTerrenoConAptoNoUrbanoLanceHipotecaNoPermitidaException() {
		assertThrows(HipotecaNoPermitidaException.class, () -> {
			new HipotecaTerreno("H" + "HT-1234", cliente1, "06/10/2026", 16_000_000.0, 20.0, Estado.SOLICITADA, false);
		});

	}

	@Test
	public void dadoUnBancoQueSePermitaIniciarUnaLiquidacion()
			throws HipotecaNoPermitidaException, HipotecaInexistenteException {
		Hipoteca hipoCasa = new HipotecaCasa("HC-1234", cliente1, "06/10/2026", 5_000_000.0, 20.0, Estado.SOLICITADA,
				1.0);
		banco.registrarHipoteca(hipoCasa);
		banco.iniciarLiquidacion(hipoCasa.getCodHipo());

		assertNotNull(banco.buscarLiquidacionPendiente(Integer.valueOf(1)));

	}

	@Test
	public void dadoUnBancoQueSePermitaObtenerElMontoFinalAlEmitirLaLiquidacionParaUnaHipotecaDepartamento()
			throws HipotecaNoPermitidaException, HipotecaInexistenteException {
		Hipoteca hipoDepto = new HipotecaDepto("HD-1234", cliente1, "06/10/2026", 10_000_000.0, 12.0,
				Estado.SOLICITADA);
		banco.registrarHipoteca(hipoDepto);
		banco.iniciarLiquidacion(hipoDepto.getCodHipo());
		
		assertEquals(Double.valueOf(11_200_000.0), banco.buscarHipoteca("HD-1234").montoFinal());
	}

//	@Test
//	public void dadoUnBancoQueSePermitaEmitirUnaLiquidacion() {
//
//	}
//
//	@Test
//	public void dadoUnBancoQueSePermitaPagarUnaLiquidacion() {
//
//	}
//
//	@Test
//	public void dadoUnBancoQueNoSePermitaPagarUnaLiquidacionQueNoFueEmitida() {
//
//	}
//
//	@Test
//	public void dadoUnBancoQueSePermitaObtenerUnReporteDeRecaudacionTotalPorFechaDeEmisionDeLiquidacionOrdenadoAscendentePorFechaConElMontoTotalAbonado() {
//
//	}

}
