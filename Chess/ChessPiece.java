package Chess;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Write a description of class ChessPiece here.
 *
 * @author Kieran Sutton
 * @version 3/9/18
 */
public interface ChessPiece {
    public List<Point2D> getMoves();
    public void movePiece(Point2D point);
    public String getPieceType();
}