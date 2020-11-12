package entity;
import control.Dish.ExtraFile;
/**
 * Title        : ExtraInfo.java
 * Description  : This class is used for processing extra information.
 * @author      : Hu Zhenming
 * @author 		: Jindong Ma
 * @version     : 1.2
 */
public class ExtraInfo {
    public String[] dishName = new String[7];//extra's name
    public int[] extraCount =new int[]{0, 0, 0, 0, 0, 0, 0};//数目
    public double[] dishPrice = new double[7];
    public String[] availability = new String[7];
    public int length = 0;
	/**
	 * Getters.
	 */
    public String[] getDishName() {
		return dishName;
	}
	/**
	 * Setters.
	 */
	public void setDishName(String[] dishName) {
		this.dishName = dishName;
	}
	/**
	 * Getters.
	 */
	public int[] getExtraCount() {
		return extraCount;
	}
	/**
	 * Setters.
	 */
	public void setExtraCount(int extraCount,int index) {
		this.extraCount[index] = extraCount;
	}
	/**
	 * Getters.
	 */
	public double[] getDishPrice() {
		return dishPrice;
	}
	/**
	 * Setters.
	 */
	public void setDishPrice(double[] dishPrice) {
		this.dishPrice = dishPrice;
	}
	/**
	 * Getters.
	 */
	public String[] getAvailability() {
		return availability;
	}
	/**
	 * Setters.
	 */
	public void setAvailability(String[] availability) {
		this.availability = availability;
	}
	/**
	 * Getters.
	 */
	public int getLength() {
		return length;
	}
	/**
	 * Setters.
	 */
	public void setLength(int length) {
		this.length = length;
	}
	public ExtraFile extrafile = new ExtraFile();
	/**
	 * ExtraInfoo constructor without parameter.
	 * Process the information.
	 */
    public ExtraInfo() {
    	dishName = extrafile.getDishName();
    	dishPrice = extrafile.getDishPrice();
    	availability = extrafile.getAvailability();
    	length = extrafile.getLength();
    	System.out.println(dishName[0]);
    	System.out.println(dishPrice[0]);
    	System.out.println(length);
    }
}
