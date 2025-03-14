package org.kinoxp.kinoxp.Controller;

import org.kinoxp.kinoxp.Entity.Film;
import org.kinoxp.kinoxp.Entity.Show;
import org.kinoxp.kinoxp.Repository.FilmRepository;
import org.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("allshows")
@CrossOrigin(origins = "*")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/allshowsData")
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @GetMapping("/{showID}")
    public ResponseEntity<Show> getById(@PathVariable int showID) {
        return showRepository.findById(showID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        if (show.getFilm() == null || show.getFilm().getFilmid() == 0) {
            return ResponseEntity.badRequest().body(null); // Hvis film mangler, returnér 400
        }

        // Hent filmen fra databasen
        Film film = filmRepository.findById(show.getFilm().getFilmid())
                .orElseThrow(() -> new RuntimeException("Film ikke fundet"));

        // Sørg for at dato og tid ikke er null
        if (show.getDate() == null || show.getTime() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        show.setFilm(film); // Knyt filmen til showet
        Show savedShow = showRepository.save(show);

        return new ResponseEntity<>(savedShow, HttpStatus.CREATED);
    }

   /* @PostMapping("/add")
    public ResponseEntity<Show> createShow(@RequestBody Map<String, String> payload) {
        LocalDate date = LocalDate.parse(payload.get("date"));
        LocalTime time = LocalTime.parse(payload.get("time"));
        int filmid = Integer.parseInt(payload.get("film"));
        Film film = filmRepository.findById(filmid)
                .orElseThrow(()-> new RuntimeException("Film ikke fundet"));


        Show show = new Show(date,time);
        show.setFilm(film);

        Show savedShow = showRepository.save(show);
        return new ResponseEntity<>(savedShow, HttpStatus.CREATED);
    }*/


    @PutMapping("/update/{showID}")
    public ResponseEntity<Show> updateShow ( @PathVariable int showID, @RequestBody Show updatedShow){
        return showRepository.findById(showID).map(existingShow -> {
            existingShow.setDate(updatedShow.getDate());
            existingShow.setTime(updatedShow.getTime());
            Show savedShow = showRepository.save(existingShow);
            return ResponseEntity.ok(savedShow);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{showID}")
    public ResponseEntity<Void> deleteShow ( @PathVariable int showID){
        if (showRepository.existsById(showID)) {
            showRepository.deleteById(showID);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

