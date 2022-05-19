import javax.swing.*;

public class Main extends JFrame {

    public static final int WINDOW_SIZE = 500;

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        GameBoard gameBoard = new GameBoard();
        this.add(gameBoard);
        this.setResizable(true);
        this.setSize(WINDOW_SIZE, WINDOW_SIZE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
