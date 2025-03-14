package org.kinoxp.kinoxp.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showID;

    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "filmid", referencedColumnName = "filmid")
    private Film film;


    public Show(LocalDate date, LocalTime time, Film film) {
        this.date = date;
        this.time = time;
        this.film = film;
    }


    public Show() {}

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
