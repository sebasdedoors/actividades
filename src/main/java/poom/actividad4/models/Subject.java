package poom.actividad4.models;
import java.util.ArrayList;
import java.util.List;

public class Subject {
  
    private String name;
    private int credits;
    private String ID;
    private String course;
    private List<Student> students;
    private Teacher teacher;
    private int hours;

    @Override
    public String toString() {
        return "Materia{" +
        "nombre='" + name + '\'' +
        ", credits=" + credits +
        ", hours=" + hours + 
        '}';
    }

public Subject(String name, int credits, String ID, String course, int hours, Teacher teacher){
    this.name = name;
    this.credits = credits;
    this.ID = ID;
    this.hours = hours;
    this.course = course;
    this.teacher = teacher;
    setName(name);
    setCredits(credits);
    setID(ID);
    setHours(hours);
    setCourse(course);
    setTeacher(teacher);
    
    this.students = new ArrayList<>();
   }
public String getName(){
    return name;
}
public int getCredits(){
    return credits;
}
public String getID(){
    return ID;
}
public  int getHours(){
    return hours;
}
public String getCourse(){
    return course;
}
public Teacher getTeacher(){
    return teacher;
}
public void setName(String name){
    if (name == null || name.trim().isEmpty() || name.matches(".*\\d.*")) {
        throw new IllegalArgumentException("El nombre no puede contener números.");
    }
    this.name = name;
}
public void setCredits(int credits){
    if (credits == 0){
        throw new IllegalArgumentException("Los créditos deben de tener un mínimo de 1");
    }
    this.credits = credits;
}
public void setID(String ID){
    if (ID == null){
        throw new IllegalArgumentException("El esapcio no puede estar vacio. ");
    }
}
public void setHours(int hours){
    if (hours < 0){
        throw new IllegalArgumentException("Las horas no pueden ser negativas.");
    }
    this.hours = hours;
}    
    public void setCourse(String course){
        if(course == null || course.trim().isEmpty() || course.matches(".*\\d.*")){
            throw new IllegalArgumentException("El curso no puede contener números.");
        }
        this.course = course;
    }
public void setTeacher(Teacher teacher){
    if (teacher == null){
        throw new IllegalArgumentException("El profesor no puede ser nulo.");
    }
    this.teacher = teacher;
    }
}