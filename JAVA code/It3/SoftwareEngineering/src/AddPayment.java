/**
 * Title        : AddPayment.java
 * Description  : Add other payment way for users
 * @author      : Zhang Jiaqi
 * @version     : 1.0
 */
import javax.swing.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class AddPayment extends JFrame implements ActionListener{

	String payment_url = "./payment.json";
	JTextField f1;
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
//		JLabel price=new JLabel("Price(in pounds ��)");
//		price.setHorizontalAlignment(JLabel.CENTER);
//		price.setFont(ff);
		
		f1=new JTextField();
		f1.addActionListener(this);
//		f2=new JTextField();
//		f2.addActionListener(this);
		JPanel extra1=new JPanel();
		JPanel extra11=new JPanel();
		JPanel extra12=new JPanel();
		JPanel extra13=new JPanel();
		JPanel extra14=new JPanel();
		extra1.setLayout(new GridLayout(5,0));
//		JPanel extra2=new JPanel();
//		JPanel extra21=new JPanel();
//		JPanel extra22=new JPanel();
//		extra2.setLayout(new GridLayout(3,0));
		extra1.add(extra11);
		extra1.add(extra12);
		extra1.add(f1);
		extra1.add(extra13);
		extra1.add(extra14);
//		extra2.add(extra21);
//		extra2.add(f2);
//		extra2.add(extra22);
		mainPanel.add(dishName);
		mainPanel.add(extra1);
//		mainPanel.add(price);
//		mainPanel.add(extra2);
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
	
	public void actionPerformed(ActionEvent event){
		String opt = event.getActionCommand();
		
		if(opt=="Back") {
			this.dispose();
			
			try {
				new managePayment();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opt=="Save!")
		{
			this.dispose();
			try {
			write();}
			catch (IOException ex) {
              ex.printStackTrace();
        }
		}
		else if(opt=="Cancel") {
			this.dispose();
			new managerLogin();
			
		}
		
		}
	public void write() throws IOException{
		String s1=f1.getText();
		
		
		//System.out.println(jsonStr);
		
		
		String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr = new FileReader(payment_url);
        BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
        while ((compulsory_temp=compulsory_br.readLine())!=null) {
            compulsory_string = compulsory_string + compulsory_temp + "\n";
        }
        
        JSONObject compulsory = JSONObject.fromObject(compulsory_string);
        JSONArray compulsorydishes = compulsory.getJSONArray("dishes");
        compulsorydishes.add("");
        
        try {
            FileWriter fw = new FileWriter(payment_url);
            PrintWriter pw = new PrintWriter(fw);
            String str[] = compulsory.toString().split(",");
            int i;
            for(i=0; i<str.length-1; i++) {
                pw.println(str[i]+",");
            }
            pw.println(str[i]);
            pw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
