package Chess;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Rook here.
 *
 * @author Kieran Sutton
 * @version 3/9/18
 */
public class Rook extends ChessPiece {
    public Rook(Point startingPosition, boolean isNotBlack) {
        super(startingPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        Point temp = new Point(super.getPosition());
        for(int x = (int) temp.getX(); x >= 0; x--) {
            moveList.add(new Point(x, (int) temp.getY()));
        }
        for(int x = (int) temp.getX(); x < 8; x++) {
            moveList.add(new Point(x, (int) temp.getY()));
        }
        for(int y = (int) temp.getY(); y >= 0; y--) {
            moveList.add(new Point((int) temp.getX(), y));
        }
        for(int y = (int) temp.getY(); y < 8; y++) {
            moveList.add(new Point((int) temp.getX(), y));
        }
        return super.removeInvalidMoves(moveList);
    }
    
    public String getPieceType() {
        if(super.isPieceWhite()) {
            return "White Rook";
        } else {
            return "Black Rook";
        }
    }
}