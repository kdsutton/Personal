package Chess;
import java.awt.Point;
import java.util.List;

/**
 * Write a description of class ChessPiece here.
 *
 * @author Kieran Sutton
 * @version 3/9/18
 */
public abstract class ChessPiece {
    private Point position;
    private boolean isWhite;
    
    public ChessPiece(Point startingPosition, boolean isNotBlack) {
        this.position = startingPosition;
        this.isWhite = isNotBlack;
    }
    
    public Point getPosition() {
        return this.position;
    }
    
    public boolean isPieceWhite() {
        return this.isWhite;
    }
    
    public void movePiece(Point point) {
        this.position.setLocation(point);
    }
    
    public List<Point> removeInvalidMoves(List<Point> moveList) {
        for(int x = 0; x < moveList.size(); x++) {
            Point move = moveList.get(x);
            if(move.equals(this.position) || move.getX() < 0 || move.getX() > 7 || move.getY() < 0 ||  move.getY() > 7) {
                moveList.remove(move);
                x--;
            }
        }
        return moveList;
    }
    
    public abstract List<Point> getMoves();
    public abstract String getPieceType();
}