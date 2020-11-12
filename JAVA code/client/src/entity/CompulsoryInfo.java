package entity;
import control.Dish.CompulsoryFile;
/**
 * Title        : CompulsoryInfo.java
 * Description  : This class is used for processing compulsory information.
 * @author      : Yuang Du
 * @author 		: Qiushuo Cheng
 * @version     : 1.2
 */
public class CompulsoryInfo {
	public String[] dish_str = new String[9];
	public int[] option_len = new int[9];
	public String[][] option_str = new String[9][6];
	public String[][] availability = new String[9][6];
    public  int dish_len;
	/**
	 * The url of the json file of compulsory dish.
	 */
    CompulsoryFile compulsoryfile ;
	/**
	 * CompulsoryInfo constructor without parameter.
	 * Process the information.
	 */
    public CompulsoryInfo() {
		compulsoryfile = new CompulsoryFile();
		dish_str = compulsoryfile.getDish_str();
		option_len = compulsoryfile.getOption_len();
		option_str = compulsoryfile.getOption_str();
		availability = compulsoryfile.getAvailability();
		dish_len = compulsoryfile.getDish_len();
	}
}
