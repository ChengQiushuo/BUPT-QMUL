package boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.RamenInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Title        : SignUp.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class SignUp extends JFrame implements ActionListener, FocusListener {
    private JPanel p;
    private String temp;
    private String temp_1 = "", temp_2 = "", temp_3 = "", temp_4 = "";
    private String num = "";
    private JTextField t;
    private JTextField t_1, t_2, t_3, t_4;
    private int Caps = 0;
    entity.RamenInfo RamenInfo;
    /**
     * Constructor without parameters.
     */
    public SignUp(RamenInfo RamenInfos) {
        // Set the frame.
        super("Sign up");
        RamenInfo = RamenInfos;
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the sign up menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Come and sign up!"));

        // Set labels.
        JLabel l_0 = new JLabel("Sign up and join the loyalty scheme~", JLabel.CENTER);
        l_0.setFont(new Font(null, Font.BOLD, 30));
        l_0.setBounds(135, 70, 700, 50);
        JLabel l_1 = new JLabel("*First name ", JLabel.RIGHT);
        l_1.setFont(new Font(null, Font.BOLD, 20));
        l_1.setBounds(95, 170, 250, 27);
        JLabel l_2 = new JLabel("*Surname ", JLabel.RIGHT);
        l_2.setFont(new Font(null, Font.BOLD, 20));
        l_2.setBounds(95, 220, 250, 27);
        JLabel l_3 = new JLabel("E-mail ", JLabel.RIGHT);
        l_3.setFont(new Font(null, Font.BOLD, 20));
        l_3.setBounds(95, 270, 250, 27);
        JLabel l_4 = new JLabel("Mobile number ", JLabel.RIGHT);
        l_4.setFont(new Font(null, Font.BOLD, 20));
        l_4.setBounds(95, 320, 250, 27);
        JLabel l_5 = new JLabel("and / or", JLabel.RIGHT);
        l_5.setFont(new Font(null, Font.BOLD, 12));
        l_5.setBounds(76, 301, 250, 16);
        // Add labels to the sign up menu.
        p.add(l_0);
        p.add(l_1);
        p.add(l_2);
        p.add(l_3);
        p.add(l_4);
        p.add(l_5);

        // Set text fields.
        t_1 = new JTextField();
        t_1.setBounds(345, 165, 382, 40);
        t_1.setFont(new Font(null, Font.BOLD, 20));
        t_1.addFocusListener(this);
        t_2 = new JTextField();
        t_2.setBounds(345, 215, 382, 40);
        t_2.setFont(new Font(null, Font.BOLD, 20));
        t_2.addFocusListener(this);
        t_3 = new JTextField();
        t_3.setBounds(345, 265, 382, 40);
        t_3.setFont(new Font(null, Font.BOLD, 20));
        t_3.addFocusListener(this);
        t_4 = new JTextField();
        t_4.setBounds(345, 315, 382, 40);
        t_4.setFont(new Font(null, Font.BOLD, 20));
        t_4.addFocusListener(this);
        // Add text fields to the sign up menu.
        p.add(t_1);
        p.add(t_2);
        p.add(t_3);
        p.add(t_4);

        // Set the clear button.
        JButton b_clear_1 = new JButton("Clear");
        b_clear_1.setFont(new Font(null, Font.BOLD, 22));
        b_clear_1.setBounds(755, 165, 120, 40);
        b_clear_1.addActionListener(this);
        b_clear_1.setActionCommand("b_clear_1");
        JButton b_clear_2 = new JButton("Clear");
        b_clear_2.setFont(new Font(null, Font.BOLD, 22));
        b_clear_2.setBounds(755, 215, 120, 40);
        b_clear_2.addActionListener(this);
        b_clear_2.setActionCommand("b_clear_2");
        JButton b_clear_3 = new JButton("Clear");
        b_clear_3.setFont(new Font(null, Font.BOLD, 22));
        b_clear_3.setBounds(755, 265, 120, 40);
        b_clear_3.addActionListener(this);
        b_clear_3.setActionCommand("b_clear_3");
        JButton b_clear_4 = new JButton("Clear");
        b_clear_4.setFont(new Font(null, Font.BOLD, 22));
        b_clear_4.setBounds(755, 315, 120, 40);
        b_clear_4.addActionListener(this);
        b_clear_4.setActionCommand("b_clear_4");
        // Add the clear button to the sign up menu.
        p.add(b_clear_1);
        p.add(b_clear_2);
        p.add(b_clear_3);
        p.add(b_clear_4);

        // Set the button set.
        JButton b_1 = new JButton("1");
        b_1.setFont(new Font(null, Font.BOLD, 22));
        b_1.setBounds(164, 395, 50, 48);
        b_1.addActionListener(this);
        b_1.setActionCommand("b_1");
        JButton b_2 = new JButton("2");
        b_2.setFont(new Font(null, Font.BOLD, 22));
        b_2.setBounds(222, 395, 50, 48);
        b_2.addActionListener(this);
        b_2.setActionCommand("b_2");
        JButton b_3 = new JButton("3");
        b_3.setFont(new Font(null, Font.BOLD, 22));
        b_3.setBounds(280, 395, 50, 48);
        b_3.addActionListener(this);
        b_3.setActionCommand("b_3");
        JButton b_4 = new JButton("4");
        b_4.setFont(new Font(null, Font.BOLD, 22));
        b_4.setBounds(338, 395, 50, 48);
        b_4.addActionListener(this);
        b_4.setActionCommand("b_4");
        JButton b_5 = new JButton("5");
        b_5.setFont(new Font(null, Font.BOLD, 22));
        b_5.setBounds(396, 395, 50, 48);
        b_5.addActionListener(this);
        b_5.setActionCommand("b_5");
        JButton b_6 = new JButton("6");
        b_6.setFont(new Font(null, Font.BOLD, 22));
        b_6.setBounds(452, 395, 50, 48);
        b_6.addActionListener(this);
        b_6.setActionCommand("b_6");
        JButton b_7 = new JButton("7");
        b_7.setFont(new Font(null, Font.BOLD, 22));
        b_7.setBounds(510, 395, 50, 48);
        b_7.addActionListener(this);
        b_7.setActionCommand("b_7");
        JButton b_8 = new JButton("8");
        b_8.setFont(new Font(null, Font.BOLD, 22));
        b_8.setBounds(568, 395, 50, 48);
        b_8.addActionListener(this);
        b_8.setActionCommand("b_8");
        JButton b_9 = new JButton("9");
        b_9.setFont(new Font(null, Font.BOLD, 22));
        b_9.setBounds(626, 395, 50, 48);
        b_9.addActionListener(this);
        b_9.setActionCommand("b_9");
        JButton b_0 = new JButton("0");
        b_0.setFont(new Font(null, Font.BOLD, 22));
        b_0.setBounds(684, 395, 50, 48);
        b_0.addActionListener(this);
        b_0.setActionCommand("b_0");
        JButton b_Caps = new JButton("Caps");
        b_Caps.setFont(new Font(null, Font.BOLD, 22));
        b_Caps.setBounds(742, 395, 108, 48);
        b_Caps.addActionListener(this);
        b_Caps.setActionCommand("b_Caps");
        JButton b_Q = new JButton("Q");
        b_Q.setFont(new Font(null, Font.BOLD, 18));
        b_Q.setBounds(192, 450, 50, 48);
        b_Q.addActionListener(this);
        b_Q.setActionCommand("b_Q");
        JButton b_W = new JButton("W");
        b_W.setFont(new Font(null, Font.BOLD, 18));
        b_W.setBounds(250, 450, 50, 48);
        b_W.addActionListener(this);
        b_W.setActionCommand("b_W");
        JButton b_E = new JButton("E");
        b_E.setFont(new Font(null, Font.BOLD, 18));
        b_E.setBounds(308, 450, 50, 48);
        b_E.addActionListener(this);
        b_E.setActionCommand("b_E");
        JButton b_R = new JButton("R");
        b_R.setFont(new Font(null, Font.BOLD, 18));
        b_R.setBounds(366, 450, 50, 48);
        b_R.addActionListener(this);
        b_R.setActionCommand("b_R");
        JButton b_T = new JButton("T");
        b_T.setFont(new Font(null, Font.BOLD, 18));
        b_T.setBounds(424, 450, 50, 48);
        b_T.addActionListener(this);
        b_T.setActionCommand("b_T");
        JButton b_Y = new JButton("Y");
        b_Y.setFont(new Font(null, Font.BOLD, 18));
        b_Y.setBounds(482, 450, 50, 48);
        b_Y.addActionListener(this);
        b_Y.setActionCommand("b_Y");
        JButton b_U = new JButton("U");
        b_U.setFont(new Font(null, Font.BOLD, 18));
        b_U.setBounds(540, 450, 50, 48);
        b_U.addActionListener(this);
        b_U.setActionCommand("b_U");
        JButton b_I = new JButton("I");
        b_I.setFont(new Font(null, Font.BOLD, 18));
        b_I.setBounds(598, 450, 50, 48);
        b_I.addActionListener(this);
        b_I.setActionCommand("b_I");
        JButton b_O = new JButton("O");
        b_O.setFont(new Font(null, Font.BOLD, 18));
        b_O.setBounds(656, 450, 50, 48);
        b_O.addActionListener(this);
        b_O.setActionCommand("b_O");
        JButton b_P = new JButton("P");
        b_P.setFont(new Font(null, Font.BOLD, 18));
        b_P.setBounds(714, 450, 50, 48);
        b_P.addActionListener(this);
        b_P.setActionCommand("b_P");
        JButton b_dot = new JButton(".");
        b_dot.setFont(new Font(null, Font.BOLD, 18));
        b_dot.setBounds(772, 450, 50, 48);
        b_dot.addActionListener(this);
        b_dot.setActionCommand("b_.");
        JButton b_A = new JButton("A");
        b_A.setFont(new Font(null, Font.BOLD, 18));
        b_A.setBounds(220, 505, 50, 48);
        b_A.addActionListener(this);
        b_A.setActionCommand("b_A");
        JButton b_S = new JButton("S");
        b_S.setFont(new Font(null, Font.BOLD, 18));
        b_S.setBounds(278, 505, 50, 48);
        b_S.addActionListener(this);
        b_S.setActionCommand("b_S");
        JButton b_D = new JButton("D");
        b_D.setFont(new Font(null, Font.BOLD, 18));
        b_D.setBounds(336, 505, 50, 48);
        b_D.addActionListener(this);
        b_D.setActionCommand("b_D");
        JButton b_F = new JButton("F");
        b_F.setFont(new Font(null, Font.BOLD, 18));
        b_F.setBounds(394, 505, 50, 48);
        b_F.addActionListener(this);
        b_F.setActionCommand("b_F");
        JButton b_G = new JButton("G");
        b_G.setFont(new Font(null, Font.BOLD, 18));
        b_G.setBounds(452, 505, 50, 48);
        b_G.addActionListener(this);
        b_G.setActionCommand("b_G");
        JButton b_H = new JButton("H");
        b_H.setFont(new Font(null, Font.BOLD, 18));
        b_H.setBounds(510, 505, 50, 48);
        b_H.addActionListener(this);
        b_H.setActionCommand("b_H");
        JButton b_J = new JButton("J");
        b_J.setFont(new Font(null, Font.BOLD, 18));
        b_J.setBounds(568, 505, 50, 48);
        b_J.addActionListener(this);
        b_J.setActionCommand("b_J");
        JButton b_K = new JButton("K");
        b_K.setFont(new Font(null, Font.BOLD, 18));
        b_K.setBounds(626, 505, 50, 48);
        b_K.addActionListener(this);
        b_K.setActionCommand("b_K");
        JButton b_L = new JButton("L");
        b_L.setFont(new Font(null, Font.BOLD, 18));
        b_L.setBounds(684, 505, 50, 48);
        b_L.addActionListener(this);
        b_L.setActionCommand("b_L");
        JButton b_zh = new JButton("-");
        b_zh.setFont(new Font(null, Font.BOLD, 18));
        b_zh.setBounds(742, 505, 50, 48);
        b_zh.addActionListener(this);
        b_zh.setActionCommand("b_-");
        JButton b_Z = new JButton("Z");
        b_Z.setFont(new Font(null, Font.BOLD, 18));
        b_Z.setBounds(250, 560, 50, 48);
        b_Z.addActionListener(this);
        b_Z.setActionCommand("b_Z");
        JButton b_X = new JButton("X");
        b_X.setFont(new Font(null, Font.BOLD, 18));
        b_X.setBounds(308, 560, 50, 48);
        b_X.addActionListener(this);
        b_X.setActionCommand("b_X");
        JButton b_C = new JButton("C");
        b_C.setFont(new Font(null, Font.BOLD, 18));
        b_C.setBounds(366, 560, 50, 48);
        b_C.addActionListener(this);
        b_C.setActionCommand("b_C");
        JButton b_V = new JButton("V");
        b_V.setFont(new Font(null, Font.BOLD, 18));
        b_V.setBounds(424, 560, 50, 48);
        b_V.addActionListener(this);
        b_V.setActionCommand("b_V");
        JButton b_B = new JButton("B");
        b_B.setFont(new Font(null, Font.BOLD, 18));
        b_B.setBounds(482, 560, 50, 48);
        b_B.addActionListener(this);
        b_B.setActionCommand("b_B");
        JButton b_N = new JButton("N");
        b_N.setFont(new Font(null, Font.BOLD, 18));
        b_N.setBounds(540, 560, 50, 48);
        b_N.addActionListener(this);
        b_N.setActionCommand("b_N");
        JButton b_M = new JButton("M");
        b_M.setFont(new Font(null, Font.BOLD, 18));
        b_M.setBounds(598, 560, 50, 48);
        b_M.addActionListener(this);
        b_M.setActionCommand("b_M");
        JButton b_at = new JButton("@");
        b_at.setFont(new Font(null, Font.BOLD, 18));
        b_at.setBounds(656, 560, 50, 48);
        b_at.addActionListener(this);
        b_at.setActionCommand("b_@");
        JButton b_xh = new JButton("_");
        b_xh.setFont(new Font(null, Font.BOLD, 18));
        b_xh.setBounds(714, 560, 50, 48);
        b_xh.addActionListener(this);
        b_xh.setActionCommand("b__");
        // Add the button set to the sign up menu.
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(b_4);
        p.add(b_5);
        p.add(b_6);
        p.add(b_7);
        p.add(b_8);
        p.add(b_9);
        p.add(b_0);
        p.add(b_Caps);
        p.add(b_Q);
        p.add(b_W);
        p.add(b_E);
        p.add(b_R);
        p.add(b_T);
        p.add(b_Y);
        p.add(b_U);
        p.add(b_I);
        p.add(b_O);
        p.add(b_P);
        p.add(b_dot);
        p.add(b_A);
        p.add(b_S);
        p.add(b_D);
        p.add(b_F);
        p.add(b_G);
        p.add(b_H);
        p.add(b_J);
        p.add(b_K);
        p.add(b_L);
        p.add(b_zh);
        p.add(b_Z);
        p.add(b_X);
        p.add(b_C);
        p.add(b_V);
        p.add(b_B);
        p.add(b_N);
        p.add(b_M);
        p.add(b_at);
        p.add(b_xh);

        // Set the Back button.
        JButton b1 = new JButton("Back");
        b1.setFont(new Font(null, Font.BOLD, 20));
        b1.setBounds(19, 633, 200, 60);
        b1.addActionListener(this);
        b1.setActionCommand("b1");
        // Set the Finish button.
        JButton b2 = new JButton("Finish");
        b2.setFont(new Font(null, Font.BOLD, 20));
        b2.setBounds(777, 633, 200, 60);
        b2.addActionListener(this);
        b2.setActionCommand("b2");
        // Set the No, thanks button.

        p.add(b1);
        p.add(b2);
//        p.add(b3);

        // Add the sign up menu to the frame.
        this.add(p);

        num = gen_num();

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
     * These methods aim to check if the information is valid.
     */
    public int checkFirstName() {
        String regEx = "^[a-zA-Z.]+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(temp_1);
        if(matcher.matches()==true) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public int checkSurname() {
        String regEx = "^[a-zA-Z.]+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(temp_2);
        if(matcher.matches()==true) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public int checkEmail() {
        String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(temp_3);
        if(matcher.matches()==true) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public int checkMobileNumber() {
        String regEx = "^1[3456789]\\d{9}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(temp_4);
        if(matcher.matches()==true) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * This method aims to generate a new membership number.
     */
    public String gen_num() {
        int[] num = new int[8];
        String s = "";
        String l;
        String[] l_ = new String[6];

        try {
        	 String data = "";
             String str;
             int flag1 = 1;
            FileReader fr1 = new FileReader(LogIn.mem_file);
            FileReader fr2 = new FileReader(LogIn.mem_file);
            FileReader f1 = new FileReader(LogIn.jsonFile);
            BufferedReader br = new BufferedReader(fr1);
            BufferedReader br1 = new BufferedReader(f1);
            while ((str=br1.readLine())!=null) {
                data = data + str + "\n";
            }
            JSONObject dataJson = new JSONObject(data);
            JSONArray jsonArray = dataJson.getJSONArray("members");
            while(flag1==1) {
            	 for(int j=0; j<8; j++) {
                     num[j] = (int)(Math.random()*10);
                     s = s + Integer.toString(num[j]);
                 }
            	 for (int i = 0; i < jsonArray.length(); i++) {
                     JSONObject info = jsonArray.getJSONObject(i);
                     if(info.getString("member_number").equals(s)) {
                         flag1=1;
                         break;
                     }else {
                    	 flag1=0;
                     }
                 }
            	 f1.close();
            	 System.out.println(s);
            }
            s="";
            l = br.readLine();
            if(l==null) {
                for(int i=0; i<8; i++) {
                    num[i] = (int)(Math.random()*10);
                    s = s + Integer.toString(num[i]);
                }
                br.close();
                fr1.close();
            }
            else {
                int count = 1;
                do {
                    for (int i = 0; i < 8; i++) {
                        num[i] = (int) (Math.random() * 10);
                        s = s + Integer.toString(num[i]);
                    }
                    do {
                        l_ = l.split(", ");
                        if (l_[0].equals(s)) {
                            System.out.println(s + " exists");
                            s = "";
                            count = 1;
                            br.close();
                            fr1.close();
                            fr2 = new FileReader(LogIn.mem_file);
                            br = new BufferedReader(fr2);
                            break;
                        }
                        else {
                            count = 0;
                        }
                    } while((l=br.readLine())!=null);
                } while(count==1);
                br.close();
                fr1.close();
                fr2.close();
            }
        }
        catch (Exception error) {
            System.out.println("membership.txt-count lines");
        }

        return s;
    }

    /**
     * This aims to print the registration details.
     */
    public void pirntDetails() {
        System.out.println("======== email/SMS function <=> print =========");
        System.out.println("= Your ticket with the registration details:");
        System.out.println("= Your membership number: " + num);
        System.out.println("= Your first name: " + temp_1);
        System.out.println("= Your surname: " + temp_2);
        System.out.println("= Your email: " + temp_3);
        System.out.println("= Your mobile number: " + temp_4);
        System.out.println("= Your stamps: 0");
        System.out.println("===============================================");
    }

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "b1": // Back
                this.dispose();
                new KioskGui();
                break;

            case "b2": // Finish
            	temp_3 = t_3.getText();
                if(temp_1.length()==0) {
                    JOptionPane.showMessageDialog(null, "Please enter your first name !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(checkFirstName()==0){
                    JOptionPane.showMessageDialog(null, "Please enter your first name in the correct format !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(temp_2.length()==0) {
                    JOptionPane.showMessageDialog(null, "Please enter your surname !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(checkSurname()==0) {
                    JOptionPane.showMessageDialog(null, "Please enter your surname in the correct format !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(temp_3.length()==0&&temp_4.length()==0) {
                    JOptionPane.showMessageDialog(null, "Please enter your email and/or mobile number !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(temp_3.length()!=0&&checkEmail()==0) {
                    JOptionPane.showMessageDialog(null, "Please enter your email in the correct format !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(temp_4.length()!=0&&checkMobileNumber()==0) {
                    JOptionPane.showMessageDialog(null, "Please enter your mobile number in the correct format !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Congratulations!Please check youer email or SMS to get the membership number!", "Registered successfully", JOptionPane.INFORMATION_MESSAGE);
//                    File f = new File(LogIn.jsonFile);	
                    String data="";
                    String str;
                    try {
                    
                 
                        FileReader fr = new FileReader(LogIn.jsonFile);
                        BufferedReader br = new BufferedReader(fr);
                        while ((str=br.readLine())!=null) {
                            data = data + str + "\n";
                        }                     
                        JSONObject dataJson = new JSONObject(data);
                        JSONArray jsonArray = dataJson.getJSONArray("members");
                        br.close();
                        BufferedWriter bw=new BufferedWriter(new FileWriter(LogIn.jsonFile));
                        if(temp_3.length()==0) {
                        	JSONObject object=new JSONObject();
                        	JSONObject member=new JSONObject();
                        	member.put("member_number", num);
                        	member.put("first_name", temp_1);
                        	member.put("last_name", temp_2);
                        	member.put("mobile_number", temp_4);	
                        	member.put("stamps", "0");
                        	
                        	jsonArray.put(member);
                        	
                        	object.put("members", jsonArray);
                        	String jsonString = object.toString();
                        	System.out.println("Json string is: "+jsonString);
                        	bw.write(jsonString);	
                        	bw.close();
                        
                        }
                        else if(temp_4.length()==0) {
                        	JSONObject object=new JSONObject();
                        	JSONObject member=new JSONObject();
                        	member.put("member_number", num);
                        	member.put("first_name", temp_1);
                        	member.put("last_name", temp_2);
                        	member.put("email", temp_3);	
                        	member.put("stamps", "0");
                        	
                        	jsonArray.put(member);
                        
                        	object.put("members", jsonArray);
                        	String jsonString = object.toString();
                        	System.out.println("Json string is: "+jsonString);
                        	bw.write(jsonString);	
                        	bw.close();
                        }
                        else {
                        	JSONObject object=new JSONObject();
                        	JSONObject member=new JSONObject();
                        	member.put("member_number", num);
                        	member.put("first_name", temp_1);
                        	member.put("last_name", temp_2);
                        	member.put("email", temp_3);	
                        	member.put("mobile_number", temp_4);	
                        	member.put("stamps", "0");                
                        	jsonArray.put(member);               	
                        	object.put("members", jsonArray);
                        	String jsonString = object.toString();
                        	System.out.println("Json string is: "+jsonString);
                        	bw.write(jsonString);	
                        	bw.close();
                        }
                       
                    }
                    catch (Exception error) {
                        System.out.println("json.txt");
                    }
                    pirntDetails();
                    this.dispose();
                    new OrderFood(RamenInfo);
                }
                break;

//            case "b3": // No, thanks
//                this.dispose();
//                new Pay_out();
//                break;

            case "b_clear_1":
                if(temp.equals(temp_1)) {
                    temp = "";
                }
                temp_1 = "";
                t_1.setText(temp_1);
                p.updateUI();
                break;

            case "b_clear_2":
                if(temp.equals(temp_2)) {
                    temp = "";
                }
                temp_2 = "";
                t_2.setText(temp_2);
                p.updateUI();
                break;

            case "b_clear_3":
                if(temp.equals(temp_3)) {
                    temp = "";
                }
                temp_3 = "";
                t_3.setText(temp_3);
                p.updateUI();
                break;

            case "b_clear_4":
                if(temp.equals(temp_4)) {
                    temp = "";
                }
                temp_4 = "";
                t_4.setText(temp_4);
                p.updateUI();
                break;

            case "b_1":
                temp = temp + "1";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_2":
                temp = temp + "2";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_3":
                temp = temp + "3";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                System.out.println(temp_1);
                System.out.println("!");
                break;

            case "b_4":
                temp = temp + "4";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_5":
                temp = temp + "5";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_6":
                temp = temp + "6";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_7":
                temp = temp + "7";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_8":
                temp = temp + "8";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_9":
                temp = temp + "9";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_0":
                temp = temp + "0";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_Caps":
                Caps = 1;
                break;

            case "b_Q":
                if(Caps==0) {
                    temp = temp + "q";
                }
                else if(Caps==1) {
                    temp = temp + "Q";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_W":
                if(Caps==0) {
                    temp = temp + "w";
                }
                else if(Caps==1) {
                    temp = temp + "W";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_E":
                if(Caps==0) {
                    temp = temp + "e";
                }
                else if(Caps==1) {
                    temp = temp + "E";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_R":
                if(Caps==0) {
                    temp = temp + "r";
                }
                else if(Caps==1) {
                    temp = temp + "R";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_T":
                if(Caps==0) {
                    temp = temp + "t";
                }
                else if(Caps==1) {
                    temp = temp + "T";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_Y":
                if(Caps==0) {
                    temp = temp + "y";
                }
                else if(Caps==1) {
                    temp = temp + "Y";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_U":
                if(Caps==0) {
                    temp = temp + "u";
                }
                else if(Caps==1) {
                    temp = temp + "U";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_I":
                if(Caps==0) {
                    temp = temp + "i";
                }
                else if(Caps==1) {
                    temp = temp + "I";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_O":
                if(Caps==0) {
                    temp = temp + "o";
                }
                else if(Caps==1) {
                    temp = temp + "O";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_P":
                if(Caps==0) {
                    temp = temp + "p";
                }
                else if(Caps==1) {
                    temp = temp + "P";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_.":
                temp = temp + ".";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_A":
                if(Caps==0) {
                    temp = temp + "a";
                }
                else if(Caps==1) {
                    temp = temp + "A";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_S":
                if(Caps==0) {
                    temp = temp + "s";
                }
                else if(Caps==1) {
                    temp = temp + "S";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_D":
                if(Caps==0) {
                    temp = temp + "d";
                }
                else if(Caps==1) {
                    temp = temp + "D";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_F":
                if(Caps==0) {
                    temp = temp + "f";
                }
                else if(Caps==1) {
                    temp = temp + "F";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_G":
                if(Caps==0) {
                    temp = temp + "g";
                }
                else if(Caps==1) {
                    temp = temp + "G";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_H":
                if(Caps==0) {
                    temp = temp + "h";
                }
                else if(Caps==1) {
                    temp = temp + "H";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_J":
                if(Caps==0) {
                    temp = temp + "j";
                }
                else if(Caps==1) {
                    temp = temp + "J";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_K":
                if(Caps==0) {
                    temp = temp + "k";
                }
                else if(Caps==1) {
                    temp = temp + "K";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_L":
                if(Caps==0) {
                    temp = temp + "l";
                }
                else if(Caps==1) {
                    temp = temp + "L";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_-":
                temp = temp + "-";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_Z":
                if(Caps==0) {
                    temp = temp + "z";
                }
                else if(Caps==1) {
                    temp = temp + "Z";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_X":
                if(Caps==0) {
                    temp = temp + "x";
                }
                else if(Caps==1) {
                    temp = temp + "X";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_C":
                if(Caps==0) {
                    temp = temp + "c";
                }
                else if(Caps==1) {
                    temp = temp + "C";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_V":
                if(Caps==0) {
                    temp = temp + "v";
                }
                else if(Caps==1) {
                    temp = temp + "V";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_B":
                if(Caps==0) {
                    temp = temp + "b";
                }
                else if(Caps==1) {
                    temp = temp + "B";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_N":
                if(Caps==0) {
                    temp = temp + "n";
                }
                else if(Caps==1) {
                    temp = temp + "N";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_M":
                if(Caps==0) {
                    temp = temp + "m";
                }
                else if(Caps==1) {
                    temp = temp + "M";
                    Caps = 0;
                }
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b_@":
                temp = temp + "@";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            case "b__":
                temp = temp + "_";
                t.setText(temp);
                p.updateUI();
                temp_1 = t_1.getText();
                temp_2 = t_2.getText();
                temp_3 = t_3.getText();
                temp_4 = t_4.getText();
                break;

            default:
                System.out.println("---ERROR - SignUp---");
        }
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source==t_1) {
            temp = t_1.getText();
            t = t_1;
        }
        else if(source==t_2) {
            temp = t_2.getText();
            t = t_2;
        }
        else if(source==t_3) {
            temp = t_3.getText();
            t = t_3;
        }
        else if(source==t_4) {
            temp = t_4.getText();
            t = t_4;
        }
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {

    }
}
