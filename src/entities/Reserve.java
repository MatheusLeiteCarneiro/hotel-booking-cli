package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserve {
    private final int checkInHour = 14;
    private final int checkOutHour = 12;
    private final int checkInAndCheckOutMinutes = 0;

    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer addedPeople;


    public Reserve() {
    }

    public Reserve(Guest guest) {
        this.guest = guest;

    }


    public Guest getGuest() {
        return guest;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getCheckInHour() {
        return checkInHour;
    }

    public int getCheckOutHour() {
        return checkOutHour;
    }

    public int getCheckInAndCheckOutMinutes() {
        return checkInAndCheckOutMinutes;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Integer getAddedPeople() {
        return addedPeople;
    }

    public void setAddedPeople(Integer addedPeople) {
        this.addedPeople = addedPeople;
    }

    public boolean verifyCheckIn(LocalDate checkIn) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (checkIn.isBefore(LocalDate.now())) {
            System.out.println("You can't enter a date before: " + LocalDate.now().format(formatter));
            System.out.print("Type a new date (DD/MM/YYYY):");
            return false;
        }
        checkInDate = checkIn;
        return true;
    }

    public boolean verifyCheckOut(LocalDate checkOut) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (checkInDate.isBefore(checkOut)) {
            checkOutDate = checkOut;
            return true;
        }
        System.out.println("You can only enter a date after the checkIn at: " + checkInDate.format(formatter));
        System.out.print("Type a new date (DD/MM/YYYY):");
        return false;

    }

    public int getNights() {
        return (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }


    public double totalValue() {
        double total = getNights() * room.getType().finalDailyPrice(addedPeople);
        return total;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room type: " + room.getType().getName() + "\n");
        stringBuilder.append("Room number: " + room.getNumber() + "\n");
        if (addedPeople > 0) {
            stringBuilder.append("Added person(s): " + addedPeople + "\n");
        } else {
            stringBuilder.append("No aditional person\n");
        }
        stringBuilder.append("Night(s): " + getNights() + "\n");
        stringBuilder.append("CheckIn date and time: " + checkInDate.atTime(checkInHour, checkInAndCheckOutMinutes).format(formatter) + "\n");
        stringBuilder.append("CheckOut date and time: " + checkOutDate.atTime(checkOutHour, checkInAndCheckOutMinutes).format(formatter) + "\n");
        stringBuilder.append("Price: $" + String.format("%.2f", totalValue()) + "\n");


        return stringBuilder.toString();

    }
}
