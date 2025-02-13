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
import poom.actividad4.models.Subject;


public class CLI {


private Scanner scanner;
    private List<Student> students;
    private List<Teacher> teachers;

    private String student;
    private Lang lang;

    public CLI() {
        scanner = new Scanner(System.in);
        selectLanguage();
    }       
    public static void main(String[] args) {
        Student student1 = new Student("Juan Perez López", 21,30211001,null);
        Student student2 = new Student("Clara Fernández Álvarez", 21, 30211002, null);
        Student student3 = new Student("María González Ramírez", 19, 30211003,null);
        Student student4 = new Student("Carlos Herrera Sánchez", 22, 30211004,null);
        Student student5 = new Student("Ana Martínez Torres", 20, 30211005,null);
        Student student6 = new Student("Sofía Castro Morales", 18, 30211006,null);
        Student student7 = new Student("Miguel Rojas Ortega", 25, 30211007,null);
        Student student8 = new Student("Daniela Chávez Flores", 21, 30211008,null);
        Student student9 = new Student("Andrés Jiménez Navarro", 19, 30211009,null);
        Student student10 = new Student("Patricia Salazar Mendoza", 24, 30211010,null);
        Student student11 = new Student("Ricardo Ortega Villalobos", 22, 30211011,null);
        Student student12 = new Student("Gabriela Suárez Pineda", 20, 30211012,null);
        Student student13 = new Student("Fernando López Castillo", 23, 30211013, null);
        Student student14 = new Student("Laura Méndez Ruiz", 19, 30211014, null);
        Student student15 = new Student("Diego Ramírez Navas", 24, 30211015, null);
        Student student16 = new Student("Valeria Torres Cervantes", 22, 30211016, null);
        Student student17 = new Student("Alejandro Vega Pacheco", 21, 30211017, null);
        Student student18 = new Student("Camila Reyes Silva", 18, 30211018, null);
        Student student19 = new Student("Eduardo Álvarez Fuentes", 25, 30211019, null);
        Student student20 = new Student("Carolina Herrera Domínguez", 20, 30211020, null);
        Student student21 = new Student("Javier Núñez Ortega", 22, 30211021, null);
        Student student22 = new Student("Natalia Rivas Camacho", 19, 30211022, null);
        Student student23 = new Student( "Roberto Fernández Jiménez", 20, 30211023, null);

        Subject subject1 = new Subject("POO", 30, "3456", null, 80,null );
        Subject subject2 = new Subject(null, 0, null, null, 0, null);
        Subject subject3 = new Subject(null, 0, null, null, 0, null);

        Course course = new Course(null, null, 0);

        Teacher teacher = new Teacher(null, 0, 0);


    


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
        
        switch (option) {
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

        private void showMenu() {
            System.out.println("+------------------------------+");
            System.out.println(lang.MENU);
            System.out.println("+------------------------------+");
        }

        public void runApp() {
            while (true) {
                showMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
                
               switch (opcion) {
                    case 1:
                        showStudents();
                        break;
                    case 2:
                        showCourses();
                        break;
                    case 3:
                        showTeachers();
                        break;
                    case 4:
                        addStudent();
                        break;
                    case 5:
                        addCourse();
                        break;
                    case 6:
                        addTeacher();
                        break;
                    case 7:
                        assignTeacherToCourse();
                        break;
                    case 8:
                        assignStudentToCourse();
                        break;
                    case 9:
                        showStudentsInCourse();
                        break;
                    case 10:
                        showTeachersInCourse();
                        break;
                    case 11:
                        System.out.println(lang.EXIT);
                        return;
                    default:
                        System.out.println(lang.INVALID);
                }
            }
        }
        private void Students
}

