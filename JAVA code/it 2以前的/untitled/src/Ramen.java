import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Title        : Ramen.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 2.0
 */
public class Ramen extends JFrame implements ActionListener {
    private String ramenPic_3 = "./img/ramen_02.png";
    private String dish_url = "./dish/compulsory.json";
    private int dish_len;
    private String[] dish_str = new String[9];
    private int[] option_len = new int[9];
    private String[][] option_str = new String[9][6];
    private String[][] availability = new String[9][6];
    private String[] choice = new String[9];
    
    /**
     * Constructor without parameters.
     */
    public Ramen() throws IOException {
        // Set the frame.
        super("Ramen");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the ramen menu.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Please choose the following options~"));

        // The picture of the ramen.
        JLabel ramen_l_0 = new JLabel();
        Icon pic = new ImageIcon(ramenPic_3);
        ramen_l_0.setIcon(pic);
        ramen_l_0.setBounds(666, 111, 300, 290);
        // Add the picture to the ramen menu.
        p.add(ramen_l_0);

        Json();

        // The label.
        JLabel ramen_1 = new JLabel(dish_str[0]+":", JLabel.RIGHT);
        ramen_1.setFont(new Font(null, Font.BOLD, 23));
        ramen_1.setBounds(10, 30, 180, 30);
        // Buttons.
        ButtonGroup bg_1 = new ButtonGroup();
        JRadioButton rb_1_1 = new JRadioButton(option_str[0][0]);
        rb_1_1.setFont(new Font(null, Font.BOLD, 15));
        rb_1_1.setBounds(222, 33, 130, 25);
        rb_1_1.addActionListener(this);
        rb_1_1.setActionCommand("rb_1_1");
        JRadioButton rb_1_2 = new JRadioButton(option_str[0][1]);
        rb_1_2.setFont(new Font(null, Font.BOLD, 15));
        rb_1_2.setBounds(362, 33, 130, 25);
        rb_1_2.addActionListener(this);
        rb_1_2.setActionCommand("rb_1_2");
        JRadioButton rb_1_3 = new JRadioButton(option_str[0][2]);
        rb_1_3.setFont(new Font(null, Font.BOLD, 15));
        rb_1_3.setBounds(502, 33, 130, 25);
        rb_1_3.addActionListener(this);
        rb_1_3.setActionCommand("rb_1_3");
        JRadioButton rb_1_4 = new JRadioButton(option_str[0][3]);
        rb_1_4.setFont(new Font(null, Font.BOLD, 15));
        rb_1_4.setBounds(222, 63, 130, 25);
        rb_1_4.addActionListener(this);
        rb_1_4.setActionCommand("rb_1_4");
        JRadioButton rb_1_5 = new JRadioButton(option_str[0][4]);
        rb_1_5.setFont(new Font(null, Font.BOLD, 15));
        rb_1_5.setBounds(362, 63, 130, 25);
        rb_1_5.addActionListener(this);
        rb_1_5.setActionCommand("rb_1_5");
        JRadioButton rb_1_6 = new JRadioButton(option_str[0][5]);
        rb_1_6.setFont(new Font(null, Font.BOLD, 15));
        rb_1_6.setBounds(502, 63, 130, 25);
        rb_1_6.addActionListener(this);
        rb_1_6.setActionCommand("rb_1_6");
        // Add to the ramen menu.
        bg_1.add(rb_1_1);
        bg_1.add(rb_1_2);
        bg_1.add(rb_1_3);
        bg_1.add(rb_1_4);
        bg_1.add(rb_1_5);
        bg_1.add(rb_1_6);

        // The label.
        JLabel ramen_2 = new JLabel(dish_str[1]+":", JLabel.RIGHT);
        ramen_2.setFont(new Font(null, Font.BOLD, 23));
        ramen_2.setBounds(10, 105, 180, 30);
        // Buttons.
        ButtonGroup bg_2 = new ButtonGroup();
        JRadioButton rb_2_1 = new JRadioButton(option_str[1][0]);
        rb_2_1.setFont(new Font(null, Font.BOLD, 15));
        rb_2_1.setBounds(222, 108, 130, 25);
        rb_2_1.addActionListener(this);
        rb_2_1.setActionCommand("rb_2_1");
        JRadioButton rb_2_2 = new JRadioButton(option_str[1][1]);
        rb_2_2.setFont(new Font(null, Font.BOLD, 15));
        rb_2_2.setBounds(362, 108, 130, 25);
        rb_2_2.addActionListener(this);
        rb_2_2.setActionCommand("rb_2_2");
        JRadioButton rb_2_3 = new JRadioButton(option_str[1][2]);
        rb_2_3.setFont(new Font(null, Font.BOLD, 15));
        rb_2_3.setBounds(502, 108, 130, 25);
        rb_2_3.addActionListener(this);
        rb_2_3.setActionCommand("rb_2_3");
        JRadioButton rb_2_4 = new JRadioButton(option_str[1][3]);
        rb_2_4.setFont(new Font(null, Font.BOLD, 15));
        rb_2_4.setBounds(222, 138, 130, 25);
        rb_2_4.addActionListener(this);
        rb_2_4.setActionCommand("rb_2_4");
        JRadioButton rb_2_5 = new JRadioButton(option_str[1][4]);
        rb_2_5.setFont(new Font(null, Font.BOLD, 15));
        rb_2_5.setBounds(362, 138, 130, 25);
        rb_2_5.addActionListener(this);
        rb_2_5.setActionCommand("rb_2_5");
        JRadioButton rb_2_6 = new JRadioButton(option_str[1][5]);
        rb_2_6.setFont(new Font(null, Font.BOLD, 15));
        rb_2_6.setBounds(502, 138, 130, 25);
        rb_2_6.addActionListener(this);
        rb_2_6.setActionCommand("rb_2_6");
        // Add to the ramen menu.
        bg_2.add(rb_2_1);
        bg_2.add(rb_2_2);
        bg_2.add(rb_2_3);
        bg_2.add(rb_2_4);
        bg_2.add(rb_2_5);
        bg_2.add(rb_2_6);

        // The label.
        JLabel ramen_3 = new JLabel(dish_str[2]+":", JLabel.RIGHT);
        ramen_3.setFont(new Font(null, Font.BOLD, 23));
        ramen_3.setBounds(10, 180, 180, 30);
        // Buttons.
        ButtonGroup bg_3 = new ButtonGroup();
        JRadioButton rb_3_1 = new JRadioButton(option_str[2][0]);
        rb_3_1.setFont(new Font(null, Font.BOLD, 15));
        rb_3_1.setBounds(222, 183, 130, 25);
        rb_3_1.addActionListener(this);
        rb_3_1.setActionCommand("rb_3_1");
        JRadioButton rb_3_2 = new JRadioButton(option_str[2][1]);
        rb_3_2.setFont(new Font(null, Font.BOLD, 15));
        rb_3_2.setBounds(362, 183, 130, 25);
        rb_3_2.addActionListener(this);
        rb_3_2.setActionCommand("rb_3_2");
        JRadioButton rb_3_3 = new JRadioButton(option_str[2][2]);
        rb_3_3.setFont(new Font(null, Font.BOLD, 15));
        rb_3_3.setBounds(502, 183, 130, 25);
        rb_3_3.addActionListener(this);
        rb_3_3.setActionCommand("rb_3_3");
        JRadioButton rb_3_4 = new JRadioButton(option_str[2][3]);
        rb_3_4.setFont(new Font(null, Font.BOLD, 15));
        rb_3_4.setBounds(222, 213, 130, 25);
        rb_3_4.addActionListener(this);
        rb_3_4.setActionCommand("rb_3_4");
        JRadioButton rb_3_5 = new JRadioButton(option_str[2][4]);
        rb_3_5.setFont(new Font(null, Font.BOLD, 15));
        rb_3_5.setBounds(362, 213, 130, 25);
        rb_3_5.addActionListener(this);
        rb_3_5.setActionCommand("rb_3_5");
        JRadioButton rb_3_6 = new JRadioButton(option_str[2][5]);
        rb_3_6.setFont(new Font(null, Font.BOLD, 15));
        rb_3_6.setBounds(502, 213, 130, 25);
        rb_3_6.addActionListener(this);
        rb_3_6.setActionCommand("rb_3_6");
        // Add to the ramen menu.
        bg_3.add(rb_3_1);
        bg_3.add(rb_3_2);
        bg_3.add(rb_3_3);
        bg_3.add(rb_3_4);
        bg_3.add(rb_3_5);
        bg_3.add(rb_3_6);

        // The label.
        JLabel ramen_4 = new JLabel(dish_str[3]+":", JLabel.RIGHT);
        ramen_4.setFont(new Font(null, Font.BOLD, 23));
        ramen_4.setBounds(10, 255, 180, 30);
        // Buttons.
        ButtonGroup bg_4 = new ButtonGroup();
        JRadioButton rb_4_1 = new JRadioButton(option_str[3][0]);
        rb_4_1.setFont(new Font(null, Font.BOLD, 15));
        rb_4_1.setBounds(222, 258, 130, 25);
        rb_4_1.addActionListener(this);
        rb_4_1.setActionCommand("rb_4_1");
        JRadioButton rb_4_2 = new JRadioButton(option_str[3][1]);
        rb_4_2.setFont(new Font(null, Font.BOLD, 15));
        rb_4_2.setBounds(362, 258, 130, 25);
        rb_4_2.addActionListener(this);
        rb_4_2.setActionCommand("rb_4_2");
        JRadioButton rb_4_3 = new JRadioButton(option_str[3][2]);
        rb_4_3.setFont(new Font(null, Font.BOLD, 15));
        rb_4_3.setBounds(502, 258, 130, 25);
        rb_4_3.addActionListener(this);
        rb_4_3.setActionCommand("rb_4_3");
        JRadioButton rb_4_4 = new JRadioButton(option_str[3][3]);
        rb_4_4.setFont(new Font(null, Font.BOLD, 15));
        rb_4_4.setBounds(222, 288, 130, 25);
        rb_4_4.addActionListener(this);
        rb_4_4.setActionCommand("rb_4_4");
        JRadioButton rb_4_5 = new JRadioButton(option_str[3][4]);
        rb_4_5.setFont(new Font(null, Font.BOLD, 15));
        rb_4_5.setBounds(362, 288, 130, 25);
        rb_4_5.addActionListener(this);
        rb_4_5.setActionCommand("rb_4_5");
        JRadioButton rb_4_6 = new JRadioButton(option_str[3][5]);
        rb_4_6.setFont(new Font(null, Font.BOLD, 15));
        rb_4_6.setBounds(502, 288, 130, 25);
        rb_4_6.addActionListener(this);
        rb_4_6.setActionCommand("rb_4_6");
        // Add to the ramen menu.
        bg_4.add(rb_4_1);
        bg_4.add(rb_4_2);
        bg_4.add(rb_4_3);
        bg_4.add(rb_4_4);
        bg_4.add(rb_4_5);
        bg_4.add(rb_4_6);

        // The label.
        JLabel ramen_5 = new JLabel(dish_str[4]+":", JLabel.RIGHT);
        ramen_5.setFont(new Font(null, Font.BOLD, 23));
        ramen_5.setBounds(10, 330, 180, 30);
        // Buttons.
        ButtonGroup bg_5 = new ButtonGroup();
        JRadioButton rb_5_1 = new JRadioButton(option_str[4][0]);
        rb_5_1.setFont(new Font(null, Font.BOLD, 15));
        rb_5_1.setBounds(222, 333, 130, 25);
        rb_5_1.addActionListener(this);
        rb_5_1.setActionCommand("rb_5_1");
        JRadioButton rb_5_2 = new JRadioButton(option_str[4][1]);
        rb_5_2.setFont(new Font(null, Font.BOLD, 15));
        rb_5_2.setBounds(362, 333, 130, 25);
        rb_5_2.addActionListener(this);
        rb_5_2.setActionCommand("rb_5_2");
        JRadioButton rb_5_3 = new JRadioButton(option_str[4][2]);
        rb_5_3.setFont(new Font(null, Font.BOLD, 15));
        rb_5_3.setBounds(502, 333, 130, 25);
        rb_5_3.addActionListener(this);
        rb_5_3.setActionCommand("rb_5_3");
        JRadioButton rb_5_4 = new JRadioButton(option_str[4][3]);
        rb_5_4.setFont(new Font(null, Font.BOLD, 15));
        rb_5_4.setBounds(222, 363, 130, 25);
        rb_5_4.addActionListener(this);
        rb_5_4.setActionCommand("rb_5_4");
        JRadioButton rb_5_5 = new JRadioButton(option_str[4][4]);
        rb_5_5.setFont(new Font(null, Font.BOLD, 15));
        rb_5_5.setBounds(362, 363, 130, 25);
        rb_5_5.addActionListener(this);
        rb_5_5.setActionCommand("rb_5_5");
        JRadioButton rb_5_6 = new JRadioButton(option_str[4][5]);
        rb_5_6.setFont(new Font(null, Font.BOLD, 15));
        rb_5_6.setBounds(502, 363, 130, 25);
        rb_5_6.addActionListener(this);
        rb_5_6.setActionCommand("rb_5_6");
        // Add to the ramen menu.
        bg_5.add(rb_5_1);
        bg_5.add(rb_5_2);
        bg_5.add(rb_5_3);
        bg_5.add(rb_5_4);
        bg_5.add(rb_5_5);
        bg_5.add(rb_5_6);

        // The label.
        JLabel ramen_6 = new JLabel(dish_str[5]+":", JLabel.RIGHT);
        ramen_6.setFont(new Font(null, Font.BOLD, 23));
        ramen_6.setBounds(10, 405, 180, 30);
        // Buttons.
        ButtonGroup bg_6 = new ButtonGroup();
        JRadioButton rb_6_1 = new JRadioButton(option_str[5][0]);
        rb_6_1.setFont(new Font(null, Font.BOLD, 15));
        rb_6_1.setBounds(222, 408, 130, 25);
        rb_6_1.addActionListener(this);
        rb_6_1.setActionCommand("rb_6_1");
        JRadioButton rb_6_2 = new JRadioButton(option_str[5][1]);
        rb_6_2.setFont(new Font(null, Font.BOLD, 15));
        rb_6_2.setBounds(362, 408, 130, 25);
        rb_6_2.addActionListener(this);
        rb_6_2.setActionCommand("rb_6_2");
        JRadioButton rb_6_3 = new JRadioButton(option_str[5][2]);
        rb_6_3.setFont(new Font(null, Font.BOLD, 15));
        rb_6_3.setBounds(502, 408, 130, 25);
        rb_6_3.addActionListener(this);
        rb_6_3.setActionCommand("rb_6_3");
        JRadioButton rb_6_4 = new JRadioButton(option_str[5][3]);
        rb_6_4.setFont(new Font(null, Font.BOLD, 15));
        rb_6_4.setBounds(222, 438, 130, 25);
        rb_6_4.addActionListener(this);
        rb_6_4.setActionCommand("rb_6_4");
        JRadioButton rb_6_5 = new JRadioButton(option_str[5][4]);
        rb_6_5.setFont(new Font(null, Font.BOLD, 15));
        rb_6_5.setBounds(362, 438, 130, 25);
        rb_6_5.addActionListener(this);
        rb_6_5.setActionCommand("rb_6_5");
        JRadioButton rb_6_6 = new JRadioButton(option_str[5][5]);
        rb_6_6.setFont(new Font(null, Font.BOLD, 15));
        rb_6_6.setBounds(502, 438, 130, 25);
        rb_6_6.addActionListener(this);
        rb_6_6.setActionCommand("rb_6_6");
        // Add to the ramen menu.
        bg_6.add(rb_6_1);
        bg_6.add(rb_6_2);
        bg_6.add(rb_6_3);
        bg_6.add(rb_6_4);
        bg_6.add(rb_6_5);
        bg_6.add(rb_6_6);

        // The label.
        JLabel ramen_7 = new JLabel(dish_str[6]+":", JLabel.RIGHT);
        ramen_7.setFont(new Font(null, Font.BOLD, 23));
        ramen_7.setBounds(10, 480, 180, 30);
        // Buttons.
        ButtonGroup bg_7 = new ButtonGroup();
        JRadioButton rb_7_1 = new JRadioButton(option_str[6][0]);
        rb_7_1.setFont(new Font(null, Font.BOLD, 15));
        rb_7_1.setBounds(222, 483, 130, 25);
        rb_7_1.addActionListener(this);
        rb_7_1.setActionCommand("rb_7_1");
        JRadioButton rb_7_2 = new JRadioButton(option_str[6][1]);
        rb_7_2.setFont(new Font(null, Font.BOLD, 15));
        rb_7_2.setBounds(362, 483, 130, 25);
        rb_7_2.addActionListener(this);
        rb_7_2.setActionCommand("rb_7_2");
        JRadioButton rb_7_3 = new JRadioButton(option_str[6][2]);
        rb_7_3.setFont(new Font(null, Font.BOLD, 15));
        rb_7_3.setBounds(502, 483, 130, 25);
        rb_7_3.addActionListener(this);
        rb_7_3.setActionCommand("rb_7_3");
        JRadioButton rb_7_4 = new JRadioButton(option_str[6][3]);
        rb_7_4.setFont(new Font(null, Font.BOLD, 15));
        rb_7_4.setBounds(222, 513, 130, 25);
        rb_7_4.addActionListener(this);
        rb_7_4.setActionCommand("rb_7_4");
        JRadioButton rb_7_5 = new JRadioButton(option_str[6][4]);
        rb_7_5.setFont(new Font(null, Font.BOLD, 15));
        rb_7_5.setBounds(362, 513, 130, 25);
        rb_7_5.addActionListener(this);
        rb_7_5.setActionCommand("rb_7_5");
        JRadioButton rb_7_6 = new JRadioButton(option_str[6][5]);
        rb_7_6.setFont(new Font(null, Font.BOLD, 15));
        rb_7_6.setBounds(502, 513, 130, 25);
        rb_7_6.addActionListener(this);
        rb_7_6.setActionCommand("rb_7_6");
        // Add to the ramen menu.
        bg_7.add(rb_7_1);
        bg_7.add(rb_7_2);
        bg_7.add(rb_7_3);
        bg_7.add(rb_7_4);
        bg_7.add(rb_7_5);
        bg_7.add(rb_7_6);

        // The label.
        JLabel ramen_8 = new JLabel(dish_str[7]+":", JLabel.RIGHT);
        ramen_8.setFont(new Font(null, Font.BOLD, 23));
        ramen_8.setBounds(10, 555, 180, 30);
        // Buttons.
        ButtonGroup bg_8 = new ButtonGroup();
        JRadioButton rb_8_1 = new JRadioButton(option_str[7][0]);
        rb_8_1.setFont(new Font(null, Font.BOLD, 15));
        rb_8_1.setBounds(222, 558, 130, 25);
        rb_8_1.addActionListener(this);
        rb_8_1.setActionCommand("rb_8_1");
        JRadioButton rb_8_2 = new JRadioButton(option_str[7][1]);
        rb_8_2.setFont(new Font(null, Font.BOLD, 15));
        rb_8_2.setBounds(362, 558, 130, 25);
        rb_8_2.addActionListener(this);
        rb_8_2.setActionCommand("rb_8_2");
        JRadioButton rb_8_3 = new JRadioButton(option_str[7][2]);
        rb_8_3.setFont(new Font(null, Font.BOLD, 15));
        rb_8_3.setBounds(502, 558, 130, 25);
        rb_8_3.addActionListener(this);
        rb_8_3.setActionCommand("rb_8_3");
        JRadioButton rb_8_4 = new JRadioButton(option_str[7][3]);
        rb_8_4.setFont(new Font(null, Font.BOLD, 15));
        rb_8_4.setBounds(222, 588, 130, 25);
        rb_8_4.addActionListener(this);
        rb_8_4.setActionCommand("rb_8_4");
        JRadioButton rb_8_5 = new JRadioButton(option_str[7][4]);
        rb_8_5.setFont(new Font(null, Font.BOLD, 15));
        rb_8_5.setBounds(362, 588, 130, 25);
        rb_8_5.addActionListener(this);
        rb_8_5.setActionCommand("rb_8_5");
        JRadioButton rb_8_6 = new JRadioButton(option_str[7][5]);
        rb_8_6.setFont(new Font(null, Font.BOLD, 15));
        rb_8_6.setBounds(502, 588, 130, 25);
        rb_8_6.addActionListener(this);
        rb_8_6.setActionCommand("rb_8_6");
        // Add to the ramen menu.
        bg_8.add(rb_8_1);
        bg_8.add(rb_8_2);
        bg_8.add(rb_8_3);
        bg_8.add(rb_8_4);
        bg_8.add(rb_8_5);
        bg_8.add(rb_8_6);

        // The label.
        JLabel ramen_9 = new JLabel(dish_str[8]+":", JLabel.CENTER);
        ramen_9.setFont(new Font(null, Font.BOLD, 23));
        ramen_9.setBounds(725, 450, 180, 30);
        // Buttons.
        ButtonGroup bg_9 = new ButtonGroup();
        JRadioButton rb_9_1 = new JRadioButton(option_str[8][0]);
        rb_9_1.setFont(new Font(null, Font.BOLD, 15));
        rb_9_1.setBounds(691, 503, 130, 25);
        rb_9_1.addActionListener(this);
        rb_9_1.setActionCommand("rb_9_1");
        JRadioButton rb_9_2 = new JRadioButton(option_str[8][1]);
        rb_9_2.setFont(new Font(null, Font.BOLD, 15));
        rb_9_2.setBounds(831, 503, 130, 25);
        rb_9_2.addActionListener(this);
        rb_9_2.setActionCommand("rb_9_2");
        JRadioButton rb_9_3 = new JRadioButton(option_str[8][2]);
        rb_9_3.setFont(new Font(null, Font.BOLD, 15));
        rb_9_3.setBounds(691, 533, 130, 25);
        rb_9_3.addActionListener(this);
        rb_9_3.setActionCommand("rb_9_3");
        JRadioButton rb_9_4 = new JRadioButton(option_str[8][3]);
        rb_9_4.setFont(new Font(null, Font.BOLD, 15));
        rb_9_4.setBounds(831, 533, 130, 25);
        rb_9_4.addActionListener(this);
        rb_9_4.setActionCommand("rb_9_4");
        JRadioButton rb_9_5 = new JRadioButton(option_str[8][4]);
        rb_9_5.setFont(new Font(null, Font.BOLD, 15));
        rb_9_5.setBounds(691, 563, 130, 25);
        rb_9_5.addActionListener(this);
        rb_9_5.setActionCommand("rb_9_5");
        JRadioButton rb_9_6 = new JRadioButton(option_str[8][5]);
        rb_9_6.setFont(new Font(null, Font.BOLD, 15));
        rb_9_6.setBounds(831, 563, 130, 25);
        rb_9_6.addActionListener(this);
        rb_9_6.setActionCommand("rb_9_6");
        // Add to the ramen menu.
        bg_9.add(rb_9_1);
        bg_9.add(rb_9_2);
        bg_9.add(rb_9_3);
        bg_9.add(rb_9_4);
        bg_9.add(rb_9_5);
        bg_9.add(rb_9_6);

        switch (dish_len) {
            case 9:
                p.add(ramen_9);
                switch (option_len[8]) {
                    case 6:
                        p.add(rb_9_6);
                        if(availability[8][5].equals("No")) {
                            rb_9_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_9_5);
                        if(availability[8][4].equals("No")) {
                            rb_9_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_9_4);
                        if(availability[8][3].equals("No")) {
                            rb_9_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_9_3);
                        if(availability[8][2].equals("No")) {
                            rb_9_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_9_2);
                        if(availability[8][1].equals("No")) {
                            rb_9_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_9_1);
                        if(availability[8][0].equals("No")) {
                            rb_9_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(8);

            case 8:
                p.add(ramen_8);
                switch (option_len[7]) {
                    case 6:
                        p.add(rb_8_6);
                        if(availability[7][5].equals("No")) {
                            rb_8_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_8_5);
                        if(availability[7][4].equals("No")) {
                            rb_8_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_8_4);
                        if(availability[7][3].equals("No")) {
                            rb_8_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_8_3);
                        if(availability[7][2].equals("No")) {
                            rb_8_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_8_2);
                        if(availability[7][1].equals("No")) {
                            rb_8_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_8_1);
                        if(availability[7][0].equals("No")) {
                            rb_8_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(7);

            case 7:
                p.add(ramen_7);
                switch (option_len[6]) {
                    case 6:
                        p.add(rb_7_6);
                        if(availability[6][5].equals("No")) {
                            rb_7_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_7_5);
                        if(availability[6][4].equals("No")) {
                            rb_7_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_7_4);
                        if(availability[6][3].equals("No")) {
                            rb_7_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_7_3);
                        if(availability[6][2].equals("No")) {
                            rb_7_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_7_2);
                        if(availability[6][1].equals("No")) {
                            rb_7_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_7_1);
                        if(availability[6][0].equals("No")) {
                            rb_7_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(6);

            case 6:
                p.add(ramen_6);
                switch (option_len[5]) {
                    case 6:
                        p.add(rb_6_6);
                        if(availability[5][5].equals("No")) {
                            rb_6_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_6_5);
                        if(availability[5][4].equals("No")) {
                            rb_6_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_6_4);
                        if(availability[5][3].equals("No")) {
                            rb_6_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_6_3);
                        if(availability[5][2].equals("No")) {
                            rb_6_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_6_2);
                        if(availability[5][1].equals("No")) {
                            rb_6_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_6_1);
                        if(availability[5][0].equals("No")) {
                            rb_6_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(5);

            case 5:
                p.add(ramen_5);
                switch (option_len[4]) {
                    case 6:
                        p.add(rb_5_6);
                        if(availability[4][5].equals("No")) {
                            rb_5_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_5_5);
                        if(availability[4][4].equals("No")) {
                            rb_5_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_5_4);
                        if(availability[4][3].equals("No")) {
                            rb_5_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_5_3);
                        if(availability[4][2].equals("No")) {
                            rb_5_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_5_2);
                        if(availability[4][1].equals("No")) {
                            rb_5_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_5_1);
                        if(availability[4][0].equals("No")) {
                            rb_5_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(4);

            case 4:
                p.add(ramen_4);
                switch (option_len[3]) {
                    case 6:
                        p.add(rb_4_6);
                        if(availability[3][5].equals("No")) {
                            rb_4_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_4_5);
                        if(availability[3][4].equals("No")) {
                            rb_4_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_4_4);
                        if(availability[3][3].equals("No")) {
                            rb_4_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_4_3);
                        if(availability[3][2].equals("No")) {
                            rb_4_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_4_2);
                        if(availability[3][1].equals("No")) {
                            rb_4_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_4_1);
                        if(availability[3][0].equals("No")) {
                            rb_4_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(3);

            case 3:
                p.add(ramen_3);
                switch (option_len[2]) {
                    case 6:
                        p.add(rb_3_6);
                        if(availability[2][5].equals("No")) {
                            rb_3_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_3_5);
                        if(availability[2][4].equals("No")) {
                            rb_3_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_3_4);
                        if(availability[2][3].equals("No")) {
                            rb_3_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_3_3);
                        if(availability[2][2].equals("No")) {
                            rb_3_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_3_2);
                        if(availability[2][1].equals("No")) {
                            rb_3_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_3_1);
                        if(availability[2][0].equals("No")) {
                            rb_3_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(2);

            case 2:
                p.add(ramen_2);
                switch (option_len[1]) {
                    case 6:
                        p.add(rb_2_6);
                        if(availability[1][5].equals("No")) {
                            rb_2_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_2_5);
                        if(availability[1][4].equals("No")) {
                            rb_2_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_2_4);
                        if(availability[1][3].equals("No")) {
                            rb_2_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_2_3);
                        if(availability[1][2].equals("No")) {
                            rb_2_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_2_2);
                        if(availability[1][1].equals("No")) {
                            rb_2_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_2_1);
                        if(availability[1][0].equals("No")) {
                            rb_2_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(1);

            case 1:
                p.add(ramen_1);
                switch (option_len[0]) {
                    case 6:
                        p.add(rb_1_6);
                        if(availability[0][5].equals("No")) {
                            rb_1_6.setEnabled(false);
                        }
                    case 5:
                        p.add(rb_1_5);
                        if(availability[0][4].equals("No")) {
                            rb_1_5.setEnabled(false);
                        }
                    case 4:
                        p.add(rb_1_4);
                        if(availability[0][3].equals("No")) {
                            rb_1_4.setEnabled(false);
                        }
                    case 3:
                        p.add(rb_1_3);
                        if(availability[0][2].equals("No")) {
                            rb_1_3.setEnabled(false);
                        }
                    case 2:
                        p.add(rb_1_2);
                        if(availability[0][1].equals("No")) {
                            rb_1_2.setEnabled(false);
                        }
                    case 1:
                        p.add(rb_1_1);
                        if(availability[0][0].equals("No")) {
                            rb_1_1.setEnabled(false);
                        }
                        break;
                    default:
                        System.out.println("---ERROR---");
                }
                check(0);
                break;

            default:
                System.out.println("---ERROR---");
        }

        // Set the Cancel button.
        JButton b_1 = new JButton("Cancel");
        b_1.setFont(new Font(null, Font.BOLD, 20));
        b_1.setBounds(19, 633, 200, 60);
        b_1.addActionListener(this);
        b_1.setActionCommand("b_1");
        // Set the Confirm button.
        JButton b_2 = new JButton("Confirm");
        b_2.setFont(new Font(null, Font.BOLD, 20));
        b_2.setBounds(777, 633, 200, 60);
        b_2.addActionListener(this);
        b_2.setActionCommand("b_2");
        // Add the buttons to the ramen menu.
        p.add(b_1);
        p.add(b_2);

        // Add the ramen menu to the frame.
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

    private void Json() throws IOException {
        String dish_temp = "";
        String dish_string = "";
        FileReader dish_fr = new FileReader(dish_url);
        BufferedReader dish_br = new BufferedReader(dish_fr);
        while ((dish_temp=dish_br.readLine())!=null) {
            dish_string = dish_string + dish_temp + "\n";
        }
        JSONObject dish = new JSONObject(dish_string);
        JSONArray dishes = dish.getJSONArray("dishes");
        dish_len = dishes.length();
        for(int i=0; i<dish_len; i++) {
            JSONObject obj_i = (JSONObject)dishes.get(i);
            dish_str[i] = obj_i.getString("name");
            JSONArray options = obj_i.getJSONArray("option");
            option_len[i] = options.length();
            for(int j=0; j<option_len[i]; j++) {
                JSONObject obj_j = (JSONObject)options.get(j);
                option_str[i][j] = obj_j.getString("item");
                availability[i][j] = obj_j.getString("availability");
            }
        }
        dish_br.close();
        dish_fr.close();
        /*System.out.println(dish_len);
        for(int i=0; i<8; i++) {
            System.out.print(option_len[i]+" ");
        }
        System.out.println(option_len[8]);
        for(int i=0; i<9; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(availability[i][j]+" ");
            }
            System.out.println(availability[i][5]);
        }*/
    }

    private void check(int num) {
        int count=0;
        for(int i=0; i<option_len[num]; i++) {
            if(availability[num][i].equals("No")) {
                count++;
            }
        }
        if(count==option_len[num]) {
            choice[num] = "...";
        }
    }

    private String joint() {
        String str = "";
        for(int i=0; i<dish_len-1; i++) {
            str = str + choice[i] + " , ";
        }
        str = str + choice[dish_len-1];
        return str;
    }

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "rb_1_1":
                choice[0] = option_str[0][0];
                break;

            case "rb_1_2":
                choice[0] = option_str[0][1];
                break;

            case "rb_1_3":
                choice[0] = option_str[0][2];
                break;

            case "rb_1_4":
                choice[0] = option_str[0][3];
                break;

            case "rb_1_5":
                choice[0] = option_str[0][4];
                break;

            case "rb_1_6":
                choice[0] = option_str[0][5];
                break;

            case "rb_2_1":
                choice[1] = option_str[1][0];
                break;

            case "rb_2_2":
                choice[1] = option_str[1][1];
                break;

            case "rb_2_3":
                choice[1] = option_str[1][2];
                break;

            case "rb_2_4":
                choice[1] = option_str[1][3];
                break;

            case "rb_2_5":
                choice[1] = option_str[1][4];
                break;

            case "rb_2_6":
                choice[1] = option_str[1][5];
                break;

            case "rb_3_1":
                choice[2] = option_str[2][0];
                break;

            case "rb_3_2":
                choice[2] = option_str[2][1];
                break;

            case "rb_3_3":
                choice[2] = option_str[2][2];
                break;

            case "rb_3_4":
                choice[2] = option_str[2][3];
                break;

            case "rb_3_5":
                choice[2] = option_str[2][4];
                break;

            case "rb_3_6":
                choice[2] = option_str[2][5];
                break;

            case "rb_4_1":
                choice[3] = option_str[3][0];
                break;

            case "rb_4_2":
                choice[3] = option_str[3][1];
                break;

            case "rb_4_3":
                choice[3] = option_str[3][2];
                break;

            case "rb_4_4":
                choice[3] = option_str[3][3];
                break;

            case "rb_4_5":
                choice[3] = option_str[3][4];
                break;

            case "rb_4_6":
                choice[3] = option_str[3][5];
                break;

            case "rb_5_1":
                choice[4] = option_str[4][0];
                break;

            case "rb_5_2":
                choice[4] = option_str[4][1];
                break;

            case "rb_5_3":
                choice[4] = option_str[4][2];
                break;

            case "rb_5_4":
                choice[4] = option_str[4][3];
                break;

            case "rb_5_5":
                choice[4] = option_str[4][4];
                break;

            case "rb_5_6":
                choice[4] = option_str[4][5];
                break;

            case "rb_6_1":
                choice[5] = option_str[5][0];
                break;

            case "rb_6_2":
                choice[5] = option_str[5][1];
                break;

            case "rb_6_3":
                choice[5] = option_str[5][2];
                break;

            case "rb_6_4":
                choice[5] = option_str[5][3];
                break;

            case "rb_6_5":
                choice[5] = option_str[5][4];
                break;

            case "rb_6_6":
                choice[5] = option_str[5][5];
                break;

            case "rb_7_1":
                choice[6] = option_str[6][0];
                break;

            case "rb_7_2":
                choice[6] = option_str[6][1];
                break;

            case "rb_7_3":
                choice[6] = option_str[6][2];
                break;

            case "rb_7_4":
                choice[6] = option_str[6][3];
                break;

            case "rb_7_5":
                choice[6] = option_str[6][4];
                break;

            case "rb_7_6":
                choice[6] = option_str[6][5];
                break;

            case "rb_8_1":
                choice[7] = option_str[7][0];
                break;

            case "rb_8_2":
                choice[7] = option_str[7][1];
                break;

            case "rb_8_3":
                choice[7] = option_str[7][2];
                break;

            case "rb_8_4":
                choice[7] = option_str[7][3];
                break;

            case "rb_8_5":
                choice[7] = option_str[7][4];
                break;

            case "rb_8_6":
                choice[7] = option_str[7][5];
                break;

            case "rb_9_1":
                choice[8] = option_str[8][0];
                break;

            case "rb_9_2":
                choice[8] = option_str[8][1];
                break;

            case "rb_9_3":
                choice[8] = option_str[8][2];
                break;

            case "rb_9_4":
                choice[8] = option_str[8][3];
                break;

            case "rb_9_5":
                choice[8] = option_str[8][4];
                break;

            case "rb_9_6":
                choice[8] = option_str[8][5];
                break;

            case "b_2": // Confirm
                /*for(int i=0; i<8; i++) {
                    System.out.print(choice[i]+" ");
                }
                System.out.println(choice[8]);*/
                boolean flag = true;
                for(int i=0; i<dish_len; i++) {
                    if(choice[i]==null) {
                        flag = false;
                        break;
                    }
                }
                if(flag==false) {
                    JOptionPane.showMessageDialog(null, "Something you haven't chosen !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    OrderFood.ramen++;
                    switch (OrderFood.ramen) {
                        case 1:
                            OrderFood.ramenOrder[0] = joint();
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[0]);
                            break;

                        case 2:
                            OrderFood.ramenOrder[1] = joint();
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[1]);
                            break;

                        case 3:
                            OrderFood.ramenOrder[2] = joint();
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[2]);
                            break;

                        case 4:
                            OrderFood.ramenOrder[3] = joint();
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[3]);
                            break;

                        case 5:
                            OrderFood.ramenOrder[4] = joint();
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[4]);
                            break;

                        default:
                            System.out.println("---ERROR - Ramen - Confirm---");
                    }
                    this.dispose();
                    new OrderFood();
                }
                break;

            case "b_1":// Cancel
                this.dispose();
                new OrderFood();
                break;

            default:
                System.out.println("---ERROR - Ramen---");
        }
    }
}
