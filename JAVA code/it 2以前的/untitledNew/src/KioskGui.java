import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title        : KioskGui.java
 * Description  : This class is the main program file of the Group-Project Coursework.
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class KioskGui extends JFrame implements ActionListener {
    public static String ramenPic_1 = "./img/ramen_01.png";
//    public static int member = 0;

    /**
     * Constructor without parameters.
     */
    public KioskGui() {
        // Set the frame.
        super("Self-Ordering Kiosk");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        // Set the panel.
        OrderFood.ramen = 0;
        OrderFood.dishName = new String[7];
        OrderFood.extraCount =new int[]{0, 0, 0, 0, 0, 0, 0};
        OrderFood.dishPrice = new double[7];
        OrderFood.ramenOrder[0] = null;
        OrderFood.ramenOrder[1] = null;
        OrderFood.ramenOrder[2] = null;
        OrderFood.ramenOrder[3] = null;
        OrderFood.ramenOrder[4] = null;
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(12, 12, 1000, 716);
        p.setBorder(BorderFactory.createTitledBorder("Welcome to self-ordering kiosk software!"));

        // Set the label.
        JLabel l_1 = new JLabel("Welcome to Totoro Ramen!", JLabel.CENTER);
        l_1.setFont(new Font(null, Font.BOLD, 45));
        l_1.setBounds(135, 30, 700, 100);

        // Set the picture.
        JLabel l_2 = new JLabel();
        Icon pic = new ImageIcon(ramenPic_1);
        l_2.setIcon(pic);
        l_2.setBounds(260, 112, 450, 450);

        // Set buttons.
        JButton b_1 = new JButton("Begin");
        b_1.setFont(new Font(null, Font.BOLD, 20));
        b_1.setBounds(47, 600, 200, 60);
        b_1.addActionListener(this);
        b_1.setActionCommand("b_1");
        JButton b_2 = new JButton("Membership Order");
        b_2.setFont(new Font(null, Font.BOLD, 20));
        b_2.setBounds(360, 600, 220, 60);
        b_2.addActionListener(this);
        b_2.setActionCommand("b_2");
        JButton b_3 = new JButton("Join in Loyalty Shceme");
        b_3.setFont(new Font(null, Font.BOLD, 20));
        b_3.setBounds(680, 600, 270, 60);
        b_3.addActionListener(this);
        b_3.setActionCommand("b_3");

        /*
         * Add the label, picture and buttons to the panel.
         * Add the panel to the frame.
         */
        p.add(l_1);
        p.add(l_2);
        p.add(b_1);
//        p.add(b_2);
        p.add(b_3);
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
            // If the first button is chosen.
            case "b_1":
            	new OrderFood();
                this.dispose();    
                break;

            // If the second button is chosen.
            case "b_2": 
//            	member = 1;
            	new LogIn(); 
                this.dispose();  
              
                break;
            case "b_3":            
            	new SignUp();
                this.dispose();
    
                break;
            default:
                System.out.println("---ERROR---");
        }
    }

    /**
     * The main method now only creates a new instance of my program.
     * @param args The program does not use this parameter.
     */
    public static void main(String[] args) {
        new KioskGui();
    }
}
