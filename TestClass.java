package vendingMachineGroupProject;

public class TestClass {
	private String ItemName;
	private double Price;
	private String Location;

	public void setItemName(String n) {
		ItemName = n;

	}

	public String getItemName() {
		return ItemName;

	}

	public void setLocation(String l) {
		Location = l;

	}

	public String getLocation() {
		return Location;
	}

	public void setPrice(double p) {
		Price = p;

	}

	public double getPrice() {
		return Price;

	}

	public TestClass() {
		ItemName = "Not set yet!";
		Price = 0;
		Location = "Not set yet";
	}

	public TestClass(String nItemName, double pPrice, String lLocation) {
		ItemName = nItemName;
		Price = pPrice;
		Location = lLocation;
	}

	public TestClass(String ItemName) {
		this.ItemName = ItemName;

	}
}
