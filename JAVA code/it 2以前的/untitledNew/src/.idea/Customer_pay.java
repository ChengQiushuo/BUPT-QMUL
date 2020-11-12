package boundary;

import javax.swing.*;


import control.Order;
import control.Payment;
import control.Report.UpdateReport;
import entity.ExtraInfo;
import entity.RamenInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Title        : Pay_out.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Customer_pay extends JFrame implements ActionListener {
    private String payment = null;
    private String[] payments = new String[5];
    private String[] availability = new String[5];
    public Payment paymentinfo;
    entity.RamenInfo RamenInfo;
    ExtraInfo ExtraInfo;
    public UpdateReport updatereport;
    private int paymentlength;
    /**
     * Constructor without parameters.
     */
    public Customer_pay(RamenInfo RamenInfos,ExtraInfo extraInfos) {
        // Set the frame.
        super("Pay - not use the membership number");
        RamenInfo = RamenInfos;
        ExtraInfo =extraInfos;
        paymentinfo = new Payment();
        payments = paymentinfo.getPayments();
        availability= paymentinfo.getAvailability();
        paymentlength = paymentinfo.getLength();
        updatereport = new UpdateReport();
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the pay_out menu.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
//        p.setBorder(BorderFactory.createTitledBorder("Please check again and pay the bill after choosing the payment~"));

        JLabel lab = new JLabel("Please check again and  choosse the Payment method", JLabel.LEFT);
        lab.setFont(new Font(null, Font.BOLD, 25));
        lab.setBounds(15, 10, 750, 30);
        //Dining Option
        JLabel l_way = new JLabel("Dining Way", JLabel.LEFT);
        l_way.setFont(new Font(null, Font.BOLD, 24));
        l_way.setBounds(400,450, 150, 25);
        JLabel l_option = new JLabel(Detail.item, JLabel.LEFT);
        l_option.setFont(new Font(null, Font.BOLD, 22));
        l_option.setBounds(400,500, 150, 25);
        p.add(l_option);
        p.add(l_way);
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
        
        JLabel l_ = new JLabel("ADD-ON:", JLabel.LEFT);
        l_.setFont(new Font(null, Font.BOLD, 22));
        l_.setBounds(15, 400, 300, 18);
        p.add(l_);
        
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
        JLabel l_13 = new JLabel("£" + String.format("%.2f",calculatePrice()), JLabel.CENTER);
        l_13.setFont(new Font(null, Font.BOLD, 50));
        l_13.setBounds(590, 350, 333, 60);
        // Add the sum of the cost to the pay menu.
        p.add(l_13);

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
        
        switch(paymentlength) {
         case 5:
        	  bg.add(rb_5);
        	  p.add(rb_5);
        	  if(availability[4].equals("No")) {
                  rb_5.setEnabled(false);
              }
         case 4:
        	 bg.add(rb_4);
        	  p.add(rb_4);
        	  if(availability[3].equals("No")) {
                  rb_4.setEnabled(false);
              }
         case 3:
        	 bg.add(rb_3);
        	 p.add(rb_3); 
        	 if(availability[2].equals("No")) {
                 rb_3.setEnabled(false);
             }
         case 2:
        	  bg.add(rb_2);
        	  p.add(rb_2); 
        	  if(availability[1].equals("No")) {
                  rb_2.setEnabled(false);
              }
         case 1:
        	 bg.add(rb_1);
        	 p.add(rb_1); 
        	 if(availability[0].equals("No")) {
                 rb_1.setEnabled(false);
             }
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
        System.out.println(RamenInfo.ramen);
        // Add the pay_out menu to the frame.
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
			JlabelSetText(l_2,RamenInfo.ramenOrder[0]);
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
        	l_7.setText(ExtraInfo.dishName[1] +"    ----     "+ ExtraInfo.extraCount[1]);
        }
        if(ExtraInfo.extraCount[2]!=0) {
        	l_8.setText(ExtraInfo.dishName[2] +"    ----     "+ ExtraInfo.extraCount[2]);
        }
        if(ExtraInfo.extraCount[3]!=0) {
        	l_9.setText(ExtraInfo.dishName[3] +"    ----     "+ ExtraInfo.extraCount[3]);
        }
        if(ExtraInfo.extraCount[4]!=0) {
        	l_10.setText(ExtraInfo.dishName[4] +"    ----     "+ ExtraInfo.extraCount[4]);
        }
        if(ExtraInfo.extraCount[5]!=0) {
        	l_11.setText(ExtraInfo.dishName[5] +"    ----     "+ ExtraInfo.extraCount[5]);
        }
        if(ExtraInfo.extraCount[6]!=0) {
        	l_12.setText(ExtraInfo.dishName[6] +"    ----     "+ ExtraInfo.extraCount[6]);
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
                new OrderFood(RamenInfo,ExtraInfo);
                break;
            case "b2": // Pay
                if(payment==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the payment !", "Please choose the payment", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int success = JOptionPane.showConfirmDialog(null, "- Manually select whether payment is successful -", "- Manually select whether payment is successful -", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(success==0) {
                    	updatereport.updateReport(ExtraInfo, RamenInfo);
                        }
                        this.dispose();
                        new Order(payment,RamenInfo,ExtraInfo);
                        new StartGui();
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
  
}

