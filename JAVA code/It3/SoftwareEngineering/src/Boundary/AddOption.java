package Boundary;
/**
 * Title        : AddOption.java
 * Description  : Add another option to the dish
 * @author      : Zhang Jiaqi
 * @version     : 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Control.CompulsoryManage.ModifyCompulsory;

public class AddOption extends JFrame implements ActionListener{

	String compulsory_url = "./compulsory.json";
	JTextField f1;
	//JTextField f2;
	JRadioButton rb1;
	JRadioButton rb2;
	int index;
	String availability ="Yes";
	String name;
	
	public AddOption(String Name,int index) {
		JPanel topPanel=new JPanel();
		JPanel middlePanel=new JPanel();
		JPanel mainPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		this.index=index;
		this.name=Name;
		
		topPanel.setLayout(new GridLayout());
		middlePanel.setLayout(new BorderLayout(10,10));
		mainPanel.setLayout(new GridLayout(2,2));
		bottomPanel.setLayout(new GridLayout(0,5));
		
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		JLabel title=new JLabel("Add another option to this dish");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(f);
		topPanel.add(title);
		
		Font ff = new Font("TimesRoman", Font.BOLD, 17);//middlePanel layout configuration
		JLabel dishName=new JLabel("Option Name:");
		dishName.setHorizontalAlignment(JLabel.CENTER);
		dishName.setFont(ff);
		JLabel price=new JLabel("Availablity:");
		price.setHorizontalAlignment(JLabel.CENTER);
		price.setFont(ff);
		
		f1=new JTextField();
		f1.addActionListener(this);
		rb1 = new JRadioButton("Yes");
        rb1.setFont(new Font(null, Font.BOLD, 20));
        rb1.setBounds(465, 540, 150, 25);
        rb1.setActionCommand("rb1");
        rb1.setSelected(true);
        rb1.addActionListener(this);
       
        rb2 = new JRadioButton("No");
        rb2.setFont(new Font(null, Font.BOLD, 20));
        rb2.setBounds(465, 570, 150, 25);
        rb2.setActionCommand("rb2");
        rb2.addActionListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
		
        JPanel rbpanel=new JPanel();
        rbpanel.setLayout(new GridLayout(0,2));
        rbpanel.add(rb1);
        rbpanel.add(rb2);
        
		JPanel extra1=new JPanel();
		JPanel extra11=new JPanel();
		JPanel extra12=new JPanel();
		extra1.setLayout(new GridLayout(3,0));
		JPanel extra2=new JPanel();
		JPanel extra21=new JPanel();
		JPanel extra22=new JPanel();
		extra2.setLayout(new GridLayout(3,0));
		extra1.add(extra11);
		extra1.add(f1);
		extra1.add(extra12);
		extra2.add(extra21);
		extra2.add(rbpanel);
		extra2.add(extra22);
		mainPanel.add(dishName);
		mainPanel.add(extra1);
		mainPanel.add(price);
		mainPanel.add(extra2);
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
		
		gridBagLayout.columnWidths = new int[]{0};  //�������ܹ���һ��
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
		this.setTitle("Add another option");
		this.setSize(550, 400);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		String opt = event.getActionCommand();
		
		if(opt=="<-Back") {
			this.dispose();
			try {
			new ModifyCompulsoryDish (index);
			}
			catch (IOException ex) {
              ex.printStackTrace();
         }
			
		}
		else if(opt=="Save!")
		{
			if(f1.getText().isBlank()==true) {
			JOptionPane.showMessageDialog(null, "The option name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
		}
		else if(f1.getText().isBlank()==false) {
				ModifyCompulsory modifyCompulsory = new ModifyCompulsory();
				modifyCompulsory.AddExtraOption(index, f1.getText(), availability);
				this.dispose();
				try {
					new ModifyMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "The message has been saved!", "Successful!",-1);			
		}			
		}
		else if(opt=="Cancel->") {
			this.dispose();
			new managerLogin();
			
		}
		else if(opt=="rb1") {
			availability="Yes";
		}
		else if(opt=="rb2") {
			availability="No";
		}
		
		}
}
