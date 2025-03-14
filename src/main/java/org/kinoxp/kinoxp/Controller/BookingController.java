package org.kinoxp.kinoxp.Controller;

import org.kinoxp.kinoxp.Entity.Booking;
import org.kinoxp.kinoxp.Entity.Show;
import org.kinoxp.kinoxp.Repository.BookingRepository;
import org.kinoxp.kinoxp.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/booking")
@RestController
public class BookingController {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    BookingRepository bookingRepository;

    // Alle bookings
    @GetMapping("/")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    // Get metode for booking efter id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable Long id) {
        return new ResponseEntity<Optional<Booking>>(bookingRepository.findById(id), HttpStatus.OK);
    }

    // Slet booking efter Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBookingById(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity<Booking>(HttpStatus.valueOf(204));
    }

    // Det JSON der bliver sendt i dette POST request bliver parset til en Booking object som gemmes i databasen
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking body){
        Booking booking = new Booking();

        booking.setName(body.getName());
        booking.setLastName(body.getLastName());
        booking.setPhone(body.getPhone());
        booking.setAmount(body.getAmount());

        Booking savedBooking = bookingRepository.save(booking);
        return new ResponseEntity<Booking>(savedBooking, HttpStatus.CREATED);
    }

    // Opdaterer eksisterende Booking i db. Request tager i mod opdateret JSON, som i metoden bruges til opdateringen af objektet
    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBookingById(@PathVariable Long id, @RequestBody Booking body){
        Optional<Booking> booking = bookingRepository.findById(id);
        int showId = body.getShow().getShowID();
        Optional<Show> show = showRepository.findById(showId);
        if (booking.isPresent() && show.isPresent()) {
            Booking existingBooking = booking.get();
            Show existingShow = show.get();

            existingBooking.setName(body.getName());
            existingBooking.setLastName(body.getLastName());
            existingBooking.setPhone(body.getPhone());
            existingBooking.setAmount(body.getAmount());

            existingBooking.setShow(existingShow);




            Booking updatedBooking = bookingRepository.save(existingBooking);
            return new ResponseEntity<Booking>(updatedBooking, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
