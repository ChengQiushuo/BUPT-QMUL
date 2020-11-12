package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: AddPayment.java 
 * packageName: Boundary
 * date:2020.4
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Control.PaymentManage.*;

/**
 * ClassName: AddPayment<br>
 * Description: This is the GUI interface of adding another payment way for the customer
 * @version V1.0
 * @author Zhang Jiaqi
 */
public class AddPayment extends JFrame implements ActionListener{

	 String payment_url = "./payment.json";
	 JTextField f1;
	 
	 /**
	  * This constructor used to set up the GUI interface
	  */
	public AddPayment(){
		JPanel topPanel=new JPanel();
		JPanel middlePanel=new JPanel();
		JPanel mainPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		
		topPanel.setLayout(new GridLayout());
		middlePanel.setLayout(new BorderLayout(10,10));
		mainPanel.setLayout(new GridLayout(1,2));
		bottomPanel.setLayout(new GridLayout(0,5));		
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		JLabel title=new JLabel("Add A Payment Method");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(f);
		topPanel.add(title);		
		Font ff = new Font("TimesRoman", Font.BOLD, 17);//middlePanel layout configuration
		JLabel dishName=new JLabel("Payment Name :");
		dishName.setHorizontalAlignment(JLabel.CENTER);
		dishName.setFont(ff);	
		f1=new JTextField();
		f1.addActionListener(this);
		JPanel extra1=new JPanel();
		JPanel extra11=new JPanel();
		JPanel extra12=new JPanel();
		JPanel extra13=new JPanel();
		JPanel extra14=new JPanel();
		extra1.setLayout(new GridLayout(5,0));
		extra1.add(extra11);
		extra1.add(extra12);
		extra1.add(f1);
		extra1.add(extra13);
		extra1.add(extra14);
		mainPanel.add(dishName);
		mainPanel.add(extra1);
		JPanel west=new JPanel();
		JPanel east=new JPanel();
		middlePanel.add(mainPanel);
		middlePanel.add(east, BorderLayout.EAST);
		middlePanel.add(west, BorderLayout.WEST);
		middlePanel.add(west, BorderLayout.SOUTH);			
		JButton back=new JButton("Back");//bottomPanel configuration
		back.addActionListener(this);
		JButton ok=new JButton("Save!");
		ok.addActionListener(this);
		JButton cancel=new JButton("Cancel");
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
		gridBagLayout.columnWidths = new int[]{0};  
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
		this.setTitle("Add A Payment Way");
		this.setBounds(200, 133, 1000, 768);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	
	/**
	* Used to react to the event happened on the interface elements
	* @param event the event happened on the interface elements
	*/
	public void actionPerformed(ActionEvent event){
		String opt = event.getActionCommand();
		
		if(opt=="Back") {
			this.dispose();
			
			try {
				new managePayment();//back to manage interface
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(opt=="Save!")
		{
			/*examine whether the input box is null, if not write the content into file.*/
			if(f1.getText().isBlank()==true) {
				JOptionPane.showMessageDialog(null, "The payment name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
			else if(f1.getText().isBlank()==false)
			{
			this.dispose();
			String s1=f1.getText();
			ModifyPayment modifypayment = new ModifyPayment();
			modifypayment.addPayment(s1);
			try {
				new managePayment();//back to previous interface
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
        }
		
		else if(opt=="Cancel") {
			this.dispose();
			new managerLogin();
			
		}
		
		}
	
}
