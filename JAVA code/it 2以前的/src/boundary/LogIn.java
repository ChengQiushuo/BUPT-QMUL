package boundary;
import control.*;
import entity.RamenInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Title        : LogIn.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class LogIn extends JFrame implements ActionListener,json{
    private String temp_num = "";
    private int count = 0;
    String stamps = "";
    private JPanel p;
    private JTextField t;
    private JLabel l_1, l_2, l_3, l_4;
    private JButton b2, b3, b4, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_10, b_11, b_12;
    public static String jsonFile = "./file/memberships.json";
    public static String mem_file = "./file/membership.txt";
    private String stampPic = "./img/s.jpg";
    entity.RamenInfo RamenInfo;

    /**
     * Constructor without parameters.
     */
    public LogIn(RamenInfo RamenInfos) {
        // Set the frame.
        super("Log in");
        RamenInfo = RamenInfos;
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the log in menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Please enter your membership number!"));

        // Set the label.
        l_1 = new JLabel("Please enter your membership number~", JLabel.CENTER);
        l_1.setFont(new Font(null, Font.BOLD, 30));
        l_1.setBounds(135, 70, 700, 50);
        // Add the label to the log in menu.
        p.add(l_1);

        // Set the text field.
        t = new JTextField();
        t.setBounds(193, 188, 186, 60);
        t.setFont(new Font(null, Font.BOLD, 30));
        // Add the text field to the log in menu銆�
        p.add(t);

        // Set the number label.
        l_2 = new JLabel("", JLabel.CENTER);
        l_2.setFont(new Font(null, Font.BOLD, 30));
        l_2.setBounds(185, 188, 186, 60);

        // The picture of the stamp.
        l_3 = new JLabel();
        Icon pic = new ImageIcon(stampPic);
        l_3.setIcon(pic);
        l_3.setBounds(580, 255, 250, 243);
        // Add the picture to the ramen menu.
        p.add(l_3);

        // Set the number.
        l_4 = new JLabel("", JLabel.LEFT);
        l_4.setFont(new Font(null, Font.BOLD, 45));
        l_4.setBounds(850, 465, 130, 70);

        // Set the button set.
        b_1 = new JButton("1");
        b_1.setFont(new Font(null, Font.BOLD, 35));
        b_1.setBounds(123, 280, 100, 68);
        b_1.addActionListener(this);
        b_1.setActionCommand("b_1");
        b_2 = new JButton("2");
        b_2.setFont(new Font(null, Font.BOLD, 35));
        b_2.setBounds(234, 280, 100, 68);
        b_2.addActionListener(this);
        b_2.setActionCommand("b_2");
        b_3 = new JButton("3");
        b_3.setFont(new Font(null, Font.BOLD, 35));
        b_3.setBounds(345, 280, 100, 68);
        b_3.addActionListener(this);
        b_3.setActionCommand("b_3");
        b_4 = new JButton("4");
        b_4.setFont(new Font(null, Font.BOLD, 35));
        b_4.setBounds(123, 355, 100, 68);
        b_4.addActionListener(this);
        b_4.setActionCommand("b_4");
        b_5 = new JButton("5");
        b_5.setFont(new Font(null, Font.BOLD, 35));
        b_5.setBounds(234, 355, 100, 68);
        b_5.addActionListener(this);
        b_5.setActionCommand("b_5");
        b_6 = new JButton("6");
        b_6.setFont(new Font(null, Font.BOLD, 35));
        b_6.setBounds(345, 355, 100, 68);
        b_6.addActionListener(this);
        b_6.setActionCommand("b_6");
        b_7 = new JButton("7");
        b_7.setFont(new Font(null, Font.BOLD, 35));
        b_7.setBounds(123, 430, 100, 68);
        b_7.addActionListener(this);
        b_7.setActionCommand("b_7");
        b_8 = new JButton("8");
        b_8.setFont(new Font(null, Font.BOLD, 35));
        b_8.setBounds(234, 430, 100, 68);
        b_8.addActionListener(this);
        b_8.setActionCommand("b_8");
        b_9 = new JButton("9");
        b_9.setFont(new Font(null, Font.BOLD, 35));
        b_9.setBounds(345, 430, 100, 68);
        b_9.addActionListener(this);
        b_9.setActionCommand("b_9");
        b_10 = new JButton("Clear");
        b_10.setFont(new Font(null, Font.BOLD, 23));
        b_10.setBounds(123, 505, 100, 68);
        b_10.addActionListener(this);
        b_10.setActionCommand("b_10");
        b_11 = new JButton("0");
        b_11.setFont(new Font(null, Font.BOLD, 35));
        b_11.setBounds(234, 505, 100, 68);
        b_11.addActionListener(this);
        b_11.setActionCommand("b_11");
        b_12 = new JButton("OK");
        b_12.setFont(new Font(null, Font.BOLD, 23));
        b_12.setBounds(345, 505, 100, 68);
        b_12.addActionListener(this);
        b_12.setActionCommand("b_12");
        // Add the button set to the log in menu.p.add(b_10);
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

        // Set the Back button.
        JButton b1 = new JButton("Back");
        b1.setFont(new Font(null, Font.BOLD, 20));
        b1.setBounds(180, 633, 200, 60);
        b1.addActionListener(this);
        b1.setActionCommand("b1");
        // Set the Pay button.
        b2 = new JButton("Use Stamp");
        b2.setFont(new Font(null, Font.BOLD, 20));
        b2.setBounds(777, 633, 200, 60);
        b2.addActionListener(this);
        b2.setActionCommand("b2");
        // Set the Not enter button.
        b3 = new JButton("Not enter");
        b3.setFont(new Font(null, Font.BOLD, 20));
        b3.setBounds(405, 633, 200, 60);
        b3.addActionListener(this);
        b3.setActionCommand("b3");
        // Set the Not use button.
        b4 = new JButton("Don't Use Stamp");
        b4.setFont(new Font(null, Font.BOLD, 20));
        b4.setBounds(405, 633, 200, 60);
        b4.addActionListener(this);
        b4.setActionCommand("b4");
        // Add the buttons to the detail menu.
        p.add(b1);
//        p.add(b3);

        // Add the log in menu to the frame.
        this.add(p);

//        try {
//            FileReader fr = new FileReader(mem_file);
//            BufferedReader br = new BufferedReader(fr);
//            while (br.readLine()!=null) {
//                count++;
//            }
//            br.close();
//            fr.close();
//        }
//        catch (Exception error) {
//            System.out.println("membership.txt-count lines");
//        }

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
    	temp_num = t.getText();
        String opt = e.getActionCommand();
        System.out.println(opt);
        switch (opt) {
            case "b1": // Back
                this.dispose();
                new Detail(RamenInfo);
                break;

            case "b2": // Pay
            	if(Integer.parseInt(stamps)<10) {
            		 JOptionPane.showMessageDialog(null, "Your stamps can not afford a ramen,please choose 'don't use stamps' option!", "Not enough", JOptionPane.INFORMATION_MESSAGE);
            	}else {
            		this.dispose();
                    new Pay_in(temp_num,RamenInfo);
            	}
                
               
                break;

//            case "b3": // Not enter
//                this.dispose();
//                new Pay_out();
//                break;

            case "b4": // Not use
                this.dispose();        
                //需要修改
                new Pay_in(temp_num,RamenInfo);
                break;

            case "b_1":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "1";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_2":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "2";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_3":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "3";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_4":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "4";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_5":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "5";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_6":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "6";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_7":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "7";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_8":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "8";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_9":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "9";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_10":
                temp_num  = temp_num.substring(0, temp_num.length() - 1);
                t.setText(temp_num);
                p.updateUI();
                break;

            case "b_11":
                if(temp_num.length()<8) {
                    temp_num = temp_num + "0";
                    t.setText(temp_num);
                    p.updateUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too long", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "b_12":

               
            	System.out.println("q ");
            	System.out.println(temp_num);
                if(temp_num.length()!=8) {
                    JOptionPane.showMessageDialog(null, "Please enter your 8-digit membership number !", "Too short", JOptionPane.INFORMATION_MESSAGE);
                }
                else {

                int flag = 0;

                    JSONObject dataJson = json(jsonFile);
                    JSONArray jsonArray = dataJson.getJSONArray("members");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject info = jsonArray.getJSONObject(i);
                        if(info.getString("member_number").equals(temp_num)) {
                            flag++;
                            stamps = info.getString("stamp");
                            break;
                        }
                    }

                    if(flag==1) {
                        p.remove(t);
                        l_2.setText(temp_num);
                        p.add(l_2);
                        l_4.setText("X " + stamps);
                        p.add(l_4);
                        p.add(b2);
//                        p.remove(b3);
                        p.add(b4);
                        b_1.removeActionListener(this);
                        b_2.removeActionListener(this);
                        b_3.removeActionListener(this);
                        b_4.removeActionListener(this);
                        b_5.removeActionListener(this);
                        b_6.removeActionListener(this);
                        b_7.removeActionListener(this);
                        b_8.removeActionListener(this);
                        b_9.removeActionListener(this);
                        b_10.removeActionListener(this);
                        b_11.removeActionListener(this);
                        b_12.removeActionListener(this);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Not match !", "Sorry", JOptionPane.INFORMATION_MESSAGE);
                        temp_num = "";
                        t.setText(temp_num);
                    }
                }
                p.updateUI();
                break;

            default:
                System.out.println("---ERROR - LogIn---");
        }
    }

    @Override
    public JSONObject json(String file) {
        String l;
        String str;
        String data = "";
        JSONObject dataJson = null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((str=br.readLine())!=null) {
                data = data + str + "\n";
            }
            dataJson= new JSONObject(data);
            br.close();
            fr.close();
        }
        catch (Exception error) {
            System.out.println("");
        }
        return dataJson;
    }
}
