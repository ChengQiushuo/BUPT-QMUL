package Boundary;
/**
 * Title        : managementOptions.java
 * Description  : Choose one of the options to manage restaurant
 * @author      : Cheng Qiushuo
 * @version     : 2.0
 * Notes        :This version has been modified by Zhang Jiaqi
 */
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class managementOptions {

    public managementOptions() {
        frame.setBounds(200, 133, 1000, 768);
        frame.setContentPane(panel2);
       
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        modifyMenuButton.addActionListener(new modifyListener());
        addPaymentButton.addActionListener(new paymentListener());
        seeReportButton.addActionListener(new reportListener());
        BACKButton.addActionListener(new backListener());
    }

    private JPanel panel0;
    private JPanel panel2;
    private JPanel panel3;
    private JButton modifyMenuButton;
    private JButton addPaymentButton;
    private JButton seeReportButton;
    private JButton BACKButton;
    private JPanel panel1;
    JFrame frame = new JFrame("managementOptions");

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel0 = new JPanel();
      //  panel0.setBorder(BorderFactory.createLineBorder(Color.red));
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel0.setLayout(new GridLayoutManager(7, 8, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel0,BorderLayout.CENTER);
        panel2.add(panel3,BorderLayout.NORTH);
        
        panel1 = new JPanel();
       // panel1.setBorder(BorderFactory.createLineBorder(Color.red));
        panel1.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
//        panel0.add(panel1, new GridConstraints(0, 0, 1, 7, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(720, 408), null, 0, false));
        panel0.add(panel1, new GridConstraints(2, 0, 1, 7, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Palatino Linotype", Font.ITALIC, 48, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Management System");
        panel3.add(label1, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        
        final JLabel tiankong1 = new JLabel();//used to help set layout
        tiankong1.setText("                ");
        panel0.add(tiankong1, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel tiankong2 = new JLabel();
        tiankong2.setText("                ");
        panel0.add(tiankong2, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        
        modifyMenuButton = new JButton();
        Font modifyMenuButtonFont = this.$$$getFont$$$("Palatino Linotype", Font.ITALIC, 36, modifyMenuButton.getFont());
        if (modifyMenuButtonFont != null) modifyMenuButton.setFont(modifyMenuButtonFont);
        modifyMenuButton.setText("Modify menu");
        modifyMenuButton.setFocusPainted(false); 
        panel1.add(modifyMenuButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        
        seeReportButton = new JButton();
        Font seeReportButtonFont = this.$$$getFont$$$("Palatino Linotype", Font.ITALIC, 36, seeReportButton.getFont());
        if (seeReportButtonFont != null) seeReportButton.setFont(seeReportButtonFont);
        seeReportButton.setText("See Report");
        panel1.add(seeReportButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        
        final JLabel label2 = new JLabel();
        label2.setText("            ");
        addPaymentButton = new JButton();
        Font addPaymentButtonFont = this.$$$getFont$$$("Palatino Linotype", Font.ITALIC, 36, addPaymentButton.getFont());
        if (addPaymentButton != null) addPaymentButton.setFont(addPaymentButtonFont);
        addPaymentButton.setText("Manage Payment");
        panel1.add(addPaymentButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel1.add(label2, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        
        final JLabel label3 = new JLabel();
        label3.setText("                ");
        panel1.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        
        final JLabel tiankong3 = new JLabel();
        tiankong3.setText("                ");
        panel0.add(tiankong3, new GridConstraints(3, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel tiankong4 = new JLabel();
        tiankong4.setText("                ");
        panel0.add(tiankong4, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        BACKButton = new JButton();
        Font BACKButtonFont = this.$$$getFont$$$("Consolas", Font.BOLD | Font.ITALIC, 18, BACKButton.getFont());
        if (BACKButtonFont != null) BACKButton.setFont(BACKButtonFont);
        BACKButton.setText("BACK");
        panel0.add(BACKButton, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        
        
        final JLabel label4 = new JLabel();
        label4.setText("               ");
        panel0.add(label4, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("              ");
        panel0.add(label5, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("           ");
        panel0.add(label6, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel0;
    }

    public class modifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try { 
            	new ModifyMenu();
            	frame.dispose();
               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class reportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        	frame.dispose();
            try {
				new ReportShow();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    public class paymentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        	frame.dispose();
        	try {
				new managePayment();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    public class backListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new managerLogin();
            frame.dispose();
        }
    }
}
