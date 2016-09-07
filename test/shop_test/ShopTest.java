package shop_test;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import shop.Milk;
import shop.Shop;

public class ShopTest {
    
    Shop shop;
    String name;
    String address;
    String owner;
    Milk[] milkbar;
    
    @Test
    public void there_is_five_milk_in_shop() {
	Milk milk1 = new Milk(0, "", new Date(), 0, 0);
	Milk milk2 = new Milk(0, "", new Date(), 0, 0);
	Milk milk3 = new Milk(0, "", new Date(), 0, 0);
	milkbar = new Milk[]{milk1, milk2, milk3};
	shop = new Shop(name, address, owner, milkbar);
	assertTrue(shop.isThereAnyMilk());
    }
    
    @Test
    public void there_is_not_any_milk_in_shop() {
	milkbar = new Milk[]{};
	shop = new Shop(name, address, owner, milkbar);
	assertFalse(shop.isThereAnyMilk());
    }
}
