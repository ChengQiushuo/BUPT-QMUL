package Control.FileManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: ReportFile.java 
 * packageName: Control.FileManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import Entity.Report;

/**
 * ClassName: ReportFile<br>
 * Description: This is the control class that used to operate on<br>
 * the 'report' director which contains all the reports about the sales condition in .png format.
 * @version V2.0
 */
public class ReportFile {
	private String filename;
	private JSONObject info;
	private int compulsoryCount;
	private String[] compulsoryName = {"null", "null", "null", "null", "null", "null", "null", "null", "null"};
	private int[] itemCount;
	private String[][] itemName;
	private int[][] itemNumber;
	    
	private int extraCount;
	private String[] dishName;
	private int[] dishNumber;
	
	/**
	* This constructor used to initialize the file operating path
	* @param name the file operating path
	*/
	public ReportFile(String name) {
		this.filename = name;
	}
	
	/**
	* Used to read the sales condition statistics from .json file and<br> 
	* generate the object Report which contains all the information about a report
	* @return Report the object that contains all the information about a report
	* @throws IOException when read info about sales condition statistics from file failed
	*/
	public Report getReportInfo() throws IOException {
			
		String info_temp = "";
	    String info_string = "";

	    FileReader info_fr = new FileReader(filename);
	    BufferedReader info_br = new BufferedReader(info_fr);
	    while ((info_temp=info_br.readLine())!=null) {
	            info_string = info_string + info_temp + "\n";
	    }
	    info = new JSONObject(info_string);
	    info_br.close();
	    info_fr.close();

	    JSONArray compulsoryArray = info.getJSONArray("compulsory");
	    compulsoryCount = compulsoryArray.length();
	    itemCount = new int[compulsoryCount];
	    itemName = new String[compulsoryCount][9];
	    itemNumber = new int[compulsoryCount][9];
	    for(int i=0; i<compulsoryCount; i++) {
	        JSONObject compulsoryObject = (JSONObject)compulsoryArray.get(i);
	        compulsoryName[i] = compulsoryObject.getString("name");
	        JSONArray itemArray = compulsoryObject.getJSONArray("option");
	        itemCount[i] = itemArray.length();
	        for(int j=0; j<itemCount[i]; j++) {
	            JSONObject item = (JSONObject)itemArray.get(j);
	            itemName[i][j] = item.getString("item");
	            itemNumber[i][j] = item.getInt("number");
	        }
	    }

	    JSONArray extraArray = info.getJSONArray("extra");
	    extraCount = extraArray.length();
	    dishName = new String[extraCount];
	    dishNumber = new int[extraCount];
	    for(int i=0; i<extraCount; i++) {
	        JSONObject extraObject = (JSONObject)extraArray.get(i);
	        dishName[i] = extraObject.getString("dish");
	        dishNumber[i] = extraObject.getInt("number");
	    }
	    Report report = new Report();

	    report.setCompulsoryCount(compulsoryCount);
	    report.setCompulsoryName(compulsoryName);
	    report.setDishName(dishName);
	    report.setDishNumber(dishNumber);
	    report.setExtraCount(extraCount);
	    report.setItemCount(itemCount);
	    report.setItemNumber(itemNumber);
	    report.setItemName(itemName);
	    return report;
	}
	
}
