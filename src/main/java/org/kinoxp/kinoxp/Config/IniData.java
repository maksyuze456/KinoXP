package org.kinoxp.kinoxp.Config;

import org.kinoxp.kinoxp.Entity.Film;
import org.kinoxp.kinoxp.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class IniData implements CommandLineRunner {

    @Autowired
    FilmRepository filmRepository;

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


    }
}
