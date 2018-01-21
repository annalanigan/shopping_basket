package discount;

import basket.Item;

import java.util.ArrayList;

public class StoreCard implements IDiscount{

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        double storeCardDiscount = total * 0.02;
        double finalTotal = total - storeCardDiscount;
        return finalTotal;
    }

}
