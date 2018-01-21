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


}
