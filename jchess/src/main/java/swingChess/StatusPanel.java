package swingChess;
import java.awt.*;
import javax.swing.*;

public class StatusPanel extends JPanel{

    public StatusPanel() {
        this.setBackground(Color.BLUE);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString("White's Turn!", 10, 10);


    }

}
