package shop_test;

import java.util.Date;
import java.util.Hashtable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.Shop;

public class ShopTest {
    
    Shop shop;
    String name;
    String address;
    String owner;
    Hashtable<Long, Milk> milkbar;
    Milk milk1 = new Milk(1, 0, "", new Date(), 0);
    Milk milk2 = new Milk(2, 0, "", new Date(), 0);
    Milk milk3 = new Milk(3, 0, "", new Date(), 0);
    
    @Before
    public void setUp() {
	milkbar = new Hashtable<>();
	milkbar.put(milk1.getBarcode(), milk1);
	milkbar.put(milk2.getBarcode(), milk2);
	milkbar.put(milk3.getBarcode(), milk3);
    }
    
    @Test
    public void isThereAnyMilk_whenThreeMilkInMilkbar_ThenTrue() {
	shop = new Shop(name, address, owner, milkbar);
	assertTrue(shop.isThereAnyMilk());
    }
    
    @Test
    public void isThereAnyMilk_whenNoMilkInMilkbar_ThenFalse() {
	milkbar = new Hashtable<>();
	shop = new Shop(name, address, owner, milkbar);
	assertFalse(shop.isThereAnyMilk());
    }
    
    @Test
    public void buyMilk_whenThereIsSomeMilk_ThenThisMilk() {
	shop = new Shop(name, address, owner, milkbar);
	Milk boughtMilk2 = shop.buyMilk(milk2.getBarcode());
	assertEquals(milk2, boughtMilk2);
	Milk boughtMilk3 = shop.buyMilk(milk3.getBarcode());
	assertEquals(milk3, boughtMilk3);
    }
    
    @Test
    public void buyMilk_whenNoMilk_ThenNull() {
	milkbar = new Hashtable<>();
	shop = new Shop(name, address, owner, milkbar);
	Milk shadowMilk = shop.buyMilk(milk2.getBarcode());
	assertEquals(null, shadowMilk);
    }
    
    @Test
    public void loadMilk_whenLoadMilk_ThenLastMilkIsEqualToThat() {
	shop = new Shop(name, address, owner, milkbar);
	Milk newMilk = new Milk(4, 0, "", new Date(), 0);
	shop.loadMilk(newMilk);
	Milk boughtMilk = shop.buyMilk(newMilk.getBarcode());
	assertEquals(newMilk, boughtMilk);
    }
}
