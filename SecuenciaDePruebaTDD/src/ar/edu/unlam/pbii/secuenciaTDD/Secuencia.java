package ar.edu.unlam.pbii.secuenciaTDD;

public class Secuencia {
	public Secuencia() {

	}

	public Integer getSuma(Integer s) {
		Integer inicio = 0;
		Integer resultado = 0;
		Integer suma = 1;
		
		if(s == 0)
			return 0;
		if(s == 1)
			return 1;
	for(int i = 1; i < s; i ++) {
		resultado = inicio + suma;
		inicio = suma;
		suma = resultado;
	}
	return resultado;
	}
}