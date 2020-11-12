package boundary;

import javax.swing.*;

import control.Order;
import control.json;
import entity.ExtraInfo;
import entity.MemberInfo;
import entity.RamenInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Title        : Pay_in.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Pay_in extends JFrame implements ActionListener, json {
    private String number = null;
    private String payment = null;
    private String[] payments = new String[5];
    private String[] availability = new String[5];
    private JSONArray items;
//    private JSONObject Data;
    private static String paymentFile = "./file/payment.json";
    public String jsonFile = "./file/memberships.json";
    RamenInfo RamenInfo;
    ExtraInfo ExtraInfo;
    boolean flag;
    /**
     * Constructor without parameters.
     */
    public Pay_in(String num,RamenInfo RamenInfos,ExtraInfo extraInfos,boolean flag) {
        // Set the frame.
        this.setLayout(null);
        RamenInfo = RamenInfos;
        ExtraInfo = extraInfos;
        this.setBounds(200, 33, 1024, 768);
         number = num;
         this.flag= flag;
        String[] l_ = {null, null, null, null, null, null};
        String[] num_ = num.split(", ");

        JSONObject dataJson  = json(jsonFile);
        JSONArray jsonArray = dataJson.getJSONArray("members");
        ArrayList<MemberInfo> members = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject info = jsonArray.getJSONObject(i);
            String s1  = info.getString("member_number");
            String s2  = info.getString("stamp");
            MemberInfo m = new MemberInfo(s1, s2);
            members.add(m);
            }
        for (int i = 0; i < members.size(); i++) {
            MemberInfo m = members.get(i);
            if (m.memberNumber.equals(num_[0])) {
                l_[5] = m.stamps;
            }

            break;
        }
        this.setTitle("Pay - " + number + " - Stamps: " + l_[5]);

        // Set the pay_in menu.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
//        p.setBorder(BorderFactory.createTitledBorder("Please check again and pay the bill after choosing the payment~"));

        // Set the ramen information.
        JLabel lab = new JLabel("Please check again and choose the Payment method", JLabel.LEFT);
        lab.setFont(new Font(null, Font.BOLD, 25));
        lab.setBounds(15, 10, 750, 30);
        // Set the ramen information.
        JLabel l_1 = new JLabel("", JLabel.LEFT);
        l_1.setFont(new Font(null, Font.BOLD, 16));
        l_1.setBounds(120, 80, 800, 45);
        JLabel l_2 = new JLabel("", JLabel.LEFT);
        l_2.setFont(new Font(null, Font.BOLD, 16));
        l_2.setBounds(120, 140, 800, 45);
        JLabel l_3 = new JLabel("", JLabel.LEFT);
        l_3.setFont(new Font(null, Font.BOLD, 16));
        l_3.setBounds(120, 200, 800, 45);
        JLabel l_4 = new JLabel("", JLabel.LEFT);
        l_4.setFont(new Font(null, Font.BOLD, 16));
        l_4.setBounds(120, 260, 800, 45);
        JLabel l_5 = new JLabel("", JLabel.LEFT);
        l_5.setFont(new Font(null, Font.BOLD, 16));
        l_5.setBounds(120, 320, 800, 45);
        // Add the ramen information to the detail menu.
        p.add(l_1);
        p.add(l_2);
        p.add(l_3);
        p.add(l_4);
        p.add(l_5);
        p.add(lab);
        JLabel l_ramen = new JLabel("RAMEN:", JLabel.LEFT);
        l_ramen.setFont(new Font(null, Font.BOLD, 22));
        l_ramen.setBounds(25,50, 300, 25);
        p.add(l_ramen);
//        JLabel l_dish = new JLabel(Ramen.dish, JLabel.LEFT);
//        l_dish.setFont(new Font(null, Font.BOLD, 19));
//        l_dish.setBounds(95,80, 1000, 25);
//        p.add(l_dish);
        
        JLabel l_a = new JLabel("ADD-ON:", JLabel.LEFT);
        l_a.setFont(new Font(null, Font.BOLD, 22));
        l_a.setBounds(15, 400, 300, 18);
        p.add(l_a);
        // Set the additional information.
        JLabel l_6 = new JLabel("", JLabel.LEFT);
        l_6.setFont(new Font(null, Font.BOLD, 16));
        l_6.setBounds(30, 430, 200, 18);
        JLabel l_7 = new JLabel("", JLabel.LEFT);
        l_7.setFont(new Font(null, Font.BOLD, 16));
        l_7.setBounds(30, 460, 200, 18);
        JLabel l_8 = new JLabel("", JLabel.LEFT);
        l_8.setFont(new Font(null, Font.BOLD, 16));
        l_8.setBounds(30, 490, 200, 18);
        JLabel l_9 = new JLabel("", JLabel.LEFT);
        l_9.setFont(new Font(null, Font.BOLD, 16));
        l_9.setBounds(30, 520, 200, 18);
        JLabel l_10 = new JLabel("", JLabel.LEFT);
        l_10.setFont(new Font(null, Font.BOLD, 16));
        l_10.setBounds(30, 550, 200, 18);
        JLabel l_11 = new JLabel("", JLabel.LEFT);
        l_11.setFont(new Font(null, Font.BOLD, 16));
        l_11.setBounds(30, 520, 200, 18);
        JLabel l_12 = new JLabel("", JLabel.LEFT);
        l_12.setFont(new Font(null, Font.BOLD, 16));
        l_12.setBounds(30, 550, 200, 25);
        // Add the ramen information to the detail menu.
        p.add(l_6);
        p.add(l_7);
        p.add(l_8);
        p.add(l_9);
        p.add(l_10);
        p.add(l_11);
        p.add(l_12);

        // Set the sum of the cost.
        if(RamenInfo.ramen>0&&Integer.parseInt(l_[5])>=10&&flag==true) {
            JLabel l_13 = new JLabel("£" + String.format("%.2f",calculatePrice()-9.99 ), JLabel.CENTER);
            l_13.setFont(new Font(null, Font.BOLD, 50));
            l_13.setBounds(590, 300, 333, 60);
            l_13.setForeground(Color.red);
            p.add(l_13);
            JLabel l_14 = new JLabel("Using stamps already -£9.99", JLabel.CENTER);
            l_14.setFont(new Font(null, Font.BOLD, 13));
            l_14.setBounds(595, 360, 333, 20);
            l_14.setForeground(Color.red);
            p.add(l_14);
            
        }
        else {
            JLabel l_13 = new JLabel("£" + String.format("%.2f", calculatePrice()), JLabel.CENTER);
            l_13.setFont(new Font(null, Font.BOLD, 50));
            l_13.setBounds(590, 350, 333, 60);
            p.add(l_13);
        }
        
        	
        
             JSONObject dataJson1 = json(paymentFile);
//             Data = dataJson;
             items = dataJson1.getJSONArray("payments");
            for (int i = 0; i < items.length(); i++) {
                JSONObject obj = items.getJSONObject(i);
                payments[i] = obj.getString("name");
                availability[i] = obj.getString("availability");           
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
        if(calculatePrice()-9.99!=0) {
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
        }else {
        	payment= "stamps";
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
        // Add the buttons to the pay_in menu.
        p.add(b1);
        p.add(b2);

        // Add the pay_in menu to the frame.
        switch (RamenInfo.ramen) {
        case 5:
        	try {
			    JLabel l_5_1 = new JLabel("Pocket5: ", JLabel.LEFT);
		        l_5_1.setFont(new Font(null, Font.BOLD, 16));
		        l_5_1.setBounds(30, 320, 90, 45);
		        p.add(l_5_1);
				JlabelSetText(l_5,RamenInfo.ramenOrder[4]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        case 4:               
        	try {
			    JLabel l_4_1 = new JLabel("Pocket4: ", JLabel.LEFT);
		        l_4_1.setFont(new Font(null, Font.BOLD, 16));
		        l_4_1.setBounds(30, 260, 90, 45);
		        p.add(l_4_1);
				JlabelSetText(l_4,RamenInfo.ramenOrder[3]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        case 3:         
        	try {
			    JLabel l_3_1 = new JLabel("Pocket3: ", JLabel.LEFT);
		        l_3_1.setFont(new Font(null, Font.BOLD, 16));
		        l_3_1.setBounds(30, 200, 90, 45);
		        p.add(l_3_1);
				JlabelSetText(l_3,RamenInfo.ramenOrder[2]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        case 2:               
        	JLabel l_2_1 = new JLabel("Pocket2: ", JLabel.LEFT);
	        l_2_1.setFont(new Font(null, Font.BOLD, 16));
	        l_2_1.setBounds(30, 140, 90, 45);
	        p.add(l_2_1);
		try {
			JlabelSetText(l_2,RamenInfo.ramenOrder[1]);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        case 1:              
		try {
		    JLabel l_1_1 = new JLabel("Pocket1: ", JLabel.LEFT);
	        l_1_1.setFont(new Font(null, Font.BOLD, 16));
	        l_1_1.setBounds(30, 80, 90, 45);
	        p.add(l_1_1);
			JlabelSetText(l_1,RamenInfo.ramenOrder[0]);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//            l_1.setText("Pocket 1: "+RamenInfo.ramenOrder[0]);
            break;
        default:
            //l_0_1.setText("");
            l_5.setText("");
            l_4.setText("");
            l_3.setText("");
            l_2.setText("");
            l_1.setText("");
    }
        if(ExtraInfo.extraCount[0]!=0) {
        	l_6.setText(ExtraInfo.dishName[0] +"     ----      "+ ExtraInfo.extraCount[0]);
        }
        if(ExtraInfo.extraCount[1]!=0) {
        	l_7.setText(ExtraInfo.dishName[1] +"     ----      "+ ExtraInfo.extraCount[1]);
        }
        if(ExtraInfo.extraCount[2]!=0) {
        	l_8.setText(ExtraInfo.dishName[2] +"     ----      "+ ExtraInfo.extraCount[2]);
        }
        if(ExtraInfo.extraCount[3]!=0) {
        	l_9.setText(ExtraInfo.dishName[3] +"     ----      "+ ExtraInfo.extraCount[3]);
        }
        if(ExtraInfo.extraCount[4]!=0) {
        	l_10.setText(ExtraInfo.dishName[4] +"     ----      "+ ExtraInfo.extraCount[4]);
        }
        if(ExtraInfo.extraCount[5]!=0) {
        	l_11.setText(ExtraInfo.dishName[5] +"     ----      "+ ExtraInfo.extraCount[5]);
        }
        if(ExtraInfo.extraCount[6]!=0) {
        	l_12.setText(ExtraInfo.dishName[6] +"     ----      "+ ExtraInfo.extraCount[6]);
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
    		price += ExtraInfo.dishPrice[i]*ExtraInfo.extraCount[i];
    	}
    	price += RamenInfo.ramen*9.99;
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
                new LogIn(RamenInfo,ExtraInfo);
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
                            for (int count2 = 0; count2 < ExtraInfo.dishName.length; count2++) {
                                int a1 = extraArray.getJSONObject(count2).getInt("number");
                                a1 = a1 + ExtraInfo.extraCount[count2];
                                extraArray.getJSONObject(count2).put("number", a1);
                            }
                            for (int i = 0; i < RamenInfo.ramen; i++) {
                                String choice[] = RamenInfo.ramenOrder[i].split("\\,");
                                for (int count = 0; count < Ramen.cominfo.dish_len; count++) {
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

                        try {
							new Order(payment,number,RamenInfo,ExtraInfo,flag);
						    this.dispose();
						    new KioskGui();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    }
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
    
    void JlabelSetText(JLabel jLabel, String longString) 
  	       throws InterruptedException {
  	        StringBuilder builder = new StringBuilder("<html>");
  	        char[] chars = longString.toCharArray();
  	        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
  	        int start = 0;
  	        int len = 0;
  	        while (start + len < longString.length()) {
  	            while (true) {
  	                len++;
  	                if (start + len > longString.length())break;
  	                if (fontMetrics.charsWidth(chars, start, len) 
  	                      > jLabel.getWidth()) {
  	                    break;
  	                }
  	            }
  	            builder.append(chars, start, len-1).append("<br/>");
  	            start = start + len - 1;
  	            len = 0;
  	        }
  	        builder.append(chars, start, longString.length()-start);
  	        builder.append("</html>");
  	        jLabel.setText(builder.toString());
  	    }

    @Override
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
