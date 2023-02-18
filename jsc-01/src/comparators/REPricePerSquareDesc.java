package comparators;

import classes.RealEstate;

import java.util.Comparator;

public class REPricePerSquareDesc implements Comparator<RealEstate> {
    @Override
    public int compare(RealEstate first, RealEstate second) {
        if ((first.getPrice()/first.getSquare()) > (second.getPrice()/second.getSquare())) return -1;
        if ((first.getPrice()/first.getSquare()) < (second.getPrice()/second.getSquare())) return 1;
        return 0;
    }
}
