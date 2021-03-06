package basket;

import discount.IDiscount;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private ArrayList<IDiscount> discounts;

    public Basket(){
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public void addItem(Item item1) {
        items.add(item1);
    }

    public int countItems() {
        return items.size();
    }

    public void removeItem(Item item2) {
        items.remove(item2);
    }

    public void removeLastItem() {
        items.remove(countItems()-1);
    }

    public void emptyBasket() {
        items.clear();
    }

    public double totalCost(){
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void addDiscounts(IDiscount discount) {
        discounts.add(discount);
    }

    public int countDiscounts(){
        return discounts.size();
    }

    // rework this to make the order mandatory rather than just chance?

    public double discountCost(){
        double total = totalCost();
        for (IDiscount discount : discounts){
            total = discount.applyDiscount(items, total);
        }
        return total;
    }

}
