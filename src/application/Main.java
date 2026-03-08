package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Reservation reservation = null;

        try {
            System.out.print("Room Number: ");
            int roomNumber = input.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkin = LocalDate.parse(input.next(), fmt());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkout = LocalDate.parse(input.next(), fmt());

            reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter a data to update a reservation");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(input.next(), fmt());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(input.next(), fmt());

            reservation.updatesDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        } catch (DomainException e) {
            System.out.println("Error in a reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        input.close();
    }

    private static DateTimeFormatter fmt() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
