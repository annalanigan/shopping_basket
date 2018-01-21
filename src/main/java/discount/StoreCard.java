package discount;

import basket.Item;

import java.util.ArrayList;

public class StoreCard implements IDiscount{

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        return 0;
    }

}
