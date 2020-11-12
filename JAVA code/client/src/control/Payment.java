package control;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Title        : Payment.java
 * Description  : This class is used for reading payment information.
 * @author      : Jindong Ma
 * @author 		: Zhenming Hu
 * @version     : 1.2
 */
public class Payment {
	/**
	 * The url of the json file of payment.
	 */
    private  String paymentFile = "../jsonfile/payment.json";
    private String[] payments = new String[5];
    private String[] availability = new String[5];
    private JSONArray items;
    private int length=0;
	/**
	 * Payment constructor without parameter.
	 * Process the information.
	 */
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
	/**
	 * Getters.
	 */
	public String[] getPayments() {
		return payments;
	}
	/**
	 * Setters.
	 */
	public void setPayments(String[] payments) {
		this.payments = payments;
	}
	/**
	 * Getters.
	 */
	public String[] getAvailability() {
		return availability;
	}
	/**
	 * Setters.
	 */
	public void setAvailability(String[] availability) {
		this.availability = availability;
	}
	/**
	 * Getters.
	 */
	public int getLength() {
		return length;
	}
	/**
	 * Setters.
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * method: JSONObject json(file)
	 * This method is used for reading payment information.
	 * @param file The url of payment.
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
	            System.out.println("membership.json-pay_in");
	        }
	        return dataJson;
	    }
}
