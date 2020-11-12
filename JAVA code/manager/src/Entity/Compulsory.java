package Entity;
/** 
 * projectName: SoftwareEngineering
 * fileName: Compulsory.java 
 * packageName: Entity
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

/**
 * ClassName: Compulsory<br>
 * Description: This is the entity class that used to store<br>
 * the information about single compulsory dish read from file
 * @version V2.0
 */
public class Compulsory {
	private String dishID;
	private String name = "";
	private String[] option;
	private String[] availability;
	
	/**
	* This constructor is used to do nothing
	*/
	public Compulsory() {
		
	}
	
	/**
	* This constructor is used to initialize a Compulsory object, set the instance variables it has
	* @param dishID the ID of a compulsory dish
	* @param name the name of the compulsory dish
	* @param option the choosing options of this dish
	* @param availability the availability of the options this dish has
	*/
	public Compulsory(String dishID,String name,String[] option,String[] availability) {
		this.dishID = dishID;
		this.name = name;
		this.option = option;
		this.availability = availability;
	}
	
	/**
	* Used to get the ID of a compulsory dish
	* @return String the ID of this compulsory dish
	*/
	public String getDishID() {
		return dishID;
	}
	
	/**
	* Used to set the ID of a compulsory dish
	* @param dishID the ID of this compulsory dish
	*/
	public void setDishID(String dishID) {
		this.dishID = dishID;
	}
	
	/**
	* Used to get the dish name of a compulsory dish
	* @return String the name of this compulsory dish
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Used to set the name of a compulsory dish
	* @param name the name of this compulsory dish
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Used to get the choosing options array of a compulsory dish
	* @return String[] the array of choosing options of this compulsory dish
	*/
	public String[] getOption() {
		return option;
	}
	
	/**
	* Used to set the choosing options array of a compulsory dish
	* @param option the new array of choosing options of this compulsory dish
	*/
	public void setOption(String[] option) {
		this.option = option;
	}
	
	/**
	* Used to get the availability array of options that a compulsory dish has
	* @return String[] the availability array of options that this compulsory dish has
	*/
	public String[] getAvailability() {
		return availability;
	}
	
	/**
	* Used to set the choosing options array of a compulsory dish
	* @param i the index of this option in the option array
	* @param availability the availability of this options(Yes or No)
	*/
	public void setAvailability(int i,String availability) {
		this.availability[i] = availability;
	}
	
	
}
