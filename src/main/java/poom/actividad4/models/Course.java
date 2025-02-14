package poom.actividad4.models;

import java.util.List;

public class Course {
    private String name;
    private List<Subject> subjects;
    private int credit;
    private Teacher teacher;
    private Student student;
    private Subject subject;

    public Course(String name, List<Subject> subject, int credit, Teacher teacher, Student student){
        setName(name);
        setSubject(subjects);
        setCredit(credit);
        setTeacher(teacher);
        setStudent(student);
    }

    public String getName(){return name;}
    public int getCredit(){return credit;}
    public List<Subject> getSubject(){return subjects;}
    public Teacher getTeacher(){return teacher;}
    public Student getStudent(){return student;}

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede quedar vacio.");
        }else{
            this.name = name;
        }
    }

    public void setSubject(List<Subject> subjects){
        if(subject == null){
            throw new IllegalArgumentException("El tema no puede quedar vacio.");
        }else{
            subjects.add(subject);
        }
    }

    public void setCredit(int credit){
        if(credit == 0){
            throw new IllegalArgumentException("Los creditos deben de tener un minimo de 1");
        }else{
            this.credit = credit;
        }
    }

    public void setTeacher(Teacher teacher){
        if(teacher == null){
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacio.");
        }else{
            this.teacher = teacher;
        }
    }

    public void setStudent(Student student){
        if(student == null){
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacio.");
        }else{
            this.student = student;
        }
    }

}
