import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GameBoard extends JPanel {

    public static final int BOARD_LENGTH = 3;

    private final ArrayList<ArrayList<Square>> boardData;

    private int o = 1;

    public GameBoard () {
        A a = new A();
        this.setBackground(Color.BLUE);
        GridLayout gridLayout = new GridLayout(BOARD_LENGTH, BOARD_LENGTH);
        this.setLayout(gridLayout);
        this.boardData = new ArrayList<>();
        for (int row = 0; row < BOARD_LENGTH; row++) {
            ArrayList<Square> currentRow = new ArrayList<>();
            for (int column = 0; column < BOARD_LENGTH; column++) {
                Player player = Player.none;
                Square square = new Square(
                        Color.WHITE,
                        player);
                final int[] g = {0};
                square.addActionListener((event) -> {
                    if(square.getPlayer() == Player.none) {
                        if(a.i == 0){
                            square.setPlayer(Player.blue);
                            a.plus();
                        }else {
                            square.setPlayer(Player.red);
                            a.minus();
                        }
                        if(checkWinDiagonal() || checkWinRows() || checkWinColumns()){

                        }
                        repaint();
                    }
                });
                this.add(square);
                currentRow.add(square);
            }
            this.boardData.add(currentRow);
        }
    }
    public Player sl(){
        if(o == 1){
            return Player.blue;
        }else {
            return Player.red;
        }
    }
    public boolean checkWinDiagonal() {
        if (!boardData.isEmpty()) {
            if (boardData.get(1).get(1).getPlayer() == Player.none) return false;
            if ((boardData.get(0).get(0).getPlayer() == boardData.get(1).get(1).getPlayer()) && (boardData.get(1).get(1).getPlayer() == boardData.get(2).get(2).getPlayer()))
                return true;
            return (boardData.get(0).get(2).getPlayer() == boardData.get(1).get(1).getPlayer()) && (boardData.get(1).get(1).getPlayer() == boardData.get(2).get(0).getPlayer());
        }
        return false;
    }

      public boolean checkWinRows() {
          int c = 0;
          Player player = Player.blue;
          for (int i = 0; i < 3; i++) {
              if (c == BOARD_LENGTH && player != Player.none) return true;
              c = 0;
              player = boardData.get(i).get(0).getPlayer();
              for (int j = 0; j < BOARD_LENGTH; j++) {
                  if (boardData.get(i).get(j).getPlayer() == player) c++;
              }
          }
          return c == BOARD_LENGTH && player != Player.none;
      }

     public boolean checkWinColumns(){
         int c = 0;
         Player player = Player.blue;
         for (int i = 0; i < 3; i++) {
             if (c == 3 && player != Player.none ) return true;
             c = 0;
             player = boardData.get(0).get(i).getPlayer();
             for (int j = 0; j < 3; j++) {
                 if(boardData.get(j).get(i).getPlayer() == player) c++;
             }
         }
         return c == 3 && player != Player.none;
     }

}