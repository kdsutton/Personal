package Chess;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Pawn here.
 *
 * @author Kieran Sutton
 * @version 3/9/18
 */
public class Pawn implements ChessPiece {
    private Point2D position;
    
    public Pawn(Point2D startingPosition) {
        this.position = startingPosition;
    }
    
    public List<Point2D> getMoves() {
        List<Point2D> moveList = new ArrayList<Point2D>();
        return moveList;
    }
    
    public void movePiece(Point2D point) {
        this.position = point;
    }
    
    public String getPieceType() {
        return "Pawn";
    }
}