package Control.CompulsoryManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: ModifyCompulsory.java 
 * packageName: Control.CompulsoryManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import java.io.IOException;
import Control.FileManage.*;

/**
 * ClassName: ModifyCompulsory<br>
 * Description: This is the control class that used to control<br>
 * the compulsory dishes. Like adding dishes, deleting dishes, adding options etc.
 * @version V2.0
 */
public class ModifyCompulsory {
	/**the file control class used to operating on .json file*/
	public  CompulsoryFile compulsoryfile = new CompulsoryFile();
	
	/**
	* This constructor is used to do nothing
	*/
	public ModifyCompulsory() {
		
	}

	/**
	* Used to add a compulsory dish with simple options(Yes or No)<br>
	* by calling the control file class
	* @param name the name of the compulsory dish
	*/
	public void AddSimpleOption(String name) {
		try {
			compulsoryfile.addSimpleOption(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Used to add a compulsory dish with ranking options(high, medium, low)<br>
	* by calling the control file class
	* @param name the name of the compulsory dish
	* @param item1 the name of the high level option
	* @param item2 the name of the medium level option
	* @param item3 the name of the low level option
	*/
	public void AddRankingOption(String name,String item1,String item2,String item3) {
		try {
			compulsoryfile.addRankingOptions(name,item1,item2,item3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	* Used to add an extra option to the compulsory dish by calling the control file class
	* @param index the index of a compulsory dish in the compulsory dishes info array
	* @param name the extra option's name
	* @param availability the availability of the extra option(Yes or No)
	*/
	public  void AddExtraOption(int index ,String name,String availability) {
		try {
			compulsoryfile.AddExtraOption(index,name,availability);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Used to delete a compulsory dish by calling the control file class
	* @param index the index of the compulsory dish in the compulsory dishes info array
	*/
	public void DeleteCompulsory(int index) {	
			compulsoryfile.DeleteCompulsory(index);		
	}
	
	/**
	* Used to delete a compulsory dish's single option by calling the control file class
	* @param index the index of option that wants to delete in the array of options
	*/
	public void DeleteCompulsoryOption(int index,int num) {	
		compulsoryfile.DeleteCompulsoryOption(index,num);		
	}
	
	/**
	* Used to set options' availability status by calling the control file class
	* @param Availability the array of the availability information about all the options that one dish has
	*/
	public void setOption(int index,String[] Availability) {
		compulsoryfile.setOption(index,Availability);
	}
	
}
