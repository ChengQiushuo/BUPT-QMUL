package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: DishAddChoose.java 
 * packageName: Boundary
 * date:2020.4 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
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

/**
 * ClassName: DishAddChoose<br>
 * Description: This is the GUI interface of choosing the dish <br>
 * that wants to add has ranking options(three options) or just simple option(one option)
 * @version V3.0
 * @author Du Yuang
 */
public class DishAddChoose extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	* This constructor used to set up the GUI interface
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
		lblNewLabel.setFont(new Font("TimesRoman", Font.BOLD, 40));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton RankingOptionButton = new JButton("Ranking Options");
		RankingOptionButton.setFont(new Font(null, Font.BOLD, 20));
		GridBagConstraints gbc_RankingOptionButton = new GridBagConstraints();
		gbc_RankingOptionButton.fill = GridBagConstraints.BOTH;
		gbc_RankingOptionButton.insets = new Insets(0, 0, 5, 5);
		gbc_RankingOptionButton.gridx = 2;
		gbc_RankingOptionButton.gridy = 2;
		RankingOptionButton.addActionListener(this);
		RankingOptionButton.setActionCommand("rank");
		contentPane.add(RankingOptionButton, gbc_RankingOptionButton);
		
		JButton SimpleOptionButton = new JButton("Simple Options");
		SimpleOptionButton.setFont(new Font(null, Font.BOLD, 20));
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
	
	
	/**
	* Used to react to the event happened on the interface elements
	* @param e the event happened on the interface elements
	*/
	public void actionPerformed(ActionEvent e) {
		String opt = e.getActionCommand();
		switch (opt) {
			case "rank":
				this.dispose();
				new AddDishes();//go to adding dishes with ranking(three) options
				break;
			case "simple":
				new SimpleOption();//go to adding dishes with simple(one) option
				this.dispose();
                break;
			case "back":
				this.dispose();
				try {
					new ModifyMenu();//back to previous interface
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

