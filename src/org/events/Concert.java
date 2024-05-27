package org.events;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int totalPlaces, LocalTime time, BigDecimal price) throws IllegalArgumentException, IllegalStateException {
        super(title, date, totalPlaces);
        this.time = time;
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFormattedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDate().format(formatter);
    }

    public String getTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    public String getPriceFormatter(){
        DecimalFormat formatter = new DecimalFormat("0.00€");
        formatter.setRoundingMode(RoundingMode.UNNECESSARY);  // metodo per evitare l'arrotondamento
        return formatter.format(price);
    }

    @Override
    public String toString() {
        return getFormattedDate() + " " + getTimeFormatter() + " - " + getTitle() + " - " + getPriceFormatter();
    }
}
