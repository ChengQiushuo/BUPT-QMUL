package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: AutomaticReport.java 
 * packageName: Boundary
 * date:2020.4
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
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
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import Entity.Email;
import Control.ReportManage.SetEmail;

/**
 * ClassName: AutomaticReport<br>
 * Description: This is the GUI interface of configure the email setting.
 * @version V2.0
 * @author Du Yuang
 * @author Zhang Jiaqi
 */
public class AutomaticReport extends JFrame implements ActionListener {

	JTextField f1;
	/**the availability status of the report service*/
	public String status;

	/**
	* This constructor used to set up the GUI interface
	*/
	public AutomaticReport() {
		JPanel topPanel=new JPanel();
		JPanel middlePanel=new JPanel();
		JPanel mainPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		
		topPanel.setLayout(new GridLayout());
		middlePanel.setLayout(new BorderLayout(10,10));
		mainPanel.setLayout(new GridLayout(2,2));
		bottomPanel.setLayout(new GridLayout(0,5));
		
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		JLabel title=new JLabel("AutomaticReport");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(f);
		topPanel.add(title);
		
		Font ff = new Font("TimesRoman", Font.BOLD, 20);//middlePanel layout configuration
		JLabel dishName=new JLabel("Email Name:");
		dishName.setHorizontalAlignment(JLabel.CENTER);
		dishName.setFont(ff);
		JLabel price=new JLabel("Send or not:");
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setFont(ff);
		
		f1=new JTextField();
		f1.addActionListener(this);
		JPanel extra1=new JPanel();
		JPanel extra11=new JPanel();
		JPanel extra12=new JPanel();
		extra1.setLayout(new GridLayout(3,0));
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		JRadioButton rb1 = new JRadioButton("Send");
        rb1.setFont(new Font(null, Font.BOLD, 20));
        rb1.addActionListener(this);
        JRadioButton rb2 = new JRadioButton("Not send");
        rb2.setFont(new Font(null, Font.BOLD, 20));
        rb2.addActionListener(this);
        buttonPanel.add(rb1);
        buttonPanel.add(rb2);
        ButtonGroup g1=new ButtonGroup();
        g1.add(rb1); 
        g1.add(rb2);
        rb1.setSelected(true);
        
		
		extra1.add(extra11);
		extra1.add(f1);
		extra1.add(extra12);
		mainPanel.add(dishName);
		mainPanel.add(extra1);
		mainPanel.add(price);
		mainPanel.add(buttonPanel);
		
		JPanel west=new JPanel();
		JPanel east=new JPanel();
		middlePanel.add(mainPanel);
		middlePanel.add(east, BorderLayout.EAST);
		middlePanel.add(west, BorderLayout.WEST);
		middlePanel.add(west, BorderLayout.SOUTH);
		
		
		JButton back=new JButton("<-Back");//bottomPanel configuration
		back.addActionListener(this);
		JButton ok=new JButton("Save!");
		ok.addActionListener(this);
		JButton cancel=new JButton("Cancel->");
		cancel.addActionListener(this);
		JLabel coushu1=new JLabel();
		JLabel coushu2=new JLabel();
		bottomPanel.add(back);
		bottomPanel.add(coushu1);
		bottomPanel.add(ok);
		bottomPanel.add(coushu2);
		bottomPanel.add(cancel);
		
		GridBagLayout gridBagLayout=new GridBagLayout(); 
		this.setLayout(gridBagLayout); 
		GridBagConstraints gridBagConstraints=new GridBagConstraints();
		
		gridBagLayout.columnWidths = new int[]{0};  //set the column of the entire interface
        gridBagLayout.rowHeights = new int[]{0,0,0};
        gridBagLayout.columnWeights = new double[]{1.0};
        gridBagLayout.rowWeights = new double[]{0.2,0.7,0.1};
		
		gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagLayout.setConstraints(topPanel, gridBagConstraints);
        
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagLayout.setConstraints(middlePanel, gridBagConstraints);
        
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagLayout.setConstraints(bottomPanel, gridBagConstraints);

    
        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AutomaticReport");
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	
	/**
	* Used to react to the event happened on the interface elements
	* @param e the event happened on the interface elements
	*/
	public void actionPerformed(ActionEvent e) {
		String opt = e.getActionCommand();
		switch (opt) {
			case "<-Back":
				this.dispose();
			try {
				new ReportShow();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				break;
			case "Save!":{
				if(checkEmail(f1.getText())==1) {
					String email = f1.getText();	
					Email emailobject = new Email(email,status);
					SetEmail setemail = new SetEmail();
					setemail.SetNewEmail(emailobject);//let the control class to do the email setting		
					this.dispose();
					try {
						new ReportShow();//back to previous interface
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					  JOptionPane.showMessageDialog(null, "Please enter your email in the correct format !", "Invalid information", JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
			}
			case "Cancel->":
				this.dispose();
				new managerLogin();
				break;
			case "Send":
				status = "Send";
				break;
			case "Not Send":
				status = "Not";
				break;
			default:
                System.out.println("---ERROR - Detail---");
		}
	}
	
	/**
	* Used to check whether the input follows the email format requirements
	* @param email the input string represent the email
	* @return int 0 represents the input does not follow the email format, otherwise 1 represents follows.
	*/
	public int checkEmail(String email) {
        String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regEx);//the format
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==true) {
            return 1;
        }
        else {
            return 0;
        }
    }
	
}

