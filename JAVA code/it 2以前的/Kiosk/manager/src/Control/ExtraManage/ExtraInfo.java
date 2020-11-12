package Control.ExtraManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: ExtraInfo.java 
 * packageName: Control.ExtraManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import java.io.IOException;

import Control.FileManage.*;
import Entity.Extra;

/**
 * ClassName: ExtraInfo<br>
 * Description: This is the information class that used to control<br>
 * the information about the extra dishes read from file
 * @version V2.0
 */
public class ExtraInfo {
	/**the file control class used to operate on .json file*/
	public  ExtraFile extrafile = new ExtraFile();
	
	/**
	* Used to get the array that contains all the extra dishes' information
	* @return Extra[] the array of object Extra which contains the info of extra dishes
	* @throws IOException when read info about extra dishes from file failed
	*/
	public Extra[] getExtraInfo() throws IOException {
				return extrafile.getExtraInfo();
	}
	
	/**
	* Used to get the total number of extra dishes
	* @return int the number of existing extra dishes
	*/
	public int getExtraNumber() {
		return extrafile.getLength();
	}
}
