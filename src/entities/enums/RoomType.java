package entities.enums;

public enum RoomType {
    STANDARD(250.0,2,50.0,3),
    FAMILY(400.0,3,75.0,5),
    DELUXE(600.0,2,150.0,4);

    private final Double dailyPrice;
    private final  Integer peoplePerRoom;
    private final Double extraCostPerPerson;
    private final Integer maxPeoplePerRoom;

    RoomType(double dailyPrice, int peoplePerRoom, double extraCostPerPerson, int maxPeoplePerRoom) {
    this.dailyPrice = dailyPrice;
    this.peoplePerRoom = peoplePerRoom;
    this.extraCostPerPerson = extraCostPerPerson;
    this.maxPeoplePerRoom = maxPeoplePerRoom;
    }

    public Double getDailyPrice() {
        return dailyPrice;
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
        return dailyPrice + (addedPeople * extraCostPerPerson) ;
    }
}
