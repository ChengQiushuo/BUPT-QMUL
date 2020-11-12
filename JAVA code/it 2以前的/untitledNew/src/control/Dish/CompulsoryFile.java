package control.Dish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import control.json;

public class CompulsoryFile implements json {
    private String dish_url = "./dish/compulsory.json";
    public  String[] dish_str = new String[9];
    public  int[] option_len = new int[9];
    public  String[][] option_str = new String[9][6];
    public  String[][] availability = new String[9][6];
    public  int dish_len;
    public String[] getDish_str() {
		return dish_str;
	}
	public void setDish_str(String[] dish_str) {
		this.dish_str = dish_str;
	}
	
	public int[] getOption_len() {
		return option_len;
	}
	public void setOption_len(int[] option_len) {
		this.option_len = option_len;
	}
	public String[][] getOption_str() {
		return option_str;
	}
	public void setOption_str(String[][] option_str) {
		this.option_str = option_str;
	}
	public String[][] getAvailability() {
		return availability;
	}
	public void setAvailability(String[][] availability) {
		this.availability = availability;
	}
	public int getDish_len() {
		return dish_len;
	}
	public void setDish_len(int dish_len) {
		this.dish_len = dish_len;
	}
	
	  public CompulsoryFile() {

	        JSONObject dish = json(dish_url);
	        JSONArray dishes = dish.getJSONArray("dishes");
	        dish_len = dishes.length();

	        for(int i=0; i<dish_len; i++) {
	            JSONObject obj_i = (JSONObject)dishes.get(i);
	            dish_str[i] = obj_i.getString("name");
	            JSONArray options = obj_i.getJSONArray("option");
	            option_len[i] = options.length();
	            for(int j=0; j<option_len[i]; j++) {
	                JSONObject obj_j = (JSONObject)options.get(j);
	                option_str[i][j] = obj_j.getString("item");
	                availability[i][j] = obj_j.getString("availability");
	            }
	        }

	        /*System.out.println(dish_len);
	        for(int i=0; i<8; i++) {
	            System.out.print(option_len[i]+" ");
	        }
	        System.out.println(option_len[8]);
	        for(int i=0; i<9; i++) {
	            for(int j=0; j<5; j++) {
	                System.out.print(availability[i][j]+" ");
	            }
	            System.out.println(availability[i][5]);
	        }*/
	    }
	  @Override
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
