import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Reverse Polish Notation Calculator
 *
 * @author Kieran Sutton
 * @version 10/19/17
 */
public class NormCalc implements ActionListener{
    JFrame frame = new JFrame("NormCalc");
    Label output = new Label();
    int currentIndex = 0;
    String input = "";
    
    public NormCalc() {
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.anchor = GridBagConstraints.CENTER;
        
        this.output.setBackground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        frame.add(this.output, constraints);
        
        JButton buttonPlus = new JButton("+");
        buttonPlus.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonPlus.addActionListener(this);
        buttonPlus.setActionCommand(" + ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonPlus, constraints);
        
        JButton buttonMinus = new JButton("-");
        buttonMinus.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonMinus.addActionListener(this);
        buttonMinus.setActionCommand(" - ");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonMinus, constraints);
        
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonMultiply.addActionListener(this);
        buttonMultiply.setActionCommand(" * ");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonMultiply, constraints);
        
        JButton buttonDivide = new JButton("/");
        buttonDivide.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonDivide.addActionListener(this);
        buttonDivide.setActionCommand(" / ");
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonDivide, constraints);
        
        JButton buttonEnter = new JButton("=");
        buttonEnter.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonEnter.addActionListener(this);
        buttonEnter.setActionCommand("=");
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.ipady = 30;
        frame.add(buttonEnter, constraints);
        constraints.ipady = 0;
        
        JButton buttonClear = new JButton("C");
        buttonClear.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonClear.addActionListener(this);
        buttonClear.setActionCommand("C");
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonClear, constraints);
        
        JButton buttonBackspace = new JButton("←");
        buttonBackspace.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonBackspace.addActionListener(this);
        buttonBackspace.setActionCommand("Back");
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonBackspace, constraints);
        
        JButton buttonNegative = new JButton("-");
        buttonNegative.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonNegative.addActionListener(this);
        buttonNegative.setActionCommand("-");
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonNegative, constraints);
        
        JButton buttonDecimal = new JButton(".");
        buttonDecimal.setHorizontalTextPosition(AbstractButton.CENTER);
        buttonDecimal.addActionListener(this);
        buttonDecimal.setActionCommand(".");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(buttonDecimal, constraints);
        
        JButton button0 = new JButton("0");
        button0.setHorizontalTextPosition(AbstractButton.CENTER);
        button0.addActionListener(this);
        button0.setActionCommand("0");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button0, constraints);
        
        JButton button1 = new JButton("1");
        button1.setHorizontalTextPosition(AbstractButton.CENTER);
        button1.addActionListener(this);
        button1.setActionCommand("1");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button1, constraints);
        
        JButton button2 = new JButton("2");
        button2.setHorizontalTextPosition(AbstractButton.CENTER);
        button2.addActionListener(this);
        button2.setActionCommand("2");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button2, constraints);
        
        JButton button3 = new JButton("3");
        button3.setHorizontalTextPosition(AbstractButton.CENTER);
        button3.addActionListener(this);
        button3.setActionCommand("3");
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button3, constraints);
        
        JButton button4 = new JButton("4");
        button4.setHorizontalTextPosition(AbstractButton.CENTER);
        button4.addActionListener(this);
        button4.setActionCommand("4");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button4, constraints);
        
        JButton button5 = new JButton("5");
        button5.setHorizontalTextPosition(AbstractButton.CENTER);
        button5.addActionListener(this);
        button5.setActionCommand("5");
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button5, constraints);
        
        JButton button6 = new JButton("6");
        button6.setHorizontalTextPosition(AbstractButton.CENTER);
        button6.addActionListener(this);
        button6.setActionCommand("6");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button6, constraints);
        
        JButton button7 = new JButton("7");
        button7.setHorizontalTextPosition(AbstractButton.CENTER);
        button7.addActionListener(this);
        button7.setActionCommand("7");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button7, constraints);
        
        JButton button8 = new JButton("8");
        button8.setHorizontalTextPosition(AbstractButton.CENTER);
        button8.addActionListener(this);
        button8.setActionCommand("8");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add(button8, constraints);
        
        JButton button9 = new JButton("9");
        button9.setHorizontalTextPosition(AbstractButton.CENTER);
        button9.addActionListener(this);
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
            case "=": this.calcEquals(); break;
            case "C": this.calcClear(); break;
            case "Back": this.calcBack(); break;
            default: this.calcCommand(command); break;
        }
        this.calcUpdate();
    }
    
    public void calcEquals() {
        List<String> operations = new ArrayList<String>(Arrays.asList(input.split("\\s")));
        
        while(true) {
            int index = -1;
            int indexMultiply = operations.indexOf("*");
            int indexDivide = operations.indexOf("/");
            boolean isMultiply = false;
            
            if(indexMultiply != -1 && (indexDivide == -1 || indexMultiply < indexDivide)) {
                index = indexMultiply;
                isMultiply = true;
            } else if (indexDivide != -1 && (indexMultiply == -1 || indexDivide < indexMultiply)) {
                index = indexDivide;
            } else {
                break;
            }
            
            
            double operand1 = Double.parseDouble(operations.get(index - 1));
            double operand2 = Double.parseDouble(operations.get(index + 1));
            if(isMultiply) {
                operations.set(index, Double.toString(operand1 * operand2));
            } else {
                operations.set(index, Double.toString(operand1 / operand2));
            }
            operations.remove(index + 1);
            operations.remove(index - 1);
        }
        
        while(true) {
            int index = -1;
            int indexPlus = operations.indexOf("+");
            int indexMinus = operations.indexOf("-");
            boolean isPlus = false;
            
            if(indexPlus != -1 && (indexMinus == -1 || indexPlus < indexMinus)) {
                index = indexPlus;
                isPlus = true;
            } else if (indexMinus != -1 && (indexPlus == -1 || indexMinus < indexPlus)) {
                index = indexMinus;
            } else {
                break;
            }
            
            double operand1 = Double.parseDouble(operations.get(index - 1));
            double operand2 = Double.parseDouble(operations.get(index + 1));
            if(isPlus) {
                operations.set(index, Double.toString(operand1 + operand2));
            } else {
                operations.set(index, Double.toString(operand1 - operand2));
            }
            operations.remove(index + 1);
            operations.remove(index - 1);
        }
        
        this.input = operations.get(0);
    }
    
    public void calcClear() {
        this.input = "";
    }
    
    public void calcBack() {
        if (this.input.length() > 0) {
            if(this.input.charAt(this.input.length() - 1) == ' ') {
                this.input = this.input.substring(0, this.input.length() - 3);
            } else {
                this.input = this.input.substring(0, this.input.length() - 1);
            }
        } else {
            this.input = "";
        }
    }
    
    public void calcCommand(String command) {
        this.input += command;
    }
    
    public void calcUpdate() {
        this.output.setText(this.input);
    }
}