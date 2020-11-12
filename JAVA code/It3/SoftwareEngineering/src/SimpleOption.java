import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.SwingConstants;

public class SimpleOption extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField DishPrice;
	private JTextField DishName;
	private JSONObject dish;

	/**
	 * Title       : AutomaticReport.java
	 * Description : 
	 * @author     : Du Yuang
	 * @version    : 0.9
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleOption frame = new SimpleOption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleOption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 198, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 49, 55, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_2 = new JLabel("Dish Add");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Dish Name: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		DishName = new JTextField();
		GridBagConstraints gbc_DishName = new GridBagConstraints();
		gbc_DishName.insets = new Insets(0, 0, 5, 5);
		gbc_DishName.fill = GridBagConstraints.HORIZONTAL;
		gbc_DishName.gridx = 1;
		gbc_DishName.gridy = 1;
		contentPane.add(DishName, gbc_DishName);
		DishName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Price: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		DishPrice = new JTextField();
		GridBagConstraints gbc_DishPrice = new GridBagConstraints();
		gbc_DishPrice.insets = new Insets(0, 0, 5, 5);
		gbc_DishPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_DishPrice.gridx = 1;
		gbc_DishPrice.gridy = 2;
		contentPane.add(DishPrice, gbc_DishPrice);
		DishPrice.setColumns(10);
		
		JButton BackButton = new JButton("<-Back");
		GridBagConstraints gbc_BackButton = new GridBagConstraints();
		gbc_BackButton.insets = new Insets(0, 0, 0, 5);
		gbc_BackButton.gridx = 0;
		gbc_BackButton.gridy = 3;
		BackButton.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("\u00A3                           ");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		BackButton.setActionCommand("back");
		contentPane.add(BackButton, gbc_BackButton);
		
		JButton OKButton = new JButton("OK");
		GridBagConstraints gbc_OKButton = new GridBagConstraints();
		gbc_OKButton.insets = new Insets(0, 0, 0, 5);
		gbc_OKButton.gridx = 1;
		gbc_OKButton.gridy = 3;
		OKButton.addActionListener(this);
		OKButton.setActionCommand("ok");
		contentPane.add(OKButton, gbc_OKButton);
		
		JButton CancelButton = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.gridx = 2;
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
				new DishAddChoose();
				break;
			case "ok":
				try {
					String dishName = DishName.getText();
					String dishPrice = DishPrice.getText();
					JSONObject compulsory;
					JSONArray compulsory_dishes;
					String compulsory_temp = "";
					String compulsory_string = "";
					String[] compulsory_dish = new String[15];
					FileReader compulsory_fr = new FileReader("./compulsory.json");
					BufferedReader compulsory_br = new BufferedReader(compulsory_fr);
					// read the file and add a new dish
					while ((compulsory_temp=compulsory_br.readLine())!=null) {
						compulsory_string = compulsory_string + compulsory_temp + "\n";
					}	
					compulsory_string = compulsory_string.substring(0,compulsory_string.length()-3) + ",\n{dishID:compulsorty08"+",\n"+"name:"+dishName+",\n"+"price:"+dishPrice+"}]}\n";
					compulsory = new JSONObject(compulsory_string);
					compulsory_dishes = compulsory.getJSONArray("dishes");
					for(int i=0; i<compulsory_dishes.length(); i++) {
						JSONObject obj = (JSONObject)compulsory_dishes.get(i);
						compulsory_dish[i] = obj.getString("name");
					}
		        
					// write the file
					FileWriter fw = new FileWriter("./compulsory.json");
					PrintWriter pw = new PrintWriter(fw);
					String str[] = compulsory.toString().split(",");
					int i;
					for(i=0; i<str.length-1; i++) {
						pw.println(str[i]+",");
					}
					pw.println(str[i]);
					compulsory_br.close();
					compulsory_fr.close();
					pw.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
			}
				this.dispose();
				new DishAddChoose();
				break;
			case "cancel":
				this.dispose();
				new managerLogin();
				break;
			default:
                System.out.println("---ERROR - Detail---");
		}
	}
}
