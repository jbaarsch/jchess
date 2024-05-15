package swingChess;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
	
	BoardPanel board;
	JPanel hudPanel;
	StatusPanel statusPanel;
	MovePanel movePanel;
	
	public GamePanel() {
		board = new BoardPanel();
		this.add(board);

		hudPanel = new JPanel();
		hudPanel.setPreferredSize(new Dimension(220, 640));

		statusPanel = new StatusPanel();
		statusPanel.setPreferredSize(new Dimension(200, 300));

		movePanel = new MovePanel();
		movePanel.setPreferredSize(new Dimension(200, 300));

		hudPanel.add(statusPanel);
		hudPanel.add(movePanel);

		this.add(hudPanel);

		
//		ImageIcon icon = new ImageIcon("src/oljchess/images/pawn_dark.png");
//		JLabel piece = new JLabel(icon);
//		this.add(piece);
		
		
		
	}
	
	
	
	
	
	

}
