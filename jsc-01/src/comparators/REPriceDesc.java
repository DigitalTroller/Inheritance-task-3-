package comparators;

import classes.RealEstate;

import java.util.Comparator;

public class REPriceDesc implements Comparator<RealEstate> {
    @Override
    public int compare(RealEstate first, RealEstate second) {
        return -(first.getPrice() - second.getPrice());
    }
}
