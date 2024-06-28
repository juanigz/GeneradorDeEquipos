package tests;

import org.junit.Before;
import org.junit.Test;

import sistema.Equipo;
import sistema.Incompatibilidad;
import sistema.Persona;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class EquipoTest
{
	private Equipo equipo;

	@Before
	public void inicializar()
	{
		List<Persona> personas = new ArrayList<>();
		List<Incompatibilidad> incompatibilidades = new ArrayList<>();
		equipo = new Equipo(personas, incompatibilidades);
	}

	@Test(expected = IllegalArgumentException.class)
	public void maximosRolesPorEquipoInvalidoTest()
	{
		equipo.setArquitectos(5);
		equipo.getRolMax("Desarrollador");
	}
	
	@Test
	public void maximosRolesPorEquipoTest()
	{
		equipo.setLideresProyecto(3);
		int maxLideres = equipo.getRolMax("Lider del Proyecto");
		
		assertEquals(3, maxLideres);
	}
	
	@Test
	public void equipoSinProgramadoresTest()
	{
		assertTrue(equipo.getProgramadores() == 0);
	}
}
