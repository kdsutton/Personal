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
    private static final Color LIGHT_BROWN = new Color(238, 238, 210);
    private static final Color DARK_BROWN = new Color(102, 51, 0);
    private static final Color HIGHLIGHT = new Color(255, 251, 204, 63);
    private Rectangle[][] board = new Rectangle[8][8];
    private Rectangle[][] highlight = new Rectangle[8][8];
    private ChessPiece[][] pieces = new ChessPiece[8][8];
    private ChessPiece activePiece = null;
    
    public ChessBoard() {
        for(int y = 0; y < this.board.length; y++) {
            for(int x = 0; x < this.board[y].length; x++) {
                this.board[y][x] = new Rectangle(60 * x, 60 * y, 60, 60);
            }
        }
        for(int x = 0; x < this.pieces.length; x++) {
            Arrays.fill(this.highlight[x], null);
            Arrays.fill(this.pieces[x], null);
        }
        //New board pieces
        this.pieces[0][0] = new Rook(new Point(0, 0), false);
        this.pieces[0][1] = new Horse(new Point(60 * 1, 0), false);
        this.pieces[0][2] = new Bishop(new Point(60 * 2, 0), false);
        this.pieces[0][3] = new King(new Point(60 * 3, 0), false);
        this.pieces[0][4] = new Queen(new Point(60 * 4, 0), false);
        this.pieces[0][5] = new Bishop(new Point(60 * 5, 0), false);
        this.pieces[0][6] = new Horse(new Point(60 * 6, 0), false);
        this.pieces[0][7] = new Rook(new Point(60 * 7, 0), false);
        for(int x = 0; x < 8; x++) {
            this.pieces[1][x] = new Pawn(new Point(60 * x, 60 * 1), false);
        }
        this.pieces[7][0] = new Rook(new Point(0, 60 * 7), true);
        this.pieces[7][1] = new Horse(new Point(60 * 1, 60 * 7), true);
        this.pieces[7][2] = new Bishop(new Point(60 * 2, 60 * 7), true);
        this.pieces[7][3] = new King(new Point(60 * 3, 60 * 7), true);
        this.pieces[7][4] = new Queen(new Point(60 * 4, 60 * 7), true);
        this.pieces[7][5] = new Bishop(new Point(60 * 5, 60 * 7), true);
        this.pieces[7][6] = new Horse(new Point(60 * 6, 60 * 7), true);
        this.pieces[7][7] = new Rook(new Point(60 * 7, 60 * 7), true);
        for(int x = 0; x < 8; x++) {
            this.pieces[6][x] = new Pawn(new Point(60 * x, 60 * 6), true);
        }
        this.repaint();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(60 * 8, 60 * 8);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.DARK_BROWN);
        for(Rectangle[] row : this.board) {
            for(Rectangle rectangle : row) {
                g2.fill(rectangle);
                if(g2.getColor() == this.DARK_BROWN) {
                    g2.setColor(this.LIGHT_BROWN);
                } else {
                    g2.setColor(this.DARK_BROWN);
                }
            }
            if(g2.getColor() == this.DARK_BROWN) {
                g2.setColor(this.LIGHT_BROWN);
            } else {
                g2.setColor(this.DARK_BROWN);
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
    
    public ChessPiece findPiece(Point point) {
        return null;
    }
    
    public void setActivePiece(Point point) {
        this.activePiece = this.findPiece(point);
    }
    
    public void highlightMoves(Point point) {
        if(this.activePiece == null) {
            
        } else {
            
        }
    }
    
    public class MouseListener implements MouseMotionListener {
        public void mousePressed(MouseEvent event) {
            setActivePiece(event.getPoint());
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {
            highlightMoves(event.getPoint());
        }
        public void mouseExited(MouseEvent event) {}
        public void mouseDragged(MouseEvent event) {
            
        }
        public void mouseMoved(MouseEvent event) {}
    }
}