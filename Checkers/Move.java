package Checkers;
import java.awt.Point;

/**
 * Write a description of class Move here.
 *
 * @author Kieran Sutton
 * @version 5/8/18
 */
public class Move {
    private Point move;
    private boolean isJump;
    
    public Move(Point moveInit, boolean isJumpInit) {
        this.move = moveInit;
        this.isJump = isJumpInit;
    }
    
    public Point getMove() {
        return this.move;
    }
    
    public boolean isJump() {
        return this.isJump;
    }
}