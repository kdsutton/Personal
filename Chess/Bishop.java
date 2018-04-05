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
 * Write a description of class Bishop here.
 *
 * @author Kieran Sutton
 * @version 3/13/18
 */
public class Bishop extends ChessPiece {
    public Bishop(Point startingPosition, Point boardPosition, boolean isNotBlack) {
        super(startingPosition, boardPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        int x = (int) super.getBoardPoint().getX() - 1;
        int y = (int) super.getBoardPoint().getY() - 1;
        while(x >= 0 && y >= 0) {
            moveList.add(new Point(x, y));
            x--; y--;
        }
        x = (int) super.getBoardPoint().getX() + 1;
        y = (int) super.getBoardPoint().getY() - 1;
        while(x < 8 && y >= 0) {
            moveList.add(new Point(x, y));
            x++; y--;
        }
        x = (int) super.getBoardPoint().getX() + 1;
        y = (int) super.getBoardPoint().getY() + 1;
        while(x < 8 && y < 8) {
            moveList.add(new Point(x, y));
            x++; y++;
        }
        x = (int) super.getBoardPoint().getX() - 1;
        y = (int) super.getBoardPoint().getY() + 1;
        while(x >= 0 && y < 8) {
            moveList.add(new Point(x, y));
            x--; y++;
        }
        return moveList;
    }
    
    public String getPieceType() {
        if(super.isPieceWhite()) {
            return "White Bishop";
        } else {
            return "Black Bishop";
        }
    }
    
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage img = null;
        try {
            if(super.isPieceWhite()) {
                img = ImageIO.read(new File("C:\\Users\\kdsutton\\GitHub\\Personal\\Chess\\Icons\\White Bishop.png"));
            } else {
                img = ImageIO.read(new File("C:\\Users\\kdsutton\\GitHub\\Personal\\Chess\\Icons\\Black Bishop.png"));
            }
        } catch(IOException e) {}
        int x = (int) super.getPosition().getX();
        int y = (int) super.getPosition().getY();
        g2.drawImage(img, x, y, this);
    }
}