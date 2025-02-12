package poom.actividad4.process;

import java.util.List;

import java.util.ArrayList;

public class Materia {

public String nombre;

public int creditos;

public String ID;

public Curso curso;

public List<Alumno> alumnos;
public List<Profesor> profesores;


@Override
public String toString() {
    return "Materia{" +
            "nombre='" + nombre + '\'' +
            ", creditos=" + creditos +
            ", horas=" + horas +
            '}';
            
}

public Materia(String nombre, int creditos, String ID, int horas)
    {
        this.nombres = nombres;
        this.creditos = creditos;
        this.ID = ID;
        this.horas = horas;
        this.alumnos = new ArrayList<>();
    }
public int horas;
}
