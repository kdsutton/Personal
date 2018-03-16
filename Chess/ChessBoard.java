package Chess;
import java.util.Arrays;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
            for(int x = 0; x < this.board[y].length; x++) {
                this.board[y][x] = new Rectangle(new Point(80 * x, 80 * y), this.getPreferredSize());
            }
        }
        for(int x = 0; x < this.pieces.length; x++) {
            Arrays.fill(this.pieces[x], null);
        }
        //New board pieces
        this.pieces[0][0] = new Rook(new Point(0, 0), false);
        this.pieces[0][1] = new Horse(new Point(1, 0), false);
        this.pieces[0][2] = new Bishop(new Point(2, 0), false);
        this.pieces[0][3] = new King(new Point(3, 0), false);
        this.pieces[0][4] = new Queen(new Point(4, 0), false);
        this.pieces[0][5] = new Bishop(new Point(5, 0), false);
        this.pieces[0][6] = new Horse(new Point(6, 0), false);
        this.pieces[0][7] = new Rook(new Point(7, 0), false);
        for(int x = 0; x < 8; x++) {
            this.pieces[1][x] = new Pawn(new Point(x, 1), false);
        }
        this.pieces[7][0] = new Rook(new Point(0, 7), true);
        this.pieces[7][1] = new Horse(new Point(1, 7), true);
        this.pieces[7][2] = new Bishop(new Point(2, 7), true);
        this.pieces[7][3] = new King(new Point(3, 7), true);
        this.pieces[7][4] = new Queen(new Point(4, 7), true);
        this.pieces[7][5] = new Bishop(new Point(5, 7), true);
        this.pieces[7][6] = new Horse(new Point(6, 7), true);
        this.pieces[7][7] = new Rook(new Point(7, 7), true);
        for(int x = 0; x < 8; x++) {
            this.pieces[6][x] = new Pawn(new Point(x, 6), true);
        }
        this.repaint();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        for(Rectangle[] row : this.board) {
            for(Rectangle rectangle : row) {
                g2.fill(rectangle);
                if(g2.getColor() == Color.BLACK) {
                    g2.setColor(Color.WHITE);
                } else {
                    g2.setColor(Color.BLACK);
                }
            }
            if(g2.getColor() == Color.BLACK) {
                g2.setColor(Color.WHITE);
            } else {
                g2.setColor(Color.BLACK);
            }
        }
        for(ChessPiece[] row : this.pieces) {
            for(ChessPiece piece : row) {
                if(piece != null) {
                    piece.draw(g2);
                }
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