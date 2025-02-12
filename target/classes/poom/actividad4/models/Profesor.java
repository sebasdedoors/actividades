package poom.actividad4.models;

import java.util.List;
import java.util.ArrayList; 

public class Profesor {

public String nombre;

public double salario;

public String nomina;

public List<Materia> materias;

public Profesor(String nombre, double salario, String nomina)
    {
        this.nombre = nombre;
        this.salario = salario;
        this.nomina = nomina;
        this.materias = new ArrayList<>();
    }
    


}
