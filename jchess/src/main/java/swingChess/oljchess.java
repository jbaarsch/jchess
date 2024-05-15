package swingChess;

import javax.swing.*;

public class oljchess {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JChess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new GamePanel());
		frame.pack();
		frame.setVisible(true);
		
		

	}

}
