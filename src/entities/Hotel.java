package entities;

import entities.enums.RoomType;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reserve> reserves = new ArrayList<>();

    public Hotel() {
        loadRooms();
    }
    public void loadRooms(){
        for (int i = 0; i <= 10; i++){
            rooms.add(new Room((100+i), RoomType.STANDART));
        }
        for (int i = 0; i <= 10; i++){
            rooms.add(new Room((200+i), RoomType.FAMILY));
        }
        for (int i = 0; i <= 10; i++){
            rooms.add(new Room((300+i), RoomType.DELUXE));
        }

    }
    public void addReserve(Reserve newReserve){
        reserves.add(newReserve);
    }

    public void removeReserve(Reserve newReserve){
        reserves.remove(newReserve);
    }


}
