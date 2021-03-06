import javax.swing.*;
import java.awt.*;

public class Square extends JButton {
    private final Color color;
    private Player player;

    public Square (Color color, Player player) {
        this.color = color;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer (Player player) {
        this.player = player;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(0, 0,
                 this.getWidth(), this.getHeight());
        switch (this.player) {
            case none:
                //do nothing
                break;
            case red:
                g.setColor(Color.RED);
                g.fillOval(5, 5, this.getWidth() - 10, this.getHeight() - 10);
                break;
            case blue:
                g.setColor(Color.BLUE);
                g.fillOval(5, 5, this.getWidth() - 10, this.getHeight() - 10);
                break;

        }
    }
}
