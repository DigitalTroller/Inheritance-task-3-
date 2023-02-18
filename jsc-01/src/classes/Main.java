package classes;

import comparators.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        classes.House house = new classes.House();
//        house.setFloors(3);
//        house.setGardenSquare(32.5);
//        house.setCity("Astana");
//        house.setCrossing("Mukhtar-Abay");
//        house.setStreet("Madi");
//        house.setHouse(42);
//        System.out.println(house.getFullAddress());
//        System.out.println(house.getShortAddress());
//        house.setSquare(100);
//        house.setPrice(40_000_000);
//        house.setKitchenSquare(25);
//        house.setLiveSquare(60);
//        System.out.println(house.getDescription()+"\n\n");


//        classes.Flat flat = new classes.Flat();
//        flat.setCity("Astana");
//        flat.setCrossing("Konaeva-Saraishyk");
//        flat.setHouse(50);
//        flat.setStreet("Zhumabayeva");
//        System.out.println(flat.getFullAddress());
//        System.out.println(flat.getShortAddress());
//        flat.setApartment(42);
//        System.out.println(flat.getFullAddress());
//        System.out.println(flat.getShortAddress());
//        flat.setPrice(35_000_000);
//        flat.setSquare(60);
//        flat.setRooms(4);
//        flat.setLiveSquare(45.0);
//        flat.setKitchenSquare(10.0);
//        flat.setFloor(5);
//        flat.setTotalFloor(10);
//        System.out.println(flat.getDescription()+"\n\n");


