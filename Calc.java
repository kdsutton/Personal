import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import java.awt.event.ActionEvent;

/**
 * Write a description of class Calc here.
 *
 * @author Kieran Sutton
 * @version 10/19/17
 */
public class Calc {
    JFrame frame = new JFrame("RPNCalc");
    Label output = new Label();
    
    public void main() {
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.anchor = GridBagConstraints.CENTER;
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        frame.add(this.output, constraints);
        
        JButton buttonPlus = new JButton("+");
        buttonPlus.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonPlus.setActionCommand("+");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonPlus, constraints);
        
        JButton buttonMinus = new JButton("-");
        buttonMinus.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonMinus.setActionCommand("-");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonMinus, constraints);
        
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonMultiply.setActionCommand("*");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonMultiply, constraints);
        
        JButton buttonDivide = new JButton("/");
        buttonDivide.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonDivide.setActionCommand("/");
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonDivide, constraints);
        
        JButton buttonEnter = new JButton("↵");
        buttonEnter.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonEnter.setActionCommand("↵");
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.ipady = 30;
        frame.add(buttonEnter, constraints);
        constraints.ipady = 0;
        
        JButton buttonClear = new JButton("C");
        buttonClear.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonClear.setActionCommand("C");
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonClear, constraints);
        
        JButton buttonBackspace = new JButton("←");
        buttonBackspace.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonBackspace.setActionCommand("←");
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonBackspace, constraints);
        
        JButton buttonNegative = new JButton("-");
        buttonNegative.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonNegative.setActionCommand("Neg");
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonNegative, constraints);
        
        JButton buttonDecimal = new JButton(".");
        buttonDecimal.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonDecimal.setActionCommand(".");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonDecimal, constraints);
        
        JButton button0 = new JButton("0");
        button0.setHorizontalTextPosition(AbstractButton.CENTER);
        button0.setActionCommand("0");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button0, constraints);
        
        JButton button1 = new JButton("1");
        button1.setHorizontalTextPosition(AbstractButton.CENTER);
        button1.setActionCommand("1");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button1, constraints);
        
        JButton button2 = new JButton("2");
        button2.setHorizontalTextPosition(AbstractButton.CENTER);
        button2.setActionCommand("2");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button2, constraints);
        
        JButton button3 = new JButton("3");
        button3.setHorizontalTextPosition(AbstractButton.CENTER);
        button3.setActionCommand("3");
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button3, constraints);
        
        JButton button4 = new JButton("4");
        button4.setHorizontalTextPosition(AbstractButton.CENTER);
        button4.setActionCommand("4");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button4, constraints);
        
        JButton button5 = new JButton("5");
        button5.setHorizontalTextPosition(AbstractButton.CENTER);
        button5.setActionCommand("5");
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button5, constraints);
        
        JButton button6 = new JButton("6");
        button6.setHorizontalTextPosition(AbstractButton.CENTER);
        button6.setActionCommand("6");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button6, constraints);
        
        JButton button7 = new JButton("7");
        button7.setHorizontalTextPosition(AbstractButton.CENTER);
        button7.setActionCommand("7");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button7, constraints);
        
        JButton button8 = new JButton("8");
        button8.setHorizontalTextPosition(AbstractButton.CENTER);
        button8.setActionCommand("8");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button8, constraints);
        
        JButton button9 = new JButton("9");
        button9.setHorizontalTextPosition(AbstractButton.CENTER);
        button9.setActionCommand("9");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button9, constraints);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch(command) {
            case "+": this.calcCommand("+"); break;
            case "-": this.calcCommand("-"); break;
            case "*": this.calcCommand("*"); break;
            case "/": this.calcCommand("/"); break;
            case "Enter": this.calcEnter(); break;
            case "C": this.calcClear(); break;
            case "←": this.calcBack(); break;
            case "Neg": this.calcNeg(); break;
            default: this.calcLabel(command); break;
        }
    }
}