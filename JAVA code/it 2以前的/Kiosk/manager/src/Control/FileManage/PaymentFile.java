package Control.FileManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: PaymentFile.java 
 * packageName: Control.FileManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import Entity.Payment;

/**
 * ClassName: PaymentFile<br>
 * Description: This is the control class that used to operate on<br>
 * the 'payment.json' file which contains all the information about payment ways in json format.
 * @version V2.0
 */
public class PaymentFile {
	private JSONArray items;
	public String jsonFile = "./payment.json";
	private int paymentNum = 0;
	private JSONObject Data;
    private String[] item = new String[5];
	private String[] availability = new String[5];
	private Payment[] paymentArr;
	
	/**
	* This constructor used to read all the information about payment way from json file<br>
	* and store them into Payment[] which is the array of Payment objects.
	*/
	public PaymentFile() {
		
		String data = "";
        String str;
    	int i = 0 ;
    	paymentArr = new Payment[6];
    	   try {
               FileReader fr = new FileReader(jsonFile);
               BufferedReader br = new BufferedReader(fr);
               while ((str=br.readLine())!=null) {
                   data = data + str + "\n";
               }
                Data = new JSONObject(data);
       
               items = Data.getJSONArray("payments");
               paymentNum = items.length();
               for (i = 0; i < items.length(); i++) {
                   JSONObject obj = items.getJSONObject(i);
                   Payment payment = new Payment(obj.getString("name"),obj.getString("availability"));
                   item[i] = obj.getString("name");
                   availability[i] = obj.getString("availability");
                   paymentArr[i] = payment;
              }

               for(; i<5; i++) {
               	 Payment  paymentObj = new  Payment ();
                    paymentArr[i] = paymentObj;
               }
               br.close();
               fr.close();
               } catch (FileNotFoundException fe) {
                   fe.printStackTrace();
               } catch (IOException ie) {
                   ie.printStackTrace();
               }
	}
	
	/**
	* Used to get the object array of payment which contains all the information about payment ways
	* @return Payment[] the object array of payment ways
	*/
	public Payment[] getPaymentInfo(){
    	
    	return paymentArr;
    }
	
	/**
	* Used to get the number of payment ways
	* @return int the number of payment ways
	*/
    public int getPaymentNum() {
    	return this.paymentNum;
    }
    
    /**
	* Used to set the availability of each payment way
	* @param paymentArr the object array of payment ways
	*/
    public void modifyPayment(Payment[] paymentArr) {
    	  for(int j =0;j<paymentNum;j++) {
    		  ((JSONObject)items.get(j)).put("availability",paymentArr[j].getAvailability());
    	  }
    	  try {
              FileWriter fw = new FileWriter(jsonFile);
              PrintWriter pw = new PrintWriter(fw);
          
              String str[] = Data.toString().split(",");
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
	* Used to delete a payment way
	* @param num the index of this payment way in the object array of payment ways
	*/
    public void deletePayment(int num) {
    	items.remove(num);
    	  try {
              FileWriter fw = new FileWriter(jsonFile);
              PrintWriter pw = new PrintWriter(fw);
              String str[] = Data.toString().split(",");
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
	* Used to add a payment way
	* @param name the name of the new payment way
	*/
    public void addPayment(String name) {
    	   String data="";
           String str;
           try {     
               FileReader fr = new FileReader(jsonFile);
               BufferedReader br = new BufferedReader(fr);
               while ((str=br.readLine())!=null) {
                   data = data + str + "\n";
               }                     
               JSONObject dataJson = new JSONObject(data);
               JSONArray jsonArray = dataJson.getJSONArray("payments");
               br.close();
               FileWriter fw = new FileWriter(jsonFile);
               PrintWriter pw = new PrintWriter(fw);
               
               	JSONObject payment=new JSONObject();
               	payment.put("name", name);
               	payment.put("availability","Yes");                     	
               	jsonArray.put(payment);            	
               	dataJson.put("payments", jsonArray);
               	String jsonString = dataJson.toString();    
 
                String str1[] = jsonString.toString().split(",");
                int i;
                for(i=0; i<str1.length-1; i++) {
                    pw.println(str1[i]+",");
                }
                pw.println(str1[i]);
                pw.close();
                fw.close();
           }
           catch (Exception error) {
               System.out.println("json.txt");
           }
    }

}
