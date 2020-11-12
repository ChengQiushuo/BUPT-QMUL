import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
             
                        this.dispose();
                        new Order(payment);
                        new KioskGui();
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
}
