package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: SimpleOption.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import Control.CompulsoryManage.ModifyCompulsory;;

/**
 * ClassName: SimpleOption<br>
 * Description: This is the GUI interface of adding dishes with simple options(yes or no)
 * @version V2.0
 * @author Du Yuang
 * @author Zhang Jiaqi
 */
public class SimpleOption extends JFrame implements ActionListener {
	private JTextField f1;
	
	/**
	* This constructor used to set up the GUI interface
	*/
	public SimpleOption() {
		JPanel topPanel=new JPanel();
		JPanel middlePanel=new JPanel();
		JPanel mainPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		
		topPanel.setLayout(new GridLayout());
		middlePanel.setLayout(new BorderLayout(10,10));
		mainPanel.setLayout(new GridLayout(1,2));
		bottomPanel.setLayout(new GridLayout(0,5));
		
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		JLabel title=new JLabel("Add A Dish");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(f);
		topPanel.add(title);
		
		Font ff = new Font("TimesRoman", Font.BOLD, 17);//middlePanel layout configuration
		JLabel dishName=new JLabel("Dish Name:");
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
		this.setTitle("Add a Dish");
		this.setSize(550, 400);
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
				new DishAddChoose();//back to previous interface
				break;
			case "Save!":
				/*examine whether the input box is null, if not write the content into file.*/
				if(f1.getText().isBlank()==true) {
					JOptionPane.showMessageDialog(null, "The dish name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
				}
				
				else if(f1.getText().isBlank()==false)
				{
					ModifyCompulsory modifyCompulsory = new ModifyCompulsory();
					modifyCompulsory.AddSimpleOption(f1.getText());// write to file by calling control class					
					this.dispose();				
					JOptionPane.showMessageDialog(null, "The message has been saved!", "Successful!",-1);
					new DishAddChoose();																
				}
				break;
			case "Cancel->":
				this.dispose();
				new managerLogin();
				break;
			default:
                System.out.println("---ERROR - Detail---");
		}
	}
}
