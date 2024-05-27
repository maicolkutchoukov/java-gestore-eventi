package org.events;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = null;
        LocalDate date = null;
        int totalPlaces = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Inserisci il titolo dell'evento: ");
                title = scanner.nextLine();

                System.out.print("Inserisci la data (dd/MM/yyyy): ");
                String dateInput = scanner.nextLine();
                date = LocalDate.parse(dateInput, formatter);

                System.out.print("Inserisci la capienza della location (Totale posti prenotabili): ");
                totalPlaces = Integer.parseInt(scanner.nextLine());

                break;
            } catch (DateTimeException e){
                System.out.println("Formato data non valido.");
            } catch (NumberFormatException e){
                System.out.println("Capienza non valida.");
            }
        }
        Event event1 = new Event(title, date, totalPlaces);
        System.out.println(event1);
        System.out.print("Vuoi prenotare i posti per l'evento? (y/n) ");
        String choice = scanner.nextLine();
        while (choice.equals("y")) {
            System.out.print("Inserisci il numero di posti da prenotare: ");
            int bookSeats = Integer.parseInt(scanner.nextLine());
            event1.bookSeats(bookSeats);
            int avaiableSeats = event1.avaiableSeats();
            System.out.println("Posti prenotati: " + event1.getReservedSeats() + " posti disponibili: " + avaiableSeats);
            System.out.print("Vuoi disdire qualche prenotazione? (y/n) ");
            choice = scanner.nextLine();
            if (choice.equals("y")) {
                while (true) {
                    System.out.print("Quanti posti desideri disdire? ");
                    int p = Integer.parseInt(scanner.nextLine());
                    try {
                        event1.cancelSeats(p);
                        choice = "n";
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println("Posti prenotati: " + event1.getReservedSeats() + " posti disponibili: " + event1.avaiableSeats());
            System.out.println("Bye bye");
        }


        scanner.close();
    }
}
