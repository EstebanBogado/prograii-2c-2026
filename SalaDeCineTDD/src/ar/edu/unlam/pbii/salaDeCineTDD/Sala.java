package ar.edu.unlam.pbii.salaDeCineTDD;

public abstract class Sala {
	protected Butaca[][] butacas;
	protected Pelicula pelicula;
	protected Integer cantButacas = 0;
	protected Integer butacasOcupadas = 0;
	protected Integer filas;
	protected Integer columnas;
	protected Integer volumen;
	protected Double precioEntrada;
	protected Boolean esMenor = false;
	protected Boolean promocional = false;
	protected Double facturacionSala = 0.0;

	public Sala(Integer filas, Integer columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.butacas = new Butaca[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.butacas[i][j] = new Butaca();
				cantButacas++;
			}
		}
	}

	public abstract void setVolumen(Integer volumen);

	public abstract Integer getVolumen();

	public Integer boletosVendidos() {
		return this.butacasOcupadas();
	}

	public void proyectarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public Integer getCantButacas() {
		return this.cantButacas;
	}

	public Integer butacasDisponibles() {
		return cantButacas - this.butacasOcupadas;
	}

	public Integer butacasOcupadas() {
		return this.butacasOcupadas;
	}

	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void venderBoleto(Integer fila, Integer columna, Integer edad) {
		if (edad >= 0 && edad <= 10)
			this.esMenor = true;
		if (edad < 0)
			return;
		if (fila >= this.filas || fila < 0 || columna >= this.columnas || columna < 0)
			return;
		if (butacas[fila][columna].estaOcupada())
			return;
		if (edad < pelicula.getEdadMinima() || edad < 0)
			return;
		butacas[fila][columna].ocuparButaca();
		this.butacasOcupadas++;
		if (this.esMenor) {
			this.precioEntrada = Valores.ENTRADA_MENOR.getPrecio();
		} else {
			if (edad > 10)
				this.precioEntrada = Valores.ENTRADA_MAYOR.getPrecio();
		}
		this.esMenor = false;

		this.facturacionSala += this.precioEntrada;
	}

	public Double getFacturaciónSala() {
		return this.facturacionSala;
	}

	public void devolverBoleto(Integer fila, Integer columna) {
		if (fila >= this.filas || fila < 0 || columna >= this.columnas || columna < 0)
			return;
		if (!butacas[fila][columna].estaOcupada())
			return;
		butacas[fila][columna].liberarButaca();
		this.butacasOcupadas--;
		this.facturacionSala -= this.precioEntrada;
	}
}
