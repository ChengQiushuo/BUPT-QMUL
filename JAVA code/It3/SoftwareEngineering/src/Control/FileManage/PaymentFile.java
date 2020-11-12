package Control.FileManage;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import Entity.Payment;

public class PaymentFile {
	private JSONArray items;
	private String jsonFile = "./payment.json";
	private int paymentNum = 0;
	private JSONObject Data;
    private String[] item = new String[5];
	private String[] availability = new String[5];
	private Payment[] paymentArr;
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
	public Payment[] getPaymentInfo(){
    	
    	return paymentArr;
    }
    public int getPaymentNum() {
    	return this.paymentNum;
    }
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
