package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: ModifyExtraDish.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Entity.Extra;
import Control.ExtraManage.ModifyExtra;

/**
 * ClassName: ModifyExtraDish<br>
 * Description: This is the GUI setting interface of an extra dish.<br>
 * Function contains: changing dish price, changing option availability, deleting this dish.
 * @version V4.0
 * @author Hu Zhenming
 */
public class ModifyExtraDish extends JFrame implements ActionListener {
    private int index;
    private String price = "";
    private String availability = "";
    private JTextField t;
    private JPanel p;
    private Extra extra;
    private ModifyExtra modifyExtra;

    /**
	* This constructor used to set up the GUI interface
	* @param index the index of this modifying dish in the array of information about extra dishes read from file
	* @throws IOException when reading the dishes information from file failed
	*/
    public ModifyExtraDish (int index) throws IOException {
        // Set the frame.
        super("Modify Extra");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        this.index = index;
        extra = ModifyMenu.extraArr[index];
        modifyExtra = new ModifyExtra();

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
        // Set cancel button.
        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font(null, Font.BOLD, 20));
        cancel.setBounds(774, 654, 200, 60);
        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");
        this.add(cancel);
        // Set delete button.
        JButton delete = new JButton("Delete");
        delete.setFont(new Font(null, Font.BOLD, 20));
        delete.setBounds(774, 543, 200, 60);
        delete.addActionListener(this);
        delete.setActionCommand("delete");
        this.add(delete);

        // Set modify menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 618);
        p.setBorder(BorderFactory.createTitledBorder("Modify extra dish"));
        // Set the title.
        JLabel l_0 = new JLabel("Modify "+extra.getName(), JLabel.CENTER);
        l_0.setFont(new Font(null, Font.BOLD, 30));
        l_0.setBounds(205, 70, 600, 50);
        p.add(l_0);
        // Set labels.
        JLabel l_1 = new JLabel("New Price: ￡", JLabel.CENTER);
        l_1.setFont(new Font(null, Font.BOLD, 30));
        l_1.setBounds(130, 188, 200, 60);
        p.add(l_1);
        JLabel l_2 = new JLabel("Availability:", JLabel.CENTER);
        l_2.setFont(new Font(null, Font.BOLD, 30));
        l_2.setBounds(600, 280, 200, 60);
        p.add(l_2);
        JLabel l_3 = new JLabel("Current price: ￡"+String.format("%.2f", extra.getPrice()), JLabel.LEFT);
        l_3.setFont(new Font(null, Font.BOLD, 20));
        l_3.setBounds(731, 395, 246, 30);
        p.add(l_3);
        JLabel l_4 = new JLabel("Current state: "+extra.getAvailability(), JLabel.LEFT);
        l_4.setFont(new Font(null, Font.BOLD, 20));
        l_4.setBounds(731, 445, 246, 30);
        p.add(l_4);

        // Set the text field.
        t = new JTextField();
        t.setBounds(330, 188, 110, 60);
        t.setFont(new Font(null, Font.BOLD, 30));
        p.add(t);

        // Set button set.
        JButton b_1 = new JButton("1");
        b_1.setFont(new Font(null, Font.BOLD, 35));
        b_1.setBounds(123, 280, 100, 68);
        b_1.addActionListener(this);
        b_1.setActionCommand("b_1");
        JButton b_2 = new JButton("2");
        b_2.setFont(new Font(null, Font.BOLD, 35));
        b_2.setBounds(234, 280, 100, 68);
        b_2.addActionListener(this);
        b_2.setActionCommand("b_2");
        JButton b_3 = new JButton("3");
        b_3.setFont(new Font(null, Font.BOLD, 35));
        b_3.setBounds(345, 280, 100, 68);
        b_3.addActionListener(this);
        b_3.setActionCommand("b_3");
        JButton b_4 = new JButton("4");
        b_4.setFont(new Font(null, Font.BOLD, 35));
        b_4.setBounds(123, 355, 100, 68);
        b_4.addActionListener(this);
        b_4.setActionCommand("b_4");
        JButton b_5 = new JButton("5");
        b_5.setFont(new Font(null, Font.BOLD, 35));
        b_5.setBounds(234, 355, 100, 68);
        b_5.addActionListener(this);
        b_5.setActionCommand("b_5");
        JButton b_6 = new JButton("6");
        b_6.setFont(new Font(null, Font.BOLD, 35));
        b_6.setBounds(345, 355, 100, 68);
        b_6.addActionListener(this);
        b_6.setActionCommand("b_6");
        JButton b_7 = new JButton("7");
        b_7.setFont(new Font(null, Font.BOLD, 35));
        b_7.setBounds(123, 430, 100, 68);
        b_7.addActionListener(this);
        b_7.setActionCommand("b_7");
        JButton b_8 = new JButton("8");
        b_8.setFont(new Font(null, Font.BOLD, 35));
        b_8.setBounds(234, 430, 100, 68);
        b_8.addActionListener(this);
        b_8.setActionCommand("b_8");
        JButton b_9 = new JButton("9");
        b_9.setFont(new Font(null, Font.BOLD, 35));
        b_9.setBounds(345, 430, 100, 68);
        b_9.addActionListener(this);
        b_9.setActionCommand("b_9");
        JButton b_10 = new JButton(".");
        b_10.setFont(new Font(null, Font.BOLD, 23));
        b_10.setBounds(123, 505, 100, 68);
        b_10.addActionListener(this);
        b_10.setActionCommand("b_10");
        JButton b_11 = new JButton("0");
        b_11.setFont(new Font(null, Font.BOLD, 35));
        b_11.setBounds(234, 505, 100, 68);
        b_11.addActionListener(this);
        b_11.setActionCommand("b_11");
        JButton b_12 = new JButton("Clear");
        b_12.setFont(new Font(null, Font.BOLD, 23));
        b_12.setBounds(345, 505, 100, 68);
        b_12.addActionListener(this);
        b_12.setActionCommand("b_12");
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(b_4);
        p.add(b_5);
        p.add(b_6);
        p.add(b_7);
        p.add(b_8);
        p.add(b_9);
        p.add(b_10);
        p.add(b_11);
        p.add(b_12);

