package shop;

public class Shop {
    
    private String name;
    private String address;
    private String owner;
    private Milk[] milkbar;
    private int flag;

    public Shop(String name, String address, String owner, Milk[] milkbar) {
	this.name = name;
	this.address = address;
	this.owner = owner;
	this.milkbar = milkbar;
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
	return false;
    }
    
    public Milk buyMilk(Milk m) {
	return null;
    }
}
