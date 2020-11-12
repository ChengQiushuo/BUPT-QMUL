package Boundary;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import Control.CompulsoryManage.ModifyCompulsory;;
public class SimpleOption extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField DishName;
	/**
	 * Title       : AutomaticReport.java
	 * Description : 
	 * @author     : Du Yuang
	 * @version    : 0.9
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
		
		JButton BackButton = new JButton("<-Back");
		GridBagConstraints gbc_BackButton = new GridBagConstraints();
		gbc_BackButton.insets = new Insets(0, 0, 0, 5);
		gbc_BackButton.gridx = 0;
		gbc_BackButton.gridy = 3;
		BackButton.addActionListener(this);
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
				if(DishName.getText().isBlank()==true) {
					JOptionPane.showMessageDialog(null, "The dish name should not be null!", "Warning!",JOptionPane.WARNING_MESSAGE);
				}
				
				else if(DishName.getText().isBlank()==false)
				{
					ModifyCompulsory modifyCompulsory = new ModifyCompulsory();
					modifyCompulsory.AddSimpleOption(DishName.getText());					
					this.dispose();				
					JOptionPane.showMessageDialog(null, "The message has been saved!", "Successful!",-1);
					new DishAddChoose();																
				}
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
