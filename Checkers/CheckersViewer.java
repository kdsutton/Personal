package Checkers;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Point;

/**
 * Write a description of class CheckersViewer here.
 *
 * @author Kieran Sutton
 * @version 5/2/18
 */
public class CheckersViewer extends JFrame {
    public CheckersViewer() {
        this.setTitle("Checkers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new CheckersBoard());
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        CheckersViewer viewer = new CheckersViewer();
    }
}