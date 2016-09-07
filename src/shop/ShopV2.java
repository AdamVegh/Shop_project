package shop;

import java.util.Vector;

public class ShopV2 {

    private String name;
    private String address;
    private String owner;
    private Vector<Milk> milkbar;

    public ShopV2(String name, String address, String owner, Vector<Milk> milkbar) {
	this.name = name;
	this.address = address;
	this.owner = owner;
	this.milkbar = milkbar;
    }

    public ShopV2(String name, String address, String owner) {
	this(name, address, owner, new Vector<Milk>(500));
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

    public Milk buyMilk(Milk m) {
	return milkbar.elementAt(milkbar.indexOf(m));
    }
    
    public void loadMilk(Milk m) {
	milkbar.add(m);
    }
}
