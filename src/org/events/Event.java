package org.events;

import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private int totalPlaces;
    private int reservedSeats;

    public Event(String title, LocalDate date, int totalPlaces) {
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
}
