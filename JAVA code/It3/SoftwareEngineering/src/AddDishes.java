/**
 * Title        : AddDishes.java
 * Description  : Add a compulsory dish to the menu
 * @author      : Zhang Jiaqi
 * @version     : 1.0(I1)
 */
import javax.swing.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class AddDishes extends JFrame implements ActionListener{
	String compulsory_url = "./compulsory.json";
	JTextField f1;
	JTextField f2;
	JTextField f3;
	JTextField f4;
	JTextField f5;
	
	public AddDishes() {
		JPanel topPanel=new JPanel();
		JPanel middlePanel=new JPanel();
		JPanel mainPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		
		topPanel.setLayout(new GridLayout());
		middlePanel.setLayout(new BorderLayout(10,10));
		mainPanel.setLayout(new GridLayout(5,2));
		bottomPanel.setLayout(new GridLayout(0,5));

		
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		JLabel title=new JLabel("Add A Dish");
//		title.setBorder(BorderFactory.createLineBorder(Color.red));
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
		JPanel extra5=new JPanel();
		JPanel extra51=new JPanel();
		JPanel extra52=new JPanel();
		extra5.setLayout(new GridLayout(3,0));
		
		 f1=new JTextField();
		f1.addActionListener(this);
		f2=new JTextField();
		f2.addActionListener(this);
		f3=new JTextField();
		f3.addActionListener(this);
		f4=new JTextField();
		f4.addActionListener(this);
		f5=new JTextField();
		f5.addActionListener(this);
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
		extra5.add(extra51);
		extra5.add(f5);
		extra5.add(extra52);
		
		mainPanel.add(dishName);
		mainPanel.add(extra1);
		mainPanel.add(option1);
		mainPanel.add(extra2);
		mainPanel.add(option2);
		mainPanel.add(extra3);
		mainPanel.add(option3);
		mainPanel.add(extra4);
		mainPanel.add(price);
		mainPanel.add(extra5);
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
			this.dispose();
			try {
			write();}
			catch (IOException ex) {
              ex.printStackTrace();
        }
		new DishAddChoose();	
		}
		}
	
	public void write() throws IOException{
		String s1=f1.getText();
		String s2=f2.getText();
		String s3=f3.getText();
		String s4=f4.getText();
		String s5=f5.getText();
		float a=Float.parseFloat(s5);
		Double d= Double.parseDouble(s5);
		DecimalFormat df = new DecimalFormat("0.00");
		String s=df.format(d);
		String jsonStr = "{\"dishID\":\"compulsory08\",\"name\":\""+s1+"\",\"price\":\""+s+"\",\"option\":[{\"item\":\""+s2+"\",\"availability\":\"Yes\"},{\"item\":\""+s3+"\",\"availability\":\"Yes\"},{\"item\":\""+s4+"\",\"availability\":\"Yes\"}]}";
		//System.out.println(jsonStr);
		
		
		String compulsory_temp = "";
        String compulsory_string = "";
        FileReader compulsory_fr = new FileReader(compulsory_url);
        BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
        while ((compulsory_temp=compulsory_br.readLine())!=null) {
            compulsory_string = compulsory_string + compulsory_temp + "\n";
        }
        
        JSONObject compulsory = JSONObject.fromObject(compulsory_string);
        JSONArray compulsorydishes = compulsory.getJSONArray("dishes");
        JSONObject json1 = JSONObject.fromObject(jsonStr);
        compulsorydishes.add(json1);
        
        try {
            FileWriter fw = new FileWriter(compulsory_url);
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
