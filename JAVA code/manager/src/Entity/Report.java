package Entity;
/** 
 * projectName: SoftwareEngineering
 * fileName: Report.java 
 * packageName: Entity
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

/**
 * ClassName: Report<br>
 * Description: This is the entity class that used to store<br>
 * the information about a report read from file
 * @version V2.0
 */
public class Report {

	private int compulsoryCount;
	private String[] compulsoryName = {"null", "null", "null", "null", "null", "null", "null", "null", "null"};
	private int[] itemCount;
	private String[][] itemName;
	private int[][] itemNumber;
	private int extraCount;
	private String[] dishName;
	private int[] dishNumber;
	
	/**
	* Used to get the number of compulsory dishes
	* @return int the number of compulsory dishes
	*/
	public int getCompulsoryCount() {
		return compulsoryCount;
	}
	
	/**
	* Used to set the number of compulsory dishes
	* @param compulsoryCount the new number of compulsory dishes
	*/
	public void setCompulsoryCount(int compulsoryCount) {
		this.compulsoryCount = compulsoryCount;
	}
	
	/**
	* Used to get all the name of compulsory dishes
	* @return String[] the name array of compulsory dishes
	*/
	public String[] getCompulsoryName() {
		return compulsoryName;
	}
	
	/**
	* Used to set all the name array of compulsory dishes
	* @param compulsoryName the name array of compulsory dishes
	*/
	public void setCompulsoryName(String[] compulsoryName) {
		this.compulsoryName = compulsoryName;
	}
	
	/**
	* Used to get the array which contains the quantity of each compulsory dish's options
	* @return int[] the array which contains the quantity of each compulsory dish's options
	*/
	public int[] getItemCount() {
		return itemCount;
	}
	
	/**
	* Used to set the array which contains the quantity of each compulsory dish's options
	* @param itemCount the array which contains the quantity of each compulsory dish's options
	*/
	public void setItemCount(int[] itemCount) {
		this.itemCount = itemCount;
	}
	
	/**
	* Used to get the two-dimension array which contains the name of each compulsory dish's options
	* @return String[][] the two-dimension array which contains the name of each compulsory dish's options
	*/
	public String[][] getItemName() {
		return itemName;
	}
	
	/**
	* Used to set the two-dimension array which contains the name of each compulsory dish's options
	* @param itemName the two-dimension array which contains the name of each compulsory dish's options
	*/
	public void setItemName(String[][] itemName) {
		this.itemName = itemName;
	}
	
	/**
	* Used to get the two-dimension array which contains the statistical number of each compulsory dish's options
	* @return int[][] the two-dimension array which contains the statistical number of each compulsory dish's options
	*/
	public int[][] getItemNumber() {
		return itemNumber;
	}
	
	/**
	* Used to set the two-dimension array which contains the statistical number of each compulsory dish's options
	* @param itemNumber the two-dimension array which contains the statistical number of each compulsory dish's options
	*/
	public void setItemNumber(int[][] itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	/**
	* Used to get the number of extra dishes
	* @return int the number of extra dishes
	*/
	public int getExtraCount() {
		return extraCount;
	}
	
	/**
	* Used to set the number of extra dishes
	* @param extraCount the number of extra dishes
	*/
	public void setExtraCount(int extraCount) {
		this.extraCount = extraCount;
	}
	
	/**
	* Used to get all the name of extra dishes
	* @return String[] the name array of extra dishes
	*/
	public String[] getDishName() {
		return dishName;
	}
	
	/**
	* Used to set the name of extra dishes
	* @param dishName the name of extra dishes
	*/
	public void setDishName(String[] dishName) {
		this.dishName = dishName;
	}
	
	/**
	* Used to get the array contains the statistical number of each extra dish
	* @return int[] the array contains the statistical number of each extra dish
	*/
	public int[] getDishNumber() {
		return dishNumber;
	}
	
	/**
	* Used to set the array contains the statistical number of each extra dish
	* @param dishNumber the array contains the statistical number of each extra dish
	*/
	public void setDishNumber(int[] dishNumber) {
		this.dishNumber = dishNumber;
	}
}
