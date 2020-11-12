package boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title        : SignUpYes.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class SignUpYes extends JFrame implements ActionListener {
    /**
     * Constructor without parameters.
     */
    public SignUpYes() {
    }

    /**
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            default:
                System.out.println("---ERROR - SignUp---");
        }
    }
}
