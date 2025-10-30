package entities;

import entities.enums.RoomType;

public class Room {
    private Integer number;
    private RoomType type;

    public Room() {
    }

    public Room(Integer number, RoomType type) {
        this.number = number;
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }


}
