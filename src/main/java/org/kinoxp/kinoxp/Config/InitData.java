/*package org.kinoxp.kinoxp.Config;

import org.kinoxp.kinoxp.Entity.Show;
import org.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    ShowRepository showRepository;

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Show> showList = new ArrayList<>();
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

*/