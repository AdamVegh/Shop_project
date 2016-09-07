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
    
    public class ShopRegistry {
	
	private Milk milk;
	private int quantity;
	private int prize;

	public ShopRegistry(Milk milk, int quantity, int prize) {
	    this.milk = milk;
	    this.quantity = quantity;
	    this.prize = prize;
	}

	public Milk getMilk() {
	    return milk;
	}

	public void setMilk(Milk milk) {
	    this.milk = milk;
	}

	public int getQuantity() {
	    return quantity;
	}

	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}

	public int getPrize() {
	    return prize;
	}

	public void setPrize(int prize) {
	    this.prize = prize;
	}
	
	public void incrementQuantity(int q) {
	    this.quantity += q;
	}
	
	public void decrementQuantity(int q) {
	    this.quantity -= q;
	}
    }
}
