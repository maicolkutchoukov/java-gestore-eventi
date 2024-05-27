package org.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEventi {
    private String title;
    private List<Event> events;

    public ProgrammEventi(String title){
        this.title = title;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public List<Event> eventOnDate(LocalDate date){
        List<Event> eventOnDate = new ArrayList<>();
        for (Event event : events){
            if (event.getDate().isEqual(date)){
                eventOnDate.add(event);
            }
        }
        return eventOnDate;
    }

    public int numberEvents(){
        return events.size();
    }

    public void clearEvents(){
        events.clear();
    }

    public String toString() {
        String result = "Titolo del programma: " + title + "\n";
        Collections.sort(events, (e1, e2) -> e1.getDate().compareTo(e2.getDate()));
        for (Event event : events) {
            result += event.getDate() + " - " + event.getTitle() + "\n";
        }
        return result;
    }

}
