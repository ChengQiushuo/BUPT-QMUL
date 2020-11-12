package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: ModifyCompulsory.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Entity.Compulsory;
import Control.CompulsoryManage.ModifyCompulsory;

/**
 * ClassName: ModifyCompulsoryDish<br>
 * Description: This is the GUI setting interface of a compulsory dish.<br>
 * Function contains: adding options, changing option availability, deleting this dish.
 * @version V4.0
 * @author Hu Zhenming
 */
public class ModifyCompulsoryDish extends JFrame implements ActionListener {
    private int index;
    private String[] availability ;
    private Compulsory compulsory;
    private JPanel p;
    private ModifyCompulsory modifyCompulsory;
    
    /**
	* This constructor used to set up the GUI interface
	* @param index the index of this modifying dish in the array of information about compulsory dishes read from file
	* @throws IOException when reading the dishes information from file failed
	*/
    public ModifyCompulsoryDish (int index) throws IOException {
        // Set the frame.
        super("Modify Compulsory");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);
        
        this.index = index;
        compulsory = ModifyMenu.compulsoryArr[index];
        modifyCompulsory = new ModifyCompulsory();
        availability = compulsory.getAvailability();
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
        // Set add button.
        JButton addOptions = new JButton("Add options");
        addOptions.setFont(new Font(null, Font.BOLD, 20));
        addOptions.setBounds(774, 30, 200, 60);
        addOptions.addActionListener(this);
        addOptions.setActionCommand("addOptions");
        this.add(addOptions);
        // Set delete all button.
        JButton deleteCompulsory = new JButton("Delete compulsory");
        deleteCompulsory.setFont(new Font(null, Font.BOLD, 18));
        deleteCompulsory.setBounds(774, 100, 200, 60);
        deleteCompulsory.addActionListener(this);
        deleteCompulsory.setActionCommand("deleteCompulsory");
        this.add(deleteCompulsory);

        // Set modify menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 618);
        p.setBorder(BorderFactory.createTitledBorder("Modify compulsory dish"));
        // Set the title.
        JLabel l_0 = new JLabel("Modify "+compulsory.getName(), JLabel.CENTER);
        l_0.setFont(new Font(null, Font.BOLD, 30));
        l_0.setBounds(205, 70, 600, 50);
        p.add(l_0);

        // Set items.
        JLabel l_1_1 = new JLabel(compulsory.getOption()[0], JLabel.CENTER);
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

        JLabel l_2_1 = new JLabel(compulsory.getOption()[1], JLabel.CENTER);
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

        JLabel l_3_1 = new JLabel(compulsory.getOption()[2], JLabel.CENTER);
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

        JLabel l_4_1 = new JLabel(compulsory.getOption()[3], JLabel.CENTER);
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

        JLabel l_5_1 = new JLabel(compulsory.getOption()[4], JLabel.CENTER);
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

        JLabel l_6_1 = new JLabel(compulsory.getOption()[5], JLabel.CENTER);
        l_6_1.setFont(new Font(null, Font.BOLD, 25));
        l_6_1.setBounds(700, 343, 180, 30);
        JLabel l_6_2 = new JLabel("Availability:", JLabel.CENTER);
        l_6_2.setFont(new Font(null, Font.BOLD, 16));
        l_6_2.setBounds(635, 398, 120, 20);
        ButtonGroup bg_6 = new ButtonGroup();
        JRadioButton rb_6_1 = new JRadioButton("Yes");
        rb_6_1.setFont(new Font(null, Font.BOLD, 20));
        rb_6_1.setBounds(755, 385, 150, 25);
        rb_6_1.addActionListener(this);
        rb_6_1.setActionCommand("rb_6_1");
        JRadioButton rb_6_2 = new JRadioButton("No");
        rb_6_2.setFont(new Font(null, Font.BOLD, 20));
        rb_6_2.setBounds(755, 412, 150, 25);
        rb_6_2.addActionListener(this);
        rb_6_2.setActionCommand("rb_6_2");
        bg_6.add(rb_6_1);
        bg_6.add(rb_6_2);
        JButton b_6 = new JButton("Delete");
        b_6.setFont(new Font(null, Font.BOLD, 15));
        b_6.setBounds(645, 417, 100, 35);
        b_6.addActionListener(this);
        b_6.setActionCommand("b_6");

