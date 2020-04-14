package test.pl.kamiljacko.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import pl.kamiljacko.tests.Basket;
import pl.kamiljacko.tests.Item;

public class BasketTest {

    Basket basket;

    @Before
    public void basket() {
        this.basket = new Basket();
        Item item1 = new Item("Item1", 6.99);
        Item item2 = new Item("Item2", 3.01);
        basket.addItems(item1, item2);
    }

    @Test
    public void shouldSayTrue() {
        assertTrue(basket.addItems(new Item("flour", 3.22)));
    }

    @Test
    public void shouldSayFalse() {
        assertFalse(basket.addItems(new Item("Item1", 3.22)));
    }

    @Test
    public void shouldReturnOK() {
        Item item = new Item("Item1", 333.2);
        assertEquals(basket.deleteItems(item), "ok");
    }
}