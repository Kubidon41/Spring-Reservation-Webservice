package me.Kubano3ak;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ReservationMockedData {
    //list of reservations post
    private List<Reservation> reservations;

    private static ReservationMockedData instance = null;

    public static ReservationMockedData getInstance() {
        if (instance == null) {
            instance = new ReservationMockedData();
        }
        return instance;
    }

    public ReservationMockedData() {
        reservations = new ArrayList<Reservation>();
        reservations.add(new Reservation(1, "Travis Scott",
                "Hello, I am Travis"));
        reservations.add(new Reservation(2, "Jordan Belford",
                "Buissnesman from Kalifornia" ));
        reservations.add(new Reservation(3, "Snoop Dog",
                "He really love green plants" ));
        reservations.add(new Reservation(4, "Tofis",
                "It's my dog" ));
        reservations.add(new Reservation(5, "Jakub Nowak",
                "Second year electrnics student the CEO of idontknowyet XD"));
    }

    //return all reservations
    public List<Reservation> fetchReservation() {
        return reservations;
    }

    //return reservation by id
    public Reservation getReservationById(int id) {
        for (Reservation b : reservations) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public Reservation createReservation(int id, String name, String description) {
        Reservation newReservation = new Reservation(id, name, description);
        reservations.add(newReservation);
        return newReservation;
    }


    public Reservation updateReservation(int id, String name, String description) {
        for (Reservation b : reservations) {
            if (b.getId() == id) {
                int reservationIndex = reservations.indexOf(b);
                b.setName(name);
                b.setDescription(description);
                reservations.set(reservationIndex, b);
                return b;
            }
        }
        return null;
    }

    // delete reservation by id
    public boolean deleteReservation(int id){
        int reservationIndex = -1;
        for(Reservation b: reservations) {
            if(b.getId() == id) {
                reservationIndex = reservations.indexOf(b);
                continue;
            }
        }
        if(reservationIndex > -1){
            reservations.remove(reservationIndex);
        }
        return true;
    }
}
