package Control.FileManage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.text.DecimalFormat;
import Entity.Extra;
public class ExtraFile {
	private JSONObject extra;
	private JSONObject dish;
	private JSONArray  extra_dishes;
    private String extra_url = "./extra.json";
    int m = 0;
    private int Extralength = 0;
    private Extra[] extraArr;
    public ExtraFile() {
    	  String extra_temp = "";
          String extra_string = "";
          FileReader extra_fr;
		try {
			extra_fr = new FileReader(extra_url);
			 BufferedReader extra_br = new BufferedReader(extra_fr);
	          while ((extra_temp=extra_br.readLine())!=null) {
	              extra_string = extra_string + extra_temp + "\n";
	          }
	          extra = new JSONObject(extra_string);
	          extra_dishes = extra.getJSONArray("dishes");
	          Extralength = extra_dishes.length();
	          extraArr = new Extra[10];
	          for(m=0; m<extra_dishes.length(); m++) {
	              JSONObject obj = (JSONObject)extra_dishes.get(m);
	              Extra extraObj = new Extra(obj.getString("dishID"),obj.getString("name"),obj.getDouble("price"),obj.getString("availability"));
	              extraArr[m] = extraObj;
	          }

	          for(; m<10; m++) {
	          	 Extra  extraObj = new  Extra ();
	               extraArr[m] = extraObj;
	          }

	          extra_br.close();
	          extra_fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    	
    }
    public  Extra[] getExtraInfo() throws IOException {
 
      
        return extraArr;
    }
    public int getLength() {
    	return this.Extralength;
    }
    
    public void AddExtra(String name,String price) throws IOException {   
		String index;
		int number;	
		String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr = new FileReader(extra_url);
        BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
        while ((compulsory_temp=compulsory_br.readLine())!=null) {
            compulsory_string = compulsory_string + compulsory_temp + "\n";
        }
        compulsory_br.close();
        JSONObject compulsory = new JSONObject(compulsory_string);
        JSONArray compulsorydishes = compulsory.getJSONArray("dishes");
        number=compulsorydishes.length()+1;
        if(number<=9) {
        	index="0"+number;
        }else {
        	index=""+number;
        }           
        Double d= Double.parseDouble(price);
		DecimalFormat df = new DecimalFormat("0.00");
		String s=df.format(d);
		String jsonStr = "{\"dishID\":\"extra"+index+"\",\"name\":\""+name+"\",\"price\":\""+s+"\",\"availability\":\"Yes\"}";
        JSONObject json1 = new JSONObject(jsonStr);
        compulsorydishes.put(json1);    
        try {
            FileWriter fw = new FileWriter(extra_url);
            PrintWriter pw = new PrintWriter(fw);
            String str[] = compulsory.toString().split(",");
            int i;
            for(i=0; i<str.length-1; i++) {
                pw.println(str[i]+",");
            }
            pw.println(str[i]);
            pw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void DeleteExtra(int index) {
    	extra_dishes.remove(index);
    	  try {
              FileWriter fw = new FileWriter(extra_url);
              PrintWriter pw = new PrintWriter(fw);
              String str[] = extra.toString().split(",");
              int i;
              for(i=0; i<str.length-1; i++) {
                  pw.println(str[i]+",");
              }
              pw.println(str[i]);
              pw.close();
              fw.close();
          } catch (IOException ex) {
              ex.printStackTrace();
          }   	
    }
    public void SetExtra(int index,String price,String Availability) {
    	  dish = (JSONObject)extra_dishes.get(index);
    	  System.out.println(price);
    	  System.out.println(Availability);
    	  dish.put("price", Double.parseDouble(price));
          dish.put("availability", Availability);
    	  try {
              FileWriter fw = new FileWriter(extra_url);
              PrintWriter pw = new PrintWriter(fw);
              String str[] = extra.toString().split(",");
              int i;
              for(i=0; i<str.length-1; i++) {
                  pw.println(str[i]+",");
              }
              pw.println(str[i]);
              pw.close();
              fw.close();
          } catch (IOException ex) {
              ex.printStackTrace();
          }   	
    }
}
