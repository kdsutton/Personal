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
    public Pawn(Point startingPosition, Point boardPosition, boolean isNotBlack) {
        super(startingPosition, boardPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        int boardPointX = (int) super.getBoardPoint().getX();
        int boardPointY = (int) super.getBoardPoint().getY();
        if(super.isPieceWhite()) {
            moveList.add(new Point(boardPointX, boardPointY - 1));
            if(boardPointY == 6) {
                moveList.add(new Point(boardPointX, boardPointY - 2));
            }
        } else {
            moveList.add(new Point(boardPointX, boardPointY + 1));
            if(boardPointY == 1) {
                moveList.add(new Point(boardPointX, boardPointY + 2));
            }
        }
        return moveList;
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