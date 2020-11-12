package Control.CompulsoryManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: CompulsoryInfo.java 
 * packageName: Control.CompulsoryManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import java.io.IOException;

import Control.FileManage.*;
import Entity.Compulsory;

/**
 * ClassName: CompulsoryInfo<br>
 * Description: This is the information class that used to control<br>
 * the information about the compulsory dishes read from file
 * @version V2.0
 */
public class CompulsoryInfo {
	/**the file control class used to operating on .json file*/
	public  CompulsoryFile compulsoryfile = new CompulsoryFile();
	
	/**
	* Used to get the array that contains all the compulsory dishes' information
	* @return Compulsory[] the array of object Compulsory which contains the info of compulsory dishes
	* @throws IOException when read info about compulsory dishes from file failed
	*/
	public  Compulsory[] getCompulsoryInfo() throws IOException {
				return compulsoryfile.getCompulsoryInfo();
	}
	
	/**
	* Used to get the total number of compulsory dishes
	* @return int the number of existing compulsory dishes
	*/
	public int getCompulsoryNumber() {
		return compulsoryfile.getLength();
	}
	
	/**
	* Used to get the total number of options that a dish has
	* @param index the index of the dish in the information array
	* @return int the number of options that the dish with index has
	*/
	public int getOptionNumber(int index) {
		return compulsoryfile.getOptionLength(index);
	}
}
