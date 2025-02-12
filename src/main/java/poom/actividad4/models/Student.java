package poom.actividad4.models;

public class Student {
    private String name;
    private int age;
    private int toition;
    private String course;


    public Student(String name, int age, int toition, String course) {
        setName(name);
        setAge(age);
        setToition(toition);
        setCourse(course);
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getToition() {return toition;}
    public String getCourse() {return course;}

    public void setName(String name){
        if (name == null || name.trim().isEmpty() || name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
    }
        this.name = name;
    }
    public void setAge(int age){
        if (age < 0 ){
            throw new IllegalArgumentException("la edad no puede ser 0. ");
        }
        this.age = age;
    }
    public void setToition(int toition){
        if (toition < 0){
            throw new IllegalArgumentException("La matrícula no puede ser negativa.");
        }
        this.toition = toition;
    }
    public void setCourse(String course){
        if(course == null || course.trim().isEmpty() || course.matches(".*\\d.*")){
            throw new IllegalArgumentException("El curso no puede contener números.");
        }
        this.course = course;
    }
}
