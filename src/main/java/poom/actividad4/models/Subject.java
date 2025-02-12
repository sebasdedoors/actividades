package poom.actividad4.models;
import java.util.ArrayList;
import java.util.List;

public class Subject {
  
    public String name;
    public int credits;
    public String ID;
    public Course course;
    public List<Student> students;
    public Teacher teacher;

    public String toString() {
        return "Materia{" +
        "nombre='" + name + '\'' +
        ", credits=" + credits +
        ", hours=" + hours + 
        '}';
    }

public Subject(String nombre, int creditos, String ID, int horas) {
    this.name = name;
    this.credits = credits;
    this.ID = ID;
    this.hours = hours;
    this.students = new ArrayList<>();
   }
public  int hours;

 }

