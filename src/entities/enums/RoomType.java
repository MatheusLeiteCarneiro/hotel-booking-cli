package entities.enums;

public enum RoomType {
    STANDARD("Standard", 250.0, 2, 50.0, 3),
    FAMILY("Family", 400.0, 3, 75.0, 5),
    DELUXE("Deluxe", 600.0, 2, 150.0, 4);

    private final String name;
    private final Double pricePerNight;
    private final  Integer peoplePerRoom;
    private final Double extraCostPerPerson;
    private final Integer maxPeoplePerRoom;

    RoomType(String name, double pricePerNight, int peoplePerRoom, double extraCostPerPerson, int maxPeoplePerRoom) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.peoplePerRoom = peoplePerRoom;
        this.extraCostPerPerson = extraCostPerPerson;
        this.maxPeoplePerRoom = maxPeoplePerRoom;
    }

    public static RoomType defineRoomType(int typeNumber) {

        switch (typeNumber) {
            case 1:
                return RoomType.STANDARD;
            case 2:
                return RoomType.FAMILY;
            case 3:
                return RoomType.DELUXE;
            default:
                return null;
        }


    }

    public String getName() {
        return name;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Integer getPeoplePerRoom() {
        return peoplePerRoom;
    }

    public Double getExtraCostPerPerson() {
        return extraCostPerPerson;
    }

    public Integer getMaxPeoplePerRoom() {
        return maxPeoplePerRoom;
    }

    public boolean verifyAddedPeople(int addedPeople){
        if(addedPeople > (maxPeoplePerRoom - peoplePerRoom) || addedPeople < 0){
            return false;
        }
        return true;
    }

    public double finalDailyPrice(int addedPeople){
        return pricePerNight + (addedPeople * extraCostPerPerson) ;
    }

    @Override
    public String toString() {
        return "($" + String.format("%.2f",pricePerNight) + " per night for " + peoplePerRoom + " | +$" + String.format("%.2f",extraCostPerPerson) + " per extra person | Max occupancy " + maxPeoplePerRoom + ")\n";
    }
}
