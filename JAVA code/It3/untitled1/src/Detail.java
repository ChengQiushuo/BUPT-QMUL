import javax.swing.*;
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
        p.setBorder(BorderFactory.createTitledBorder("Please check again and pay the bill after choosing the dining options~"));


        // Set the ramen information.
        JLabel l_1 = new JLabel("", JLabel.LEFT);
        l_1.setFont(new Font(null, Font.BOLD, 16));
        l_1.setBounds(30, 70, 750, 18);
        JLabel l_2 = new JLabel("", JLabel.LEFT);
        l_2.setFont(new Font(null, Font.BOLD, 16));
        l_2.setBounds(30, 130, 750, 18);
        JLabel l_3 = new JLabel("", JLabel.LEFT);
        l_3.setFont(new Font(null, Font.BOLD, 16));
        l_3.setBounds(30, 190, 750, 18);
        JLabel l_4 = new JLabel("", JLabel.LEFT);
        l_4.setFont(new Font(null, Font.BOLD, 16));
        l_4.setBounds(30, 250, 750, 18);
        JLabel l_5 = new JLabel("", JLabel.LEFT);
        l_5.setFont(new Font(null, Font.BOLD, 16));
        l_5.setBounds(30, 310, 750, 18);
        // Add the ramen information to the detail menu.
        p.add(l_1);
        p.add(l_2);
        p.add(l_3);
        p.add(l_4);
        p.add(l_5);

        JLabel l_ = new JLabel("ADD-ONs", JLabel.RIGHT);
        l_.setFont(new Font(null, Font.BOLD, 16));
        l_.setBounds(170, 340, 300, 18);
        p.add(l_);
        
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

        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton rb_1_1 = new JRadioButton("Eat in");
        rb_1_1.setFont(new Font(null, Font.BOLD, 15));
        rb_1_1.setBounds(770, 600, 80, 25);
        rb_1_1.addActionListener(this);
        rb_1_1.setActionCommand("rb_1_1");
        JRadioButton rb_1_2 = new JRadioButton("Take-away");
        rb_1_2.setFont(new Font(null, Font.BOLD, 15));
        rb_1_2.setBounds(860, 600, 120, 25);
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
                l_5.setText(OrderFood.ramenOrder[4]);
            case 4:               
                l_4.setText(OrderFood.ramenOrder[3]);
            case 3:         
                l_3.setText(OrderFood.ramenOrder[2]);
            case 2:               
                l_2.setText(OrderFood.ramenOrder[1]);
            case 1:              
                l_1.setText(OrderFood.ramenOrder[0]);              
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
}
