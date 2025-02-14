package poom.actividad4.models;

public class Student {
    private String name;
    private int age;
    private int tuition;
    private String course;


    public Student(String name, int age, int tuition, String course) {
        setName(name);
        setAge(age);
        setToition(tuition);
        setCourse(course);
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getToition() {return tuition;}
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
    public void setToition(int tuition){
        if (tuition < 0){
            throw new IllegalArgumentException("La matrícula no puede ser negativa.");
        }
        this.tuition = tuition;
    }
    public void setCourse(String course){
        if(course == null){
            throw new IllegalArgumentException("El curso no puede contener números.");
        }
        this.course = course;
    }
}
