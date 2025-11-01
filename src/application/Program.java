package application;

import entities.Guest;
import entities.Hotel;
import entities.Reserve;
import entities.Room;
import entities.enums.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int peopleToAdd = 0;

        System.out.println("Welcome to our Hotel, Let's book a room for you.");
        System.out.println("Type guest information:");
        System.out.print("Full name: ");
        String guestName = sc.nextLine();
        System.out.print("Email: ");
        String guestEmail = sc.nextLine();
        System.out.println();
        Guest guest = new Guest(guestName, guestEmail);
        int yesOrNo = 1;
        while (yesOrNo != 0) {
            Reserve reserve = new Reserve(guest);
            System.out.println("Now choose what type of room you want:\nType:");
            System.out.print("1- Standard Room " + RoomType.STANDARD);
            System.out.print("2- Family Room " + RoomType.FAMILY);
            System.out.print("3- Deluxe Room " + RoomType.DELUXE);
            int roomTypeNumber = sc.nextInt();
            while (RoomType.defineRoomType(roomTypeNumber) == null) {
                System.out.print("Invalid room type, digit(1, 2 or 3):");
                roomTypeNumber = sc.nextInt();
            }
            System.out.print("You chose the option: " + RoomType.defineRoomType(roomTypeNumber));
            System.out.println("Do you want to add another person to the room?");
            System.out.print("(Type: 1-for yes 0-for no): ");
            yesOrNo = sc.nextInt();
            while (!verifyYesOrNo(yesOrNo)) {
                yesOrNo = sc.nextInt();
            }
            if (yesOrNo == 1) {
                System.out.print("Type how many people you want to add: ");
                peopleToAdd = sc.nextInt();
                Integer verifyRoomCapacity = RoomType.defineRoomType(roomTypeNumber).verifyAddedPeople(peopleToAdd);
                while (verifyRoomCapacity != null) {
                    if (peopleToAdd < 0) {
                        System.out.print("Invalid number, type again: ");
                        peopleToAdd = sc.nextInt();
                    } else {
                        System.out.println("You exceeded the limit of the room you can add " + verifyRoomCapacity + " person(s)");
                        System.out.print("Type again: ");
                        peopleToAdd = sc.nextInt();
                    }
                    verifyRoomCapacity = RoomType.defineRoomType(roomTypeNumber).verifyAddedPeople(peopleToAdd);
                }
            }
            reserve.setAddedPeople(peopleToAdd);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("\nNow choose the checkIn date (DD/MM/YYYY): ");
            LocalDate checkInDate = LocalDate.parse(sc.next(), formatter);
            while (!reserve.verifyCheckIn(checkInDate)) {
                checkInDate = LocalDate.parse(sc.next(), formatter);
            }
            reserve.setCheckInDate(checkInDate);
            System.out.print("\nNow choose the checkOut date (DD/MM/YYYY): ");
            LocalDate checkOutDate = LocalDate.parse(sc.next(), formatter);
            while (!reserve.verifyCheckOut(checkOutDate)) {
                checkOutDate = LocalDate.parse(sc.next(), formatter);
            }
            reserve.setCheckOutDate(checkOutDate);


            System.out.println("\nAvailable " + RoomType.defineRoomType(roomTypeNumber).getName() + " rooms on this period:");
            List<Integer> availableRooomsNumberList = hotel.availableRoomList(checkInDate, checkOutDate, roomTypeNumber);
            if (availableRooomsNumberList.isEmpty()) {
                System.out.println("There's no available room to this date");

            } else {
                System.out.print("|");
                for (int roomsNumber : availableRooomsNumberList) {
                    System.out.print(roomsNumber + "|");
                }
            }
            System.out.print("\nType the number of the room you want to book: ");
            int roomNumber = sc.nextInt();
            while (!hotel.verifyIfRoomIsAvailable(roomNumber, availableRooomsNumberList)) {
                System.out.print("This is not a valid room, type another room number: ");
                roomNumber = sc.nextInt();
            }
            reserve.setRoom(new Room(roomNumber, roomTypeNumber));

            System.out.printf("%nThe total price is: $%.2f%n", reserve.totalValue());
            System.out.println("Do you want to confirm the reserve?");
            System.out.print("(Type 1-to confirm 0-to cancel): ");

            yesOrNo = sc.nextInt();
            while (!verifyYesOrNo(yesOrNo)) {
                yesOrNo = sc.nextInt();
            }
            if (yesOrNo == 1) {
                hotel.addReserve(reserve);
                System.out.println("\nYour room was succesfully booked!");
            } else {
                System.out.println("\nReserve canceled!");
            }

            System.out.println("\nWould you like to make another reserve?");
            System.out.print("(Type: 1-for yes 0-for no): ");
            yesOrNo = sc.nextInt();
            while (!verifyYesOrNo(yesOrNo)) {
                yesOrNo = sc.nextInt();
            }
            System.out.println();
        }
        System.out.println("Final data:\n");
        System.out.println(hotel);
        System.out.println("\nThank you for choosing our Hotel!");


        sc.close();


    }

    public static boolean verifyYesOrNo(int response) {
        if (response == 0 || response == 1) {
            return true;
        }
        System.out.print("Inavlid digit, type another time: ");
        return false;
    }


}
