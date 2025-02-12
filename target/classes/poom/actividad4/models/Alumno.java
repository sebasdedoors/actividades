package poom.actividad4.models;

public class Alumno {

public int edad;
public String nombre;

public String matriculas;


@Override
public String toString() {
    return "Alumno{" +
            "edad=" + edad +
            ", nombre='" + nombre + '\'' +
            ", matriculas='" + matriculas + '\'' +
            '}';

}

public Curso curso;

public Alumno(int edad, String nombre, String matriculas, Curso curso) {
    this.edad = edad;
    this.nombre = nombre;
    this.matriculas = matriculas;
    this.curso = curso;
}
}
