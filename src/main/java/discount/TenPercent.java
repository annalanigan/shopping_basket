package discount;

import basket.Item;

import java.util.ArrayList;

public class TenPercent implements IDiscount {

    // change this to be generic percentage discount rather than a 10% only...

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        if (total >= 20){
            total *= 0.9;
        }
        return total;
    }

}
