package control.Member;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Title        : MemberFile.java
 * Description  : This class is used for processing membership information.
 * @author      : Hu Zhenming
 * @author 		: Qiushuo Cheng
 * @version     : 1.1
 */
public class MemberFile {
	/**
	 * The url of the json file of membership.
	 */
    public String jsonFile = "../jsonfile//memberships.json";
    public String[] member_number = new String[50];
    public int member_length=0;
    public String[] stamps = new String[50];
	/**
	 * MemberFile constructor without parameter.
	 * Process the information.
	 */
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
	/**
	 * Getters.
	 */
	public String[] getMember_number() {
		return member_number;
	}
	/**
	 * Setters.
	 */
	public void setMember_number(String[] member_number) {
		this.member_number = member_number;
	}
	/**
	 * Getters.
	 */
	public int getMember_length() {
		return member_length;
	}
	/**
	 * Setters.
	 */
	public void setMember_length(int member_length) {
		this.member_length = member_length;
	}
	/**
	 * Getters.
	 */
	public String[] getStamps() {
		return stamps;
	}
	/**
	 * Setters.
	 */
	public void setStamps(String[] stamps) {
		this.stamps = stamps;
	}
	/**
	 * method: json(file)
	 * This method is used for reading membership information.
	 * @param file The url of membership.
	 * @return The information of Json format.
	 */
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
