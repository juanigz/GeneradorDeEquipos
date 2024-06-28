package sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import gSon.GenerarGson;
import gSon.ListaPersonas;

public class Registrar {
    private static GenerarGson gsonGenerator = new GenerarGson();
    private static ListaPersonas listaPersonas = gsonGenerator.getListaDesdeJson();
    private static List<Persona> listaPers = listaPersonas.getLista();
    private static List<Incompatibilidad> listaIncomp = new ArrayList<Incompatibilidad>();
    
	public static Persona generarPersona(String apellido, String nombre, String rol, String incompatibilidad, int calificacion) {
		Persona persona = new Persona(apellido, nombre, rol, incompatibilidad, calificacion);
		return persona;
	}
	
	public static List<Persona> registrarPersona(Persona persona) {
		if (!yaIngresada(persona, listaPers)) {			
			listaPers.add(persona);
			for (Persona per : listaPers) {
				if (per.getIncompatibilidad().equals(persona.getApellido())) {
					persona.setIncompatibilidad(per.getApellido());
				}
				if (persona.getIncompatibilidad().equals(per.getApellido())) {
					per.setIncompatibilidad(persona.getApellido());
				}
			}
		}
		return listaPers;
	}
	
	public static List<Incompatibilidad> generarIncompatibilidades(Persona persona, String apellidoIncompatible) {
		for (Persona p : listaPers) {
	        if (p.getApellido().equals(apellidoIncompatible)) {
	        	if(!existeIncompatibilidad(persona, p)) {
	        		listaIncomp.add(new Incompatibilidad(persona, p));	        		
	        	}
	        }
	    }
	    return listaIncomp;
	}
	
	private static boolean existeIncompatibilidad(Persona p1, Persona p2) {
		for (Incompatibilidad incomp : listaIncomp) {
			if (incomp.involucra(p1) && incomp.involucra(p2)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<Persona> eliminarPersona(String apellido) {
	    boolean encontrada = false;
	    List<Persona> ret = new ArrayList<>();
	    if (apellido != null) {	    
	    	for (Persona person : listaPers) {
	    		if (person.getApellido().equalsIgnoreCase(apellido.trim())) {
	    			encontrada = true;
	    		} else {
	    			ret.add(person);
	    		}
	    	}
	    } else {
	    	return listaPers;
	    }
	    listaPers = ret;
	    if (!encontrada && !listaPers.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "La persona no se encontró en la lista");
	        return listaPers;
	    }
	    return ret;
	}
	
	private static boolean yaIngresada(Persona persona, List<Persona> Personas) {
	    for (Persona person : Personas) {
	    	if (person.getApellido() == persona.getApellido() && person.getNombre() == persona.getNombre()){
	    		return true;
	    	}
	    }
	    return false;
	}
	
	public static void guardarJson(List<Persona> personas) {
	    ListaPersonas listaPersonas = new ListaPersonas();
	    for (Persona person : personas) {
	        if (!yaIngresada(person, listaPersonas.getLista())) {
	            listaPersonas.agregarPersona(person.getApellido(), person.getNombre(), person.getRol(),
	            		person.getIncompatibilidad(), person.getCalificacion());                
	        }
	    }
	    Gson gson = new Gson();
	    String json = gson.toJson(listaPersonas);
	    try (Writer writer = new FileWriter("listaPersonas.json")) {
	        writer.write(json);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static ListaPersonas getListaPersonas() {
		return listaPersonas;
	}
	public static List<Persona> getLista() {
		return listaPers;
	}
}
