package control;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class Payment {
    private  String paymentFile = "./file/payment.json";
    private String[] payments = new String[5];
    private String[] availability = new String[5];
    private JSONArray items;
    private int length=0;
	public Payment() {
		  length = 0;
        JSONObject dataJson1 = json(paymentFile);
        items = dataJson1.getJSONArray("payments");
       for (int i = 0; i < items.length(); i++) {
           JSONObject obj = items.getJSONObject(i);
           payments[i] = obj.getString("name");
           availability[i] = obj.getString("availability");           
           length++;
       }
	}
	  public String[] getPayments() {
		return payments;
	}
	public void setPayments(String[] payments) {
		this.payments = payments;
	}
	public String[] getAvailability() {
		return availability;
	}
	public void setAvailability(String[] availability) {
		this.availability = availability;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
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
	            System.out.println("membership.json-pay_in");
	        }
	        return dataJson;
	    }
}
