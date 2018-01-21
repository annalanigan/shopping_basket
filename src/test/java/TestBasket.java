import basket.Basket;
import basket.Item;
import discount.Bogof;
import discount.StoreCard;
import discount.TenPercent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBasket {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Basket myBasket;
    private Bogof bogof;
    private TenPercent tenPercent;
    private StoreCard storeCard;

    @Before
    public void before(){
        item1 = new Item("slippers", 9.50);
        item2 = new Item("gloves", 12.00);
        item3 = new Item("bubble bath", 4.99);
        item4 = new Item("teddy bear", 19.50);
        myBasket = new Basket();
        bogof = new Bogof();
        tenPercent = new TenPercent();
        storeCard = new StoreCard();
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

    @Test
    public void canEmptyBasket(){
        myBasket.addItem(item4);
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.emptyBasket();
        assertEquals(0, myBasket.countItems());
    }

    @Test
    public void canCalculateTotalCost(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        assertEquals(21.50, myBasket.totalCost(), 0.01);
    }

    @Test
    public void canAddDiscountToArray(){
        myBasket.addDiscounts(bogof);
        assertEquals(1, myBasket.countDiscounts());
    }

    @Test
    public void canAddManyDiscounts(){
        myBasket.addDiscounts(bogof);
        myBasket.addDiscounts(tenPercent);
        myBasket.addDiscounts(storeCard);
        assertEquals(3, myBasket.countDiscounts());
    }

    @Test
    public void canApplyBogofInBasket(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addDiscounts(bogof);
        assertEquals(21.50, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyTenPercentInBasket(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addDiscounts(tenPercent);
        assertEquals(19.35, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyStoreCardInBasket(){
        myBasket.addItem(item3);
        myBasket.addItem(item4);
        myBasket.addDiscounts(storeCard);
        assertEquals(24.49, myBasket.totalCost(), 0.01);
        assertEquals(24.00, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts__1(){
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.addItem(item4);
        myBasket.addDiscounts(bogof);
        myBasket.addDiscounts(tenPercent);
        assertEquals(41.39, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts__2(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.addItem(item4);
        myBasket.addDiscounts(tenPercent);
        myBasket.addDiscounts(storeCard);
        assertEquals(51.15, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts__3(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.addItem(item3);
        myBasket.addItem(item3);
        myBasket.addItem(item4);
        myBasket.addItem(item4);
        myBasket.addDiscounts(bogof);
        myBasket.addDiscounts(storeCard);
        assertEquals(49.96, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts__4(){
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.addItem(item3);
        myBasket.addItem(item3);
        myBasket.addItem(item3);
        myBasket.addItem(item4);
        myBasket.addDiscounts(bogof);
        myBasket.addDiscounts(tenPercent);
        myBasket.addDiscounts(storeCard);
        assertEquals(53.34, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts__5(){
        myBasket.addItem(item1);
        myBasket.addItem(item2);
        myBasket.addItem(item3);
        myBasket.addItem(item4);
        myBasket.addItem(item4);
        myBasket.addItem(item4);
        myBasket.addItem(item4);
        myBasket.addDiscounts(bogof);
        myBasket.addDiscounts(tenPercent);
        myBasket.addDiscounts(storeCard);
        assertEquals(57.76, myBasket.discountCost(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts__6(){
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addItem(item1);
        myBasket.addDiscounts(bogof);
        myBasket.addDiscounts(tenPercent);
        myBasket.addDiscounts(storeCard);
        assertEquals(25.14, myBasket.discountCost(), 0.01);
    }

}


