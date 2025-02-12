package poom.actividad4.process;

import java.util.List;
import java.util.ArrayList;


public class Curso {

public String nombre;

public Curso(String nombre) {
    this.nombre = nombre;
    this.materias = new ArrayList<>();
    this.profesores = new ArrayList<>();

}

public List<Materia> materias;

public List<Profesor> profesores;
}