package org.kinoxp.kinoxp.Config;

import org.kinoxp.kinoxp.Entity.Film;
import org.kinoxp.kinoxp.Entity.Show;
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
public class IniData implements CommandLineRunner {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ShowRepository showRepository;


    @Override
    public void run(String... args) throws Exception {
        ArrayList<Show> showList = new ArrayList<>();
        // Oprindelige dummydata
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

        // Ekstra dummydata med kendte, moderne film (udkommet sidste måned)
        Film film4 = new Film();
        film4.setTitle("Black Panther: Wakanda Forever");
        film4.setDescription("En hyldest til Wakanda med en fortsættelse af den populære franchise.");
        film4.setDuration(162);
        film4.setGenre("Action/Adventure");
        film4.setReleaseDate(LocalDate.of(2025, 2, 25)); // Sidste måneds udgivelse

        Film film5 = new Film();
        film5.setTitle("Avatar: The Way of Water");
        film5.setDescription("En visuel spektakulær rejse under havets overflade.");
        film5.setDuration(192);
        film5.setGenre("Science Fiction/Adventure");
        film5.setReleaseDate(LocalDate.of(2025, 2, 20)); // Sidste måneds udgivelse

        Film film6 = new Film();
        film6.setTitle("Spider-Man: Across the Multiverse");
        film6.setDescription("Spider-Man udforsker nye dimensioner i en episk multiverse-rejse.");
        film6.setDuration(140);
        film6.setGenre("Action/Adventure");
        film6.setReleaseDate(LocalDate.of(2025, 2, 18)); // Sidste måneds udgivelse

        Film film7 = new Film();
        film7.setTitle("Guardians of the Galaxy: Cosmic Quest");
        film7.setDescription("Et nyt eventyr med Guardians, der udforsker universets mysterier.");
        film7.setDuration(130);
        film7.setGenre("Science Fiction/Adventure");
        film7.setReleaseDate(LocalDate.of(2025, 2, 22)); // Sidste måneds udgivelse

        Film film8 = new Film();
        film8.setTitle("Fast & Furious 10");
        film8.setDescription("Hurtige biler og intense actionsekvenser i den tiende udgave.");
        film8.setDuration(135);
        film8.setGenre("Action");
        film8.setReleaseDate(LocalDate.of(2025, 2, 15)); // Sidste måneds udgivelse

        Film film9 = new Film();
        film9.setTitle("Jurassic World: Dominion 2");
        film9.setDescription("Dinosaurerne er tilbage i en ny og spændende eventyrfortælling.");
        film9.setDuration(150);
        film9.setGenre("Science Fiction/Adventure");
        film9.setReleaseDate(LocalDate.of(2025, 2, 28)); // Sidste måneds udgivelse

        filmRepository.save(film1);
        filmRepository.save(film2);
        filmRepository.save(film3);
        filmRepository.save(film4);
        filmRepository.save(film5);
        filmRepository.save(film6);
        filmRepository.save(film7);
        filmRepository.save(film8);
        filmRepository.save(film9);

        Collections.addAll(showList,
                new Show(LocalDate.of(2025, 4, 15), LocalTime.of(19, 0)),
                new Show(LocalDate.of(2025, 6, 10), LocalTime.of(19, 30)),
                new Show(LocalDate.of(2025, 8, 20), LocalTime.of(20, 0)),
                new Show(LocalDate.of(2025, 10, 5), LocalTime.of(18, 45))
        );

        showRepository.saveAll(showList);
        System.out.println("Testdata for shows er indsat!");
    }
}
