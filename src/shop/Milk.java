package shop;

import java.util.Date;

public class Milk {

    private int volume;
    private String maker;
    private Date warrantyPeriod;
    private double fatContent;
    private long prize;

    public Milk(int volume, String maker, Date warrantyPeriod, double fatContent, long prize) {
	this.volume = volume;
	this.maker = maker;
	this.warrantyPeriod = warrantyPeriod;
	this.fatContent = fatContent;
	this.prize = prize;
    }

    public boolean isConsumable() {
	return false;
    }

    public int getVolume() {
	return volume;
    }

    public String getMaker() {
	return maker;
    }

    public Date getWarrantyPeriod() {
	return warrantyPeriod;
    }

    public double getFatContent() {
	return fatContent;
    }

    public long getPrize() {
	return prize;
    }

    @Override
    public String toString() {
	return "Milk{" + "volume=" + volume + ", maker=" + maker + ", warrantyPeriod=" + warrantyPeriod + ", fatContent=" + fatContent + ", prize=" + prize + '}';
    }
}
