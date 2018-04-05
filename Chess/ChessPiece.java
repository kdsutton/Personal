package Chess;
import javax.swing.JComponent;
import java.awt.Point;
import java.util.List;
import java.awt.Graphics;

/**
 * Write a description of class ChessPiece here.
 *
 * @author Kieran Sutton
 * @version 3/9/18
 */
public abstract class ChessPiece extends JComponent{
    private Point position;
    private Point boardPoint;
    private boolean isWhite;
    
    public ChessPiece(Point startingPosition, Point boardPosition, boolean isNotBlack) {
        this.position = startingPosition;
        this.boardPoint = boardPosition;
        this.isWhite = isNotBlack;
    }
    
    public Point getPosition() {
        return this.position;
    }
    
    public Point getBoardPoint() {
        return this.boardPoint;
    }
    
    public boolean isPieceWhite() {
        return this.isWhite;
    }
    
    public void movePiece(Point point) {
        this.position.setLocation(point);
    }
    
    public void setBoardPoint(Point point) {
        this.boardPoint = point;
    }
    
    public abstract List<Point> getMoves();
    public abstract String getPieceType();
    public abstract void draw(Graphics g);
}