package ar.edu.unlam.pbii.src;

public interface EsAsegurable {

	static Double costoCobertura(TipoDeCobertura cobertura) {
		Double incrementoSeguro = 0.0;
		
		if(cobertura.equals(TipoDeCobertura.SIN_COBERTURA))
			incrementoSeguro = 1.0;
		if(cobertura.equals(TipoDeCobertura.COBERTURA_BASICA))
			incrementoSeguro = 1.08;
		if(cobertura.equals(TipoDeCobertura.COBERTURA_TOTAL))
			incrementoSeguro = 1.15;
		
		
		return incrementoSeguro;
	}
}
