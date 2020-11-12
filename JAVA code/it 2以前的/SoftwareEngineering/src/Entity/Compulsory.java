package Entity;

public class Compulsory {
	private String dishID;
	private String name = "";
	private String[] option;
	private String[] availability;
	public Compulsory() {
		
	}
	public Compulsory(String dishID,String name,String[] option,String[] availability) {
		this.dishID = dishID;
		this.name = name;
		this.option = option;
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
	public String[] getOption() {
		return option;
	}
	public void setOption(String[] option) {
		this.option = option;
	}
	public String[] getAvailability() {
		return availability;
	}
	public void setAvailability(int i,String availability) {
		this.availability[i] = availability;
	}
	
	
}
