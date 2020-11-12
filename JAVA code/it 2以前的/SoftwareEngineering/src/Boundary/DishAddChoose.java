package Boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DishAddChoose extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * @author     : Du Yuang
	 * @version    : 0.8
	 */
	/**
	 * Create the frame.
	 */
	public DishAddChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{61, 0, 68, 0, 47, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Disk Add");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton RankingOptionButton = new JButton("Ranking Options");
		GridBagConstraints gbc_RankingOptionButton = new GridBagConstraints();
		gbc_RankingOptionButton.fill = GridBagConstraints.BOTH;
		gbc_RankingOptionButton.insets = new Insets(0, 0, 5, 5);
		gbc_RankingOptionButton.gridx = 2;
		gbc_RankingOptionButton.gridy = 2;
		RankingOptionButton.addActionListener(this);
		RankingOptionButton.setActionCommand("rank");
		contentPane.add(RankingOptionButton, gbc_RankingOptionButton);
		
		JButton SimpleOptionButton = new JButton("Simple Options");
		GridBagConstraints gbc_SimpleOptionButton = new GridBagConstraints();
		gbc_SimpleOptionButton.fill = GridBagConstraints.BOTH;
		gbc_SimpleOptionButton.insets = new Insets(0, 0, 5, 5);
		gbc_SimpleOptionButton.gridx = 4;
		gbc_SimpleOptionButton.gridy = 2;
		SimpleOptionButton.addActionListener(this);
		SimpleOptionButton.setActionCommand("simple");
		contentPane.add(SimpleOptionButton, gbc_SimpleOptionButton);
		
		JButton BackButton = new JButton("<-Back");
		GridBagConstraints gbc_BackButton = new GridBagConstraints();
		gbc_BackButton.insets = new Insets(0, 0, 0, 5);
		gbc_BackButton.gridx = 0;
		gbc_BackButton.gridy = 4;
		BackButton.addActionListener(this);
		BackButton.setActionCommand("back");
		contentPane.add(BackButton, gbc_BackButton);
		
		JButton CancelButton = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.gridx = 6;
		gbc_CancelButton.gridy = 4;
		CancelButton.addActionListener(this);
		CancelButton.setActionCommand("cancel");
		contentPane.add(CancelButton, gbc_CancelButton);

		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String opt = e.getActionCommand();
		switch (opt) {
			case "rank":
				this.dispose();
				new AddDishes();
				break;
			case "simple":
				new SimpleOption();
				this.dispose();
                break;
			case "back":
				this.dispose();
				try {
					new ModifyMenu();
				} catch (IOException ex) {
					ex.printStackTrace();
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

