package poom.actividad4.models;

import java.util.List;

/**
 * Representa un curso que contiene información sobre su nombre,
 * lista de materias, créditos, profesor y estudiante asignados.
 */

public class Course {
    private String name;
    private List<Subject> subjects;
    private int credit;
    private Teacher teacher;
    private Student student;
    private Subject subject;
    
    /**
     * @param name Nombre del curso.
     * @param subjects Lista de materias asociadas al curso.
     * @param credit Cantidad de créditos del curso.
     * @param teacher Profesor asignado al curso.
     * @param student Estudiante inscrito en el curso.
     * @param subject Materia inscrita en el curso
     * @throws IllegalArgumentException Si algún parámetro es inválido.
     */

    public Course(String name, List<Subject> subjects, int credit, Teacher teacher, Student student) {
        setName(name);
        setSubject(subjects);
        setCredit(credit);
        setTeacher(teacher);
        setStudent(student);
    }
    
    /**
     * Obtiene el nombre del curso.
     * @return Nombre del curso.
     */

    public String getName() { return name; }
    
    /**
     * Obtiene la cantidad de créditos del curso.
     * @return Cantidad de créditos.
     */

    public int getCredit() { return credit; }
    
    /**
     * Obtiene la lista de materias del curso.
     * @return Lista de materias.
     */

    public List<Subject> getSubject() { return subjects; }
    
    /**
     * Obtiene el profesor asignado al curso.
     * @return Profesor del curso.
     */

    public Teacher getTeacher() { return teacher; }
    
    /**
     * Obtiene el estudiante inscrito en el curso.
     * @return Estudiante del curso.
     */

    public Student getStudent() { return student; }
    
    /**
     * Establece el nombre del curso.
     * @param name Nombre del curso.
     * @throws IllegalArgumentException Si el nombre es nulo o vacío.
     */

     public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede quedar vacio.");
        }else{
            this.name = name;
        }
    }
    
    /**
     * Establece la lista de materias del curso.
     * @param subjects Lista de materias.
     * @throws IllegalArgumentException Si la lista de materias es nula.
     */

     public void setSubject(List<Subject> subjects){
        if(subject == null){
            throw new IllegalArgumentException("El tema no puede quedar vacio.");
        }else{
            subjects.add(subject);
        }
    }
    
    /**
     * Establece la cantidad de créditos del curso.
     * @param credit Cantidad de créditos.
     * @throws IllegalArgumentException Si los créditos son 0 o negativos.
     */

     public void setCredit(int credit){
        if(credit == 0){
            throw new IllegalArgumentException("Los creditos deben de tener un minimo de 1");
        }else{
            this.credit = credit;
        }
    }
    
    /**
     * Establece el profesor del curso.
     * @param teacher Profesor asignado.
     * @throws IllegalArgumentException Si el profesor es nulo.
     */

     public void setTeacher(Teacher teacher){
        if(teacher == null){
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacio.");
        }else{
            this.teacher = teacher;
        }
    }
    
    /**
     * Establece el estudiante inscrito en el curso.
     * @param student Estudiante inscrito.
     * @throws IllegalArgumentException Si el estudiante es nulo.
     */

     public void setStudent(Student student){
        if(student == null){
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacio.");
        }else{
            this.student = student;
        }
    }

}
