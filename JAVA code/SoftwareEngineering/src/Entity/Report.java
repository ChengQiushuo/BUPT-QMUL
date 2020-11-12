package Entity;

public class Report {

	private int compulsoryCount;
	private String[] compulsoryName = {"null", "null", "null", "null", "null", "null", "null", "null", "null"};
	private int[] itemCount;
	private String[][] itemName;
	private int[][] itemNumber;
	private int extraCount;
	private String[] dishName;
	private int[] dishNumber;
	public int getCompulsoryCount() {
		return compulsoryCount;
	}
	public void setCompulsoryCount(int compulsoryCount) {
		this.compulsoryCount = compulsoryCount;
	}
	public String[] getCompulsoryName() {
		return compulsoryName;
	}
	public void setCompulsoryName(String[] compulsoryName) {
		this.compulsoryName = compulsoryName;
	}
	public int[] getItemCount() {
		return itemCount;
	}
	public void setItemCount(int[] itemCount) {
		this.itemCount = itemCount;
	}
	public String[][] getItemName() {
		return itemName;
	}
	public void setItemName(String[][] itemName) {
		this.itemName = itemName;
	}
	public int[][] getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int[][] itemNumber) {
		this.itemNumber = itemNumber;
	}
	public int getExtraCount() {
		return extraCount;
	}
	public void setExtraCount(int extraCount) {
		this.extraCount = extraCount;
	}
	public String[] getDishName() {
		return dishName;
	}
	public void setDishName(String[] dishName) {
		this.dishName = dishName;
	}
	public int[] getDishNumber() {
		return dishNumber;
	}
	public void setDishNumber(int[] dishNumber) {
		this.dishNumber = dishNumber;
	}
}
