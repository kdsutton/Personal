package Chess;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Bishop here.
 *
 * @author Kieran Sutton
 * @version 3/13/18
 */
public class Bishop extends ChessPiece {
    public Bishop(Point startingPosition, boolean isNotBlack) {
        super(startingPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        int x = (int) super.getPosition().getX() - 1;
        int y = (int) super.getPosition().getY() - 1;
        while(x >= 0 && y >= 0) {
            moveList.add(new Point(x, y));
            x--; y--;
        }
        x = (int) super.getPosition().getX() + 1;
        y = (int) super.getPosition().getY() - 1;
        while(x < 8 && y >= 0) {
            moveList.add(new Point(x, y));
            x++; y--;
        }
        x = (int) super.getPosition().getX() + 1;
        y = (int) super.getPosition().getY() + 1;
        while(x < 8 && y < 8) {
            moveList.add(new Point(x, y));
            x++; y++;
        }
        x = (int) super.getPosition().getX() - 1;
        y = (int) super.getPosition().getY() + 1;
        while(x >= 0 && y < 8) {
            moveList.add(new Point(x, y));
            x--; y++;
        }
        return super.removeInvalidMoves(moveList);
    }
    
    public String getPieceType() {
        if(super.isPieceWhite()) {
            return "White Bishop";
        } else {
            return "Black Bishop";
        }
    }
}