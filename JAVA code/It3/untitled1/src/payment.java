

import javax.swing.*;

public class payment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("payment");
        frame.setContentPane(new payment().panel0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel0;
    private JButton stampsButton;
    private JButton cashButton;
    private JButton cardButton;
    private JButton cancelButton;
}
