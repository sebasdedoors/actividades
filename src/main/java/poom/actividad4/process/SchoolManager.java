package poom.actividad4.process;

import poom.actividad4.models.Student;
import poom.actividad4.models.Subject;
import poom.actividad4.models.Teacher;
import poom.actividad4.models.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SchoolManager {

    public static Map<Course, List<Subject>> courseMap = new HashMap<>();
    public static Map<Teacher, List<Subject>> teacherMap = new HashMap<>();
    public static Map<Course, Teacher> courseTeacherMap = new HashMap<>();
    public static Map<Course, List<Student>> studentCourseMap =new HashMap<>();
    public static Map<Subject, List<Subject>> subjectMap = new HashMap<>();
    public static List<Subject> subjectList = new ArrayList<>();

    public static void enrollTeacher(Teacher teacher){
        teacherMap.put(teacher, new ArrayList<>());
    }

    public static void enrollCourse(Course course){
        courseMap.put(course, new ArrayList<>());
    }

    public static void enrollStudent(Student student){
        studentCourseMap.putIfAbsent(null, new ArrayList<>());
    } 

    public static void enrollTopic(Subject subject){
        subjectMap.put(subject, new ArrayList<>());
    }

    public static void assignStudent(Course course, Student student){
        studentCourseMap.putIfAbsent(course, new ArrayList<>());
        studentCourseMap.get(course).add(student);
        System.out.println("Estudiante " + student.getName() + " se ha inscrito con exito en " + course.getName());
    }

    public static void assignTeacher(Course course, Teacher teacher){
        courseTeacherMap.put(course, teacher);
    }

    public static void assignSubject(Subject subject, Teacher teacher){
        teacherMap.putIfAbsent(teacher, new ArrayList<>());
        teacherMap.get(teacher).add(subject);
    }

    public static void enrollSubjectToCourse(Subject subject, Course course){
        courseMap.putIfAbsent(course, new ArrayList<>());
        if(courseMap.get(course).size() >= 3){
            System.out.println("Error: El curso: " + course.getName() + " ya tiene 3 materias asignadas.");
            return;
        }
        Teacher assignedTeacher = subject.getTeacher();
        if(assignedTeacher == null){
            assignedTeacher = findAvailableTeacher();

            if(assignedTeacher == null){
                System.out.println("Error: No hay profesores disponibles para asignar la materia " + subject.getName());
                return;
            }
            subject.setTeacher(assignedTeacher);
            teacherMap.putIfAbsent(assignedTeacher, new ArrayList<>());
            teacherMap.get(assignedTeacher).add(subject);
            System.out.println("Se ha asignado automáticamente el profesor " + assignedTeacher.getName() + " a la materia " + subject.getName());
        }else{
            System.out.println("La materia " + subject.getName() + " ya tiene a un profesor asignado: " + assignedTeacher.getName());
        }
        courseMap.get(course).add(subject);
        course.addTeacher(assignedTeacher);
        System.out.println("La mareria " + subject.getName() + " se ha agregado al curso " + course.getName() + " con exito.");
    } 

    public static void enrollStudentToCourse(Student student, Course course){
        studentCourseMap.putIfAbsent(course, new ArrayList<>());
        studentCourseMap.get(course).add(student);
    }

    public static void showStudentsInCourse(Course course){
        List<Student> students = studentCourseMap.get(course);

        System.out.println("\n Estos son los estudiantes en el curso: " + course.getName());
        if(students == null || students.isEmpty()){
            System.out.println("No hay estudiantes escritos.");
            return;
        }

        for (Student student : students){
            System.out.println(" - " + student.getName());
        }
    }

    public static void ahowCourses(){
        if(courseMap.isEmpty()){
            System.out.println("No hay cursos registrados.");
            return;
        }else{
            for(Map.Entry<Course, List<Subject>> entry : courseMap.entrySet()){
                Course course = entry.getKey();
                List<Subject> subjects = entry.getValue();
                Teacher teacher = courseTeacherMap.get(course);

                System.out.println("\n Curso: " + course.getName());
                System.out.println("Profesor: " + (teacher != null ? teacher.getName() : "No asignado"));

                for(Subject subject : subjects){
                    System.out.println(" - Materia: " + subject.getName() + ", Horas: " + subject.getHours() + ", Créditos: " + subject.getCredits() + ", ID: " + subject.getID());
                }
            }
        }
    }

    public static void showTeachers(){
        if(teacherMap.isEmpty()){
            System.out.println("No hay profesores registrados.");
            return;
        }else{
            for(Map.Entry<Teacher, List<Subject>> entry : teacherMap.entrySet()){
                Teacher teacher = entry.getKey();
                List<Subject> subjects = entry.getValue();

                System.out.println("\n Estos son los profesores registrados: " + teacher.getName());
                for(Subject subject : subjects){
                    System.out.println("- Materia: " + subject.getName() + ", Horas: " + subject.getHours() + ", Créditos: " + subject.getCredits());
                }
            }
        }
    }

    private static Teacher findAvailableTeacher(){}

    public static void showStudentInCourse(Course course){}

    public static void showTeacherInCourse(Course course){
        List<Teacher> teachers = course.getTeacher();

        if(teachers == null || teachers.isEmpty()){
            System.out.println("NO hay profesores asignados a " + course.getName());
            return;
        }

        System.out.println("\nProfesores asignados al curso " + course.getName() + ":");
        for(Teacher teacher : teachers){
            System.out.println("- " + teacher.getName());
        }
    }

    public static void showSubjectsInTeacher(Teacher teacher){
        List<Subject> subjects = teacherMap.get(teacher);

        if(subjects == null || subjects.isEmpty()){
            System.out.println("No hay materias asignadas a " + teacher.getName());
            return;
        }else{
            System.out.println("\n Materias asignadas al profesor " + teacher.getName() + ":");
            for(Subject subject : subjects){
                System.out.println("- " + subject.getName());
            }
        }
    }

    public static void assignSubjectToTeacher(Subject subject, Teacher teacher){
        teacherMap.putIfAbsent(teacher, new ArrayList<>());

        if(teacherMap.get(teacher).size() > 4){
            System.out.println("Error: EL profesor " + teacher.getName()  + "ya tiene 4 materias asignadas.");
            return;
        }
        if(subject.getTeacher() != null){
            System.out.println("Error: La materia " + subject.getName() + " ya tiene un profesor asignado: " + subject.getTeacher().getName());
            return;
        }
        subject.setTeacher(teacher);
        teacherMap.get(teacher).add(subject);
        System.out.println("La materia " + subject.getName() + " se ha asignado al profesor " + teacher.getName());
    }

    public static void calculateHoursAndCredits(Course course){}

    public static void calculateSalary(Teacher teacher){}

}
