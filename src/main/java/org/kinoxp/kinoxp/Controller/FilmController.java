package org.kinoxp.kinoxp.Controller;

import org.kinoxp.kinoxp.Entity.Film;
import org.kinoxp.kinoxp.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
@CrossOrigin(origins = "*")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

//
    @GetMapping("/all")
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }


    @GetMapping("/{filmid}")
    public ResponseEntity<Film> getFilmById(@PathVariable int filmid) {
        Optional<Film> film = filmRepository.findById(filmid);
        return film.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film savedFilm = filmRepository.save(film);
        return new ResponseEntity<>(savedFilm, HttpStatus.CREATED);
    }


    @PutMapping("/{filmid}")
    public ResponseEntity<Film> updateFilm(@PathVariable int filmid, @RequestBody Film updatedFilm) {
        Optional<Film> existingFilmOpt = filmRepository.findById(filmid);

        if (!existingFilmOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Film existingFilm = existingFilmOpt.get();


        existingFilm.setTitle(updatedFilm.getTitle());
        existingFilm.setDescription(updatedFilm.getDescription());
        existingFilm.setDuration(updatedFilm.getDuration());
        existingFilm.setGenre(updatedFilm.getGenre());
        existingFilm.setReleaseDate(updatedFilm.getReleaseDate());

        Film savedFilm = filmRepository.save(existingFilm);

        return ResponseEntity.ok(savedFilm);
    }


    @DeleteMapping("/delete/{filmid}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int filmid) {
        if (filmRepository.existsById(filmid)) {
            filmRepository.deleteById(filmid);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
