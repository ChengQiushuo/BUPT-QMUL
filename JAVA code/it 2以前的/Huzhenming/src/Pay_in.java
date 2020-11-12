import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Title        : Pay_in.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Pay_in extends JFrame implements ActionListener {
    private String number = null;
    private String payment = null;

    /**
     * Constructor without parameters.
     */
    public Pay_in(String num) {
        // Set the frame.
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        String l;
        String[] l_ = {null, null, null, null, null, null};
        String[] num_ = num.split(", ");
        try {
            FileReader fr = new FileReader(LogIn.mem_file);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                l = br.readLine();
                l_ = l.split(", ");
                if(num_[0].equals(l_[0])) {
                    break;
                }
            }
            number = l_[0];
            br.close();
            fr.close();
        }
        catch (Exception error) {
            System.out.println("membership.txt-pay_in");
        }
        this.setTitle("Pay - " + number + " - Stamps: " + l_[5]);

        // Set the pay_in menu.
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
        JLabel l_6 = new JLabel("", JLabel.LEFT);
        l_6.setFont(new Font(null, Font.BOLD, 16));
        l_6.setBounds(130, 390, 400, 18);
        JLabel l_7 = new JLabel("", JLabel.LEFT);
        l_7.setFont(new Font(null, Font.BOLD, 16));
        l_7.setBounds(130, 450, 400, 18);
        JLabel l_8 = new JLabel("", JLabel.LEFT);
        l_8.setFont(new Font(null, Font.BOLD, 16));
        l_8.setBounds(130, 510, 400, 18);
        JLabel l_9 = new JLabel("", JLabel.LEFT);
        l_9.setFont(new Font(null, Font.BOLD, 16));
        l_9.setBounds(130, 570, 400, 18);
        // Add the ramen information to the detail menu.
        p.add(l_6);
        p.add(l_7);
        p.add(l_8);
        p.add(l_9);

        // Set the sum of the cost.
        if(OrderFood.ramen>0&&Integer.parseInt(l_[5])>=10) {
            JLabel l_10 = new JLabel("￡" + String.format("%.2f", OrderFood.ramen*9.99 + OrderFood.extraNori*1.00 + OrderFood.extraBoiledEgg*1.00 + OrderFood.bambooShoots*1.00 + OrderFood.extraChashu*1.00 - 9.99), JLabel.CENTER);
            l_10.setFont(new Font(null, Font.BOLD, 50));
            l_10.setBounds(590, 400, 333, 60);
            l_10.setForeground(Color.red);
            p.add(l_10);
            JLabel l_11 = new JLabel("Using stamps already -￡9.99", JLabel.CENTER);
            l_11.setFont(new Font(null, Font.BOLD, 13));
            l_11.setBounds(595, 460, 333, 20);
            l_11.setForeground(Color.red);
            p.add(l_11);
        }
        else {
            JLabel l_10 = new JLabel("￡" + String.format("%.2f", OrderFood.ramen*9.99 + OrderFood.extraNori*1.00 + OrderFood.extraBoiledEgg*1.00 + OrderFood.bambooShoots*1.00 + OrderFood.extraChashu*1.00), JLabel.CENTER);
            l_10.setFont(new Font(null, Font.BOLD, 50));
            l_10.setBounds(590, 400, 333, 60);
            p.add(l_10);
        }

        // Buttons of the payment.
        ButtonGroup bg = new ButtonGroup();
        JRadioButton rb_1 = new JRadioButton("Cash");
        rb_1.setFont(new Font(null, Font.BOLD, 30));
        rb_1.setBounds(710, 480, 150, 50);
        rb_1.addActionListener(this);
        rb_1.setActionCommand("rb_1");
        JRadioButton rb_2 = new JRadioButton("Card");
        rb_2.setFont(new Font(null, Font.BOLD, 30));
        rb_2.setBounds(710, 540, 150, 50);
        rb_2.addActionListener(this);
        rb_2.setActionCommand("rb_2");
        // Add the payment to the pay_in menu.
        bg.add(rb_1);
        bg.add(rb_2);
        p.add(rb_1);
        p.add(rb_2);

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
        switch (OrderFood.ramen) {
            case 5:
                l_5.setText(OrderFood.ramenOrder[4] + "  ==>  " + Detail.item[4]);

            case 4:
                l_4.setText(OrderFood.ramenOrder[3] + "  ==>  " + Detail.item[3]);

            case 3:
                l_3.setText(OrderFood.ramenOrder[2] + "  ==>  " + Detail.item[2]);

            case 2:
                l_2.setText(OrderFood.ramenOrder[1] + "  ==>  " + Detail.item[1]);

            case 1:
                l_1.setText(OrderFood.ramenOrder[0] + "  ==>  " + Detail.item[0]);
                break;

            default:
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
            if(Detail.item[5]==null) {
                l_6.setText("Extra Nori -- " + OrderFood.extraNori);
            }
            else {
                l_6.setText("Extra Nori -- " + OrderFood.extraNori + "  ==>  " + Detail.item[5]);
            }
        }
        if(OrderFood.extraBoiledEgg==0) {
            l_7.setText("");
        }
        else {
            if(Detail.item[6]==null) {
                l_7.setText("Extra boiled egg -- " + OrderFood.extraBoiledEgg);
            }
            else {
                l_7.setText("Extra boiled egg -- " + OrderFood.extraBoiledEgg + "  ==>  " + Detail.item[6]);
            }
        }
        if(OrderFood.bambooShoots==0) {
            l_8.setText("");
        }
        else {
            if(Detail.item[7]==null) {
                l_8.setText("Bamboo shoots -- " + OrderFood.bambooShoots);
            }
            else {
                l_8.setText("Bamboo shoots -- " + OrderFood.bambooShoots + "  ==>  " + Detail.item[7]);
            }
        }
        if(OrderFood.extraChashu==0) {
            l_9.setText("");
        }
        else {
            if(Detail.item[8]==null) {
                l_9.setText("Extra Chashu -- " + OrderFood.extraChashu);
            }
            else {
                l_9.setText("Extra Chashu -- " + OrderFood.extraChashu + "  ==>  " + Detail.item[8]);
            }
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
                        try {
                            new Order(payment, number);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        new OrderFood();
                    }
                }
                break;

            case "rb_1": // Cash
                payment = "Cash";
                break;

            case "rb_2": // Card
                payment = "Card";
                break;

            default:
                System.out.println("---ERROR - SignUp---");
        }
    }
}
