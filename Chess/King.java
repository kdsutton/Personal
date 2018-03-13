package Chess;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class King here.
 *
 * @author Kieran Sutton
 * @version 3/13/18
 */
public class King extends ChessPiece {
    public King(Point startingPosition, boolean isNotBlack) {
        super(startingPosition, isNotBlack);
    }
    
    public List<Point> getMoves() {
        List<Point> moveList = new ArrayList<Point>();
        for(int x = (int) super.getPosition().getX() - 1; x <= (int) super.getPosition().getX() + 1; x++) {
            for(int y = (int) super.getPosition().getY() - 1; y <= (int) super.getPosition().getY() + 1; y++) {
                moveList.add(new Point(x, y));
            }
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