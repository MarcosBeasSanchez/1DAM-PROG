package ejclase;

import java.util.HashSet;
import java.util.Objects;

import daw.com.Teclado;

public class Grupo {
    
    private String nombre;
    private HashSet<Alumno> alumnos;
    
    public Grupo(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }
    
    public Grupo() {
        this.nombre = "";
        this.alumnos = new HashSet<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public HashSet<Alumno> getAlumnos() {
        return alumnos;
    }
    
    public void setAlumnos(HashSet<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public void leerDatos() {
        añadirAlumnos();
    }
    
    public void añadirAlumnos() {
        String opc;
        do {
            Alumno alumno = new Alumno();
            alumno.leerClave();
            
            if (alumnos.contains(alumno)) { //duda
                System.out.println("El alumno ya existe en este grupo");
            } else {
            	alumno.leerRestoDatos();
                alumnos.add(alumno);
            }
            opc = Teclado.leerString("¿Agregar otro alumno? (s/n)");
        } while (opc.equalsIgnoreCase("s"));
    }
    
    public boolean eliminarAlumno(Alumno alumno) {
        return alumnos.remove(alumno);
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
        Grupo other = (Grupo) obj;
        return Objects.equals(nombre, other.nombre);
    }
    
    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", alumnos=" + alumnos + "]";
    }
}