        /*show options of this dish dynamically*/
        switch (ModifyMenu.compulsoryInfo.getOptionNumber(index)) {
            case 6://a dish can have up to six options
                p.add(l_6_1);
                p.add(l_6_2);
                p.add(rb_6_1);
                p.add(rb_6_2);
                if(compulsory.getAvailability()[5].equals("Yes")) {
                    rb_6_1.setSelected(true);
                }
                else if(compulsory.getAvailability()[5].equals("No")) {
                    rb_6_2.setSelected(true);
                }
                p.add(b_6);

            case 5:
                p.add(l_5_1);
                p.add(l_5_2);
                p.add(rb_5_1);
                p.add(rb_5_2);
                if(compulsory.getAvailability()[4].equals("Yes")) {
                    rb_5_1.setSelected(true);
                }
                else if(compulsory.getAvailability()[4].equals("No")) {
                    rb_5_2.setSelected(true);
                }
                p.add(b_5);

            case 4:
                p.add(l_4_1);
                p.add(l_4_2);
                p.add(rb_4_1);
                p.add(rb_4_2);
                if(compulsory.getAvailability()[3].equals("Yes")) {
                    rb_4_1.setSelected(true);
                }
                else if(compulsory.getAvailability()[3].equals("No")) {
                    rb_4_2.setSelected(true);
                }
                p.add(b_4);

            case 3:
                p.add(l_3_1);
                p.add(l_3_2);
                p.add(rb_3_1);
                p.add(rb_3_2);
                if(compulsory.getAvailability()[2].equals("Yes")) {
                    rb_3_1.setSelected(true);
                }
                else if(compulsory.getAvailability()[2].equals("No")) {
                    rb_3_2.setSelected(true);
                }
                p.add(b_3);

            case 2:
                p.add(l_2_1);
                p.add(l_2_2);
                p.add(rb_2_1);
                p.add(rb_2_2);
                if(compulsory.getAvailability()[1].equals("Yes")) {
                    rb_2_1.setSelected(true);
                }
                else if(compulsory.getAvailability()[1].equals("No")) {
                    rb_2_2.setSelected(true);
                }
                p.add(b_2);

            case 1:
                p.add(l_1_1);
                p.add(l_1_2);
                p.add(rb_1_1);
                p.add(rb_1_2);
                if(compulsory.getAvailability()[0].equals("Yes")) {
                    rb_1_1.setSelected(true);
                }
                else if(compulsory.getAvailability()[0].equals("No")) {
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
	* This method used to delete an option by getting the number of this option
	* @param num represents the number of the option that wants to be deleted
	*/
    public void deleteOption(int num) {
    	 modifyCompulsory.DeleteCompulsoryOption(this.index,num);
         this.dispose();
         try {
             new ModifyMenu();
         } catch (IOException ex) {
             ex.printStackTrace();
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
            	modifyCompulsory.setOption(this.index,availability);//write availability info back to file
            	this.dispose();
			try {
				new ModifyMenu();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
                break;

            case "cancel":
            	this.dispose();
                new managerLogin();
                break;

            case "b_1"://delete button of an option
                int d_1 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_1==0) {
                	  deleteOption(0);             	 
                }
                break;

            case "b_2":
                int d_2 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_2==0) {
                	 deleteOption(1);          
                }
                break;

            case "b_3":
                int d_3 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_3==0) {
                	 deleteOption(2);          
                }
                break;

            case "b_4":
                int d_4 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_4==0) {
                	 deleteOption(3);          
                }
                break;

            case "b_5":
                int d_5 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_5==0) {
                	 deleteOption(4);          
                }
                break;

            case "b_6":
                int d_6 = JOptionPane.showConfirmDialog(null, "Are you sure to delete it ?", "Attention", JOptionPane.YES_NO_OPTION);
                if(d_6==0) {
                	 deleteOption(5);          
                }
                break;

            case "addOptions":
                this.dispose();
                new AddOption(compulsory.getName(),index);
                break;

            case "deleteCompulsory":
                int d_C = JOptionPane.showConfirmDialog(null, "Are you sure to delete the whole dish ?", "Attention!!!", JOptionPane.YES_NO_OPTION);
                if(d_C==0) {
                  modifyCompulsory.DeleteCompulsory(index);//delete this modifying dish by calling control class to do this
                  this.dispose();
                  try {
					new ModifyMenu();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                  
                }
                break;

            case "rb_1_1"://radio button
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

            case "rb_6_1":
                availability[5] = "Yes";
                break;

            case "rb_6_2":
                availability[5] = "No";
                break;
            default:
                System.out.println("---ERROR---");
        }
    }
}
