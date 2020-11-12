package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: managerLogin.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.LoginManage.*;

/**
 * ClassName: managerLogin<br>
 * Description: This is the GUI interface of doing the authorization of manager
 * @version V2.0
 * @author Cheng Qiushuo
 */
/*
 * Management system default password is 123abc.
 */
public class managerLogin implements ActionListener{
    private JPasswordField passwordField1;
    private JButton confirmButton;
    private JPanel panel1;
    private JPanel panel0;    
    String inputPassword;
    JFrame frame = new JFrame("managerLogin");

    /**
	* This constructor used to set up the GUI interface
	*/
    public managerLogin() {
    	$$$setupUI$$$();// set up GUI interface in details
        frame.setBounds(200, 133, 1000, 768);

        frame.setContentPane(panel0);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //password = "123abc";
        confirmButton.addActionListener(this);
        }
    
    /**
	* The main method used to begin the whole manager system by create a managerLogin object.
	* @param args used to receive command line parameter 
	*/
    public static void main(String[] args) {
    	new managerLogin();
    }

    /**
	* This method used to set up GUI interface in details, like set up layout and elements.
	* @return no return value
	*/
    private void $$$setupUI$$$() {
        panel0 = new JPanel();
        panel0.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel0.setPreferredSize(new Dimension(720, 408));
        final Spacer spacer1 = new Spacer();
        panel0.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 9, new Insets(0, 0, 0, 0), -1, -1));
        panel0.add(panel1, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(3, 1, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Palatino Linotype", Font.ITALIC, 48, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Management System");
        panel1.add(label1, new GridConstraints(0, 1, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, Font.ITALIC, 26, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Password:");
        panel1.add(label2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        confirmButton = new JButton();
        Font confirmButtonFont = this.$$$getFont$$$(null, -1, 20, confirmButton.getFont());
        if (confirmButtonFont != null) confirmButton.setFont(confirmButtonFont);
        confirmButton.setText("Confirm");
        panel1.add(confirmButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField1 = new JPasswordField();
        panel1.add(passwordField1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("                     ");
        panel1.add(label3, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("");
        panel1.add(label4, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("      ");
        panel1.add(label5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    
    /**
	* This method used to set up the font.
	* @param fontName the font name wanted to use
	* @param style the font style
	* @param size the font size
	* @param currentFont the font type that current label is using
	* @return Font the font that will used
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
	* Used to react to the event happened on the confirm button
	* @param actionEvent the event happened on the button
	*/
    public void actionPerformed(ActionEvent actionEvent) 
    {
           inputPassword = new String(passwordField1.getPassword());
            Login login  = new Login();
            if (login.isSuccessful(inputPassword)) {
            	frame.dispose();
            new managementOptions();

            } else {
            	JOptionPane.showMessageDialog(null, "Wrong Password!", "Error", JOptionPane.INFORMATION_MESSAGE);
                passwordField1.setText("");

            }
     }
}
