package sistema;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class BacktrackingSolver implements Runnable {
    private Equipo equipo;
    private List<Persona> mejorSolucion;
    private int mejorCalificacion;
    private static List<Integer> calificaciones;

    public BacktrackingSolver(Equipo equipo) {
        this.equipo = equipo;
        this.mejorSolucion = new ArrayList<>();
        this.mejorCalificacion = 0;
    }

    @Override
    public void run()  {
    	List<Persona> solucionActual = new ArrayList<Persona>();
    	calificaciones = new ArrayList<Integer>();
        backtracking(solucionActual, 0);
    }
    
    private void backtracking(List<Persona> solucionActual, int indice) {
        if (indice == equipo.getPersonas().size()) {
            int calificacionActual = calcularCalificacion(solucionActual);
            if (calificacionActual > mejorCalificacion) {
                mejorCalificacion = calificacionActual;
                calificaciones.add(mejorCalificacion);
                mejorSolucion = new ArrayList<>(solucionActual);
                
            }
            return;
        }

        Persona persona = equipo.getPersonas().get(indice);

        if (esValidoAgregarPersona(solucionActual, persona)) {
            solucionActual.add(persona);
            backtracking(solucionActual, indice + 1);
            solucionActual.remove(solucionActual.size() - 1);
        }

        backtracking(solucionActual, indice + 1);
    }
    

    private int calcularCalificacion(List<Persona> solucion) {
        int calificacion = 0;
        for (Persona persona : solucion) {
            calificacion += persona.getCalificacion();
        }
        return calificacion;
    }

    private boolean esValidoAgregarPersona(List<Persona> solucion, Persona persona) {
        Map<String, Integer> rolesActuales = new HashMap<>();
        rolesActuales.put("Lider del Proyecto", 0);
        rolesActuales.put("Arquitecto", 0);
        rolesActuales.put("Programador", 0);
        rolesActuales.put("Tester", 0);

        for (Persona p : solucion) {
            rolesActuales.put(p.getRol(), rolesActuales.get(p.getRol()) + 1);
        }

        if (rolesActuales.get(persona.getRol()) >= equipo.getRolMax(persona.getRol())) {
            return false;
        }

        for (Incompatibilidad incompatibilidad : equipo.getIncompatibilidades()) {
            if (solucion.contains(incompatibilidad.getPersona1()) && persona.equals(incompatibilidad.getPersona2()) ||
                solucion.contains(incompatibilidad.getPersona2()) && persona.equals(incompatibilidad.getPersona1())) {
                return false;
            }
        }

        return true;
    }
    public static List<Integer> getCalificaciones() {
        return calificaciones;
    }
    public List<Persona> getMejorSolucion(){
    	return mejorSolucion;
    }
    
    public int getMejorCalificacion()
    {
    	return mejorCalificacion;
    }

}