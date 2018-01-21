package discount;

import basket.Item;

import java.util.ArrayList;

public class Bogof implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        // create new emply list for checkingagainst bogof disount:
        ArrayList<Item> bogofList = new ArrayList<Item>();
        // iterate through array of basket items
        for (Item item : items){
            // if it is not on the list, add it to the list and add price to the total:
            if(!bogofList.contains(item)){
                bogofList.add(item);
                total += item.getPrice();
            // otherwise, remove the item from the list, not affecting the price:
            } else {
                bogofList.remove(item);
            }
        }
        return total;
    }

}
