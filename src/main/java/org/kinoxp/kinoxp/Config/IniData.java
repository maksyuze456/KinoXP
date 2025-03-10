package org.kinoxp.kinoxp.Config;

import org.kinoxp.kinoxp.Entity.Booking;
import org.kinoxp.kinoxp.Entity.Film;
import org.kinoxp.kinoxp.Repository.BookingRepository;
import org.kinoxp.kinoxp.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class IniData implements CommandLineRunner {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
        Film film1 = new Film();
        film1.setTitle("The Great Escape");
        film1.setDescription("En spændende flugt fra fængslet.");
        film1.setDuration(120);
        film1.setGenre("Action");
        film1.setReleaseDate(LocalDate.of(2021, 5, 10));

        Film film2 = new Film();
        film2.setTitle("Romance in Paris");
        film2.setDescription("En romantisk historie i byernes by.");
        film2.setDuration(95);
        film2.setGenre("Romance");
        film2.setReleaseDate(LocalDate.of(2022, 8, 14));

        Film film3 = new Film();
        film3.setTitle("Mystery Island");
        film3.setDescription("En gruppe mennesker fanges på en mystisk ø.");
        film3.setDuration(110);
        film3.setGenre("Thriller");
        film3.setReleaseDate(LocalDate.of(2023, 3, 22));

        filmRepository.save(film1);
        filmRepository.save(film2);
        filmRepository.save(film3);

        // InitData for Booking

        Booking booking1 = new Booking();
        booking1.setName("John");
        booking1.setLastName("Johnson");
        booking1.setPhone("24259570");
        booking1.setAmount(2);
        booking1.setShow(null);

        Booking booking2 = new Booking();
        booking2.setName("Brian");
        booking2.setLastName("Davis");
        booking2.setPhone("95349570");
        booking2.setAmount(1);
        booking2.setShow(null);

        Booking booking3 = new Booking();
        booking3.setName("Christian");
        booking3.setLastName("Scott");
        booking3.setPhone("34305701");
        booking3.setAmount(2);
        booking3.setShow(null);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);

    }
}
