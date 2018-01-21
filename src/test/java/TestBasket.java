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

}


