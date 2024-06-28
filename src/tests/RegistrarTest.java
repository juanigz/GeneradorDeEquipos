package tests;

import static org.junit.Assert.*;

import sistema.Incompatibilidad;
import sistema.Persona;
import sistema.Registrar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrarTest
{
	private Persona p1, p2, p3, p4;
	private Incompatibilidad i1, i2;
	private List<Persona> listaPersonas;
	private List<Incompatibilidad> listaIncompatibilidades;

	@Before
	public void inicializar() {
		p1 = new Persona("Barrientos", "Fran", "Programador", "-", 3);
		p2 = new Persona("Psara", "Matias", "Arquitecto", "-", 4);
		p3 = new Persona("Giménez", "Juan", "Tester", "-", 5);
		p4 = new Persona("Gonzales", "Juan", "Tester", "-", 2);
		
		listaPersonas = Arrays.asList(p1, p2, p3);
		
		listaIncompatibilidades = new ArrayList<Incompatibilidad>();
		
		i1 = new Incompatibilidad(p1,p2);
		i2 = new Incompatibilidad(p3,p4);
		
		listaIncompatibilidades = Arrays.asList(i1, i2);
	}

	@Test
	public void existenPersonasEnListaTest()
	{
		assertEquals(listaPersonas.size(), 3);
	}
	
	@Test
	public void registrarPersonaTest()
	{
		Persona persona = new Persona("Gomez", "Carlos", "Programador", "-", 4);
		listaPersonas = Registrar.registrarPersona(persona);
		
		assertTrue(listaPersonas.contains(persona));
	}

	@Test
	public void eliminarPersonaTest()
	{
		listaPersonas = Registrar.eliminarPersona(p3.getApellido());
		assertFalse(listaPersonas.contains(p3));
	}

	@Test
	public void existeListaIncompatibilidadesTest()
	{
		assertEquals(2, listaIncompatibilidades.size());
	}
	
	@Test
	public void registrarIncompatiblesTest()
	{
		Persona persona1 = new Persona("Gimenez", "Juani", "Tester", "Gonzalez", 0);
		Persona persona2 = new Persona("Gonzalez", "Juan", "Tester", "Gimenez", 0);
		
		List<Incompatibilidad> listaIncompatibilidadesNueva = new ArrayList<Incompatibilidad>();
		listaIncompatibilidadesNueva.add(new Incompatibilidad(persona1, persona2));
		
		assertTrue(listaIncompatibilidadesNueva.size() == 1);
	}
	
	@Test
	public void listaIncompatibilidadVaciaTest()
	{
		List<Incompatibilidad> listaIncompatibilidadesNueva = new ArrayList<Incompatibilidad>();
		
		assertFalse(listaIncompatibilidadesNueva.size() > 0);
	}
}
