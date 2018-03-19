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
 * Write a description of class Pawn here.
 *
 * @author Kieran Sutton
 * @version 3/9/18
 */
public class Pawn extends ChessPiece {
    public Pawn(Point startingPosition, boolean isNotBlack) {
        super(startingPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        if(super.isPieceWhite()) {
            moveList.add(new Point((int) super.getPosition().getX() - 1, (int) super.getPosition().getY()));
            if(super.getPosition().getY() == 5) {
                moveList.add(new Point((int) super.getPosition().getX() - 2, (int) super.getPosition().getY()));
            }
        } else {
            moveList.add(new Point((int) super.getPosition().getX() + 1, (int) super.getPosition().getY()));
            if(super.getPosition().getY() == 1) {
                moveList.add(new Point((int) super.getPosition().getX() + 2, (int) super.getPosition().getY()));
            }
        }
        return super.removeInvalidMoves(moveList);
    }
    
    public String getPieceType() {
        if(super.isPieceWhite()) {
            return "White Pawn";
        } else {
            return "Black Pawn";
        }
    }
    
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage img = null;
        try {
            if(super.isPieceWhite()) {
                img = ImageIO.read(new File("C:\\Users\\kdsutton\\GitHub\\Personal\\Chess\\Icons\\White Pawn.png"));
            } else {
                img = ImageIO.read(new File("C:\\Users\\kdsutton\\GitHub\\Personal\\Chess\\Icons\\Black Pawn.png"));
            }
        } catch(IOException e) {}
        int x = (int) super.getPosition().getX();
        int y = (int) super.getPosition().getY();
        g2.drawImage(img, x, y, this);
    }
}