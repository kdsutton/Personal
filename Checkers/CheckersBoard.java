package Checkers;
import java.util.Arrays;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

/**
 * Write a description of class CheckersBoard here.
 *
 * @author Kieran Sutton
 * @version 3/13/18
 */
public class CheckersBoard extends JPanel{
    private static final Color LIGHT_BROWN = new Color(238, 238, 210);
    private static final Color DARK_BROWN = new Color(102, 51, 0);
    private static final Color HIGHLIGHT = new Color(255, 251, 204, 191);
    private Rectangle[][] board = new Rectangle[8][8];
    private Rectangle[][] highlight = new Rectangle[8][8];
    private CheckersPiece[][] pieces = new CheckersPiece[8][8];
    private CheckersPiece activePiece = null;
    private int squareSize;
    
    public CheckersBoard() {
        this.addMouseListener(new MouseListener());
        this.addMouseMotionListener(new MouseListener());
        this.setSize(800, 800);
        this.updateSquareSize();
        if(this.getWidth() >= this.getHeight()) {
            this.squareSize = (int) (this.getHeight() / 8);
        } else {
            this.squareSize = (int) (this.getWidth() / 8);
        }
        for(int y = 0; y < this.board.length; y++) {
            for(int x = 0; x < this.board[y].length; x++) {
                this.board[y][x] = new Rectangle(this.squareSize * x, this.squareSize * y, this.squareSize, this.squareSize);
            }
        }
        for(int x = 0; x < this.pieces.length; x++) {
            Arrays.fill(this.highlight[x], null);
            Arrays.fill(this.pieces[x], null);
        }
        for(int x = 1; x < 8; x += 2) {
            this.pieces[0][x] = new CheckersPiece(new Point(x, 0), new Point(x * this.squareSize, 0), false, this.squareSize);
        }
        for(int x = 0; x < 8; x += 2) {
            this.pieces[1][x] = new CheckersPiece(new Point(x, 1), new Point(x * this.squareSize, 1 * this.squareSize), false, this.squareSize);
        }
        for(int x = 1; x < 8; x += 2) {
            this.pieces[6][x] = new CheckersPiece(new Point(x, 6), new Point(x * this.squareSize, 6 * this.squareSize), true, this.squareSize);
        }
        for(int x = 0; x < 8; x += 2) {
            this.pieces[7][x] = new CheckersPiece(new Point(x, 7), new Point(x * this.squareSize, 7 * this.squareSize), true, this.squareSize);
        }
        this.setVisible(true);
        this.repaint();
    }
    
    public void updateSquareSize() {
        if(this.getWidth() >= this.getHeight()) {
            this.squareSize = (int) (this.getHeight() / 8);
        } else {
            this.squareSize = (int) (this.getWidth() / 8);
        }
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
    
    public void paintComponent(Graphics g) {
        this.updateSquareSize();
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
        g2.setColor(this.HIGHLIGHT);
        for(Rectangle[] row : this.highlight) {
            for(Rectangle rectangle : row) {
                if(rectangle != null) {
                    g2.fill(rectangle);
                }
            }
        }
        for(CheckersPiece[] row : this.pieces) {
            for(CheckersPiece piece : row) {
                if(piece != null) {
                    piece.draw(g2, this.squareSize);
                }
            }
        }
    }
    
    public CheckersPiece findPiece(Point point) {
        int x = (int) point.getX() / this.squareSize;
        int y = (int) point.getY() / this.squareSize;
        return this.pieces[y][x];
    }
    
    public void setActivePiece(Point point) {
        this.activePiece = this.findPiece(point);
        this.highlightMoves(point);
    }
    
    public void removeActivePiece(Point point) {
        this.activePiece = null;
        this.highlightMoves(point);
    }
    
    public void highlightMoves(Point point) {
        CheckersPiece movingPiece;
        if(this.activePiece == null) {
            movingPiece = this.findPiece(point);
        } else {
            movingPiece = this.activePiece;
        }
        for(Rectangle[] row : this.highlight) {
            Arrays.fill(row, null);
        }
        if(movingPiece != null) {
            
        }
        this.repaint();
    }
    
    public List<Point> findMoves(CheckersPiece piece) {
        int x = (int) piece.getBoardPoint().getX();
        int y = (int) piece.getBoardPoint().getY();
        List<Point> moves = new ArrayList<Point>();
        if(y > 0 && (piece instanceof CheckersKing || piece.isRed())) {
            if(x > 0) {
                
            }
            if(x < 7) {
                
            }
        }
        if(y < 7 && (piece instanceof CheckersKing || piece.isRed() == false)) {
            if(x > 0) {
                
            }
            if(x < 7) {
                
            }
        }
        return moves;
    }
    
    public class MouseListener implements MouseInputListener {
        public void mousePressed(MouseEvent event) {
            setActivePiece(event.getPoint());
        }
        public void mouseReleased(MouseEvent event) {
            removeActivePiece(event.getPoint());
        }
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
        public void mouseDragged(MouseEvent event) {
            
        }
        public void mouseMoved(MouseEvent event) {
            
        }
    }
}