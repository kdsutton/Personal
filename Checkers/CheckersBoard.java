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
    private static final Color HIGHLIGHT = new Color(255, 255, 0, 192);
    private Rectangle[][] highlight = new Rectangle[8][8];
    private CheckersPiece[][] pieces = new CheckersPiece[8][8];
    private CheckersPiece activePiece = null;
    private int squareSize;
    private double xOffset;
    private double yOffset;
    private boolean redTurn = true;
    private boolean jumpContinue = false;
    
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
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                g2.fill(new Rectangle(x * this.squareSize, y * this.squareSize, this.squareSize, this.squareSize));
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
        if(x < 8 && y < 8) {
            return this.pieces[y][x];
        }
        return null;
    }
    
    public void setActivePiece(Point point) {
        if(!this.jumpContinue) {
            this.activePiece = this.findPiece(point);
            if(this.activePiece != null) {
                Point location = this.activePiece.getLocation();
                this.xOffset = location.getX() - point.getX();
                this.yOffset = location.getY() - point.getY();
            }
        }
    }
    
    public void moveActivePiece(Point point) {
        if(this.activePiece != null) {
            this.activePiece.setLocation(new Point((int) (point.getX() + this.xOffset), (int) (point.getY() + this.yOffset)));
        }
        this.repaint();
    }
    
    public void updateActivePiece(Point point) {
        if(this.activePiece != null) {
            this.updateSquareSize();
            Point boardPoint = new Point((int) (point.getX() / this.squareSize), (int) (point.getY() / this.squareSize));
            Move validMove = null;
            for(Move move : this.findMoves(this.activePiece)) {
                if(boardPoint.equals(move.getMove())) {
                    validMove = move;
                    break;
                }
            }
            if(validMove != null) {
                Point resetPoint = this.activePiece.getBoardPoint();
                this.pieces[(int) boardPoint.getY()][(int) boardPoint.getX()] = this.activePiece;
                this.pieces[(int) resetPoint.getY()][(int) resetPoint.getX()] = null;
                this.activePiece.setBoardPoint(validMove.getMove());
                this.activePiece.setLocation(new Point((int) (validMove.getMove().getX() * this.squareSize), (int) (validMove.getMove().getY() * this.squareSize)));
                if(validMove.isJump()) {
                    Point jumped = this.findJumped(resetPoint, validMove.getMove());
                    this.pieces[(int) jumped.getY()][(int) jumped.getX()] = null;
                    this.jumpContinue = true;
                    boolean moreJumps = false;
                    for(Move move : this.findMoves(this.activePiece)) {
                        if(move.isJump()) {
                            moreJumps = true;
                            break;
                        }
                    }
                    if(moreJumps) {
                        this.jumpContinue = true;
                    }
                } else {
                    this.jumpContinue = false;
                }
                if(!this.jumpContinue) {
                    this.redTurn = !this.redTurn;
                }
                if((this.activePiece.isRed() && boardPoint.getY() == 0) || (!this.activePiece.isRed() && boardPoint.getY() == 7)) {
                    this.pieces[(int) boardPoint.getY()][(int) boardPoint.getX()] = new CheckersKing(this.activePiece, this.squareSize);
                }
            } else {
                Point resetPoint = this.activePiece.getBoardPoint();
                this.activePiece.setLocation(new Point((int) (resetPoint.getX() * this.squareSize), (int) (resetPoint.getY() * this.squareSize)));
            }
            if(!this.jumpContinue) {
                this.activePiece = null;
            }
        }
        this.highlightMoves(point);
    }
    
    public Point findJumped(Point from, Point to) {
        if(from.distance(to) > 2) {
            int jumpedX = (int) (from.getX() - (from.getX() - to.getX()) / 2);
            int jumpedY = (int) (from.getY() - (from.getY() - to.getY()) / 2);
            return new Point(jumpedX, jumpedY);
        }
        return null;
    }
    
    public void highlightMoves(Point point) {
        this.updateSquareSize();
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
            List<Move> moves = this.findMoves(movingPiece);
            for(Move move : moves) {
                int x = (int) move.getMove().getX();
                int y = (int) move.getMove().getY();
                this.highlight[y][x] = new Rectangle((int) this.squareSize * x, (int) this.squareSize * y, squareSize, squareSize);
            }
        }
        this.repaint();
    }
    
    public List<Move> findMoves(CheckersPiece piece) {
        int x = (int) piece.getBoardPoint().getX();
        int y = (int) piece.getBoardPoint().getY();
        List<Move> moves = new ArrayList<Move>();
        if(!this.jumpContinue || piece.equals(this.activePiece)) {
            if(this.redTurn && piece.isRed()) {
                if(x > 0 && y > 0 && this.pieces[y - 1][x - 1] == null) {
                    moves.add(new Move(new Point(x - 1, y - 1), false));
                } else if(x > 1 && y > 1 && this.pieces[y - 1][x - 1] != null && this.pieces[y - 2][x - 2] == null && this.pieces[y - 1][x - 1].isRed() == false) {
                    moves.add(new Move(new Point(x - 2, y - 2), true));
                }
                if(x < 7 && y > 0 && this.pieces[y - 1][x + 1] == null) {
                    moves.add(new Move(new Point(x + 1, y - 1), false));
                } else if(x < 6 && y > 1 && this.pieces[y - 1][x + 1] != null && this.pieces[y - 2][x + 2] == null && this.pieces[y - 1][x + 1].isRed() == false) {
                    moves.add(new Move(new Point(x + 2, y - 2), true));
                }
                if(piece instanceof CheckersKing) {
                    if(x > 0 && y < 7 && this.pieces[y + 1][x - 1] == null) {
                        moves.add(new Move(new Point(x - 1, y + 1), false));
                    } else if(x > 1 && y < 6 && this.pieces[y + 1][x - 1] != null && this.pieces[y + 2][x - 2] == null && this.pieces[y + 1][x - 1].isRed() == false) {
                        moves.add(new Move(new Point(x - 2, y + 2), true));
                    }
                    if(x < 7 && y < 7 && this.pieces[y + 1][x + 1] == null) {
                        moves.add(new Move(new Point(x + 1, y + 1), false));
                    } else if(x < 6 && y < 6 && this.pieces[y + 1][x + 1] != null && this.pieces[y + 2][x + 2] == null && this.pieces[y + 1][x + 1].isRed() == false) {
                        moves.add(new Move(new Point(x + 2, y + 2), true));
                    }
                }
            } else if(this.redTurn == false && piece.isRed() == false) {
                if(x > 0 && y < 7 && this.pieces[y + 1][x - 1] == null) {
                    moves.add(new Move(new Point(x - 1, y + 1), false));
                } else if(x > 1 && y < 6 && this.pieces[y + 1][x - 1] != null && this.pieces[y + 2][x - 2] == null && this.pieces[y + 1][x - 1].isRed()) {
                    moves.add(new Move(new Point(x - 2, y + 2), true));
                }
                if(x < 7 && y < 7 && this.pieces[y + 1][x + 1] == null) {
                    moves.add(new Move(new Point(x + 1, y + 1), false));
                } else if(x < 6 && y < 6 && this.pieces[y + 1][x + 1] != null && this.pieces[y + 2][x + 2] == null && this.pieces[y + 1][x + 1].isRed()) {
                    moves.add(new Move(new Point(x + 2, y + 2), true));
                }
                if(piece instanceof CheckersKing) {
                    if(x > 0 && y > 0 && this.pieces[y - 1][x - 1] == null) {
                        moves.add(new Move(new Point(x - 1, y - 1), false));
                    } else if(x > 1 && y > 1 && this.pieces[y - 1][x - 1] != null && this.pieces[y - 2][x - 2] == null && this.pieces[y - 1][x - 1].isRed()) {
                        moves.add(new Move(new Point(x - 2, y - 2), true));
                    }
                    if(x < 7 && y > 0 && this.pieces[y - 1][x + 1] == null) {
                        moves.add(new Move(new Point(x + 1, y - 1), false));
                    } else if(x < 6 && y > 1 && this.pieces[y - 1][x + 1] != null && this.pieces[y - 2][x + 2] == null && this.pieces[y - 1][x + 1].isRed()) {
                        moves.add(new Move(new Point(x + 2, y - 2), true));
                    }
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
            updateActivePiece(event.getPoint());
        }
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
        public void mouseDragged(MouseEvent event) {
            moveActivePiece(event.getPoint());
        }
        public void mouseMoved(MouseEvent event) {
            highlightMoves(event.getPoint());
        }
    }
}