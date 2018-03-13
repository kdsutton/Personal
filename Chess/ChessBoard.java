package Chess;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

/**
 * Write a description of class ChessBoard here.
 *
 * @author Kieran Sutton
 * @version 3/13/18
 */
public class ChessBoard extends JPanel{
    private Rectangle[][] board = new Rectangle[8][8];
    private ChessPiece[][] pieces = new ChessPiece[8][8];
    
    public ChessBoard() {
        for(int y = 0; y < this.board.length; y++) {
            for(int x = 0; x < this.board[x].length; x++) {
                this.board[y][x] = new Rectangle(80 * x, 80 * y, 80, 80);
            }
        }
    }
    public class MouseListener implements MouseMotionListener {
        public void mousePressed(MouseEvent event) {
            
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {
            
        }
        public void mouseExited(MouseEvent event) {}
        public void mouseDragged(MouseEvent event) {
            
        }
        public void mouseMoved(MouseEvent event) {}
    }
}