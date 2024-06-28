package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.Equipo;
import sistema.Incompatibilidad;
import sistema.Persona;
import sistema.Proceso;

import java.util.ArrayList;
import java.util.List;

public class ProcesoTest
{

	@Test
	public void testGenerarEquipo() {
		List<Persona> personas = new ArrayList<>();
		List<Incompatibilidad> incompatibilidades = new ArrayList<>();

		Equipo equipo = Proceso.generarEquipo(personas, incompatibilidades);

		assertNotNull(equipo);
		assertEquals(personas, equipo.getPersonas());
		assertEquals(incompatibilidades, equipo.getIncompatibilidades());
	}

	@Test
	public void testCargarRequerimientos() {
		Equipo equipo = new Equipo(new ArrayList<>(), new ArrayList<>());

		int cantLideres = 2;
		int cantArquitectos = 3;
		int cantTesters = 4;
		int cantProgramadores = 5;

		Proceso.cargarRequerimientos(equipo, cantLideres, cantArquitectos, cantTesters, cantProgramadores);

		assertEquals(cantLideres, equipo.getLideresProyecto());
		assertEquals(cantArquitectos, equipo.getArquitectos());
		assertEquals(cantTesters, equipo.getTesters());
		assertEquals(cantProgramadores, equipo.getProgramadores());
	}

	@Test
	public void testGenerarSolucion() {
		Equipo equipo = new Equipo(new ArrayList<>(), new ArrayList<>());

		List<Persona> solucion = Proceso.generarSolucion(equipo);

		assertNotEquals(solucion, null);
	}
}
