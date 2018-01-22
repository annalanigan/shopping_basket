package discount;

import basket.Item;

import java.util.ArrayList;

public class Bogof implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        ArrayList<Item> bogofList = new ArrayList<Item>();
        for (Item item : items){
            if(!bogofList.contains(item)){
                bogofList.add(item);
            } else {
                total -= item.getPrice();
                bogofList.remove(item);
            }
        }
        return total;
    }

}
