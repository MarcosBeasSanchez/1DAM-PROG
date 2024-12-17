package colegio;

public class FactoriaProfeAlumno {

    public static Persona crearPersona(int valor) {
        Persona p = null;

        if (valor == 1) {
            p = new Profesor();
        } else if (valor == 2) {
            p = new Alumno();
        } else {
            System.out.println("Valor inválido, solo se pueden crear profesores (valor 1) o alumnos (valor 2).");
        }

        return p;
    }
}
