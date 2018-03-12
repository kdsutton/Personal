package Chess;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

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
}