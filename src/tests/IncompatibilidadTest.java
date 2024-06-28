package tests;

import org.junit.Before;
import org.junit.Test;

import sistema.Incompatibilidad;
import sistema.Persona;

import static org.junit.Assert.*;

public class IncompatibilidadTest
{
	private Persona p1, p2, p3;
	private Incompatibilidad incompatibilidad;

	@Before
	public void inicializar()
	{
		p1 = new Persona("Barrientos", "Fran", "Programador", "-", 3);
		p2 = new Persona("Psara", "Matias", "Arquitecto", "-", 4);
		p3 = new Persona("Giménez", "Juan", "Tester", "-", 5);
		incompatibilidad = new Incompatibilidad(p1, p2);
	}

	@Test
	public void involucraTest()
	{
		assertTrue(incompatibilidad.involucra(p1));
		assertTrue(incompatibilidad.involucra(p2));
	}
	
	@Test
	public void noInvolucraTest()
	{
		assertFalse(incompatibilidad.involucra(p3));
	}
}
