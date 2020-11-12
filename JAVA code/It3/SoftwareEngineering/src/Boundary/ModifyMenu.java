package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Entity.*;
import Control.CompulsoryManage.*;
import Control.ExtraManage.*;

/**
 * Title        : ModifyMenu.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class ModifyMenu extends JFrame implements ActionListener {


    public static CompulsoryInfo compulsoryInfo ;
    public static Compulsory[] compulsoryArr ;
    public static int compulsoryNumber;
    public static ExtraInfo extrainfo ;
    public static Extra[] extraArr ;
    public  int extraNumber;

    /**
     * Constructor without parameters.
     */
    public ModifyMenu() throws IOException {
        // Set the frame.
        super("Modify Menu");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);
        
        compulsoryInfo = new CompulsoryInfo();
        extrainfo = new ExtraInfo();
        compulsoryArr = compulsoryInfo.getCompulsoryInfo();
        compulsoryNumber = compulsoryInfo.getCompulsoryNumber();
        extraArr = extrainfo.getExtraInfo();
        extraNumber = extrainfo.getExtraNumber();

        // Set the title.
        JLabel l_0 = new JLabel("Modify Menu", JLabel.CENTER);
        l_0.setBounds(400, 50, 200, 50);
        l_0.setFont(new Font(null, Font.BOLD, 30));
        this.add(l_0);
        // Set back button.
        JButton back = new JButton("Back");
        back.setFont(new Font(null, Font.BOLD, 20));
        back.setBounds(50, 654, 200, 60);
        back.addActionListener(this);
        back.setActionCommand("back");
        this.add(back);
        // Set cancel button.
        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font(null, Font.BOLD, 20));
        cancel.setBounds(774, 654, 200, 60);
        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");
        this.add(cancel);

        // Set compulsory dishes panel.
        JPanel p_l = new JPanel();
        p_l.setLayout(null);
        p_l.setBounds(50, 130, 440, 500);
        p_l.setBorder(BorderFactory.createTitledBorder("Compulsory Dishes"));
        // Set compulsory dishes add button.
        JButton add_l = new JButton("Add");
        add_l.setFont(new Font(null, Font.BOLD, 16));
        add_l.setBounds(330, 440, 100, 50);
        add_l.addActionListener(this);
        add_l.setActionCommand("add_l");
        p_l.add(add_l);
        // Set compulsory dishes items.
        JButton c_1 = new JButton(compulsoryArr[0].getName());
        c_1.setFont(new Font(null, Font.BOLD, 16));
        c_1.setFocusPainted(false); 
        c_1.setBounds(15, 50, 130, 40);
        c_1.addActionListener(this);
        c_1.setActionCommand("c_1");
        JButton c_2 = new JButton(compulsoryArr[1].getName());
        c_2.setFont(new Font(null, Font.BOLD, 16));
        c_2.setBounds(154, 50, 130, 40);
        c_2.addActionListener(this);
        c_2.setActionCommand("c_2");
        JButton c_3 = new JButton(compulsoryArr[2].getName());
        c_3.setFont(new Font(null, Font.BOLD, 16));
        c_3.setBounds(293, 50, 130, 40);
        c_3.addActionListener(this);
        c_3.setActionCommand("c_3");
        JButton c_4 = new JButton(compulsoryArr[3].getName());
        c_4.setFont(new Font(null, Font.BOLD, 16));
        c_4.setBounds(15, 120, 130, 40);
        c_4.addActionListener(this);
        c_4.setActionCommand("c_4");
        JButton c_5 = new JButton(compulsoryArr[4].getName());
        c_5.setFont(new Font(null, Font.BOLD, 16));
        c_5.setBounds(154, 120, 130, 40);
        c_5.addActionListener(this);
        c_5.setActionCommand("c_5");
        JButton c_6 = new JButton(compulsoryArr[5].getName());
        c_6.setFont(new Font(null, Font.BOLD, 16));
        c_6.setBounds(293, 120, 130, 40);
        c_6.addActionListener(this);
        c_6.setActionCommand("c_6");
        JButton c_7 = new JButton(compulsoryArr[6].getName());
        c_7.setFont(new Font(null, Font.BOLD, 16));
        c_7.setBounds(15, 190, 130, 40);
        c_7.addActionListener(this);
        c_7.setActionCommand("c_7");
        JButton c_8 = new JButton(compulsoryArr[7].getName());
        c_8.setFont(new Font(null, Font.BOLD, 16));
        c_8.setBounds(154, 190, 130, 40);
        c_8.addActionListener(this);
        c_8.setActionCommand("c_8");
        JButton c_9 = new JButton(compulsoryArr[8].getName());
        c_9.setFont(new Font(null, Font.BOLD, 16));
        c_9.setBounds(293, 190, 130, 40);
        c_9.addActionListener(this);
        c_9.setActionCommand("c_9");
        JButton c_10 = new JButton(compulsoryArr[9].getName());
        c_10.setFont(new Font(null, Font.BOLD, 16));
        c_10.setBounds(15, 260, 130, 40);
        c_10.addActionListener(this);
        c_10.setActionCommand("c_10");
        JButton c_11 = new JButton(compulsoryArr[10].getName());
        c_11.setFont(new Font(null, Font.BOLD, 16));
        c_11.setBounds(154, 260, 130, 40);
        c_11.addActionListener(this);
        c_11.setActionCommand("c_11");
        JButton c_12 = new JButton(compulsoryArr[11].getName());
        c_12.setFont(new Font(null, Font.BOLD, 16));
        c_12.setBounds(293, 260, 130, 40);
        c_12.addActionListener(this);
        c_12.setActionCommand("c_12");
        JButton c_13 = new JButton(compulsoryArr[12].getName());
        c_13.setFont(new Font(null, Font.BOLD, 16));
        c_13.setBounds(15, 330, 130, 40);
        c_13.addActionListener(this);
        c_13.setActionCommand("c_13");
        JButton c_14 = new JButton(compulsoryArr[13].getName());
        c_14.setFont(new Font(null, Font.BOLD, 16));
        c_14.setBounds(154, 330, 130, 40);
        c_14.addActionListener(this);
        c_14.setActionCommand("c_14");
        JButton c_15 = new JButton(compulsoryArr[14].getName());
        c_15.setFont(new Font(null, Font.BOLD, 16));
        c_15.setBounds(293, 330, 130, 40);
        c_15.addActionListener(this);
        c_15.setActionCommand("c_15");
        switch (compulsoryNumber) {
            case 15:
                p_l.add(c_15);
            case 14:
                p_l.add(c_14);
            case 13:
                p_l.add(c_13);
            case 12:
                p_l.add(c_12);
            case 11:
                p_l.add(c_11);
            case 10:
                p_l.add(c_10);
            case 9:
                p_l.add(c_9);
            case 8:
                p_l.add(c_8);
            case 7:
                p_l.add(c_7);
            case 6:
                p_l.add(c_6);
            case 5:
                p_l.add(c_5);
            case 4:
                p_l.add(c_4);
            case 3:
                p_l.add(c_3);
            case 2:
                p_l.add(c_2);
            case 1:
                p_l.add(c_1);
                break;
            default:
                System.out.println("---ERROR---");
        }
        this.add(p_l);

        // Set extra dishes panel.
        JPanel p_r = new JPanel();
        p_r.setLayout(null);
        p_r.setBounds(534, 130, 440, 500);
        p_r.setBorder(BorderFactory.createTitledBorder("Extra Dishes"));
        // Set extra dishes add button.
        JButton add_r = new JButton("Add");
        add_r.setFont(new Font(null, Font.BOLD, 16));
        add_r.setBounds(330, 440, 100, 50);
        add_r.addActionListener(this);
        add_r.setActionCommand("add_r");
        p_r.add(add_r);
        // Set extra dishes items.
        JButton e_1 = new JButton(extraArr[0].getName());
        e_1.setFont(new Font(null, Font.BOLD, 16));
        e_1.setBounds(13, 50, 200, 40);
        e_1.addActionListener(this);
        e_1.setActionCommand("e_1");
        JButton e_2 = new JButton(extraArr[1].getName());
        e_2.setFont(new Font(null, Font.BOLD, 16));
        e_2.setBounds(225, 50, 200, 40);
        e_2.addActionListener(this);
        e_2.setActionCommand("e_2");
        JButton e_3 = new JButton(extraArr[2].getName());
        e_3.setFont(new Font(null, Font.BOLD, 16));
        e_3.setBounds(13, 120, 200, 40);
        e_3.addActionListener(this);
        e_3.setActionCommand("e_3");
        JButton e_4 = new JButton(extraArr[3].getName());
        e_4.setFont(new Font(null, Font.BOLD, 16));
        e_4.setBounds(225, 120, 200, 40);
        e_4.addActionListener(this);
        e_4.setActionCommand("e_4");
        JButton e_5 = new JButton(extraArr[4].getName());
        e_5.setFont(new Font(null, Font.BOLD, 16));
        e_5.setBounds(13, 190, 200, 40);
        e_5.addActionListener(this);
        e_5.setActionCommand("e_5");
        JButton e_6 = new JButton(extraArr[5].getName());
        e_6.setFont(new Font(null, Font.BOLD, 16));
        e_6.setBounds(225, 190, 200, 40);
        e_6.addActionListener(this);
        e_6.setActionCommand("e_6");
        JButton e_7 = new JButton(extraArr[6].getName());
        e_7.setFont(new Font(null, Font.BOLD, 16));
        e_7.setBounds(13, 260, 200, 40);
        e_7.addActionListener(this);
        e_7.setActionCommand("e_7");
        JButton e_8 = new JButton(extraArr[7].getName());
        e_8.setFont(new Font(null, Font.BOLD, 16));
        e_8.setBounds(225, 260, 200, 40);
        e_8.addActionListener(this);
        e_8.setActionCommand("e_8");
        JButton e_9 = new JButton(extraArr[8].getName());
        e_9.setFont(new Font(null, Font.BOLD, 16));
        e_9.setBounds(13, 330, 200, 40);
        e_9.addActionListener(this);
        e_9.setActionCommand("e_9");
        JButton e_10 = new JButton(extraArr[9].getName());
        e_10.setFont(new Font(null, Font.BOLD, 16));
        e_10.setBounds(225, 330, 200, 40);
        e_10.addActionListener(this);
        e_10.setActionCommand("e_10");
        switch (extraNumber) {
            case 10:
                p_r.add(e_10);
            case 9:
                p_r.add(e_9);
            case 8:
                p_r.add(e_8);
            case 7:
                p_r.add(e_7);
            case 6:
                p_r.add(e_6);
            case 5:
                p_r.add(e_5);
            case 4:
                p_r.add(e_4);
            case 3:
                p_r.add(e_3);
            case 2:
                p_r.add(e_2);
            case 1:
                p_r.add(e_1);
                break;
            default:
                System.out.println("---ERROR---");
        }
        this.add(p_r);

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
            case "back":
            	this.dispose();
            	new managementOptions();
                break;

            case "cancel":
            	this.dispose();
            	new managerLogin();
                break;

            case "add_l":
            	this.setVisible(false);
            	new DishAddChoose();
                break;

            case "add_r":
            	this.setVisible(false);
            	new AddExtraDishes();
                break;

            case "c_1":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_2":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_3":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(2);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_4":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(3);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_5":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(4);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_6":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_7":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(6);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_8":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(7);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_9":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(8);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_10":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(9);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_11":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_12":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(11);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_13":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(12);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_14":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(13);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "c_15":
                this.dispose();
                try {
                    new ModifyCompulsoryDish(14);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_1":
                this.dispose();
                try {
                    new ModifyExtraDish(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_2":
                this.dispose();
                try {
                    new ModifyExtraDish(1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_3":
                this.dispose();
                try {
                    new ModifyExtraDish(2);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_4":
                this.dispose();
                try {
                    new ModifyExtraDish(3);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_5":
                this.dispose();
                try {
                    new ModifyExtraDish(4);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_6":
                this.dispose();
                try {
                    new ModifyExtraDish(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_7":
                this.dispose();
                try {
                    new ModifyExtraDish(6);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_8":
                this.dispose();
                try {
                    new ModifyExtraDish(7);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_9":
                this.dispose();
                try {
                    new ModifyExtraDish(8);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "e_10":
                this.dispose();
                try {
                    new ModifyExtraDish(9);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            default:
                System.out.println("---ERROR---");
        }
    }

    public static void main(String[] args) throws IOException { new ModifyMenu(); }
}
