package poom.actividad4.ui;


/**
 * La clase {@code Eng} extiende la clase {@code Lang} y proporciona mensajes en inglés
 * para la interfaz de usuario de la aplicación. Inicializa varios mensajes relacionados
 * con opciones del menú, solicitudes de entrada, errores y confirmaciones.
 */

public class Eng extends Lang {

    public Eng() {
        EXIT = "Goodbye!";
        MENU = "\u001B[32m"+"|                   Menu:                  |\n" +
               "| 1. Add Student.                          |\n" +
               "| 2. Add Teacher.                          |\n" +
               "| 3. Add Subject.                          |\n" +
               "| 4. Add Course.                           |\n" +
               "| 5. Show Students                         |\n" +
               "| 6. Show Teachers                         |\n" +
               "| 7. Show Subjects                         |\n" +
               "| 8. Show Courses                          |\n" +
               "| 9. Show Students in the Course           |\n" +
               "| 10. Show Teachers in the Course          |\n" +
               "| 11. Assign Teachers to the Course        |\n" +
               "| 12. Assign Students to the Course        |\n" +
               "| 13. Assign Subjects to the Course        |\n" +
               "| 14. Show Subjects for the Teacher        |\n" +
               "| 15. Assign Subjects to the Teacher       |\n" +
               "| 16. Calculate Hours and Credits          |\n" +
               "| 17. Calculate Salary                     |\n" +
               "| 18. Exit.                                |"+"\u001B[0m";
        INVALID = "Invalid option. Try again.";
        NAME = "Enter the student's full name:";
        AGE = "Enter the student's age: ";
        TUITION = "Enter the student's tuition number: ";
        COURSENAME = "Enter the course name: ";
        SUCCESS = "Product added successfully.";
        ERROR = "Error adding the product:";
        NUMSUB = "How many subjects will the course have?";
        NUMNEED_M = "The course must have at least 3 subjects.";
        CREDITS = "Enter the number of credits: ";
        SUCCESS_COURSE = "The course was added successfully.";
        ERROR_COURSE = "Error adding the course.";
        NAME_PROFESSOR = "Enter the teacher's name:";
        SALARY_PROFESSOR = "Enter the teacher's base salary:";
        SUCCESS_PROFESSOR = "The teacher was added successfully.";
        ERROR_PROFESSOR = "Error adding the teacher.";
        COURSE_NOT_FOUND = "The course was not found. Please create the course first.";
        ASSIGN_ALREADY_PROFESSOR = "The teacher already has an assigned subject: ";
        STUDENT_NOT_FOUND = "The student has not been added yet. Please add them first.";
        ASSIGN_ALREADY_STUDENT = "The student has already been assigned to the course: ";
        COURSE_NOT_FOUND2 = "The course you entered was not found. Please check your request.";
        COURSE = "Course";
        STUDENT = "Student";
        PROFESSOR = "Teacher";
        SUBJECT = "Subject";
        CREDITS2 = "Credits";
        HOURS = "Hours";
        SALARY = "Salary";
        SUBJECTNAME = "Enter the subject name: ";
        CREDITS_M = "Enter the number of credits the subject is worth:";
        ID = "Enter the subject ID:";
        COURSE_TO_SUBJECT = "Enter the course where this subject will be assigned:";
        HOURS_M = "Enter the number of hours per week for this class:";
        ALREADY_SUBJECT = "The subject is already assigned to this course.";
        PROFESSOR_NOT_FOUND = "The teacher has not been added yet. Please add them first.";
        SUBJECT_NOT_FOUND = "The subject has not been added yet. Please add it first.";
        ADD_SALARY = "Enter the salary to calculate:";
        NUM_M = "Enter the number of subjects the student will take:";
    }
}

