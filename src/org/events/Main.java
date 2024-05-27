package org.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il titolo dell'evento: ");
        String title = scanner.nextLine();
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (date == null) {
            System.out.print("Inserisci la data (dd/MM/yyyy): ");
            String dateInput = scanner.nextLine();
            try {
                date = LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprovare.");
            }
        }
        System.out.print("Inserisci la capienza della location (Totale posti prenotabili): ");
        int totalPlaces = Integer.parseInt(scanner.nextLine());
        Event event1 = new Event(title, date, totalPlaces);
        System.out.println(event1);
        System.out.print("Vuoi prenotare i posti per l'evento? (y/n)");
        String choice = scanner.nextLine();
        while (choice.equals("y")){
            System.out.print("Inserisci il numero di posti da prenotare: ");
            int bookSeats = Integer.parseInt(scanner.nextLine());
            event1.bookSeats(bookSeats);
            int avaiableSeats = event1.avaiableSeats();
            System.out.println("Posti prenotati:" + event1.getReservedSeats() + "posti disponibili: " + avaiableSeats);
            System.out.print("Vuoi disdire qualche prenotazione? (y/n) ");
            choice = scanner.nextLine();
            if (choice.equals("y")){
                System.out.print("Quanti posti desidere disdire? ");
                int p = Integer.parseInt(scanner.nextLine());
                event1.cancelSeats(p);
                choice = "n";
            }
            System.out.println("Posti prenotati: " + event1.getReservedSeats() + " posti disponibili: " + avaiableSeats);
            System.out.println("Bye bye");
        }


        scanner.close();
    }
}
