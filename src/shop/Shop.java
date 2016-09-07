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

    public void loadMilk(Milk milk, int prize) {
	ShopRegistry shopRegistry = new ShopRegistry(milk, this.milkbar.size(), prize);
	shopRegistry.incrementQuantity(1);
	milkbar.put(milk.getBarcode(), shopRegistry);
    }

    public Milk buyMilk(long barcode) {
	ShopRegistry shopRegistry = (ShopRegistry) milkbar.get(barcode);
	shopRegistry.decrementQuantity(1);
	return ((ShopRegistry) milkbar.remove(barcode)).getMilk();
    }

    class ShopRegistry {

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
