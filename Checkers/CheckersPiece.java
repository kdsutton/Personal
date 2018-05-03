package Checkers;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

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
    
    public CheckersPiece(Point startingPoint, Point startingLocation, boolean isNotBlack, double squareSize) {
        this.boardPoint = startingPoint;
        this.location = startingLocation;
        this.isRed = isNotBlack;
        this.updateSize(squareSize);
    }
    
    public boolean isRed() {
        return this.isRed;
    }
    
    public Point getBoardPoint() {
        return this.boardPoint;
    }
    
    public void setBoardPoint(Point point) {
        this.boardPoint = point;
    }
    
    public void setLocation(Point point) {
        this.location = point;
    }
    
    public void updateSize(double squareSize) {
        this.radius = squareSize / 2.1;
        this.offset = (squareSize - 2 * (squareSize / 2.1))/2;
    }
    
    public void draw(Graphics2D g2, double squareSize) {
        this.updateSize(squareSize);
        g2.setColor(Color.BLACK);
        if(this.isRed){
            g2.setColor(Color.RED);
        }
        g2.fill(new Ellipse2D.Double(this.offset + this.location.getX(), this.offset + this.location.getY(), 2 * this.radius, 2 * this.radius));
    }
}