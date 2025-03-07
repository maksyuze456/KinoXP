package org.kinoxp.kinoxp.Controller;

import org.kinoxp.kinoxp.Entity.Show;
import org.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/show")
@CrossOrigin(origins = "http://localhost:8080")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;

    @GetMapping
    public List<Show> getAll(){
        return showRepository.findAll();
    }

    @GetMapping("/{showID}")
    public Optional<Show> getOne(@PathVariable int showID) {
        return showRepository.findById(showID);
    }

    @PostMapping
    public Show create(@RequestBody Show show){
        return showRepository.save(show);
    }

    @PutMapping("/{showID}")
    @Transactional
    public Show update(@PathVariable int showID, @RequestBody Show updatedShow) {
        return showRepository.findById(showID).map(f -> {
            f.setDate(updatedShow.getDate());
            f.setTime(updatedShow.getTime());
            return showRepository.save(f);
        }).orElseGet(() -> {
            updatedShow.setShowID(showID);
            return showRepository.save(updatedShow);
        });
    }

    @DeleteMapping("/{showID}")
    public void delete(@PathVariable int showID){
        showRepository.deleteById(showID);
    }
}
