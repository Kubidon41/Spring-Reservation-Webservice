package me.Kubano3ak;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class ReservationController {

    private ReservationMockedData reservationMockedData = ReservationMockedData.getInstance();

    @GetMapping("/reservation")
    public List<Reservation> index() {
        return reservationMockedData.fetchReservation();
    }

    @GetMapping("/reservation/{id}")
    public Reservation show(@PathVariable String id) {
        int reservationId = Integer.parseInt(id);
        return reservationMockedData.getReservationById(reservationId);
    }

    @PostMapping("/reservation")
    public Reservation create(@RequestBody Map<String,String> body) {
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String description = body.get("description");
        return reservationMockedData.createReservation(id,name,description);
    }

    @PutMapping("/reservation/{id}")
    public Reservation update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int reservationId = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String description = body.get("description");
        return reservationMockedData.updateReservation(reservationId,name,description);
    }

    @DeleteMapping("/reservation/{id}")
    public boolean delete(@PathVariable String id) {
        int reservationId = Integer.parseInt(id);
        return reservationMockedData.deleteReservation(reservationId);
    }
}