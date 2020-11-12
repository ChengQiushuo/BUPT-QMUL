import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title        : Ramen.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Ramen extends JFrame implements ActionListener {
    private String soup, noodels, springOnion, nori, chashu, boiledEgg, spiciness;
    private ButtonGroup bg_l_1, bg_l_2, bg_l_3, bg_r_1, bg_r_2, bg_r_3, bg_4;

    private String ramenPic_3 = "./img/ramen_02.png";
    
    /**
     * Constructor without parameters.
     */
    public Ramen() {
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
        ramen_l_0.setBounds(360, 180, 300, 290);
        // Add the picture to the ramen menu.
        p.add(ramen_l_0);

        // Set the soup.
        // The label of the soup.
        JLabel ramen_l_1 = new JLabel("Soup", JLabel.RIGHT);
        ramen_l_1.setFont(new Font(null, Font.BOLD, 23));
        ramen_l_1.setBounds(10, 195, 200, 30);
        // Buttons of the soup.
        bg_l_1 = new ButtonGroup();
        JRadioButton rb_l_1_1 = new JRadioButton("Tonkotsu");
        rb_l_1_1.setFont(new Font(null, Font.BOLD, 15));
        rb_l_1_1.setBounds(220, 175, 150, 25);
        rb_l_1_1.addActionListener(this);
        rb_l_1_1.setActionCommand("rb_l_1_1");
        JRadioButton rb_l_1_2 = new JRadioButton("Shoyu");
        rb_l_1_2.setFont(new Font(null, Font.BOLD, 15));
        rb_l_1_2.setBounds(220, 200, 150, 25);
        rb_l_1_2.addActionListener(this);
        rb_l_1_2.setActionCommand("rb_l_1_2");
        JRadioButton rb_l_1_3 = new JRadioButton("Shio");
        rb_l_1_3.setFont(new Font(null, Font.BOLD, 15));
        rb_l_1_3.setBounds(220, 225, 150, 25);
        rb_l_1_3.addActionListener(this);
        rb_l_1_3.setActionCommand("rb_l_1_3");
        // Add the soup to the ramen menu.
        p.add(ramen_l_1);
        bg_l_1.add(rb_l_1_1);
        bg_l_1.add(rb_l_1_2);
        bg_l_1.add(rb_l_1_3);
        p.add(rb_l_1_1);
        p.add(rb_l_1_2);
        p.add(rb_l_1_3);

        // Set the noodles.
        // The label of the .
        JLabel ramen_l_2 = new JLabel("Noodles", JLabel.RIGHT);
        ramen_l_2.setFont(new Font(null, Font.BOLD, 23));
        ramen_l_2.setBounds(10, 305, 200, 30);
        // Buttons of the noodles.
        bg_l_2 = new ButtonGroup();
        JRadioButton rb_l_2_1 = new JRadioButton("Soft");
        rb_l_2_1.setFont(new Font(null, Font.BOLD, 15));
        rb_l_2_1.setBounds(220, 285, 150, 25);
        rb_l_2_1.addActionListener(this);
        rb_l_2_1.setActionCommand("rb_l_2_1");
        JRadioButton rb_l_2_2 = new JRadioButton("Medium");
        rb_l_2_2.setFont(new Font(null, Font.BOLD, 15));
        rb_l_2_2.setBounds(220, 310, 150, 25);
        rb_l_2_2.addActionListener(this);
        rb_l_2_2.setActionCommand("rb_l_2_2");
        JRadioButton rb_l_2_3 = new JRadioButton("Firm");
        rb_l_2_3.setFont(new Font(null, Font.BOLD, 15));
        rb_l_2_3.setBounds(220, 335, 150, 25);
        rb_l_2_3.addActionListener(this);
        rb_l_2_3.setActionCommand("rb_l_2_3");
        // Add the noodles to the ramen menu.
        p.add(ramen_l_2);
        bg_l_2.add(rb_l_2_1);
        bg_l_2.add(rb_l_2_2);
        bg_l_2.add(rb_l_2_3);
        p.add(rb_l_2_1);
        p.add(rb_l_2_2);
        p.add(rb_l_2_3);

        // Set the spring onion.
        // The label of the spring onion.
        JLabel ramen_l_3 = new JLabel("Spring onion", JLabel.RIGHT);
        ramen_l_3.setFont(new Font(null, Font.BOLD, 23));
        ramen_l_3.setBounds(10, 415, 200, 30);
        // Buttons of the spring onion.
        bg_l_3 = new ButtonGroup();
        JRadioButton rb_l_3_1 = new JRadioButton("No please");
        rb_l_3_1.setFont(new Font(null, Font.BOLD, 15));
        rb_l_3_1.setBounds(220, 395, 150, 25);
        rb_l_3_1.addActionListener(this);
        rb_l_3_1.setActionCommand("rb_l_3_1");
        JRadioButton rb_l_3_2 = new JRadioButton("Just a little");
        rb_l_3_2.setFont(new Font(null, Font.BOLD, 15));
        rb_l_3_2.setBounds(220, 420, 150, 25);
        rb_l_3_2.addActionListener(this);
        rb_l_3_2.setActionCommand("rb_l_3_2");
        JRadioButton rb_l_3_3 = new JRadioButton("A lot!");
        rb_l_3_3.setFont(new Font(null, Font.BOLD, 15));
        rb_l_3_3.setBounds(220, 445, 150, 25);
        rb_l_3_3.addActionListener(this);
        rb_l_3_3.setActionCommand("rb_l_3_3");
        // Add the spring onion to the ramen menu.
        p.add(ramen_l_3);
        bg_l_3.add(rb_l_3_1);
        bg_l_3.add(rb_l_3_2);
        bg_l_3.add(rb_l_3_3);
        p.add(rb_l_3_1);
        p.add(rb_l_3_2);
        p.add(rb_l_3_3);

        // Set the nori.
        // The label of the nori.
        JLabel ramen_r_1 = new JLabel("Nori", JLabel.RIGHT);
        ramen_r_1.setFont(new Font(null, Font.BOLD, 23));
        ramen_r_1.setBounds(690, 195, 130, 30);
        // Buttons of the nori.
        bg_r_1 = new ButtonGroup();
        JRadioButton rb_r_1_1 = new JRadioButton("Yes");
        rb_r_1_1.setFont(new Font(null, Font.BOLD, 15));
        rb_r_1_1.setBounds(830, 187, 150, 25);
        rb_r_1_1.addActionListener(this);
        rb_r_1_1.setActionCommand("rb_r_1_1");
        JRadioButton rb_r_1_2 = new JRadioButton("No");
        rb_r_1_2.setFont(new Font(null, Font.BOLD, 15));
        rb_r_1_2.setBounds(830, 212, 150, 25);
        rb_r_1_2.addActionListener(this);
        rb_r_1_2.setActionCommand("rb_r_1_2");
        // Add the nori to the ramen menu.
        p.add(ramen_r_1);
        bg_r_1.add(rb_r_1_1);
        bg_r_1.add(rb_r_1_2);
        p.add(rb_r_1_1);
        p.add(rb_r_1_2);

        // Set the chashu.
        // The label of the chashu.
        JLabel ramen_r_2 = new JLabel("Chashu", JLabel.RIGHT);
        ramen_r_2.setFont(new Font(null, Font.BOLD, 23));
        ramen_r_2.setBounds(690, 305, 130, 30);
        // Buttons of the chashu.
        bg_r_2 = new ButtonGroup();
        JRadioButton rb_r_2_1 = new JRadioButton("Yes");
        rb_r_2_1.setFont(new Font(null, Font.BOLD, 15));
        rb_r_2_1.setBounds(830, 297, 150, 25);
        rb_r_2_1.addActionListener(this);
        rb_r_2_1.setActionCommand("rb_r_2_1");
        JRadioButton rb_r_2_2 = new JRadioButton("No");
        rb_r_2_2.setFont(new Font(null, Font.BOLD, 15));
        rb_r_2_2.setBounds(830, 322, 150, 25);
        rb_r_2_2.addActionListener(this);
        rb_r_2_2.setActionCommand("rb_r_2_2");
        // Add the chashu to the ramen menu.
        p.add(ramen_r_2);
        bg_r_2.add(rb_r_2_1);
        bg_r_2.add(rb_r_2_2);
        p.add(rb_r_2_1);
        p.add(rb_r_2_2);

        // Set the boiled egg.
        // The label of the boiled egg.
        JLabel ramen_r_3 = new JLabel("Boiled egg", JLabel.RIGHT);
        ramen_r_3.setFont(new Font(null, Font.BOLD, 23));
        ramen_r_3.setBounds(690, 415, 130, 30);
        // Buttons of the boiled egg.
        bg_r_3 = new ButtonGroup();
        JRadioButton rb_r_3_1 = new JRadioButton("Yes");
        rb_r_3_1.setFont(new Font(null, Font.BOLD, 15));
        rb_r_3_1.setBounds(830, 407, 150, 25);
        rb_r_3_1.addActionListener(this);
        rb_r_3_1.setActionCommand("rb_r_3_1");
        JRadioButton rb_r_3_2 = new JRadioButton("No");
        rb_r_3_2.setFont(new Font(null, Font.BOLD, 15));
        rb_r_3_2.setBounds(830, 432, 150, 25);
        rb_r_3_2.addActionListener(this);
        rb_r_3_2.setActionCommand("rb_r_3_2");
        // Add the boiled egg to the ramen menu.
        p.add(ramen_r_3);
        bg_r_3.add(rb_r_3_1);
        bg_r_3.add(rb_r_3_2);
        p.add(rb_r_3_1);
        p.add(rb_r_3_2);

        // Set the spiciness.
        // The label of the spiciness.
        JLabel ramen_l4 = new JLabel("Spiciness", JLabel.LEFT);
        ramen_l4.setFont(new Font(null, Font.BOLD, 23));
        ramen_l4.setBounds(155, 530, 250, 30);
        // Buttons of the spiciness.
        bg_4 = new ButtonGroup();
        JRadioButton rb_4_0 = new JRadioButton("0(No)");
        rb_4_0.setFont(new Font(null, Font.BOLD, 15));
        rb_4_0.setBounds(295, 534, 100, 25);
        rb_4_0.addActionListener(this);
        rb_4_0.setActionCommand("rb_4_0");
        JRadioButton rb_4_1 = new JRadioButton("1");
        rb_4_1.setFont(new Font(null, Font.BOLD, 15));
        rb_4_1.setBounds(405, 534, 50, 25);
        rb_4_1.addActionListener(this);
        rb_4_1.setActionCommand("rb_4_1");
        JRadioButton rb_4_2 = new JRadioButton("2");
        rb_4_2.setFont(new Font(null, Font.BOLD, 15));
        rb_4_2.setBounds(485, 534, 50, 25);
        rb_4_2.addActionListener(this);
        rb_4_2.setActionCommand("rb_4_2");
        JRadioButton rb_4_3 = new JRadioButton("3");
        rb_4_3.setFont(new Font(null, Font.BOLD, 15));
        rb_4_3.setBounds(565, 534, 50, 25);
        rb_4_3.addActionListener(this);
        rb_4_3.setActionCommand("rb_4_3");
        JRadioButton rb_4_4 = new JRadioButton("4");
        rb_4_4.setFont(new Font(null, Font.BOLD, 15));
        rb_4_4.setBounds(645, 534, 50, 25);
        rb_4_4.addActionListener(this);
        rb_4_4.setActionCommand("rb_4_4");
        JRadioButton rb_4_5 = new JRadioButton("5(Max)");
        rb_4_5.setFont(new Font(null, Font.BOLD, 15));
        rb_4_5.setBounds(725, 534, 100, 25);
        rb_4_5.addActionListener(this);
        rb_4_5.setActionCommand("rb_4_5");
        // Add the spiciness to the ramen menu.
        p.add(ramen_l4);
        bg_4.add(rb_4_0);
        bg_4.add(rb_4_1);
        bg_4.add(rb_4_2);
        bg_4.add(rb_4_3);
        bg_4.add(rb_4_4);
        bg_4.add(rb_4_5);
        p.add(rb_4_0);
        p.add(rb_4_1);
        p.add(rb_4_2);
        p.add(rb_4_3);
        p.add(rb_4_4);
        p.add(rb_4_5);

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

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "rb_l_1_1": // ramen menu
                soup = "Tonkotsum, ";
                break;

            case "rb_l_1_2":
                soup = "Shoyu, ";
                break;

            case "rb_l_1_3":
                soup = "Shio, ";
                break;

            case "rb_l_2_1":
                noodels = "Soft, ";
                break;

            case "rb_l_2_2":
                noodels = "Medium, ";
                break;

            case "rb_l_2_3":
                noodels = "Firm, ";
                break;

            case "rb_l_3_1":
                springOnion = "Spring onion-No please, ";
                break;

            case "rb_l_3_2":
                springOnion = "Spring onion-Just a little, ";
                break;

            case "rb_l_3_3":
                springOnion = "Spring onion-A lot!, ";
                break;

            case "rb_r_1_1":
                nori = "Nori-yes, ";
                break;

            case "rb_r_1_2":
                nori = "Nori-no, ";
                break;

            case "rb_r_2_1":
                chashu = "Chashu-yes, ";
                break;

            case "rb_r_2_2":
                chashu = "Chashu-no, ";
                break;

            case "rb_r_3_1":
                boiledEgg = "Boiled egg-yes, ";
                break;

            case "rb_r_3_2":
                boiledEgg = "Boiled egg-no, ";
                break;

            case "rb_4_0":
                spiciness = "0";
                break;

            case "rb_4_1":
                spiciness = "1";
                break;

            case "rb_4_2":
                spiciness = "2";
                break;

            case "rb_4_3":
                spiciness = "3";
                break;

            case "rb_4_4":
                spiciness = "4";
                break;

            case "rb_4_5":
                spiciness = "5";
                break;

            case "b_2": // Confirm
                if(soup==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Soup !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(noodels==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Noodels !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(springOnion==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Spring onion !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(nori==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Nori !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(chashu==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Chashu !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(boiledEgg==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Boiled egg !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(spiciness==null) {
                    JOptionPane.showMessageDialog(null, "You haven't chosen the Spiciness !", "Please choose all the options", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    OrderFood.ramen++;
                    switch (OrderFood.ramen) {
                        case 1:
                            OrderFood.ramenOrder[0] = soup + noodels + springOnion + nori + chashu + boiledEgg + spiciness;
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[0]);
                            break;

                        case 2:
                            OrderFood.ramenOrder[1] = soup + noodels + springOnion + nori + chashu + boiledEgg + spiciness;
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[1]);
                            break;

                        case 3:
                            OrderFood.ramenOrder[2] = soup + noodels + springOnion + nori + chashu + boiledEgg + spiciness;
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[2]);
                            break;

                        case 4:
                            OrderFood.ramenOrder[3] = soup + noodels + springOnion + nori + chashu + boiledEgg + spiciness;
                            OrderFood.ramen_1.setText(OrderFood.ramenOrder[3]);
                            break;

                        case 5:
                            OrderFood.ramenOrder[4] = soup + noodels + springOnion + nori + chashu + boiledEgg + spiciness;
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
