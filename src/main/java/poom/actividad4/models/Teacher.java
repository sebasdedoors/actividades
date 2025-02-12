package poom.actividad4.models;

import java.util.ArrayList;
import java.util.List;


public class Teacher {
    public String name;
    public double salary;
    public String payroll;
    public List<Subject> subjects ;


    public Teacher(String nombre, double salario, String nomina) {
        this.name = name;
        this.salary = salary;
        this.payroll = payroll;
        this.subjects = new ArrayList<>();  
    }
}
