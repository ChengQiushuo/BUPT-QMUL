package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: managePayment.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Entity.Payment;
import Control.PaymentManage.*;

/**
 * ClassName: managePayment<br>
 * Description: This is the GUI interface of managing the payment.<br>
 * Like setting availability, adding or deleting a payment way.
 * @version V1.0
 * @author Hu Zhenming
 */
public class managePayment extends JFrame implements ActionListener {

	/*Up to five payment ways*/
    private String[] availability = new String[5];
    private JPanel p;
    /*control class that gets the information about all the payment way from file reading class*/
    private PaymentInfo paymentInfo;
    /*control class that can change the information about payment by file writing class*/
    private ModifyPayment modifyPayment;
    /*array used to store the information about all the payment way*/
    private Payment[] paymentArr;
    /*integer represents the number of existing payment way*/
    private int paymentNum;

 
    /**
	* This constructor used to set up the GUI interface
	* @throws IOException when reading the payment information from file failed
	*/
    public managePayment () throws IOException  {
        // Set the frame.
        super("manage Payment");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);
        paymentInfo = new PaymentInfo();
        modifyPayment = new ModifyPayment();
        paymentArr = paymentInfo.getPaymentInfo();
        paymentNum = paymentInfo.getPaymentNum();
        for(int i=0;i<paymentNum;i++) {
        availability[i] = paymentArr[i].getAvailability();       
        }
      
        // Set back button.
        JButton back = new JButton("Back");
        back.setFont(new Font(null, Font.BOLD, 20));
        back.setBounds(50, 654, 200, 60);
        back.addActionListener(this);
        back.setActionCommand("back");
        this.add(back);
        // Set ok button.
        JButton ok = new JButton("Ok");
        ok.setFont(new Font(null, Font.BOLD, 20));
        ok.setBounds(412, 654, 200, 60);
        ok.addActionListener(this);
        ok.setActionCommand("ok");
        this.add(ok);
        // Set add button.
        JButton add = new JButton("Add");
        add.setFont(new Font(null, Font.BOLD, 20));
        add.setBounds(774, 654, 200, 60);
        add.addActionListener(this);
        add.setActionCommand("add");
        this.add(add);

        
        // Set modify menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 618);
        p.setBorder(BorderFactory.createTitledBorder("managePayment"));
        // Set the title.
        JLabel l_0 = new JLabel("Payment Management", JLabel.CENTER);
        l_0.setFont(new Font(null, Font.BOLD, 30));
        l_0.setBounds(205, 70, 600, 50);
        p.add(l_0);

        // Set items.
        JLabel l_1_1 = new JLabel(paymentArr[0].getName(), JLabel.CENTER);
        l_1_1.setFont(new Font(null, Font.BOLD, 25));
        l_1_1.setBounds(120, 188, 180, 30);
        JLabel l_1_2 = new JLabel("Availability:", JLabel.CENTER);
        l_1_2.setFont(new Font(null, Font.BOLD, 16));
        l_1_2.setBounds(55, 243, 120, 20);
        ButtonGroup bg_1 = new ButtonGroup();
        JRadioButton rb_1_1 = new JRadioButton("Yes");
        rb_1_1.setFont(new Font(null, Font.BOLD, 20));
        rb_1_1.setBounds(175, 230, 150, 25);
        rb_1_1.addActionListener(this);
        rb_1_1.setActionCommand("rb_1_1");
        JRadioButton rb_1_2 = new JRadioButton("No");
        rb_1_2.setFont(new Font(null, Font.BOLD, 20));
        rb_1_2.setBounds(175, 260, 150, 25);
        rb_1_2.addActionListener(this);
        rb_1_2.setActionCommand("rb_1_2");
        bg_1.add(rb_1_1);
        bg_1.add(rb_1_2);
        JButton b_1 = new JButton("Delete");
        b_1.setFont(new Font(null, Font.BOLD, 15));
        b_1.setBounds(65, 265, 100, 35);
        b_1.addActionListener(this);
        b_1.setActionCommand("b_1");

        JLabel l_2_1 = new JLabel(paymentArr[1].getName(), JLabel.CENTER);
        l_2_1.setFont(new Font(null, Font.BOLD, 25));
        l_2_1.setBounds(410, 188, 180, 30);
        JLabel l_2_2 = new JLabel("Availability:", JLabel.CENTER);
        l_2_2.setFont(new Font(null, Font.BOLD, 16));
        l_2_2.setBounds(345, 243, 120, 20);
        ButtonGroup bg_2 = new ButtonGroup();
        JRadioButton rb_2_1 = new JRadioButton("Yes");
        rb_2_1.setFont(new Font(null, Font.BOLD, 20));
        rb_2_1.setBounds(465, 230, 150, 25);
        rb_2_1.addActionListener(this);
        rb_2_1.setActionCommand("rb_2_1");
        JRadioButton rb_2_2 = new JRadioButton("No");
        rb_2_2.setFont(new Font(null, Font.BOLD, 20));
        rb_2_2.setBounds(465, 260, 150, 25);
        rb_2_2.addActionListener(this);
        rb_2_2.setActionCommand("rb_2_2");
        bg_2.add(rb_2_1);
        bg_2.add(rb_2_2);
        JButton b_2 = new JButton("Delete");
        b_2.setFont(new Font(null, Font.BOLD, 15));
        b_2.setBounds(355, 265, 100, 35);
        b_2.addActionListener(this);
        b_2.setActionCommand("b_2");

