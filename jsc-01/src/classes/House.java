package classes;

public class House extends RealEstate{
    private Double liveSquare, kitchenSquare, gardenSquare;
    private Integer floors;

    public House(int price, int house, double square, String city, String street, String crossing) {
        super(price, house, square, city, street, crossing);
    }

    public House(int price, int house, double square, String city, String street, String crossing, Double liveSquare, Double kitchenSquare, Double gardenSquare, Integer floors) {
        super(price, house, square, city, street, crossing);
        this.liveSquare = liveSquare;
        this.kitchenSquare = kitchenSquare;
        this.gardenSquare = gardenSquare;
        this.floors = floors;
    }

    public void setLiveSquare(double liveSquare) {
        this.liveSquare = liveSquare;
    }

    public void setKitchenSquare(double kitchenSquare) {
        this.kitchenSquare = kitchenSquare;
    }

    public void setGardenSquare(double gardenSquare) {
        this.gardenSquare = gardenSquare;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String getDescription() {
        String answer = "";
        if(liveSquare != null){
            answer+=", жилая " + liveSquare + "кв.м.";
        } if(kitchenSquare!=null){
            answer+=", кухня " + kitchenSquare + " кв.м.";
        } if(gardenSquare!= null) {
            answer+=", участок " + gardenSquare + " соток";
        } if (floors!=null) {
            answer+=", этажей " + floors;
        }
        return "Дом, " + getPrice() + " тг, площадь " + getSquare() + "кв.м." + answer;
    }

    @Override
    public String getType() {
        return "Дом";
    }

    @Override
    public String toString() {
        return "classes.House{" +
                "price=" + getPrice() +
                ", square=" + getSquare() +
                ", price per square meter=" + (getPrice()/getSquare()) +
                ", liveSquare=" + liveSquare +
                ", kitchenSquare=" + kitchenSquare +
                ", gardenSquare=" + gardenSquare +
                ", floors=" + floors +
                '}'+"\n";

    }


    @Override
    public int compareTo(RealEstate o) {
        return this.getPrice() - o.getPrice();
    }
}
