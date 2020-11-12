import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title        : Order.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Order {
    private String order_file = "./file/order/";
    public static String temp_file = "./file/temp.txt";

    /**
     * Constructor with parameters.
     * @param payment The way of the payment.
     */
    public Order(String payment) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date d = new Date();
        String url = order_file + sdf.format(d) + "_no.txt";

        try {
            FileWriter fw = new FileWriter(url);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Payment - " + payment);
            switch (OrderFood.ramen) {
                case 1:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    break;

                case 2:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    break;

                case 3:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    pw.println("Ramen 3: " + OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);
                    break;

                case 4:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    pw.println("Ramen 3: " + OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);
                    pw.println("Ramen 4: " + OrderFood.ramenOrder[3] + "  ==>  " + Detail.item[3]);
                    break;

                case 5:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    pw.println("Ramen 3: " + OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);
                    pw.println("Ramen 4: " + OrderFood.ramenOrder[3] + "  ==>  " + Detail.item[3]);
                    pw.println("Ramen 5: " + OrderFood.ramenOrder[4] + "  ==>  " + Detail.item[4]);
                    break;

                default:
                    System.out.println("---ERROR - Order--");
            }
            if(OrderFood.extraNori!=0) {
                if(Detail.item[5]==null) {
                    pw.println("Extra Nori: " + OrderFood.extraNori);
                }
                else {
                    pw.println("Extra Nori: " + OrderFood.extraNori + " ==> " + Detail.item[5]);
                }
            }
            if(OrderFood.extraBoiledEgg!=0) {
                if(Detail.item[6]==null) {
                    pw.println("Extra boiled egg: " + OrderFood.extraBoiledEgg);
                }
                else {
                    pw.println("Extra boiled egg: " + OrderFood.extraBoiledEgg + " ==> " + Detail.item[6]);
                }
            }
            if(OrderFood.bambooShoots!=0) {
                if(Detail.item[7]==null) {
                    pw.println("Bamboo shoots: " + OrderFood.bambooShoots);
                }
                else {
                    pw.println("Bamboo shoots: " + OrderFood.bambooShoots + " ==> " + Detail.item[7]);
                }
            }
            if(OrderFood.extraChashu!=0) {
                if(Detail.item[8]==null) {
                    pw.println("Extra Chashu: " + OrderFood.extraChashu);
                }
                else {
                    pw.println("Extra Chashu: " + OrderFood.extraChashu + " ==> " + Detail.item[8]);
                }
            }
            pw.println("Cost: ￡" + String.format("%.2f", OrderFood.ramen*9.99 + OrderFood.extraNori*1.00 + OrderFood.extraBoiledEgg*1.00 + OrderFood.bambooShoots*1.00 + OrderFood.extraChashu*1.00));
            pw.close();
            fw.close();
        }
        catch (Exception error) {
            System.out.println("order.txt");
        }
        OrderFood.ramen = 0;
        OrderFood.extraNori = 0;
        OrderFood.extraBoiledEgg = 0;
        OrderFood.bambooShoots = 0;
        OrderFood.extraChashu = 0;
        OrderFood.ramenOrder[0] = null;
        OrderFood.ramenOrder[1] = null;
        OrderFood.ramenOrder[2] = null;
        OrderFood.ramenOrder[3] = null;
        OrderFood.ramenOrder[4] = null;
    }

    /**
     * Constructor with parameters.
     * @param payment The way of the payment.
     * @param number The membership number.
     */
    public Order(String payment, String number) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date d = new Date();
        String url = order_file + sdf.format(d) + "_" + number + ".txt";

        String l;
        String[] l_ = {null, null, null, null, null, null};
        try {
            FileReader fr = new FileReader(LogIn.mem_file);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                l = br.readLine();
                l_ = l.split(", ");
                if(number.equals(l_[0])) {
                    break;
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception error) {
            System.out.println("complex error");
        }

        try {
            FileWriter fw = new FileWriter(url);
            PrintWriter pw = new PrintWriter(fw);
            System.out.println();
            pw.println(number);
            if(OrderFood.ramen>0&&Integer.parseInt(l_[5])>=10&&OrderFood.extraNori==0&&OrderFood.extraBoiledEgg==0&&OrderFood.bambooShoots==0&&OrderFood.extraChashu==0) {
                pw.println("Payment - Stamps");
            }
            else if(OrderFood.ramen>0&&Integer.parseInt(l_[5])>=10) {
                pw.println("Payment - Stamps & " + payment);
            }
            else {
                pw.println("Payment - " + payment);
            }
            switch (OrderFood.ramen) {
                case 1:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    break;

                case 2:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    break;

                case 3:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    pw.println("Ramen 3: " + OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);
                    break;

                case 4:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    pw.println("Ramen 3: " + OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);
                    pw.println("Ramen 4: " + OrderFood.ramenOrder[3] + "  ==>  " + Detail.item[3]);
                    break;

                case 5:
                    pw.println("Ramen 1: " + OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                    pw.println("Ramen 2: " + OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);
                    pw.println("Ramen 3: " + OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);
                    pw.println("Ramen 4: " + OrderFood.ramenOrder[3] + "  ==>  " + Detail.item[3]);
                    pw.println("Ramen 5: " + OrderFood.ramenOrder[4] + "  ==>  " + Detail.item[4]);
                    break;

                default:
                    System.out.println("---ERROR - Order--");
            }
            if(OrderFood.extraNori!=0) {
                if(Detail.item[5]==null) {
                    pw.println("Extra Nori: " + OrderFood.extraNori);
                }
                else {
                    pw.println("Extra Nori: " + OrderFood.extraNori + " ==> " + Detail.item[5]);
                }
            }
            if(OrderFood.extraBoiledEgg!=0) {
                if(Detail.item[6]==null) {
                    pw.println("Extra boiled egg: " + OrderFood.extraBoiledEgg);
                }
                else {
                    pw.println("Extra boiled egg: " + OrderFood.extraBoiledEgg + " ==> " + Detail.item[6]);
                }
            }
            if(OrderFood.bambooShoots!=0) {
                if(Detail.item[7]==null) {
                    pw.println("Bamboo shoots: " + OrderFood.bambooShoots);
                }
                else {
                    pw.println("Bamboo shoots: " + OrderFood.bambooShoots + " ==> " + Detail.item[7]);
                }
            }
            if(OrderFood.extraChashu!=0) {
                if(Detail.item[8]==null) {
                    pw.println("Extra Chashu: " + OrderFood.extraChashu);
                }
                else {
                    pw.println("Extra Chashu: " + OrderFood.extraChashu + " ==> " + Detail.item[8]);
                }
            }
            if(OrderFood.ramen>0&&Integer.parseInt(l_[5])>=10) {
                pw.println("Cost: ￡" + String.format("%.2f", OrderFood.ramen * 9.99 + OrderFood.extraNori * 1.00 + OrderFood.extraBoiledEgg * 1.00 + OrderFood.bambooShoots * 1.00 + OrderFood.extraChashu * 1.00 - 9.99));
            }
            else {
                pw.println("Cost: ￡" + String.format("%.2f", OrderFood.ramen * 9.99 + OrderFood.extraNori * 1.00 + OrderFood.extraBoiledEgg * 1.00 + OrderFood.bambooShoots * 1.00 + OrderFood.extraChashu * 1.00));
            }
            pw.close();
            fw.close();
        }
        catch (Exception error) {
            System.out.println("order.txt");
        }

        File f = new File(temp_file);
        f.createNewFile();
        try {
            FileReader fr = new FileReader(LogIn.mem_file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            while ((l = br.readLine())!=null) {
                l_ = l.split(", ");
                System.out.println(l_[0]);
                System.out.println(OrderFood.ramen);
                System.out.println(l_[5]);
                if(number.equals(l_[0])&&OrderFood.ramen>0&&Integer.parseInt(l_[5])>=10) {
                    pw.println(l_[0] + ", " + l_[1] + ", " + l_[2] + ", " + l_[3] + ", " + l_[4] + ", " + Integer.toString(Integer.parseInt(l_[5])-10+OrderFood.ramen-1));
                }
                else if(number.equals(l_[0])&&OrderFood.ramen>0) {
                    pw.println(l_[0] + ", " + l_[1] + ", " + l_[2] + ", " + l_[3] + ", " + l_[4] + ", " + Integer.toString(Integer.parseInt(l_[5])+OrderFood.ramen));
                }
                else {
                    pw.println(l);
                }
            }
            pw.close();
            fw.close();
            br.close();
            fr.close();
        }
        catch (Exception error) {
            System.out.println("complex error");
        }
        f = new File(LogIn.mem_file);
        f.delete();
        f = new File(temp_file);
        f.renameTo(new File(LogIn.mem_file));

        OrderFood.ramen = 0;
        OrderFood.extraNori = 0;
        OrderFood.extraBoiledEgg = 0;
        OrderFood.bambooShoots = 0;
        OrderFood.extraChashu = 0;
        OrderFood.ramenOrder[0] = null;
        OrderFood.ramenOrder[1] = null;
        OrderFood.ramenOrder[2] = null;
        OrderFood.ramenOrder[3] = null;
        OrderFood.ramenOrder[4] = null;

        pirntDetails(number);
    }

    /**
     * This aims to print the registration details.
     */
    public void pirntDetails(String number) {
        String l;
        String[] l_ = {null, null, null, null, null, null};
        try {
            FileReader fr = new FileReader(LogIn.mem_file);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                l = br.readLine();
                l_ = l.split(", ");
                if(number.equals(l_[0])) {
                    break;
                }
            }
            System.out.println("======== email/SMS function <=> print =========");
            System.out.println("= Your ticket with the registration details:");
            System.out.println("= Your membership number: " + l_[0]);
            System.out.println("= Your first name: " + l_[1]);
            System.out.println("= Your surname: " + l_[2]);
            System.out.println("= Your email: " + l_[3]);
            System.out.println("= Your mobile number: " + l_[4]);
            System.out.println("= Your stamps: " + l_[5]);
            System.out.println("===============================================");

            br.close();
            fr.close();
        }
        catch (Exception error) {
            System.out.println("complex error");
        }
    }
}
