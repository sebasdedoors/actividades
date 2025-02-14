package poom.actividad4.process;

import poom.actividad4.models.Student;
import poom.actividad4.models.Subject;
import poom.actividad4.models.Teacher;
import poom.actividad4.models.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Clase que gestiona la administración de una escuela, incluyendo la inscripción de profesores, cursos,
 * estudiantes y materias, así como la asignación de estos elementos entre sí.
 */

public class SchoolManager {

    /** Mapa que asocia cursos con sus respectivas materias. */
    public static Map<Course, List<Subject>> courseMap = new HashMap<>();
    
    /** Mapa que asocia profesores con las materias que imparten. */
    public static Map<Teacher, List<Subject>> teacherMap = new HashMap<>();
    
    /** Mapa que asocia cursos con sus profesores asignados. */
    public static Map<Course, Teacher> courseTeacherMap = new HashMap<>();
    
    /** Mapa que asocia cursos con los estudiantes inscritos en ellos. */
    public static Map<Course, List<Student>> studentCourseMap = new HashMap<>();
    
    /** Mapa que asocia materias con otras materias relacionadas. */
    public static Map<Subject, List<Subject>> subjectMap = new HashMap<>();
    
    /** Lista de todas las materias registradas en la escuela. */
    public static List<Subject> subjectList = new ArrayList<>();
    
    /** Mapa que asocia estudiantes con otros estudiantes relacionados. */
    public static Map<Student, List<Student>> studentMap = new HashMap<>();

    /**
     * Inscribe un profesor en el sistema.
     * @param teacher El profesor a inscribir.
     */

     public static void enrollTeacher(Teacher teacher){
        teacher = new Teacher(null, 0, 0);
        teacherMap.put(teacher, new ArrayList<>());
    }

    /**
     * Inscribe un curso en el sistema.
     * @param course El curso a inscribir.
     */

     public static void enrollCourse(Course course){
        course = new Course(null, subjectList, 0, null, null);
        courseMap.put(course, new ArrayList<>());
    }


    /**
     * Inscribe un estudiante en el sistema.
     * @param student El estudiante a inscribir.
     */

     public static void enrollStudent(Student student){
        student = new Student(null, 0, 0, null);
        studentMap.put(student, new ArrayList<>());
    } 

    /**
     * Inscribe una materia en el sistema.
     * @param subject La materia a inscribir.
     */

     public static void enrollSubject(Subject subject){
        subject = new Subject(null, 0, null, null, 0, null);
        subjectMap.put(subject, new ArrayList<>());
    }

    /**
     * Asigna un estudiante a un curso específico.
     * @param course El curso al que se inscribirá el estudiante.
     * @param student El estudiante a inscribir.
     */

     public static void assignStudent(Course course, Student student){
        studentCourseMap.putIfAbsent(course, new ArrayList<>());
        studentCourseMap.get(course).add(student);
        System.out.println("Estudiante " + student.getName() + " se ha inscrito con exito en " + course.getName());
    }

    /**
     * Asigna un profesor a un curso específico.
     * @param course El curso al que se asignará el profesor.
     * @param teacher El profesor a asignar.
     */

     public static void assignTeacher(Course course, Teacher teacher){
        courseTeacherMap.put(course, teacher);
    }

    /**
     * Asigna una materia a un profesor.
     * @param subject La materia a asignar.
     * @param teacher El profesor que impartirá la materia.
     */

     public static void assignSubject(Subject subject, Teacher teacher){
        teacherMap.putIfAbsent(teacher, new ArrayList<>());
        teacherMap.get(teacher).add(subject);
    }

    /**
     * Agrega una materia a un curso, verificando disponibilidad de profesores.
     * @param subject La materia a agregar.
     * @param course El curso al que se añadirá la materia.
     */

