package org.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedSeats;

    public Event(String title, LocalDate date, int totalPlaces) throws IllegalArgumentException{
        dateValidation();
        checkSeats();
        this.title = title;
        this.date = date;
        this.totalPlaces = totalPlaces;
        reservedSeats = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }


    public int getReservedSeats() {
        return reservedSeats;
    }

    private void dateValidation() {
        LocalDate today = LocalDate.now();
        if (date.isBefore(today)) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }
    }

    private void checkSeats(){
        if (totalPlaces < 0){
            throw new IllegalArgumentException("I posti non possono essere negativi.");
        }
    }

    public void bookSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Il numero di posti da prenotare deve essere almeno 1.");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato.");
        }
        if (reservedSeats + numberOfSeats > totalPlaces) {
            throw new IllegalStateException("Non ci sono abbastanza posti disponibili.");
        }
        reservedSeats += numberOfSeats;
    }

    public void cancelSeats(int numberOfSeats){
        if (numberOfSeats < 0){
            throw new IllegalArgumentException("Il numero di posti da cancellare deve essere almeno 1.");
        }
        if (date.isBefore(LocalDate.now())){
            throw new IllegalStateException("L'evento è già passato.");
        }
        if(numberOfSeats > reservedSeats){
            throw new IllegalArgumentException("Non ci sono abbastanza posti prenotati");
        }

        reservedSeats -= numberOfSeats;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        return date.format(formatter) + " - " + title;
    }
}
