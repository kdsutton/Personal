package Checkers;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Point;

/**
 * Write a description of class PieceTest here.
 *
 * @author Kieran Sutton
 * @version 4/25/18
 */
public class PieceTestViewer extends JFrame {
    public PieceTestViewer() {
        this.setTitle("Piece Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new PieceTest());
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        PieceTestViewer tester =  new PieceTestViewer();
    }
}