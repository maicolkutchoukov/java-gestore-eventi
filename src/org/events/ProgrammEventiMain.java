package org.events;

import java.time.LocalDate;
import java.util.List;

public class ProgrammEventiMain {
    public static void main(String[] args) {
        // Creazione di un programma eventi
        ProgrammEventi program = new ProgrammEventi("Programma Eventi");

        // Aggiunta di eventi al programma
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(19);
        LocalDate nextWeek = LocalDate.now().plusWeeks(1);

        Event event1 = new Event("Evento 1", today, 100);
        Event event2 = new Event("Evento 2", tomorrow, 150);
        Event event3 = new Event("Evento 3", nextWeek, 80);

        program.addEvent(event1);
        program.addEvent(event2);
        program.addEvent(event3);

        // Stampa del programma eventi
        System.out.println("Programma Eventi:");
        System.out.println(program);

        // Test del metodo eventOnDate
        LocalDate testDate = LocalDate.now().plusDays(1);
        List<Event> eventsOnTestDate = program.eventOnDate(testDate);
        System.out.println("Eventi presenti il " + testDate + ":");
        for (Event event : eventsOnTestDate) {
            System.out.println(event);
        }

        // Test del metodo numberEvents
        System.out.println("Numero totale di eventi nel programma: " + program.numberEvents());

        // Test del metodo clearEvents
        program.clearEvents();
        System.out.println("Numero di eventi dopo la cancellazione: " + program.numberEvents());
    }
}
