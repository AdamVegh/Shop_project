package shop_test;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.Shop;

public class ShopTest {
    
    Shop shop;
    String name;
    String address;
    String owner;
    Milk[] milkbar;
    Milk milk1 = new Milk(0, "", new Date(), 0, 0);
    Milk milk2 = new Milk(0, "", new Date(), 0, 0);
    Milk milk3 = new Milk(0, "", new Date(), 0, 0);
    
    @Before
    public void setUp() {
	milkbar = new Milk[]{milk1, milk2, milk3};
    }
    
    @Test
    public void there_is_three_milk_in_shop() {
	shop = new Shop(name, address, owner, milkbar);
	assertTrue(shop.isThereAnyMilk());
    }
    
    @Test
    public void there_is_not_any_milk_in_shop() {
	milkbar = new Milk[]{};
	shop = new Shop(name, address, owner, milkbar);
	assertFalse(shop.isThereAnyMilk());
    }
    
    @Test
    public void buy_milk_if_there_is_any() {
	shop = new Shop(name, address, owner, milkbar);
	Milk boughtMilk3 = shop.buyMilk(milk3);
	assertEquals(milk3, boughtMilk3);
	Milk boughtMilk2 = shop.buyMilk(milk3);
	assertEquals(milk2, boughtMilk2);
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void buy_milk_if_there_is_no_one() {
	milkbar = new Milk[]{};
	shop = new Shop(name, address, owner, milkbar);
	shop.buyMilk(milk1);
    }
}
