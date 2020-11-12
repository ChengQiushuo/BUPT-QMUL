package Control.ReportManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: ReportInfo.java 
 * packageName: Control.ReportManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import Control.FileManage.ReportFile;
import java.io.IOException;
import Entity.Report;

/**
 * ClassName: ReportInfo<br>
 * Description: This is the information class that used to control<br>
 * the information about the reports read from file
 * @version V2.0
 */
public class ReportInfo {

	private ReportFile reportfile;
	
	/**
	* This constructor used to initialize the file operating path
	* @param name the file operating path
	*/
	public ReportInfo(String name) {

		reportfile = new ReportFile(name);
	}

	/**
	* Used to read the sales condition statistics from .json file and<br> 
	* generate the object Report which contains all the information about a report by calling control file class
	* @return Report the object that contains all the information about a report
	* @throws IOException when read info about sales condition statistics from file failed
	*/
	public  Report getReportInfo() throws IOException {
		return reportfile.getReportInfo();
	}
}