        // Buttons of availability.
        ButtonGroup bg = new ButtonGroup();
        JRadioButton rb_1 = new JRadioButton("Yes");
        rb_1.setFont(new Font(null, Font.BOLD, 25));
        rb_1.setBounds(800, 280, 150, 25);
        rb_1.addActionListener(this);
        rb_1.setActionCommand("rb_1");
        JRadioButton rb_2 = new JRadioButton("No");
        rb_2.setFont(new Font(null, Font.BOLD, 25));
        rb_2.setBounds(800, 315, 150, 25);
        rb_2.addActionListener(this);
        rb_2.setActionCommand("rb_2");
        bg.add(rb_1);
        bg.add(rb_2);
        p.add(rb_1);
        p.add(rb_2);

        // Set information of the dish.
        price = String.format("%.2f", extra.getPrice());
        t.setText(price);
        if(extra.getAvailability().equals("Yes")) {
            rb_1.setSelected(true);
            availability = "Yes";
        }
        else if(extra.getAvailability().equals("No")) {
            rb_2.setSelected(true);
            availability = "No";
        }
        else {
            System.out.println("No availability");
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
	* This method used to check whether the new price follows the price format
	* @return boolean true new price follows format, otherwise not follow
	*/
    private boolean checkPrice() {
        String regEx = "^[0-9]{1,2}+.[0-9]{2}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(price);
        if(matcher.matches()==true) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
	* Used to react to the event happened on the interface elements
	* @param e the event happened on the interface elements
	*/
    public void actionPerformed(ActionEvent e) {
        String opt = e.getActionCommand();// Get the event.
        switch (opt) {
            case "back":
                this.dispose();
                try {
                    new ModifyMenu();//back to previous interface
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "ok":
                if(price.equals("")) {
                    JOptionPane.showMessageDialog(null, "The price cannot be null !", "Please enter the price again", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(checkPrice()==false) {
                    JOptionPane.showMessageDialog(null, "The format of price is wrong !", "Please enter the price again", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	price = t.getText();
                	modifyExtra.SetExtra(index,price,availability);
                	this.dispose();
                	try {
						new ModifyMenu();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                }
                break;

            case "cancel":
                new managerLogin();
                break;

            case "delete":
                int delete = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(delete==0) {
                	modifyExtra.DeleteExtra(index);
                	this.dispose();
                	try {
						new ModifyMenu();//back to previous interface
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                }
                break;

            case "rb_1"://radio button
                availability = "Yes";
                break;

            case "rb_2":
                availability = "No";
                break;

            case "b_1"://price setting buttons
                price = price + "1";
                t.setText(price);
                p.updateUI();
                break;

            case "b_2":
                price = price + "2";
                t.setText(price);
                p.updateUI();
                break;

            case "b_3":
                price = price + "3";
                t.setText(price);
                p.updateUI();
                break;

            case "b_4":
                price = price + "4";
                t.setText(price);
                p.updateUI();
                break;

            case "b_5":
                price = price + "5";
                t.setText(price);
                p.updateUI();
                break;

            case "b_6":
                price = price + "6";
                t.setText(price);
                p.updateUI();
                break;

            case "b_7":
                price = price + "7";
                t.setText(price);
                p.updateUI();
                break;

            case "b_8":
                price = price + "8";
                t.setText(price);
                p.updateUI();
                break;

            case "b_9":
                price = price + "9";
                t.setText(price);
                p.updateUI();
                break;

            case "b_10":
                price = price + ".";
                t.setText(price);
                p.updateUI();
                break;

            case "b_11":
                price = price + "0";
                t.setText(price);
                p.updateUI();
                break;

            case "b_12":
                price = "";
                t.setText(price);
                p.updateUI();
                break;

            default:
                System.out.println("---ERROR---");
        }
    }
}
