package classes;

public class Office extends RealEstate{
    private Integer rooms, officeNumber;
    private String nameOfBusinessCenter;

    public Office(int price, int house, double square, String city, String street, String crossing) {
        super(price, house, square, city, street, crossing);
    }

    public Office(int price, int house, double square, String city, String street, String crossing, Integer rooms, Integer officeNumber, String nameOfBusinessCenter) {
        super(price, house, square, city, street, crossing);
        this.rooms = rooms;
        this.officeNumber = officeNumber;
        this.nameOfBusinessCenter = nameOfBusinessCenter;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(Integer officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getNameOfBusinessCenter() {
        return nameOfBusinessCenter;
    }

    public void setNameOfBusinessCenter(String nameOfBusinessCenter) {
        this.nameOfBusinessCenter = nameOfBusinessCenter;
    }

    @Override
    public String getFullAddress() {
        if (officeNumber!= null) return super.getFullAddress() + ", cabinet number " + officeNumber;
        return super.getFullAddress();
    }

    @Override
    public String getShortAddress() {
        if (officeNumber!=null) return super.getShortAddress() + ", cabinet number " + officeNumber;
        return super.getShortAddress();
    }

    @Override
    public String getDescription() {
        String roomsNumb = "";
        if (rooms != null) roomsNumb+=", " + rooms + "-комнатный";
        String nameOfBC = "";
        if (nameOfBusinessCenter!=null) nameOfBC+=", бизнес центр " + nameOfBusinessCenter;
        return "Офис, " + getPrice() + " тг" + roomsNumb + ", площадь " + getSquare() + " кв.м." + nameOfBC;
    }

    @Override
    public String getType() {
        return "Офис";
    }

    @Override
    public String toString() {
        return "classes.Office{" +
                "price=" + getPrice() +
                ", square=" + getSquare() +
                ", price per square meter=" + (getPrice()/getSquare()) +
                ", rooms=" + rooms +
                ", officeNumber=" + officeNumber +
                ", nameOfBusinessCenter='" + nameOfBusinessCenter + '\'' +
                '}'+"\n";
    }

    @Override
    public int compareTo(RealEstate o) {
        return this.getPrice() - o.getPrice();
    }
}
