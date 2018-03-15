package Chess;
import javax.swing.JFrame;

/**
 * Write a description of class ChessGame here.
 *
 * @author Kieran Sutton
 * @version 3/14/18
 */
public class ChessGame extends JFrame {
    public ChessGame() {
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(new ChessBoard());
        
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
    }
}