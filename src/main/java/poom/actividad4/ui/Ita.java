
package poom.actividad4.ui;

/**
 * La clase {@code Ita} extiende la clase {@code Lang} y proporciona mensajes en italiano
 * para la interfaz de usuario de la aplicación. Inicializa varios mensajes relacionados
 * con opciones del menú, solicitudes de entrada, errores y confirmaciones.
 */

public class Ita extends Lang {

  

    public Ita() {
        EXIT = "Arrivederci!";
        MENU = "\u001B[32m"+"|                   Menu:                  |\n" +
               "| 1. Aggiungi Studente.                     |\n" +
               "| 2. Aggiungi Insegnante.                   |\n" +
               "| 3. Aggiungi Materia.                      |\n" +
               "| 4. Aggiungi Corso.                        |\n" +
               "| 5. Mostra Studenti                        |\n" +
               "| 6. Mostra Insegnanti                      |\n" +
               "| 7. Mostra Materie                         |\n" +
               "| 8. Mostra Corsi                           |\n" +
               "| 9. Mostra Studenti nel Corso              |\n" +
               "| 10. Mostra Insegnanti nel Corso           |\n" +
               "| 11. Assegna Insegnanti al Corso           |\n" +
               "| 12. Assegna Studenti al Corso             |\n" +
               "| 13. Assegna Materie al Corso              |\n" +
               "| 14. Mostra Materie dell'Insegnante        |\n" +
               "| 15. Assegna Materie all'Insegnante        |\n" +
               "| 16. Calcola Ore e Crediti                 |\n" +
               "| 17. Calcola Stipendio                     |\n" +
               "| 18. Esci.                                 |"+"\u001B[0m";
        INVALID = "Opzione non valida. Riprova.";
        NAME = "Inserisci il nome completo dello studente:";
        AGE = "Inserisci l'età dello studente: ";
        TUITION = "Inserisci la matricola dello studente: ";
        COURSENAME = "Inserisci il nome del corso: ";
        SUCCESS = "Prodotto aggiunto con successo.";
        ERROR = "Errore nell'aggiunta del prodotto:";
        NUMSUB = "Quante materie avrà il corso?";
        NUMNEED_M = "Il corso deve avere almeno 3 materie.";
        CREDITS = "Inserisci il numero di crediti: ";
        SUCCESS_COURSE = "Il corso è stato aggiunto con successo.";
        ERROR_COURSE = "Errore nell'aggiunta del corso.";
        NAME_PROFESSOR = "Inserisci il nome dell'insegnante:";
        SALARY_PROFESSOR = "Inserisci lo stipendio base dell'insegnante:";
        SUCCESS_PROFESSOR = "L'insegnante è stato aggiunto con successo.";
        ERROR_PROFESSOR = "Errore nell'aggiunta dell'insegnante.";
        COURSE_NOT_FOUND = "Il corso non è stato trovato. Crealo prima, per favore.";
        ASSIGN_ALREADY_PROFESSOR = "L'insegnante ha già una materia assegnata: ";
        STUDENT_NOT_FOUND = "Lo studente non è stato ancora aggiunto. Aggiungilo, per favore.";
        ASSIGN_ALREADY_STUDENT = "Lo studente è già stato assegnato a questo corso: ";
        COURSE_NOT_FOUND2 = "Il corso inserito non è stato trovato. Controlla la tua richiesta.";
        COURSE = "Corso";
        STUDENT = "Studente";
        PROFESSOR = "Insegnante";
        SUBJECT = "Materia";
        CREDITS2 = "Crediti";
        HOURS = "Ore";
        SALARY = "Stipendio";
        SUBJECTNAME = "Inserisci il nome della materia: ";
        CREDITS_M = "Inserisci il numero di crediti della materia:";
        ID = "Inserisci l'ID della materia:";
        COURSE_TO_SUBJECT = "Inserisci il corso a cui sarà assegnata questa materia:";
        HOURS_M = "Inserisci le ore settimanali per questa materia:";
        ALREADY_SUBJECT = "La materia è già assegnata a questo corso.";
        PROFESSOR_NOT_FOUND = "L'insegnante non è stato ancora aggiunto. Aggiungilo, per favore.";
        SUBJECT_NOT_FOUND = "La materia non è stata ancora aggiunta. Aggiungila, per favore.";
        ADD_SALARY = "Inserisci lo stipendio da calcolare:";
        NUM_M = "Inserisci il numero di materie che lo studente seguirà:";
    }
}

