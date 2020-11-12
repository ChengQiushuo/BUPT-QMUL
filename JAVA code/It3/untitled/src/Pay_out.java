import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title        : Pay_out.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Pay_out extends JFrame implements ActionListener {
    private String payment = null;
    private String[] payments = new String[5];
    private String[] availability = new String[5];
    private JSONArray items;
    private JSONObject Data;
    private static String paymentFile = "./file/payment.json";

    /**
     * Constructor without parameters.
     */
    public Pay_out() {
        // Set the frame.
        super("Pay - not use the membership number");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the pay_out menu.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Please check again and pay the bill after choosing the payment~"));

        // Set the ramen information.
        JLabel l_1 = new JLabel("", JLabel.LEFT);
        l_1.setFont(new Font(null, Font.BOLD, 16));
        l_1.setBounds(30, 70, 900, 18);
        JLabel l_2 = new JLabel("", JLabel.LEFT);
        l_2.setFont(new Font(null, Font.BOLD, 16));
        l_2.setBounds(30, 130, 900, 18);
        JLabel l_3 = new JLabel("", JLabel.LEFT);
        l_3.setFont(new Font(null, Font.BOLD, 16));
        l_3.setBounds(30, 190, 900, 18);
        JLabel l_4 = new JLabel("", JLabel.LEFT);
        l_4.setFont(new Font(null, Font.BOLD, 16));
        l_4.setBounds(30, 250, 900, 18);
        JLabel l_5 = new JLabel("", JLabel.LEFT);
        l_5.setFont(new Font(null, Font.BOLD, 16));
        l_5.setBounds(30, 310, 900, 18);
        // Add the ramen information to the detail menu.
        p.add(l_1);
        p.add(l_2);
        p.add(l_3);
        p.add(l_4);
        p.add(l_5);

        // Set the additional information.
        JLabel l_6 = new JLabel("", JLabel.RIGHT);
        l_6.setFont(new Font(null, Font.BOLD, 16));
        l_6.setBounds(180, 370, 300, 18);
        JLabel l_7 = new JLabel("", JLabel.RIGHT);
        l_7.setFont(new Font(null, Font.BOLD, 16));
        l_7.setBounds(180, 400, 300, 18);
        JLabel l_8 = new JLabel("", JLabel.RIGHT);
        l_8.setFont(new Font(null, Font.BOLD, 16));
        l_8.setBounds(180, 430, 300, 18);
        JLabel l_9 = new JLabel("", JLabel.RIGHT);
        l_9.setFont(new Font(null, Font.BOLD, 16));
        l_9.setBounds(180, 460, 300, 18);
        JLabel l_10 = new JLabel("", JLabel.RIGHT);
        l_10.setFont(new Font(null, Font.BOLD, 16));
        l_10.setBounds(180, 490, 300, 18);
        JLabel l_11 = new JLabel("", JLabel.RIGHT);
        l_11.setFont(new Font(null, Font.BOLD, 16));
        l_11.setBounds(180, 520, 300, 18);
        JLabel l_12 = new JLabel("", JLabel.RIGHT);
        l_12.setFont(new Font(null, Font.BOLD, 16));
        l_12.setBounds(180, 550, 300, 25);
        // Add the ramen information to the detail menu.
        p.add(l_6);
        p.add(l_7);
        p.add(l_8);
        p.add(l_9);
        p.add(l_10);
        p.add(l_11);
        p.add(l_12);
       
        
  
        // Set the sum of the cost.
        JLabel l_13 = new JLabel("£" + String.format("%.2f",calculatePrice()), JLabel.CENTER);
        l_13.setFont(new Font(null, Font.BOLD, 50));
        l_13.setBounds(590, 350, 333, 60);
        // Add the sum of the cost to the pay menu.
        p.add(l_13);
        String str;
        String data = "";
        File f = new File(paymentFile);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            data="";
            str="";
            while ((str=br.readLine())!=null) {
                data = data + str + "\n";
            }
             JSONObject dataJson = new JSONObject(data);
             Data = dataJson;
             items = dataJson.getJSONArray("payments");
            for (int i = 0; i < items.length(); i++) {
                JSONObject obj = items.getJSONObject(i);
                payments[i] = obj.getString("name");
                availability[i] = obj.getString("availability");           
            }
            br.close();
            fr.close();
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        // Buttons of the payment.
        ButtonGroup bg = new ButtonGroup();
        JRadioButton rb_1 = new JRadioButton(payments[0]);
        rb_1.setFont(new Font(null, Font.BOLD, 30));
        rb_1.setBounds(710, 410, 150, 50);
        rb_1.addActionListener(this);
        rb_1.setActionCommand("rb_1");
        JRadioButton rb_2 = new JRadioButton(payments[1]);
        rb_2.setFont(new Font(null, Font.BOLD, 30));
        rb_2.setBounds(710, 450, 150, 50);
        rb_2.addActionListener(this);
        rb_2.setActionCommand("rb_2");
        JRadioButton rb_3 = new JRadioButton(payments[2]);
        rb_3.setFont(new Font(null, Font.BOLD, 30));
        rb_3.setBounds(710, 490, 150, 50);
        rb_3.addActionListener(this);
        rb_3.setActionCommand("rb_3");
        JRadioButton rb_4 = new JRadioButton(payments[3]);
        rb_4.setFont(new Font(null, Font.BOLD, 30));
        rb_4.setBounds(710, 530, 150, 50);
        rb_4.addActionListener(this);
        rb_4.setActionCommand("rb_4");
        JRadioButton rb_5 = new JRadioButton(payments[4]);
        rb_5.setFont(new Font(null, Font.BOLD, 30));
        rb_5.setBounds(710, 570, 150, 50);
        rb_5.addActionListener(this);
        rb_5.setActionCommand("rb_5");
        // Add the payment to the pay_in menu.
        
        switch(items.length()) {
         case 5:
        	  bg.add(rb_5);
        	  p.add(rb_5);
         case 4:
        	 bg.add(rb_4);
        	  p.add(rb_4);
         case 3:
        	 bg.add(rb_3);
        	 p.add(rb_3);
         case 2:
        	  bg.add(rb_2);
        	  p.add(rb_2);
         case 1:
        	 bg.add(rb_1);
        	 p.add(rb_1);
        	 break;

         default:
             System.out.println("---ERROR---");
        }
        

        // Set the Change button.
        JButton b1 = new JButton("Change");
        b1.setFont(new Font(null, Font.BOLD, 20));
        b1.setBounds(19, 633, 200, 60);
        b1.addActionListener(this);
        b1.setActionCommand("b1");
        // Set the Pay button.
        JButton b2 = new JButton("Pay");
        b2.setFont(new Font(null, Font.BOLD, 20));
        b2.setBounds(777, 633, 200, 60);
        b2.addActionListener(this);
        b2.setActionCommand("b2");
        // Add the buttons to the pay_out menu.
        p.add(b1);
        p.add(b2);
        System.out.println(OrderFood.ramen);
        // Add the pay_out menu to the frame.
        switch (OrderFood.ramen) {
        	
            case 5:
                l_5.setText(OrderFood.ramenOrder[4] + "  ==>  " + Detail.item);

            case 4:
                l_4.setText(OrderFood.ramenOrder[3] + "  ==>  " + Detail.item);

            case 3:
                l_3.setText(OrderFood.ramenOrder[2] + "  ==>  " + Detail.item);

            case 2:
                l_2.setText(OrderFood.ramenOrder[1] + "  ==>  " + Detail.item);

            case 1:
                l_1.setText(OrderFood.ramenOrder[0] + "  ==>  " + Detail.item);
                break;

            default:
                l_5.setText("");
                l_4.setText("");
                l_3.setText("");
                l_2.setText("");
                l_1.setText("");
        }
        if(OrderFood.extraCount[0]!=0) {
        	l_6.setText(OrderFood.dishName[0] +"     ----      "+ OrderFood.extraCount[0]);
        }
        if(OrderFood.extraCount[1]!=0) {
        	l_7.setText(OrderFood.dishName[1] +"     ----      "+ OrderFood.extraCount[1]);
        }
        if(OrderFood.extraCount[2]!=0) {
        	l_8.setText(OrderFood.dishName[2] +"     ----      "+ OrderFood.extraCount[2]);
        }
        if(OrderFood.extraCount[3]!=0) {
        	l_9.setText(OrderFood.dishName[3] +"     ----      "+ OrderFood.extraCount[3]);
        }
        if(OrderFood.extraCount[4]!=0) {
        	l_10.setText(OrderFood.dishName[4] +"     ----      "+ OrderFood.extraCount[4]);
        }
        if(OrderFood.extraCount[5]!=0) {
        	l_11.setText(OrderFood.dishName[5] +"     ----      "+ OrderFood.extraCount[5]);
        }
        if(OrderFood.extraCount[6]!=0) {
        	l_12.setText(OrderFood.dishName[6] +"     ----      "+ OrderFood.extraCount[6]);
        }
        this.add(p);

        /*
         * Set the closing operation.
         * Set the frame to non-resizeable.
         * Set the frame to visible.
         */
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public double calculatePrice() {
    	double price = 0.0;
    	int i=0;
    	for(i=0;i<7;i++) {
    		price += OrderFood.dishPrice[i]*OrderFood.extraCount[i];
    	}
    	price += OrderFood.ramen*9.99;
    	return price;
    }

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "b1": // Change
                this.dispose();
                new OrderFood();
                break;

            case "b2": // Pay
            	
                if(payment==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the payment !", "Please choose the payment", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int success = JOptionPane.showConfirmDialog(null, "- Manually select whether payment is successful -", "- Manually select whether payment is successful -", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(success==0) {

                            Calendar cal = Calendar.getInstance();
                            cal.setTime(new Date());
                            SimpleDateFormat formatter = new SimpleDateFormat(("yyyyMMdd"));
                            Date date = new Date(System.currentTimeMillis());
                            File f = new File("./report/" + (Integer.parseInt(formatter.format(date)) + 1 - (cal.get(Calendar.DAY_OF_WEEK) - 1)) + "info.json");
                            try {
                                BufferedReader br = new BufferedReader(new FileReader(f));
                                String str = null;
                                String data = "";
                                while ((str = br.readLine()) != null) {
                                    data = data + str + "\n";
                                }
                                JSONObject dataObject = new JSONObject(data);
                                JSONArray extraArray = dataObject.getJSONArray("extra");
                                JSONArray compulsoryArray = dataObject.getJSONArray("compulsory");
                                for (int count2 = 0; count2 < OrderFood.dishName.length; count2++) {
                                    int a1 = extraArray.getJSONObject(count2).getInt("number");
                                    a1 = a1 + OrderFood.extraCount[count2];
                                    extraArray.getJSONObject(count2).put("number", a1);
                                }
                                for (int i = 0; i < OrderFood.ramen; i++) {
                                    String choice[] = OrderFood.ramenOrder[i].split("\\,");
                                    for (int count = 0; count < Ramen.dish_len; count++) {
                                        JSONArray array = compulsoryArray.getJSONObject(count).getJSONArray("options");
                                        for (int count1 = 0; count1 < array.length(); count1++) {
                                            String s1 = new String(array.getJSONObject(count1).getString("item"));
                                            String s2 = new String(choice[count]);
                                            if (s2.equals(s1)) {
                                                int a = array.getJSONObject(count1).getInt("number");
                                                a++;
                                                array.getJSONObject(count1).put("number", a);
                                                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./report/"
                                                        + (Integer.parseInt(formatter.format(date)) + 1 - (cal.get(Calendar.DAY_OF_WEEK) - 1)) + "info.json"));
                                                String updatedJson = formatJson(dataObject.toString());
                                                osw.write(updatedJson);
                                                osw.flush();
                                                osw.close();
                                            }
                                        }
                                    }
                                }

                            }
                            catch(FileNotFoundException O){
                                O.printStackTrace();
                            } catch(IOException O){
                                O.printStackTrace();
                            }

                        }
                        this.dispose();
                        new Order(payment);
                        new KioskGui();
                    }

                break;

            case "rb_1": // Cash
                payment = payments[0];
                break;

            case "rb_2": // Card
                payment = payments[1];
                break;
            case "rb_3": // Card
                payment = payments[2];
                break;
            case "rb_4": // Card
                payment = payments[3];
                break;
            case "rb_5": // Card
                payment = payments[4];
                break;

            default:
                System.out.println("---ERROR - SignUp---");
        }
    }
    /**
     * 单位缩进字符串。
     */
    private static String SPACE = "   ";

    /**
     * 返回格式化JSON字符串。
     *
     * @param json 未格式化的JSON字符串。
     * @return 格式化的JSON字符串。
     */
    public static String formatJson(String json) {
        StringBuffer result = new StringBuffer();

        int length = json.length();
        int number = 0;
        char key = 0;

        // 遍历输入字符串。
        for (int i = 0; i < length; i++) {
            // 1、获取当前字符。
            key = json.charAt(i);

            // 2、如果当前字符是前方括号、前花括号做如下处理：
            if ((key == '[') || (key == '{')) {
                // （1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
                    result.append('\n');
                    result.append(indent(number));
                }

                // （2）打印：当前字符。
                result.append(key);

                // （3）前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');

                // （4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));

                // （5）进行下一次循环。
                continue;
            }

            // 3、如果当前字符是后方括号、后花括号做如下处理：
            if ((key == ']') || (key == '}')) {
                // （1）后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');

                // （2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));

                // （3）打印：当前字符。
                result.append(key);

                // （4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
                    result.append('\n');
                }

                // （5）继续下一次循环。
                continue;
            }

            // 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if ((key == ',')) {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            // 5、打印：当前字符。
            result.append(key);
        }

        return result.toString();
    }

    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     *
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private static String indent(int number) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < number; i++) {
            result.append(SPACE);
        }
        return result.toString();
    }
}