//        classes.Office office = new classes.Office();
//        office.setCity("Astana");
//        office.setStreet("Koshanova");
//        office.setCrossing("Imanova-Seifulina");
//        office.setHouse(68);
//        System.out.println(office.getFullAddress());
//        System.out.println(office.getShortAddress());
//        office.setOfficeNumber(50);
//        System.out.println(office.getFullAddress());
//        System.out.println(office.getShortAddress());
//        office.setRooms(3);
//        office.setPrice(3_000_000);
//        office.setSquare(20);
//        System.out.println(office.getDescription());
//        office.setNameOfBusinessCenter("Easy money");
//        System.out.println(office.getDescription());

        ArrayList<RealEstate> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(getRandRealEstate());
        }

        Scanner scanner = new Scanner(System.in);

        REPriceDesc priceDesc = new REPriceDesc();
        REPriceAsc priceAsc = new REPriceAsc();
        RESquareDesc squareDesc = new RESquareDesc();
        RESquareAsc squareAsc = new RESquareAsc();
        REPricePerSquareDesc pricePerSquareDesc = new REPricePerSquareDesc();
        REPricePerSquareAsc pricePerSquareAsc = new REPricePerSquareAsc();
        System.out.print("1 - сортировка по цене по возр, 2 - по цене по убыв, 3 - по площади по возр, " +
                "\n4 - по площади по убыв, 5 - по цене за кв.м. возр, 6 - по цене за кв.м. убыв" +
                "\nПо какому принципу сортировать результаты поиска: ");
        int input = scanner.nextInt();
        Comparator comparator;
        if(input==1){
            comparator = new REPriceAsc();
        } else if (input == 2) {
            comparator = new REPriceDesc();
        } else if (input == 3) {
            comparator = new RESquareAsc();
        } else if (input == 4) {
            comparator = new RESquareDesc();
        } else if (input == 5) {
            comparator = new REPricePerSquareAsc();
        } else {
            comparator = new REPricePerSquareDesc();
        }


        while (true){
            System.out.println();
            System.out.print("1 - квартиры, 2 - дома, 3 - офисы\nПожалуйста введите тип категории для поиска: ");
            int categoryint = scanner.nextInt();
            String category = "";
            if (categoryint==1){
                category = "Квартира";
            } else if (categoryint == 2) {
                category = "Дом";
            } else if (categoryint == 3) {
                category = "Офис";
            }
            System.out.print("Цена от: ");
            scanner.nextLine();
            String fromm = scanner.nextLine();
            int from;
            if (fromm.equals("")) from = 20_000_000;
            else from = Integer.parseInt(fromm);
            System.out.print("Цена до: ");
            String tilll = scanner.nextLine();
            int till;
            if (tilll.equals("")) till = 40_000_000;
            else till = Integer.parseInt(tilll);

            Collections.sort(list, comparator);

            for (classes.RealEstate r : list) {
                if(r.getType().equals(category)){
                    if(r.getPrice()>=from&&r.getPrice()<=till){
                        System.out.println(r.getDescription());
                    }
                }
            }
        }

    }
        public static RealEstate getRandRealEstate() {
            Random rand = new Random();
            double scale = Math.pow(10, 2);
            String[] streets = new String[]{"Abay", "Pushkin", "Tole bi", "Dostyk"};
            String[] namesofBC = new String[]{"Easy Money", "Almaty", "Moscow", "BC A"};
            String[] cityS = new String[]{"Astana", "Almaty", "Semey", "Taraz", "Kyzylorda", "Oral", "Taldykorgan"};
            int random = rand.nextInt(1,4);
            if (random==1){
                int price = rand.nextInt(20_000_000, 40_000_001);
                int house = rand.nextInt(1, 100);
                double square = rand.nextDouble(30, 101);
                String city = cityS[rand.nextInt(0,7)];
                String street = streets[rand.nextInt(0, 4)];
                String crossing = streets[rand.nextInt(0,4)];
                while (crossing.equals(street))
                    crossing =streets[rand.nextInt(0, 4)];
                crossing+= street + " - ";
                int rooms = rand.nextInt(2, 5);
                int apartment = rand.nextInt(1, 1000);
                double kitchenSquare = rand.nextDouble(10,20);
                double liveSquare = square-kitchenSquare;
                int floors = rand.nextInt(1, 19);
                int totalFloor = rand.nextInt(floors, 20);
                return new Flat(price, house, Math.round(square*scale)/scale, city, street, crossing, rooms, floors, totalFloor,apartment, Math.round(liveSquare*scale)/scale, Math.round(kitchenSquare*scale)/scale);
            } else if (random == 2) {
                int price = rand.nextInt(20_000_000, 40_000_001);
                int house = rand.nextInt(1, 100);
                double square = rand.nextDouble(30, 101);
                String city = cityS[rand.nextInt(0,7)];
                String street = streets[rand.nextInt(0, 4)];
                String crossing = streets[rand.nextInt(0,4)];
                while (crossing.equals(street))
                    crossing =streets[rand.nextInt(0, 4)];
                crossing+= street + " - ";
                double liveSquare, kitchenSquare, gardenSquare;
                int floors;
                kitchenSquare = rand.nextDouble(10,20);
                liveSquare = square-kitchenSquare;
                gardenSquare = rand.nextDouble(10,35);
                floors = rand.nextInt(1, 4);
                return new House(price, house, Math.round(square* scale)/scale, city, street, crossing, Math.round(liveSquare*scale)/scale, Math.round(kitchenSquare*scale)/scale, Math.round(gardenSquare*scale)/scale, floors);
            } else {
                int price = rand.nextInt(20_000_000, 40_000_001);
                int house = rand.nextInt(1, 100);
                double square = rand.nextDouble(30, 101);
                String city = cityS[rand.nextInt(0,7)];
                String street = streets[rand.nextInt(0, 4)];
                String crossing = streets[rand.nextInt(0,4)];
                while (crossing.equals(street))
                    crossing =streets[rand.nextInt(0, 4)];
                crossing+= street + " - ";
                int rooms, officeNumber;
                String nameOfBusinessCenter = namesofBC[rand.nextInt(0, 4)];
                rooms = rand.nextInt(2, 5);
                officeNumber = rand.nextInt(1, 1000);
                return new Office(price, house, Math.round(square* scale)/scale, city, street, crossing, rooms, officeNumber, nameOfBusinessCenter);
            }
        }
}

