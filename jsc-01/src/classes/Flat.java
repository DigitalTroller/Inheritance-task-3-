package classes;

public class Flat extends RealEstate{
    private Integer rooms, floor, totalFloor, apartment;
    private Double liveSquare, kitchenSquare;

    public Flat(int price, int house, double square, String city, String street, String crossing) {
        super(price, house, square, city, street, crossing);
    }

    public Flat(int price, int house, double square, String city, String street, String crossing, Integer rooms, Integer floor, Integer totalFloor, Integer apartment, Double liveSquare, Double kitchenSquare) {
        super(price, house, square, city, street, crossing);
        this.rooms = rooms;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.apartment = apartment;
        this.liveSquare = liveSquare;
        this.kitchenSquare = kitchenSquare;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public Double getLiveSquare() {
        return liveSquare;
    }

    public void setLiveSquare(Double liveSquare) {
        this.liveSquare = liveSquare;
    }

    public Double getKitchenSquare() {
        return kitchenSquare;
    }

    public void setKitchenSquare(Double kitchenSquare) {
        this.kitchenSquare = kitchenSquare;
    }

    @Override
    public String getShortAddress() {
        if(apartment != null) return super.getShortAddress() + ", apartment: " + apartment;
        else return super.getShortAddress();
    }

    @Override
    public String getFullAddress() {
        if(apartment != null) return super.getFullAddress() + ", apartment: " + apartment;
        else return super.getFullAddress();
    }

    @Override
    public String getDescription() {
        String answer = "";
        if(liveSquare != null){
            answer+=", ?????????? " + liveSquare + "????.??.";
        } if(kitchenSquare!=null){
            answer+=", ?????????? " + kitchenSquare + " ????.??.";
        } if(floor!= null) {
            answer+=", ???????? " + floor;
        } if (totalFloor!=null) {
            answer+=", ?????????????????? " + totalFloor;
        }
        return "????????????????, " + getPrice() + "????, " + rooms + "-??????????????????, " + "?????????????? " + getSquare() + " ????.??." + answer;
    }

    @Override
    public String getType() {
        return "????????????????";
    }

    @Override
    public String toString() {
        return "classes.Flat{" +
                "price=" + getPrice() +
                ", square=" + getSquare() +
                ", price per square meter=" + (getPrice()/getSquare()) +
                ", rooms=" + rooms +
                ", floor=" + floor +
                ", totalFloor=" + totalFloor +
                ", apartment=" + apartment +
                ", liveSquare=" + liveSquare +
                ", kitchenSquare=" + kitchenSquare +
                '}'+"\n";
    }


    @Override
    public int compareTo(RealEstate o) {
        return this.getPrice() - o.getPrice();
    }
}
