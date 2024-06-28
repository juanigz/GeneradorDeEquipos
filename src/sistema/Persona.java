package sistema;

public class Persona {
	private String apellido;
	private String nombre;
	private String rol;
	private String incompatibilidad;
	private int calificacion;
	
	public Persona(String apellido, String nombre, String rol, String incompatibilidad, int calificacion){
		this.apellido = apellido;
		this.nombre = nombre;
		this.rol = rol;
		this.incompatibilidad = incompatibilidad;
		this.calificacion = calificacion;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getIncompatibilidad() {
		return incompatibilidad;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public void setIncompatibilidad(String apellidoInc) {
		this.incompatibilidad = apellidoInc;
	}
	
}
