import java.util.Random;

/**
 * Write a description of class GameOfLife here.
 *
 * @author Kieran Sutton
 * @version 11/13/17
 */
public class GameOfLife {
    boolean[][] board;
    
    public GameOfLife() {
        this.board = new boolean[10][10];
        Random gen = new Random();
        for(int y = 0; y < this.board.length; y++) {
            for(int x = 0; x < this.board[y].length; x++) {
                if(gen.nextInt(6) == 0) {
                    this.board[y][x] = true;
                }
            }
        }
    }

    public GameOfLife(boolean[][] initalState) {
        this.board = initalState;
    }

    public void update() {
        boolean[][] newBoard = new boolean[this.board.length][this.board[0].length];
        for(int y = 0; y < this.board.length; y++)  {
            for(int x = 0; x < this.board[y].length; x++) {
                boolean testUp = true;
                if(y == 0) {
                    testUp = false;
                }
                boolean testDown = true;
                if(y == this.board.length - 1) {
                    testDown = false;
                }
                boolean testLeft = true;
                if(x == 0) {
                    testLeft = false;
                }
                boolean testRight = true;
                if(x == this.board[y].length - 1) {
                    testRight = false;
                }
                
                int aliveCells = 0;
                if(testUp && testLeft && this.board[y - 1][x - 1]) {
                    aliveCells++;
                }
                if(testUp && this.board[y - 1][x]) {
                    aliveCells++;
                }
                if(testUp && testRight && this.board[y - 1][x + 1]) {
                    aliveCells++;
                }
                if(testLeft && this.board[y][x - 1]) {
                    aliveCells++;
                }
                if(testRight && this.board[y][x + 1]) {
                    aliveCells++;
                }
                if(testDown && testLeft && this.board[y + 1][x - 1]) {
                    aliveCells++;
                }
                if(testDown && this.board[y + 1][x]) {
                    aliveCells++;
                }
                if(testDown && testRight && this.board[y + 1][x + 1]) {
                    aliveCells++;
                }
                
                if(this.board[y][x] && (aliveCells >= 2 && aliveCells <=3)) {
                    newBoard[y][x] = true;
                } else if(this.board[y][x] == false && aliveCells == 3) {
                    newBoard[y][x] = true;
                }
            }
        }
        this.board = newBoard;
    }
    
    public String toString() {
        String output = "";
        for(int y = 0; y < this.board.length; y++) {
            for(int x = 0; x < this.board[y].length; x++) {
                if(this.board[y][x]) {
                    output += "1 ";
                } else {
                    output += "0 ";
                }
            }
            output += "\n";
        }
        return output;
    }
    
    public static void main(int cycles) throws InterruptedException {
        GameOfLife gameoflife = new GameOfLife();
        System.out.println(gameoflife);
        for(int i = 0; i < cycles; i++) {
            gameoflife.update();
            System.out.println(gameoflife);
            Thread.sleep(1000);
        }
    }
}