package entities;

import entities.enums.RoomType;

public class Room {
    private Integer number;
    private RoomType type;

    public Room() {
    }

    public Room(Integer number, Integer typeNumber) {
        this.number = number;
        type = RoomType.defineRoomType(typeNumber);
    }



    public Integer getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }


}
