package Chess;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

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
}