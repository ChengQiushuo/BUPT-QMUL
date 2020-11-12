package Entity;
/** 
 * projectName: SoftwareEngineering
 * fileName: Payment.java 
 * packageName: Entity
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

/**
 * ClassName: Payment<br>
 * Description: This is the entity class that used to store<br>
 * the information about a payment way read from file
 * @version V2.0
 */
public class Payment {
	
	private String name="";
	private String availability ="";
	
	/**
	* This constructor is used to do nothing
	*/
	public Payment() {
		
	}
	
	/**
	* This constructor is used to initialize a Payment object, set the instance variables it has
	* @param name the name of the payment way
	* @param availability the availability of this payment way
	*/
	public Payment(String name,String availability) {
		this.availability = availability;
		this.name = name;
	}
	
	/**
	* Used to get the name of a payment way
	* @return String the name of this payment way
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Used to set the name of a payment way
	* @param name the new name of this payment way
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Used to get the availability status of a payment way
	* @return String the availability of this payment way(Yes or No)
	*/
	public String getAvailability() {
		return availability;
	}
	
	/**
	* Used to set the availability status of a payment way
	* @param availability the availability status of this payment way(Yes or No)
	*/
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
