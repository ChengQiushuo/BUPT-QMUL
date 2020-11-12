package Control.FileManage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import Entity.Compulsory;

public class CompulsoryFile {
	private JSONObject compulsory;
	private JSONArray  compulsory_dishes;
    private JSONArray items;
    private String[] item ;
    private String[] availability;
    private String compulsory_url = "./compulsory.json";
    int i = 0;
    private int Comlength = 0;
    private int[] Optionlength= {0,0,0,0,0,0,0,0,0};
    Compulsory[] compulsoryArr;
    public CompulsoryFile() {
    	String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr;
		try {
			compulsory_fr = new FileReader(compulsory_url);
			 BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
		        while ((compulsory_temp=compulsory_br.readLine())!=null) {
		            compulsory_string = compulsory_string + compulsory_temp + "\n";
		        }
		        compulsory = new JSONObject(compulsory_string);
		        compulsory_dishes = compulsory.getJSONArray("dishes");
		        compulsoryArr = new Compulsory[15];
		        Comlength = compulsory_dishes.length();
		        for(i=0; i<compulsory_dishes.length(); i++) {
		            JSONObject obj = (JSONObject)compulsory_dishes.get(i);
		            items = obj.getJSONArray("option");
		            item = new String[9];
		            availability = new String[9];
		            Optionlength[i] = items.length(); 
		            for(int k=0; k<items.length(); k++) {
		                JSONObject obj2 = (JSONObject)items.get(k);
		                item[k] = obj2.getString("item");
		                availability[k] = obj2.getString("availability");
		            }
		            Compulsory compulsoryObj = new Compulsory(obj.getString("dishID"),obj.getString("name"),item,availability);
		            
		            compulsoryArr[i] = compulsoryObj;
		        }

		        for(; i<15; i++) {
		            Compulsory compulsoryObj = new Compulsory();
		            compulsoryArr[i] = compulsoryObj;
		        }
		     
		        compulsory_br.close();
		        compulsory_fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
    public  Compulsory[] getCompulsoryInfo() throws IOException {
 
        
        return compulsoryArr;
    }
    public int getLength() {
    	return this.Comlength;
    }
    public int getOptionLength(int index) {
    	return this.Optionlength[index];
    }
    public void addSimpleOption(String name) throws IOException {
    	String index;
		int number;		
		String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr = new FileReader(compulsory_url);
        BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
        while ((compulsory_temp=compulsory_br.readLine())!=null) {
            compulsory_string = compulsory_string + compulsory_temp + "\n";
        }
        compulsory_br.close();
        compulsory_fr.close();
        
        JSONObject compulsory = new JSONObject(compulsory_string);
        JSONArray compulsorydishes = compulsory.getJSONArray("dishes");
        number=compulsorydishes.length()+1;
        if(number<=9) {
        	index="0"+number;
        }else {
        	index=""+number;
        }
        String jsonStr = "{\"dishID\":\"compulsory"+index+"\",\"name\":\""+name+"\",\"option\":[{\"item\":\"Yes"+"\",\"availability\":\"Yes\"},{\"item\":\"No"+"\",\"availability\":\"Yes\"}]}";
        JSONObject json1 = new JSONObject(jsonStr);
        compulsorydishes.put(json1);
        
        try {
            FileWriter fw = new FileWriter(compulsory_url);
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
    
    public void addRankingOptions(String name,String item1,String item2,String item3) throws IOException {
  
		String index;
		int number;
		
		String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr = new FileReader(compulsory_url);
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
        String jsonStr = "{\"dishID\":\"compulsory"+index+"\",\"name\":\""+name+"\","+"\"option\":[{\"item\":\""+item1+"\",\"availability\":\"Yes\"},{\"item\":\""+item2+"\",\"availability\":\"Yes\"},{\"item\":\""+item3+"\",\"availability\":\"Yes\"}]}";
        JSONObject json1 = new JSONObject(jsonStr);
        compulsorydishes.put(json1);
        
        try {
            FileWriter fw = new FileWriter(compulsory_url);
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
    public void AddExtraOption(int index,String name,String availability1) throws IOException{
    	String jsonStr = "{\"item\":\""+name+"\",\"availability\":\""+availability1+"\"}";		
		String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr = new FileReader(compulsory_url);
        BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
        while ((compulsory_temp=compulsory_br.readLine())!=null) {
            compulsory_string = compulsory_string + compulsory_temp + "\n";
        }
        compulsory_br.close();
        JSONObject compulsory = new JSONObject(compulsory_string);
        JSONArray compulsorydishes = compulsory.getJSONArray("dishes");
        JSONObject dish=compulsorydishes.getJSONObject(index);
        JSONArray option=dish.getJSONArray("option");
        JSONObject json1 = new JSONObject(jsonStr);
        option.put(json1);
        
        try {
            FileWriter fw = new FileWriter(compulsory_url);
            PrintWriter pw = new PrintWriter(fw);
            String str[] = compulsory.toString().split(",");
            int m;
            for(m=0; m<str.length-1; m++) {
                pw.println(str[m]+",");
            }
            pw.println(str[m]);
            pw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void DeleteCompulsory(int index) {
    	compulsory_dishes.remove(index);
    	 try {
             FileWriter fw = new FileWriter(compulsory_url);
             PrintWriter pw = new PrintWriter(fw);
             String str[] = compulsory.toString().split(",");
             int l;
             for(l=0; l<str.length-1; l++) {
                 pw.println(str[l]+",");
             }
             pw.println(str[l]);
             pw.close();
             fw.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }
    public void DeleteCompulsoryOption(int index) {
    	 items.remove(index);
    	 try {
             FileWriter fw = new FileWriter(compulsory_url);
             PrintWriter pw = new PrintWriter(fw);
             String str[] = compulsory.toString().split(",");
             int l;
             for(l=0; l<str.length-1; l++) {
                 pw.println(str[l]+",");
             }
             pw.println(str[l]);
             pw.close();
             fw.close();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }
    
    public void setOption(String[] Availability) {
        switch (items.length()) {
//        case 9:
//            ((JSONObject)items.get(8)).put("availability", availability[8]);
//
//        case 8:
//            ((JSONObject)items.get(7)).put("availability", availability[7]);
//
//        case 7:
//            ((JSONObject)items.get(6)).put("availability", availability[6]);

        case 6:
            ((JSONObject)items.get(5)).put("availability", Availability[5]);

        case 5:
            ((JSONObject)items.get(4)).put("availability", Availability[4]);

        case 4:
            ((JSONObject)items.get(3)).put("availability", Availability[3]);

        case 3:
            ((JSONObject)items.get(2)).put("availability", Availability[2]);

        case 2:
            ((JSONObject)items.get(1)).put("availability", Availability[1]);

        case 1:     	
            ((JSONObject)items.get(0)).put("availability", Availability[0]);
            
            try {
                FileWriter fw = new FileWriter(compulsory_url);
                PrintWriter pw = new PrintWriter(fw);
                String str[] = compulsory.toString().split(",");
                int n;
                for(n=0; n<str.length-1; n++) {
                    pw.println(str[n]+",");
                }
                pw.println(str[n]);
                pw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
       
            break;

        default:
            System.out.println("---File ERROR---");
    }
    }
}
