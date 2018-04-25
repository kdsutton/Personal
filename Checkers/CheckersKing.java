package Checkers;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Polygon;

/**
 * Write a description of class CheckersKing here.
 *
 * @author Kieran Sutton
 * @version 4/20/18
 */
public class CheckersKing extends CheckersPiece {
    private static final Color DARK_RED = new Color(128, 0, 0);
    private static final Color GREY = new Color(128, 128, 128);
    private static final double[] STAR_X = {10, 16, 0.5, 4, 0.5};
    private static final double[] STAR_Y = {0, 18, 7, 7, 18};
    private double scale;
    
    public CheckersKing(Point startingPoint, Point startingLocation, boolean isBlack, double squareSize) {
        super(startingPoint, startingLocation, isBlack, squareSize);
        this.scale = squareSize / 21;
    }
    
    public void draw(Graphics2D g2) {
        super.draw(g2);
        int[] xArray = new int[5];
        for(int i = 0; i < 5; i++) {
            xArray[i] = (int) (this.scale * (this.location.getX() + this.STAR_X[i]));
        }
        int[] yArray = new int[5];
        for(int i = 0; i < 5; i++) {
            yArray[i] = (int) (this.scale * (this.location.getY() + this.STAR_Y[i]));
        }
        g2.setColor(this.GREY);
        if(this.isRed) {
            g2.setColor(this.DARK_RED);
        }
        g2.fill(new Polygon(xArray, yArray, 5));
    }
}