package ejclase;

import java.util.HashMap;
import java.util.Objects;

import daw.com.Teclado;

public class Instituto {
    
    private String nombre;
    private HashMap<String, Grupo> grupos;
    
    public Instituto(String nombre) {
        this.nombre = nombre;
        this.grupos = new HashMap<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public HashMap<String, Grupo> getGrupos() {
        return grupos;
    }
    
    public void setGrupos(HashMap<String, Grupo> grupos) {
        this.grupos = grupos;
    }
    
    public void cargarDatos() {
        agregarGrupoYAlumnos();
    }

    
    public void agregarGrupoYAlumnos() {
        String nombreGrupo;
        do {
            nombreGrupo = Teclado.leerString("Nombre del Grupo");
            if (grupos.containsKey(nombreGrupo)) {
                System.out.println("El Instituto ya tiene este Grupo.");
            } else {
                Grupo nuevoGrupo = new Grupo(nombreGrupo);     
                nuevoGrupo.leerDatos();
                grupos.put(nombreGrupo, nuevoGrupo);
            }
            if (grupos.size() >= 3) {
                System.out.println("Se ha alcanzado el máximo de grupos permitidos.");
                break;
            }
        } while (Teclado.leerString("¿Agregar otro grupo? (s/n)").equalsIgnoreCase("s"));
    }
    
    public boolean alumnoExisteEnGrupos(Alumno alumno) {  //duda  
        for (Grupo grupo : grupos.values()) {
            if (grupo.getAlumnos().contains(alumno)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean contieneGrupo(Grupo g) {
        return grupos.containsValue(g);
    }
    
    public Grupo getGrupo(String nombreGrupo) {
        return grupos.get(nombreGrupo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Instituto other = (Instituto) obj;
        return Objects.equals(nombre, other.nombre);
    }
    
    @Override
    public String toString() {
        return "Instituto [nombre=" + nombre + ", grupos=" + grupos + "]";
    }
}
