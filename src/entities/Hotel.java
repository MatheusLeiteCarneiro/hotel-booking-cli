package entities;

import entities.enums.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reserve> reserves = new ArrayList<>();

    public Hotel() {
        loadRooms();
    }

    public void loadRooms() {
        for (int i = 0; i <= 5; i++) {
            rooms.add(new Room((100 + i), 1));
        }
        for (int i = 0; i <= 5; i++) {
            rooms.add(new Room((200 + i), 2));
        }
        for (int i = 0; i <= 5; i++) {
            rooms.add(new Room((300 + i), 3));
        }

    }

    public void addReserve(Reserve newReserve) {
        reserves.add(newReserve);
    }

    public void removeReserve(Reserve newReserve) {
        reserves.remove(newReserve);
    }

    public List<Integer> availableRoomList(LocalDate checkIn, LocalDate checkOut, int roomTypeIndex) {
        List<Integer> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            boolean isAvailable = true;
            if (room.getType() == RoomType.defineRoomType(roomTypeIndex)) {
                for (Reserve reserve : reserves) {
                    if (reserve.getRoom().getNumber() == room.getNumber()) {
                        boolean noConflict = (checkOut.isBefore(reserve.getCheckInDate()) || checkIn.isAfter(reserve.getCheckOutDate()));

                        if (!noConflict) {
                            isAvailable = false;
                            break;
                        }
                    }
                }
            } else {
                isAvailable = false;

            }
            if (isAvailable) {
                availableRooms.add(room.getNumber());
            }
        }
        return availableRooms;
    }

    public boolean verifyIfRoomIsAvailable(int chosenRoom, List<Integer> roomList) {
        return roomList.contains(chosenRoom);
    }


    public double totalPayment() {
        double sum = 0.0;
        for (Reserve r : reserves) {
            sum += r.totalValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (reserves.isEmpty()) {
            stringBuilder.append("No reservations were made");
        } else {
            stringBuilder.append("Guest information-" + reserves.getFirst().getGuest() + "\n");
            for (Reserve reserve : reserves) {
                stringBuilder.append("Reserve #" + (reserves.indexOf(reserve) + 1) + "\n");
                stringBuilder.append(reserve + "\n");
            }
            stringBuilder.append("Total price: $" + String.format("%.2f", totalPayment()));
        }
        return stringBuilder.toString();
    }
}
