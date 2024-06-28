package sistema;

import java.util.List;

public class Proceso {
	
	public static Equipo generarEquipo(List<Persona> personas, List<Incompatibilidad> incompatibilidades) {
		Equipo equipoBase = new Equipo(personas, incompatibilidades);
		return equipoBase;
	}
	public static void cargarRequerimientos(Equipo equipoBase, int cantLideres, int cantArquitectos, int cantTesters, int cantProgramadores) {
		equipoBase.cargarRequerimientos(cantLideres, cantArquitectos, cantProgramadores, cantTesters);
	}
	public static List<Persona> generarSolucion(Equipo equipoBase){		
		BacktrackingSolver solver = new BacktrackingSolver(equipoBase);

		Thread solverThread = new Thread(solver);
		solverThread.start();
		try {
			solverThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Persona> solucion = solver.getMejorSolucion();
		return solucion;
	}
}
