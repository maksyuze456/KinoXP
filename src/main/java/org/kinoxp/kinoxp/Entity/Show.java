package org.kinoxp.kinoxp.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table (name="Shows")
public class Show {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int showID;

    private LocalDate date;

    private LocalTime time;

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings;
    public Show(LocalDate localDate, LocalTime localTime){}
    public Show(int showID, LocalDate date, LocalTime time) {
        this.showID = showID;
        this.date = date;
        this.time = time;
    }

    public Show() {

    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int forestillingID) {
        this.showID = forestillingID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate dato) {
        this.date = dato;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime tid) {
        this.time = tid;
    }
}


