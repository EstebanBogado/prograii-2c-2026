package ar.edu.unlam.pbii.escuelaDemo;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	private void assertOrden(String listado, String... dnis) {
		int anterior = -1;
		for (String dni : dnis) {
			int posicion = listado.indexOf("dni=" + dni);
			assertTrue(posicion > anterior, "El DNI " + dni + " no está en el listado o está fuera de orden");
			anterior = posicion;
		}
	}

	@org.junit.jupiter.api.Test
	void crearUnAlumnoYUnDocenteQueExtiendanDePersona() throws NotaPromedioGeneralInvalidaException {
		Persona d1 = new Docente("D-1234", "1234567", "Gómez", "Juan", "Historia");
		Persona a1 = new Alumno("2345678", "Pérez", "María", "primero", "A", 7.8);

		assertNotNull(a1);
		assertNotNull(d1);
	}

	@org.junit.jupiter.api.Test
	void crearUnAlumnoConPromedioGeneralMayorADiez() throws NotaPromedioGeneralInvalidaException {

		assertThrows(NotaPromedioGeneralInvalidaException.class,
				() -> new Alumno("2345678", "Pérez", "María", "primero", "A", 17.8));
	}

	@org.junit.jupiter.api.Test
	void crearLaEscuelaYAgregarleDocentesYAlumnos()
			throws PersonaConDNIRepetidoException, NotaPromedioGeneralInvalidaException {
		Docente d1 = new Docente("D-1234", "1234567", "Gómez", "Juan", "Historia");
		Docente d2 = new Docente("D-2345", "3698521", "Skodnick", "Vodgan", "Matematicas");
		Docente d3 = new Docente("D-3456", "6547892", "Báez", "Pedro", "Física");
		Docente d4 = new Docente("D-4567", "4561239", "skodnick", "Analía", "Álgebra");

		Alumno a1 = new Alumno("2345678", "Pérez", "María", "1", "A", 7.8);
		Alumno a2 = new Alumno("9874562", "Páez", "Ariel", "2", "B", 8.8);
		Alumno a3 = new Alumno("8765432", "Giménez", "Juan", "1", "A", 6.8);
		Alumno a4 = new Alumno("1478523", "Pérez", "María", "3", "C", 10.0);
		Alumno a5 = new Alumno("1234567", "González", "Martín", "4", "C", 6.0);

		Escuela normalSuperior = new Escuela("Normal Superior");

		normalSuperior.agregarAlumno(a1);
		normalSuperior.agregarAlumno(a2);
		normalSuperior.agregarAlumno(a3);
		normalSuperior.agregarAlumno(a4);
		normalSuperior.agregarAlumno(a5);

		normalSuperior.agregarDocente(d1);
		normalSuperior.agregarDocente(d2);
		normalSuperior.agregarDocente(d3);
		normalSuperior.agregarDocente(d4);

		assertEquals(Integer.valueOf(4), normalSuperior.cantDocentes());
		assertEquals(Integer.valueOf(5), normalSuperior.cantAlumnos());
	}

	@org.junit.jupiter.api.Test
	void crearLaEscuelaYAgregarleDocentesYAlumnosYQueAlIngresarDNIRepetidosArrojeExcepcion()
			throws PersonaConDNIRepetidoException, NotaPromedioGeneralInvalidaException {
		Docente d1 = new Docente("D-1234", "1234567", "Gómez", "Juan", "Historia");
		Docente d2 = new Docente("D-2345", "3698521", "Skodnick", "Vodgan", "Matematicas");
		Docente d3 = new Docente("D-3456", "6547892", "Báez", "Pedro", "Física");
		Docente d4 = new Docente("D-4567", "1234567", "López", "Analía", "Álgebra");

		Alumno a1 = new Alumno("2345678", "Pérez", "María", "primero", "A", 7.8);
		Alumno a2 = new Alumno("9874562", "Páez", "Ariel", "segundo", "B", 8.8);
		Alumno a3 = new Alumno("2345678", "Giménez", "Juan", "primero", "A", 6.8);
		Alumno a4 = new Alumno("1478523", "Pérez", "María", "tercero", "C", 10.0);

		Escuela normalSuperior = new Escuela("Normal Superior");

		normalSuperior.agregarAlumno(a1);
		normalSuperior.agregarAlumno(a2);
		normalSuperior.agregarAlumno(a4);

		normalSuperior.agregarDocente(d1);
		normalSuperior.agregarDocente(d2);
		normalSuperior.agregarDocente(d3);

		assertEquals(Integer.valueOf(3), normalSuperior.cantDocentes());
		assertEquals(Integer.valueOf(3), normalSuperior.cantAlumnos());
		assertThrows(PersonaConDNIRepetidoException.class, () -> normalSuperior.agregarAlumno(a3));
		assertThrows(PersonaConDNIRepetidoException.class, () -> normalSuperior.agregarDocente(d4));
	}

	@org.junit.jupiter.api.Test
	void creadoUnListadoDeAlumnosQueOrdenePorMeritoYTambienPorAnioCursada()
			throws PersonaConDNIRepetidoException, NotaPromedioGeneralInvalidaException {
		Docente d1 = new Docente("D-1234", "1234567", "Gómez", "Juan", "Historia");
		Docente d2 = new Docente("D-2345", "3698521", "Skodnick", "Vodgan", "Matematicas");
		Docente d3 = new Docente("D-3456", "6547892", "Báez", "Pedro", "Física");
		Docente d4 = new Docente("D-4567", "4561239", "skodnick", "Analía", "Álgebra");

		Alumno a1 = new Alumno("2345678", "Pérez", "María", "1", "A", 7.8);
		Alumno a2 = new Alumno("9874562", "Páez", "Ariel", "2", "B", 8.8);
		Alumno a3 = new Alumno("8765432", "Giménez", "Juan", "1", "A", 6.8);
		Alumno a4 = new Alumno("1478523", "Pérez", "María", "3", "C", 10.0);
		Alumno a5 = new Alumno("1234567", "González", "Martín", "4", "C", 6.0);

		Escuela normalSuperior = new Escuela("Normal Superior");

		normalSuperior.agregarAlumno(a1);
		normalSuperior.agregarAlumno(a2);
		normalSuperior.agregarAlumno(a3);
		normalSuperior.agregarAlumno(a4);
		normalSuperior.agregarAlumno(a5);

		normalSuperior.agregarDocente(d1);
		normalSuperior.agregarDocente(d2);
		normalSuperior.agregarDocente(d3);
		normalSuperior.agregarDocente(d4);

		String listadoPorAnioCursada = normalSuperior.listarAlumnosPorAnioCursada();
		String listadoPorMerito = normalSuperior.listarAlumnosPorPromedio();

		assertOrden(listadoPorAnioCursada, "8765432", "2345678", "9874562", "1478523", "1234567");
		assertOrden(listadoPorMerito, "1478523", "9874562", "2345678", "8765432", "1234567");

	}

	@org.junit.jupiter.api.Test
	void crearUnaPizarraUnaNotebookYUnLibroYQueEstenDisponiblesParaAlquilarlos() {

		Alquilable libro = new Libro("Cien años de soledad", "123-456-789-0123");
		Alquilable pizarra = new Pizarra(Tamanio.GRANDE, "PG-123456");
		Alquilable notebook = new Notebook(Marca.LENOVO, "NL-123456");

		assertTrue(libro.estaDisponible());
		assertTrue(notebook.estaDisponible());
		assertTrue(pizarra.estaDisponible());

	}

}
