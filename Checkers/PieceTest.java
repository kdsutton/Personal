package Checkers;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * Write a description of class PieceTest here.
 *
 * @author Kieran Sutton
 * @version 4/25/18
 */
public class PieceTest extends JPanel {
    private CheckersKing king;
    
    public PieceTest() {
        this.setSize(500, 500);
        this.king = new CheckersKing(new Point(0, 0), new Point(0, 0), true, this.getSquareSize());
        this.setVisible(true);
        this.repaint();
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
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle2D.Double(0, 0, this.getSquareSize(), this.getSquareSize()));
        this.king.draw(g2, this.getSquareSize());
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
    
    public static void main(String[] args) {
        PieceTest tester =  new PieceTest();
    }
}