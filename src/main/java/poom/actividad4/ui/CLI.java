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
    private Lang lang;

    public CLI() {
        scanner = new Scanner(System.in);
        selectLanguage();
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
        
        switch (option) {
            case 1:
                lang = new Esp();
                break;
            case 2:
                lang = new Eng();
                break;
            case 3:
                lang = new De();
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
}

