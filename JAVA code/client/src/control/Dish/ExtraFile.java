package control.Dish;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.DecimalFormat;
import java.io.*;
import control.json;

/**
 * Title        : ExtraFile.java
 * Description  : This class is used for reading extra dish information.
 * @author      : Jiaqi Zhang
 * @author      : Yutong Hu
 * @version     : 1.1
 */
public class ExtraFile implements json{
	 public JSONArray jsonArray;
	 public String[] dishName = new String[7];
	 public double[] dishPrice = new double[7];
	 public String[] availability = new String[7];
	 public int length = 0;
    /**
     * The url of the json file of extra dish.
     */
	 public  String jsonFile = "../jsonfile/extra.json";
    /**
     * Control decimal format.
     */
	 DecimalFormat df   = new DecimalFormat("######0.00");
    /**
     * ExtraFile constructor without parameter.
     * Process the information.
     */
	 public ExtraFile() {
		 JSONObject dataJson = json(jsonFile);
	     jsonArray = dataJson.getJSONArray("dishes");
	        for (int count = 0; count < jsonArray.length(); count++) {
	            JSONObject info = jsonArray.getJSONObject(count);
	            dishName[count] = info.getString("name");    //dish name	         
	            dishPrice[count] = info.getDouble("price");  //dish price
	            availability[count] = info.getString("availability");  //dish price
	            df.format(dishPrice[count]);
	            length++;
	        }
	 }

    /**
     * Getters.
     */
	 public String[] getDishName() {
		 return dishName;
	 }
    /**
     * Getters.
     */

     public double[] getDishPrice() {
    	 return dishPrice;
     }
    /**
     * Getters.
     */
     public String[] getAvailability() {
		 return availability;
	 }
    /**
     * Getters.
     */
     public int getLength() {
    	 return length;
     }
    /**
     * method: json(file)
     * This method is used for reading extra information.
     * @param file The url of extra.
     * @return The information of Json format.
     */
     public JSONObject json(String file) {
         String l;
         String str;
         String data = "";
         JSONObject dataJson = null;
         try {
             FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             while ((str=br.readLine())!=null) {
                 data = data + str + "\n";
             }
             dataJson= new JSONObject(data);
             br.close();
             fr.close();
         }
         catch (Exception error) {
             System.out.println("");
         }
         return dataJson;
     }
  }

