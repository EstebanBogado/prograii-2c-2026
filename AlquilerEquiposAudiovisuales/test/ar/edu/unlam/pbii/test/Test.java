package ar.edu.unlam.pbii.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unlam.pbii.src.Alquiler;
import ar.edu.unlam.pbii.src.Articulo;
import ar.edu.unlam.pbii.src.EsAsegurable;
import ar.edu.unlam.pbii.src.CamaraCine;
import ar.edu.unlam.pbii.src.Cliente;
import ar.edu.unlam.pbii.src.Luz;
import ar.edu.unlam.pbii.src.Microfono;
import ar.edu.unlam.pbii.src.TipoDeCobertura;

class Test {

	@BeforeEach
	void setUp() {
	}

	@org.junit.jupiter.api.Test
	void elCostoDeUnEquipoIncluidaLaActualizacionDeLaTarifaDiaria() {
		Cliente cli_1234 = new Cliente("Pepe");
		Alquiler alq_1234 = new Alquiler(cli_1234, 3);

		Articulo camaraCine = new CamaraCine(1);
		Articulo iluminacion = new Luz(1);
		Articulo microfono = new Microfono(1);

		alq_1234.setArticulo(camaraCine);
		alq_1234.setArticulo(iluminacion);
		alq_1234.setArticulo(microfono);

		alq_1234.subTotal();
		assertEquals(Double.valueOf(325.0), alq_1234.subTotal());

		alq_1234.total(TipoDeCobertura.COBERTURA_BASICA);
		assertEquals(Double.valueOf(351.0), alq_1234.total(TipoDeCobertura.COBERTURA_BASICA));
		
		alq_1234.setDiasAlqui(4);
		microfono.setCantElem(1);
		alq_1234.setArticulo(microfono);
		alq_1234.subTotal();
		assertEquals(Double.valueOf(440.0), alq_1234.subTotal());
		

		alq_1234.total(TipoDeCobertura.COBERTURA_BASICA);
		assertEquals(Double.valueOf(475.20), alq_1234.total(TipoDeCobertura.COBERTURA_BASICA), 0.0001);

	}

}
