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

    @Test
    public void wontTake10PercentifLessThan20(){
        myBasket.remove(item4);
        myBasket.remove(item2);
        assertEquals(14.49, tenPercentDiscount.applyDiscount(myBasket, 14.49), 0.01);
    }

    @Test
    public void canUseBogofDiscount(){
        myBasket.add(item1);
        assertEquals(45.99, bogofDiscount.applyDiscount(myBasket, 55.49), 0.01);
    }

    @Test
    public void canUseBogofDiscount__multipleItems(){
        myBasket.add(item1);
        myBasket.add(item2);
        myBasket.add(item3);
        myBasket.add(item4);
        assertEquals(45.99, bogofDiscount.applyDiscount(myBasket, 91.98), 0.01);
    }

    @Test
    public void canUseBogofDiscount__tripleItems(){
        myBasket.add(item1);
        myBasket.add(item1);
        myBasket.add(item2);
        myBasket.add(item2);
        assertEquals(67.49, bogofDiscount.applyDiscount(myBasket, 88.99), 0.01);
    }

    @Test
    public void canUseStoreCard(){
        assertEquals(45.07, storeCard.applyDiscount(myBasket, 45.99), 0.01);
    }
}