        JLabel l_3_1 = new JLabel(paymentArr[2].getName(), JLabel.CENTER);
        l_3_1.setFont(new Font(null, Font.BOLD, 25));
        l_3_1.setBounds(700, 188, 180, 30);
        JLabel l_3_2 = new JLabel("Availability:", JLabel.CENTER);
        l_3_2.setFont(new Font(null, Font.BOLD, 16));
        l_3_2.setBounds(635, 243, 120, 20);
        ButtonGroup bg_3 = new ButtonGroup();
        JRadioButton rb_3_1 = new JRadioButton("Yes");
        rb_3_1.setFont(new Font(null, Font.BOLD, 20));
        rb_3_1.setBounds(755, 230, 150, 25);
        rb_3_1.addActionListener(this);
        rb_3_1.setActionCommand("rb_3_1");
        JRadioButton rb_3_2 = new JRadioButton("No");
        rb_3_2.setFont(new Font(null, Font.BOLD, 20));
        rb_3_2.setBounds(755, 260, 150, 25);
        rb_3_2.addActionListener(this);
        rb_3_2.setActionCommand("rb_3_2");
        bg_3.add(rb_3_1);
        bg_3.add(rb_3_2);
        JButton b_3 = new JButton("Delete");
        b_3.setFont(new Font(null, Font.BOLD, 15));
        b_3.setBounds(645, 265, 100, 35);
        b_3.addActionListener(this);
        b_3.setActionCommand("b_3");

        JLabel l_4_1 = new JLabel(paymentArr[3].getName(), JLabel.CENTER);
        l_4_1.setFont(new Font(null, Font.BOLD, 25));
        l_4_1.setBounds(120, 343, 180, 30);
        JLabel l_4_2 = new JLabel("Availability:", JLabel.CENTER);
        l_4_2.setFont(new Font(null, Font.BOLD, 16));
        l_4_2.setBounds(55, 398, 120, 20);
        ButtonGroup bg_4 = new ButtonGroup();
        JRadioButton rb_4_1 = new JRadioButton("Yes");
        rb_4_1.setFont(new Font(null, Font.BOLD, 20));
        rb_4_1.setBounds(175, 385, 150, 25);
        rb_4_1.addActionListener(this);
        rb_4_1.setActionCommand("rb_4_1");
        JRadioButton rb_4_2 = new JRadioButton("No");
        rb_4_2.setFont(new Font(null, Font.BOLD, 20));
        rb_4_2.setBounds(175, 412, 150, 25);
        rb_4_2.addActionListener(this);
        rb_4_2.setActionCommand("rb_4_2");
        bg_4.add(rb_4_1);
        bg_4.add(rb_4_2);
        JButton b_4 = new JButton("Delete");
        b_4.setFont(new Font(null, Font.BOLD, 15));
        b_4.setBounds(65, 417, 100, 35);
        b_4.addActionListener(this);
        b_4.setActionCommand("b_4");

