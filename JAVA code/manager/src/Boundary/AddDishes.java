package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: AddDishes.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.CompulsoryManage.ModifyCompulsory;

/**
 * ClassName: AddDishes<br>
 * Description: This is the GUI interface of adding dishes with ranking options
 * @version V4.0
 * @author Zhang Jiaqi
 */
public class AddDishes extends JFrame implements ActionListener{
	JTextField f1;
	JTextField f2;
	JTextField f3;
	JTextField f4;
	
	/**
	* This constructor used to set up the GUI interface
	*/
	public AddDishes() {
		JPanel topPanel=new JPanel();
		JPanel middlePanel=new JPanel();
		JPanel mainPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		
		topPanel.setLayout(new GridLayout());
		middlePanel.setLayout(new BorderLayout(10,10));
		mainPanel.setLayout(new GridLayout(4,2));
		bottomPanel.setLayout(new GridLayout(0,5));

		
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		JLabel title=new JLabel("Add A Dish");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(f);
		
		topPanel.add(title);
		
		Font ff = new Font("TimesRoman", Font.BOLD, 17);//middlePanel layout configuration
		JLabel dishName=new JLabel("Dish Name");
		dishName.setHorizontalAlignment(JLabel.CENTER);
		dishName.setFont(ff);
		JLabel option1=new JLabel("Option 1(light weight)");
		option1.setHorizontalAlignment(JLabel.CENTER);
		option1.setFont(ff);
		JLabel option2=new JLabel("Option 2(medium)");
		option2.setHorizontalAlignment(JLabel.CENTER);
		option2.setFont(ff);
		JLabel option3=new JLabel("Option 3(heavy weight)");
		option3.setHorizontalAlignment(JLabel.CENTER);
		option3.setFont(ff);
		JLabel price=new JLabel("Price(in pounds ��)");
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setFont(ff);
		
		JPanel extra1=new JPanel();
		JPanel extra11=new JPanel();
		JPanel extra12=new JPanel();
		extra1.setLayout(new GridLayout(3,0));
		JPanel extra2=new JPanel();
		JPanel extra21=new JPanel();
		JPanel extra22=new JPanel();
		extra2.setLayout(new GridLayout(3,0));
		JPanel extra3=new JPanel();
		JPanel extra31=new JPanel();
		JPanel extra32=new JPanel();
		extra3.setLayout(new GridLayout(3,0));
		JPanel extra4=new JPanel();
		JPanel extra41=new JPanel();
		JPanel extra42=new JPanel();
		extra4.setLayout(new GridLayout(3,0));
		
		f1=new JTextField();
		f1.addActionListener(this);
		f2=new JTextField();
		f2.addActionListener(this);
		f3=new JTextField();
		f3.addActionListener(this);
		f4=new JTextField();
		f4.addActionListener(this);
		
		extra1.add(extra11);
		extra1.add(f1);
		extra1.add(extra12);
		extra2.add(extra21);
		extra2.add(f2);
		extra2.add(extra22);
		extra3.add(extra31);
		extra3.add(f3);
		extra3.add(extra32);
		extra4.add(extra41);
		extra4.add(f4);
		extra4.add(extra42);
		
		mainPanel.add(dishName);
		mainPanel.add(extra1);
		mainPanel.add(option1);
		mainPanel.add(extra2);
		mainPanel.add(option2);
		mainPanel.add(extra3);
		mainPanel.add(option3);
		mainPanel.add(extra4);
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
		
		gridBagLayout.columnWidths = new int[]{0};
        gridBagLayout.rowHeights = new int[]{0,0,0};
        gridBagLayout.columnWeights = new double[]{1.0};
        gridBagLayout.rowWeights = new double[]{0.1,0.8,0.1};
		
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
		this.setTitle("Add a Dish");
		this.setSize(450, 600);
		this.setVisible(true);
	}

	/**
	* Used to react to the event happened on the interface elements
	* @param event the event happened on the interface elements
	*/
	public void actionPerformed(ActionEvent event) {
		String opt = event.getActionCommand();
		
		if(opt=="<-Back") {
			this.dispose();
			new DishAddChoose();
			
		}
		else if(opt=="Cancel->") {
			this.dispose();			
			new managerLogin();	
		}
		else if(opt=="Save!")
		{
			/*examine whether the input box is null, if not write the content into file.*/
			if(f1.getText().isBlank()==true) {
				JOptionPane.showMessageDialog(null, "The dish name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
			else if(f1.getText().isBlank()==false&&f2.getText().isBlank()==true) {
				JOptionPane.showMessageDialog(null, "The option1 name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
			else if(f1.getText().isBlank()==false&&f2.getText().isBlank()==false&&f3.getText().isBlank()==true) {
				JOptionPane.showMessageDialog(null, "The option2 name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
			else if(f1.getText().isBlank()==false&&f2.getText().isBlank()==false&&f3.getText().isBlank()==false&&f4.getText().isBlank()==true) {
				JOptionPane.showMessageDialog(null, "The option3 name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
			
			else if(f1.getText().isBlank()==false&&f2.getText().isBlank()==false&&f3.getText().isBlank()==false&&f4.getText().isBlank()==false) 
			{
					ModifyCompulsory modifyCompulsory = new ModifyCompulsory();
					modifyCompulsory.AddRankingOption(f1.getText(), f2.getText(), f3.getText(), f4.getText());					
				JOptionPane.showMessageDialog(null, "The message has been saved!", "Successful!",-1);
				this.dispose();
				new DishAddChoose();// back to previous interface
				}				
			}
		}

}