package control;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import boundary.Detail;
import boundary.LogIn;
import entity.ExtraInfo;
import entity.RamenInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Title        : Order.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Order {
    private String order_file = "./file/order/";
    public static String temp_file = "./file/temp.txt";
    entity.RamenInfo RamenInfo;
    ExtraInfo ExtraInfo;
    /**
     * Constructor with parameters.
     * @param payment The way of the payment.
     */
    public Order(String payment, RamenInfo RamenInfos,ExtraInfo extraInfos) {
        RamenInfo = RamenInfos;
        ExtraInfo = extraInfos;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date d = new Date();
        String url = order_file + sdf.format(d) + "_no.txt";
       
        try {
            FileWriter fw = new FileWriter(url);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Payment - " + payment);
   
            switch (RamenInfo.ramen) {
                case 1:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    break;

                case 2:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    break;

                case 3:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    pw.println("Ramen 3: " + RamenInfo.ramenOrder[2] + "  ==>  " + Detail.item);
                    break;

                case 4:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    pw.println("Ramen 3: " + RamenInfo.ramenOrder[2] + "  ==>  " + Detail.item);
                    pw.println("Ramen 4: " + RamenInfo.ramenOrder[3] + "  ==>  " + Detail.item);
                    break;

                case 5:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    pw.println("Ramen 3: " + RamenInfo.ramenOrder[2] + "  ==>  " + Detail.item);
                    pw.println("Ramen 4: " + RamenInfo.ramenOrder[3] + "  ==>  " + Detail.item);
                    pw.println("Ramen 5: " + RamenInfo.ramenOrder[4] + "  ==>  " + Detail.item);
                    break;

                default:
                    System.out.println("---ERROR - Order--");
            }
            if(ExtraInfo.extraCount[0]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[0]+": " + ExtraInfo.extraCount[0]);
                }
                else {
                    pw.println(ExtraInfo.dishName[0]+": " + ExtraInfo.extraCount[0] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[1]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[1]+": " + ExtraInfo.extraCount[1]);
                }
                else {
                    pw.println(ExtraInfo.dishName[1]+": " + ExtraInfo.extraCount[1] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[2]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[2]+": " + ExtraInfo.extraCount[2]);
                }
                else {
                    pw.println(ExtraInfo.dishName[2]+": " + ExtraInfo.extraCount[2] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[3]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[3]+": " + ExtraInfo.extraCount[3]);
                }
                else {
                    pw.println(ExtraInfo.dishName[3]+": " + ExtraInfo.extraCount[3] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[4]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[4]+": " + ExtraInfo.extraCount[4]);
                }
                else {
                    pw.println(ExtraInfo.dishName[4]+": " + ExtraInfo.extraCount[4] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[5]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[5]+": " + ExtraInfo.extraCount[5]);
                }
                else {
                    pw.println(ExtraInfo.dishName[5]+": " + ExtraInfo.extraCount[5] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[6]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[6]+": " + ExtraInfo.extraCount[6]);
                }
                else {
                    pw.println(ExtraInfo.dishName[6]+": " + ExtraInfo.extraCount[6] + " ==> " + Detail.item);
                }
            }
            
            pw.println("Cost: £" + String.format("%.2f", calculatePrice()));
            pw.close();
            fw.close();
        }
        catch (Exception error) {
            System.out.println("order.txt");
        }
        RamenInfo.ramen = 0;
        for(int i=0;i<7;i++) {
            ExtraInfo.dishName[i]=null;
        	ExtraInfo.extraCount[i]=0;
        	ExtraInfo.dishPrice[i]=0.0;
        }
        RamenInfo.ramenOrder[0] = null;
        RamenInfo.ramenOrder[1] = null;
        RamenInfo.ramenOrder[2] = null;
        RamenInfo.ramenOrder[3] = null;
        RamenInfo.ramenOrder[4] = null;
    }

    /**
     * Constructor with parameters.
     * @param payment The way of the payment.
     * @param number The membership number.
     */
    public Order(String payment, String number, RamenInfo RamenInfos,ExtraInfo extraInfos) throws IOException {
        RamenInfo = RamenInfos;
        ExtraInfo  = extraInfos;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date d = new Date();
        String url = order_file + sdf.format(d) + "_" + number + ".txt";
        String data = "";
        String str;
        String member_num="";
//        String first_name="";
//        String last_name="";
//        String email="";
//        String mobile="";
        String stamps="";
        try {

        	 FileReader fr = new FileReader(LogIn.jsonFile);
             BufferedReader br = new BufferedReader(fr);
             while ((str=br.readLine())!=null) {
                 data = data + str + "\n";
             }
             JSONObject dataJson = new JSONObject(data);
             JSONArray jsonArray = dataJson.getJSONArray("members");
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject info = jsonArray.getJSONObject(i);
                 if(info.getString("member_number").equals(number)) {
                     member_num=info.getString("member_number");
//                     first_name=info.getString("first_name");
//                     last_name=info.getString("last_name");
//                     email=info.getString("email");
//                     mobile=info.getString("mobile_number");
                     stamps=info.getString("stamp");
                     System.out.println(info);
                     break;
                 }
             }
             br.close();
             fr.close();
        	
        }
        catch (Exception error) {
            System.out.println("complex111 error");
        }

        try {
            FileWriter fw = new FileWriter(url);
            PrintWriter pw = new PrintWriter(fw);
            System.out.println();
            pw.println(number);
            if(RamenInfo.ramen>0&&Integer.parseInt(stamps)>=10&&ExtraInfo.extraCount[0]==0&&ExtraInfo.extraCount[1]==0&&ExtraInfo.extraCount[2]==0&&ExtraInfo.extraCount[3]==0&&ExtraInfo.extraCount[4]==0&&ExtraInfo.extraCount[5]==0&&ExtraInfo.extraCount[6]==0) {
                pw.println("Payment - Stamps");
            }
            else if(RamenInfo.ramen>0&&Integer.parseInt(stamps)>=10) {
                pw.println("Payment - Stamps & " + payment);
            }
            else {
                pw.println("Payment - " + payment);
            }
            switch (RamenInfo.ramen) {
                case 1:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    break;

                case 2:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    break;

                case 3:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    pw.println("Ramen 3: " + RamenInfo.ramenOrder[2] + "  ==>  " + Detail.item);
                    break;

                case 4:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    pw.println("Ramen 3: " + RamenInfo.ramenOrder[2] + "  ==>  " + Detail.item);
                    pw.println("Ramen 4: " + RamenInfo.ramenOrder[3] + "  ==>  " + Detail.item);
                    break;

                case 5:
                    pw.println("Ramen 1: " + RamenInfo.ramenOrder[0] + "  ==>  " + Detail.item);
                    pw.println("Ramen 2: " + RamenInfo.ramenOrder[1] + "  ==>  " + Detail.item);
                    pw.println("Ramen 3: " + RamenInfo.ramenOrder[2] + "  ==>  " + Detail.item);
                    pw.println("Ramen 4: " + RamenInfo.ramenOrder[3] + "  ==>  " + Detail.item);
                    pw.println("Ramen 5: " + RamenInfo.ramenOrder[4] + "  ==>  " + Detail.item);
                    break;

                default:
                    System.out.println("---ERROR - Order--");
            }
            if(ExtraInfo.extraCount[0]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[0]+": " + ExtraInfo.extraCount[0]);
                }
                else {
                    pw.println(ExtraInfo.dishName[0]+": " + ExtraInfo.extraCount[0] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[1]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[1]+": " + ExtraInfo.extraCount[1]);
                }
                else {
                    pw.println(ExtraInfo.dishName[1]+": " + ExtraInfo.extraCount[1] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[2]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[2]+": " + ExtraInfo.extraCount[2]);
                }
                else {
                    pw.println(ExtraInfo.dishName[2]+": " + ExtraInfo.extraCount[2] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[3]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[3]+": " + ExtraInfo.extraCount[3]);
                }
                else {
                    pw.println(ExtraInfo.dishName[3]+": " + ExtraInfo.extraCount[3] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[4]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[4]+": " + ExtraInfo.extraCount[4]);
                }
                else {
                    pw.println(ExtraInfo.dishName[4]+": " + ExtraInfo.extraCount[4] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[5]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[5]+": " + ExtraInfo.extraCount[5]);
                }
                else {
                    pw.println(ExtraInfo.dishName[5]+": " + ExtraInfo.extraCount[5] + " ==> " + Detail.item);
                }
            }
            if(ExtraInfo.extraCount[6]!=0) {
                if(Detail.item==null) {
                    pw.println(ExtraInfo.dishName[6]+": " + ExtraInfo.extraCount[6]);
                }
                else {
                    pw.println(ExtraInfo.dishName[6]+": " + ExtraInfo.extraCount[6] + " ==> " + Detail.item);
                }
            }
            
            if(RamenInfo.ramen>0&&Integer.parseInt(stamps)>=10) {
                pw.println("Cost: £" + String.format("%.2f", calculatePrice() - 9.99));
            }
            else {
                pw.println("Cost: £" + String.format("%.2f",calculatePrice()));
            }
            pw.close();
            fw.close();
        }
        catch (Exception error) {
            System.out.println("order1.txt");
        }
        
        try {
        	String data1="";
            String str1;
        	 FileReader fr = new FileReader(LogIn.jsonFile);
             BufferedReader br = new BufferedReader(fr);   
             while ((str1=br.readLine())!=null) {
                 data1 = data1 + str1 + "\n";
             }
  
             JSONObject dataJson = new JSONObject(data1);
             JSONArray jsonArray = dataJson.getJSONArray("members");
             br.close();
             fr.close();
                if(number.equals(member_num)&&RamenInfo.ramen>0&&Integer.parseInt(stamps)>=10) {
                    BufferedWriter bw=new BufferedWriter(new FileWriter(LogIn.jsonFile));
                	  for (int i = 0; i < jsonArray.length(); i++) {
                          JSONObject info = jsonArray.getJSONObject(i);
                          if(info.getString("member_number").equals(number)) {
                        	  info.put("stamp",Integer.toString(Integer.parseInt(stamps)-10+RamenInfo.ramen-1));
                        	  System.out.println("info is"+info.toString());
                        	  String ws = dataJson.toString();
                        	  bw.write(ws);
                        	  break; 
                          }
                      }
                	  bw.close();
//                    pw.println(l_[0] + ", " + l_[1] + ", " + l_[2] + ", " + l_[3] + ", " + l_[4] + ", " + Integer.toString(Integer.parseInt(l_[5])-10+RamenInfo.ramen-1));
                }
                else if(number.equals(member_num)&&RamenInfo.ramen>0) {
                      BufferedWriter bw=new BufferedWriter(new FileWriter(LogIn.jsonFile));
                	  for (int i = 0; i < jsonArray.length(); i++) {
                          JSONObject info = jsonArray.getJSONObject(i);
                          if(info.getString("member_number").equals(number)) {            
                        	  info.put("stamp",Integer.toString(Integer.parseInt(stamps)+RamenInfo.ramen));
                        	  System.out.println("info is"+info.toString());
                        	  String ws = dataJson.toString();
                        	  bw.write(ws);
                              break;
                          }
                      }
                	  bw.close();
//                    pw.println(l_[0] + ", " + l_[1] + ", " + l_[2] + ", " + l_[3] + ", " + l_[4] + ", " + Integer.toString(Integer.parseInt(l_[5])+RamenInfo.ramen));
                }
                else {
//                    pw.println(l);
                }
            
        }
        catch (Exception error) {
            System.out.println("complex2 error");
        }

        RamenInfo.ramen = 0;
        for(int i=0;i<7;i++) {
            ExtraInfo.dishName[i]=null;
        	ExtraInfo.extraCount[i]=0;
            ExtraInfo.dishPrice[i]=0.0;
        }
        RamenInfo.ramenOrder[0] = null;
        RamenInfo.ramenOrder[1] = null;
        RamenInfo.ramenOrder[2] = null;
        RamenInfo.ramenOrder[3] = null;
        RamenInfo.ramenOrder[4] = null;

        pirntDetails(number);
    }

    /**
     * This aims to print the registration details.
     */
    public void pirntDetails(String number) {
        String data = "";
        String str;
        String member_num="";
        String first_name="";
        String last_name="";
        String email="";
        String mobile="";
        String stamps="";
        try {
//            FileReader fr = new FileReader(LogIn.mem_file);
//            BufferedReader br = new BufferedReader(fr);
//            while (true) {
//                l = br.readLine();
//                l_ = l.split(", ");
//                if(number.equals(l_[0])) {
//                    break;
//                }
//            }
        	  FileReader fr = new FileReader(LogIn.jsonFile);
              BufferedReader br = new BufferedReader(fr);
              while ((str=br.readLine())!=null) {
                  data = data + str + "\n";
              }
              JSONObject dataJson = new JSONObject(data);
              JSONArray jsonArray = dataJson.getJSONArray("members");
              for (int i = 0; i < jsonArray.length(); i++) {
                  JSONObject info = jsonArray.getJSONObject(i);
                  if(info.getString("member_number").equals(number)) {
                      member_num=info.getString("member_number");
                      first_name=info.getString("first_name");
                      last_name=info.getString("last_name");
                      email=info.getString("email");
                      mobile=info.getString("mobile_number");
                      stamps=info.getString("stamp");
                      
                      break;
                  }
              }
              br.close();
              fr.close();
            System.out.println("======== email/SMS function <=> print =========");
            System.out.println("= Your ticket with the registration details:");
            System.out.println("= Your membership number: " +member_num );
            System.out.println("= Your first name: " +first_name);
            System.out.println("= Your surname: " +  last_name);
            System.out.println("= Your email: " +  email);
            System.out.println("= Your mobile number: " + mobile);
            System.out.println("= Your stamps: " + stamps);
            System.out.println("===============================================");

            br.close();
            fr.close();
        }
        catch (Exception error) {
            System.out.println("complex3 error");
        }
    }
    public double calculatePrice() {
    	double price = 0.0;
    	int i=0;
    	for(i=0;i<7;i++) {
    		price += ExtraInfo.dishPrice[i]*ExtraInfo.extraCount[i];
    	}
    	price += RamenInfo.ramen*9.99;
    	return price;
    }
}
