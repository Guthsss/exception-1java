package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Reservation reservation = null;

        System.out.print("Room Number: ");
        int roomNumber = input.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkin = LocalDate.parse(input.next(), fmt());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkout = LocalDate.parse(input.next(), fmt());

        if (!checkout.isAfter(checkin)) {
            System.out.println("Error in a reservation: check-out date must be after check-in date");
        } else {
            reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter a data to update a reservation");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(input.next(), fmt());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(input.next(), fmt());

            String error = reservation.updatesDates(checkin, checkout);
            if (error != null) {
                System.out.println("Error in a reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }
        }
    }

    private static DateTimeFormatter fmt() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
