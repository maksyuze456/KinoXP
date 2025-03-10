package org.kinoxp.kinoxp.Controller;

import org.kinoxp.kinoxp.Entity.Booking;
import org.kinoxp.kinoxp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/booking")
@RestController
public class BookingController {
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
    public void deleteBookingById(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }

    // Det JSON der bliver sendt i dette POST request bliver parset til en Booking object som gemmes i databasen
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Map<String, String> body){
        Booking booking = new Booking();

        booking.setName(body.get("name"));
        booking.setLastName(body.get("lastName"));
        booking.setPhone(body.get("phone"));
        booking.setAmount(Integer.valueOf(body.get("amount")));

        Booking savedBooking = bookingRepository.save(booking);
        return new ResponseEntity<Booking>(savedBooking, HttpStatus.CREATED);
    }

    // Opdaterer eksisterende Booking i db. Request tager i mod opdateret JSON, som i metoden bruges til opdateringen af objektet
    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBookingById(@PathVariable Long id, @RequestBody Booking body){
        Optional<Booking> booking = bookingRepository.findById(id);

        if (booking.isPresent()) {
            Booking existingBooking = booking.get();

            existingBooking.setName(body.getName());
            existingBooking.setLastName(body.getLastName());
            existingBooking.setPhone(body.getPhone());

            Booking updatedBooking = bookingRepository.save(existingBooking);
            return new ResponseEntity<Booking>(updatedBooking, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
