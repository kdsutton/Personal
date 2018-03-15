package Chess;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class Horse here.
 *
 * @author Kieran Sutton
 * @version 3/12/18
 */
public class Horse extends ChessPiece {
    public Horse(Point startingPosition, boolean isNotBlack) {
        super(startingPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        int x = (int) super.getPosition().getX();
        int y = (int) super.getPosition().getY();
        moveList.add(new Point(x - 1, y - 2));
        moveList.add(new Point(x + 1, y - 2));
        moveList.add(new Point(x + 2, y - 1));
        moveList.add(new Point(x + 2, y + 1));
        moveList.add(new Point(x + 1, y + 2));
        moveList.add(new Point(x - 1, y + 2));
        moveList.add(new Point(x - 2, y + 1));
        moveList.add(new Point(x - 2, y - 1));
        return super.removeInvalidMoves(moveList);
    }
    
    public String getPieceType() {
        if(super.isPieceWhite()) {
            return "White Horse";
        } else {
            return "Black Horse";
        }
    }
    
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage img = null;
        try {
            if(super.isPieceWhite()) {
                img = ImageIO.read(new File("Icons\\White Horse.png"));
            } else {
                img = ImageIO.read(new File("Icons\\Black Horse.png"));
            }
        } catch(IOException e) {}
        int x = (int) super.getPosition().getX();
        int y = (int) super.getPosition().getY();
        g2.drawImage(img, 100 * x, 100 * y, this);
    }
}