package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Reserve {
    private Guest guest;
    private  Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer addedPeople;


    public Reserve() {
    }

    public Reserve(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public Reserve(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate,int addedPeople) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.addedPeople = addedPeople;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkInDate.atTime(14, 00);
    }



    public LocalDateTime getCheckOutDateTime() {
        return checkOutDate.atTime(12, 00);
    }




    public double totalValue(){
        int days = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double total = days * room.getType().finalDailyPrice(addedPeople);
        return total;
    }
}