     public static void enrollSubjectToCourse(Subject subject, Course course){
        courseMap.putIfAbsent(course, new ArrayList<>());
        if(courseMap.get(course).size() >= 3){
            System.out.println("Error: El curso: " + course.getName() + " ya tiene 3 materias asignadas.");
            return;
        }
        Teacher assignedTeacher = subject.getTeacher();
        if(teacherMap.containsKey(assignedTeacher) == false){

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
        course.setTeacher(assignedTeacher);
        System.out.println("La mareria " + subject.getName() + " se ha agregado al curso " + course.getName() + " con exito.");
    } 

    /**
     * Inscribe un estudiante a un curso específico.
     * @param student El estudiante a inscribir.
     * @param course El curso al que se inscribirá el estudiante.
     */

     public static void enrollStudentToCourse(Student student, Course course){
        studentCourseMap.putIfAbsent(course, new ArrayList<>());
        studentCourseMap.get(course).add(student);
    }

    /**
     * Muestra la lista de estudiantes inscritos en un curso.
     * @param course El curso del que se mostrarán los estudiantes.
     */

     public static void showStudentsInCourse(Course course){
        List<Student> students = studentCourseMap.get(course);

        System.out.println("\n Estos son los estudiantes en el curso: " + course.getName());
        if(students == null || students.isEmpty()){
            System.out.println("No hay estudiantes inscritos.");
            return;
        }

        for (Student student : students){
            System.out.println(" - " + student.getName());
        }
    }


    /**
     * Muestra la lista de cursos disponibles junto con sus materias y profesores asignados.
     */

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

/**
 * Muestra los profesores registrados y las materias asignadas a cada uno.
 * Si no hay profesores registrados, se muestra un mensaje indicando esto.
 */

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

/**
 * Muestra los alumnos asignados a un curso específico.
 * Si no hay alumnos asignados, se muestra un mensaje indicando esto.
 *  @param course El curso del cual se mostrarán los alumnos asignados.
 */

 public static void showStudentInCourse(Course course){
    Student student = course.getStudent();

    if(student == null){
        System.out.println("No hay alumnos asignados a " + course.getName());
        return;
    }

    System.out.println("\nAlumnos asignados al curso " + course.getName() + ":");
    for(Course studentCourse : studentCourseMap.keySet()){
        System.out.println("- " + studentCourse.getName());
    }
}

/**
 * Muestra los profesores asignados a un curso específico.
 * Si no hay profesores asignados, se muestra un mensaje indicando esto.
 * @param course El curso del cual se mostrarán los profesores asignados.
 */

 public static void showTeacherInCourse(Course course){
    Teacher teachers = course.getTeacher();

    if(teachers == null){
        System.out.println("NO hay profesores asignados a " + course.getName());
        return;
    }

    System.out.println("\nProfesores asignados al curso " + course.getName() + ":");
    for(Teacher teacher : teacherMap.keySet()){
        System.out.println("- " + teacher.getName());
    }
}


/**
 * Muestra las materias asignadas a un profesor específico.
 * Si no hay materias asignadas, se muestra un mensaje indicando esto.
 * @param teacher El profesor cuyo listado de materias asignadas se mostrará.
 */

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

/**
 * Asigna una materia a un profesor. Si el profesor ya tiene 4 materias asignadas o si la materia ya tiene un profesor asignado,
 * se muestra un mensaje de error. Si no, la materia se asigna correctamente al profesor.
 * @param subject La materia que se asignará al profesor.
 * @param teacher El profesor al cual se asignará la materia.
 */

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

/**
 * Calcula el total de horas y créditos de un curso sumando las horas y créditos de las materias asignadas a él.
 * @param course El curso del cual se calcularán las horas y créditos.
 */

 public static void calculateHoursAndCredits(Course course){
    List<Subject> subjects = courseMap.get(course);
    int totalHours = 0;
    int totalCredits = 0;

    for(Subject subject : subjects){
        totalHours += subject.getHours();
        totalCredits += subject.getCredits();
    }
    System.out.println("El curso " + course.getName() + " tiene un total de " + totalHours + " horas y " + totalCredits + " créditos.");
}

/**
 * Calcula el salario de un profesor basado en el número de cursos que tiene asignados.
 * El salario base es incrementado según la cantidad de cursos que el profesor tiene asignados.
 * @param teacher El profesor cuyo salario será calculado.
 */

 public void calculateSalary(Teacher teacher){
    double salary = teacher.getSalary();
    double totalSalary = 0;
    if(courseTeacherMap.size() == 1){
        totalSalary = salary;
    }
    if(courseTeacherMap.size() == 2){
        totalSalary = salary + (salary * 0.25);
    }
    if(courseTeacherMap.size() == 3){
        totalSalary = salary + (salary * 0.5);
    }
    if(courseTeacherMap.size() == 4){
        totalSalary = salary + (salary * 0.75);
    }
    teacher.setPayroll(totalSalary);
}

/**
 * Muestra las materias asignadas a un curso específico.
 * Si no hay materias asignadas, se muestra un mensaje indicando esto.
 * @param subject La materia que se verificará si está asignada al curso.
 * @param course El curso cuyo listado de materias asignadas se mostrará.
 */

 public void showSubjectsInCourse(Subject subject, Course course){
    List<Subject> subjects = course.getSubject();

    if(subjects == null){
        System.out.println("No hay materias asignadas a " + course.getName());
        return;
    }

    System.out.println("\nMaterias asignados al curso: " + course.getName() + ":");
    for(Subject subjectCourse : subjectMap.keySet()){
        System.out.println("- " + subjectCourse.getName());
    }
    return;
}

}
