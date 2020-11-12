package control;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class MemberFile {
    public String jsonFile = "./file/memberships.json";
    public String[] member_number = new String[50];
    public int member_length=0;
    public String[] stamps = new String[50];
	public MemberFile() {
		JSONObject dataJson = json(jsonFile);
		
        JSONArray jsonArray = dataJson.getJSONArray("members");
        member_length = jsonArray.length();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject info = jsonArray.getJSONObject(i);
            member_number[i]=info.getString("member_number");
            stamps[i]= info.getString("stamp");
               
        }
	}
	  public String[] getMember_number() {
		return member_number;
	}
	public void setMember_number(String[] member_number) {
		this.member_number = member_number;
	}
	public int getMember_length() {
		return member_length;
	}
	public void setMember_length(int member_length) {
		this.member_length = member_length;
	}
	public String[] getStamps() {
		return stamps;
	}
	public void setStamps(String[] stamps) {
		this.stamps = stamps;
	}
	public JSONObject json(String file) {
	
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
