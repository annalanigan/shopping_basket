import basket.Basket;
import basket.Item;
import discount.Bogof;
import discount.StoreCard;
import discount.TenPercent;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestDiscounts {

    private Bogof bogofDiscount;
    private TenPercent tenPercentDiscount;
    private StoreCard storeCard;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private ArrayList<Item> myBasket;


    @Before
    public void before() {
        bogofDiscount = new Bogof();
        tenPercentDiscount = new TenPercent();
        storeCard = new StoreCard();
        item1 = new Item("slippers", 9.50);
        item2 = new Item("gloves", 12.00);
        item3 = new Item("bubble bath", 4.99);
        item4 = new Item("teddy bear", 19.50);
        myBasket = new ArrayList<>();
        myBasket.add(item1);
        myBasket.add(item2);
        myBasket.add(item3);
        myBasket.add(item4);
    }

    @Test
    public void canTakeOff10Percent(){
        assertEquals(41.39, tenPercentDiscount.applyDiscount(myBasket, 45.99), 0.1);
    }

}
