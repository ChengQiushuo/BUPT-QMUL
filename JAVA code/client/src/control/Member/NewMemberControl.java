package control.Member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONArray;
import org.json.JSONObject;


import entity.NewMember;
/**
 * Title        : NewMemberControl.java
 * Description  : This class is used for processing a new membership.
 * @author      : Yuang Du
 * @author 		: Jindong Ma
 * @version     : 1.1
 */
public class NewMemberControl {
	/**
	 * The url of the json file of membership.
	 */
    public  String jsonFile = "../jsonfile/memberships.json";
    public String num="";
    public String temp_1="";
    public String temp_2="";
    public String temp_3="";
    public String temp_4="";
	/**
	 * NewMemberControl constructor with a parameter.
	 * Process the information.
	 * @param newmember The new membership.
	 */
    public NewMemberControl(NewMember newmember) {
    	num = newmember.getMember_number();
    	temp_1 = newmember.getFirst_name();
    	temp_2 = newmember.getLast_name();
    	temp_3 = newmember.getEmail();
    	temp_4 = newmember.getMobile_number();
    	
    }

	/**
	 * method: void AddNewMember()
	 * This method is used for adding the new membership.
	 */
	public void AddNewMember() {
		  String data="";
          String str;
          try {
               
              FileReader fr = new FileReader(jsonFile);
              BufferedReader br = new BufferedReader(fr);
              while ((str=br.readLine())!=null) {
                  data = data + str + "\n";
              }                     
              JSONObject dataJson = new JSONObject(data);
              JSONArray jsonArray = dataJson.getJSONArray("members");
              br.close();
              BufferedWriter bw=new BufferedWriter(new FileWriter(jsonFile));
              if(temp_3.length()==0) {
              	JSONObject object=new JSONObject();
              	JSONObject member=new JSONObject();
              	member.put("member_number", num);
              	member.put("first_name", temp_1);
              	member.put("last_name", temp_2);
              	member.put("mobile_number", temp_4);	
              	member.put("stamp", "0");
              	
              	jsonArray.put(member);
              	
              	object.put("members", jsonArray);
              	String jsonString = object.toString();
           
              	bw.write(jsonString);	
              	bw.close();
              
              }
              else if(temp_4.length()==0) {
              	JSONObject object=new JSONObject();
              	JSONObject member=new JSONObject();
              	member.put("member_number", num);
              	member.put("first_name", temp_1);
              	member.put("last_name", temp_2);
              	member.put("email", temp_3);	
              	member.put("stamp", "0");
              	
              	jsonArray.put(member);
              
              	object.put("members", jsonArray);
              	String jsonString = object.toString();
              	System.out.println("Json string is: "+jsonString);
              	bw.write(jsonString);	
              	bw.close();
              }
              else {
              	JSONObject object=new JSONObject();
              	JSONObject member=new JSONObject();
              	member.put("member_number", num);
              	member.put("first_name", temp_1);
              	member.put("last_name", temp_2);
              	member.put("email", temp_3);	
              	member.put("mobile_number", temp_4);	
              	member.put("stamp", "0");                
              	jsonArray.put(member);               	
              	object.put("members", jsonArray);
              	String jsonString = object.toString();
              	System.out.println("Json string is: "+jsonString);
              	bw.write(jsonString);	
              	bw.close();
              }
             
          }
          catch (Exception error) {
              System.out.println("json.txt");
          }
          pirntDetails();
	}
	
	  public void pirntDetails() {
	        System.out.println("======== email/SMS function <=> print =========");
	        System.out.println("= Your ticket with the registration details:");
	        System.out.println("= Your membership number: " + num);
	        System.out.println("= Your first name: " + temp_1);
	        System.out.println("= Your surname: " + temp_2);
	        System.out.println("= Your email: " + temp_3);
	        System.out.println("= Your mobile number: " + temp_4);
	        System.out.println("= Your stamps: 0");
	        System.out.println("===============================================");
	    }
}
