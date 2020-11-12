import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title        : MrMiyazaki.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class MrMiyazaki extends JFrame implements ActionListener {
    /**
     * Constructor without parameters.
     */
    public MrMiyazaki() {
        // Set the frame.
        super("Mr. Miyazaki");
        this.setLayout(null);
        this.setSize(1024, 768);
        this.setLocation(200, 33);

        // Set the panel.
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setSize(1000, 716);
        p.setLocation(12, 12);
        p.setBorder(BorderFactory.createTitledBorder("Welcome to self-ordering kiosk software! -- Mr. Miyazaki"));

        /*
         * Add the panel to the frame.
         */
        this.add(p);

        /*
         * Set the closing operation.
         * Set the frame to non-resizeable.
         * Set the frame to visible.
         */
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
    }
}
