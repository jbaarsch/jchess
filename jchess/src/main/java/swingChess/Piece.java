package swingChess;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Piece {
	
	boolean isLight;
	Role role;
	
	public Piece(Role role, boolean isLight) {
		this.role = role;
		this.isLight = isLight;
	}
	
	public Role getRole() {
		return role;
	}
	
	public Icon getIcon() {
		String imgName = getIconString();
		System.out.println(imgName);
		ImageIcon img = new ImageIcon(imgName);
		Image image = img.getImage();
		Image newImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}
	
	public int[][] getMoves() {
		int[][] moves = role.getMoves();
		return moves;
	}
	
	private String getIconString() {
		String result = "images/";
		result += role.toString();
		result += (isLight)?"_light":"_dark";
		result += ".png";
		
		return result;
	}
	
	

}
