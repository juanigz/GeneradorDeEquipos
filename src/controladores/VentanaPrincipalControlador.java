package controladores;

import java.awt.EventQueue;
import java.util.List;

import sistema.Persona;
import sistema.Registrar;
import visual.VentanaPrincipal;

public class VentanaPrincipalControlador {
	
	public static VentanaPrincipal ventanaPrincipal;
	
	public VentanaPrincipalControlador() {
		inicializarVentanaPrincipal();
	}
	
	private static void inicializarVentanaPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal = new VentanaPrincipal();
					mostrar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void cerrar() {
		ventanaPrincipal.setVisible(false);
	}
	public static void mostrar() {
		ventanaPrincipal.setVisible(true);
	}
	
	public static void actualizarTabla(List<Persona> personas) {
		VentanaPrincipal.actualizarTabla(personas);
	}	
	
	public static void guardarJson(List<Persona> Personas) {
		Registrar.guardarJson(Personas);
	}
	
	public static List<Persona> eliminarPersona(String apellido) {
		return Registrar.eliminarPersona(apellido);
	}
}
