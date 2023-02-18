package classes;

public abstract class RealEstate implements Comparable<RealEstate>{

    private int price, house;
    private double square;
    private String city, street, crossing;

    public RealEstate(int price, int house, double square, String city, String street, String crossing) {
        this.price = price;
        this.house = house;
        this.square = square;
        this.city = city;
        this.street = street;
        this.crossing = crossing;
    }

    public int getPrice() {
        return price;
    }

    public double getSquare() {
        return square;
    }

    public int getHouse() {
        return house;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getCrossing() {
        return crossing;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public final double getPricePerSquareMeter(){
        return price/square;
    }

    public String getShortAddress(){
        return street + ", " + house;
    }

    public String getFullAddress(){
        return "City: "+ city + ", Crossing: " + crossing + ", Street: " + street + ", classes.House: " + house;
    }

    public abstract String getDescription();

    public abstract String getType();
}
