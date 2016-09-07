package shop_test;

import java.util.Date;
import java.util.Vector;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.ShopV2;

public class ShopV2Test {
    
        
    ShopV2 shop;
    String name;
    String address;
    String owner;
    Vector<Milk> milkbar;
    Milk milk1 = new Milk(0, "", new Date(), 0, 0);
    Milk milk2 = new Milk(0, "", new Date(), 0, 0);
    Milk milk3 = new Milk(0, "", new Date(), 0, 0);
    
    @Before
    public void setUp() {
	milkbar = new Vector<Milk>();
	milkbar.add(milk1);
	milkbar.add(milk2);
	milkbar.add(milk3);
    }
    
    @Test
    public void there_is_three_milk_in_shop() {
	shop = new ShopV2(name, address, owner, milkbar);
	assertTrue(shop.isThereAnyMilk());
    }
    
    @Test
    public void there_is_not_any_milk_in_shop() {
	milkbar = new Vector<>();
	shop = new ShopV2(name, address, owner, milkbar);
	assertFalse(shop.isThereAnyMilk());
    }
    
    @Test
    public void buy_milk_if_there_is_any() {
	shop = new ShopV2(name, address, owner, milkbar);
	Milk boughtMilk2 = shop.buyMilk(milk2);
	assertEquals(milk2, boughtMilk2);
	Milk boughtMilk3 = shop.buyMilk(milk3);
	assertEquals(milk3, boughtMilk3);
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void buy_milk_if_there_is_no_one() {
	milkbar = new Vector<Milk>();
	shop = new ShopV2(name, address, owner, milkbar);
	shop.buyMilk(milk2);
    }
    
    @Test
    public void load_shop_with_milk() {
	shop = new ShopV2(name, address, owner, milkbar);
	Milk newMilk = new Milk(0, "", new Date(), 0, 0);
	shop.loadMilk(newMilk);
	Milk boughtMilk = shop.buyMilk(newMilk);
	assertEquals(newMilk, boughtMilk);
    }
}
