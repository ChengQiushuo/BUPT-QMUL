package Control.FileManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: CompulsoryFile.java 
 * packageName: Control.FileManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import Entity.Compulsory;

/**
 * ClassName: CompulsoryFile<br>
 * Description: This is the control class that used to operate on<br>
 * the 'compulsory.json' file which contains all the information about compulsory dishes in json format.
 * @version V2.0
 */
public class CompulsoryFile {
	private JSONObject compulsory;
	private JSONArray  compulsory_dishes;
    private JSONArray items;
    private JSONArray[] Items = new JSONArray[9];
    private String[] item ;
    private String[] availability;
    //private String compulsory_url = "./compulsory.json";
    private String compulsory_url = "../jsonfile/compulsory.json";
    int i = 0;
    private int Comlength = 0;
    private int[] Optionlength= {0,0,0,0,0,0,0,0,0};
    Compulsory[] compulsoryArr;
    
    /**
	* This constructor used to read all the information about compulsory dishes from json file<br>
	* and store them into Compulsory[] which is the array of Compulsory objects.
	*/
    public CompulsoryFile() 
    {	
//    	for(int j =0 ; j<9; j++) {
//    		Items[j] = new JSONArray();
//    	}
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
		        for(i=0; i<compulsory_dishes.length(); i++) 
		        {
		            JSONObject obj = (JSONObject)compulsory_dishes.get(i);
		            items = obj.getJSONArray("option");
		            Items[i] = items;
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
			e.printStackTrace();
		}
       
    }
    
    
    /**
	* Used to get the object array of compulsory dishes which contains all the information about compulsory dishes
	* @return Compulsory[] the object array of compulsory dishes
	*/
    public Compulsory[] getCompulsoryInfo() 
    {
            return compulsoryArr;
    }

    /**
	* Used to get the number of compulsory dishes
	* @return int the number of compulsory dishes
	*/
    public int getLength() 
    {
    	return this.Comlength;
    }
    
    /**
	* Used to get the number of a compulsory dish's options
	* @param index the index of a compulsory dish
	* @return int the number of a compulsory dish's options
	*/
    public int getOptionLength(int index) {
    	return this.Optionlength[index];
    }
    
    /**
	* Used to add a compulsory dish with simple options(Yes or No)
	* @param name the name of the compulsory dish
	* @throws IOException when read/write info about compulsory dishes from/to file failed
	*/
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
    
    /**
	* Used to add a compulsory dish with ranking options(high, medium, low)
	* @param name the name of the compulsory dish
	* @param item1 the name of the high level option
	* @param item2 the name of the medium level option
	* @param item3 the name of the low level option
	* @throws IOException when read/write info about compulsory dishes from/to file failed
	*/
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
    
    /**
	* Used to add an extra option to the compulsory dish
	* @param index the index of a compulsory dish in the compulsory dishes info array
	* @param name the extra option's name
	* @param availability1 the availability of the extra option(Yes or No)
	* @throws IOException when read/write info about compulsory dishes from/to file failed
	*/
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
    
    /**
	* Used to delete a compulsory dish
	* @param index the index of the compulsory dish in the compulsory dishes info array
	*/
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
    
    /**
	* Used to delete a compulsory dish's single option
	* @param index the index of option that wants to delete in the array of options
	*/
    public void DeleteCompulsoryOption(int index,int num) {
    	 System.out.println(index);
    	 System.out.println(Items[index]);
    	 Items[index].remove(num);
    	 System.out.println(Items[index]);
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
    
    /**
	* Used to set options' availability status
	* @param Availability the array of the availability information about all the options that one dish has
	*/
    public void setOption(int index,String[] Availability) {
        switch (Items[index].length()) {
        case 6:
            ((JSONObject)Items[index].get(5)).put("availability", Availability[5]);

        case 5:
            ((JSONObject)Items[index].get(4)).put("availability", Availability[4]);

        case 4:
            ((JSONObject)Items[index].get(3)).put("availability", Availability[3]);

        case 3:
            ((JSONObject)Items[index].get(2)).put("availability", Availability[2]);

        case 2:
            ((JSONObject)Items[index].get(1)).put("availability", Availability[1]);

        case 1:     	
            ((JSONObject)Items[index].get(0)).put("availability", Availability[0]);
            
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
