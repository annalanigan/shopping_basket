import basket.Basket;
import basket.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBasket {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Basket myBasket;

    @Before
    public void before(){
        item1 = new Item("slippers", 9.50);
        item2 = new Item("gloves", 12.00);
        item3 = new Item("bubble bath", 4.99);
        item4 = new Item("teddy bear", 19.50);
        myBasket = new Basket();
    }

    @Test
    public void canAddItemToBasket(){
        myBasket.addItem(item1);
        assertEquals(1, myBasket.countItems());
    }

    @Test
    public void canAddMultipleItemsToBasket(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        assertEquals(3, myBasket.countItems());
    }

    @Test
    public void canRemoveItemFromBasket(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.removeItem(item2);
        assertEquals(2, myBasket.countItems());
    }

    @Test
    public void canRemoveLastItemFromBasket(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.removeLastItem();
        myBasket.removeLastItem();
        assertEquals(1, myBasket.countItems());
    }

}


