package control;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.DecimalFormat;
import java.io.*;
import control.json;
public class ExtraFile implements json{
	 public JSONArray jsonArray;
	 public String[] dishName = new String[7];
	 public double[] dishPrice = new double[7];
	 public String[] availability = new String[7];
	 public int length = 0;
	 public  String jsonFile = "./dish/extra.json";
	 DecimalFormat df   = new DecimalFormat("######0.00");
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
    	 
     public String[] getDishName() {
		 return dishName;
	 }
     public double[] getDishPrice() {
    	 return dishPrice;
     }
     public String[] getAvailability() {
		 return availability;
	 }
     public int getLength() {
    	 return length;
     }
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

