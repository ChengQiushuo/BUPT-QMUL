import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;

/**
 * Title        : OrderFood.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class OrderFood extends JFrame implements ActionListener {
    public static int ramen = 0;


    public static String[] dishName = new String[7];
    public static int[] extraCount =new int[]{0, 0, 0, 0, 0, 0, 0};//数目
    public static double[] dishPrice = new double[7];
    public JSONArray jsonArray;

    public int i = 0;
    public int size = 1;
    public static int[] extraOptions = new int[7];
    private JPanel p;
    private double sum = 0.00;
    private JLabel l_5; // cost
    private JButton b[][] = new JButton[7][2];
    private JButton b_0_1, b_0_2, b_1_1, b_1_2, b_2_1, b_2_2, b_3_1, b_3_2, b_4_1, b_4_2; // add & cut
    private JLabel l[][] = new JLabel[7][3];
    private JLabel l_0_3, l_1_3, l_2_3, l_3_3, l_4_3; // amount
    public static JLabel ramen_1, ramen_2, ramen_3, ramen_4, ramen_5; // ramen details
    public static String[] ramenOrder = {null, null, null, null, null};
    
    private String ramenPic_2 = "./img/ramen_02.png";
    private String bigCutPic = "./img/c_1.png";
    private String bigAddPic = "./img/a_1.png";
    private String smallCutPic = "./img/c_2.png";
    private String smallAddPic = "./img/a_2.png";

    public static String jsonFile = "./dish/extra.json";

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
        JLabel l_0_2 = new JLabel("£9.99", JLabel.CENTER);
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
            if (ramen == 0) {
                l_0_3 = new JLabel("0", JLabel.CENTER);
            } else {
                l_0_3 = new JLabel(Integer.toString(ramen), JLabel.CENTER);
            }
            l_0_3.setFont(new Font(null, Font.BOLD, 75));
            l_0_3.setBounds(190, 516, 150, 77);
            // Add the ramen to the food menu.
            p.add(l_0_1);
            p.add(l_0_2);
            if (ramen == 0) {
                p.add(b_0_2);
            } else if (ramen == 5) {
                p.add(b_0_1);
            } else {
                p.add(b_0_1);
                p.add(b_0_2);
            }
            p.add(l_0_3);

            //Read the json file and store the information in String variable, data

        String data = "";
        String str;
        File f = new File(jsonFile);
        try {
            FileReader fr = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fr);
            while ((str=br.readLine())!=null) {
                data = data + str + "\n";
            }
            br.close();
            fr.close();

            //Create JSONArray to extra the name and price of the dish extra
            DecimalFormat df   = new DecimalFormat("######0.00");
            JSONObject dataJson = new JSONObject(data);
             jsonArray = dataJson.getJSONArray("dishes");
            for (int count = 0; count < jsonArray.length(); count++) {
                JSONObject info = jsonArray.getJSONObject(count);
                dishName[count] = info.getString("name");    //dish name
                JSONObject info1 = jsonArray.getJSONObject(count);
                dishPrice[count] = info1.getDouble("price");  //dish price
                df.format(dishPrice[count]);
            }

            int y0 = 135;
            int y1 = 140;
            int y2 = 135;
            int y3 = 135;
            int y4 = 135;


        for(;i<jsonArray.length();i++){
            if(jsonArray.getJSONObject(i).getString("availability").equals("Yes")) {
                l[i][0] = new JLabel(dishName[i], JLabel.LEFT);
                l[i][0].setFont(new Font(null, Font.BOLD, 20));
                l[i][0].setBounds(550, y0, 200, 30);
                // The price of the extra nori.
                l[i][1] = new JLabel("£" + dishPrice[i], JLabel.LEFT);
                System.out.println("£" + dishPrice[i]);
                l[i][1].setFont(new Font(null, Font.BOLD, 20));
                l[i][1].setBounds(750, y1, 100, 20);
                // Buttons of the nori.
                ImageIcon icon_1_1 = new ImageIcon(smallCutPic);
                ImageIcon icon_1_2 = new ImageIcon(smallAddPic);
                b[i][0] = new JButton(icon_1_1);
                b[i][0].setBounds(870, y2, 25, 24);
                b[i][0].addActionListener(this);
                b[i][0].setActionCommand("b1" + i);
                b[i][1] = new JButton(icon_1_2);
                b[i][1].setBounds(930, y3, 25, 24);
                b[i][1].addActionListener(this);
                b[i][1].setActionCommand("b2" + i);
                // The number of the extra nori.
                if (extraCount[i] == 0) {
                    l[i][2] = new JLabel("0", JLabel.CENTER);
                } else {
                    l[i][2] = new JLabel(Integer.toString(extraCount[i]), JLabel.CENTER);
                }
                l[i][2].setFont(new Font(null, Font.BOLD, 23));
                l[i][2].setBounds(888, y4, 45, 24);
                // Add the extra nori to the food menu.
                p.add(l[i][0]);
                p.add(l[i][1]);
                if (extraCount[i] == 0) {
                    p.add(b[i][1]);
                } else if (extraCount[i] == 10) {
                    p.add(b[i][0]);
                } else {
                    p.add(b[i][0]);
                    p.add(b[i][1]);
                }
                p.add(l[i][2]);
                y0 += 60;
                y1 += 60;
                y2 += 60;
                y3 += 60;
                y4 += 60;
            }
        }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

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
        reset.setFont(new Font(null, Font.BOLD, 20));
        reset.setBounds(500, 633, 200, 60);
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
        sum = ramen*9.99 + extraCount[0]*dishPrice[0] + extraCount[1]*dishPrice[1] + extraCount[2]*dishPrice[2]
                + extraCount[3]*dishPrice[3]+extraCount[4]*dishPrice[4]+extraCount[5]*dishPrice[5]+extraCount[6]*dishPrice[6];
        if(sum==0) {
            l_5.setText("");
        }
        else {
            l_5.setText("£" + String.format("%.2f", sum));
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
			try {
				new Ramen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
                break;

            case "b_0_1": // cut ramen
                ramen--;
                switch (ramen) {
                    case 4:
                        ramen_5.setText("0");
                        ramenOrder[4] = null;
                        break;
                        
                    case 3:
                        ramen_4.setText("0");
                        ramenOrder[3] = null;
                        break;
                        
                    case 2:
                        ramen_3.setText("0");
                        ramenOrder[2] = null;
                        break;
                        
                    case 1:
                        ramen_2.setText("0");
                        ramenOrder[1] = null;
                        break;
                        
                    case 0:
                        ramen_1.setText("0");
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
                    l_0_3.setText("0");
                    p.remove(b_0_1);
                }
                updateSum();
                p.updateUI();
                break;

            case "b20": // add extra nori
                extraCount[0]++;
                l[0][2].setText(Integer.toString(extraCount[0]));
                if(extraCount[0]==1) {
                    p.add(b[0][0]);
                }
                else if(extraCount[0]==10) {
                    p.remove(b[0][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b10": // cut extra nori
                extraCount[0]--;
                l[0][2].setText(Integer.toString(extraCount[0]));
                if(extraCount[0]==9) {
                    p.add(b[0][1]);
                }
                else if(extraCount[0]==0) {
                    l[0][2].setText("0");
                    p.remove(b[0][0]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b21": // add extra boiled egg
                extraCount[1]++;
                l[1][2].setText(Integer.toString(extraCount[1]));
                if(extraCount[1]==1) {
                    p.add(b[1][0]);
                }
                else if(extraCount[1]==10) {
                    p.remove(b[1][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b11": // cut extra boiled egg
                extraCount[1]--;
                l[1][2].setText(Integer.toString(extraCount[1]));
                if(extraCount[1]==9) {
                    p.add(b[1][1]);
                }
                else if(extraCount[1]==0) {
                    l[1][2].setText("0");
                    p.remove(b[1][0]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b22": // add bamboo shoots
                extraCount[2]++;
                l[2][2].setText(Integer.toString(extraCount[2]));
                if(extraCount[2]==1) {
                    p.add(b[2][0]);
                }
                else if(extraCount[2]==10) {
                    p.remove(b[2][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b12": // cut bamboo shoots
                extraCount[2]--;
                l[2][2].setText(Integer.toString(extraCount[2]));
                if(extraCount[2]==9) {
                    p.add(b[2][1]);
                }
                else if(extraCount[2]==0) {
                    l[2][2].setText("0");
                    p.remove(b[2][0]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b23": // add extra chashu
                extraCount[3]++;
                l[3][2].setText(Integer.toString(extraCount[3]));
                if(extraCount[3]==1) {
                    p.add(b[3][0]);
                }
                else if(extraCount[3]==10) {
                    p.remove(b[3][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b13": // cut extra chashu
                extraCount[3]--;
                l[3][2].setText(Integer.toString(extraCount[3]));
                if(extraCount[3]==9) {
                    p.add(b[3][1]);
                }
                else if(extraCount[3]==0) {
                    l[3][2].setText("0");
                    p.remove(b[3][0]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b24": // add extra chashu
                extraCount[4]++;
                l[4][2].setText(Integer.toString(extraCount[4]));
                if(extraCount[4]==1) {
                    p.add(b[4][0]);
                }
                else if(extraCount[4]==10) {
                    p.remove(b[4][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b14": // cut extra chashu
                extraCount[4]--;
                l[4][2].setText(Integer.toString(extraCount[4]));
                if(extraCount[4]==9) {
                    p.add(b[4][1]);
                }
                else if(extraCount[4]==0) {
                    l[4][2].setText("0");
                    p.remove(b[4][0]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b25": // add extra chashu
                extraCount[5]++;
                l[5][2].setText(Integer.toString(extraCount[5]));
                if(extraCount[5]==1) {
                    p.add(b[5][0]);
                }
                else if(extraCount[5]==10) {
                    p.remove(b[5][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b15": // cut extra chashu
                extraCount[5]--;
                l[5][2].setText(Integer.toString(extraCount[5]));
                if(extraCount[5]==9) {
                    p.add(b[5][1]);
                }
                else if(extraCount[5]==0) {
                    l[5][2].setText("0");
                    p.remove(b[5][0]);
                }
                updateSum();
                p.updateUI();
                break;
            case "b26": // add extra chashu
                extraCount[6]++;
                l[6][2].setText(Integer.toString(extraCount[6]));
                if(extraCount[6]==1) {
                    p.add(b[6][0]);
                }
                else if(extraCount[6]==10) {
                    p.remove(b[6][1]);
                }
                updateSum();
                p.updateUI();
                break;

            case "b16": // cut extra chashu
                extraCount[6]--;
                l[6][2].setText(Integer.toString(extraCount[6]));
                if(extraCount[6]==9) {
                    p.add(b[6][1]);
                }
                else if(extraCount[6]==0) {
                    l[6][2].setText("0");
                    p.remove(b[6][0]);
                }
                updateSum();
                p.updateUI();
                break;
            case "b_0": // OK
                if(ramen==0&&extraCount[0]==0&&extraCount[1]==0&&extraCount[2]==0&&extraCount[3]==0&&extraCount[4]==0&&extraCount[5]==0&&extraCount[6]==0) {
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
                for(int i=0;i<7;i++) {
                	dishName[i]=null;
                	extraCount[i]=0;
                	dishPrice[i]=0.0;
                }
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
