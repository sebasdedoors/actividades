package poom.actividad4.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import poom.actividad4.ui.Lang;

import poom.actividad4.models.Course;
import poom.actividad4.models.Student;
import poom.actividad4.models.Teacher;
import poom.actividad4.process.SchoolManager;
import poom.actividad4.models.Subject;


public class CLI {
    private Scanner scanner;
    private List<Student> students;
    private List<Teacher> teachers;
    private Student student;
    private Lang lang;
    private Teacher teacher;
    private Course course;
    private SchoolManager schoolManager;
    private Map<Course, String> courseMap;
    private Map<Teacher, List<Subject>> teacherMap;
    private List<String> subjects;
    private Subject subject;

    public CLI(){
        scanner = new Scanner(System.in);
        schoolManager = new SchoolManager();
        selectLanguage();
    }   
    
    public CLI(Lang lang){
        this.lang = lang;
        this.scanner = new Scanner(System.in);
    }

    public void selectLanguage() {
        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                       Hola! Bienvenido |  Hello! Welcome | Hallo! Willkommen | Ciao! Benvenut@                   |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|            Select a language / Seleccione un idioma / Wählen Sie eine Sprache / Seleziona una lingua:            |");
        System.out.println("|                                                  1. Español                                                      |");
        System.out.println("|                                                  2. English                                                      |");
        System.out.println("|                                                  3. Deutsch                                                      |");
        System.out.println("|                                                  4. Italiano                                                     |"); 
        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|             Ingrese una opción / Enter an option / Geben Sie eine Option ein / Inserisci un'opzione:             |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
            
        int option = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (option){
            case 1:
                lang = new Esp();
                break;
            case 2:
                lang = new Eng();
                break;
            case 3:
                lang = new Deu();
                break;
            case 4:
                lang = new Ita();
                break;
            default:
                System.out.println("Opción no válida. Español por defecto.");
                lang = new Esp();
        }
    }

    private void showMenu(){
        System.out.println("+------------------------------+");
        System.out.println(lang.MENU);
        System.out.println("+------------------------------+");
    }

    public void runApp(){
        while (true) {
            showMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
           switch (opcion) {
                case 1:
                    addStudent(); 
                    break;
                case 2:
                    showStudents(); 
                    break;
                case 3:
                    addTeacher(); 
                    break;
                case 4:
                    showTeachers(); 
                    break;
                case 5:
                    addSubject(); 
                    break;
                case 6:
                    showSubjects(); 
                    break;
                case 7:
                    addCourse(); 
                    break;
                case 8:
                    showCourses(); 
                    break;
                case 9:
                    showStudentsInCourse(); 
                    break;
                case 10:
                    showTeachersInCourse();
                    break;
                case 11:
                    assignTeacherToCourse();
                    break;
                case 12:
                    assignStudentToCourse();
                    break;
                case 13:
                    assignSubjectToCourse();
                    break;
                case 14:
                    showSubjectsInTeacher();
                    break;
                case 15:
                    assignSubjectToTeacher();
                    break;
                case 16:
                    calculateHoursAndCredits();
                    break;
                case 17:
                    calculateSalary();
                    break;
                case 18:
                    System.out.println(lang.EXIT);
                    break;
                default:
                    System.out.println(lang.INVALID);
            }
        }
    }

    /*addSubject, assignSubjectToCourse, showSubjectsInTeacher, assignSubjectToTeacher, calculateHoursAndCredits, calculateSalary */
    private void showStudents(){
        for(Student student : students){
            System.out.println("- " + student.getName() + ", Edad: " + student.getAge() + ", Curso: " + student.getCourse() + ", Matricula: " + student.getToition() + ".");
        }
    }

    private void showCourses(){
        for(Course course : courseMap.keySet()){
            System.out.println("- " + course.getName() + ", Materias: " + course.getSubject() + ", Creditos: " + course.getCredit());
        }
    }

    private void showTeachers(){
        for(Teacher teacher : teacherMap.keySet()){
            System.out.println("- " + teacher.getName() + ", Materias impartidas: " + teacher.getSubjects() + ", Salario: " + teacher.getSalary() + ", Nomina: " + teacher.getPayroll());
        }
    }

