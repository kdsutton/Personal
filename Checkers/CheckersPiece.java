package Checkers;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

/**
 * Write a description of class CheckersPiece here.
 *
 * @author Kieran Sutton
 * @version 4/20/18
 */
public class CheckersPiece extends JComponent{
    Point boardPoint;
    Point location;
    boolean isRed;
    double radius;
    double offset;
    
    public CheckersPiece(Point startingPoint, Point startingLocation, boolean isBlack, double squareSize) {
        this.boardPoint = startingPoint;
        this.location = startingLocation;
        this.isRed = !isBlack;
        this.radius = squareSize / 2.1;
        this.offset = (squareSize - 2 * (squareSize / 2.1))/2;
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        if(this.isRed){
            g2.setColor(Color.RED);
        }
        g2.fill(new Ellipse2D.Double(this.offset + this.location.getX(), this.offset + this.location.getY(), 2 * this.radius, 2 * this.radius));
    }
}