package Checkers;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Write a description of class PieceTest here.
 *
 * @author Kieran Sutton
 * @version 4/25/18
 */
public class PieceTest extends JPanel {
    CheckersKing king;
    
    public PieceTest() {
        this.king = new CheckersKing(new Point(), new Point(), false, this.getSquareSize());
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
    
    public double getSquareSize() {
        if(this.getWidth() > this.getHeight()) {
            return this.getHeight();
        } else {
            return this.getWidth();
        }
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        this.king.draw(g2);
    }
    
    public static void main(String[] args) {
        PieceTest tester =  new PieceTest();
    }
}