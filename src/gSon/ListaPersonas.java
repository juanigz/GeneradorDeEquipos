package gSon;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import sistema.Persona;

public class ListaPersonas implements Serializable {
    private static final long serialVersionUID = 1L;
    private LinkedList<Persona> lista;

    public ListaPersonas() {
        lista = new LinkedList<Persona>();
    }

    public void agregarPersona(String apellido, String nombre, String rol, String incompatibilidad, int calificacion) {
        Persona localidad = new Persona(apellido, nombre, rol, incompatibilidad, calificacion);
        lista.add(localidad);
    }

    public Persona getPersona() {
        if (!lista.isEmpty()) {
            return lista.removeFirst();
        } else {
            throw new RuntimeException();
        }
    }

    public boolean noExistenPersona() {
        return lista.isEmpty();
    }
    
    public List<Persona> getLista() {
        return lista;
    }
}
