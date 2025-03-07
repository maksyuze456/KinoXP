package org.kinoxp.kinoxp.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "genre")
    private String genre;


    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Film() {}

    public Film(String title, String description, int duration, String genre, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public int getFilmid() {
        return filmid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
