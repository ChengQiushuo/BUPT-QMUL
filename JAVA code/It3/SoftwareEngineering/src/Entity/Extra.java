package Entity;

public class Extra {
	private String dishID="";
	private String name="";
	Double  price = 0.0;
	private String availability ="";
	public Extra() {
		
	}
	public Extra(String dishID,String name,Double price,String availability) {
		this.dishID = dishID;
		this.name = name;
		this.price = price;
		this.availability = availability;
	}
	public String getDishID() {
		return dishID;
	}
	public void setDishID(String dishID) {
		this.dishID = dishID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