    private void addStudent(){
        try{
            System.out.println("Ingrese el nombre completo del estudiante:");
            String name = scanner.nextLine();
            student.setName(name);
            System.out.println("Ingrese la edad del estudiante: ");
            int age = scanner.nextInt();
            student.setAge(age);
            System.out.println("Ingrese la matricula el estudiante: ");
            int tuition = scanner.nextInt();
            student.setToition(tuition);
            System.out.println("Escriba el curso del estudiante: ");
            String courseName = scanner.nextLine();
            student.setCourse(courseName);

            schoolManager.enrollStudent(student);
            System.out.println("Producto agregado exitosamente");
        }catch(Exception e){
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }
    
    private void addCourse(){
        try{
            System.out.println("Ingrese el nombre del curso:");
            String name = scanner.nextLine();
            course.setName(name);
            System.out.println("¿Cúantas materias tendrá el curso?");
            int numsub = scanner.nextInt();
            if(numsub < 3){
                System.out.println("El curso debe de tener al menos 3 materias");
                return;
            }
            for(int i = 1; i < numsub; i++){
                String newSubject = scanner.nextLine();
                subjects.add(newSubject);
            }
            System.out.println("Ingrese la cantidad de creditos: ");
            int credit = scanner.nextInt();
            course.setCredit(credit);

            System.out.println("El curso se agrego con exito.");
            schoolManager.enrollCourse(course);
        }catch(Exception e){
            System.out.println("Erroral agregar el curso: " + e.getMessage());
        }
    }

    private void addTeacher(){
        try{
            System.out.println("Ingrese el nombre del profesor:");
            String name = scanner.nextLine();
            teacher.setName(name);
            System.out.println("Ingrese el salario base del profesor:");
            double salary = scanner.nextDouble();
            teacher.setSalary(salary);

            schoolManager.enrollTeacher(teacher);
            System.out.println("El maestro se agrego con exito.");
        }catch(Exception e){
            System.out.println("Error al agregar al profesor: " + e.getMessage());
        }
    }

    private void assignTeacherToCourse(){
        System.out.println("Ingrese el nombre del curso:");
        String curso = scanner.nextLine();
        if(schoolManager.courseMap.containsValue(curso) == false){
            System.out.println("El curso no ha sido encontrado, primero cree el curso por favor.");
            return;
        } 
        System.out.println("Ingrese el nombre del profesor:");
        String teacherName = scanner.nextLine();
        Teacher teacher = schoolManager.courseTeacherMap.get(teacherName);
        
        if(schoolManager.courseTeacherMap.containsValue(teacher)){
        System.out.println("Este maestro ya esta asignado a este curso.");
        return;
        }
        schoolManager.assignTeacher(course, teacher);;
    }

    private void assignStudentToCourse(){
        try{
            System.out.println("Ingrese el nombre del curso:");
            String courseName = scanner.nextLine();
            Course course = null;
            for (Course c : schoolManager.courseMap.keySet()) {
                if (c.getName().equals(courseName)) {
                    course = c;
                    break;
                }
            }
            if(course == null){
                System.out.println("El curso no ha sido creado aún, por favor creelo primero.");
                return;
            }
            System.out.println("Ingrese el nombre del estudiannte:");
            String studentName = scanner.nextLine();
            List<Student> students = schoolManager.studentMap.get(studentName);
            if(students == null || students.isEmpty()){
                System.out.println("El estudiante no ha sido agregado aun, agreguelo por favor.");
                return;
            }
            Student student = students.get(0); // Assuming the first student in the list
            if(schoolManager.studentCourseMap.containsValue(student)){
                System.out.println("El estudiante ya esta asignado a este curso.");
                return;
            }
            schoolManager.enrollStudentToCourse(student, course);
            System.out.println("El estudiante ha sido asignado conexito.");
        }catch(Exception e){
            System.out.println("Error al asignar al estudiante: " + e.getMessage());
        }
    }

    private void showStudentsInCourse(){
        System.out.println("Escriba el nombre del curso:");
        String courseName = scanner.nextLine();
        if(schoolManager.studentCourseMap.containsKey(courseName) == false){
            System.out.println("El curso que ha escrito no ha sido encontrado, por favor verifique su petición.");
            return;
        }
        for(var entry : schoolManager.studentCourseMap.entrySet()){
            System.out.println("Curso: " + entry.getKey() + ", Estudiante: " + entry.getValue());
        }
    }

    private void showTeachersInCourse(){
        System.out.println("Escribe el nombre del curso:");
        String courseName = scanner.nextLine();
        if(schoolManager.courseTeacherMap.containsKey(courseName) == false){
            System.out.println("El curso que ha escrito no ha sido encontrado, por favor verifique su escritura.");
            return;
        }
        for(var entry : schoolManager.courseTeacherMap.entrySet()){
            System.out.println("Curso: " + entry.getKey() + ", Profesor: " + entry.getValue());
        }
    }

    private void addSubject(){
        try{
        System.out.println("Ingrese el nombre de la materia:");
        String name = scanner.nextLine();
        subject.setName(name);
        System.out.println("Escriba la cantidad de creditos que vale la materia:");
        int credits = scanner.nextInt();
        subject.setCredits(credits);
        System.out.println("Escriba el ID de la materia:");
        String id = scanner.nextLine();
        subject.setID(id);
        System.out.println("Escriba el curso en el que se alojrá esta materia:");
        String course = scanner.nextLine();
        subject.setCourse(course);
        System.out.println("Escriba las horas por semana que se dará la clase:");
        int hours = scanner.nextInt();
        subject.setHours(hours);

        schoolManager.enrollSubject(subject);
        System.out.println("La materia se agregó con exito.");
        }catch(Exception e){
            System.out.println("Error al agregar materia: " + e.getMessage());
        }
    }

    private void assignSubjectToCourse(){
        try{
            System.out.println("Escriba el nombre del curso:");
            String courseName = scanner.nextLine();
            if(schoolManager.courseMap.containsKey(courseName) == false){
                System.out.println("El nombre del curso no fue econtrado, por favor verifique su escritura.");
                return;
            }
            System.out.println("Escriba el nombre de la materia:");
            String subjectName = scanner.nextLine();
            if(schoolManager.courseMap.containsValue(subjectName) == true){
                System.out.println("La materia ya esta asignada a este curso.");
                return;
            }
            schoolManager.enrollSubjectToCourse(subject, course);
            System.out.println("La materia fue asignada con exito.");
        }catch(Exception e){
            System.out.println("Error al  asignar materia al curso: " + e.getMessage());
        }
    }

    private void showSubjectsInTeacher(){
        System.out.println("Escriba el nombre del maestro:");
        String teacherName = scanner.nextLine();
        if(schoolManager.courseTeacherMap.containsValue(teacherName) == false){
            System.out.println("El nombre del maestro no ha sido encontrado, por favor verifique su escritura.");
            return;
        }
        schoolManager.subjectMap.get(teacherName);
        for(var entry: schoolManager.courseTeacherMap.entrySet()){
            System.out.println("Maestro: " + entry.getValue() + ", Materia: " + subject.getName());
        }
    }

    private void assignSubjectToTeacher(){
        try{
            System.out.println("Escriba el nombre de la materia:");
            String subjectName =scanner.nextLine();
            if(schoolManager.courseMap.containsValue(subjectName) == false){
                System.out.println("La materia no ha sido creada; por favor creala primero.");
                return;
            }
            System.out.println("Escriba el nombre del maestro:");
            String teacherName = scanner.nextLine();
            if(schoolManager.teacherMap.containsKey(teacherName) == false){
                System.out.println("El maestro no ha sido encontrado, primero cree al maestro.");
                return;
            }
            schoolManager.assignSubjectToTeacher(subject, teacher);
            System.out.println("La materia fue asignada con exito.");
        }catch(Exception e){
            System.out.println("Error al asignar materia: " + e.getMessage());
        }
    }

    private void calculateHoursAndCredits(){
        schoolManager.calculateHoursAndCredits(course);
    }

    private void calculateSalary(){
        System.out.println("Escriba el salario a calcular:");
        double salary = scanner.nextDouble();
        System.out.println("Escriba la cantidad de materias que llevara:");
        int subject = scanner.nextInt();
        if(subject == 1){
            salary = salary;
        }
        if(subject == 2){
            salary = salary + (salary * 0.25);
        }
        if(subject == 3){
            salary = salary + (salary * 0.5);
        }
        if(subject == 4){
            salary = salary + (salary * 0.75);
        }
        teacher.setPayroll(salary);
    }

    private void showSubjects(){
        for(Subject subject : schoolManager.subjectMap.keySet()){
            System.out.println("- " + subject.getName() + ", Creditos: " + subject.getCredits() + ", ID: " + subject.getID() + ", Curso: " + subject.getCourse() + ", Horas: " + subject.getHours() + ", Maestro: " + subject.getTeacher());
        }
    }
}



