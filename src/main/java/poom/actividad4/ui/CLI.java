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
    private static SchoolManager schoolManager;
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
        System.out.println("+------------------------------------------+");
        System.out.println(lang.MENU);
        System.out.println("+------------------------------------------+");
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
                    addTeacher(); 
                    break;
                case 3:
                    addSubject(); 
                    break;
                case 4:
                    addCourse(); 
                    break;
                case 5:
                    showStudents();
                    break;
                case 6:
                    showTeachers(); 
                    break;
                case 7:
                    showSubjects(); 
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
                    System.exit(0);
                    break;
                default:
                    System.out.println(lang.INVALID);
            }
        }
    }

    /*addSubject, assignSubjectToCourse, showSubjectsInTeacher, assignSubjectToTeacher, calculateHoursAndCredits, calculateSalary */
    private static void showStudents(){
        for(var entry : schoolManager.studentMap.entrySet()){
            System.out.println("Estudiantes " + entry.getKey());
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

    private void addStudent(){ /*Acua*/
        try{
            System.out.println(lang.NAME);
            String name = scanner.nextLine();
            System.out.println(lang.AGE);
            int age = scanner.nextInt();
            System.out.println(lang.TUITION);
            int tuition = scanner.nextInt();
            System.out.println(lang.COURSENAME);
            String courseName = scanner.nextLine();
            schoolManager.enrollStudent(name, age, tuition, courseName);
            System.out.println(lang.SUCCESS);
        }catch(Exception e){
            System.out.println(lang.ERROR + e.getMessage());
        }
    }
    
    private void addCourse(){
        try{
            System.out.println(lang.COURSENAME);
            String name = scanner.nextLine();
            System.out.println(lang.NUMSUB);
            int numsub = scanner.nextInt();
            if(numsub < 3){
                System.out.println(lang.NUMNEED_M);
                return;
            }
            for(int i = 1; i < numsub; i++){
                String newSubject = scanner.nextLine();
                subjects.add(newSubject);
            }
            System.out.println(lang.CREDITS);
            int credit = scanner.nextInt();

            System.out.println(lang.SUCCESS_COURSE);
            schoolManager.enrollCourse(name, course.getSubject(), credit, course.getTeacher(), course.getStudent());
        }catch(Exception e){
            System.out.println(lang.ERROR_COURSE + e.getMessage());
        }
    }

    private void addTeacher(){ /*Aqui tambien. */
        try{
            System.out.println(lang.NAME_PROFESSOR);
            String name = scanner.nextLine();
            System.out.println(lang.SALARY_PROFESSOR);
            double salary = scanner.nextDouble();
            System.out.println("Escriba la nomina del maestro:");
            double payroll = scanner.nextDouble();

            schoolManager.enrollTeacher(name, salary, payroll);
            System.out.println(lang.SUCCESS_PROFESSOR);
        }catch(Exception e){
            System.out.println(lang.ERROR_PROFESSOR + e.getMessage());
        }
    }

    private void assignTeacherToCourse(){
        System.out.println(lang.COURSENAME);
        String curso = scanner.nextLine();
        if(schoolManager.courseMap.containsValue(curso) == false){
            System.out.println(lang.COURSE_NOT_FOUND);
            return;
        } 
        System.out.println(lang.NAME_PROFESSOR);
        String teacherName = scanner.nextLine();
        Teacher teacher = schoolManager.courseTeacherMap.get(teacherName);
        
        if(schoolManager.courseTeacherMap.containsValue(teacher)){
        System.out.println(lang.ASSIGN_ALREADY_PROFESSOR);
        return;
        }
        schoolManager.assignTeacher(course, teacher);;
    }

    private void assignStudentToCourse(){
        try{
            System.out.println(lang.COURSENAME);
            String courseName = scanner.nextLine();
            Course course = null;
            for (Course c : schoolManager.courseMap.keySet()) {
                if (c.getName().equals(courseName)) {
                    course = c;
                    break;
                }
            }
            if(course == null){
                System.out.println(lang.COURSE_NOT_FOUND);
                return;
            }
            System.out.println(lang.NAME);
            String studentName = scanner.nextLine();
            List<Student> students = schoolManager.studentMap.get(studentName);
            if(students == null || students.isEmpty()){
                System.out.println(lang.STUDENT_NOT_FOUND);
                return;
            }
            Student student = students.get(0); // Assuming the first student in the list
            if(schoolManager.studentCourseMap.containsValue(student)){
                System.out.println(lang.ASSIGN_ALREADY_STUDENT);
                return;
            }
            schoolManager.enrollStudentToCourse(student, course);
            System.out.println(lang.SUCCESS);
        }catch(Exception e){
            System.out.println(lang.ERROR + e.getMessage());
        }
    }

    private void showStudentsInCourse(){
        System.out.println(lang.COURSENAME);
        String courseName = scanner.nextLine();
        if(schoolManager.studentCourseMap.containsKey(courseName) == false){
            System.out.println(lang.COURSE_NOT_FOUND2);
            return;
        }
        for(var entry : schoolManager.studentCourseMap.entrySet()){
            System.out.println(lang.COURSE + entry.getKey() + lang.STUDENT + entry.getValue());
        }
    }

    private void showTeachersInCourse(){
        System.out.println(lang.COURSENAME);
        String courseName = scanner.nextLine();
        if(schoolManager.courseTeacherMap.containsKey(courseName) == false){
            System.out.println(lang.COURSE_NOT_FOUND2);
            return;
        }
        for(var entry : schoolManager.courseTeacherMap.entrySet()){
            System.out.println(lang.COURSE + entry.getKey() + lang.PROFESSOR + entry.getValue());
        }
    }

    private void addSubject(){
        try{
        System.out.println(lang.SUBJECTNAME);
        String name = scanner.nextLine();
        subject.setName(name);
        System.out.println(lang.CREDITS_M);
        int credits = scanner.nextInt();
        subject.setCredits(credits);
        System.out.println(lang.ID);
        String id = scanner.nextLine();
        subject.setID(id);
        System.out.println(lang.COURSE_TO_SUBJECT);
        String course = scanner.nextLine();
        subject.setCourse(course);
        System.out.println(lang.HOURS_M);
        int hours = scanner.nextInt();
        subject.setHours(hours);

        schoolManager.enrollSubject(subject);
        System.out.println(lang.SUCCESS);
        }catch(Exception e){
            System.out.println(lang.ERROR + e.getMessage());
        }
    }

    private void assignSubjectToCourse(){
        try{
            System.out.println(lang.COURSENAME);
            String courseName = scanner.nextLine();
            if(schoolManager.courseMap.containsKey(courseName) == false){
                System.out.println(lang.COURSE_NOT_FOUND);
                return;
            }
            System.out.println(lang.SUBJECTNAME);;
            String subjectName = scanner.nextLine();
            if(schoolManager.courseMap.containsValue(subjectName) == true){
                System.out.println(lang.ALREADY_SUBJECT);
                return;
            }
            schoolManager.enrollSubjectToCourse(subject, course);
            System.out.println(lang.SUCCESS);
        }catch(Exception e){
            System.out.println(lang.ERROR + e.getMessage());
        }
    }

    private void showSubjectsInTeacher(){
        System.out.println(lang.NAME_PROFESSOR);
        String teacherName = scanner.nextLine();
        if(schoolManager.courseTeacherMap.containsValue(teacherName) == false){
            System.out.println(lang.PROFESSOR_NOT_FOUND);
            return;
        }
        schoolManager.subjectMap.get(teacherName);
        for(var entry: schoolManager.courseTeacherMap.entrySet()){
            System.out.println(lang.PROFESSOR + entry.getValue() + lang.SUBJECT + subject.getName());
        }
    }

    private void assignSubjectToTeacher(){
        try{
            System.out.println(lang.SUBJECTNAME);
            String subjectName =scanner.nextLine();
            if(schoolManager.courseMap.containsValue(subjectName) == false){
                System.out.println(lang.SUBJECT_NOT_FOUND);
                return;
            }
            System.out.println(lang.NAME_PROFESSOR);
            String teacherName = scanner.nextLine();
            if(schoolManager.teacherMap.containsKey(teacherName) == false){
                System.out.println(lang.PROFESSOR_NOT_FOUND);
                return;
            }
            schoolManager.assignSubjectToTeacher(subject, teacher);
            System.out.println(lang.SUCCESS);
        }catch(Exception e){
            System.out.println(lang.ERROR + e.getMessage());
        }
    }

    private void calculateHoursAndCredits(){
        schoolManager.calculateHoursAndCredits(course);
    }

    private void calculateSalary(){
        System.out.println(lang.ADD_SALARY);
        double salary = scanner.nextDouble();
        System.out.println(lang.NUM_M);
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
            System.out.println("- " + subject.getName() + lang.CREDITS2 + subject.getCredits() + lang.ID + subject.getID() + lang.COURSE + subject.getCourse() + lang.HOURS + subject.getHours() + lang.PROFESSOR + subject.getTeacher());
        }
    }

    

}



