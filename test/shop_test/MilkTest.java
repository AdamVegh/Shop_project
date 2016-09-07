package shop_test;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import shop.Milk;

public class MilkTest {
    
    Milk milk;
    int volume;
    String maker;
    Date warrantyPeriod;
    double fatContent;
    long prize;
    Date nowDate = new Date();
    
    @Test
    public void warrantyPeriod_of_milk_is_after_now() {
	int nowYear = nowDate.getYear();
	int month = 12;
	int day = 12;
	warrantyPeriod = new Date(nowYear+3, month-1, day);
	milk = new Milk(volume, maker, warrantyPeriod, fatContent, prize);
	assertTrue(milk.isConsumable());
    }
    
    @Test
    public void warrantyPeriod_of_milk_is_before_now() {
	int nowYear = nowDate.getYear();
	int month = 1;
	int day = 21;
	warrantyPeriod = new Date(nowYear-1, month-1, day);
	milk = new Milk(volume, maker, warrantyPeriod, fatContent, prize);
	assertFalse(milk.isConsumable());
    }
}
