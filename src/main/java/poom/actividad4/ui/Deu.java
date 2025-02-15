package poom.actividad4.ui;


/**
 * Clase que representa la configuración de idioma en alemán.
 * Contiene constantes de texto utilizadas en la interfaz de usuario.
 */

public class Deu extends Lang {


    public Deu() {
        EXIT = "Auf Wiedersehen!";
        MENU = "\u001B[32m" +
               "|                   Menü:                  |\n" +
               "| 1. Schüler hinzufügen.                   |\n" +
               "| 2. Lehrer hinzufügen.                    |\n" +
               "| 3. Fach hinzufügen.                      |\n" +
               "| 4. Kurs hinzufügen.                      |\n" +
               "| 5. Schüler anzeigen                       |\n" +
               "| 6. Lehrer anzeigen                        |\n" +
               "| 7. Fächer anzeigen                        |\n" +
               "| 8. Kurse anzeigen                         |\n" +
               "| 9. Schüler im Kurs anzeigen               |\n" +
               "| 10. Lehrer im Kurs anzeigen               |\n" +
               "| 11. Lehrer dem Kurs zuweisen              |\n" +
               "| 12. Schüler dem Kurs zuweisen             |\n" +
               "| 13. Fächer dem Kurs zuweisen              |\n" +
               "| 14. Fächer des Lehrers anzeigen           |\n" +
               "| 15. Fächer dem Lehrer zuweisen            |\n" +
               "| 16. Stunden und Credits berechnen         |\n" +
               "| 17. Gehalt berechnen                      |\n" +
               "| 18. Beenden.                              |" +
               "\u001B[0m";
        INVALID = "Ungültige Option. Versuchen Sie es erneut.";
        NAME = "Geben Sie den vollständigen Namen des Schülers ein:";
        AGE = "Geben Sie das Alter des Schülers ein: ";
        TUITION = "Geben Sie die Matrikelnummer des Schülers ein: ";
        COURSENAME = "Geben Sie den Kursnamen ein: ";
        SUCCESS = "Produkt erfolgreich hinzugefügt.";
        ERROR = "Fehler beim Hinzufügen des Produkts:";
        NUMSUB = "Wie viele Fächer hat der Kurs?";
        NUMNEED_M = "Der Kurs muss mindestens 3 Fächer haben.";
        CREDITS = "Geben Sie die Anzahl der Credits ein: ";
        SUCCESS_COURSE = "Der Kurs wurde erfolgreich hinzugefügt.";
        ERROR_COURSE = "Fehler beim Hinzufügen des Kurses.";
        NAME_PROFESSOR = "Geben Sie den Namen des Lehrers ein:";
        SALARY_PROFESSOR = "Geben Sie das Grundgehalt des Lehrers ein:";
        SUCCESS_PROFESSOR = "Der Lehrer wurde erfolgreich hinzugefügt.";
        ERROR_PROFESSOR = "Fehler beim Hinzufügen des Lehrers.";
        COURSE_NOT_FOUND = "Der Kurs wurde nicht gefunden. Bitte erstellen Sie den Kurs zuerst.";
        ASSIGN_ALREADY_PROFESSOR = "Der Lehrer hat bereits ein zugewiesenes Fach: ";
        STUDENT_NOT_FOUND = "Der Schüler wurde noch nicht hinzugefügt. Bitte fügen Sie ihn zuerst hinzu.";
        ASSIGN_ALREADY_STUDENT = "Der Schüler wurde bereits diesem Kurs zugewiesen: ";
        COURSE_NOT_FOUND2 = "Der eingegebene Kurs wurde nicht gefunden. Bitte überprüfen Sie Ihre Eingabe.";
        COURSE = "Kurs";
        STUDENT = "Schüler";
        PROFESSOR = "Lehrer";
        SUBJECT = "Fach";
        CREDITS2 = "Credits";
        HOURS = "Stunden";
        SALARY = "Gehalt";
        SUBJECTNAME = "Geben Sie den Namen des Fachs ein: ";
        CREDITS_M = "Geben Sie die Anzahl der Credits für das Fach ein:";
        ID = "Geben Sie die ID des Fachs ein:";
        COURSE_TO_SUBJECT = "Geben Sie den Kurs ein, dem dieses Fach zugeordnet wird:";
        HOURS_M = "Geben Sie die Wochenstunden für dieses Fach ein:";
        ALREADY_SUBJECT = "Das Fach ist bereits diesem Kurs zugewiesen.";
        PROFESSOR_NOT_FOUND = "Der Lehrer wurde noch nicht hinzugefügt. Bitte fügen Sie ihn zuerst hinzu.";
        SUBJECT_NOT_FOUND = "Das Fach wurde noch nicht hinzugefügt. Bitte fügen Sie es zuerst hinzu.";
        ADD_SALARY = "Geben Sie das zu berechnende Gehalt ein:";
        NUM_M = "Geben Sie die Anzahl der Fächer ein, die der Schüler belegen wird:";
    }
}
