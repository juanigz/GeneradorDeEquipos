package controladores;

import javax.swing.UIManager;

public class Principal {
	
	public static VentanaPrincipalControlador instanciaPrincipalControlador;
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			instanciaPrincipalControlador = new VentanaPrincipalControlador();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		  Equipo equipo = new Equipo();
//	        // ... (agregar personas e incompatibilidades al equipo)
//
//	        BacktrackingSolver solver = new BacktrackingSolver(equipo);
//
//	        // Ejecutar el algoritmo de backtracking en un hilo separado
//	        Thread solverThread = new Thread(solver);
//	        solverThread.start();
//
//	        // ... (realizar otras tareas en la aplicación principal)
//
//	        // Esperar a que el algoritmo de backtracking termine
//	        try {
//	            solverThread.join();
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//
//	        // Obtener y mostrar la solución
//	        List<Persona> solucion = solver.getMejorSolucion();
//	        // ... (mostrar la solución)
//		
//	}
	}
}