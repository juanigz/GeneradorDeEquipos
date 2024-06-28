package controladores;

import java.util.List;

import sistema.Incompatibilidad;
import sistema.Persona;
import sistema.Registrar;
import visual.VentanaRegistro;

public class VentanaRegistroControlador {
	
	static VentanaRegistro ventanaRegistro = new VentanaRegistro();
	
	public static void cerrar() {
		ventanaRegistro.setVisible(false);
	}
	public static void mostrar() {
		ventanaRegistro.setVisible(true);
	}
	
	public static Persona generarPersona(String apellido, String nombre, String rol, String incompatibilidad, int calificacion) {
		return Registrar.generarPersona(apellido, nombre, rol, incompatibilidad, calificacion);
	}
	
	public static List<Persona> registrarPersona(Persona persona){
		return Registrar.registrarPersona(persona);
	}

	public static List<Persona> getLista() {
		return Registrar.getLista();
	}
	public static List<Incompatibilidad> getIncompatibilidades(Persona persona, String apellidoIncomp) {
		return Registrar.generarIncompatibilidades(persona, apellidoIncomp);
	}
}
