package shop;

import java.util.Date;

public class Milk {

    private static final int LITER;
    private static final int HALF_LITER;
    private static final int GLASS;
    private static final double FAT;
    private static final double HALF_FAT;
    
    static {
	LITER = 1000;
	HALF_LITER = 500;
	GLASS = 200;
	FAT = 2.8;
	HALF_FAT = 1.5;
    }
    
    protected long barcode;
    protected int volume;
    protected String maker;
    protected Date warrantyPeriod;
    protected double fatContent;

    public Milk(long barcode, int volume, String maker, Date warrantyPeriod, double fatContent) {
	this.barcode = barcode;
	this.volume = volume;
	this.maker = maker;
	this.warrantyPeriod = warrantyPeriod;
	this.fatContent = fatContent;
    }


    public boolean isConsumable() {
	return warrantyPeriod.after(new Date());
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

    public long getBarcode() {
	return barcode;
    }

    @Override
    public String toString() {
	return "Milk{" + "barcode=" + barcode + ", volume=" + volume + ", maker=" + maker + ", warrantyPeriod=" + warrantyPeriod + ", fatContent=" + fatContent + '}';
    }
}
