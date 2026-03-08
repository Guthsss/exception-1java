package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer duration() {
        return (int) ChronoUnit.DAYS.between(checkin, checkout);
    }

    public void updatesDates(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + fmt.format(checkin)
                + ", check-out: "
                + fmt.format(checkout)
                + ", "
                + duration()
                + " nights";
    }
}
