package Boundary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import Entity.Email;
import Control.ReportManage.SetEmail;
public class AutomaticReport extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField EmailText;
	public String status;

	/**
	 * Title       : AutomaticReport.java
	 * Description : ҳ����ת����ɣ��޷���ȡRadioButton��ֵ
	 * @author     : Du Yuang
	 * @version    : 0.8
	 */
	public AutomaticReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{214, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{49, 46, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel AutomaticReport = new JLabel("Automatic Report");
		GridBagConstraints gbc_AutomaticReport = new GridBagConstraints();
		gbc_AutomaticReport.gridwidth = 2;
		gbc_AutomaticReport.insets = new Insets(0, 0, 5, 5);
		gbc_AutomaticReport.gridx = 1;
		gbc_AutomaticReport.gridy = 0;
		contentPane.add(AutomaticReport, gbc_AutomaticReport);
		
		JLabel lblNewLabel = new JLabel("Your E-mail: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		EmailText = new JTextField();
		GridBagConstraints gbc_EmailText = new GridBagConstraints();
		gbc_EmailText.gridwidth = 2;
		gbc_EmailText.insets = new Insets(0, 0, 5, 5);
		gbc_EmailText.fill = GridBagConstraints.HORIZONTAL;
		gbc_EmailText.gridx = 1;
		gbc_EmailText.gridy = 1;
		contentPane.add(EmailText, gbc_EmailText);
		EmailText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Send or not: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton BackButton = new JButton("Back");
		GridBagConstraints gbc_BackButton = new GridBagConstraints();
		gbc_BackButton.fill = GridBagConstraints.VERTICAL;
		gbc_BackButton.insets = new Insets(0, 0, 0, 5);
		gbc_BackButton.gridx = 0;
		gbc_BackButton.gridy = 3;
		BackButton.addActionListener(this);
		
		JRadioButton sendRadioButton = new JRadioButton("Send");
		sendRadioButton.setActionCommand("Send");
		GridBagConstraints gbc_sendRadioButton = new GridBagConstraints();
		gbc_sendRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_sendRadioButton.gridx = 1;
		gbc_sendRadioButton.gridy = 2;
		contentPane.add(sendRadioButton, gbc_sendRadioButton);
		
		JRadioButton notSendRadioButton = new JRadioButton("Not");
		notSendRadioButton.setActionCommand("Not");
		GridBagConstraints gbc_notSendRadioButton = new GridBagConstraints();
		gbc_notSendRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_notSendRadioButton.gridx = 2;
		gbc_notSendRadioButton.gridy = 2;
		contentPane.add(notSendRadioButton, gbc_notSendRadioButton);
		BackButton.setActionCommand("back");
		contentPane.add(BackButton, gbc_BackButton);
		sendRadioButton.addActionListener(this);	
		notSendRadioButton.addActionListener(this);
		// create a button group
		ButtonGroup YN = new ButtonGroup();
		YN.add(sendRadioButton);
		YN.add(notSendRadioButton);
		
		if(sendRadioButton.isSelected()) {
			status = "send";
		}
		else {
			status = "not";
		}
				
		JButton OKButton = new JButton("OK");
		GridBagConstraints gbc_OKButton = new GridBagConstraints();
		gbc_OKButton.fill = GridBagConstraints.VERTICAL;
		gbc_OKButton.gridwidth = 2;
		gbc_OKButton.insets = new Insets(0, 0, 0, 5);
		gbc_OKButton.gridx = 1;
		gbc_OKButton.gridy = 3;
		OKButton.addActionListener(this);
		OKButton.setActionCommand("ok");
		contentPane.add(OKButton, gbc_OKButton);
		
		JButton CancelButton = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.fill = GridBagConstraints.VERTICAL;
		gbc_CancelButton.gridx = 3;
		gbc_CancelButton.gridy = 3;
		CancelButton.addActionListener(this);
		CancelButton.setActionCommand("cancel");
		contentPane.add(CancelButton, gbc_CancelButton);
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String opt = e.getActionCommand();
		switch (opt) {
			case "back":
				this.dispose();
			try {
				new ReportShow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
			case "ok":{
				// add information to json file
				if(checkEmail(EmailText.getText())==1) {
					String email = EmailText.getText();	
					Email emailobject = new Email(email,status);
					SetEmail setemail = new SetEmail();
					setemail.SetNewEmail(emailobject);		
					this.dispose();
					try {
						new ReportShow();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					  JOptionPane.showMessageDialog(null, "Please enter your email in the correct format !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
			}
			case "cancel":
				this.dispose();
				new managerLogin();
				break;
			case "Send":
				status = "Send";
				break;
			case "Not":
				status = "Not";
				break;
			default:
                System.out.println("---ERROR - Detail---");
		}
	}
	public int checkEmail(String email) {
        String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==true) {
            return 1;
        }
        else {
            return 0;
        }
    }
	
}

