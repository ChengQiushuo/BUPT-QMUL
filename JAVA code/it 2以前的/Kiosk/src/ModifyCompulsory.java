import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title        : ModifyCompulsory.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class ModifyCompulsory extends JFrame implements ActionListener {
    private int index;
    private JSONObject dish;
    private JSONArray items;
    private String[] item = new String[9];
    private String[] availability = new String[9];

    private JPanel p;

    /**
     * Constructor without parameters.
     */
    public ModifyCompulsory (int index) throws IOException {
        // Set the frame.
        super("Modify Compulsory");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        this.index = index;
        dish = (JSONObject)ModifyMenu.compulsory_dishes.get(index);
        items = dish.getJSONArray("option");
        for(int i=0; i<items.length(); i++) {
            JSONObject obj = (JSONObject)items.get(i);
            item[i] = obj.getString("item");
            availability[i] = obj.getString("availability");
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
        // Set cancel button.
        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font(null, Font.BOLD, 20));
        cancel.setBounds(774, 654, 200, 60);
        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");
        this.add(cancel);

        // Set modify menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 618);
        p.setBorder(BorderFactory.createTitledBorder("Modify compulsory dish"));
        // Set the title.
        JLabel l_0 = new JLabel("Modify "+dish.getString("name"), JLabel.CENTER);
        l_0.setFont(new Font(null, Font.BOLD, 30));
        l_0.setBounds(205, 70, 600, 50);
        p.add(l_0);

        // Set items.
        JLabel l_1_1 = new JLabel(item[0], JLabel.CENTER);
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

        JLabel l_2_1 = new JLabel(item[1], JLabel.CENTER);
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

        JLabel l_3_1 = new JLabel(item[2], JLabel.CENTER);
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

        JLabel l_4_1 = new JLabel(item[3], JLabel.CENTER);
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

        JLabel l_5_1 = new JLabel(item[4], JLabel.CENTER);
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

        JLabel l_6_1 = new JLabel(item[5], JLabel.CENTER);
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

        JLabel l_7_1 = new JLabel(item[6], JLabel.CENTER);
        l_7_1.setFont(new Font(null, Font.BOLD, 25));
        l_7_1.setBounds(120, 498, 180, 30);
        JLabel l_7_2 = new JLabel("Availability:", JLabel.CENTER);
        l_7_2.setFont(new Font(null, Font.BOLD, 16));
        l_7_2.setBounds(55, 553, 120, 20);
        ButtonGroup bg_7 = new ButtonGroup();
        JRadioButton rb_7_1 = new JRadioButton("Yes");
        rb_7_1.setFont(new Font(null, Font.BOLD, 20));
        rb_7_1.setBounds(175, 540, 150, 25);
        rb_7_1.addActionListener(this);
        rb_7_1.setActionCommand("rb_7_1");
        JRadioButton rb_7_2 = new JRadioButton("No");
        rb_7_2.setFont(new Font(null, Font.BOLD, 20));
        rb_7_2.setBounds(175, 570, 150, 25);
        rb_7_2.addActionListener(this);
        rb_7_2.setActionCommand("rb_7_2");
        bg_7.add(rb_7_1);
        bg_7.add(rb_7_2);

        JLabel l_8_1 = new JLabel(item[7], JLabel.CENTER);
        l_8_1.setFont(new Font(null, Font.BOLD, 25));
        l_8_1.setBounds(410, 498, 180, 30);
        JLabel l_8_2 = new JLabel("Availability:", JLabel.CENTER);
        l_8_2.setFont(new Font(null, Font.BOLD, 16));
        l_8_2.setBounds(345, 553, 120, 20);
        ButtonGroup bg_8 = new ButtonGroup();
        JRadioButton rb_8_1 = new JRadioButton("Yes");
        rb_8_1.setFont(new Font(null, Font.BOLD, 20));
        rb_8_1.setBounds(465, 540, 150, 25);
        rb_8_1.addActionListener(this);
        rb_8_1.setActionCommand("rb_8_1");
        JRadioButton rb_8_2 = new JRadioButton("No");
        rb_8_2.setFont(new Font(null, Font.BOLD, 20));
        rb_8_2.setBounds(465, 570, 150, 25);
        rb_8_2.addActionListener(this);
        rb_8_2.setActionCommand("rb_8_2");
        bg_8.add(rb_8_1);
        bg_8.add(rb_8_2);

        JLabel l_9_1 = new JLabel(item[8], JLabel.CENTER);
        l_9_1.setFont(new Font(null, Font.BOLD, 25));
        l_9_1.setBounds(700, 498, 180, 30);
        JLabel l_9_2 = new JLabel("Availability:", JLabel.CENTER);
        l_9_2.setFont(new Font(null, Font.BOLD, 16));
        l_9_2.setBounds(635, 553, 120, 20);
        ButtonGroup bg_9 = new ButtonGroup();
        JRadioButton rb_9_1 = new JRadioButton("Yes");
        rb_9_1.setFont(new Font(null, Font.BOLD, 20));
        rb_9_1.setBounds(755, 540, 150, 25);
        rb_9_1.addActionListener(this);
        rb_9_1.setActionCommand("rb_9_1");
        JRadioButton rb_9_2 = new JRadioButton("No");
        rb_9_2.setFont(new Font(null, Font.BOLD, 20));
        rb_9_2.setBounds(755, 570, 150, 25);
        rb_9_2.addActionListener(this);
        rb_9_2.setActionCommand("rb_9_2");
        bg_9.add(rb_9_1);
        bg_9.add(rb_9_2);

        switch (items.length()) {
            case 9:
                p.add(l_9_1);
                p.add(l_9_2);
                p.add(rb_9_1);
                p.add(rb_9_2);
                if(availability[8].equals("Yes")) {
                    rb_9_1.setSelected(true);
                }
                else if(availability[8].equals("No")) {
                    rb_9_2.setSelected(true);
                }

            case 8:
                p.add(l_8_1);
                p.add(l_8_2);
                p.add(rb_8_1);
                p.add(rb_8_2);
                if(availability[7].equals("Yes")) {
                    rb_8_1.setSelected(true);
                }
                else if(availability[7].equals("No")) {
                    rb_8_2.setSelected(true);
                }

            case 7:
                p.add(l_7_1);
                p.add(l_7_2);
                p.add(rb_7_1);
                p.add(rb_7_2);
                if(availability[6].equals("Yes")) {
                    rb_7_1.setSelected(true);
                }
                else if(availability[6].equals("No")) {
                    rb_7_2.setSelected(true);
                }

            case 6:
                p.add(l_6_1);
                p.add(l_6_2);
                p.add(rb_6_1);
                p.add(rb_6_2);
                if(availability[5].equals("Yes")) {
                    rb_6_1.setSelected(true);
                }
                else if(availability[5].equals("No")) {
                    rb_6_2.setSelected(true);
                }

            case 5:
                p.add(l_5_1);
                p.add(l_5_2);
                p.add(rb_5_1);
                p.add(rb_5_2);
                if(availability[4].equals("Yes")) {
                    rb_5_1.setSelected(true);
                }
                else if(availability[4].equals("No")) {
                    rb_5_2.setSelected(true);
                }

            case 4:
                p.add(l_4_1);
                p.add(l_4_2);
                p.add(rb_4_1);
                p.add(rb_4_2);
                if(availability[3].equals("Yes")) {
                    rb_4_1.setSelected(true);
                }
                else if(availability[3].equals("No")) {
                    rb_4_2.setSelected(true);
                }

            case 3:
                p.add(l_3_1);
                p.add(l_3_2);
                p.add(rb_3_1);
                p.add(rb_3_2);
                if(availability[2].equals("Yes")) {
                    rb_3_1.setSelected(true);
                }
                else if(availability[2].equals("No")) {
                    rb_3_2.setSelected(true);
                }

            case 2:
                p.add(l_2_1);
                p.add(l_2_2);
                p.add(rb_2_1);
                p.add(rb_2_2);
                if(availability[1].equals("Yes")) {
                    rb_2_1.setSelected(true);
                }
                else if(availability[1].equals("No")) {
                    rb_2_2.setSelected(true);
                }

            case 1:
                p.add(l_1_1);
                p.add(l_1_2);
                p.add(rb_1_1);
                p.add(rb_1_2);
                if(availability[0].equals("Yes")) {
                    rb_1_1.setSelected(true);
                }
                else if(availability[0].equals("No")) {
                    rb_1_2.setSelected(true);
                }
                break;

            default:
                System.out.println("---ERROR---");
        }

        // Add panel to the frame.
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
            case "back":
                this.dispose();
                try {
                    new ModifyMenu();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "ok":
                switch (items.length()) {
                    case 9:
                        ((JSONObject)items.get(8)).put("availability", availability[8]);

                    case 8:
                        ((JSONObject)items.get(7)).put("availability", availability[7]);

                    case 7:
                        ((JSONObject)items.get(6)).put("availability", availability[6]);

                    case 6:
                        ((JSONObject)items.get(5)).put("availability", availability[5]);

                    case 5:
                        ((JSONObject)items.get(4)).put("availability", availability[4]);

                    case 4:
                        ((JSONObject)items.get(3)).put("availability", availability[3]);

                    case 3:
                        ((JSONObject)items.get(2)).put("availability", availability[2]);

                    case 2:
                        ((JSONObject)items.get(1)).put("availability", availability[1]);

                    case 1:
                        ((JSONObject)items.get(0)).put("availability", availability[0]);
                        break;

                    default:
                        System.out.println("---ERROR---");
                }
                try {
                    FileWriter fw = new FileWriter(ModifyMenu.compulsory_url);
                    PrintWriter pw = new PrintWriter(fw);
                    String str[] = ModifyMenu.compulsory.toString().split(",");
                    int i;
                    for(i=0; i<str.length-1; i++) {
                        pw.println(str[i]+",");
                    }
                    pw.println(str[i]);
                    pw.close();
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
                try {
                    new ModifyMenu();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "cancel":
                // 感觉有点鸡肋。。。
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

            case "rb_6_1":
                availability[5] = "Yes";
                break;

            case "rb_6_2":
                availability[5] = "No";
                break;

            case "rb_7_1":
                availability[6] = "Yes";
                break;

            case "rb_7_2":
                availability[6] = "No";
                break;

            case "rb_8_1":
                availability[7] = "Yes";
                break;

            case "rb_8_2":
                availability[7] = "No";
                break;

            case "rb_9_1":
                availability[8] = "Yes";
                break;

            case "rb_9_2":
                availability[8] = "No";
                break;

            default:
                System.out.println("---ERROR---");
        }
    }
}
