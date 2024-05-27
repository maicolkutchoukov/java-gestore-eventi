package org.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedSeats;

    public Event(String title, LocalDate date, int totalPlaces) throws IllegalArgumentException, IllegalStateException{
        this.title = title;
        this.date = date;
        this.totalPlaces = totalPlaces;
        reservedSeats = 0;
        dateValidation();
        checkSeats();
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
        dateValidation();
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }


    public int getReservedSeats() {
        return reservedSeats;
    }

    private void dateValidation() throws IllegalArgumentException{
        LocalDate today = LocalDate.now();
        if (date.isBefore(today)) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }
    }

    private void checkSeats() throws IllegalArgumentException{
        if (totalPlaces < 0){
            throw new IllegalArgumentException("I posti non possono essere negativi.");
        }
    }

    public void bookSeats(int numberOfSeats) throws IllegalArgumentException, IllegalStateException{
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

    public void cancelSeats(int numberOfSeats) throws IllegalStateException, IllegalArgumentException{
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

    public int avaiableSeats(){
        int avaiable = totalPlaces - reservedSeats;
        return avaiable;

    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter) + " - " + title;
    }
}
