package comparators;

import classes.RealEstate;

import java.util.Comparator;

public class RESquareDesc implements Comparator<RealEstate> {
    @Override
    public int compare(RealEstate first, RealEstate second) {
        if (first.getSquare() > second.getSquare()) return -1;
        if (first.getSquare() < second.getSquare()) return 1;
        return 0;
    }
}
