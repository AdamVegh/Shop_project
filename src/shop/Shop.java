package shop;

import java.util.Hashtable;

public class Shop {

    private String name;
    private String address;
    private String owner;
    private Hashtable milkbar;

    public Shop(String name, String address, String owner, Hashtable milkbar) {
	this.name = name;
	this.address = address;
	this.owner = owner;
	this.milkbar = milkbar;
    }

    public Shop(String name, String address, String owner) {
	this(name, address, owner, new Hashtable(500));
    }

    public String getName() {
	return name;
    }

    public String getAddress() {
	return address;
    }

    public String getOwner() {
	return owner;
    }

    public boolean isThereAnyMilk() {
	return !milkbar.isEmpty();
    }

    public Milk buyMilk(long barcode) {
	return (Milk) milkbar.remove(barcode);
    }
    
    public void loadMilk(Milk m) {
	milkbar.put(m.getBarcode(), m);
    }
}
