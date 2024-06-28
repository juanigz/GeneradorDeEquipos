package sistema;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	 	private int lideresProyecto;
	    private int arquitectos;
	    private int programadores;
	    private int testers;
	    private List<Persona> personas;
	    private List<Incompatibilidad> incompatibilidades;

	    
	    public Equipo(List<Persona> personas, List<Incompatibilidad> incompatibilidades) {
	    	 this.personas = personas;
	         this.incompatibilidades = incompatibilidades;
	    }

	    public void cargarRequerimientos(int lideresProyecto, int arquitectos, int programadores, int testers) {
	        this.lideresProyecto = lideresProyecto;
	        this.arquitectos = arquitectos;
	        this.programadores = programadores;
	        this.testers = testers;
	    }

	    public int getRolMax(String rol) {
			//Devuelve el número máximo de personas permitidas para un rol específico.
	        switch (rol) {
	            case "Lider del Proyecto":
	                return getLideresProyecto();
	            case "Arquitecto":
	                return getArquitectos();
	            case "Programador":
	                return getProgramadores();
	            case "Tester":
	                return getTesters();
	            default:
	                throw new IllegalArgumentException("Rol desconocido: " + rol);
	        }
	    }
		public int getLideresProyecto() {
			return lideresProyecto;
		}
		public void setLideresProyecto(int lideresProyecto) {
			this.lideresProyecto = lideresProyecto;
		}
		public int getArquitectos() {
			return arquitectos;
		}
		public void setArquitectos(int arquitectos) {
			this.arquitectos = arquitectos;
		}
		public int getProgramadores() {
			return programadores;
		}
		public void setProgramadores(int programadores) {
			this.programadores = programadores;
		}
		public int getTesters() {
			return testers;
		}
		public void setTesters(int testers) {
			this.testers = testers;
		}
		public List<Persona> getPersonas() {
			return personas;
		}
		public void setPersonas(ArrayList<Persona> personas) {
			this.personas = personas;
		}
		public List<Incompatibilidad> getIncompatibilidades() {
			return incompatibilidades;
		}
		public void setIncompatibilidades(ArrayList<Incompatibilidad> incompatibilidades) {
			this.incompatibilidades = incompatibilidades;
		}
		
		
}
