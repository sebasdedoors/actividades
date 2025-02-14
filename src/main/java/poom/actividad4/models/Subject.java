package poom.actividad4.models;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una materia en un sistema académico.
 * Contiene información sobre la materia, como su nombre, créditos, identificador,
 * curso, cantidad de horas, el profesor a cargo y los estudiantes inscritos.
 */

public class Subject {
    
    private String name;
    private int credits;
    private String ID;
    private String course;
    private List<Student> students;
    private Teacher teacher;
    private int hours;


  /**
     * Devuelve una representación en cadena de la materia.
     * @return Cadena con la información de la materia.
     */

    @Override
    public String toString() {
        return "Materia{" +
        "nombre='" + name + '\'' +
        ", credits=" + credits +
        ", hours=" + hours + 
        '}';
    }

    /**
     *@param name Nombre de la materia.
     * @param credits Cantidad de créditos de la materia.
     * @param ID Identificador único de la materia.
     * @param course Curso al que pertenece la materia.
     * @param hours Cantidad de horas de la materia.
     * @param teacher Profesor encargado de la materia.
     */

     public Subject(String name, int credits, String ID, String course, int hours, Teacher teacher){
        setName(name);
        setCredits(credits);
        setID(ID);
        setHours(hours);
        setCourse(course);
        setTeacher(teacher);
        
        this.students = new ArrayList<>();
       }

    /**
     * Obtiene el nombre de la materia.
     * @return Nombre de la materia.
     */

    public String getName() {
        return name;
    }

    /**
     * Obtiene la cantidad de créditos de la materia.
     * @return Cantidad de créditos.
     */

    public int getCredits() {
        return credits;
    }

    /**
     * Obtiene el identificador único de la materia.
     * @return Identificador de la materia.
     */

    public String getID() {
        return ID;
    }

    /**
     * Obtiene la cantidad de horas de la materia.
     * @return Cantidad de horas.
     */

    public int getHours() {
        return hours;
    }

    /**
     * Obtiene el curso al que pertenece la materia.
     * @return Curso de la materia.
     */

    public String getCourse() {
        return course;
    }

    /**
     * Obtiene el profesor encargado de la materia.
     * @return Profesor de la materia.
     */

    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Asigna un nombre a la materia.
     * @param name Nombre de la materia.
     * @throws IllegalArgumentException Si el nombre es nulo, vacío o contiene números.
     */

     public void setName(String name){
        if (name == null || name.trim().isEmpty() || name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
        }
        this.name = name;
    }

    /**
     * Asigna la cantidad de créditos a la materia.
     * @param credits Cantidad de créditos.
     * @throws IllegalArgumentException Si los créditos son 0.
     */

     public void setCredits(int credits){
        if (credits == 0){
            throw new IllegalArgumentException("Los créditos deben de tener un mínimo de 1");
        }
        this.credits = credits;
    }

    /**
     * Asigna el identificador único de la materia.
     * @param ID Identificador de la materia.
     * @throws IllegalArgumentException Si el identificador es nulo.
     */

     public void setID(String ID){
        if (ID == null){
            throw new IllegalArgumentException("El esapcio no puede estar vacio. ");
        }
        this.ID = ID;
    }

    /**
     * Asigna la cantidad de horas a la materia.
     * @param hours Cantidad de horas.
     * @throws IllegalArgumentException Si las horas son negativas.
     */

     public void setHours(int hours){
        if (hours < 0){
            throw new IllegalArgumentException("Las horas no pueden ser negativas.");
        }
        this.hours = hours;
    }   
    
    /**
     * Asigna el curso al que pertenece la materia.
     * @param course Curso de la materia.
     * @throws IllegalArgumentException Si el curso es nulo, vacío o contiene números.
     */

     public void setCourse(String course){
        if(course == null || course.trim().isEmpty() || course.matches(".*\\d.*")){
            throw new IllegalArgumentException("El curso no puede contener números.");
        }
        this.course = course;
    }

    /**
     * Asigna un profesor a la materia.
     * @param teacher Profesor de la materia.
     * @throws IllegalArgumentException Si el profesor es nulo.
     */

     public void setTeacher(Teacher teacher){
        if (teacher == null){
            throw new IllegalArgumentException("El profesor no puede ser nulo.");
        }
        this.teacher = teacher;
        }
    }
