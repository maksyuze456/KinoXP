package org.kinoxp.kinoxp.Controller;
import org.kinoxp.kinoxp.Entity.Show;
import org.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/show")
@CrossOrigin(origins = "http://localhost:8080") // Tilader anmodninger fra frontend
public class ShowController {

    @Autowired
    private ShowRepository ShowRepository;

    //Get henter alle forestillinger
    @GetMapping
    public List<Show> getAll(){
        return ShowRepository.findAll();
    }

    //Hent en bestemt forestilling udfra ID
    @GetMapping("/{ShowID}")
    public Optional<Show> getOne(@PathVariable int ShowID) {
        return ShowRepository.findById(ShowID);

    }

    //post- opret en ny forestilling
    @PostMapping
    public Show create (@RequestBody Show show){
        return ShowRepository.save(show);
    }
    //put- opdater en eksisterende forestilling
    @PutMapping("/{ShowID}")
    public Show update(@PathVariable int ShowID, @RequestBody Show updatedShow) {
        return ShowRepository.findById(ShowID).map(f -> {
            f.setDate(updatedShow.getDate());
            f.setTime(updatedShow.getTime());
            return ShowRepository.save(f);
        }).orElseGet(() -> {
            updatedShow.setShowID(ShowID);
            return ShowRepository.save(updatedShow);
        });
    }
    //delete slet en forestilling
    @DeleteMapping("/{forestillingId}")
    public void delete(@PathVariable int forestillingId){
        ShowRepository.deleteById(forestillingId);
    }
}



