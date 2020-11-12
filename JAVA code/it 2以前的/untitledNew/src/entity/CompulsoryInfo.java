package entity;
import control.Dish.CompulsoryFile;
public class CompulsoryInfo {
	public String[] dish_str = new String[9];
	public int[] option_len = new int[9];
	public String[][] option_str = new String[9][6];
	public String[][] availability = new String[9][6];
    public  int dish_len;
    CompulsoryFile compulsoryfile ;
	public CompulsoryInfo() {
		compulsoryfile = new CompulsoryFile();
		dish_str = compulsoryfile.getDish_str();
		option_len = compulsoryfile.getOption_len();
		option_str = compulsoryfile.getOption_str();
		availability = compulsoryfile.getAvailability();
		dish_len = compulsoryfile.getDish_len();
	}
}
