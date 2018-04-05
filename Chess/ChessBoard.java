package Chess;
import java.util.Arrays;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.event.MouseInputListener;
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
    private static final Color HIGHLIGHT = new Color(255, 251, 204, 191);
    private Rectangle[][] board = new Rectangle[8][8];
    private Rectangle[][] highlight = new Rectangle[8][8];
    private ChessPiece[][] pieces = new ChessPiece[8][8];
    private ChessPiece activePiece = null;
    
    public ChessBoard() {
        this.addMouseListener(new MouseListener());
        this.addMouseMotionListener(new MouseListener());
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
        this.pieces[0][0] = new Rook(new Point(0, 0), new Point(0, 0), false);
        this.pieces[0][1] = new Horse(new Point(60 * 1, 0), new Point(1, 0), false);
        this.pieces[0][2] = new Bishop(new Point(60 * 2, 0), new Point(2, 0), false);
        this.pieces[0][3] = new King(new Point(60 * 3, 0), new Point(3, 0), false);
        this.pieces[0][4] = new Queen(new Point(60 * 4, 0), new Point(4, 0), false);
        this.pieces[0][5] = new Bishop(new Point(60 * 5, 0), new Point(5, 0), false);
        this.pieces[0][6] = new Horse(new Point(60 * 6, 0), new Point(6, 0), false);
        this.pieces[0][7] = new Rook(new Point(60 * 7, 0), new Point(7, 0), false);
        for(int x = 0; x < 8; x++) {
            this.pieces[1][x] = new Pawn(new Point(60 * x, 60 * 1), new Point(x, 1), false);
        }
        this.pieces[7][0] = new Rook(new Point(0, 60 * 7), new Point(0, 7), true);
        this.pieces[7][1] = new Horse(new Point(60 * 1, 60 * 7), new Point(1, 7), true);
        this.pieces[7][2] = new Bishop(new Point(60 * 2, 60 * 7), new Point(2, 7), true);
        this.pieces[7][3] = new King(new Point(60 * 3, 60 * 7), new Point(3, 7), true);
        this.pieces[7][4] = new Queen(new Point(60 * 4, 60 * 7), new Point(4, 7), true);
        this.pieces[7][5] = new Bishop(new Point(60 * 5, 60 * 7), new Point(5, 7), true);
        this.pieces[7][6] = new Horse(new Point(60 * 6, 60 * 7), new Point(6, 7), true);
        this.pieces[7][7] = new Rook(new Point(60 * 7, 60 * 7), new Point(7, 7), true);
        for(int x = 0; x < 8; x++) {
            this.pieces[6][x] = new Pawn(new Point(60 * x, 60 * 6), new Point(x, 6), true);
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
        g2.setColor(this.HIGHLIGHT);
        for(Rectangle[] row : this.highlight) {
            for(Rectangle rectangle : row) {
                if(rectangle != null) {
                    g2.fill(rectangle);
                }
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
        int x = (int) point.getX() / 60;
        int y = (int) point.getY() / 60;
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
        ChessPiece movingPiece;
        if(this.activePiece == null) {
            movingPiece = this.findPiece(point);
        } else {
            movingPiece = this.activePiece;
        }
        for(Rectangle[] row : this.highlight) {
            Arrays.fill(row, null);
        }
        if(movingPiece != null) {
            List<Point> moves = this.removeInvalidMoves(movingPiece, movingPiece.getMoves());
            for(Point move : moves) {
                int x = (int) move.getX();
                int y = (int) move.getY();
                this.highlight[y][x] = new Rectangle(60 * x, 60 * y, 60, 60);
            }
        }
        this.repaint();
    }
    
    public List<Point> removeInvalidMoves(ChessPiece piece, List<Point> moves) {
        for(int x = 0; x < moves.size(); x++) {
            Point boardPoint = piece.getBoardPoint();
            switch(piece.getPieceType()) {
                case "White Pawn":
                break;
                case "Black Pawn":
                break;
                case "White Rook": moves = this.removeInvalidStraight(piece, moves);
                break;
                case "Black Rook": moves = this.removeInvalidStraight(piece, moves);
                break;
                case "White Horse":
                break;
                case "Black Horse":
                break;
                case "White Bishop":
                break;
                case "Black Bishop":
                break;
                case "White Queen": moves = this.removeInvalidStraight(piece, moves);
                break;
                case "Black Queen": moves = this.removeInvalidStraight(piece, moves);
                break;
                case "White King":
                break;
                case "Black King":
                break;
            }
        }
        return moves;
    }
    
    public List<Point> removeInvalidStraight(ChessPiece piece, List<Point> moves) {
        boolean isBlocked = false;
        int pointX = (int) piece.getBoardPoint().getX();
        int pointY = (int) piece.getBoardPoint().getY();
        for(int x = pointX; x < 8; x++) {
            Point move = new Point(x, pointY);
            if(isBlocked) {
                moves.remove(move);
            } else if(this.pieces[pointY][x] != null) {
                isBlocked = true;
                if(this.pieces[pointY][x].isPieceWhite() == piece.isPieceWhite()) {
                    moves.remove(move);
                }
            }
        }
        for(int x = pointX; x >= 0; x--) {
            Point move = new Point(x, pointY);
            if(isBlocked) {
                moves.remove(move);
            } else if(this.pieces[pointY][x] != null) {
                isBlocked = true;
                if(this.pieces[pointY][x].isPieceWhite() == piece.isPieceWhite()) {
                    moves.remove(move);
                }
            }
        }
        for(int y = pointY; y < 8; y++) {
            Point move = new Point(pointX, y);
            if(isBlocked) {
                moves.remove(move);
            } else if(this.pieces[y][pointX] != null) {
                isBlocked = true;
                if(this.pieces[y][pointX].isPieceWhite() == piece.isPieceWhite()) {
                    moves.remove(move);
                }
            }
        }
        for(int y = pointY; y >= 0; y--) {
            Point move = new Point(pointX, y);
            if(isBlocked) {
                moves.remove(move);
            } else if(this.pieces[y][pointX] != null) {
                isBlocked = true;
                if(this.pieces[y][pointX].isPieceWhite() == piece.isPieceWhite()) {
                    moves.remove(move);
                }
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
        public void mouseMoved(MouseEvent event) {}
    }
}