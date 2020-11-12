package Control.ExtraManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: ModifyExtra.java 
 * packageName: Control.ExtraManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import java.io.IOException;
import Control.FileManage.*;

/**
 * ClassName: ModifyExtra<br>
 * Description: This is the control class that used to control the extra dishes.<br>
 * Like adding dishes, deleting dishes, setting price.
 * @version V2.0
 */
public class ModifyExtra {
	/**the file control class used to operating on .json file*/
	public  ExtraFile extrafile = new ExtraFile();
	/**
	* This constructor is used to do nothing
	*/
    public ModifyExtra() 
    {
		
	}
    
    /**
	* Used to add an extra dish by calling the control file class
	* @param name the name of the compulsory dish
	* @param price the price of this new dish
	*/
	public  void AddExtra(String name,String price) {
	try {
		extrafile.AddExtra(name,price);
	} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	/**
	* Used to delete an extra dish by calling the control file class
	* @param index the index of the extra dish in the extra dishes info array
	*/
	public void DeleteExtra(int index) {
		extrafile.DeleteExtra(index);
	}
	
	/**
	* Used to configure the extra dish's setting, like price and availability
	* @param index the index of the extra dish in the extra dishes info array
	* @param price the price of this dish
	* @param Availability the availability of this dish(Yes or No)
	*/
	public void SetExtra(int index,String price,String Availability) {
		extrafile.SetExtra(index, price, Availability);
	}
}
