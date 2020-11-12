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
    public static String[] item = {null, null, null, null, null, null, null, null, null};

    /**
     * Constructor without parameters.
     */
    public Detail() {
        // Set the frame.
        super("Detail");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the detail menu.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Please check again and pay the bill after choosing the dining options~"));

        // Set labels.
        JLabel l_0_1 = new JLabel("", JLabel.CENTER);
        l_0_1.setFont(new Font(null, Font.BOLD, 16));
        l_0_1.setBounds(810, 40, 100, 18);
        JLabel l_0_2 = new JLabel("", JLabel.CENTER);
        l_0_2.setFont(new Font(null, Font.BOLD, 16));
        l_0_2.setBounds(507, 397, 100, 18);
        // Add the labels to the detail menu.
        p.add(l_0_1);
        p.add(l_0_2);

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

        // Set the additional information.
        JLabel l_6 = new JLabel("", JLabel.RIGHT);
        l_6.setFont(new Font(null, Font.BOLD, 16));
        l_6.setBounds(140, 430, 300, 18);
        JLabel l_7 = new JLabel("", JLabel.RIGHT);
        l_7.setFont(new Font(null, Font.BOLD, 16));
        l_7.setBounds(140, 490, 300, 18);
        JLabel l_8 = new JLabel("", JLabel.RIGHT);
        l_8.setFont(new Font(null, Font.BOLD, 16));
        l_8.setBounds(140, 550, 300, 18);
        JLabel l_9 = new JLabel("", JLabel.RIGHT);
        l_9.setFont(new Font(null, Font.BOLD, 16));
        l_9.setBounds(140, 610, 300, 18);
        // Add the ramen information to the detail menu.
        p.add(l_6);
        p.add(l_7);
        p.add(l_8);
        p.add(l_9);

        // Buttons of dining options.
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton rb_1_1 = new JRadioButton("Eat in");
        rb_1_1.setFont(new Font(null, Font.BOLD, 15));
        rb_1_1.setBounds(770, 67, 80, 25);
        rb_1_1.addActionListener(this);
        rb_1_1.setActionCommand("rb_1_1");
        JRadioButton rb_1_2 = new JRadioButton("Take-away");
        rb_1_2.setFont(new Font(null, Font.BOLD, 15));
        rb_1_2.setBounds(860, 67, 120, 25);
        rb_1_2.addActionListener(this);
        rb_1_2.setActionCommand("rb_1_2");
        ButtonGroup bg2 = new ButtonGroup();
        JRadioButton rb_2_1 = new JRadioButton("Eat in");
        rb_2_1.setFont(new Font(null, Font.BOLD, 15));
        rb_2_1.setBounds(770, 127, 80, 25);
        rb_2_1.addActionListener(this);
        rb_2_1.setActionCommand("rb_2_1");
        JRadioButton rb_2_2 = new JRadioButton("Take-away");
        rb_2_2.setFont(new Font(null, Font.BOLD, 15));
        rb_2_2.setBounds(860, 127, 120, 25);
        rb_2_2.addActionListener(this);
        rb_2_2.setActionCommand("rb_2_2");
        ButtonGroup bg3 = new ButtonGroup();
        JRadioButton rb_3_1 = new JRadioButton("Eat in");
        rb_3_1.setFont(new Font(null, Font.BOLD, 15));
        rb_3_1.setBounds(770, 187, 80, 25);
        rb_3_1.addActionListener(this);
        rb_3_1.setActionCommand("rb_3_1");
        JRadioButton rb_3_2 = new JRadioButton("Take-away");
        rb_3_2.setFont(new Font(null, Font.BOLD, 15));
        rb_3_2.setBounds(860, 187, 120, 25);
        rb_3_2.addActionListener(this);
        rb_3_2.setActionCommand("rb_3_2");
        ButtonGroup bg4 = new ButtonGroup();
        JRadioButton rb_4_1 = new JRadioButton("Eat in");
        rb_4_1.setFont(new Font(null, Font.BOLD, 15));
        rb_4_1.setBounds(770, 247, 80, 25);
        rb_4_1.addActionListener(this);
        rb_4_1.setActionCommand("rb_4_1");
        JRadioButton rb_4_2 = new JRadioButton("Take-away");
        rb_4_2.setFont(new Font(null, Font.BOLD, 15));
        rb_4_2.setBounds(860, 247, 120, 25);
        rb_4_2.addActionListener(this);
        rb_4_2.setActionCommand("rb_4_2");
        ButtonGroup bg5 = new ButtonGroup();
        JRadioButton rb_5_1 = new JRadioButton("Eat in");
        rb_5_1.setFont(new Font(null, Font.BOLD, 15));
        rb_5_1.setBounds(770, 307, 80, 25);
        rb_5_1.addActionListener(this);
        rb_5_1.setActionCommand("rb_5_1");
        JRadioButton rb_5_2 = new JRadioButton("Take-away");
        rb_5_2.setFont(new Font(null, Font.BOLD, 15));
        rb_5_2.setBounds(860, 307, 120, 25);
        rb_5_2.addActionListener(this);
        rb_5_2.setActionCommand("rb_5_2");
        ButtonGroup bg6 = new ButtonGroup();
        JRadioButton rb_6_1 = new JRadioButton("Eat in");
        rb_6_1.setFont(new Font(null, Font.BOLD, 15));
        rb_6_1.setBounds(470, 427, 80, 25);
        rb_6_1.addActionListener(this);
        rb_6_1.setActionCommand("rb_6_1");
        JRadioButton rb_6_2 = new JRadioButton("Take-away");
        rb_6_2.setFont(new Font(null, Font.BOLD, 15));
        rb_6_2.setBounds(560, 427, 120, 25);
        rb_6_2.addActionListener(this);
        rb_6_2.setActionCommand("rb_6_2");
        ButtonGroup bg7 = new ButtonGroup();
        JRadioButton rb_7_1 = new JRadioButton("Eat in");
        rb_7_1.setFont(new Font(null, Font.BOLD, 15));
        rb_7_1.setBounds(470, 487, 80, 25);
        rb_7_1.addActionListener(this);
        rb_7_1.setActionCommand("rb_7_1");
        JRadioButton rb_7_2 = new JRadioButton("Take-away");
        rb_7_2.setFont(new Font(null, Font.BOLD, 15));
        rb_7_2.setBounds(560, 487, 120, 25);
        rb_7_2.addActionListener(this);
        rb_7_2.setActionCommand("rb_7_2");
        ButtonGroup bg8 = new ButtonGroup();
        JRadioButton rb_8_1 = new JRadioButton("Eat in");
        rb_8_1.setFont(new Font(null, Font.BOLD, 15));
        rb_8_1.setBounds(470, 547, 80, 25);
        rb_8_1.addActionListener(this);
        rb_8_1.setActionCommand("rb_8_1");
        JRadioButton rb_8_2 = new JRadioButton("Take-away");
        rb_8_2.setFont(new Font(null, Font.BOLD, 15));
        rb_8_2.setBounds(560, 547, 120, 25);
        rb_8_2.addActionListener(this);
        rb_8_2.setActionCommand("rb_8_2");
        ButtonGroup bg9 = new ButtonGroup();
        JRadioButton rb_9_1 = new JRadioButton("Eat in");
        rb_9_1.setFont(new Font(null, Font.BOLD, 15));
        rb_9_1.setBounds(470, 607, 80, 25);
        rb_9_1.addActionListener(this);
        rb_9_1.setActionCommand("rb_9_1");
        JRadioButton rb_9_2 = new JRadioButton("Take-away");
        rb_9_2.setFont(new Font(null, Font.BOLD, 15));
        rb_9_2.setBounds(560, 607, 120, 25);
        rb_9_2.addActionListener(this);
        rb_9_2.setActionCommand("rb_9_2");
        // Add the buttons to the detail menu.
        bg1.add(rb_1_1);
        bg1.add(rb_1_2);
        bg2.add(rb_2_1);
        bg2.add(rb_2_2);
        bg3.add(rb_3_1);
        bg3.add(rb_3_2);
        bg4.add(rb_4_1);
        bg4.add(rb_4_2);
        bg5.add(rb_5_1);
        bg5.add(rb_5_2);
        bg6.add(rb_6_1);
        bg6.add(rb_6_2);
        bg7.add(rb_7_1);
        bg7.add(rb_7_2);
        bg8.add(rb_8_1);
        bg8.add(rb_8_2);
        bg9.add(rb_9_1);
        bg9.add(rb_9_2);

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
                p.add(rb_5_1);
                p.add(rb_5_2);
                l_5.setText(OrderFood.ramenOrder[4]);

            case 4:
                p.add(rb_4_1);
                p.add(rb_4_2);
                l_4.setText(OrderFood.ramenOrder[3]);

            case 3:
                p.add(rb_3_1);
                p.add(rb_3_2);
                l_3.setText(OrderFood.ramenOrder[2]);

            case 2:
                p.add(rb_2_1);
                p.add(rb_2_2);
                l_2.setText(OrderFood.ramenOrder[1]);

            case 1:
                p.add(rb_1_1);
                p.add(rb_1_2);
                l_1.setText(OrderFood.ramenOrder[0]);
                l_0_1.setText("Must");
                break;

            default:
                l_0_1.setText("");
                l_5.setText("");
                l_4.setText("");
                l_3.setText("");
                l_2.setText("");
                l_1.setText("");
        }
        if(OrderFood.extraNori==0) {
            l_6.setText("");
        }
        else {
            p.add(rb_6_1);
            p.add(rb_6_2);
            l_6.setText("Extra Nori -- " + OrderFood.extraNori);
        }
        if(OrderFood.extraBoiledEgg==0) {
            l_7.setText("");
        }
        else {
            p.add(rb_7_1);
            p.add(rb_7_2);
            l_7.setText("Extra boiled egg -- " + OrderFood.extraBoiledEgg);
        }
        if(OrderFood.bambooShoots==0) {
            l_8.setText("");
        }
        else {
            p.add(rb_8_1);
            p.add(rb_8_2);
            l_8.setText("Bamboo shoots -- " + OrderFood.bambooShoots);
        }
        if(OrderFood.extraChashu==0) {
            l_9.setText("");
        }
        else {
            p.add(rb_9_1);
            p.add(rb_9_2);
            l_9.setText("Extra Chashu -- " + OrderFood.extraChashu);
        }
        if(OrderFood.extraNori==0&&OrderFood.extraBoiledEgg==0&&OrderFood.bambooShoots==0&&OrderFood.extraChashu==0) {
            l_0_2.setText("");
        }
        else {
            l_0_2.setText("Optional");
        }
        item[0] = null;
        item[1] = null;
        item[2] = null;
        item[3] = null;
        item[4] = null;
        item[5] = null;
        item[6] = null;
        item[7] = null;
        item[8] = null;
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
                int temp = 0;
                for(int i=0; i<OrderFood.ramen; i++) {
                    if(item[i]==null) {
                        temp++;
                    }
                }
                if(temp!=0) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen all the must options !", "Please choose all the must options", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int mem = JOptionPane.showConfirmDialog(null, "Do you have a membership number ?", "Please choose one ~", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(mem==0) {
                        this.dispose();
                        new LogIn();
                    }
                    else if(mem==1) {
                        this.dispose();
                        new SignUp();
                    }
                }
                break;

            case "rb_1_1":
                item[0] = "Eat in";
                break;

            case "rb_1_2":
                item[0] = "Take-away";
                break;

            case "rb_2_1":
                item[1] = "Eat in";
                break;

            case "rb_2_2":
                item[1] = "Take-away";
                break;

            case "rb_3_1":
                item[2] = "Eat in";
                break;

            case "rb_3_2":
                item[2] = "Take-away";
                break;

            case "rb_4_1":
                item[3] = "Eat in";
                break;

            case "rb_4_2":
                item[3] = "Take-away";
                break;

            case "rb_5_1":
                item[4] = "Eat in";
                break;

            case "rb_5_2":
                item[4] = "Take-away";
                break;

            case "rb_6_1":
                item[5] = "Eat in";
                break;

            case "rb_6_2":
                item[5] = "Take-away";
                break;

            case "rb_7_1":
                item[6] = "Eat in";
                break;

            case "rb_7_2":
                item[6] = "Take-away";
                break;

            case "rb_8_1":
                item[7] = "Eat in";
                break;

            case "rb_8_2":
                item[7] = "Take-away";
                break;

            case "rb_9_1":
                item[8] = "Eat in";
                break;

            case "rb_9_2":
                item[8] = "Take-away";
                break;

            default:
                System.out.println("---ERROR - Detail---");
        }
    }
}
