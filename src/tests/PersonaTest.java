package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import sistema.Persona;

public class PersonaTest
{
	Persona p1, p2, p3;

	@Before
	public void inicializar()
	{
		p1 = new Persona("Barrientos", "Fran", "Programador", "-", 3);
		p2 = new Persona("Psara", "Matias", "Arquitecto", "-", 4);
		p3 = new Persona("Giménez", "Juan", "Tester", "-", 5);
	}

	@Test
	public void personaApellidoTest()
	{
		assertEquals("Barrientos", p1.getApellido());
	}

	@Test
	public void personaNombreTest()
	{
		assertNotEquals(p1.getNombre(), null);
	}

	@Test
	public void incompatibilidadTest()
	{
		assertEquals("-", p2.getIncompatibilidad());
	}

	@Test
	public void calificacionPersonaTest()
	{
		assertEquals(5, p3.getCalificacion());
	}

	@Test
	public void personaRolTest()
	{
		assertEquals("Arquitecto", p2.getRol());
	}
}