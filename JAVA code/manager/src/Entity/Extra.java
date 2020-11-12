package Entity;
/** 
 * projectName: SoftwareEngineering
 * fileName: Extra.java 
 * packageName: Entity
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

/**
 * ClassName: Extra<br>
 * Description: This is the entity class that used to store<br>
 * the information about single extra dish read from file
 * @version V2.0
 */
public class Extra {
	private String dishID="";
	private String name="";
	Double  price = 0.0;
	private String availability ="";
	public Extra() {
		
	}
	
	/**
	* This constructor is used to initialize a Extra object, set the instance variables it has
	* @param dishID the ID of an extra dish
	* @param name the name of the extra dish
	* @param price the price of this dish
	* @param availability the availability of this dish
	*/
	public Extra(String dishID,String name,Double price,String availability) {
		this.dishID = dishID;
		this.name = name;
		this.price = price;
		this.availability = availability;
	}
	
	/**
	* Used to get the ID of an extra dish
	* @return String the ID of this extra dish
	*/
	public String getDishID() {
		return dishID;
	}
	
	/**
	* Used to set the ID of an extra dish
	* @param dishID the ID of this extra dish
	*/
	public void setDishID(String dishID) {
		this.dishID = dishID;
	}
	
	/**
	* Used to get the dish name of an extra dish
	* @return String the name of this extra dish
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Used to set the name of an extra dish
	* @param name the name of this extra dish
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Used to get the price of an extra dish
	* @return Double the price of this extra dish
	*/
	public Double getPrice() {
		return price;
	}
	
	/**
	* Used to set the price of an extra dish
	* @param price the price of this extra dish
	*/
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	* Used to get the availability of an extra dish
	* @return String the availability of this extra dish
	*/
	public String getAvailability() {
		return availability;
	}
	
	/**
	* Used to set the availability of an extra dish
	* @param availability the availability of this extra dish
	*/
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