        JLabel l_5_1 = new JLabel(paymentArr[4].getName(), JLabel.CENTER);
        l_5_1.setFont(new Font(null, Font.BOLD, 25));
        l_5_1.setBounds(410, 343, 180, 30);
        JLabel l_5_2 = new JLabel("Availability:", JLabel.CENTER);
        l_5_2.setFont(new Font(null, Font.BOLD, 16));
        l_5_2.setBounds(345, 398, 120, 20);
        ButtonGroup bg_5 = new ButtonGroup();
        JRadioButton rb_5_1 = new JRadioButton("Yes");
        rb_5_1.setFont(new Font(null, Font.BOLD, 20));
        rb_5_1.setBounds(465, 385, 150, 25);
        rb_5_1.addActionListener(this);
        rb_5_1.setActionCommand("rb_5_1");
        JRadioButton rb_5_2 = new JRadioButton("No");
        rb_5_2.setFont(new Font(null, Font.BOLD, 20));
        rb_5_2.setBounds(465, 412, 150, 25);
        rb_5_2.addActionListener(this);
        rb_5_2.setActionCommand("rb_5_2");
        bg_5.add(rb_5_1);
        bg_5.add(rb_5_2);
        JButton b_5 = new JButton("Delete");
        b_5.setFont(new Font(null, Font.BOLD, 15));
        b_5.setBounds(355, 417, 100, 35);
        b_5.addActionListener(this);
        b_5.setActionCommand("b_5");

       
        /*show payment way dynamically*/
        switch (paymentNum) {
         

            case 5:
                p.add(l_5_1);
                p.add(l_5_2);
                p.add(rb_5_1);
                p.add(rb_5_2);
                if(paymentArr[4].getAvailability().equals("Yes")) {
                    rb_5_1.setSelected(true);
                }
                else if(paymentArr[4].getAvailability().equals("No")) {
                    rb_5_2.setSelected(true);
                }
                p.add(b_5);

            case 4:
                p.add(l_4_1);
                p.add(l_4_2);
                p.add(rb_4_1);
                p.add(rb_4_2);
                if(paymentArr[3].getAvailability().equals("Yes")) {
                    rb_4_1.setSelected(true);
                }
                else if(paymentArr[3].getAvailability().equals("No")) {
                    rb_4_2.setSelected(true);
                }

                p.add(b_4);
            case 3:
                p.add(l_3_1);
                p.add(l_3_2);
                p.add(rb_3_1);
                p.add(rb_3_2);
                if(paymentArr[2].getAvailability().equals("Yes")) {
                    rb_3_1.setSelected(true);
                }
                else if(paymentArr[2].getAvailability().equals("No")) {
                    rb_3_2.setSelected(true);
                }
                p.add(b_3);
            case 2:
                p.add(l_2_1);
                p.add(l_2_2);
                p.add(rb_2_1);
                p.add(rb_2_2);
                if(paymentArr[1].getAvailability().equals("Yes")) {
                    rb_2_1.setSelected(true);
                }
                else if(paymentArr[1].getAvailability().equals("No")) {
                    rb_2_2.setSelected(true);
                }
                p.add(b_2);
            case 1:
                p.add(l_1_1);
                p.add(l_1_2);
                p.add(rb_1_1);
                p.add(rb_1_2);
                if(paymentArr[0].getAvailability().equals("Yes")) {
                    rb_1_1.setSelected(true);
                }
                else if(paymentArr[0].getAvailability().equals("No")) {
                    rb_1_2.setSelected(true);
                }
                p.add(b_1);
                break;

            default:
                System.out.println("---ERROR---");
        }

        this.add(p);// Add panel to the frame.

        /**
         * Set the closing operation.
         * Set the frame to non-resizeable.
         * Set the frame to visible.
         */
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
	* Used to react to the event happened on the interface elements
	* @param e the event happened on the interface elements
	*/
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "back":
                this.dispose();
                new managementOptions();//back to previous interface       
                break;

            case "ok":
                switch (paymentNum) {
                
                    case 5:
                    	paymentArr[4].setAvailability(availability[4]);                    
                    case 4:
                    	paymentArr[3].setAvailability(availability[3]);                   
                    case 3:
                    	paymentArr[2].setAvailability(availability[2]);               
                    case 2:
                    	paymentArr[1].setAvailability(availability[1]);         
                    case 1:
                    	paymentArr[0].setAvailability(availability[0]);
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
			    modifyPayment.ChangePayment(paymentArr);//write availability information back to file
                this.dispose();
			    new managementOptions();
                break;

            case "add":
            	this.dispose();
            	new AddPayment();// go to payment adding interface
                break;

            case "rb_1_1":
                availability[0] = "Yes";
                break;

            case "rb_1_2":
                availability[0] = "No";
                break;

            case "rb_2_1":
                availability[1] = "Yes";
                break;

            case "rb_2_2":
                availability[1] = "No";
                break;

            case "rb_3_1":
                availability[2] = "Yes";
                break;

            case "rb_3_2":
                availability[2] = "No";
                break;

            case "rb_4_1":
                availability[3] = "Yes";
                break;

            case "rb_4_2":
                availability[3] = "No";
                break;

            case "rb_5_1":
                availability[4] = "Yes";
                break;

            case "rb_5_2":
                availability[4] = "No";
                break;
            
            case "b_1":
                int d_1 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_1==0) {
                    modifyPayment.deletePayment(0);
                    this.dispose();
                    try {
                        new managePayment();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                break;

            case "b_2":
                int d_2 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_2==0) {
                	  modifyPayment.deletePayment(1);
                      this.dispose();
                      try {
                          new managePayment();
                      } catch (IOException ex) {
                          ex.printStackTrace();
                      }
                }
                break;

            case "b_3":
                int d_3 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_3==0) {
                	  modifyPayment.deletePayment(2);
                      this.dispose();
                      try {
                          new managePayment();
                      } catch (IOException ex) {
                          ex.printStackTrace();
                      }
                }
                break;

            case "b_4":
                int d_4 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_4==0) {
                	  modifyPayment.deletePayment(3);
                      this.dispose();
                      try {
                          new managePayment();
                      } catch (IOException ex) {
                          ex.printStackTrace();
                      }
                }
                break;

            case "b_5":
                int d_5 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_5==0) {
                	  modifyPayment.deletePayment(4);
                      this.dispose();
                      try {
                          new managePayment();
                      } catch (IOException ex) {
                          ex.printStackTrace();
                      }
                }
                break;

            default:
                System.out.println("---PAYMENT ERROR---");
        }
    }
    
}

