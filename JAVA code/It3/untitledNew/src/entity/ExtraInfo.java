package entity;
import control.Dish.ExtraFile;

public class ExtraInfo {
    public String[] dishName = new String[7];//extra's name
    public int[] extraCount =new int[]{0, 0, 0, 0, 0, 0, 0};//数目
    public double[] dishPrice = new double[7];
    public String[] availability = new String[7];
    public int length = 0;
    public String[] getDishName() {
		return dishName;
	}
	public void setDishName(String[] dishName) {
		this.dishName = dishName;
	}
	public int[] getExtraCount() {
		return extraCount;
	}
	public void setExtraCount(int extraCount,int index) {
		this.extraCount[index] = extraCount;
	}
	public double[] getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double[] dishPrice) {
		this.dishPrice = dishPrice;
	}
	public String[] getAvailability() {
		return availability;
	}
	public void setAvailability(String[] availability) {
		this.availability = availability;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public ExtraFile extrafile = new ExtraFile();
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
