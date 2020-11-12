package Entity;

public class Payment {
	
	private String name="";
	private String availability ="";
	
	public Payment() {
		
	}
	public Payment(String name,String availability) {
		this.availability = availability;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
