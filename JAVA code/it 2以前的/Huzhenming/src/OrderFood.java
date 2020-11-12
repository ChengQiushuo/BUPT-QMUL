import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title        : OrderFood.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class OrderFood extends JFrame implements ActionListener {
    public static int ramen = 0;
    public static int extraNori = 0;
    public static int extraBoiledEgg = 0;
    public static int bambooShoots = 0;
    public static int extraChashu = 0;

    private JPanel p;
    private double sum = 0.00;
    private JLabel l_5; // cost
    private JButton b_0_1, b_0_2, b_1_1, b_1_2, b_2_1, b_2_2, b_3_1, b_3_2, b_4_1, b_4_2; // add & cut
    private JLabel l_0_3, l_1_3, l_2_3, l_3_3, l_4_3; // amount
    public static JLabel ramen_1, ramen_2, ramen_3, ramen_4, ramen_5; // ramen details
    public static String[] ramenOrder = {null, null, null, null, null};
    
    private String ramenPic_2 = "./img/ramen_02.png";
    private String bigCutPic = "./img/c_1.png";
    private String bigAddPic = "./img/a_1.png";
    private String smallCutPic = "./img/c_2.png";
    private String smallAddPic = "./img/a_2.png";

    /**
     * Constructor without parameters.
     */
    public OrderFood() {
        // Set the frame.
        super("Order Food");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the food menu.
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Welcome to self-ordering kiosk software! -- Order Food"));

        // Set the ramen.
        // The picture of the ramen.
        Icon pic_0 = new ImageIcon(ramenPic_2);
        JLabel l_0_1 = new JLabel();
        l_0_1.setIcon(pic_0);
        l_0_1.setBounds(65, 111, 400, 385);
        // The price of the ramen.
        JLabel l_0_2 = new JLabel("￡9.99", JLabel.CENTER);
        l_0_2.setFont(new Font(null, Font.BOLD, 36));
        l_0_2.setBounds(155, 70, 200, 40);
        // Buttons of the ramen.
        ImageIcon icon_0_1 = new ImageIcon(bigCutPic);
        b_0_1 = new JButton(icon_0_1);
        b_0_1.setBounds(110, 518, 77, 75);
        b_0_1.addActionListener(this);
        b_0_1.setActionCommand("b_0_1");
        ImageIcon icon_0_2 = new ImageIcon(bigAddPic);
        b_0_2 = new JButton(icon_0_2);
        b_0_2.setBounds(345, 518, 77, 75);
        b_0_2.addActionListener(this);
        b_0_2.setActionCommand("b_0_2");
        // The number of the ramen.
        if(ramen==0) {
            l_0_3 = new JLabel("", JLabel.CENTER);
        }
        else {
            l_0_3 = new JLabel(Integer.toString(ramen), JLabel.CENTER);
        }
        l_0_3.setFont(new Font(null, Font.BOLD, 75));
        l_0_3.setBounds(190, 516, 150, 77);
        // Add the ramen to the food menu.
        p.add(l_0_1);
        p.add(l_0_2);
        if(ramen==0) {
            p.add(b_0_2);
        }
        else if(ramen==5) {
            p.add(b_0_1);
        }
        else {
            p.add(b_0_1);
            p.add(b_0_2);
        }
        p.add(l_0_3);

        // Set the extra nori.
        // The label of the extra nori.
        JLabel l_1_1 = new JLabel("Extra Nori", JLabel.LEFT);
        l_1_1.setFont(new Font(null, Font.BOLD, 23));
        l_1_1.setBounds(580, 160, 250, 30);
        // The price of the extra nori.
        JLabel l_1_2 = new JLabel("￡1", JLabel.LEFT);
        l_1_2.setFont(new Font(null, Font.BOLD, 16));
        l_1_2.setBounds(699, 177, 30, 20);
        // Buttons of the nori.
        ImageIcon icon_1_1 = new ImageIcon(smallCutPic);
        ImageIcon icon_1_2 = new ImageIcon(smallAddPic);
        b_1_1 = new JButton(icon_1_1);
        b_1_1.setBounds(817, 165, 25, 24);
        b_1_1.addActionListener(this);
        b_1_1.setActionCommand("b_1_1");
        b_1_2 = new JButton(icon_1_2);
        b_1_2.setBounds(900, 165, 25, 24);
        b_1_2.addActionListener(this);
        b_1_2.setActionCommand("b_1_2");
        // The number of the extra nori.
        if(extraNori==0) {
            l_1_3 = new JLabel("", JLabel.CENTER);
        }
        else {
            l_1_3 = new JLabel(Integer.toString(extraNori), JLabel.CENTER);
        }
        l_1_3.setFont(new Font(null, Font.BOLD, 23));
        l_1_3.setBounds(848, 164, 45, 24);
        // Add the extra nori to the food menu.
        p.add(l_1_1);
        p.add(l_1_2);
        if(extraNori==0) {
            p.add(b_1_2);
        }
        else if(extraNori==10) {
            p.add(b_1_1);
        }
        else {
            p.add(b_1_1);
            p.add(b_1_2);
        }
        p.add(l_1_3);

        // Set the extra boiled egg.
        // The label of the extra boiled egg.
        JLabel l_2_1 = new JLabel("Extra boiled egg", JLabel.LEFT);
        l_2_1.setFont(new Font(null, Font.BOLD, 23));
        l_2_1.setBounds(580, 270, 250, 30);
        // The price of the extra boiled egg.
        JLabel l_2_2 = new JLabel("￡1", JLabel.LEFT);
        l_2_2.setFont(new Font(null, Font.BOLD, 16));
        l_2_2.setBounds(772, 287, 30, 20);
        // Buttons of the extra boiled egg.
        b_2_1 = new JButton(icon_1_1);
        b_2_1.setBounds(817, 275, 25, 24);
        b_2_1.addActionListener(this);
        b_2_1.setActionCommand("b_2_1");
        b_2_2 = new JButton(icon_1_2);
        b_2_2.setBounds(900, 275, 25, 24);
        b_2_2.addActionListener(this);
        b_2_2.setActionCommand("b_2_2");
        // The number of the extra boiled egg.
        if(extraBoiledEgg==0) {
            l_2_3 = new JLabel("", JLabel.CENTER);
        }
        else {
            l_2_3 = new JLabel(Integer.toString(extraBoiledEgg), JLabel.CENTER);
        }
        l_2_3.setFont(new Font(null, Font.BOLD, 23));
        l_2_3.setBounds(848, 274, 45, 24);
        // Add the extra boiled egg to the food menu.
        p.add(l_2_1);
        p.add(l_2_2);
        if(extraBoiledEgg==0) {
            p.add(b_2_2);
        }
        else if(extraBoiledEgg==10) {
            p.add(b_2_1);
        }
        else {
            p.add(b_2_1);
            p.add(b_2_2);
        }
        p.add(l_2_3);

        // Set the bamboo shoots.
        // The label of the bamboo shoots.
        JLabel l_3_1 = new JLabel("Bammboo shoots", JLabel.LEFT);
        l_3_1.setFont(new Font(null, Font.BOLD, 23));
        l_3_1.setBounds(580, 380, 250, 30);
        // The price of the bamboo shoots.
        JLabel l_3_2 = new JLabel("￡1", JLabel.LEFT);
        l_3_2.setFont(new Font(null, Font.BOLD, 16));
        l_3_2.setBounds(784, 397, 30, 20);
        // Buttons of the bamboo shoots.
        b_3_1 = new JButton(icon_1_1);
        b_3_1.setBounds(817, 385, 25, 24);
        b_3_1.addActionListener(this);
        b_3_1.setActionCommand("b_3_1");
        b_3_2 = new JButton(icon_1_2);
        b_3_2.setBounds(900, 385, 25, 24);
        b_3_2.addActionListener(this);
        b_3_2.setActionCommand("b_3_2");
        // The number of the bamboo shoots.
        if(bambooShoots==0) {
            l_3_3 = new JLabel("", JLabel.CENTER);
        }
        else {
            l_3_3 = new JLabel(Integer.toString(bambooShoots), JLabel.CENTER);
        }
        l_3_3.setFont(new Font(null, Font.BOLD, 23));
        l_3_3.setBounds(848, 384, 45, 24);
        // Add the bamboo shoots to the food menu.
        p.add(l_3_1);
        p.add(l_3_2);
        if(bambooShoots==0) {
            p.add(b_3_2);
        }
        else if(bambooShoots==10) {
            p.add(b_3_1);
        }
        else {
            p.add(b_3_1);
            p.add(b_3_2);
        }
        p.add(l_3_3);

        // Set the extra chashu.
        // The label of the extra chashu.
        JLabel l_4_1 = new JLabel("Extra Chashu", JLabel.LEFT);
        l_4_1.setFont(new Font(null, Font.BOLD, 23));
        l_4_1.setBounds(580, 490, 250, 30);
        // The price of the extra chashu.
        JLabel l_4_2 = new JLabel("￡1", JLabel.LEFT);
        l_4_2.setFont(new Font(null, Font.BOLD, 16));
        l_4_2.setBounds(737, 507, 30, 20);
        // Buttons of the extra chashu.
        b_4_1 = new JButton(icon_1_1);
        b_4_1.setBounds(817, 495, 25, 24);
        b_4_1.addActionListener(this);
        b_4_1.setActionCommand("b_4_1");
        b_4_2 = new JButton(icon_1_2);
        b_4_2.setBounds(900, 495, 25, 24);
        b_4_2.addActionListener(this);
        b_4_2.setActionCommand("b_4_2");
        // The number of the extra chashu.
        if(extraChashu==0) {
            l_4_3 = new JLabel("", JLabel.CENTER);
        }
        else {
            l_4_3 = new JLabel(Integer.toString(extraChashu), JLabel.CENTER);
        }
        l_4_3.setFont(new Font(null, Font.BOLD, 23));
        l_4_3.setBounds(848, 494, 45, 24);
        // Add the extra chashu to the food menu.
        p.add(l_4_1);
        p.add(l_4_2);
        if(extraChashu==0) {
            p.add(b_4_2);
        }
        else if(extraChashu==10) {
            p.add(b_4_1);
        }
        else {
            p.add(b_4_1);
            p.add(b_4_2);
        }
        p.add(l_4_3);

        // Set the sum of the cost.
        if(sum==0.00) {
            l_5 = new JLabel("", JLabel.CENTER);
        }
        else {
            l_5 = new JLabel(Double.toString(sum), JLabel.CENTER);
        }
        l_5.setFont(new Font(null, Font.BOLD, 50));
        l_5.setBounds(590, 50, 333, 60);
        // Add the sum of the cost to the food menu.
        p.add(l_5);

        // Set the OK button.
        JButton b_0 = new JButton("OK");
        b_0.setFont(new Font(null, Font.BOLD, 20));
        b_0.setBounds(777, 633, 200, 60);
        b_0.addActionListener(this);
        b_0.setActionCommand("b_0");
        // Add the OK button to the food menu.
        p.add(b_0);

        // Set the Reset button.
        JButton reset = new JButton("Reset");
        reset.setFont(new Font(null, Font.BOLD, 10));
        reset.setBounds(917, 22, 60, 60);
        reset.addActionListener(this);
        reset.setActionCommand("reset");
        // Add the OK button to the food menu.
        p.add(reset);

        // Set the details of the ramen.
        ramen_1 = new JLabel(ramenOrder[0], JLabel.LEFT);
        ramen_1.setFont(new Font(null, Font.BOLD, 12));
        ramen_1.setBounds(85, 611, 600, 13);
        ramen_2 = new JLabel(ramenOrder[1], JLabel.LEFT);
        ramen_2.setFont(new Font(null, Font.BOLD, 12));
        ramen_2.setBounds(85, 628, 600, 13);
        ramen_3 = new JLabel(ramenOrder[2], JLabel.LEFT);
        ramen_3.setFont(new Font(null, Font.BOLD, 12));
        ramen_3.setBounds(85, 645, 600, 13);
        ramen_4 = new JLabel(ramenOrder[3], JLabel.LEFT);
        ramen_4.setFont(new Font(null, Font.BOLD, 12));
        ramen_4.setBounds(85, 662, 600, 13);
        ramen_5 = new JLabel(ramenOrder[4], JLabel.LEFT);
        ramen_5.setFont(new Font(null, Font.BOLD, 12));
        ramen_5.setBounds(85, 679, 600, 13);
        // Add the details to the food menu.
        p.add(ramen_1);
        p.add(ramen_2);
        p.add(ramen_3);
        p.add(ramen_4);
        p.add(ramen_5);

        // Add the food menu to the frame.
        updateSum();
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
     * This method aims to update the sum of the cost.
     */
    public void updateSum() {
        sum = ramen*9.99 + extraNori*1.00 + extraBoiledEgg*1.00 + bambooShoots*1.00 + extraChashu*1.00;
        if(sum==0) {
            l_5.setText("");
        }
        else {
            l_5.setText("￡" + String.format("%.2f", sum));
        }
    }

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "b_0_2": // add ramen
                this.dispose();
                new Ramen();
                break;

            case "b_0_1": // cut ramen
                ramen--;
                switch (ramen) {
                    case 4:
                        ramen_5.setText("");
                        ramenOrder[4] = null;
                        break;
                        
                    case 3:
                        ramen_4.setText("");
                        ramenOrder[3] = null;
                        break;
                        
                    case 2:
                        ramen_3.setText("");
                        ramenOrder[2] = null;
                        break;
                        
                    case 1:
                        ramen_2.setText("");
                        ramenOrder[1] = null;
                        break;
                        
                    case 0:
                        ramen_1.setText("");
                        ramenOrder[0] = null;
                        break;
                        
                    default:
                        System.out.println("---ERROR - OrderFood - cut ramen---");
                }
                l_0_3.setText(Integer.toString(ramen));
                if(ramen==4) {
                    p.add(b_0_2);
                }
                else if(ramen==0) {
                    l_0_3.setText("");
                    p.remove(b_0_1);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_1_2": // add extra nori
                extraNori++;
                l_1_3.setText(Integer.toString(extraNori));
                if(extraNori==1) {
                    p.add(b_1_1);
                }
                else if(extraNori==10) {
                    p.remove(b_1_2);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_1_1": // cut extra nori
                extraNori--;
                l_1_3.setText(Integer.toString(extraNori));
                if(extraNori==9) {
                    p.add(b_1_2);
                }
                else if(extraNori==0) {
                    l_1_3.setText("");
                    p.remove(b_1_1);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_2_2": // add extra boiled egg
                extraBoiledEgg++;
                l_2_3.setText(Integer.toString(extraBoiledEgg));
                if(extraBoiledEgg==1) {
                    p.add(b_2_1);
                }
                else if(extraBoiledEgg==10) {
                    p.remove(b_2_2);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_2_1": // cut extra boiled egg
                extraBoiledEgg--;
                l_2_3.setText(Integer.toString(extraBoiledEgg));
                if(extraBoiledEgg==9) {
                    p.add(b_2_2);
                }
                else if(extraBoiledEgg==0) {
                    l_2_3.setText("");
                    p.remove(b_2_1);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_3_2": // add bamboo shoots
                bambooShoots++;
                l_3_3.setText(Integer.toString(bambooShoots));
                if(bambooShoots==1) {
                    p.add(b_3_1);
                }
                else if(bambooShoots==10) {
                    p.remove(b_3_2);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_3_1": // cut bamboo shoots
                bambooShoots--;
                l_3_3.setText(Integer.toString(bambooShoots));
                if(bambooShoots==9) {
                    p.add(b_3_2);
                }
                else if(bambooShoots==0) {
                    l_3_3.setText("");
                    p.remove(b_3_1);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_4_2": // add extra chashu
                extraChashu++;
                l_4_3.setText(Integer.toString(extraChashu));
                if(extraChashu==1) {
                    p.add(b_4_1);
                }
                else if(extraChashu==10) {
                    p.remove(b_4_2);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_4_1": // cut extra chashu
                extraChashu--;
                l_4_3.setText(Integer.toString(extraChashu));
                if(extraChashu==9) {
                    p.add(b_4_2);
                }
                else if(extraChashu==0) {
                    l_4_3.setText("");
                    p.remove(b_4_1);
                }
                updateSum();
                p.updateUI();
                break;

            case "b_0": // OK
                if(ramen==0&&extraNori==0&&extraBoiledEgg==0&&bambooShoots==0&&extraChashu==0) {
                    JOptionPane.showMessageDialog(null, "Please choose your food !", "You haven't chosen anything", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    this.dispose();
                    new Detail();
                }
                break;

            case "reset": // Reset
                this.dispose();
                ramen = 0;
                extraNori = 0;
                extraBoiledEgg = 0;
                bambooShoots = 0;
                extraChashu = 0;
                ramenOrder[0] = null;
                ramenOrder[1] = null;
                ramenOrder[2] = null;
                ramenOrder[3] = null;
                ramenOrder[4] = null;
                new OrderFood();
                break;

            default:
                System.out.println("---ERROR - OrderFood---");
        }
    }
}
