import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import javax.swing.JButton;


/**
 * Write a description of class Calc here.
 *
 * @author Kieran Sutton
 * @version 10/19/17
 */
public class Calc {
    Label output = new Label();
    
    public void main(String[] args) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.anchor = GridBagConstraints.CENTER;
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        panel.add(this.output, constraints);
        
    }
}
