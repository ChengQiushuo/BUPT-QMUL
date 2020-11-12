import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title        : Detail.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Detail extends JFrame implements ActionListener {
    public static String item = "";
//    private String temp_num = "";

    /**
     * Constructor without parameters.
     */
    public Detail() {
    	
        // Set the frame.
        super("Detail");
        this.setLayout(null);
        item="";
        this.setBounds(200, 33, 1024, 768);

        // Set the detail menu.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
//        p.setBorder(BorderFactory.createTitledBorder("Please check again and pay the bill after choosing the dining options~"));
 
        JLabel lab = new JLabel("Please check again and  choosse the dining options", JLabel.LEFT);
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
        
        JLabel l_ = new JLabel("ADD-ON:", JLabel.LEFT);
        l_.setFont(new Font(null, Font.BOLD, 22));
        l_.setBounds(15, 400, 300, 18);
        p.add(l_);
        
        // Set the additional information.
        JLabel l_6 = new JLabel("", JLabel.LEFT);
        l_6.setFont(new Font(null, Font.BOLD, 16));
        l_6.setBounds(10, 430, 250, 18);
        JLabel l_7 = new JLabel("", JLabel.LEFT);
        l_7.setFont(new Font(null, Font.BOLD, 16));
        l_7.setBounds(10, 460, 250, 18);
        JLabel l_8 = new JLabel("", JLabel.LEFT);
        l_8.setFont(new Font(null, Font.BOLD, 16));
        l_8.setBounds(10, 490, 250, 18);
        JLabel l_9 = new JLabel("", JLabel.LEFT);
        l_9.setFont(new Font(null, Font.BOLD, 16));
        l_9.setBounds(10, 520, 250, 18);
        JLabel l_10 = new JLabel("", JLabel.LEFT);
        l_10.setFont(new Font(null, Font.BOLD, 16));
        l_10.setBounds(10, 550, 250, 18);
        JLabel l_11 = new JLabel("", JLabel.LEFT);
        l_11.setFont(new Font(null, Font.BOLD, 16));
        l_11.setBounds(10, 520, 250, 18);
        JLabel l_12 = new JLabel("", JLabel.LEFT);
        l_12.setFont(new Font(null, Font.BOLD, 16));
        l_12.setBounds(10, 550, 250, 25);
        // Add the ramen information to the detail menu.
        p.add(l_6);
        p.add(l_7);
        p.add(l_8);
        p.add(l_9);
        p.add(l_10);
        p.add(l_11);
        p.add(l_12);
        
        JLabel l_d = new JLabel("Please Select a Dining Method", JLabel.LEFT);
        l_d.setFont(new Font(null, Font.BOLD, 23));
        l_d.setBounds(520, 520, 400, 30);
        p.add(l_d);
        
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton rb_1_1 = new JRadioButton("EAT IN");
        rb_1_1.setFont(new Font(null, Font.BOLD, 25));
        rb_1_1.setBounds(520, 570, 150,40);
        rb_1_1.addActionListener(this);
        rb_1_1.setActionCommand("rb_1_1");
        JRadioButton rb_1_2 = new JRadioButton("TAKE-AWAY");
        rb_1_2.setFont(new Font(null, Font.BOLD, 25));
        rb_1_2.setBounds(700, 570, 200, 40);
        rb_1_2.addActionListener(this);
        rb_1_2.setActionCommand("rb_1_2");
        bg1.add(rb_1_1);
        bg1.add(rb_1_2);
        this.add(rb_1_1);
        this.add(rb_1_2);
       

        // Set the Modify button.
        JButton b1 = new JButton("Modify");
        b1.setFont(new Font(null, Font.BOLD, 20));
        b1.setBounds(19, 633, 200, 60);
        b1.addActionListener(this);
        b1.setActionCommand("b1");
        // Set the Continue button.
        JButton b2 = new JButton("Continue");
        b2.setFont(new Font(null, Font.BOLD, 20));
        b2.setBounds(777, 633, 200, 60);
        b2.addActionListener(this);
        b2.setActionCommand("b2");
        // Add the buttons to the detail menu.
        p.add(b1);
        p.add(b2);

        // Add the detail menu to the frame.
        switch (OrderFood.ramen) {
            case 5:
            	try {
    			    JLabel l_5_1 = new JLabel("Pocket5: ", JLabel.LEFT);
    		        l_5_1.setFont(new Font(null, Font.BOLD, 16));
    		        l_5_1.setBounds(30, 320, 90, 45);
    		        p.add(l_5_1);
    				JlabelSetText(l_5,OrderFood.ramenOrder[4]+",aaaaaaaa");
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
    				JlabelSetText(l_4,OrderFood.ramenOrder[3]+"aaaaaaaaaa");
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
    				JlabelSetText(l_3,OrderFood.ramenOrder[2]+"aaaaaaaa");
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
				JlabelSetText(l_2,OrderFood.ramenOrder[0]+"aaa");
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
				JlabelSetText(l_1,OrderFood.ramenOrder[0]+"aa");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//                l_1.setText("Pocket 1: "+OrderFood.ramenOrder[0]);              
                break;
            default:
                //l_0_1.setText("");
                l_5.setText("");
                l_4.setText("");
                l_3.setText("");
                l_2.setText("");
                l_1.setText("");
        }
        if(OrderFood.extraCount[0]!=0) {
        	l_6.setText(OrderFood.dishName[0] +"    ----     "+ OrderFood.extraCount[0]);
        }
        if(OrderFood.extraCount[1]!=0) {
        	l_7.setText(OrderFood.dishName[1] +"    ----     "+ OrderFood.extraCount[1]);
        }
        if(OrderFood.extraCount[2]!=0) {
        	l_8.setText(OrderFood.dishName[2] +"    ----     "+ OrderFood.extraCount[2]);
        }
        if(OrderFood.extraCount[3]!=0) {
        	l_9.setText(OrderFood.dishName[3] +"    ----     "+ OrderFood.extraCount[3]);
        }
        if(OrderFood.extraCount[4]!=0) {
        	l_10.setText(OrderFood.dishName[4] +"    ----     "+ OrderFood.extraCount[4]);
        }
        if(OrderFood.extraCount[5]!=0) {
        	l_11.setText(OrderFood.dishName[5] +"    ----     "+ OrderFood.extraCount[5]);
        }
        if(OrderFood.extraCount[6]!=0) {
        	l_12.setText(OrderFood.dishName[6] +"    ----     "+ OrderFood.extraCount[6]);
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

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "b1": // Modify
                this.dispose();
                new OrderFood();
                break;

            case "b2": // Continue
               
                if(item=="") {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the option !", "Please choose the option", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int mem = JOptionPane.showConfirmDialog(null, "Do you have a membership number ?", "Please choose one ~", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(mem==0) {
                        this.dispose();
                        new LogIn();
                    }
                    else if(mem==1) {
                        this.dispose();
                        new Pay_out();
                    }                	
                }
                break;

            case "rb_1_1":
                item = "Eat in";
                break;

            case "rb_1_2":           
                item = "Take-away";
                break;
                
            default:
                System.out.println("---ERROR - Detail---");
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
