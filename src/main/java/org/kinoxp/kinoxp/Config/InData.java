package org.kinoxp.kinoxp.Config;

import org.kinoxp.kinoxp.Entity.Booking;
import org.kinoxp.kinoxp.Entity.Film;
import org.kinoxp.kinoxp.Entity.Show;
import org.kinoxp.kinoxp.Repository.BookingRepository;
import org.kinoxp.kinoxp.Repository.FilmRepository;
import org.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

@Component
public class InData implements CommandLineRunner {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {

        // 🎬 Opret film
        Film film1 = new Film("The Great Escape", "En spændende flugt fra fængslet.", 120, "Action", LocalDate.of(2021, 5, 10));
        Film film2 = new Film("Romance in Paris", "En romantisk historie i byernes by.", 95, "Romance", LocalDate.of(2022, 8, 14));
        Film film3 = new Film("Mystery Island", "En gruppe mennesker fanges på en mystisk ø.", 110, "Thriller", LocalDate.of(2023, 3, 22));

        filmRepository.save(film1);
        filmRepository.save(film2);
        filmRepository.save(film3);

        // 🎭 Opret forestillinger og knyt dem til film
        Show show1 = new Show(LocalDate.of(2025, 4, 15), LocalTime.of(19, 0), film1);
        Show show2 = new Show(LocalDate.of(2025, 6, 10), LocalTime.of(19, 30), film2);
        Show show3 = new Show(LocalDate.of(2025, 8, 20), LocalTime.of(20, 0), film3);
        Show show4 = new Show(LocalDate.of(2025, 10, 5), LocalTime.of(18, 45), film1);

        showRepository.save(show1);
        showRepository.save(show2);
        showRepository.save(show3);
        showRepository.save(show4);

       /* // 🎟️ Opret bookinger og knyt dem til shows
        Booking booking1 = new Booking("John", "Johnson", "24259570", 2, show1);
        Booking booking2 = new Booking("Brian", "Davis", "95349570", 1, show2);
        Booking booking3 = new Booking("Christian", "Scott", "34305701", 2, show3);
        Booking booking4 = new Booking("Emma", "Watson", "12345678", 3, show1);
        Booking booking5 = new Booking("Michael", "Jordan", "87654321", 4, show2);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);

        System.out.println("✅ Dummy data for Film, Shows og Bookings er oprettet!");
    }*/
    }
}
